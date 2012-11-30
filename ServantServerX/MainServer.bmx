'THE SERVANT - SERVER APP (c)2003
'
'
Import Vertex.BNetEx
Import MaxGui.Drivers
Include "includes\BPproV1.0.bmx"
Include "includes\globalsb.bmx"

'ExecFile "weatherserver:exe"

'weather networking

'Const ServerSwap$="weather:swp"	'swap file

CreateWin1()

Global gDay
Global gMonth
Global gYear

initializeServer()


While quitapp=False
	thisevent=PollEvent()
	' check For windows events	
	Select thisEvent
		Case EVENT_WINDOWSIZE
			'stop resize event
			SetGadgetShape win1,GadgetX(win1),GadgetY(win1),782,577
		Case EVENT_WINDOWCLOSE
			'quit the server, the win1 has been closed
			quitapp=True
		Case EVENT_GADGETACTION
			'gadget
			Select EventSourceHandle()
				Case txtChat 
					'lock the chat display
					ActivateGadget txtChatEntry
				
				Case txtChatEntry
					'do chat text entry
					'If EventData()=13 And TextFieldText(txtChatEntry)<>"" 
						'enter pressed, send message
					'	sendChatMessage()
					'EndIf
				Case cmdKick
					'kick player from game
					kickplayer()
					ActivateGadget txtChatEntry
				Case cmdBan
					'ban player from game
					kickplayer(True)
					ActivateGadget txtChatEntry
				
				Case cmdOK
										
					sendChatMessage()
					ActivateGadget txtChatEntry

									
				Case lstUsers
					'user list clicked
					ActivateGadget txtChatEntry
			End Select	
	
			
	End Select
	
	
	


	
	
	If MilliSecs()>nextStatusbarupdate Then
		'update status bar
		updatestatusbar()			
		nextStatusBarUpdate=MilliSecs()+2000

		'update server game time

		gservertime=gservertime + gdecmin
		If gservertime>24 Then
			gservertime=gservertime-24
			updatedate()
		EndIf
		broadcastTimeOfDay()
	EndIf
	'do server stuff
	serverloop()
	
	Delay 1
Wend

BP_EndSession()		'Call this To shut down the session

savegameworld()

End

Function CreateWin1()
	Win1 = CreateWindow("The Servant - SERVER : " + CurrentTime() + " / " + CurrentDate(),138,174,782,577,Desktop(),11)
	SetMinWindowSize win1,782,577
	txtChat = CreateTextArea(13,11,564,470,Win1,3)
	SetGadgetText txtChat ,"Server started " + CurrentTime() + " / " + CurrentDate()
	SetGadgetLayout txtChat ,1,0,1,0
	txtChatEntry = CreateTextField(16,491,562,40,Win1,0)
	'SetGadgetText txtChatEntry ,"Text"
	SetGadgetLayout txtChatEntry ,1,0,1,0
	playerlist = CreateListBox(587,11,177,472,Win1,0)
'	AddGadgetItem playerlist ,"ListBox"
'	SelectGadgetItem playerlist ,0
	SetGadgetLayout playerlist ,1,0,1,0
	cmdKick = CreateButton("&Kick",653,491,45,22,Win1,0)
	SetGadgetLayout cmdKick ,1,0,1,0
	cmdBan = CreateButton("&Ban",703,491,45,22,Win1,0)
	SetGadgetLayout cmdBan ,1,0,1,0
	
	cmdOK = CreateButton("&OK",587,491,45,22,Win1,4)
	SetGadgetLayout cmdOK ,1,0,1,0
	
	
	
	ActivateGadget txtchatentry
End Function

Function initializeServer()
	BP_HostSession("Host", 255, 1, 5555, 30) 
	gamefile=ReadFile("gamestate.txt")
	gservertime=Float(ReadLine (gamefile))
	gday=Int(ReadLine( gamefile))
	gmonth=Int(ReadLine( gamefile))
	gyear=Int(ReadLine( gamefile))

	CloseFile gamefile
End Function

Function sendChatMessage()
	ctext=TextFieldText(txtChatEntry)
	
	'Return/enter
	If Left(cText,1)="/" Or Left(cText,1)="." Then
		parsecommand(ctext)
		cText$=Chr(10) + "SERVER: " + TextFieldText(txtchatentry)
		AddTextAreaText txtChat,cText$
