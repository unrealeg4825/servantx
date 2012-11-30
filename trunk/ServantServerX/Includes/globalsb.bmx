

Global Win1
Global txtChat 
Global txtChatEntry 
Global playerlist 
Global cmdKick 
Global cmdBan
Global cmdOK 

Global LOWESTMESSAGERENDER=400
Global gLastMessageID=0
Global maxcharlength =90
Global ctext$

Global npc_list:TList = New TList
Global Message_list:TList = New TList
Global User_list:TList = New TList
Global Info_list:TList = New TList	
Global pdata_list:TList = New TList
Global animal_list:TList = New TList
Global statemachine_list:TList = New TList
Global weatherupdate_list:TList = New TList

Type npc

	Method New()
	
		ListAddLast(npc_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(npc_list,Self)
	
	End Method
	
	Field numberofNPC = 1
	Field x#,y#,z#
End Type
  
Type Message

	Method New()
	
		ListAddLast(Message_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(Message_list,Self)
	
	End Method

	Field Action%
	Field iText$,iColor%
	Field From$,fColor%
	Field id
End Type

Type User

	Method New()
	
		ListAddLast(User_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(User_list,Self)
	
	End Method

	Field Nick$
End Type

Type Info

	Method New()
	
		ListAddLast(Info_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(Info_list,Self)
	
	End Method
		'Text messages
	Field txt$				'String
	Field time%				'time of msg originating
End Type

'player data. For this example, we only need name And location, as well as player id
Type pdata

	Method New()
	
		ListAddLast(pdata_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(pdata_list,Self)
	
	End Method

	Field X#,Y#,Z#,oldX#,OldY#,OldZ#,name$,net_id%,entity,yaw#,packetyaw#,namesprite,model,sex
	Field Experience,health,mana,strength,dexterity,Lvl,constitution,luck,charisma,Hitpoints,intelligence,hunger,Energy
	Field dataused,anim,splineid,packettime,lasttime,initialized,nomovement,packetx#,packety#,packetz#,Zone
End Type

'Type NetInfo
'Field net_id,name$
'End Type

Type animal


	Method New()
	
		ListAddLast(animal_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(animal_list,Self)
	
	End Method

	Field x#,y#,z#,yaw#,speed#	'movement stuff
	Field brain:statemachine	'the state machine For this animal
	Field age					'the creatures age
	Field creaturetype			'the Type of creature
	Field id					'unique ID For this creature
	Field zone					'the zone the animal lives in
	Field lastupdate			'time of last movement recalc
End Type

Type statemachine

	Method New()
	
		ListAddLast(statemachine_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(statemachine_list,Self)
	
	End Method

	Field hunger		'how hungry the animal is
	Field tiredness		'how tired the animal is
	Field confidence 	'need To be near creature of same Type
	Field aggression	'how aggresive the animal is, higher the number the higher the animal is up the food chain
End Type

'weather message Type
Type weatherupdate

	Method New()
	
		ListAddLast(weatherupdate_list,Self)
	
	End Method

	Method LDelete()
	
		ListRemove(weatherupdate_list,Self)
	
	End Method

	Field id
	Field weather
	Field lastupdate
End Type

Global lastanimalupdate	'Delay on send And update of animal positions

Global StatusBarstarttime = MilliSecs()
Global gservertime# = 7
Global gdecmin# = 1.0/60.0

Global lastweatherupdate=MilliSecs()
Global weathermap
Const weatherupdatedelay=2000