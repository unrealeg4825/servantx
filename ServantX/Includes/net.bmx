'------------------------------NETWORK STUFF------------------------------------
Include "BPproV1.0.bmx"
xCls
'pass$  =getclparam(2)

My_Port=Rand(5000,15100)

Rem
If myname="" Or pass="" Or my_port=0 Then
	End
EndIf
End Rem
ipfile:TStream=OpenFile ("serverip.txt")
ip$=ReadLine (ipfile)
CloseFile ipfile

xCls
'BP_StartLogFile("log.dat")

xText 150,50,"Checking Login Info! (Hit [esc] to cancel)",True,True
access = True 'CheckPassword(myname$,Pass$)
'DebugLog access

If access = True Then
xCls
xText 150,50,"Connecting.....",True,True
xFlip

DebugLog myname$
DebugLog my_port

reason = BP_JoinSession (myname$+charactermodel+mysex,my_port,IP$,5555)





DebugLog reason
gamestarttime=MilliSecs()

Select reason

	Case BP_USERABORT
		RuntimeError ("The user has aborted the connection attempt.")
	Case BP_IAMBANNED
		RuntimeError ("The local ip was banned from the game")
	Case BP_GAMEISFUL
		RuntimeError ("The game is full right now")
	Case BP_PORTNOTAVAILABLE
		RuntimeError ("The local port 5555 was not available")
	Case BP_NOREPLY
		RuntimeError ("Could Not connect to server check your firewall or the server might be down")
	Case BP_SUCCESS 	
	
	'BP_UDPMessage(0,4,charactermodel+mysex,False)
End Select
EndIf

BP_UpdateNetwork()
'BP_startlogfile(myname$ + ".txt")


If access = False Then End



Function CheckPassword(UID$,PWD$)
	'check uid pwd against user database
	wwwsock:TSocket = CreateTCPSocket:TSocket()
	'www=OpenTCPStream( ) 
	connect=ConnectSocket( wwwsock,0,80  )
	www:TSocketStream=CreateSocketStream( wwwsock)
	If Not www Return
	
	upstring$="GET /tstesterlogin.php?uid=" + uid$ + "&pwd=" + pwd$ + " HTTP/1.0" 
	
	WriteLine www,upstring$
	
	WriteLine www,"Host: www.binary-people.com" 
	WriteLine www,"User-Agent: BPTesterLogin" 
	WriteLine www,"Accept: */*" 
	WriteLine www,"" 
	
	sLine$=ReadLine(www)
	
	While Not sLine$=""
		sLine$=ReadLine(www)
	Wend
	
	result=Int(ReadLine(www))
	CloseSocket(wwwsock)

	'login success	
	If result = 1 Return True
	'login failure
	Return False
End Function


Function getclParam$(paramno)
	temp$=""'CommandLine()
	For icount = 1 To Len(temp$)
		If (Mid(temp$,icount,1) = "/" Or Mid(temp$,icount,1) = "\") And start=0 Then
			paramcount=paramcount+1
			If paramcount = paramno Then
				'found start of correct param
				start = icount+1
				For iloop = icount+1 To Len(temp$)
					If Mid$(temp$,iloop,1) = " " Or iloop=Len(temp$) Then
						'found End
						If iloop < Len(temp$) Then
							Return Mid$(temp$,start,iloop-start)
						Else
							Return Mid$(temp$,start)
						EndIf
					EndIf
				Next
			EndIf
		EndIf
	Next
End Function









'--------------------218.4.8NETWORK End---------------------------------------------------