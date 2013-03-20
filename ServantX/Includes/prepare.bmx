'prepare (all the stuff in test.bb before the Main loop starts

xAppTitle "Servant Beta"
Global weatherdensity:String
Global UpdateFreq:Float = 1000/10

xGraphics3D 1024,768,32,0
xAntiAlias True
xSetTextureFiltering TF_ANISOTROPIC
'/* Connect GUI To Game Engine */
AlbaLynxInput_Connect()

'/* GUI start */
AlbaLynx_Initiate( xGetRenderWindow(), xGetDevice() );

'/* Creating log with level: all events */
alAddObserverHTMLLog("AlbaLynx.html", ALLEVEL_ALL);
Local objLoaded:Int = alLoadGTemplates("Media/gui/bubble.xml");
Include "globals.bmx"

'Include "meshterrainlib.bb"
'mainsplash()--------------------------UNCOMMENT

'servantsplash()--------------------------UNCOMMENT
'Include "includes/particlelib.bb"
Include "functions.bmx"
mainmenu()
DebugLog("Starting Game")
Global pointer = xLoadImage("misc/pointer.png")
Global player = xLoadAnimMesh("media/models/player/temp.fbx")
xRotateEntity player,0,-180,0
xScaleEntity player,1,1,1
'HideEntity player
Global knight_A_Idle = xExtractAnimSeq(player,2,41) 	'Idle
Global knight_A_walk = xExtractAnimSeq(player,42,82)'walk
Global knight_A_Run = xExtractAnimSeq(player,83,124) 	'run
Global knight_A_jump = xExtractAnimSeq(player,125,166) 	'jump
Global knight_A_wave = xExtractAnimSeq(player,167,208) 	'Wave
Global knight_A_swing = xExtractAnimSeq(player,209,249) 	'Attack1



'Include "includes/createchar.bb"
xShowEntity player
xScaleEntity player,2,2,2


player_Rhand = xFindChild(player,"Bip01 R Hand")


'characterSelectScreen()
'REMAKE THIS!
Include"createchar.bmx"

temppivot=xCreatePivot()

DebugLog("Loading Game")
Include "net.bmx"
Include "load.bmx"
'EntityParent Pike,player_Rhand

 'PositionEntity pike,110,66,110

'SetBuffer BackBuffer() 'set up the buffer
irc_nick$ = myname$
DebugLog("Connecting Game")
irc_log "*** Connected to The Servant ver 1.24***",$FFFF00
irc_log "*** Press F1 to view Help ***",$FFFF00
irc_log "*** This is the open Beta version of The Servant only to test network stress ***",$FFFF00
Global gameFPS = 26
Global range = 800
Global nametex = xCreateTexture(xStringWidth(myname$),xFontHeight())
'----------------- Create everything --------------
camera=xCreateCamera(cam_pivot)
DebugLog("Created Camera")
'CameraRange camera,.1,1000
light = xCreateLight()
Global fntArial=xLoadFont("Arial",14,True,False,False)
xEntityParent compassbase,camera,True
xEntityTexture compassbase,woodtex
xScaleEntity compassbase,.2,.01,.2
xRotateEntity compassbase,90,-3,0
xPositionEntity compassbase ,0,0,2
xPositionEntity compassbase ,1.2,.9,1.6
xPositionEntity compass,0,-2,0
xScaleEntity compass,.5,.3,.01

'************Temporarily Hiding Compass***********
xHideEntity compassbase


'EntityShininess compass,1



'ScaleEntity Tombentrance,5,6,5
'RotateEntity Tombentrance,0,-180,0
'PositionEntity Tombentrance,71,67,693



'xWBuffer 1

xEntityParent cam_pivot,player
xPositionEntity cam_pivot,0,0,0
'PositionEntity camera,0,2.5,1.5
xEntityParent player,player_pivot
'HideEntity player
xPositionEntity player,0,-1.2,0

xShowEntity player
xRotateEntity camera, 13,0,0
xPositionEntity camera,0,5,-10



Global townborder = xCreateCube()
xScaleEntity townborder,150,100,150
xPositionEntity townborder,2296,117,149
xEntityAlpha townborder,0
xFlipMesh townborder


Global mesh_skybox = MakeSkyBox("Sky/") 
'Global mesh_skyboxnight = CreateSphere()'MakeSkyBoxnight("sky/") 