'		SetGadgetText txtchat, TextAreaText(txtchat) + 
		SetGadgetText txtchatentry,""
	Else
		If Len(cText)>0 Then
			BP_UDPMessage(0,5,"SYSTEM: " + cText,False)
			'visiblemessageadd(cText$,"SYSTEM",0,$ff0000,$ff0000)
			cText$=Chr(10) + "SERVER: " + TextFieldText(txtchatentry)
			AddTextAreaText txtChat,cText$
'			SetGadgetText txtchat, TextAreaText(txtchat) + 
			SetGadgetText txtchatentry,""
		EndIf
	EndIf
'stop repeating eventIDs()
	ActivateGadget txtchatentry
End Function

Function updateStatusBar()
	secsrunning$=(MilliSecs()-StatusBarstarttime)/1000 Mod 60
	minsrunning$= ((MilliSecs()-StatusBarstarttime)/1000)/60 Mod 60
	hoursrunning$=(((MilliSecs()-StatusBarstarttime)/1000)/60)/60
	
	If Len(secsrunning)=1 Then secsrunning = "0" + secsrunning
	If Len(minsrunning)=1 Then minsrunning= "0" + minsrunning

	totalplayercount=0
	For tempn:pdata = EachIn pdata_list
		totalplayercount=totalplayercount+1
	Next
	
	gameworldmins=(gservertime Mod 1)*60
	If gservertime<10 Then gwt$=gwt+"0"
	gwt=gwt+Int(gservertime)+ ":"
	If gameworldmins<10 Then gwt=gwt+"0"
	gwt=gwt+Int(gameworldmins)
	SetStatusText win1,"No of players " + totalplayercount + " :   session length " + hoursrunning + ":" + minsrunning + ":" + secsrunning + " game date:" + gday + "-" + gmonth + "-" + gyear
End Function

Function kickPlayer(ban=False)
	
	kickedplayer$=GadgetItemText (playerlist,SelectedGadgetItem(playerlist))
	tID=BP_GetPlayerID%(kickedplayer$)

	If tID=-99 Then 
		'visiblemessageadd("Command failed - " + ctext,"ERROR:",0,$ff0000,$ff0000)
		Text$=Chr(10) + "FAILED TO KICK " + kickedPlayer
		AddTextAreaText txtchat,Text$

		Return
	EndIf

	If Not ban Then
	    BP_UDPMessage(0,5,"SYSTEM:" + kickedplayer +" was kicked:",False)
		Text$=Chr(10) + "Kicked " + kickedPlayer
	Else
	    BP_UDPMessage(0,5,"SYSTEM:" + kickedplayer +" was banned:",False)
		Text$=Chr(10) + "Banned " + kickedPlayer
	EndIf
	
    BP_KickID tID,ban
    AddTextAreaText txtChat,Text$
    RemoveGadgetItem(playerlist,SelectedGadgetItem(playerlist))

	For tempn:pdata = EachIn pdata_list
		If tempn.name = kickedplayer Then
			ListRemove(pdata_list,tempn)
		EndIf
	Next
End Function

