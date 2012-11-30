; VoiceInit()
;set up scene
;****************
Include "includes\prepare.bb"

Const quitdelay=5000
Global wanttoleave
Global leavingworldstart
Global leavingworld
Global deltatime#
Global showchar
;frame per second counter
Global lastfps
Global currentfps
Global fpsstart
Arrows = 100
quivers = 2
Health = .27
    
While initilizedplayerposition=False
	;wait for initial character position
	BP_UpdateNetwork()
	;HandleMessages() Changed to below to get beast deamon to work
	CreateZone(1)
	HandleMessages()
Wend



Repeat
    deltatime# = deltatime# + .01
	If deltatime# > 1 Then deltatime# = 0
	If MilliSecs()>nextgameupdate
	 CameraPick(camera,MouseX(),MouseY())
		
		control_cameraPick()
		world_soundAmbient() 
		
		nextgameupdate=MilliSecs()+75
	 Else
	   
		control_chat()
		control_playerMove()
		Collide_with_Zone_warps()
		
	;	moveenemies()
	    moveanimals() 
		
		moveplayers()
		
		;updaterain(255-(255*currentcloudalpha))
		control_mouseLook() 
		player_Animation()	
		
		player_NetPlayerAnimations()	
		
		control_keyboardInput()	
	
		control_playerMove()   
		;Update_Lightning(camera) 	
	    ;updateGrass(Terrain)
		sky_update()
	   ; create_water_ripple(player_pivot,water,1)
	   ; UpdateWater(surface,water)
	   ; UpdateCubemap(cube_tex,cube_cam,water)
		;RenderWater()
		UpdateWorld
		RenderWorld 
		
		renderMessages()
    
	
		If helps = True Then
			DrawImage help,10,120
		EndIf
		
		
		
		
		
		
		DrawImage spellbox,260,9
		DrawImage invbutt,286,27
		DrawImage charbutt,338,27
		DrawImage datepic,124,28
		
		;Color 128,0,0
		;Rect 920,570,20,Health+50
		
		
		;DrawImage manapic,950,550
		;DrawImage statusbox,900,520
		
		
		
		If showchar = True Then 
			showcharinfo()
		EndIf
		
		If showinv = True Then 
			showinventory()
		EndIf
		
		
		
		DrawImage pointer,MouseX(),MouseY()
	    Text 100,70," X " + EntityX(player,True) + " Y " + EntityY(player,True) + " Z " + EntityZ(player,True)
		debugtext()	
		Text 10,10,"fps=" + lastfps
		;Text 100,100,"YOU HAVE " 
		
		
		;Vsync On or Off
		Flip False
		;Flip True
		
		
        RotateEntity compass,0,EntityYaw(compass,True),EntityYaw(compass,True),True
         updateFPS()	
	EndIf		





	network_update()
	leavingworld=MilliSecs()-leavingworldstart
Until leavingworld>quitdelay And wanttoleave=True

leaveworld()
;meshTerrain_delete()
End

Function control_mouseLook()
	;update mouselook for this frame - TODO needs mouse smoothing
	If mouselook = True Then
		mxs = MouseXSpeed()
		mys = MouseYSpeed()
		
		dest_xang# = dest_xang + mys
		dest_yang# = dest_yang - mxs
	
		xang# = CurveValue (xang, dest_xang, 3)
		yang# = CurveValue (yang, dest_yang, 3)
	
		RotateEntity player_pivot, 0, yang, 0
		RotateEntity camera,xang,0,0
		If dest_xang > 70 Then dest_xang = 70
		If dest_xang < -70 Then dest_xang = -70
		MoveMouse GraphicsWidth()/2,GraphicsHeight()/2
	EndIf
End Function

Function control_keyboardInput()
	;grab ALL keypresses here
	If KeyHit(60) Then mouselook = Not mouselook
	
	If KeyHit(68) Then SaveScreenshot
	
	;leave world check
	If KeyHit(1) Then 
		wanttoleave=True
		leavingworldstart=MilliSecs()
	EndIf
	
	;help on/off
	If KeyHit(59) Then helps = Not helps 
	
	If KeyHit(28) Then 
		FlushKeys
		chatenabled = Not chatenabled
	EndIf

End Function

Function control_cameraPick()

;Detect Left Mouse Click
mouseClicked = MouseHit(1)

;INVENTORY HIDE AND SHOW
If mouseClicked = 1 And ImageRectOverlap(invbutt,285,27,MouseX(),MouseY(),1,1) 
	showinv = Not showinv
	
EndIf


;CHARACTER INFO HIDE And SHOW