xScaleEntity mesh_skybox,.25,.25,.25
xEntityOrder mesh_skybox, 100
xEntityFX mesh_skybox,9
'EntityFX mesh_skyboxnight,9

'ScaleEntity mesh_skyboxnight,15,15,15' was 20,20,20
'FlipMesh mesh_skyboxnight


xEntityOrder mesh_skybox, 99

'mesh_skyboxnight_tex = LoadTexture("sky/stars.bmp") 
'ScaleTexture mesh_skyboxnight_tex,.1,.1
'EntityTexture mesh_skyboxnight,mesh_skyboxnight_tex
xEntityOrder mesh_skybox, 99
Global cloudlayer[3]
Global cloudtex[3]

For icount = 0 To 2
	cloudlayer[icount]=xCreateSphere(16)
	
	xPositionEntity cloudlayer[icount],0,-10,0
	'RotateEntity cloudlayer(icount),180,0,0
	xFlipMesh cloudlayer[icount]
	xRotateMesh cloudlayer[icount],0,0,90
	xScaleEntity cloudlayer[icount],32+icount,16+icount,32+icount
	xEntityOrder cloudlayer[icount], 90+icount
	cloudtex[icount]=xLoadTexture("Sky\cloud" + (icount+1) + ".png",3)
	Select icount
		Case 1
			xScaleTexture cloudtex[icount],.195,.199
		Case 2
			xScaleTexture cloudtex[icount],.196,.168
		Case 3
			xScaleTexture cloudtex[icount],.262,.371
	End Select
	xEntityTexture cloudlayer[icount],cloudtex[icount]
	xEntityAlpha cloudlayer[icount],0.8'0.2 * (icount+1)
Next

Global cloudplane=xCreateSphere(16)

Global cloudplanetex=xLoadTexture("sky\cloudplane.png",4)
xScaleTexture cloudplanetex,0.5,0.5'200,200
xEntityTexture cloudplane,cloudplanetex
xFlipMesh cloudplane
xRotateMesh cloudplane,0,0,90
xScaleEntity cloudplane,32,16,32
'PositionEntity cloudplane,0,200,0
'RotateEntity cloudplane,180,0,0
xEntityOrder cloudplane, 89

Global currentcloudalpha#


moon = xLoadSprite("sprites/moon.png",4)
sun = xLoadSprite("sprites/sun.png",4)
Global moon_piv = xCreatePivot()
xPositionEntity moon_piv,0,0,0
xTurnEntity moon,90,0,0
xTurnEntity sun,90,0,0
xEntityParent moon,moon_piv
xEntityParent sun,moon_piv
xPositionEntity moon,0,2010,0
xPositionEntity sun,440,2010,80
xScaleSprite moon,130,130
xScaleSprite sun,230,230
xEntityFX moon,17
xEntityFX sun,17

'sunlight= CreateLight(1,sun)

'EntityParent invbutt,camera
'EntityParent charbutt,camera
'EntityParent inv,camera
'EntityParent spellbox,camera
'EntityParent characterinfo,camera
'EntityParent datepic,camera


xEntityParent statusbox,camera
xEntityParent healthpic,camera
xEntityParent manapic,camera




xScaleSprite healthpic,.07,.26
xScaleSprite manapic,.07,.26
'ScaleSprite spellbox,1,.2
xScaleSprite statusbox,.25,.33

'ScaleSprite inv,.3,.6
'ScaleSprite charbutt,.1,.1
'ScaleSprite invbutt,.1,.1
'ScaleSprite characterinfo,.6,.6
'ScaleSprite datepic,.11,.05



'PositionEntity inv,1.7,.5,2
'PositionEntity invbutt,-.8,1.35,2.01
'PositionEntity charbutt,-.5,1.35,2.01
'PositionEntity characterinfo,0.0,0.0,2.0
'PositionEntity datepic,-1.035,0.995,1.5


'HideEntity inv
'HideEntity characterinfo

'Global invbuttcube = CreateCube(invbutt)
'Global charbuttcube = CreateCube(charbutt)
Global swordcube = xCreateCube(swordico)

'ScaleEntity invbuttcube,.1,.1,.1
'ScaleEntity charbuttcube,.1,.1,.1

xScaleEntity swordcube,.1,.4,.1
'EntityAlpha invbuttcube,0 
'EntityAlpha charbuttcube,0 
'EntityPickMode invbuttcube,2
'EntityPickMode charbuttcube,2


