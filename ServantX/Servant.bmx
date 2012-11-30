' VoiceInit()
'set up scene
'****************
Import xorsteam.xors3d
Import Vertex.BNetEx
'AlbaLynx GUI header
Import albalynx.albalynx

'GUI To Engine connector
Import albalynx.connect_xors3d

Include "includes\prepare.bmx"

Const quitdelay:Int=5000
Global wanttoleave
Global leavingworldstart
Global leavingworld
Global deltatime#
Global showchar
'frame per second counter
Global lastfps
Global currentfps
Global fpsstart
Arrows = 100
quivers = 2
Health = .27
    
While initilizedplayerposition=False
	'wait For initial character position
	BP_UpdateNetwork()
	'HandleMessages() Changed To below To get beast deamon To work
	CreateZone(1)
	HandleMessages()
Wend

'Global derpcam = xCreateCamera()

Repeat
    deltatime# = deltatime# + .01
	If deltatime# > 1 Then deltatime# = 0
	If MilliSecs()>nextgameupdate
	 xCameraPick(camera,xMouseX(),xMouseY())
		
		control_cameraPick()
		world_soundAmbient() 
		control_playerMove() 
		nextgameupdate=MilliSecs()+75
	 Else
	   
		control_chat()
		control_playerMove()
		Collide_with_Zone_warps()
		
	'	moveenemies()
	    moveanimals() 
		
		moveplayers()
		
		'updaterain(255-(255*currentcloudalpha))
		control_mouseLook() 
		player_Animation()	
		
		player_NetPlayerAnimations()	
		
		control_keyboardInput()	
	
		control_playerMove()   
		'Update_Lightning(camera) 	
	    'updateGrass(Terrain)
		sky_update()
	   ' create_water_ripple(player_pivot,water,1)
	   ' UpdateWater(surface,water)
	   ' UpdateCubemap(cube_tex,cube_cam,water)
		'RenderWater()
		'xSetBuffer xBackBuffer()

		xUpdateWorld
		xRenderWorld 
		
		'renderMessages()
    
	
		If helps = True Then
			xDrawImage help,10,120
		EndIf
		
		
		
		
		
		
		'xDrawImage spellbox,260,9
		'xDrawImage invbutt,286,27
		'xDrawImage charbutt,338,27
		'xDrawImage datepic,124,28
		
		'Color 128,0,0
		'Rect 920,570,20,Health+50
		
		
		'DrawImage manapic,950,550
		'DrawImage statusbox,900,520
		
		
		
		If showchar = True Then 
			'showcharinfo()
		EndIf
		
		If showinv = True Then 
			'showinventory()
		EndIf
		
		
		
		'xDrawImage pointer,xMouseX(),xMouseY()
	    xText 100,70," X " + xEntityX(camera,True) + " Y " + xEntityY(camera,True) + " Z " + xEntityZ(camera,True)
	    xText 100,110," X " + xEntityX(player,True) + " Y " + xEntityY(player,True) + " Z " + xEntityZ(player,True)
		'debugtext()	
		xText 10,10,"fps=" + lastfps
		'Text 100,100,"YOU HAVE " 
		
		'AlbaLynx_Update()
		'Vsync On Or Off
		xFlip
		'Flip True
		XClsColor 100,100,255
		XCls
		
        'xRotateEntity compass,0,xEntityYaw(compass,True),xEntityYaw(compass,True),True
         updateFPS()	
	EndIf		





	network_update()
	leavingworld=MilliSecs()-leavingworldstart
Until leavingworld>quitdelay And wanttoleave=True

leaveworld()
'meshTerrain_delete()
End





Function control_mouseLook()
	'update mouselook For this frame - TODO needs mouse smoothing
	If mouselook = True Then
		mxs = xMouseXSpeed()
		mys = xMouseYSpeed()
		
		dest_xang# = dest_xang + mys
		dest_yang# = dest_yang - mxs
	
		xang# = CurveValue (xang, dest_xang, 3)
		yang# = CurveValue (yang, dest_yang, 3)
	
		xRotateEntity player_pivot, 0, yang, 0
		xRotateEntity camera,xang,0,0
		If dest_xang > 70 Then dest_xang = 70
		If dest_xang < -70 Then dest_xang = -70
		xMoveMouse xGraphicsWidth()/2,xGraphicsHeight()/2
	EndIf
End Function

Function control_keyboardInput()
	'grab ALL keypresses here
	If xKeyHit(60) Then mouselook = Not mouselook
	
	If xKeyHit(68) Then SaveScreenshot
	
	'leave world check
	If xKeyHit(1) Then 
		wanttoleave=True
		leavingworldstart=MilliSecs()
	EndIf
	
	'help on/off
	If xKeyHit(59) Then helps = Not helps 
	
	If xKeyHit(28) Then 
		FlushKeys
		chatenabled = Not chatenabled
	EndIf