Function ServerLoop()
	'Main game loop
	Local msg:MsgInfo
	BP_UpdateNetwork()	'Let BlitzPlay do its thing

	For msg:MsgInfo = EachIn MsgInfo_list	'MsgInfo is the Type list BlitzPlay uses For received packets
		Select msg.msgType			'Check against the msgType
			Case BP_PLAYERHASJOINED	'Someone joined!
				addnewplayer(msg)
			Case BP_PLAYERHASLEFT		'Someone Left!
				p:pdata = FindPdata(msg.msgFrom)
			If p<>Null Then 
					For icount=0 To CountGadgetItems(playerlist)-1
						If GadgetItemText (playerlist,icount)=p.name Then
							RemoveGadgetItem(playerlist,icount)
						EndIf	
					Next
					Text$=Chr(10) + p.name + " left the game:"
					AddTextAreaText txtChat,Text$
					
					If p.name<>"Beast Daemon" Then
						BP_UDPMessage(0,5,"SYSTEM: " + p.name + " left the game:",False)
						'store players last position
						playerposition = WriteFile ("playerdata." + p.name + ":pos")
						WriteLine playerposition,p.x
						WriteLine playerposition,p.y
						WriteLine playerposition,p.z
						WriteLine playerposition,p.yaw
						WriteLine playerposition,p.model
						WriteLine playerposition,p.sex
						WriteLine playerposition,p.health
						WriteLine playerposition,p.Zone
						CloseFile playerposition
						
					EndIf			
					
					For wo:weatherupdate = EachIn weatherupdate_list
						If wo.id=p.net_id
							ListRemove(weatherupdate_list,wo)
						EndIf
					Next
					
 					p.LDelete() 	'Delete 'em					
				EndIf
				'broadcastTimeOfDay()
			Case 1		'A positional update
				p:pdata = FindPdata(msg.msgFrom)
				If p <> Null Then 	'error check To make sure this person is in the game
			     	p.x = BP_StrToFloat(Mid$(msg.msgData,1,4))
					p.y = BP_StrToFloat(Mid$(msg.msgData,5,4))
					p.z = BP_StrToFloat(Mid$(msg.msgData,9,4))
				EndIf
      		Case 4    
            	p:pdata=FindpData(msg.msgFrom)
            	p.zone = Int(Mid$(msg.msgData,1,4))
              

		  	Case 5 
		    	tUID$=Left(msg.msgData,Instr(msg.msgData,":")) 
      	 		tMsg$=Mid(msg.msgData,Instr(msg.msgData,":")+1) 

				If (Upper(tUID$)="BEEPS:" Or Upper(tUID$)="CKOB:") And Upper(Left$(tmsg$,6))=" /TIME" Then
					'command from op
					gservertime=Int(Upper(Mid(tmsg,8)))
					broadcasttimeofday()
				Else
					'chat message
					AddTextAreaText txtChat,Chr(10) + tUID$ + ": " + tMsg$
				EndIf
		End Select
		msg.LDelete()
	Next
End Function

Function FindPdata:pdata(id%)
	'Hunt For the player information that matches id%
	For p:pdata = EachIn pdata_list
		If p.net_id = id Then Return p
	Next
End Function

Function Createnpc:pdata()
'	Local n:pdata = New pdata
 '	n.name = "BlackSmith"
 '	n.model = 1
 '	n.x# = 648
 '	n.y# = 212
 '	n.z# = 150
'	n.playertype=1		'npc
'	Return n
End Function

Function parseCommand(ctext$)
	'find non-player specific commands
	Select Upper(Left(ctext,5))
		Case "/TIME"
			gservertime=Int(Upper(Mid(ctext,7)))
			broadcasttimeofday()
			Return
		Case "/QUIT"
			End
	End Select
	
	commandparam$=Mid(ctext,Instr(ctext," ")+1)
	
	tID=BP_GetPlayerID%(commandparam)	
	
	If tID=-99 Then 
		ctext=""
		'visiblemessageadd("Command failed - " + ctext,"ERROR:",0,$ff0000,$ff0000)
		Return
	EndIf
	
	Select Upper(Left(ctext,5))
		Case "/KICK"
		 	BP_KickID tID,False
			'visiblemessageadd("Kicked " + commandparam,"SYSTEM",0,$ff0000,$ff0000)
			BP_UDPMessage(0,5,"SYSTEM: " + commandparam + " was kicked:",False)
			For tempn:pdata = EachIn pdata_list
				'DebugLog tempn.name
				If tempn.name = kickedplayer Then
					tempn.LDelete()
				EndIf
			Next
		Case "/BAN "
		 	BP_KickID tID,True
			'visiblemessageadd("Banned " + commandparam,"SYSTEM",0,$ff0000,$ff0000)
			BP_UDPMessage(0,5,"SYSTEM: " + commandparam + " was banned:",False)
		Case "/UNBA"
			BP_UnbanIP BP_GetPlayerIP(commandparam)
			'visiblemessageadd(commandparam + " is no longer banned:","SYSTEM",0,$ff0000,$ff0000)
	End Select
	ctext=""
	SetGadgetText txtchatentry,""
End Function

Function BP_GetPlayerID%(Name$)
'-=-=-=Find a player's ID based on the name
	For nInfo:NetInfo = EachIn NetInfo_list
		If Left(nInfo.Name$,Len(name)) = name$ Then Return nInfo.net_id
	Next
	
	Return -99			'failed
End Function



Function BP_GetPlayerIP%(Name$)
'-=-=-=Find a player's name based on the ID
	For nInfo:NetInfo = EachIn NetInfo_list
		If nInfo.Name$ = name$ Then Return nInfo.ip
	Next
	
	Return -99			'failed