'PositionEntity spellbox,0,1.3,2
xPositionEntity statusbox,1.7,-1.1,2
xPositionEntity healthpic,1.68,-1.165,2.1
xPositionEntity manapic,1.85,-1.165,2.1

'EntityOrder charbutt,-1
'EntityOrder invbutt,-2
'EntityOrder inv,-3
'EntityOrder characterinfo,-4
'EntityOrder spellbox,-5
'EntityOrder datepic,-9

xEntityOrder statusbox,-6
xEntityOrder healthpic,-7
xEntityOrder manapic,-8





xSpriteViewMode moon,1
xSpriteViewMode sun,1
'Terrain Section---------------------------------------------------------
warp = xCreateCube()

xPositionEntity warp,-197,-5.4,1290.16

xEntityType warp,6
xScaleEntity warp,4,4,4
xEntityRadius warp,4
xEntityAlpha warp,0


'For icount=0 To 6
'	meshTerrainTextures(icount)=LoadTexture("terrain/tex0" + (icount+1) + ".jpg")
'Next
'meshTerrainmaxTextureID=6
'
'MeshTerrain_CreateFromHeightmap("terrain/3200heightmap.jpg",camera)
'Global TERRAIN=LoadTerrain("lvl_hmap.bmp")
'NameEntity(terrain,"terrain")
'tex2 = LoadTexture("lvl_detail.bmp")
'grass = LoadTexture("lvl_tmap.jpg")

'ScaleTexture grass,256,256
'ScaleEntity terrain,10,300,10
'PositionEntity terrain,0,0,0
'ScaleTexture tex2,8,8
'TerrainDetail terrain,2000,True
'EntityTexture terrain,grass
'EntityTexture terrain,tex2,0,1
'EntityType terrain,1
'Global terrainplane=CreatePlane()
'terrainplane
'EntityTexture terrainplane,grass,0,0
'EntityTexture terrainplane,tex2,0,1
'PositionEntity terrainplane,0,10,0


'-------------------------------------------------------------------------


'----------------NPC SECTION----------------------------------------------
'Idle


Global rotation_pivot = xCreatePivot()
xEntityParent rotation_pivot,player_pivot',True
xPositionEntity rotation_pivot,0,0,.4



'PositionEntity tomb,-42.4,30,537

'RotateEntity tomb,0,90,0
'ScaleEntity tomb,3,3,3
'EntityType tomb,1

For p:pdata = EachIn pdatas 
 namesprite = createtext(name$,cube)
Next

'********POSITION********************
DebugLog("Setting Camera on Pivot")
xEntityParent camera,cam_pivot,False

Global cText$,cKey 'variable To hold typed messages


' ******* set up Collisions now ***************

xEntityType player_pivot,2
xEntityRadius player_pivot,1

chatenabled = True

For p:pdata = EachIn pdatas 
 If p.entity <> 0 Then 
 xMoveEntity p.namesprite,0,3,0
 xSpriteViewMode p.namesprite,1
EndIf
Next
light1 = xCreateSphere()

'----------------------------------------------

xAnimate player,2,.5,knight_A_Idle,1

'check For all names
For p:pdata = EachIn pdatas
If p.namesprite = 0 Then 
createtext(p.name$,p.entity)
namesprite = 1
EndIf
Next



xCollisions 2,1,2,2
xCollisions 1,2,2,3
xCollisions 2,4,2,2
xCollisions 3,1,2,1
xCollisions 2,3,2,3

xCollisions 6,2,2,2 
xCollisions 2,6,2,2

xCollisions 1,Water_Col,2,1
xCollisions Water_Col,1,2,1


CX#=1537
CY#=299
CZ#=142

night = False

Global listen=xCreateListener(camera,1,1,1)	


gSnowPivot = xCreatePivot(camera)
gSnowPivot2 = xCreatePivot(camera)





'ScaleEntity mesh_skyboxnight,600,600,600

'################Load OBJECTS#######################


'If raining = True Then
'splashframes = 20
'splashtex=CreateSplashTexture(500,64,splashframes)


'ringframes = 20
'ringtex=CreateRingTexture(50,128,ringframes)

'raintex=CreateRainTexture(50,128)
'CreateRain3D(255,raintex) 



'CreateRings3D(50,ringtex,ringframes)
'CreateSplashes3D(100,splashtex,splashframes)
'EndIf

framePeriod = 1000 / gameFPS
frameTime = MilliSecs () - framePeriod

