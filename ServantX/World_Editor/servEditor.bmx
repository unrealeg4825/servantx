'==================================================================
'Project Title:     ServED
'Author:     Matthew LaVoice
'Email:            mattlavoice@binary-people.com	        
'Version:    1.0      
'Date:         9/9/03     
'Notes:       Made For The Servant mmorpgFunction (dir$)
'                   
'                   
'==================================================================
Import xorsteam.xors3d
'AlbaLynx GUI header
Import albalynx.albalynx

'GUI To Engine connector
Import albalynx.connect_xors3d
Import bah.database
Import bah.dbsqlite

xGraphics3D 1024,768,32
xAntiAlias True
xSetTextureFiltering TF_ANISOTROPIC


'/* Connect GUI To Game Engine */
AlbaLynxInput_Connect()

'/* GUI start */
AlbaLynx_Initiate( xGetRenderWindow(), xGetDevice() );

'/* Creating log with level: all events */
alAddObserverHTMLLog("AlbaLynx.html", ALLEVEL_ALL);
Local objLoaded:Int = alLoadGTemplates("../Media/gui/bubble.xml");
Local dtop:Int		= alCreateGDesktop( "AlbaLynx v." + AlbaLynx_Version() );
'SetBuffer BackBuffer()
'xHidePointer 

'Include "icons.bb"
'Include "blitzui.bb"
'LoadColourScheme( "slate.cs" )
'Include "opensavedialog.bb"

'Include "particlelib.bb"

Global value:Int
Global startx:Int
Global starty:Int
Global amount:Int
Global dest_xang:Float 
Global mys:Int
Global dest_yang:Float 
Global mxs:Int
Global xang:Float 
Global yang:Float

'DATABASE STUFFS
Global DBC:TDBConnection

Global controlType:Int   = 0
Global selectMask:Int    = 0
Global controllPosX# = 0.0
Global controllPosY# = 0.0
Global controllPosZ# = 0.0
Global mouseSpeedX   = 0
Global mouseSpeedY   = 0
Global Buildings:TList = New TList
Global TERRAIN:Int




Type Building

	Method New()
	
		ListAddLast(Buildings,Self)
		
	End Method
	
	Field x:Float,y:Float,z:Float
	Field entity:Int
	Field FileName:String
	Field yaw:Int,pitch:Int,roll:Int
	Field scaleX:Float,scaleY:Float,scaleZ:Float

End Type

Global myemits:TList = New TList

Type myemit
	
	Method New()
	
		ListAddLast(myemits,Self)
		
	End Method
	
	Field x:Float,y:Float,z:Float
	Field entity:Int
End Type

Global particleblocks:TList = New TList

Type particleblock

	Method New()
	
		ListAddLast(particleblocks,Self)
		
	End Method
	
	Field x:Float,y:Float,z:Float
	Field entity:Int
End Type

Global grasss:TList = New TList

Type grass

	Method New()
	
		ListAddLast(grasss,Self)
		
	End Method
	
	Field x:Float,y:Float,z:Float
	Field entity:Int
	Field FileName:String
End Type

Global MX:Float,MY:Float,MZ:Float
Global pentity:Int
Global turnPentity:Int
Global scalex:Float,scaley:Float,scalez:Float




Global camera = xCreateCamera()
xPositionEntity camera,200,80,50
xEntityType camera,2
xEntityRadius camera,1



xCameraClsColor camera,80,130,235
xCameraFogMode camera,1
xCameraRange camera,1,6500
xCameraFogRange camera,5000,6000
xCameraFogColor camera,80,130,235

light= xCreateLight()


CreateDatabase()

Rem
Local btn_exit:Int	= alCreateGButton(dtop , "Exit", xGraphicsWidth()-100, xGraphicsHeight()-50,70, 30);
Local label_input = alCreateGStatic(dtop, "Enter Zone ID:", 10, 50, 100, 20, 0, "LabelJ");
Local fm_zoneid		= alCreateGTextBox(dtop, "", 120, 50, 100, "", 3, "0-9");
While ZONEID$ = ""
XClsColor 200,200,200
xCls
AlbaLynx_Update()
ZONEID$ = alGetValueS(fm_zoneid)
xFlip
Wend
alFreeElement (label_input)
alFreeElement (fm_zoneid)


'ZONEID$ = Input$("Please enter the number of the Zone that you wish to edit ?: ")

alSetPosition( btn_exit, alGetWidth(dtop) - alGetWidth(btn_exit) - 20, alGetHeight(dtop) - alGetHeight(btn_exit) - 20);
End Rem

terraedit = 1

'Load fonts And  cursors
'And collect information
'Initialise(  )

'Window


	menu = alCreateGMenu();
	mf_new = alAddMenuItem(menu, "File/New", "Ctrl+N");
	mf_open = alAddMenuItem(menu, "File/Open", "Ctrl+O");
	mf_save = alAddMenuItem(menu, "File/Save", "Ctrl+S", "AlbaLynx");
	mf_import = alAddMenuItem(menu, "File/Import Legacy Zone")
	mf_exit = alAddMenuItem(menu, "File/Exit", "Ctrl+Q");
	m_edit = alAddMenuItem(menu, "Models");
	m_view = alAddMenuItem(menu, "Models/Load Models");
	m_tool = alAddMenuItem(menu, "Tools");
	m_model = alAddMenuItem(menu, "Tools/Model Properties");
	m_treem = alAddMenuItem(menu, "Tools/Tree Maker");
	m_particles = alAddMenuItem(menu, "Tools/Particles");
	
	


