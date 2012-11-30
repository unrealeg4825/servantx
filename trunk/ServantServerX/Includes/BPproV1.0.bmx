

'=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-Constants=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-
'------These are the values that JoinSession will Return
Const BP_NOREPLY = 0			'No reply from host within 15 seconds
Const BP_IAMBANNED = 1			'Local player's IP has been banned
Const BP_GAMEISFULL = 2		'The game has maxed out players
Const BP_PORTNOTAVAILABLE = 3	'The Local port wasn't available
Const BP_SUCCESS = 4			'The game was joined!
Const BP_USERABORT = 5			'The user pushed ESC While joining
Const BP_INVALIDHOSTIP = 6		'The IP used For the Host was invalid
'------These are all the messages BP can generate For the End user:
Const BP_PLAYERHASJOINED = 255	'msgData = New player name|msgFrom = player's id
Const BP_PLAYERHASLEFT = 254	'msgData = T/F on If intentionally|msgFrom = player's id
Const BP_HOSTHASLEFT = 253		'msgData = T/F on If intentionally|msgFrom = old host's id
Const BP_PLAYERWASKICKED = 252	'msgData = Null|msgFrom = kicked player's id
'=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Globals=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
'---------------The following shouldn't be modified externally------------------
'**Although these ones might be useful To you**
Global BP_GameType			    'Type of game: (0-255)
Global BP_TotRecvPacket		'Packets received
Global BP_TotSentPacket		'Packets sent
Global BP_Host				    'T/F, am I the Host?
Global BP_Host_ID				'Host's ID #
Global BP_Host_IP				'Host's IP (in integer format)
Global BP_Host_Port			'Host's Port
Global BP_MaxPlayers = 255 	'Maximum # of players
Global BP_My_Name$				'Local player's Name
Global BP_My_ID				'Local player's ID #
Global BP_My_Port				'Local port being used by BlitzPlay
Global BP_NumPlayers			'How many players are connected To the game Right now
Global BP_LocalHost = BP_ConvertIP ("127:0:0:1")'integer Local loopback address
Global BP_Online = False		'T/F
Global BP_My_IP				'This computers IP: Set To Local If no IP
Global BP_LogFile$ = ""			'Define If you want logging enabled:
Global BP_TimeoutPeriod=15000	'How Long before we assuming connection dropped(in ms)
Global BP_Log:TStream					'Log file handle, 0 If logging disabled
Global BP_AutoLogging			'True Or False on If BP should internally do the logging
Global BP_UDPdebug			    'Odds (in ) that packets do Not get sent (For testing)
'**These ones probably Not as useful::

Global BP_UDP_Stream:TUDPStream			'UDP Stream handle
Global BP_CompressBank = CreateBank(4)'Bank used For converting Floats To Strings
'=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Types=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Global NetInfo_list:TList = New TList
Global MsgInfo_list:TList = New TList
Global DiscID_list:TList = New TList
Global Connecting_list:TList = New TList
Global UnrecMsgQueue_list:TList = New TList
Global BannedPlayers_list:TList = New TList
Global Spline_list:TList = New TList