If mouseClicked = 1 And ImageRectOverlap(charbutt,335,27,MouseX(),MouseY(),1,1) 
	showchar = Not showchar
	
EndIf


;IF ENTITY PICKED ADD IT TO INVENTORY

For w.weapons = Each Weapons
		If PickedEntity() = w\entity  And mouseClicked = 1 Then 
	    HideEntity w\entity
		PutInInventory(w\entity,w\name$,w\ID)
        EndIf
Next


	
End Function

Function control_chat()
		If chatenabled = True Then
			;If VoiceBlockForResult()=1 Then
			;	a$ = VoiceTestBlock()
			;	ctext$ = a$
			;Else
			;	a$=""
			;EndIf
			;Keyboard input
			cKey%=GetKey()
			If cKey>32 And cKey<128
				cText=cText+Chr(cKey)
			ElseIf cKey=8 And Len(cText)>0
				cText=Left(cText,Len(cText)-1)
			ElseIf cKey=32
				cText=cText+" "
			ElseIf cKey=13 ;Return is hit
				If Len(cText)>0 Then
					
					BP_UDPMessage(0,5,myname$ + ": " + cText,False,False)
					visibleMessageAdd(cText,myname,0,$ffffff,$ffffff)
					;irc_send(cText)
				EndIf
		
				If Upper(Left(cText,6))="!DRINK" Then
					Drinkbeer=1
				EndIf
		
				If Upper(Left(cText,6))="!Save" Then
					Print"character Saved"
					Cls
				EndIf
			
				cText=""
			EndIf
		EndIf
End Function