Global window,chk002,lbl004,sld001
Global win001,btn001,lbl001,lbl002,lbl003
Global txt001,txt002,txt003

Global postool,rottool,scaletool

Global win002,gravbox,htab_paramset,btn002,Flamechk,Smokechk,Yscaletxt
Global Xscaletxt,Agetxt,Splitdelaytxt,zacceltxt,Yacceltxt,XaccelTxt,txt004

	
Rem

tree001 = TreeView( 148, 6, 0, 0, 20, 20, 10, 0 )



'Window
win001 = Window( 553, 667, 454, 101, "Particleinator", "0", 1, 0, 0, 0 )
gravbox = Tab( 364, 7, 0, 0 )
CloseTab(  )

createparticle = Button( 6, 45, 59, 15, "Make", "0", 1, 0, 0 )
Flamechk = CheckBox( 6, 23, "Smoke", 0 )
Smokechk = CheckBox( 6, 5, "Flames", 0 )
lbl009 = Label( 297, 56, "Y scale", 0 )
lbl008 = Label( 297, 32, "X scale", 0 )
lbl007 = Label( 296, 4, "Gravity", 0 )
lbl006 = Label( 201, 56, "Age", 0 )
lbl005 = Label( 187, 32, "Split Delay", 0 )
lbl004 = Label( 189, 3, "Distortion", 0 )
lbl003 = Label( 84, 57, "Z Accel", 0 )
lbl002 = Label( 84, 32, "Y Accel", 0 )
lbl001 = Label( 81, 6, "X Accel", 0 )
'txt001 = TextBox( 340, 101, 64, 17, 0, 0, 18, 10, 0 )
'SendMessage( txt001, "TM_SETTEXT", 0, "" )
Yscaletxt = TextBox( 340, 50, 69, 21, 0, 0, 18, 10, 0 )
SendMessage( Yscaletxt, "TM_SETTEXT", 0, "" )
Xscaletxt = TextBox( 339, 26, 69, 21, 0, 0, 18, 10, 0 )
SendMessage( Xscaletxt, "TM_SETTEXT", 0, "" )
Agetxt = TextBox( 238, 50, 47, 21, 0, 0, 18, 10, 0 )
SendMessage( Agetxt, "TM_SETTEXT", 0, "" )
Splitdelaytxt = TextBox( 238, 26, 48, 21, 0, 0, 18, 10, 0 )
SendMessage( Splitdelaytxt, "TM_SETTEXT", 0, "" )
Disttxt = TextBox( 236, 1, 51, 21, 0, 0, 18, 10, 0 )
SendMessage( Disttxt, "TM_SETTEXT", 0, "" )
zacceltxt = TextBox( 130, 51, 52, 21, 0, 0, 18, 10, 0 )
SendMessage( zacceltxt, "TM_SETTEXT", 0, "" )
Yacceltxt = TextBox( 129, 27, 54, 21, 0, 0, 18, 10, 0 )
SendMessage( Yacceltxt, "TM_SETTEXT", 0, "" )
XaccelTxt = TextBox( 129, 2, 53, 21, 0, 0, 18, 10, 0 )
SendMessage( XaccelTxt, "TM_SETTEXT", 0, "" )
txt001 = TextBox( 340, 1, 20, 15, 0, 0, 18, 10, 1 )
SendMessage( txt001, "TM_SETTEXT", 0, "" )

End Rem
'*******Changes the working directory To the Engine Directory******




event:sEvent = New sEvent
'1 Key Esc
While Not KeyHit(1)

xCls

mx#=0
my#=0
mz#=0
	
'Mouse Right Button, 57 Key Space	
If xMouseHit(2) And xKeyDown(57)=0  

	
	
	If pEntColor > 0 Then xEntityColor (pEntColor, 255, 255, 255)
	
	picked=xCameraPick(camera,xMouseX(),xMouseY()) 


	If picked > 0
		pEntColor = xPickedEntity ()
		xEntityColor (pEntColor, 255, 130, 130)
	EndIf	
		
	
	
EndIf	
	


'211 Key Delete
If xKeyHit(211) And picked>0 

	'FreeEntity eEntColor
	xFreeEntity picked
	For check:building = EachIn buildings
		If check.entity = picked Then ListRemove(buildings,check)
	Next
	
	For chek:grass = EachIn grasss
		If chek.entity = picked Then ListRemove(grasss,chek)
	Next
	
	picked = 0
	
	pEntColor = 0
	
	
EndIf	



	
If turnpentity = False Then
'205 Key Right
If xKeyDown(205)=True Then mx#=+.5
'203 Key Left
If xKeyDown(203)=True Then mx#=-.5
'208 Key Down
If xKeyDown(208)=True Then mz#=-.5
'200 Key Up
If xKeyDown(200)=True Then mz#=+.5
'30 Key A
If xKeyDown(30) Then	my# =+.5
'44 Key Z
If xKeyDown(44) Then my# =-.5
pentity = xPickedEntity()
'mx = EntityX(pentity)
'my = EntityY(pentity)
'mz = EntityZ(pentity)
 If pentity > 0 And picked > 0 Then
 xMoveEntity pentity,MX#,MY#,MZ#
 EndIf 
EndIf