End Function

'###########################################################################

Function addNewPlayer(msg:MsgInfo)
	
	'a player has joined the game, prepare data And broadcast
	p:pData = New pData
	p.name = Left(msg.msgData,Len(msg.msgData)-2) 'Mid$(msg.msgData,1,4) 'Left(msg.msgData,Len(msg.msgData)-1)    	
	p.net_id = msg.msgfrom

	playerposition = ReadFile("playerdata." + p.name + ":pos")
	
	If playerposition = 0 Then
		'first time player
		p.x = 253.304
       	p.y = 66.0069
       	p.z = 238.417
		p.yaw=0
		p.zone = 1
		p.health = 100
		p.model = Int(Mid$(msg.msgData,Len(msg.msgData)-1,1))
		p.sex = Int(Mid$(msg.msgData,Len(msg.msgData),1))
		'createnewplayer file
		playerposition = WriteFile ("playerdata."+ p.name + ":pos")
		WriteLine playerposition,p.x
		WriteLine playerposition,p.y
		WriteLine playerposition,p.z
		WriteLine playerposition,p.yaw
		WriteLine playerposition,p.model
		WriteLine playerposition,p.sex
		WriteLine playerposition,p.health
        WriteLine playerposition,p.Zone
		CloseFile playerposition
	Else
		'Load old player position
		p.x=Float(ReadLine (playerposition))
		p.y=Float(ReadLine (playerposition))
		p.z=Float(ReadLine (playerposition))
		p.yaw=Float(ReadLine (playerposition))
		p.model=Int(ReadLine(playerposition))
		p.sex=Int(ReadLine(playerposition))
		p.health=Int(ReadLine(playerposition))
		p.zone=Int(ReadLine(playerposition))
		CloseFile (playerposition)
	EndIf

	'add player To listbox	
	AddGadgetItem(playerlist,p.name)
	If p.name<>"Beast Daemon"
	   	Text$=Chr(10) + p.name + " Has Joined "
	   	AddTextAreaText txtChat,Text$
		'broadcasttimeofday()
		'BP_UDPMessage(p.net_id,5,"SYSTEM:PLPS " + p.x + "-" + p.y + "-" + p.z,False)
		initialposition$=bp_floattostr(p.x) + bp_floattostr(p.y) + bp_floattostr(p.z) + bp_floattostr(p.yaw) + bp_floattostr(p.model) + bp_floattostr(p.sex)+bp_floattostr(p.health)+bp_floattostr(p.Zone)
		'send Current position To player
		BP_UDPMessage p.net_id,6,initialposition,True
		BP_UDPMessage p.net_id,6,initialposition,True
		DebugLog "sent " + p.name + " start coords of " + p.x + "," + p.y + "," + p.z + ",YAW=" + p.yaw
		'send Current date To player
		BP_UDPMessage p.net_id,10,("D"+gday + "/" + gmonth + "/" + gyear),True
	EndIf
	'Create a weatherupdate Object For this player
	thisweather:weatherupdate = New weatherupdate
	thisweather.id=p.net_id
End Function

Function broadcastTimeOfDay()
	BP_UDPMessage(0,10,"T"+gservertime,False)
End Function

Function saveGameWorld()
	'save time And date of game world
	gamefile=WriteFile ("gamestate:txt")
	If gamefile = 0 Then End
	
	'save time
	WriteLine gamefile,gservertime
	WriteLine gamefile,gday
	WriteLine gamefile,gmonth
	WriteLine gamefile,gyear

	CloseFile gamefile
End Function

Function updateDate()
	'Next day is here, update calendar
	
	gday=gday+1
	
	Select gmonth
		Case 1,3,5,7,8,10,12
			'31 days in this month
			daysinmonth=31
		Case 2
			'28 in this month, 29 on leap year
			If gyear Mod 4=0 Then
				daysinmonth=29
			Else
				daysinmonth=28
			EndIf
		Case 4,6,9,11
			daysinmonth=30
	End Select
	
	If gday>daysinmonth Then
		gday=1
		gmonth=gmonth+1
	EndIf
	
	If gmonth >12 Then
		gmonth=1
		gyear=gyear+1
	EndIf
	date$="D"+ gday + "/" + gmonth + "/" + gyear
	BP_UDPMessage(0,10,date,False)
End Function