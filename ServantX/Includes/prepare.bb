;prepare (all the stuff in test.bb before the main loop starts

AppTitle "Servant Beta"
Global weatherdensity$
Global UpdateFreq# = 1000/10

Graphics3D 1024,768,32,1
SetBuffer BackBuffer()

Include "includes/globals.bb"

;Include "meshterrainlib.bb"
;mainsplash()--------------------------UNCOMMENT

;servantsplash()--------------------------UNCOMMENT
;Include "includes/particlelib.bb"
Include "includes/functions.bb"
mainmenu()

Global pointer = LoadImage("misc/pointer.png")
Global player = LoadAnimMesh("media/models/player/knight.b3d")
RotateEntity player,0,-180,0
ScaleEntity player,5,5,5
;HideEntity player
Global knight_A_Idle = ExtractAnimSeq(player,2,41) 	;Idle
Global knight_A_walk = ExtractAnimSeq(player,42,82);walk
Global knight_A_Run = ExtractAnimSeq(player,83,124) 	;run
Global knight_A_jump = ExtractAnimSeq(player,125,166) 	;jump
Global knight_A_wave = ExtractAnimSeq(player,167,208) 	;Wave
Global knight_A_swing = ExtractAnimSeq(player,209,249) 	;Attack1



;Include "includes/createchar.bb"
ShowEntity player
ScaleEntity player,2,2,2


player_Rhand = FindChild(player,"Bip01 R Hand")


;characterSelectScreen()
Include"includes/createchar.bb"

temppivot=CreatePivot()
Include "includes/net.bb"
Include "includes/load.bb"
;EntityParent Pike,player_Rhand

 ;PositionEntity pike,110,66,110

;SetBuffer BackBuffer() ;set up the buffer
irc_nick$ = myname$
irc_log "*** Connected to The Servant ver 1.24***",$FFFF00
irc_log "*** Press F1 to view Help ***",$FFFF00
irc_log "*** This is the open Beta version of The Servant only to test network stress ***",$FFFF00
Global gameFPS = 26
Global range = 800
Global nametex = CreateTexture(StringWidth(myname$),FontHeight())
;----------------- Create everything --------------
camera=CreateCamera(cam_pivot)
;CameraRange camera,.1,1000
light = CreateLight()
Global fntArial=LoadFont("Arial",14,True,False,False)
EntityParent compassbase,camera,True
EntityTexture compassbase,woodtex
ScaleEntity compassbase,.2,.01,.2
RotateEntity compassbase,90,-3,0
PositionEntity compassbase ,0,0,2
PositionEntity compassbase ,1.2,.9,1.6
PositionEntity compass,0,-2,0
ScaleEntity compass,.5,.3,.01

;************Temporarily Hiding Compass***********
HideEntity compassbase


;EntityShininess compass,1



;ScaleEntity Tombentrance,5,6,5
;RotateEntity Tombentrance,0,-180,0
;PositionEntity Tombentrance,71,67,693



WBuffer 1

EntityParent cam_pivot,player_pivot
PositionEntity cam_pivot,0,0,0
;PositionEntity camera,0,2.5,1.5
EntityParent player,player_pivot
;HideEntity player
PositionEntity player,0,-1.2,0

ShowEntity player
RotateEntity camera, 13,0,0
PositionEntity camera,0,5,-10



Global townborder = CreateCube()
ScaleEntity townborder,150,100,150
PositionEntity townborder,2296,117,149
EntityAlpha townborder,0
FlipMesh townborder


Global mesh_skybox = MakeSkyBox("sky/") 
;Global mesh_skyboxnight = CreateSphere();MakeSkyBoxnight("sky/") 



ScaleEntity mesh_skybox,.25,.25,.25
EntityOrder mesh_skybox, 100
EntityFX mesh_skybox,9
;EntityFX mesh_skyboxnight,9

;ScaleEntity mesh_skyboxnight,15,15,15; was 20,20,20
;FlipMesh mesh_skyboxnight


EntityOrder mesh_skybox, 99

;mesh_skyboxnight_tex = LoadTexture("sky/stars.bmp") 
;ScaleTexture mesh_skyboxnight_tex,.1,.1
;EntityTexture mesh_skyboxnight,mesh_skyboxnight_tex
EntityOrder mesh_skybox, 99
Dim cloudlayer(3)
Dim cloudtex(3)

For icount = 0 To 2
	cloudlayer(icount)=CreateSphere(16)
	
	PositionEntity cloudlayer(icount),0,-10,0
	;RotateEntity cloudlayer(icount),180,0,0
	FlipMesh cloudlayer(icount)
	RotateMesh cloudlayer(icount),0,0,90
	ScaleEntity cloudlayer(icount),32+icount,16+icount,32+icount
	EntityOrder cloudlayer(icount), 90+icount
	cloudtex(icount)=LoadTexture("Sky\cloud" + (icount+1) + ".png",3)
	Select icount
		Case 1
			ScaleTexture cloudtex(icount),.195,.199
		Case 2
			ScaleTexture cloudtex(icount),.196,.168
		Case 3
			ScaleTexture cloudtex(icount),.262,.371
	End Select
	EntityTexture cloudlayer(icount),cloudtex(icount)
	EntityAlpha cloudlayer(icount),0.8;0.2 * (icount+1)
Next

Global cloudplane=CreateSphere(16)

Global cloudplanetex=LoadTexture("sky\cloudplane.png",4)
ScaleTexture cloudplanetex,0.5,0.5;200,200
EntityTexture cloudplane,cloudplanetex
FlipMesh cloudplane
RotateMesh cloudplane,0,0,90
ScaleEntity cloudplane,32,16,32
;PositionEntity cloudplane,0,200,0
;RotateEntity cloudplane,180,0,0
EntityOrder cloudplane, 89

Global currentcloudalpha#


moon = LoadSprite("sprites/moon.png",4)
sun = LoadSprite("sprites/sun.png",4)
Global moon_piv = CreatePivot()
PositionEntity moon_piv,0,0,0
TurnEntity moon,90,0,0
TurnEntity sun,90,0,0
EntityParent moon,moon_piv
EntityParent sun,moon_piv
PositionEntity moon,0,2010,0
PositionEntity sun,440,2010,80
ScaleSprite moon,130,130
ScaleSprite sun,230,230
EntityFX moon,17
EntityFX sun,17

;sunlight= CreateLight(1,sun)

;EntityParent invbutt,camera
;EntityParent charbutt,camera
;EntityParent inv,camera
;EntityParent spellbox,camera
;EntityParent characterinfo,camera
;EntityParent datepic,camera


EntityParent statusbox,camera
EntityParent healthpic,camera
EntityParent manapic,camera




ScaleSprite healthpic,.07,.26
ScaleSprite manapic,.07,.26
;ScaleSprite spellbox,1,.2
ScaleSprite statusbox,.25,.33

;ScaleSprite inv,.3,.6
;ScaleSprite charbutt,.1,.1
;ScaleSprite invbutt,.1,.1
;ScaleSprite characterinfo,.6,.6
;ScaleSprite datepic,.11,.05



;PositionEntity inv,1.7,.5,2
;PositionEntity invbutt,-.8,1.35,2.01
;PositionEntity charbutt,-.5,1.35,2.01
;PositionEntity characterinfo,0.0,0.0,2.0
;PositionEntity datepic,-1.035,0.995,1.5


;HideEntity inv
;HideEntity characterinfo

;Global invbuttcube = CreateCube(invbutt)
;Global charbuttcube = CreateCube(charbutt)
Global swordcube = CreateCube(swordico)

;ScaleEntity invbuttcube,.1,.1,.1
;ScaleEntity charbuttcube,.1,.1,.1

ScaleEntity swordcube,.1,.4,.1
;EntityAlpha invbuttcube,0 
;EntityAlpha charbuttcube,0 
;EntityPickMode invbuttcube,2
;EntityPickMode charbuttcube,2


;PositionEntity spellbox,0,1.3,2
PositionEntity statusbox,1.7,-1.1,2
PositionEntity healthpic,1.68,-1.165,2.1
PositionEntity manapic,1.85,-1.165,2.1

;EntityOrder charbutt,-1
;EntityOrder invbutt,-2
;EntityOrder inv,-3
;EntityOrder characterinfo,-4
;EntityOrder spellbox,-5
;EntityOrder datepic,-9

EntityOrder statusbox,-6
EntityOrder healthpic,-7
EntityOrder manapic,-8





SpriteViewMode moon,1
SpriteViewMode sun,1
;Terrain Section---------------------------------------------------------
warp = CreateCube()

PositionEntity warp,-197,-5.4,1290.16

EntityType warp,6
ScaleEntity warp,4,4,4
EntityRadius warp,4
EntityAlpha warp,0


;For icount=0 To 6
;	meshTerrainTextures(icount)=LoadTexture("terrain/tex0" + (icount+1) + ".jpg")
;Next
;meshTerrainmaxTextureID=6
;
;MeshTerrain_CreateFromHeightmap("terrain/3200heightmap.jpg",camera)
;Global TERRAIN=LoadTerrain("lvl_hmap.bmp")
;NameEntity(terrain,"terrain")
;tex2 = LoadTexture("lvl_detail.bmp")
;grass = LoadTexture("lvl_tmap.jpg")

;ScaleTexture grass,256,256
;ScaleEntity terrain,10,300,10
;PositionEntity terrain,0,0,0
;ScaleTexture tex2,8,8
;TerrainDetail terrain,2000,True
;EntityTexture terrain,grass
;EntityTexture terrain,tex2,0,1
;EntityType terrain,1
;Global terrainplane=CreatePlane()
;terrainplane
;EntityTexture terrainplane,grass,0,0
;EntityTexture terrainplane,tex2,0,1
;PositionEntity terrainplane,0,10,0


;-------------------------------------------------------------------------


;----------------NPC SECTION----------------------------------------------
;Idle


Global rotation_pivot = CreatePivot()
EntityParent rotation_pivot,player_pivot,True
PositionEntity rotation_pivot,0,0,.4



;PositionEntity tomb,-42.4,30,537

;RotateEntity tomb,0,90,0
;ScaleEntity tomb,3,3,3
;EntityType tomb,1

For p.pdata = Each pdata 
 namesprite = createtext(name$,cube)
Next

;********POSITION********************

EntityParent camera,cam_pivot,False

Global cText$,cKey% ;variable To hold typed messages


; ******* set up collisions now ***************
;EntityType terrain,1
EntityType player_pivot,2
EntityRadius player_pivot,1.3

chatenabled = True

For p.pdata = Each pdata 
 If p\entity <> 0 Then 
 MoveEntity p\namesprite,0,3,0
 SpriteViewMode p\namesprite,1
EndIf
Next
light1 = CreateSphere()

;----------------------------------------------

Animate player,2,.5,knight_A_Idle,1

;check for all names
For p.pdata = Each pdata
If p\namesprite = 0 Then 
createtext(p\name$,p\entity)
namesprite = 1
EndIf
Next



Collisions 2,1,2,3
Collisions 1,2,2,3
Collisions 2,4,2,2
Collisions 3,1,2,1
Collisions 2,3,2,3

Collisions 6,2,2,2 
Collisions 2,6,2,2

Collisions 1,Water_Col,2,1
Collisions Water_Col,1,2,1


CX#=1537
CY#=299
CZ#=142

night = False

Global listen=CreateListener(camera,1,1,1)	


gSnowPivot = CreatePivot(camera)
gSnowPivot2 = CreatePivot(camera)





;ScaleEntity mesh_skyboxnight,600,600,600

;################LOAD OBJECTS#######################


;If raining = True Then
;splashframes = 20
;splashtex=CreateSplashTexture(500,64,splashframes)


;ringframes = 20
;ringtex=CreateRingTexture(50,128,ringframes)

;raintex=CreateRainTexture(50,128)
;CreateRain3D(255,raintex) 



;CreateRings3D(50,ringtex,ringframes)
;CreateSplashes3D(100,splashtex,splashframes)
;EndIf

framePeriod = 1000 / gameFPS
frameTime = MilliSecs () - framePeriod

;-------------------------------------------------


;#######################################################GRASS ACTIVE FLAG
;Global GRASSINITIALIZED=False
;Global NUMBEROFGRASSES=2500
;Global grassmap = LoadImage ("lvl_grassmap.jpg")
;Global grassmapscale#=10

;Global tempgrassx# 
;Global tempgrassy# 
;Global tempweatherx#
;Global tempweathery#
;Global weathermap=LoadImage("lvl_weathermap.jpg")
Type grassStalk
	Field x#
	Field y#
	Field z#
	Field ang#
	Field t1,t2,t3,t4
	Field v1,v2,v3,v4
	Field lowx# ;modifier to adjust width of stalk
End Type

;ground=CreatePlane()
;EntityColor ground,20,60,20



;#################################################################RAIN SETUP
Global rain_delay
Global rain_amount=24
Global rain_splash=LoadSprite("splash.bmp",3)
Global rain_ripple=LoadSprite("ripple.bmp",3)
Global rain_mesh=CreateMesh()
	EntityBlend rain_mesh,3
	EntityFX rain_mesh,2;34
Global rain_surface=CreateSurface(rain_mesh)
Type rain
	Field x#,y#,z#
	Field lx#,ly#,lz#
	Field xv#,yv#,zv#
	Field xvg#,yvg#,zvg#
	Field ang#
	Field v1,v2,v3,v4
	Field t1,t2,t3,t4
End Type
Type rain_splash
	Field life#
	Field ent
End Type
Type rain_ripple
	Field life#
	Field ent
End Type

Global rainlight=LoadSound ("misc\sounds\rain.mp3")
Global rainheavy=LoadSound ("misc\sounds\rain.wav")
LoopSound rainlight
LoopSound rainheavy
Global chlrainl = PlaySound(rainlight)
Global chlrainh = PlaySound(rainheavy)
ChannelVolume chlrainl,0
ChannelVolume chlrainh,0

;mouselook globals
Global mouselook=True
Global dest_xang#
Global dest_yang#
Global xang#
Global yang#

; SET UP WATER - load a reference mesh 

FXCamera=CreateCamera()
CameraClsMode FXCamera,False,True
CameraProjMode FXCamera,0
CameraViewport FXCamera,0,0,WaterMapSize,WaterMapSize


Global water=LoadMesh("Media/water.3ds")


MoveEntity water,1400,25,1000
ScaleEntity water,5,1,5
WaterMapTexture=CreateTexture(WaterMapSize,WaterMapSize,128+256+48)
EntityTexture water,WaterMapTexture
EntityColor water,100,200,255
EntityColor water,512,512,512
EntityAlpha water,0.7
EntityFX water,1
;AddEntity(water)


surf=GetSurface(water,1)
Dim Vertex.Vertices(CountVertices(surf))
For i=0 To CountVertices(surf)-1
	Vertex(i) = New Vertices
	Vertex(i)\x#=VertexX#(surf,i)
	Vertex(i)\y#=VertexY#(surf,i)
	Vertex(i)\z#=VertexZ#(surf,i)
Next

;Global water = CreateTerrain(WATER_GRID_SIZE)
;watert = LoadTexture("misc\water2.bmp")
;Global watercubemapDay = LoadTexture("sky/skymap.bmp",128)
;Global watercubemapNight = LoadTexture("sky/nightmap.bmp",128)
;EntityAlpha water,.8
;EntityType water,water_col
;MoveEntity water,800,23,-300
;ScaleEntity water,90,WATER_HEIGHT#,60
;EntityPickMode water,2
;SetCubeFace watercubemapDay,4

;ScaleTexture watert,2,2
;EntityTexture water,watert

;SetCubeFace watercubemapNight,4

Include"includes/warps.bb"
SetBuffer BackBuffer()
;~IDEal Editor Parameters:
;~C#Blitz3D