'-------------------------------------------------


'#######################################################GRASS ACTIVE FLAG
'Global GRASSINITIALIZED=False
'Global NUMBEROFGRASSES=2500
'Global grassmap = LoadImage ("lvl_grassmap.jpg")
'Global grassmapscale#=10

'Global tempgrassx# 
'Global tempgrassy# 
'Global tempweatherx#
'Global tempweathery#
'Global weathermap=LoadImage("lvl_weathermap.jpg")
Global grassStalks:TList = New TList

Type grassStalk

	Method New()
		ListAddLast(grassStalks,Self)
	End Method
	Field x#
	Field y#
	Field z#
	Field ang#
	Field t1,t2,t3,t4
	Field v1,v2,v3,v4
	Field lowx# 'modifier To adjust width of stalk
End Type

'ground=CreatePlane()
'EntityColor ground,20,60,20



'#################################################################RAIN SETUP
Global rain_delay
Global rain_amount=24
Global rain_splashh=xLoadSprite("splash.bmp",3)
Global rain_rippleh=xLoadSprite("ripple.bmp",3)
Global rain_mesh=xCreateMesh()
	xEntityBlend rain_mesh,3
	xEntityFX rain_mesh,2'34
Global rain_surface=xCreateSurface(rain_mesh)

Global rains:TList = New TList

Type rain

	Method New()
		ListAddLast(rains,Self)
	End Method
	Field x#,y#,z#
	Field lx#,ly#,lz#
	Field xv#,yv#,zv#
	Field xvg#,yvg#,zvg#
	Field ang#
	Field v1,v2,v3,v4
	Field t1,t2,t3,t4
End Type

Global rain_splashes:TList = New TList

Type rain_splash

	Method New()
		ListAddLast(rain_splashes,Self)
	End Method

	Field life#
	Field ent
End Type

Global rain_ripples:TList = New TList

Type rain_ripple
	Method New()
		ListAddLast(rain_ripples,Self)
	End Method

	Field life#
	Field ent
End Type

Global rainlight=xLoadSound ("misc\sounds\rain.mp3")
Global rainheavy=xLoadSound ("misc\sounds\rain.wav")
xLoopSound rainlight
xLoopSound rainheavy
Global chlrainl = xPlaySound(rainlight)
Global chlrainh = xPlaySound(rainheavy)
xChannelVolume chlrainl,0
xChannelVolume chlrainh,0

'mouselook globals
Global mouselook=True
Global dest_xang#
Global dest_yang#
Global xang#
Global yang#

' SET UP WATER - Load a reference mesh 

FXCamera=xCreateCamera()
xCameraClsMode FXCamera,False,True
xCameraProjMode FXCamera,0
xCameraViewport FXCamera,0,0,WaterMapSize,WaterMapSize


Global water=xLoadMesh("Media/water.3ds")

DebugLog("Loaded water")
xMoveEntity water,1400,25,1000
xScaleEntity water,5,1,5
WaterMapTexture=xCreateTexture(WaterMapSize,WaterMapSize,128+256+48)
xEntityTexture water,WaterMapTexture
xEntityColor water,100,200,255
xEntityColor water,512,512,512
xEntityAlpha water,0.7
xEntityFX water,1
'AddEntity(water)


surf=xGetSurface(water,0)
Global VertexT:Vertices[xCountVertices(surf)]

For i=0 To xCountVertices(surf)-1
	VertexT[i] = New Vertices
	VertexT[i].x#=xVertexX#(surf,i)
	VertexT[i].y#=xVertexY#(surf,i)
	VertexT[i].z#=xVertexZ#(surf,i)
Next

'Global water = CreateTerrain(WATER_GRID_SIZE)
'watert = LoadTexture("misc\water2.bmp")
'Global watercubemapDay = LoadTexture("sky/skymap.bmp",128)
'Global watercubemapNight = LoadTexture("sky/nightmap.bmp",128)
'EntityAlpha water,.8
'EntityType water,water_col
'MoveEntity water,800,23,-300
'ScaleEntity water,90,WATER_HEIGHT#,60
'EntityPickMode water,2
'SetCubeFace watercubemapDay,4

'ScaleTexture watert,2,2
'EntityTexture water,watert

'SetCubeFace watercubemapNight,4

Include"warps.bmx"
xSetBuffer xBackBuffer()
'~IDEal Editor Parameters:
'~C#Blitz3D