End Function

Function control_cameraPick()

'Detect Left Mouse Click
mouseClicked = xMouseHit(1)

'INVENTORY HIDE And SHOW
If mouseClicked = 1 And xImageRectOverlap(invbutt,285,27,xMouseX(),xMouseY(),1,1) 
	showinv = Not showinv
	
EndIf


'CHARACTER INFO HIDE And SHOW

If mouseClicked = 1 And xImageRectOverlap(charbutt,335,27,xMouseX(),xMouseY(),1,1) 
	showchar = Not showchar
	
EndIf


'If ENTITY PICKED ADD IT To INVENTORY

For w:weapons = EachIn Weaponsl
		If xPickedEntity() = w.entity  And mouseClicked = 1 Then 
	    xHideEntity w.entity
		PutInInventory(w.entity,w.name$,w.ID)
        EndIf
Next


	
End Function

Function control_chat()
		If chatenabled = True Then
			'If VoiceBlockForResult()=1 Then
			'	a$ = VoiceTestBlock()
			'	ctext$ = a$
			'Else
			'	a$=""
			'EndIf
			'Keyboard Input
			cKey=xGetKey()
			If cKey>32 And cKey<128
				cText=cText+Chr(cKey)
			ElseIf cKey=8 And Len(cText)>0
				cText=Left(cText,Len(cText)-1)
			ElseIf cKey=32
				cText=cText+" "
			ElseIf cKey=13 'Return is hit
				If Len(cText)>0 Then
					
					BP_UDPMessage(0,5,myname$ + ": " + cText,False,False)
					visibleMessageAdd(cText,myname,0,$ffffff,$ffffff)
					'irc_send(cText)
				EndIf
		
				If Upper(Left(cText,6))="!DRINK" Then
					Drinkbeer=1
				EndIf
		
				If Upper(Left(cText,6))="!Save" Then
					Print"character Saved"
					xCls
				EndIf
			
				cText=""
			EndIf
		EndIf
End Function