Type NetInfo
	Method New()
	
		ListAddLast(NetInfo_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(NetInfo_list,Self)
	
	End Method
					'--The general player info:
	Field Name$				'Player's Name
	Field Net_id			'Players unique ID #
	Field IP				'Ip::
	Field Port				'Port (really!)
	Field LastHeard		'When the last packet was received from them:
	Field Alive			'Boolean on If we think this player is still there
End Type

Type MsgInfo

	Method New()
	
		ListAddLast(MsgInfo_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(MsgInfo_list,Self)
	
	End Method
					'--Messages that have arrived are stored here
	Field msgData$			'actual packet contents
	Field msgType			'Msg Type(0-255)
	Field msgFrom			'ID of msg sender
End Type

Type DiscID

	Method New()
	
		ListAddLast(DiscID_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(DiscID_list,Self)
	
	End Method
						'--Keeps track of disconnects' ID's
	Field id				'ID of disconnect
End Type

Type Connecting

	Method New()
	
		ListAddLast(Connecting_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(Connecting_list,Self)
	
	End Method
					'--For players trying To connect
	Field Name$				'Connect name
	Field net_id			'New player's ID
	Field IP				'IP +
	Field Port				'Port
	Field LastHeard		'When the last packet was received from them:
	Field Alive			'Boolean on If we think this New connect is still trying
End Type

Type UnrecMsgQueue

	Method New()
	
		ListAddLast(UnrecMsgQueue_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(UnrecMsgQueue_list,Self)
	
	End Method
				'--Messages from unrecognized IP+Port
	Field msgData$			'Hm: Self explanatory:
	Field msgType
	Field IP				'Check against this IP To see If this player has joined yet
	Field Port
	Field Time				'These will be stored For up To 1 second Then disregarded
	Field net_id
End Type

Type BannedPlayers

	Method New()
	
		ListAddLast(BannedPlayers_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(BannedPlayers_list,Self)
	
	End Method
				'--List of IP's not to let in
	Field IP				'IP in 32bit Int form
End Type

'Splines
Type Spline

	Method New()
	
		ListAddLast(Spline_list,Self)
	
	End Method
	
	Method LDelete()
	
		ListRemove(Spline_list,Self)
	
	End Method

	Field x#[3]
	Field z#[3]
End Type


'=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=Functions=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=
Function BP_BanIP (ip)
'-=-=-=Make it impossible For an IP To join
	Local alreadybanned = False
	For banned:BannedPlayers = EachIn BannedPlayers_list
		If banned.IP = ip Then alreadybanned = True
	Next
	If Not alreadybanned Then
		banned:BannedPlayers = New BannedPlayers
		banned.IP = ip
	End If
End Function

Function BP_ClearSession()
'-=-=-=Clears out any data that could be leftover from previous sessions:
	ClearList(NetInfo_list)
	ClearList(UnrecMsgQueue_list)
	ClearList(Connecting_list)
	ClearList(BannedPlayers_list)
	ClearList(MsgInfo_list)
	ClearList(DiscID_list)
	BP_TotSentPacket = 0
	BP_TotRecvPacket = 0
	BP_StopLogFile()
End Function

Function BP_ConvertIp (IP$)
'-=-=-=Convert an IP from x:x:x:x To integer format:
	Local dot1 = Int(Instr(IP$,":"))
	Local dot2 = Int(Instr(IP$,":",dot1+1))
	Local dot3 = Int(Instr(IP$,":",dot2+1))
	Local Octet1 = Int(Mid$(IP$,1,dot1-1))
	Local Octet2 = Int(Mid$(IP$,dot1+1,dot2-1))
	Local Octet3 = Int(Mid$(IP$,dot2+1,dot3-1))
	Local Octet4 = Int(Mid$(IP$,dot3+1))
	Return (((((Octet1 Shl 8) Or Octet2) Shl 8) Or Octet3) Shl 8) Or Octet4
End Function

Function BP_ConvertDomain (domain$)
'-=-=-=Converts from www:domain:com To integer IP address:
	Return HostIp(domain$,0)
End Function

Function BP_EndSession ()
'-=-=-=Disconnect from everything
	Local counter
	Local stime
	If BP_Online
		If BP_Host Then
			BP_UDPMessage (0,251,Chr$(BP_My_ID))
		Else
			BP_UDPMessage(BP_Host_ID,253,Chr$(BP_My_ID))
		End If
		BP_Online = False
	End If
	If BP_UDP_Stream Then
		BP_UDP_Stream.Close()
		'CloseUDPStream BP_UDP_Stream
		BP_UDP_Stream = Null
	End If
	BP_ClearSession()
	BP_StopLogFile()
End Function

Function BP_FindConnect:Connecting (IP, Port)
'-=-=-=Go through the Connecting Type list And search by IP+Port
	If IP = BP_My_IP Or IP = BP_LocalHost Then
		For c:Connecting = EachIn Connecting_list
			If (c.Port = Port) And ((c.IP = BP_My_IP) Or (c.IP = BP_LocalHost)) Then Return c
		Next
	Else
		For c:Connecting = EachIn Connecting_list
			If (c.Port = Port) And (c.IP = IP) Then Return c
		Next
	End If
End Function

Function BP_FindID:NetInfo(ID)
'-=-=-=Go through the NetInfo Type list And find a specific instance, based on the ID
	For nInfo:NetInfo = EachIn NetInfo_list
		If nInfo.net_id = ID Then Return nInfo
	Next
End Function

Function BP_FindIP:NetInfo(IP, Port)
'-=-=-=Find a NetInfo based on IP+Port Or just Port If in debug
	If IP = BP_My_IP Or IP = BP_LocalHost Then
		For nInfo:NetInfo = EachIn NetInfo_list
			If (nInfo.Port = Port) And ((nInfo.IP = BP_My_IP) Or (nInfo.IP = BP_LocalHost)) Then Return nInfo
		Next
	Else
		For nInfo:NetInfo = EachIn NetInfo_list
			If (nInfo.Port = Port) And (nInfo.IP = IP) Then Return nInfo
		Next
	End If
End Function

Function BP_FloatToStr$(num#)
'-=-=-=Convert a floating point number To a 4 Byte String
	Local st$ = "",i
	PokeFloat BP_CompressBank,0,num
	For i = 0 To 3 
		st$ = st$ + Chr$(PeekByte(BP_CompressBank,i))
	Next 
	Return st$ 
End Function

Function BP_GetGameType()
'-=-=-=Returns the currently set game Type
    Return BP_GameType
End Function

Function BP_GetHostID()
'-=-=-=Returns the Host ID
    Return BP_Host_ID
End Function

Function BP_GetHostIP()
'-=-=-=Returns the Host IP address
    Return BP_Host_IP
End Function

Function BP_GetHostPort()
'-=-=-=Returns the Host Port
    Return BP_Host_Port
End Function

Function BP_GetLogFileName$()
'-=-=-=Returns the currently set Log File name
    Return BP_LogFile$
End Function

Function BP_GetMaxPlayers()
'-=-=-=Returns the currently set Max Players value
    Return BP_MaxPlayers
End Function

Function BP_GetMyID()
'-=-=-=Returns this users ID
    Return BP_My_ID
End Function

Function BP_GetMyIP$()
'-=-=-=Returns this users IP address
	Local ip
	If HostIps("") Then ip = HostIp("") Else ip = BP_LocalHost
	Return DottedIP$(ip)
End Function

Function BP_GetMyName$()
'-=-=-=Returns this users name
	Return BP_My_Name$
End Function

Function BP_GetMyPort()
'-=-=-=Returns this users Port
	Return BP_My_Port
End Function

Function BP_GetNumberOfPlayers()
'-=-=-=Returns the Current number of players
	Return BP_NumPlayers
End Function

Function BP_GetPacketsReceived()
'-=-=-=Returns the number of packets that have been received
	Return BP_TotRecvPacket
End Function

Function BP_GetPacketsSent()
'-=-=-=Returns the number of packets that have been sent
	Return BP_TotSentPacket
End Function

Function BP_GetPlayerName$(ID)
'-=-=-=Find a player's name based on the ID
    'nInfo:NetInfo = NetInfo
	For nInfo:NetInfo = EachIn NetInfo_list
		If nInfo.net_id = ID Then Return nInfo.Name$
	Next
End Function

Function BP_GetTimeoutPeriod()
'-=-=-=Returns the Current Timeout Period
    Return BP_TimeoutPeriod / 1000
End Function

Function BP_HostSession(BP_HostName$,MaxPlayers,GameType,LocalPort,TimeoutPeriod)
'-=-=-=Host the game
'First clear out any Left over data from a previous session
	BP_ClearSession()
'Now initialize the Host information And open the specified port:
	BP_NumPlayers = 1
	BP_MaxPlayers = MaxPlayers
	BP_Host = True
	BP_My_IP = BP_ConvertIP(BP_GetMyIP())
	BP_My_Port = LocalPort
	BP_Host_Port = BP_My_Port
	BP_Host_ID = 1
	BP_Host_IP = BP_My_IP
	nInfo:NetInfo = New NetInfo
	nInfo.IP = BP_My_IP
	nInfo.Port = BP_My_Port
	nInfo.Name = BP_HostName$
	BP_My_Name = BP_HostName$
	BP_My_ID = 1
	nInfo.net_id = 1
	'BP_UDP_Socket = CreateUDPSocket()
	'ConnectSocket( socket:TSocket,remoteIp,remotePort )
	'BindSocket( BP_UDP_Socket,BP_Host_Port )
	'SocketListen( BP_UDP_Socket,0 )
	BP_UDP_Stream = New TUDPStream
	BP_UDP_Stream.Init()
	BP_UDP_Stream.SetLocalPort(BP_Host_Port)
'And set up the game information
	BP_GameType = GameType
	BP_TimeoutPeriod = TimeoutPeriod * 1000	'TimeoutPeriod is converted To milliseconds
	If BP_UDP_Stream Then BP_Online = True Else BP_Online = False
	Return BP_Online
End Function

Function BP_IntToStr$(Num, StrLen = 4)
'-=-=-=Take an Integer And compress it To a String, of "strlen" bytes Long:
	Local shiftin
	Local st$ = Chr$(num And 255)
	For shiftin = 1 To (strlen - 1)
		st$ = st$ + Chr$(num Sar (8 * shiftin))
	Next
	Return st
End Function 

Function BP_JoinSession (ClientName$,LocalPort,strHostIP$,HostPort)
'-=-=-=Join a game already in progress
'JoinSession will Return:	0=No reply from BP_Host	1=This IP is banned
'							2=Game is full			3=Local port Not available
'							4=Joined game!
'Also notice the constants which coincide w/ these values:
'		BP_NOREPLY, BP_IAMBANNED, BP_GAMEISFULL, BP_PORTNOTAVAILABLE, BP_SUCCESS
	Local starttime
	Local reason
	Local counter
	Local curTime
	Local msg:MsgInfo
'Clear out any Left over data from a previous session And initialize this session
	BP_ClearSession()

	'Directly convert the Host's IP into an integer, to test to see if the IP entered is simply a number (w/ no periods)
	intHostIP = Int(strHostIP)
	If intHostIP Then	'First, error check For valid IP's
		If Not(Instr(strHostIP, ":")) Then
			BP_UpdateLog ("Connection attempt aborted: Host IP is invalid:")
			Return BP_INVALIDHOSTIP
		End If
	End If

	'Now, convert the IP/Domain To an integer
	intHostIP = BP_ConvertDomain(strHostIP)
	BP_UpdateLog ("New connection attempt for " + ClientName + " on Port " + LocalPort + ": Server: " + DottedIP$(intHostIP) + ":" + HostPort)

	'Error check again
	If Not(intHostIP) Then
		BP_UpdateLog ("Connection attempt aborted: Host IP is invalid:")
		Return BP_INVALIDHOSTIP
	End If

	BP_Host = False
	BP_My_IP = BP_ConvertIP(BP_GetMyIP())
	BP_My_Port = LocalPort
	BP_Host_IP = intHostIP
	BP_Host_Port = HostPort

'Start connecting with BP_Host
	'BP_UDP_Socket = CreateUDPSocket()
	'BindSocket( BP_UDP_Socket,BP_My_Port )
	'isconnected = ConnectSocket( BP_UDP_Socket,BP_Host_IP,BP_Host_Port )
	'SocketListen( BP_UDP_Socket,0 )
	BP_UDP_Stream = New TUDPStream
	BP_UDP_Stream.Init()
	BP_UDP_Stream.SetLocalPort(BP_My_Port)
	
	If BP_UDP_Stream Then
		BP_UDPSend (Chr$(254) + Chr$(0) + Chr$(1) + ClientName, BP_Host_IP, BP_Host_Port)
		BP_NumPlayers = 255

		starttime = MilliSecs()

		reason = 0
		BP_Online = True

'Receive info on game session as well as other player information
		Repeat
			BP_UpdateNetwork ()
			If (MilliSecs() - starttime) > 15000 Then
				BP_Online = False
				Exit
			End If
			For msg:MsgInfo = EachIn MsgInfo_list
				If msg.msgType = 256 Then
					reason = Int(msg.msgData)
					BP_Online = False
					Exit
				End If
			Next
			counter = 0
			For nInfo:NetInfo = EachIn NetInfo_list
				counter = counter + 1
			Next
			If counter = BP_NumPlayers Then
				reason = 4
				BP_Online = True
				Exit
			End If
			If KeyHit(1) Then
				reason = BP_USERABORT
				BP_Online = False
			End If
		Until reason

		If BP_Online Then
			nInfo:NetInfo = New NetInfo
			nInfo.Name = ClientName
			nInfo.net_id = BP_My_ID
			nInfo.IP = BP_My_IP
			nInfo.Port = BP_My_Port
			nInfo.Alive = True

            BP_My_Name$ = ClientName
			BP_UDPSend (Chr$(254) + Chr$(0) + Chr$(2), BP_Host_IP, BP_Host_Port)
			BP_NumPlayers = BP_NumPlayers + 1
			For nInfo:NetInfo = EachIn NetInfo_list
				If nInfo.net_id = BP_Host_ID Then
					nInfo.IP = BP_Host_IP
					nInfo.Port = BP_Host_Port
				End If
			Next
		Else
			If BP_UDPStream Then BP_UDP_Stream.Close() 
			BP_UDP_Stream = Null
		End If
	Else
		BP_Online = False
		reason = BP_PORTNOTAVAILABLE
	End If
	Return reason
End Function

Function BP_KickID (id, ban = False)
	Local msg:MsgInfo
'-=-=-=Kick an ID, maybe even ban 'em
	If BP_My_ID = BP_Host_ID Then
		nInfo:NetInfo = BP_FindID(id)
		If nInfo<>Null And id <> BP_My_ID Then
			BP_UDPMessage(0, 249, Chr$(id)+Chr$(ban))
			msg:MsgInfo = New MsgInfo
			msg.msgType = 252
			msg.msgFrom = id
			msg.msgData = ban
			If ban Then
				BP_BanIP (nInfo.IP)
				If BP_Log Then BP_UpdateLog ("You banned: " + nInfo.Name)
			Else
				If BP_Log Then BP_UpdateLog ("You kicked: " + nInfo.Name)
			End If
			nInfo.LDelete() 
			BP_NumPlayers = BP_NumPlayers - 1
		End If
	End If
End Function

Function BP_NextAvailID ()
'-=-=-=Find out the Next available ID # that is Not in use
	Local testing
	Local foundit
	Local temp_array[256]

	For nInfo:NetInfo = EachIn NetInfo_list
		temp_array[nInfo.net_id] = True
	Next

	For testing = 1 To BP_MaxPlayers
		If Not temp_array[testing] Then
			foundit = testing
			Exit
		End If
	Next
	Return foundit
End Function

Function BP_SetGameType(GameType)
'-=-=-=Allows the user To control the numeric game Type value
	If BP_My_ID = BP_Host_ID Then
	    BP_GameType = GameType
		BP_UDPMessage(0,248,"1"+GameType)
	End If
End Function

Function BP_SetMaxPlayers(MaximumPlayers)
'-=-=-=Allows the user To control the maximum allowable players
	If (BP_My_ID = BP_Host_ID) Then
		If MaximumPlayers > 255 Then MaximumPlayers = 255
		If MaximumPlayers < 0 Then MaximumPlayers = 0
	    BP_MaxPlayers = MaximumPlayers
		BP_UDPMessage(0,248,"2"+MaximumPlayers)
	End If
End Function

Function BP_SetTimeoutPeriod(TimeoutPeriod)
'-=-=-=Allows the user To set Or change the TimeoutPeriod value
    BP_TimeoutPeriod = TimeoutPeriod
End Function

Function BP_SimulatePacketLoss(Odds)
'-=-=-=Allows the user To control simulated packet loss
    BP_UDPdebug = Odds
End Function

Function BP_StartLogFile(FileName$, Append = True, Automatic = True)
'-=-=-=Opens up the Log file: Also, optionally appends To the file instead of overwriting:
'Will only start a Log If there isn't one already, and if the filename is valid:
	If (Len(FileName$) > 0) And (BP_Log = Null) Then
		BP_LogFile$ = FileName$
		BP_AutoLogging = Automatic
		'Check To see If the file exists already
		If FileType(FileName$) = 1 Then
			Select Append	'If it does, check To see If we're going to append or overwrite
				Case True
					BP_Log = OpenFile (FileName$)
					SeekStream (BP_Log, FileSize(FileName$))
					WriteLine BP_Log, ""
				Case False
					DeleteFile FileName$
					BP_Log = WriteFile (FileName$)
			End Select
		Else
			BP_Log = WriteFile (FileName$)
		End If			
		'Now that the file is opened, insert the header information
		WriteLine BP_Log, "**Logging enabled at " + CurrentTime$() + " for " + BP_GetMyName() + ":"
		If BP_Online Then
			WriteLine BP_Log, "Connection Status: Online  Local IP/Port = " + DottedIP$(Int(BP_GetMyIP())) + "/" + BP_GetMyPort() + "  Host IP/Port = " + DottedIP$(Int(BP_GetHostIP())) + "/" + BP_GetHostPort()
		Else
			WriteLine BP_Log, "Connection Status: Offline  Local IP/Port = " + DottedIP$(Int(BP_GetMyIP())) + "/" + BP_GetMyPort() + "  Host IP/Port = " + DottedIP$(Int(BP_GetHostIP())) + "/" + BP_GetHostPort()
		End If
		WriteLine BP_Log, "Current Session Stats: GameType = " + BP_GetGameType() + "  NumPlayers = " + BP_GetNumberOfPlayers() + "  Local ID/Host ID = " + BP_GetMyID() + "/" + BP_GetHostID()
	EndIf
End Function

Function BP_StopLogFile()
'-=-=-=Allows the user To stop the logfile
	If BP_Log
		WriteLine BP_Log, "**Logging stopped at " + CurrentTime$() + ":"
		CloseFile BP_Log
		BP_Log = Null
	End If
	BP_AutoLogging = False
End Function

Function BP_StrToInt(st$)
'-=-=-=Take a String of any length And turn it into an integer again:
	Local shiftin
	Local num
	For shiftin = 0 To (Len (st$) - 1)
		num = num Or (Asc (Mid$ (st$, shiftin + 1, 1)) Shl shiftin * 8)
	Next
	Return num
End Function

Function BP_StrToFloat#(st$)
'-=-=-=Take a 4 Byte String And turn it back into a floating point #:
	Local num#,i
	For i = 0 To 3
		PokeByte BP_CompressBank,i,Asc(Mid$(st$,i+1,1))
	Next
	num# = PeekFloat(BP_CompressBank,0)
	Return num
End Function

Function BP_UnbanIP (ip)
'-=-=-=Allow an IP To join again
	For banned:BannedPlayers = EachIn BannedPlayers_list
		If banned.IP = ip Then banned.LDelete()
	Next
End Function

Function BP_UpdateNetwork ()		'This is the -meat- of the library:
'-=-=-=Check For messages, disconnects, New players, And UDP resends:
	'First lets get the variables defined as Local To this Function only
	Local curTime
	Local senderIP
	Local senderPort
	Local msgLength
	Local msgType
	Local msgTarget
	Local msgToSend$
	Local msgData$
	Local reading
	Local counter
	Local allowed
	Local kickedID
	Local newmsg
	Local msg:MsgInfo
	'Local nInfo:NetInfo
'***Check UDP Messages first
	If BP_Host
		While BP_Online
			
			If BP_UDP_Stream.RecvMsg() Then
				curTime = MilliSecs ()
				BP_TotRecvPacket = BP_TotRecvPacket + 1
				senderPort = BP_UDP_Stream.GetMsgPort()
				senderIP = BP_UDP_Stream.GetMsgIP()
				msgLength = BP_UDP_Stream.Size() - 2		'(-2 For the BP Header)
				msgType = BP_UDP_Stream.ReadByte()			'1 Byte For the msg Type
				msgTarget = BP_UDP_Stream.ReadByte()			'1 For the message target

				nInfo:NetInfo = BP_FindIP (senderIP, senderPort)
				If nInfo<>Null Then 
					nInfo.lastHeard = curTime 
					nInfo.Alive = True	'Make sure we don't timeout
				EndIf
				msgData$ = ""
				For reading = 1 To msgLength
					msgData$ = msgData$ + Chr( BP_UDP_Stream.ReadByte())
				Next
				Print "Message Data: "+msgData$+" Message type: "+254
				Select msgType
					Case 255			'If it was a keep alive packet
						If nInfo <> Null Then
							nInfo.LastHeard = curTime
							nInfo.Alive = True
						End If

					Case 254			'A packet with connecting info For a New player
						Print "new player! Case: "+Asc(msgData)
						Select Asc(msgData)
							Case 1
								c:Connecting = BP_FindConnect (senderIP, senderPort)
								If c = Null Then
									'New join! Time To see If we'll let 'em in
									'check To see that they aren't banned
									'allowed is the code that we assign To this connect
									'1 = banned|2 = no room|4 = allowed!
									allowed = BP_SUCCESS
									For banned:BannedPlayers = EachIn BannedPlayers_list
										If banned.ip = senderIP Then allowed = BP_IAMBANNED
									Next
									'make sure there's room, counting people in middle of connecting
									counter = 0
									For ccount:Connecting = EachIn Connecting_list
										counter = counter + 1
									Next
									If (BP_NumPlayers + counter) => BP_MaxPlayers Then allowed = BP_GAMEISFULL
									If allowed = BP_SUCCESS Then
										Print "New connection!"
										c:Connecting = New Connecting
										c.Name = Mid$ (msgData,2)
										c.net_id = BP_NextAvailID ()
										c.IP = senderIP
										c.Port = senderPort
										c.LastHeard = curTime
										msgToSend$ = Chr$(254) + Chr$(BP_My_ID) + Chr$(1) + Chr$(c.net_id) + Chr$(BP_My_ID) + Chr$(BP_NumPlayers) + Chr$(BP_MaxPlayers) + Chr$(BP_GameType) + Chr$(BP_TimeoutPeriod/1000)
										BP_UDPSend (msgToSend, c.IP, c.Port)
										For nInfo:NetInfo = EachIn NetInfo_list
											msgToSend = Chr$(254) + Chr$(BP_My_ID) + Chr$(2) +  Chr$(nInfo.net_id) + nInfo.Name
											BP_UDPSend (msgToSend, c.IP, c.Port)
											Print "message: "+msgToSend
										Next
										If BP_Log Then BP_UpdateLog (c.Name + " is attempting to join the game::")
									Else
										msgToSend = Chr$(254) + Chr$(BP_My_ID) + Chr$(3) + Chr$(allowed)
										BP_UDPSend (msgToSend, senderIP, senderPort)
									End If
								End If
							Case 2
								c:Connecting = BP_FindConnect(senderIP, senderPort)
								If c<>Null Then
									sendmsg$ = Chr$(c.net_id) + c.Name
									BP_UDPMessage (0,252,sendmsg)
									nInfo:NetInfo = New NetInfo
									nInfo.name = c.name
									nInfo.IP = senderIP
									nInfo.Port = senderPort
									nInfo.net_id = c.net_id
									nInfo.LastHeard = curtime
									nInfo.Alive = True
									c.LDelete() 
									msg:MsgInfo = New MsgInfo
									msg.msgType = 255
									msg.msgFrom = nInfo.net_id
									msg.msgData = nInfo.Name
									BP_NumPlayers = BP_NumPlayers + 1
									If BP_Log Then BP_UpdateLog (nInfo.name + " has joined the game from " + DottedIP$(nInfo.IP) + ":" + nInfo.Port + " ID #" + nInfo.net_id)
								End If
						End Select

					Case 253			'Someone has Left the game
						nInfo:NetInfo = BP_FindID(Asc(msgData))	'Since this player is the Host, Then tell everyone
						If nInfo<>Null Then						'Else about it too
							disc_id = nInfo.net_id
							msg:MsgInfo = New MsgInfo
							msg.msgData = True
							msg.msgType = BP_PLAYERHASLEFT
							msg.msgFrom = nInfo.net_id
							If BP_Log Then BP_UpdateLog (nInfo.Name + " has left the game:")
							nInfo.LDelete() 
							BP_UDPMessage(0,253,Chr$(disc_id) + Chr$(True))
							For c:connecting = EachIn connecting_list
								msgToSend$ = Chr$(253) + Chr$(BP_My_ID) + Chr$(disc_id) + Chr$(True)
								BP_UDPSend (msgToSend, c.IP, c.Port)
							Next
							BP_NumPlayers = BP_NumPlayers - 1
						End If

					Case 252		'Someone has successfully joined the game

					Case 251		'The Host has disconnected

					Case 250		'This was a "are you still there??" packet from someone:
						BP_UDPSend (Chr$(255) + Chr$(BP_My_ID) + "yup", senderIP, senderPort)

					Case 249		'Someone got kicked

					Default			'Nothing internal, a user packet:
						nInfo2:NetInfo = nInfo
						If nInfo2 <> Null Then	'Do we recognize the sender?
							If msgTarget <> BP_My_ID Then
								If msgTarget = 0 Then			'If its a UDP broadcast::
									msgToSend$ = Chr$(msgType) + Chr$(nInfo2.net_id) + msgData
									For nInfo:NetInfo = EachIn NetInfo_list
										If nInfo.net_id <> BP_My_ID And nInfo.net_id <> nInfo2.net_id Then
											BP_UDPSend (msgToSend, nInfo.IP, nInfo.Port)
										End If
									Next
								Else							'Ah, a specific target:
									msgToSend$ = Chr$(msgType) + Chr$(nInfo2.net_id) + msgData
									nInfo:NetInfo = BP_FindID (msgTarget)
									BP_UDPSend (msgToSend, nInfo.IP, nInfo.Port)
								End If
							End If	

							If msgTarget = 0 Or msgTarget = BP_My_ID Then
								msg:MsgInfo = New MsgInfo
								msg.msgData = msgData
								msg.msgType = msgType
								msg.msgFrom = nInfo2.net_id
								nInfo2.LastHeard = curtime
								nInfo2.Alive = True
								If BP_AutoLogging Then BP_UpdateLog ("[Incoming] From: " + LSet$(nInfo2.Name,20) + " Type: " + LSet$(msgType,3) + " {" + msgData$ + "}")
							End If
						Else
							msgq:UnrecMsgQueue = New UnrecMsgQueue
							msgq.msgData = msgData
							msgq.msgType = msgType
							msgq.IP = senderIP
							msgq.Port = senderPort
							msgq.Time = curTime
						End If
				End Select
			Else
				Exit			'Ah finally done receiving UDP messages? Outta this loop Then!
			End If
		Wend

		curTime = MilliSecs ()

		If BP_Online		'Have To check again because something *could* have made us offline in prev loop
			'Now look through messages from unrecognized players And see If they've recently joined
			For msgq:UnrecMsgQueue = EachIn UnrecMsgQueue_list
				nInfo:NetInfo = BP_FindIP(msgq.IP, msgq.Port)
				If nInfo <> Null Then
					msg:MsgInfo = New MsgInfo
					msg.msgData = msgData
					msg.msgType = msgType
					msg.msgFrom = nInfo.net_id
					If BP_AutoLogging Then BP_UpdateLog ("[Incoming] From: " + LSet$(nInfo.Name,20) + " Type: " + LSet$(msg.msgType,3) + " {" + msg.msgData$ + "}")
					msgq.LDelete()
				Else
					If (msgq.Time + 1000) < curTime Then msgq.LDelete() 
				End If
			Next		

			'Check To see who might have been disconnected
			For nInfo:NetInfo = EachIn NetInfo_list
				If nInfo.net_id <> BP_My_ID Then
					If ((nInfo.LastHeard + (BP_TimeoutPeriod / 2)) < curTime) And (nInfo.Alive) Then	'It's been 5 secs?
						BP_UDPMessage (nInfo.net_id, 250, "hello?")
						nInfo.Alive = False
						If BP_Log Then BP_UpdateLog (nInfo.Name + " hasn't been heard from in: " + (BP_TimeoutPeriod/1000) + " seconds: Testing to see if still connected:")
					End If
					If ((nInfo.LastHeard + BP_TimeoutPeriod) < curTime) And (nInfo.Alive = False) Then					'It's been 10 secs!?
						disc_id = nInfo.net_id
						msg:MsgInfo = New MsgInfo
						msg.msgType = BP_PLAYERHASLEFT
						msg.msgFrom = nInfo.net_id
						msg.msgData = False
						BP_UDPMessage (disc_id,249,Chr$(disc_id))
						If BP_Log Then BP_UpdateLog (nInfo.Name + " has lagged out of the game:")
						nInfo.LDelete() 
						BP_UDPMessage (0,253,Chr$(disc_id) + Chr$(False))
						BP_NumPlayers = BP_NumPlayers - 1
					End If
				End If
			Next
			'Scan through the list of people connecting, And see If we haven't heard from them in 10 secs		
			For c:Connecting = EachIn Connecting_list
				If (c.LastHeard + BP_TimeoutPeriod) < curTime Then						'It's been 10 secs!?
					If BP_Log Then BP_UpdateLog (c.Name + " didn't reply fast enough: Deleting from connecting queue:")
					c.LDelete()
				End If
			Next
		End If
'***************************Client's UpdateNetwork
	Else	
		While BP_Online
		
			
			If BP_UDP_Stream.RecvMsg() Then

				senderPort = BP_UDP_Stream.GetMsgPort()
				senderIP = BP_UDP_Stream.GetMsgIP()		
				If senderIP <> BP_Host_IP Then Exit
			
			
				curTime = MilliSecs ()
				nInfo:NetInfo = BP_FindID (BP_Host_ID)
				If nInfo<>Null Then 
				nInfo.lastHeard = curTime
				nInfo.Alive = True
				EndIf
				BP_TotRecvPacket = BP_TotRecvPacket + 1
				senderPort = BP_UDP_Stream.GetMsgPort()
				'Msg will be in format: 123 1=Type|2=Sender|3=Data
				msgLength = BP_UDP_Stream.Size() - 2		'(-2 For the 2 bytes being read as the header)
				msgType = BP_UDP_Stream.ReadByte()			'1 Byte For the msg Type
				msgFrom = BP_UDP_Stream.ReadByte()			'1 Byte For the msg sender
				msgData$ = ""
				For reading = 1 To msgLength
					msgData$ = msgData$ + Chr$ (BP_UDP_Stream.ReadByte())
				Next

				Select msgType
					Case 255			'If it was a keep alive packet::
						nInfo:NetInfo = BP_FindIP (senderIP, senderPort)
						If nInfo<>Null Then
							nInfo.LastHeard = curTime
							nInfo.Alive = True
						End If

					Case 254			'A packet with connecting info For a New player
						Select Asc(msgData)
							Case 1
								BP_My_ID = Asc(Mid$(msgData,2))
								BP_Host_ID = Asc(Mid$(msgData,3))
								BP_NumPlayers = Asc(Mid$(msgData,4))
								BP_MaxPlayers = Asc(Mid$(msgData,5))
								BP_GameType = Asc(Mid$(msgData,6))
								BP_TimeoutPeriod = Asc(Mid$(msgData,7)) * 1000
							Case 2
								nInfo:NetInfo = BP_FindID(Asc(Mid$(msgData,2)))
								If nInfo=Null Then
									msgData = Mid$(msgData,2)
									nInfo:NetInfo = New NetInfo
									nInfo.net_id = Asc(Mid$(msgData,1))
									nInfo.Name = Mid$(msgData,2)
									nInfo.Alive = True
									nInfo.LastHeard = curTime
									msg:MsgInfo = New MsgInfo
									msg.msgType = 255
									msg.msgFrom = nInfo.net_id
									msg.msgData = nInfo.Name
									
								End If
							Case 3
								reason = Asc(Mid$(msgData,2,1))
								msg:MsgInfo = New MsgInfo
								msg.msgType = 256
								msg.msgFrom = 0
								msg.msgData = reason
						End Select

					Case 253			'Someone has Left the game
						nInfo:NetInfo = BP_FindID(Asc(msgData))	'If they're still in the game
						If nInfo<>Null Then
							msg:MsgInfo = New MsgInfo			'And make a New msg about it
							msg.msgData = Asc(Mid$(msgData,2))
							msg.msgType = 254
							msg.msgFrom = nInfo.net_id
							nInfo.LDelete()
							BP_NumPlayers = BP_NumPlayers - 1
							If BP_Log Then
								If msg.msgData Then BP_UpdateLog (nInfo.Name + " has left the game:") Else BP_UpdateLog (nInfo.Name + " has lagged out of the game:" + nInfo.net_id)
							End If
						End If

					Case 252		'Someone has successfully joined the game
						curTime = MilliSecs ()
						nInfo:NetInfo = New NetInfo
						nInfo.net_id = Asc(Mid$(msgData,1))
						nInfo.Name = Mid$(msgData,2)
						nInfo.LastHeard = curtime
						nInfo.Alive = True
						BP_NumPlayers = BP_NumPlayers + 1
						msg:MsgInfo = New MsgInfo
						msg.msgData = nInfo.Name
						
						msg.msgType = 255
						msg.msgFrom = nInfo.net_id
						If BP_Log Then BP_UpdateLog (nInfo.Name + " has joined the game w/ ID #" + nInfo.net_id)

					Case 251		'The Host has disconnected
						nInfo:NetInfo = BP_FindID(Asc(msgData))
						If nInfo<>Null Then
							BP_Online = False
							BP_UDP_Stream.Close()
							BP_UDP_Stream = Null
							msg:MsgInfo = New MsgInfo
							msg.msgType = 253
							msg.msgFrom = nInfo.net_id
							msg.msgData = True
							ClearList(NetInfo_list)
							BP_NumPlayers = 0
						End If
						If BP_Log Then BP_UpdateLog ("The Host ended the session:")

					Case 250		'This was a "are you still there??" packet from someone:
						BP_UDPSend (Chr$(255) + Chr$(BP_My_ID) + "yup", senderIP, senderPort)

					Case 249		'Someone got kicked
						kickedID = Asc(msgData)
						nInfo:NetInfo = BP_FindID(kickedID)
						If nInfo <> Null Then
							msg:MsgInfo = New MsgInfo
							msg.msgType = 252
							msg.msgFrom = nInfo.net_id
							msg.msgData = Asc(Mid$(msgData,2))
							If BP_Log Then
								If msg.msgData Then BP_UpdateLog (nInfo.Name + " was banned") Else BP_UpdateLog (nInfo.Name + " was kicked")
							End If
							If kickedID = BP_My_ID Then
								ClearList(NetInfo_list)
								BP_Online = False
								BP_UDP_Stream.Close()
								BP_UDP_Stream = Null
								BP_NumPlayers = 0
								Return
							Else
								nInfo.LDelete() 
								BP_NumPlayers = BP_NumPlayers - 1
							End If
						End If

					Case 248
						Select Asc(msgData)
							Case 1
								BP_GameType = Asc(Mid$(msgData,2))
							Case 2
								BP_MaxPlayers = Asc(Mid$(msgData,2))
						End Select

					Default			'Nothing 'special'
						nInfo:NetInfo = BP_FindID(msgFrom)
						curTime = MilliSecs ()
						If nInfo <> Null Then
							msg:MsgInfo = New MsgInfo
							msg.msgData = msgData
							msg.msgType = msgType
							msg.msgFrom = msgFrom
							nInfo.LastHeard = curtime
							nInfo.Alive = True
							If BP_AutoLogging Then BP_UpdateLog ("[Incoming] UDP From: " + LSet$(nInfo.Name,20) + " Type: " + LSet$(msgType,3) + " {" + msgData$ + "}")
						Else
							msgq:UnrecMsgQueue = New UnrecMsgQueue
							msgq.msgData = msgData
							msgq.msgType = msgType
							msgq.net_id = msgFrom
							msgq.Time = curTime
						End If
				End Select
			Else
				Exit			'Ah finally done receiving UDP messages? Outta this loop Then!
			End If
		Wend

		If BP_Online		'Have To check again because something *could* have made us offline in prev loop
			curTime = MilliSecs ()
			'Now look through messages from unrecognized players And see If they've recently joined
			For msgq:UnrecMsgQueue = EachIn UnrecMsgQueue_list
				nInfo:NetInfo = BP_FindID(msgq.net_id)
				If nInfo <> Null Then
					msg:MsgInfo = New MsgInfo
					msg.msgData = msgData
					msg.msgType = msgType
					msg.msgFrom = nInfo.net_id
					If BP_AutoLogging Then BP_UpdateLog ("[Incoming] From: " + LSet$(nInfo.Name,20) + " Type: " + LSet$(msg.msgType,3) + " {" + msg.msgData$ + "}")
					msgq.LDelete() 
				Else
					If (msgq.Time + 1000) < curTime Then msgq.LDelete() 
				End If
			Next		

			'Check For disconnection from Host
			nInfo:NetInfo = BP_FindID (BP_Host_ID)
			If nInfo<>Null
				If ((nInfo.LastHeard + (BP_TimeoutPeriod/2)) < curTime) And (nInfo.Alive) Then	'It's been awhile::
					BP_UDPMessage (nInfo.net_id, 250, "hello?")
					nInfo.Alive = False
				End If
				If ((nInfo.LastHeard + BP_TimeoutPeriod) < curTime) And (nInfo.Alive = False) Then	'It's been BP_TimeoutPeriod secs!?
					BP_Online = False
					BP_UDP_Stream.Close()
					BP_UDP_Stream = Null
					msg:MsgInfo = New MsgInfo
					msg.msgType = 253
					msg.msgFrom = nInfo.net_id
					ClearList(NetInfo_list)
					BP_NumPlayers = 0
					If BP_Log Then BP_UpdateLog ("Host hasn't replied in " + (BP_TimeoutPeriod/1000) + " seconds, game ended")
				End If
			End If'If nInfo<>Null
		End If'If BP_Online
	End If'If BP_Host
End Function


Function BP_UDPSend (msg$, IP, Port)
'-=-=-=Sends the UDP message, Byte by Byte:
	Local odds
	Local writing
	BP_TotSentPacket = BP_TotSentPacket + 1
	Print "Send to: "+IP+" port: "+Port
	
	If BP_UDPdebug Then
		odds = Rand (1,100)
		If odds < (100 - BP_UDPdebug) Then
		BP_UDP_Stream.SetRemoteIP(TNetwork.IntIP(IP))
		BP_UDP_Stream.SetLocalPort()
		BP_UDP_Stream.SetRemotePort(Port)
			For writing = 1 To Len(msg)
				 BP_UDP_Stream.WriteByte( Asc ( Mid$ (msg,writing,1)))
			Next
			BP_UDP_Stream.SendMsg()'SendUDPMsg BP_UDP_Stream, IP, Port
			
		End If
	Else
		BP_UDP_Stream.SetRemoteIP(TNetwork.IntIP(IP))
		BP_UDP_Stream.SetLocalPort()
		BP_UDP_Stream.SetRemotePort(Port)	
		For writing = 1 To Len(msg)
			 BP_UDP_Stream.WriteByte( Asc ( Mid$ (msg,writing,1)))
		Next
		'BP_UDP_Stream.SendMsg()'SendUDPMsg BP_UDP_Stream, IP, Port
		BP_UDP_Stream.SendMsg()
	End If
End Function

Function BP_UDPMessage (msgTarget, msgType, msgData$, unusedRE = False, unusedIN = False)
'-=-=-=Prepare a UDP message To send:
	Local curTime
	If BP_Online
'Insert the message Type
		If BP_Host
			If msgTarget = 0 Then			'If its a UDP broadcast::
				msgData = Chr$(msgType) + Chr$(BP_My_ID) + msgData
				For nInfo:NetInfo = EachIn NetInfo_list
					If nInfo.net_id <> BP_My_ID Then
						If BP_AutoLogging Then BP_UpdateLog ("[Outgoing] UDP   To: " + LSet$(nInfo.Name,20) + " Type: " + LSet$(msgType,3) + " {" + msgData + "}")
						BP_UDPSend (msgData, nInfo.IP, nInfo.Port)
					End If
				Next
			Else	'Ah, a specific target:
				msgData = Chr$(msgType) + Chr$(BP_My_ID) + msgData
				nInfo:NetInfo = BP_FindID (msgTarget)
				If BP_AutoLogging Then BP_UpdateLog ("[Outgoing] UDP   To: " + LSet$(nInfo.Name,20) + " Type: " + LSet$(msgType,3) + " {" + msgData + "}")
				BP_UDPSend (msgData, nInfo.IP, nInfo.Port)
			End If
		Else	'Client doing a send
			msgData = Chr$(msgType) + Chr$(msgTarget) + msgData
			If BP_AutoLogging Then BP_UpdateLog ("[Outgoing] UDP   To: " + msgTarget + " Type: " + LSet$(msgType,3) + " {" + msgData + "}")
			BP_UDPSend (msgData, BP_Host_IP, BP_Host_Port)
		End If
	End If
End Function


Function BP_UpdateLog (txt$)
'-=-=-=Updates the Log file, checks To see If its been started
	If BP_Log Then
		WriteLine BP_Log, txt$
	End If
End Function