If turnPentity = True Then
 '205 Key Right
 If xKeyDown(205)=True Then mx#=+.5
 '203 Key Left
 If xKeyDown(203)=True Then mx#=-.5
 '208 Key Down
 If xKeyDown(208)=True Then mz#=-.5
 '200 Key Up
 If xKeyDown(200)=True Then mz#=+.5
 '30 Key A
 If xKeyDown(30) Then my# =+.5
 '44 Key Z
 If xKeyDown(44) Then my# =-.5
 pentity = xPickedEntity()
  If pentity > 0 And picked > 0 Then
   xTurnEntity pentity,mz#,mx#,my#
  EndIf 
EndIf



xUpdateWorld
xRenderWorld
xDrawGrid(0,0, 10, 800);
'Draw the GUI And update the mouse
'UpdateGUI(  )
AlbaLynx_Update();

	
UserInput()

'If KeyDown(57)=0 Then
'userinput()
'EndIf


While( alGetEvent(event) )


Select event.type_

	Case ALEVENT_CLICK
		Select event.object_
		
			Case m_view
				filter$="3ds:3ds;Milkshape:ms3d;Autodesk FBX:fbx;B3D:b3d"
				FileName$ = RequestFile( "Model",filter$ )
				If FileName$ <> "" Then
					If Mesh xFreeEntity Mesh
					placebuilding(FileName$)
				EndIf
		
			Case mf_open
				filter$="Servant Zone:t3x"
				filename$=RequestFile( "Open Zone",filter$ )
				If filename$ <> "" Then
					Load_zone(filename$)
				EndIf			
		
			Case mf_save
				filter$="Servant Zone:t3x"
				filename$=RequestFile( "Save Zone as",filter$, True )
				If filename$ <> "" Then
					Save_zone(filename$)
				EndIf
		
			Case mf_import
				dir$ = RequestDir$( "Select Zone Folder" )
				If dir$ <> "" Then
					load_legacy_zone(StripAll(dir$))
				EndIf
			Case mf_exit
				'/* Disconnect from engine */
				AlbaLynxInput_Disconnect();
				'/* Release GUI */
				AlbaLynx_Free();
				End
			
			Case m_model
				If alCheckExistence(window) = False Then
					Create_Model_Props()
				EndIf
			
			Case m_treem
				If alCheckExistence(win001) = False Then
					Create_Tree_Maker()
				EndIf				
				
			Case m_particles
				If alCheckExistence(win002) = False Then
					Create_particle_tool()
				EndIf				
			
			Case sld001
				pentity = xPickedEntity()
				svalue# = Float(alGetValueI(sld001))
				xEntityAlpha pentity,svalue#*0.01	
				
			Case btn001
				StartX = Int(alGetValueS(txt001))
				StartY = Int(alGetValueS(txt002))
				amount = Int(alGetValueS(txt003))
				placetree(startx,starty,amount)				
			
			Case postool
				controlType = 0
			
			Case rottool
				controlType = 1
				
			Case scaletool
				controlType = 2
			
			Rem
			Case scalenowbutton
			scalex# = SendMessage(txt021, "TM_GETTEXT")
			scaley# = SendMessage(txt022, "TM_GETTEXT")
			scalez# = SendMessage(txt023, "TM_GETTEXT")
			pentity = PickedEntity()
			End Rem
			
		End Select

End Select

Wend
Rem
		
Case mnui002
createbldfile(ZONEID$)

					
Case createparticle 
'xacc# = SendMessage(xacceltxt,"TM_GETTEXT")
'yacc# = SendMessage(yacceltxt,"TM_GETTEXT")
'zacc# = SendMessage(zacceltxt,"TM_GETTEXT")
'distortion# = SendMessage( Disttxt,"TM_GETTEXT")
'spitDelay# =SendMessage(Splitdelaytxt,"TM_GETTEXT")'
'particleMaxAge# =SendMessage( Agetxt,"TM_GETTEXT")
'useGrav = SendMessage( GravTxt,"TM_GETTEXT")
'xScale# = SendMessage( Xscaletxt,"TM_GETTEXT")
'yScale# = SendMessage( Yscaletxt ,"TM_GETTEXT")
'MostSolid = 1
'fx = 2
 
'maxAge# = SendMessage( Agetxt,"TM_GETTEXT") 
'm.myemit= New myemit
'm\entity = CreateSphere()
'm\x# = EntityX(camera)
'm\y# = EntityY(camera)
'm\z# = EntityZ(camera)
'PositionEntity m\entity,m\x#,m\y#,m\z#
'createGenerator (m\X#,M\y#,M\z#,xacc#,yacc#,zacc#,distortion#,spitDelay#,particleMaxAge#,useGrav,myGFX$,xScale#,yScale#,MostSolid,fx=2)
'Function createGenerator (x#,y#,z#,xacc#=0,yacc#=0,zacc#=0,distortion#=0.5,spitDelay=100,particleMaxAge=5,useGrav=True,myGFX$="fire.png",xScale#=0.1,yScale#=0.11,MostSolid#=1,fx=2,maxAge=-1)
'Funtion found in Particlelib.bb

placeparticleblock()


Case chk002
turnPentity = SendMessage( chk002, "CM_GETCHECKED")

Case flamechk
myGFX$= "fire.png"
Case smokechk
myGFX$= "smoke.bmp"
           
Case sld001
pentity = PickedEntity()
value = SendMessage( sld001, "SM_GETVALUE")
EntityAlpha pentity,value /60.


'Scale Code

Case scalenowbutton
scalex# = SendMessage(txt021, "TM_GETTEXT")
scaley# = SendMessage(txt022, "TM_GETTEXT")
scalez# = SendMessage(txt023, "TM_GETTEXT")
pentity = PickedEntity()