Function water_meshWaves()
	'make the terrain waves. needs To be converted To dynamic mesh instead of slow blitz terrain
	For z = 0 To WATER_GRID_SIZE-1
		For x = 0 To WATER_GRID_SIZE-1
			hite# = Sin(WaterY(z,x))
			xModifyTerrain water,x,z,Abs(hite#/2)+.5,False
			WaterY(z,x) = WaterY(z,x) + 1
		Next
	Next
End Function

Function player_Animation()
	'update player animation here
	If oldmoved = moved
		'If already moving Then dont Animate again
	Else
	
	Select moved
			Case 15
				xAnimate player,1,2,knight_A_walk,1'run
			'Case 1
				'Animate player,3,.5,knight_A_die,10'Walk Front
			Case 0
				xAnimate player,2,.1,knight_A_Idle,5'Idle
		End Select
		
	oldmoved = moved
	
	EndIf
	If Jumped =1Then
	'Animate player,2,3,knight_A_jump,10
	EndIf 
	
	If xAnimating(player) = 0		'If its Not Animating, Then go To idle
		moved = 0
	EndIf
	
	If Not xKeyDown(200)
		moved=0
	EndIf
End Function

Function player_NetPlayerAnimations()
	For p:pdata = EachIn pdatas 
'			DebugLog p\dataused + " - " + p\anim
		'IS THIS A New DATA PACKET?
		If Not p.dataused
			lastanim=p.anim
			
			
			p.x=xEntityX(p.entity)
			p.z=xEntityZ(p.entity)
			
			
			
			If (p.x<>p.oldX) Or (P.Z<>p.oldZ) 
				p.anim=15
				
				If p.x<>p.oldX Then p.oldX = p.x
				If P.Z<>p.oldZ Then p.oldZ = p.z
			

			
			Else 
						
				p.anim = 0
			
			EndIf 
			
			p.dataused=True
			'Animate PLAYER
			If lastanim<>p.anim
				Select p.anim
					Case 15
						xAnimate p.entity,1,2,knight_A_walk,1'run
					'Case 1
						'Animate player,3,.5,knight_A_die,10'Walk Front
					Case 0
						xAnimate p.entity,2,.1,knight_A_Idle,5'Idle
				End Select
			EndIf
		EndIf
		
		Next
End Function


Function sky_update()
	'updateskybox And cloud positions
	xPositionEntity mesh_skybox,xEntityX(camera,1),xEntityY(camera,1)-10,xEntityZ(camera,1)
	'PositionEntity mesh_skyboxnight,EntityX(camera,1),EntityY(camera,1)-10,EntityZ(camera,1)

	thiscloudalpha#=Int(weatherdensity)/255.0
	If currentcloudalpha >thiscloudalpha Then currentcloudalpha=currentcloudalpha-0.0005
	If currentcloudalpha <thiscloudalpha Then currentcloudalpha=currentcloudalpha+0.0005
	If currentcloudalpha >1 Then currentcloudalpha=1
	If currentcloudalpha <0 Then currentcloudalpha=0
	For cloudcount=0 To 2
		xPositionEntity cloudlayer(cloudcount),xEntityX(camera,1),xEntityY(camera,1),xEntityZ(camera,1)
		xTurnEntity cloudlayer(cloudcount),0,.01*cloudcount,0
		xEntityAlpha cloudlayer(cloudcount),currentcloudalpha
	Next
	xPositionEntity cloudplane,xEntityX(camera,1),xEntityY(camera,1)+10,xEntityZ(camera,1)
	xEntityAlpha cloudplane,currentcloudalpha/2.0'256/((255-Int(weatherdensity))+1)
	xPositionTexture cloudplanetex,Sin(MilliSecs()/10000.0),0
	xTurnEntity mesh_skybox,0,.003,0,True
	
	skydif# = Abs(12-Float(gservertime))
	
	'EntityAlpha mesh_skyboxnight,skydif/12
	
	'EntityAlpha mesh_skybox,1-(skydif/12)
	
	If 1-(skydif/12) > .5 Then
	'EntityTexture water,watercubemapDay
	Else
	'EntityTexture water,watercubemapNight
	EndIf
	
	skyadjust#=skydif/12.0
	xCameraFogMode camera, 0
	xCameraFogColor camera, (40 * (1-skyadjust)),( 60 * (1-skyadjust)),( 65 * (1-skyadjust))
	'xCameraRange camera, 1, range
	'xCameraFogRange camera, 300, range' - (200 + ((skydif/12)*400))
	locallight=100+(255.0*(1-skyadjust))
	If locallight>255 Then locallight=255
	'AmbientLight  locallight,locallight,locallight
	xAmbientLight  175,175,175
	
	
	'########################################################################lightning flash
	If flash>150 And flash>Locallight Then
		xAmbientLight flash,flash,flash
	End If	
	
	Update_Lightning(camera)
	'TurnEntity  moon_piv,.003,0,0

End Function

Function world_soundAmbient()
	'trigger ambient world sounds based on time of day - TODO no birds in rain etc And move To server
	If gservertime>17 Or gservertime<7 Then
		If Rand(1,2000)=1 Then xPlaySound(nighthowl)
	EndIf
	If gservertime>17 Or gservertime<7 Then 
		'If Rand(1,500)=1 Then xPlaySound(ambiant2)
	EndIf
	If gservertime>8 Or gservertime<15 Then 
 		If Rand(1,500)=1 Then xPlaySound(ambiant1)
 	EndIf
End Function

Function network_update()
	'update all network For this frame
	If MilliSecs()-sendcounter>500 Then
		If initilizedplayerposition=True
			packet$ = BP_FloatToStr(xEntityX(player_pivot,True)) + BP_FloatToStr(xEntityY(player_pivot,True)) + BP_FloatToStr(xEntityZ(player_pivot,True)) + BP_FloatToStr(xEntityYaw(player_pivot,True)+180)
			BP_UDPMessage(0,1,packet$,True,False)	'broadcast message, of Type 1, contents = packet$, reliable False
		EndIf
		sendcounter = MilliSecs()
	End If


	BP_UpdateNetwork()
	HandleMessages()
End Function

Function leaveworld()
	'disconnect And leave the game world
	
	'Delete name sprites
	For p:pdata = EachIn pdatas
		DeleteFile p.name+".png"
	Next
	
	'quit message broadcast
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
	
	xDrawImage characterinfo,10,(yvalue / 2) - 55
	
	xText 148,(yvalue / 2) - 40,myname$ 
	xText 148,(yvalue / 2) - 14,level
	xText 148,(yvalue / 2) + 13,experiance
	xText 148,(yvalue / 2) + 42,Health
	xText 148,(yvalue / 2) + 66,mana
	xText 148,(yvalue / 2) + 90,Strength
	xText 148,(yvalue / 2) + 114,Dexterity
	xText 148,(yvalue / 2) + 137,Consitution
	xText 148,(yvalue / 2) + 161,luck
	xText 148,(yvalue / 2) + 185,hitpoints
	xText 148,(yvalue / 2) + 209,intelligence
	xText 148,(yvalue / 2) + 233,hunger
	xText 148,(yvalue / 2) + 257,energy
	
End Function



Function showinventory()
	
	xDrawImage inv,(xvalue * 2) - 280 ,(yvalue / 2) 
	
	
For v:inventory = EachIn inventories
objects = v.typeobj
name$ = v.name$ 
Select objects = v.typeobj
	Case 1 ' Axes
 Select name$
	Case "Celtic Axe"
		xDrawImage Celticaxeimg,(xvalue * 2) - 250 ,(yvalue / 2) + 30
 End Select
Case 2 ' Swords

Case 3 ' Staffs

Case 4 ' Shields

Case 5 ' Armor

Case 6 ' bows,crossbows
End Select
Next

End Function 

Function moveenemies()

For n:npcs = EachIn NPCSL

nx=xEntityX(n.entity)
nz=xEntityZ(n.entity)

terheight= xTerrainHeight(Terrain,nx,nz) 
spoty#=xTerrainY(Terrain,nx,terheight,nz)

  If xEntityY(n.entity) < -100 Then 
	xPositionEntity n.entity,nx,spoty#+80,nz
  EndIf	

xEntityAutoFade n.entity,300,1000
xRotateMesh n.entity,0,90,0

If xEntityDistance(n.entity,player_pivot) > 50 Then
thisyaw#=ATan2(xEntityX(n.entity)-nx,xEntityZ(n.entity)-nz)
'RotateEntity n\entity,0,360-thisyaw#,0
xMoveEntity n.entity,0,0,.5
EndIf



If xEntityDistance(n.entity,player_pivot) < 50 Then

xPointEntity n.entity,player_pivot
Select n.side

Case 1 
xMoveEntity n.entity,0,0,.5
Case 2

irc_log "*** Hello Young Lad ***",$FFFF00
End Select

EndIf


If xEntityDistance(n.entity,player_pivot) < 10 Then
Select n.side
Case 1 
Health = Health - .1

Case 2

irc_log "*** Hello Young Lad ***",$FFFF00
End Select

EndIf

Next
End Function






'TEST
Function RenderWater()

	HideEntities()
	xCameraProjMode camera,0
	xCameraProjMode FXCamera,1
	
	wdb=1-wdb
		
	
			If waterdirection=1
			xFlipMesh water
			xEntityAlpha water,1
			xEntityColor water,155,200,255

		EndIf	
		waterdirection=-1
		
		xPositionEntity FXCamera,-xEntityX(player),xEntityY(player)-2,xEntityZ(player)
		
		
		If wdb
			'do Left view	
			xSetCubeFace WaterMapTexture,0
			xRotateEntity FXCamera,0,-90,180
			xRenderWorld
			xCopyRect 0,0,WaterMapSize,WaterMapSize,0,0,xBackBuffer(),xTextureBuffer(WaterMapTexture)
			'do forward view
			xSetCubeFace WaterMapTexture,1
			xRotateEntity FXCamera,0,0,180
			xRenderWorld
			xCopyRect 0,0,WaterMapSize,WaterMapSize,0,0,xBackBuffer(),xTextureBuffer(WaterMapTexture)
		Else
			'do Right view	
			xSetCubeFace WaterMapTexture,2
			xRotateEntity FXCamera,0,90,180
			xRenderWorld
			xCopyRect 0,0,WaterMapSize,WaterMapSize,0,0,xBackBuffer(),xTextureBuffer(WaterMapTexture)
			'do backward view
			xSetCubeFace WaterMapTexture,3
			xRotateEntity FXCamera,0,180,180
			xRenderWorld
			xCopyRect 0,0,WaterMapSize,WaterMapSize,0,0,xBackBuffer(),xTextureBuffer(WaterMapTexture)
		EndIf
		
		'do down view
		xSetCubeFace WaterMapTexture,5
		xRotateEntity FXCamera,-90,0,180
		xRenderWorld
		xCopyRect 0,0,WaterMapSize,WaterMapSize,0,0,xBackBuffer(),xTextureBuffer(WaterMapTexture)
	



	xCameraProjMode FXCamera,0
	xCameraProjMode camera,1
	ShowEntities()


	gs=xGetSurface(water,1)
	Freq#=MilliSecs()/4
	For i=0 To xCountVertices(gs)-1
		TVertex[i].y#=Sin(freq+TVertex[i].x#*500+TVertex[i].z#*300)*1.2
		xVertexCoords gs,i,TVertex[i].x#,-TVertex[i].y#,TVertex[i].z#
	Next

	If xEntityY(camera,1)<-2 underwater=1 Else underwater=0

	

	
End Function


Function AddEntity(ent)
	e:entity=New entity
	e.ent=ent
End Function
Function HideEntities()
	For e:entity=EachIn entities
		xHideEntity e.ent
	Next
End Function
'----------------------------------------------------------------------------------
Function ShowEntities()
	For e:entity=EachIn entities
		xShowEntity e.ent
	Next

End Function
'~IDEal Editor Parameters:
'~C#Blitz3D