Function water_meshWaves()
	;make the terrain waves. needs to be converted to dynamic mesh instead of slow blitz terrain
	For z = 0 To WATER_GRID_SIZE-1
		For x = 0 To WATER_GRID_SIZE-1
			hite# = Sin(WaterY(z,x))
			ModifyTerrain water,x,z,Abs(hite#/2)+.5,False
			WaterY(z,x) = WaterY(z,x) + 1
		Next
	Next
End Function

Function player_Animation()
	;update player animation here
	If oldmoved = moved
		;If already moving then dont animate again
	Else
	
	Select moved
			Case 15
				Animate player,1,2,knight_A_walk,1;run
			;Case 1
				;Animate player,3,.5,knight_A_die,10;Walk Front
			Case 0
				Animate player,2,.1,knight_A_Idle,5;Idle
		End Select
		
	oldmoved = moved
	
	EndIf
	If Jumped =1Then
	;Animate player,2,3,knight_A_jump,10
	EndIf 
	
	If Animating(player) = 0		;if its not animating, then go to idle
		moved = 0
	EndIf
	
	If Not KeyDown(200)
		moved=0
	EndIf
End Function

Function player_NetPlayerAnimations()
	For p.pdata = Each pdata 
;			DebugLog p\dataused + " - " + p\anim
		;IS THIS A NEW DATA PACKET?
		If Not p\dataused
			lastanim=p\anim
			
			
			p\x=EntityX(p\entity)
			p\z=EntityZ(p\entity)
			
			
			
			If (p\x<>p\oldX) Or (P\Z<>p\oldZ) 
				p\anim=15
				
				If p\x<>p\oldX Then p\oldX = p\x
				If P\Z<>p\oldZ Then p\oldZ = p\z
			

			
			Else 
						
				p\anim = 0
			
			EndIf 
			
			p\dataused=True
			;ANIMATE PLAYER
			If lastanim<>p\anim
				Select p\anim
					Case 15
						Animate p\entity,1,2,knight_A_walk,1;run
					;Case 1
						;Animate player,3,.5,knight_A_die,10;Walk Front
					Case 0
						Animate p\entity,2,.1,knight_A_Idle,5;Idle
				End Select
			EndIf
		EndIf
		
		Next
End Function


Function sky_update()
	;updateskybox and cloud positions
	PositionEntity mesh_skybox,EntityX(camera,1),EntityY(camera,1)-10,EntityZ(camera,1)
	;PositionEntity mesh_skyboxnight,EntityX(camera,1),EntityY(camera,1)-10,EntityZ(camera,1)

	thiscloudalpha#=Int(weatherdensity)/255.0
	If currentcloudalpha >thiscloudalpha Then currentcloudalpha=currentcloudalpha-0.0005
	If currentcloudalpha <thiscloudalpha Then currentcloudalpha=currentcloudalpha+0.0005
	If currentcloudalpha >1 Then currentcloudalpha=1
	If currentcloudalpha <0 Then currentcloudalpha=0
	For cloudcount=0 To 2
		PositionEntity cloudlayer(cloudcount),EntityX(camera,1),EntityY(camera,1),EntityZ(camera,1)
		TurnEntity cloudlayer(cloudcount),0,.01*cloudcount,0
		EntityAlpha cloudlayer(cloudcount),currentcloudalpha
	Next
	PositionEntity cloudplane,EntityX(camera,1),EntityY(camera,1)+10,EntityZ(camera,1)
	EntityAlpha cloudplane,currentcloudalpha/2.0;256/((255-Int(weatherdensity))+1)
	PositionTexture cloudplanetex,Sin(MilliSecs()/10000.0),0
	TurnEntity mesh_skybox,0,.003,0,True
	
	skydif# = Abs(12-Float(gservertime))
	
	;EntityAlpha mesh_skyboxnight,skydif/12
	
	;EntityAlpha mesh_skybox,1-(skydif/12)
	
	If 1-(skydif/12) > .5 Then
	;EntityTexture water,watercubemapDay
	Else
	;EntityTexture water,watercubemapNight
	EndIf
	
	skyadjust#=skydif/12.0
	CameraFogMode camera, 1
	CameraFogColor camera, (40 * (1-skyadjust)),( 60 * (1-skyadjust)),( 65 * (1-skyadjust))
	CameraRange camera, 1, range
	CameraFogRange camera, 300, range; - (200 + ((skydif/12)*400))
	locallight=100+(255.0*(1-skyadjust))
	If locallight>255 Then locallight=255
	;AmbientLight  locallight,locallight,locallight
	AmbientLight  175,175,175
	
	
	;########################################################################lightning flash
	If flash>150 And flash>Locallight Then
		AmbientLight flash,flash,flash
	End If	
	
	Update_Lightning(camera)
	;TurnEntity  moon_piv,.003,0,0

End Function

Function world_soundAmbient()
	;trigger ambient world sounds based on time of day - TODO no birds in rain etc and move to server
	If gservertime>17 Or gservertime<7 Then
		If Rand(1,2000)=1 Then PlaySound(nighthowl)
	EndIf
	If gservertime>17 Or gservertime<7 Then 
		If Rand(1,500)=1 Then PlaySound(ambiant2)
	EndIf
	If gservertime>8 Or gservertime<15 Then 
 		If Rand(1,500)=1 Then PlaySound(ambiant1)
 	EndIf
End Function

Function network_update()
	;update all network for this frame
	If MilliSecs()-sendcounter>500 Then
		If initilizedplayerposition=True
			packet$ = BP_FloatToStr(EntityX(player_pivot,True)) + BP_FloatToStr(EntityY(player_pivot,True)) + BP_FloatToStr(EntityZ(player_pivot,True)) + BP_FloatToStr(EntityYaw(player_pivot,True)+180)
			BP_UDPMessage(0,1,packet$,True,False)	;broadcast message, of type 1, contents = packet$, reliable false
		EndIf
		sendcounter = MilliSecs()
	End If


	BP_UpdateNetwork()
	HandleMessages()
End Function

Function leaveworld()
	;disconnect and leave the game world
	
	;delete name sprites
	For p.pdata = Each pdata 
		DeleteFile p\name+".png"
	Next
	
	;quit message broadcast
	BP_UDPMessage(0,BP_PLAYERHASLEFT,"-",True,False) 
	Delay 100
	BP_EndSession()
End Function

Function updateFPS()
	If MilliSecs()-fpsstart>1000 Then
		lastfps=currentfps
		currentfps=0
		fpsstart=MilliSecs()
	EndIf
	currentfps=currentfps+1	
End Function


Function showcharinfo()
	
	DrawImage characterinfo,10,(yvalue / 2) - 55
	
	Text 148,(yvalue / 2) - 40,myname$ 
	Text 148,(yvalue / 2) - 14,level
	Text 148,(yvalue / 2) + 13,experiance
	Text 148,(yvalue / 2) + 42,Health
	Text 148,(yvalue / 2) + 66,mana
	Text 148,(yvalue / 2) + 90,Strength
	Text 148,(yvalue / 2) + 114,Dexterity
	Text 148,(yvalue / 2) + 137,Consitution
	Text 148,(yvalue / 2) + 161,luck
	Text 148,(yvalue / 2) + 185,hitpoints
	Text 148,(yvalue / 2) + 209,intelligence
	Text 148,(yvalue / 2) + 233,hunger
	Text 148,(yvalue / 2) + 257,energy
	
End Function



Function showinventory()
	
	DrawImage inv,(xvalue * 2) - 280 ,(yvalue / 2) 
	
	
For v.inventory = Each inventory
objects = v\typeobj
name$ = v\name$ 
Select objects = v\typeobj
	Case 1 ; Axes
 Select name$
	Case "Celtic Axe"
		DrawImage Celticaxeimg,(xvalue * 2) - 250 ,(yvalue / 2) + 30
 End Select
Case 2 ; Swords

Case 3 ; Staffs

Case 4 ; Shields

Case 5 ; Armor

Case 6 ; bows,crossbows
End Select
Next

End Function 

Function moveenemies()

For n.npcs = Each NPCS

nx=EntityX(n\entity)
nz=EntityZ(n\entity)

terheight= TerrainHeight(Terrain,nx,nz) 
spoty#=TerrainY(Terrain,nx,terheight,nz)

  If EntityY(n\entity) < -100 Then 
	PositionEntity n\entity,nx,spoty#+80,nz
  EndIf	

EntityAutoFade n\entity,300,1000
RotateMesh n\entity,0,90,0

If EntityDistance(n\entity,player_pivot) > 50 Then
thisyaw#=ATan2(EntityX(n\entity)-nx,EntityZ(n\entity)-nz)
;RotateEntity n\entity,0,360-thisyaw#,0
MoveEntity n\entity,0,0,.5
EndIf



If EntityDistance(n\entity,player_pivot) < 50 Then

PointEntity n\entity,player_pivot
Select n\side

Case 1 
MoveEntity n\entity,0,0,.5
Case 2

irc_log "*** Hello Young Lad ***",$FFFF00
End Select

EndIf


If EntityDistance(n\entity,player_pivot) < 10 Then
Select n\side
Case 1 
Health = Health - .1

Case 2

irc_log "*** Hello Young Lad ***",$FFFF00
End Select

EndIf

Next
End Function






;TEST
Function RenderWater()

	HideEntities()
	CameraProjMode camera,0
	CameraProjMode FXCamera,1
	
	wdb=1-wdb
		
	
			If waterdirection=1
			FlipMesh water
			EntityAlpha water,1
			EntityColor water,155,200,255

		EndIf	
		waterdirection=-1
		
		PositionEntity FXCamera,-EntityX(player),EntityY(player)-2,EntityZ(player)
		
		
		If wdb
			;do left view	
			SetCubeFace WaterMapTexture,0
			RotateEntity FXCamera,0,-90,180
			RenderWorld
			CopyRect 0,0,WaterMapSize,WaterMapSize,0,0,BackBuffer(),TextureBuffer(WaterMapTexture)
			;do forward view
			SetCubeFace WaterMapTexture,1
			RotateEntity FXCamera,0,0,180
			RenderWorld
			CopyRect 0,0,WaterMapSize,WaterMapSize,0,0,BackBuffer(),TextureBuffer(WaterMapTexture)
		Else
			;do right view	
			SetCubeFace WaterMapTexture,2
			RotateEntity FXCamera,0,90,180
			RenderWorld
			CopyRect 0,0,WaterMapSize,WaterMapSize,0,0,BackBuffer(),TextureBuffer(WaterMapTexture)
			;do backward view
			SetCubeFace WaterMapTexture,3
			RotateEntity FXCamera,0,180,180
			RenderWorld
			CopyRect 0,0,WaterMapSize,WaterMapSize,0,0,BackBuffer(),TextureBuffer(WaterMapTexture)
		EndIf
		
		;do down view
		SetCubeFace WaterMapTexture,5
		RotateEntity FXCamera,-90,0,180
		RenderWorld
		CopyRect 0,0,WaterMapSize,WaterMapSize,0,0,BackBuffer(),TextureBuffer(WaterMapTexture)
	



	CameraProjMode FXCamera,0
	CameraProjMode camera,1
	ShowEntities()


	gs=GetSurface(water,1)
	Freq#=MilliSecs()/4
	For i=0 To CountVertices(gs)-1
		Vertex(i)\y#=Sin(freq+Vertex(i)\x#*500+Vertex(i)\z#*300)*1.2
		VertexCoords gs,i,Vertex(i)\x#,-Vertex(i)\y#,Vertex(i)\z#
	Next

	If EntityY(camera,1)<-2 underwater=1 Else underwater=0

	

	
End Function


Function AddEntity(ent)
	e.entity=New entity
	e\ent=ent
End Function
Function HideEntities()
	For e.entity=Each entity
		HideEntity e\ent
	Next
End Function
;----------------------------------------------------------------------------------
Function ShowEntities()
	For e.entity=Each entity
		ShowEntity e\ent
	Next

End Function
;~IDEal Editor Parameters:
;~C#Blitz3D