If pentity <> 0

	For b.building = Each building
	
		If b\entity = pentity 
	
			b\ScaleX# =scalex#
			b\ScaleY# =scaley#
			b\ScaleZ# =scalez#
			
			ScaleEntity pentity,scalex#,scaley#,scalez#

		
		EndIf	
	
	Next
	
EndIf


End Select
End Select
	
'Draw the mouse
DrawMouse(  )
updateGenerators()
updateParticles()
	
'Reset all GUI events
ResetEvents( )
Color 255,255,255
End Rem
'57 Key Space
If xKeyDown(57)
 
	'TranslateEntity camera,0,0,0
	control_mouseLook()
Else

	mouseSpeedX = xMouseXSpeed()
	mouseSpeedY = xMouseYSpeed()
	mxs = mouseSpeedX
	mys = mouseSpeedY	
EndIf	
  control_object()

xFlip
Wend
'Destroy()
End



Function control_object()

	If pentity <> 0 Then
	
		x# = xEntityX(pentity)
		y# = xEntityY(pentity)
		z# = xEntityZ(pentity)	
	
		Select controlType
			Case 0
				mask = xCheckMovementGizmo(x#, y#, z#, camera, xMouseX(), xMouseY())
				If Not xMouseDown(1)
					selectMask   = mask
					controllPosX = x
					controllPosY = y
					controllPosZ = z
				EndIf
				xDrawMovementGizmo(x#, y#, z#, selectMask)
				'used_controller$ = "Used move controler"
			Case 1
				mask = xCheckRotationGizmo(x#, y#, z#, camera, xMouseX(), xMouseY())
				If Not xMouseDown(1) 
					selectMask   = mask
					controllPosX = x
					controllPosY = y
					controllPosZ = z
					deltaX#      = 0.0
					deltaY#      = 0.0
					deltaZ#      = 0.0
				EndIf
				xDrawRotationGizmo(x#, y#, z#, selectMask, deltaX, deltaY, deltaZ)
				'used_controller$ = "Used rotate controler"
			Case 2
				mask = xCheckScaleGizmo(x#, y#, z#, camera, xMouseX(), xMouseY())
				If Not xMouseDown(1) 
					selectMask   = mask
					controllPosX = x
					controllPosY = y
					controllPosZ = z
					deltaX       = 1.0
					deltaY       = 1.0
					deltaZ       = 1.0
					scaleXInit   = xEntityScaleX(pentity)
					scaleYInit   = xEntityScaleY(pentity)
					scaleZInit   = xEntityScaleZ(pentity)
				EndIf
				xDrawScaleGizmo(x#, y#, z#, selectMask, deltaX, deltaY, deltaZ)
				'used_controller$ = "Used scale controler"
			Default
				'used_controller$ = ""
			End Select
	
			If xMouseDown(1) And selectMask <> 0
				useX     = selectMask & 1
				useY     = selectMask & 2
				useZ     = selectMask & 4
				useG     = selectMask & 8
				factorX# = 0.7 / Float(xGraphicsWidth())
				factorY# = 0.7 / Float(xGraphicsHeight())
				Select controlType
				' if movement gizmo is used
				Case 0
					' move controlled entity
					dx#   = controllPosX - xEntityX(camera, True)
					dy#   = controllPosY - xEntityY(camera, True)
					dz#   = controllPosZ - xEntityZ(camera, True)
					dist# = Sqr(dx * dx + dy * dy + dz * dz)
					' x-axis
					If useX
						move# = ComputeMove(camera, 10.0, 0.0, 0.0) * factorX * dist
						xTranslateEntity pentity, move, 0.0, 0.0, False
					EndIf
					' y-axis
					If useY
						move# = ComputeMove(camera, 0.0, 10.0, 0.0) * factorY * dist
						xTranslateEntity pentity, 0.0, move, 0.0, False
					EndIf
					' z-axis
					If useZ
						move# = ComputeMove(camera, 0.0, 0.0, 10.0) * factorX * dist
						xTranslateEntity pentity, 0.0, 0.0, move, False
					EndIf
				' if scaling gizmo is used
				Case 2
					' scale controlled entity
					dx#   = controllPosX - xEntityX(camera, True)
					dy#   = controllPosY - xEntityY(camera, True)
					dz#   = controllPosZ - xEntityZ(camera, True)
					dist# = Sqr(dx * dx + dy * dy + dz * dz)
					' x-axis
					If useX
						move#      = ComputeMove(camera, 10.0, 0.0, 0.0) * factorX * dist
						deltaX     = deltaX     + move
						scaleXInit = scaleXInit + move
						xScaleEntity pentity, scaleXInit, scaleYInit, scaleZInit
					EndIf
					' y-axis
					If useY
						move#      = ComputeMove(camera, 0.0, 10.0, 0.0) * factorY * dist
						deltaY     = deltaY     + move
						scaleYInit = scaleYInit + move
						xScaleEntity pentity, scaleXInit, scaleYInit, scaleZInit
					EndIf
					' z-axis
					If useZ
						move#      = ComputeMove(camera, 0.0, 0.0, 10.0) * factorX * dist
						deltaZ     = deltaZ     + move
						scaleZInit = scaleZInit + move
						xScaleEntity pentity, scaleXInit, scaleYInit, scaleZInit
					EndIf
				' if rotation gizmo is used
				Case 1
					' rotate controlled entity
					' x-axis
					If useX
						move#  = ComputeMove(camera, 0.0, -10.0, 0.0)
						deltaX = deltaX + move
						xTurnEntity pentity, move, 0.0, 0.0, True
					EndIf
					' y-axis
					If useY
						move#  = ComputeMove(camera, -10.0, -10.0, 0.0);
						deltaY = deltaY + move
						xTurnEntity pentity, 0.0, move, 0.0, True
					EndIf
					' z-axis
					If useZ
						move#  = ComputeMove(camera, -10.0, 0.0, 0.0);
						deltaZ = deltaZ + move
						xTurnEntity pentity, 0.0, 0.0, move, True
					EndIf
				End Select
			EndIf
	
	
	
	
	
	
	
	EndIf

End Function

Function placetree(StartX#,Starty#,Count)
	'place trees on the map
	For grassed = 0 To Count
		For icount = 1 To 4
			temp$="tree"
			If icount<10 Then temp$=temp$
			temp$=temp$ + icount
			grassX# = Rnd(StartX,Starty)
			grassZ# = Rnd(StartX,Starty)
			If terrain <> 0 Then
				terheight#= xTerrainHeight(terrain,grassX#,grassz#) 
				grassy# = xTerrainY(terrain,grassx,terheight#,grassz#)
			Else
				grassy# = xEntityY(camera)
			EndIf
			g:grass = New grass
			
			g.FileName$ = "..\Media\Trees\" + temp$ + ".b3d"
			
			g.entity=xLoadMesh(g.FileName$)
			
			xPositionEntity g.entity,grassx,grassy,grassZ
			xEntityPickMode g.entity,2
			
			
			xScaleEntity g.entity,.3,.3,.3
			xRotateEntity g.entity,0,Rnd(1,90),0
		Next
	Next
End Function


Function userInput()
'Catch user Input


'2 Key F1
If xKeyDown(59) Then xTurnEntity camera,0,1,0
'3 Key F2
If xKeyDown(60) Then xTurnEntity camera,0,-1,0


'61 Key F3
'If xKeyHit(61) Then Wireframe True
'62 Key F4
'If xKeyHit(62)Then Wireframe False
'77 Num Right
If xKeyDown(77) Then xMoveEntity camera,4,0,0
'75 Num Left
If xKeyDown(75) Then xMoveEntity camera,-4,0,0
'72 Num Up
If xKeyDown(72) Then xMoveEntity camera,0,4,0
'76 Num Down/Middle
If xKeyDown(76) Then xMoveEntity camera,0,-4,0
'74 Num Subtract
If xKeyDown(74) Then xMoveEntity camera,0,0,-4
'78 Num Add
If xKeyDown(78) Then xMoveEntity camera,0,0,4
'82 Num 0/Ins
If xKeyDown(82) Then xTurnEntity camera,4,0,0
'83 Num Decimal/Del
If xKeyDown(83) Then xTurnEntity camera,-4,0,0

'57 Key Space
If xKeyDown(57)
	'Left Button
	If xMouseDown(1) Then xMoveEntity camera,0,0,4
	'Right Button
	If xMouseDown(2) Then xMoveEntity camera,0,0,-4
	
EndIf	
	
End Function


Function placebuilding(model$)
'place a New model on the map

b:building = New building
b.entity = xLoadMesh(model$)

xMoveEntity camera,0,0,50

b.x = xEntityX(camera)
b.y = xEntityY(camera) 
b.z = xEntityZ(camera)
If terrain <> 0 Then

terheight#= xTerrainHeight(terrain,xEntityX(camera),xEntityZ(camera)) 
grassy# = xTerrainY(terrain,xEntityX(camera),terheight#,xEntityZ(camera))

Else
grassy# = xEntityY(camera)
EndIf
b.scaleX# =0.3
b.scaleY# =0.3
b.scaleZ# =0.3


xScaleEntity b.entity, .3,.3,.3
xEntityPickMode b.entity,2
Print model$
b.FileName$ = Replace(model$,Replace(AppDir$+"/","/","\"),"")'fullToLocalPath (CurrentDir$(),model$)
Print b.FileName$
hit2 = False
xNameEntity(b.entity,"Building")
xPositionEntity b.entity,xEntityX(camera),grassy,xEntityZ(camera)

xMoveEntity camera,0,0,-50




End Function

Function fullToLocalPath$(root$,fullpath$)
'takes the apps root And the full path And returns 
'only the subdirs from the full path
'If the root isn't in the full path then the whole 
'full path is returned
rootpos=Instr(fullpath$,root$)
If rootpos Then
Return Mid(fullpath$,rootpos+Len(root$))
EndIf
	
'root Not in full, Return full
Return fullpath$
End Function

Rem

Function placeparticleblock()
p.particleblock = New particleblock
p\entity = CreateCube()
EntityPickMode p\entity,2

MoveEntity camera,0,0,100

p\x = EntityX(camera)
p\y = EntityY(camera) 
p\z = EntityZ(camera)
PositionEntity p\entity,EntityX(camera),EntityY(camera)-18,EntityZ(camera)

MoveEntity camera,0,0,-100


End Function



Function createBldfile(ZoneNumber$)


buildings = WriteFile("Media\Zone\" + ZoneNumber$ + "\buildings" + ZoneNumber$ + ".T3d")
For b.building = Each building
WriteString buildings,b\FileName$
WriteFloat buildings,EntityX(b\entity)
WriteFloat buildings,EntityY(b\entity)
WriteFloat buildings,EntityZ(b\entity)
WriteFloat buildings,EntityPitch(b\entity)
WriteFloat buildings,EntityYaw(b\entity)
WriteFloat buildings,EntityRoll(b\entity)

WriteFloat buildings,b\scaleX#
WriteFloat buildings,b\scaleY#
WriteFloat buildings,b\scaleZ#


Next
CloseFile(buildings)

objectsfile$ = "Media\Zone\" + ZoneNumber$ + "\Obj" + ZoneNumber$ + ".T3d"


Objects = WriteFile(objectsfile$)

For g.grass = Each grass
WriteString Objects,g\FileName$
WriteFloat Objects,EntityX(g\entity)
WriteFloat Objects,EntityY(g\entity)
WriteFloat Objects,EntityZ(g\entity)

Next
CloseFile(objects)

particless = WriteFile("Media\Zone\" + ZoneNumber$ + "\Particles" + ZoneNumber$ + ".T3d")
For p.particleblock = Each particleblock
WriteFloat particless,EntityX(p\entity)
WriteFloat particless,EntityY(p\entity)
WriteFloat particless,EntityZ(p\entity)
Next
CloseFile(particless)

End Function


End Rem

Function load_legacy_zone(ZONEID$)

ChangeDir ".."


TERRAIN=xLoadTerrain("Media\Zone\"+ZONEID$+"\lvl_hmap"+ZONEID$+".bmp")
xNameEntity(terrain,"terrain")
tex2 = xLoadTexture("Media\Zone\"+ZONEID$+"\lvl_detail"+ZONEID$+".bmp",1)
grasst = xLoadTexture("Media\Zone\"+ZONEID$+"\lvl_tmap"+ZONEID$+".jpg",1)

'xScaleTexture grasst,256,256
xScaleEntity terrain,10,300,10
xPositionEntity terrain,0,0,0,True
xScaleTexture tex2,0.01,0.01
xTerrainDetail terrain,2000


xEntityTexture terrain,grasst

xEntityTexture terrain,tex2,0,1




xEntityType terrain,1

xCollisions 1,2,2,2
xCollisions 2,1,2,2



turnPentity = False 


buildingsf:TStream = ReadFile("Media\Zone\"+ZONEID$+"\buildings"+ZONEID$+".T3d")
While Not Eof(buildingsf)
	b:building = New building
	flen = ReadInt(buildingsf)
	b.FileName=ReadString(buildingsf,flen)
	If b.FileName > 0 Then
	'TextureFilter "tree",4
	b.entity=xLoadMesh(b.FileName)
	b.x=ReadFloat(buildingsf)
	b.y=ReadFloat(buildingsf)
	b.z=ReadFloat(buildingsf)
	b.pitch=ReadFloat(buildingsf)
	b.yaw=ReadFloat(buildingsf)
	b.roll=ReadFloat(buildingsf)
		
	b.scaleX# =ReadFloat(buildingsf)
	b.scaleY# =ReadFloat(buildingsf)
	b.scaleZ# =ReadFloat(buildingsf)

	xPositionEntity b.entity,b.x,b.y,b.z
	xRotateEntity b.entity,b.pitch,b.yaw,b.roll
	xEntityType b.entity,1
	
	xScaleEntity b.entity,b.scaleX#,b.scaleY#,b.scaleZ#
	'ScaleEntity b\entity,.3,.3,.3
		
	xEntityPickMode b.entity,2
	
	'EntityAutoFade b\entity,700,900	
	
	EndIf
Wend
CloseFile(buildingsf)


Objects:TStream = ReadFile("Media\Zone\"+ZONEID$+"\Obj"+ZONEID$+".T3d")
While Not Eof(Objects)
	g:grass = New grass'=
	glen = ReadInt(Objects)
	g.FileName$=ReadString(Objects,glen)

	If g.FileName$ > 0 Then
	'TextureFilter "tree",4
	g.entity=xLoadMesh(g.FileName$)
	g.x=ReadFloat(Objects)
	g.y=ReadFloat(Objects)
	g.z=ReadFloat(Objects)
	'g\yaw=ReadFloat(treefile)
	
		
	xPositionEntity g.entity,g.x,g.y,g.z
	xRotateEntity g.entity,0,Rnd(0,360),0
	xEntityType g.entity,1
		
	xScaleEntity g.entity,.3,.3,.3
	
	xEntityPickMode g.entity,2

	
	'EntityTexture g\entity,tex1
	'EntityAutoFade g\entity,700,900
	EndIf	
Wend
CloseFile(Objects)

End Function

Function Load_zone(xmlfilename$)

	Local Doc:xmlDocument = New xmlDocument
	Doc.Load(xmlfilename$)
	Local DocRoot:xmlNode = Doc.Root:xmlNode()
	
	If DocRoot.HasChildren() Then
		Local cnode:xmlNode = DocRoot.FirstChild()
		While cnode <> Null
		
			Select cnode.Name
			
				Case "BUILDING"
					If cnode.HasChildren()
					
						Local bnode:xmlNode = cnode.FirstChild()
						While bnode <> Null
						
							Select bnode.Name
							
								Case "BLD"
									b:building = New building
									b.FileName=bnode.Attribute("filename").value
									If b.FileName <> 0 Then
										'TextureFilter "tree",4
										b.entity=xLoadMesh("..\"+b.FileName)
										b.x=Float(bnode.Attribute("xloc").value)
										b.y=Float(bnode.Attribute("yloc").value)
										b.z=Float(bnode.Attribute("zloc").value)
										
										b.pitch=Float(bnode.Attribute("pitch").value)
										b.yaw=Float(bnode.Attribute("yaw").value)
										b.roll=Float(bnode.Attribute("roll").value)
											
										b.scaleX# =Float(bnode.Attribute("xscale").value)
										b.scaleY# =Float(bnode.Attribute("yscale").value)
										b.scaleZ# =Float(bnode.Attribute("zscale").value)
									
										xPositionEntity b.entity,b.x,b.y,b.z
										xRotateEntity b.entity,b.pitch,b.yaw,b.roll
										xEntityType b.entity,1
										xScaleEntity b.entity,b.scaleX#,b.scaleY#,b.scaleZ#

										xEntityPickMode b.entity,2	
									EndIf						
							End Select
						
							bnode = bnode.NextSibling()
						Wend
					
					EndIf
				Case "GRASS"
					If cnode.HasChildren()
					
						Local gnode:xmlNode = cnode.FirstChild()
						While gnode <> Null
						
							Select gnode.Name
							
								Case "GRS"
									g:grass = New grass
									g.FileName$=gnode.Attribute("filename").value								
									If g.FileName$ <> 0 Then
										
										g.entity=xLoadMesh("..\"+g.FileName$)
										g.x=Float(gnode.Attribute("xloc").value)
										g.y=Float(gnode.Attribute("yloc").value)
										g.z=Float(gnode.Attribute("zloc").value)
										'g\yaw=ReadFloat(treefile)
										
											
										xPositionEntity g.entity,g.x,g.y,g.z
										xRotateEntity g.entity,0,Rnd(0,360),0
										xEntityType g.entity,1
											
										xScaleEntity g.entity,.3,.3,.3
										
										xEntityPickMode g.entity,2	
									EndIf						
							End Select
						
							gnode = gnode.NextSibling()
						Wend
					
					
					EndIf
				Case "PARTICLES"
			
			End Select
		
			cnode = cnode.NextSibling()
		Wend
	Else
		Return
	EndIf

End Function

Function Save_zone(xmlfilename$)

	Local Doc:xmlDocument = New xmlDocument
	Local DocRoot:xmlNode = Doc.Root:xmlNode()
	
	Local Bldnode:xmlNode = DocRoot.AddNode("BUILDING")
	For b:Building = EachIn Buildings
	
		Local bnode:xmlNode = Bldnode.AddNode("BLD")
		
		bnode.Attribute("filename").value = b.FileName$
		bnode.Attribute("xloc").value = xEntityX(b.entity)
		bnode.Attribute("yloc").value = xEntityY(b.entity)
		bnode.Attribute("zloc").value = xEntityZ(b.entity)

		bnode.Attribute("pitch").value = xEntityPitch(b.entity)
		bnode.Attribute("yaw").value = xEntityYaw(b.entity)
		bnode.Attribute("roll").value = xEntityRoll(b.entity)
		
		bnode.Attribute("xscale").value = b.scaleX#
		bnode.Attribute("yscale").value = b.scaleY#
		bnode.Attribute("zscale").value = b.scaleZ#
		
		
	
	Next

	Local GRSnode:xmlNode = DocRoot.AddNode("GRASS")
	For g:grass = EachIn grasss
		
		Local gnode:xmlNode = GRSnode.AddNode("GRS")
		gnode.Attribute("filename").value = g.FileName$
		gnode.Attribute("xloc").value = xEntityX(g.entity)
		gnode.Attribute("yloc").value = xEntityY(g.entity)
		gnode.Attribute("zloc").value = xEntityZ(g.entity)		
	
	Next
	
	Local PRTnode:xmlNode = DocRoot.AddNode("PARTICLES")
	
	
	For p:particleblock = EachIn particleblocks
	
		Local pnode:xmlNode = GRSnode.AddNode("PRT")
		pnode.Attribute("xloc").value = xEntityX(p.entity)
		pnode.Attribute("yloc").value = xEntityY(p.entity)
		pnode.Attribute("zloc").value = xEntityZ(p.entity)
	
	Next
			

	Doc.Save(xmlfilename$)

End Function

Function control_mouseLook()
	'update mouselook For this frame
	
	mxs = xMouseXSpeed()
	mys = xMouseYSpeed()
		
	dest_xang# = dest_xang + mys
	dest_yang# = dest_yang - mxs
	
	xang# = CurveValue (xang, dest_xang, 3)
	yang# = CurveValue (yang, dest_yang, 3)
	
		
	xRotateEntity camera,xang,yang#,0
	If dest_xang > 70 Then dest_xang = 70
	If dest_xang < -70 Then dest_xang = -70
		
End Function


Function ComputeMove#(camera, x#, y#, z#)
	If mouseSpeedX = 0 And mouseSpeedY = 0 Then Return 0.0
	' project axis on the screen
	xCameraProject(camera, controllPosX, controllPosY, controllPosZ)
	x1 = xProjectedX()
	y1 = xProjectedY()
	xCameraProject(camera, controllPosX + x, controllPosY + y, controllPosZ + z)
	x2 = xProjectedX()
	y2 = xProjectedY()
	' compute angle between our vectors
	dx1    = x2 - x1
	dy1    = y2 - y1
	dx2    = mouseSpeedX
	dy2    = mouseSpeedY
	len1#  = Sqr(dx1 * dx1 + dy1 * dy1)
	len2#  = Sqr(dx2 * dx2 + dy2 * dy2)
	angle# = ACos(Float(dx1 * dx2 + dy1 * dy2) / (len1 * len2))
	' compute distance
	radii# = Sqr(dx2 * dx2 + dy2 * dy2)
	' compute a new vector's x-component
	Return radii * Cos(angle)
End Function

Function CurveValue#(Currentt#,destination#,curve)
	Currentt#=Currentt#+((destination#-Currentt#)/curve)
	Return Currentt#
End Function

Function Create_Model_Props()
	window = alCreateGWindow("Model Properties", 669,259, 240, 138, AL_WinbuttonClose);
	alSetResizeMode(window, True, True);
	alSetSAreaPadding(window, 10, 10, 10, 10);
	postool  = alCreateGButton(window, "Pos", 10, 10, 50, -1);
	rottool  = alCreateGButton(window, "Rot", 60, 10, 50, -1);
	scaletool	  = alCreateGButton(window, "Scl",110, 10, 50, -1);
	lbl004 = alCreateGStatic(window, "Entity Alpha Level", 18, 45, 150, 20, 0, "LabelJ");
	sld001 = alCreateGScrollBar(window, "", 18, 76, 150, 80, 6);
	alSetSBarLimits(sld001, 0, 100);
	modl = xPickedEntity()
	If modl <> 0 Then
		alSetValueF(sld001, xGetEntityAlpha(modl)*100.00);
	Else
	
		alSetValueF(sld001, 100);
		
	EndIf
End Function

Function Create_Tree_Maker()	
	
	win001 = alCreateGWindow("Tree Maker", 768, 13, 241, 246, AL_WinbuttonClose);	
	btn001 = alCreateGButton(win001, "Place Tree's", 12, 100, 109, -1);
	lbl001 = alCreateGStatic(win001, "Start X", 56, 14, 100, 20, 0, "LabelJ");
	lbl002 = alCreateGStatic(win001, "Finish Z", 56, 42, 100, 20, 0, "LabelJ");
	lbl003 = alCreateGStatic(win001, "Amount", 56, 68, 100, 20, 0, "LabelJ");
	txt001 = alCreateGTextBox(win001, "",  19, 11, 27, "");
	txt002 = alCreateGTextBox(win001, "",  19, 37, 27, "");
	txt003 = alCreateGTextBox(win001, "",  19, 63, 27, "");
	
End Function	

Function Create_particle_tool()
	
	win002 = alCreateGWindow("Particleinator", 453, 107, 554, 301, AL_WinbuttonClose);
	gravbox = alCreateGTabContainer(win002, "Particles", 0, 0, 554, 301);
	htab_paramset = alAddTab(gravbox, "Particles");
	btn002 = alCreateGButton(htab_paramset, "Create", 6, 60, 70, 30);
	Flamechk = alCreateGToggleButton(htab_paramset, "Flames", 6, 5, 150, -1, 0, "CheckBox");
	Smokechk = alCreateGToggleButton(htab_paramset, "Smoke", 6, 30, 150, -1, 0, "CheckBox");
	Yscaletxt = alCreateGTextBox(htab_paramset, "",  80, 0, 150, "Y scale:");
	Xscaletxt = alCreateGTextBox(htab_paramset, "",  80, 60, 150, "X scale:");
	Agetxt = alCreateGTextBox(htab_paramset, "",  80, 120, 150, "Age:");
	Splitdelaytxt = alCreateGTextBox(htab_paramset, "",  80, 180, 150, "Delay:");
	zacceltxt = alCreateGTextBox(htab_paramset, "",  230, 0, 150, "Z Accel:");
	Yacceltxt = alCreateGTextBox(htab_paramset, "",  230, 60, 150, "Y Accel:");
	XaccelTxt = alCreateGTextBox(htab_paramset, "",  230, 120, 150, "X Accel:");
	txt004 = alCreateGTextBox(htab_paramset, "",  230, 180, 150, "Y scale:");


End Function

Function CreateDatabase()
	
		'creates database If it does Not exist.
		Local newdb:Byte = False
		If FileType(AppDir+"/../Data/Zone.db") = 0 Then
			Print "Create new media database"
			newdb = True
		EndIf
		DBC = LoadDatabase("SQLITE", AppDir+"/../Data/Zone.db")
		If newdb = True
			Local s:String = "CREATE TABLE zone (id integer primary key AUTOINCREMENT, " + ..
			" zname TEXT," + ..
			" isoutside INT," + ..
			" musicid BIGINT," + ..
			" skyzone TEXT," + ..
			" usefog INT," + ..
			" frcolor INT," + ..
			" fgcolor INT," + ..
			" fbcolor INT," + ..
			" ambred INT," + ..
			" ambgrn INT," + ..
			" ambblu INT," + ..
			" authorname TEXT)"
			DBC.executeQuery(s)
			s = "CREATE TABLE structures (id integer primary key AUTOINCREMENT, " + ..
			" sname TEXT," + ..
			" iswall INT," + ..
			" parentzone BIGINT," + ..
			" modelid BIGINT," + ..
			" srcolor INT," + ..
			" sgcolor INT," + ..
			" sbcolor INT," + ..
			" xpos FLOAT," + ..
			" ypos FLOAT," + ..
			" zpos FLOAT," + ..
			" pitc FLOAT," + ..
			" yaw FLOAT," + ..
			" roll FLOAT," + ..
			" xscl FLOAT," + ..
			" yscl FLOAT," + ..
			" zscl FLOAT," + ..			
			" alpha FLOAT," + ..
			" faderange FLOAT)"	
			DBC.executeQuery(s)		
		EndIf

		
End Function
