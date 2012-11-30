;==================================================================
;Project Title:     ServED
;Author:     Matthew LaVoice
;Email:            mattlavoice@binary-people.com	        
;Version:    1.0      
;Date:         9/9/03     
;Notes:       Made for The Servant mmorpgFunction (dir$)
;                   
;                   
;==================================================================
Graphics3D 1024,768,32

SetBuffer BackBuffer()
HidePointer 

Include "icons.bb"
Include "blitzui.bb"
LoadColourScheme( "slate.cs" )
Include "opensavedialog.bb"
Include "particlelib.bb"
Global value%
Global startx
Global starty
Global amount
Global dest_xang# 
Global mys
Global dest_yang# 
Global mxs
Global xang# 
Global yang#

Type Building
Field x#,y#,z#
Field entity
Field FileName$
Field yaw,pitch,roll
Field scaleX#,scaleY#,scaleZ#
End Type

Type myemit
Field x#,y#,z#
Field entity
End Type

Type particleblock
Field x#,y#,z#
Field entity
End Type



Type grass
Field x#,y#,z#
Field entity
Field FileName$
End Type

Global MX#,MY#,MZ#
Global pentity
Global turnPentity
Global scalex#,scaley#,scalez#




Global camera = CreateCamera()
PositionEntity camera,200,80,50
EntityType camera,2
EntityRadius camera,1



CameraClsColor camera,80,130,235
CameraFogMode camera,1
CameraRange camera,1,6500
CameraFogRange camera,5000,6000
CameraFogColor camera,80,130,235

light= CreateLight()

ZONEID$ = Input$("Please enter the number of the Zone that you wish to edit ?: ")

terraedit = 1

;Load fonts and  cursors
;and collect information
Initialise(  )

;Window
win001 = Window( 868, 13, 141, 246, "Tree Maker", "0", 1, 0, 0, 0 )
btn001 = Button( 12, 100, 109, 15, "Place Tree's", "0", 1, 0, 0 )
lbl001 = Label( 56, 14, "Start_X", 0 )
lbl002 = Label( 54, 42, "Finish_Z", 0 )
lbl003 = Label( 62, 68, "Amount", 0 )
txt001 = TextBox( 19, 11, 27, 21, 0, 0, 18, 10, 0 )
SendMessage( txt001, "TM_SETTEXT", 0, "" )
txt002 = TextBox( 19, 37, 27, 21, 0, 0, 18, 10, 0 )
SendMessage( txt002, "TM_SETTEXT", 0, "" )
txt003 = TextBox( 19, 63, 36, 21, 0, 0, 18, 10, 0 )
SendMessage( txt003, "TM_SETTEXT", 0, "" )

;Window
win001 = Window( 192, 4, 361, 79, "ServED Main Tool Box", "0", 1, 1, 0, 0 )
mnut001 = MenuTitle( "File" )
mnui001 = MenuItem( mnut001, "Open", "", "0", 0, 0, 0 )
mnui002 = MenuItem( mnut001, "Save", "", "0", 0, 0, 0 )
mnui003 = MenuItem( mnut001, "Exit", "", "0", 0, 0, 0 )
mnut004 = MenuTitle( "Models" )
mnui007 = MenuItem( mnut004, "Load Models", "", "0", 0, 0, 0 )
tree001 = TreeView( 148, 6, 0, 0, 20, 20, 10, 0 )


;Window
win003 = Window( 869, 259, 140, 138, "Model Properties", "0", 1, 0, 0, 0 )
chk002 = CheckBox( 18, 20, "Manual Rotation", 0 )
lbl004 = Label( 17, 50, "Entity Alpha Level", 0 )
sld001 = Slider( 18, 66, 80, 6, 0.0, 0.0, 100.0, 1, 0, "210,210,210", "210,210,210" )

;Window
win002 = Window( 870, 397, 138, 270, "Scale Model", "0", 1, 0, 0, 0 )
scalenowbutton = Button( 12, 100, 109, 15, "Scale Now", "0", 1, 0, 0 )
lbl021 = Label( 56, 14, "X Scale", 0 )
lbl022 = Label( 56, 42, "Y Scale", 0 )
lbl023 = Label( 56, 68, "Z Scale", 0 )
txt021 = TextBox( 19, 11, 27, 21, 0, 0, 18, 10, 0 )
SendMessage( txt021, "TM_SETTEXT", 0, "" )
txt022 = TextBox( 19, 37, 27, 21, 0, 0, 18, 10, 0 )
SendMessage( txt022, "TM_SETTEXT", 0, "" )
txt023 = TextBox( 19, 63, 27, 21, 0, 0, 18, 10, 0 )
SendMessage( txt023, "TM_SETTEXT", 0, "" )


;Window
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
;txt001 = TextBox( 340, 101, 64, 17, 0, 0, 18, 10, 0 )
;SendMessage( txt001, "TM_SETTEXT", 0, "" )
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


;*******Changes the working directory to the Engine Directory******
ChangeDir ".."


Global TERRAIN=LoadTerrain("Media\Zone\"+ZONEID$+"\lvl_hmap"+ZONEID$+".bmp")
NameEntity(terrain,"terrain")
tex2 = LoadTexture("Media\Zone\"+ZONEID$+"\lvl_detail"+ZONEID$+".bmp",2)
grass = LoadTexture("Media\Zone\"+ZONEID$+"\lvl_tmap"+ZONEID$+".jpg",2)

ScaleTexture grass,256,256
ScaleEntity terrain,10,300,10
PositionEntity terrain,0,0,0,True
ScaleTexture tex2,8,8
TerrainDetail terrain,2000,True


EntityTexture terrain,grass

EntityTexture terrain,tex2,0,1




EntityType terrain,1

Collisions 1,2,2,2
Collisions 2,1,2,2



turnPentity = False 


buildings = ReadFile("Media\Zone\"+ZONEID$+"\buildings"+ZONEID$+".T3d")
While Not Eof(buildings)
	b.building = New building
	b\FileName=ReadString(buildings)
	If b\FileName > 0 Then
	;TextureFilter "tree",4
	b\entity=LoadMesh(b\FileName)
	b\x=ReadFloat(buildings)
	b\y=ReadFloat(buildings)
	b\z=ReadFloat(buildings)
	b\pitch=ReadFloat(buildings)
	b\yaw=ReadFloat(buildings)
	b\roll=ReadFloat(buildings)
		
	b\scaleX# =ReadFloat(buildings)
	b\scaleY# =ReadFloat(buildings)
	b\scaleZ# =ReadFloat(buildings)

	PositionEntity b\entity,b\x,b\y,b\z
	RotateEntity b\entity,b\pitch,b\yaw,b\roll
	EntityType b\entity,1
	
	ScaleEntity b\entity,b\scaleX#,b\scaleY#,b\scaleZ#
	;ScaleEntity b\entity,.3,.3,.3
		
	EntityPickMode b\entity,2
	
	;EntityAutoFade b\entity,700,900	
	
	EndIf
Wend
CloseFile(buildings)


Objects = ReadFile("Media\Zone\"+ZONEID$+"\Obj"+ZONEID$+".T3d")
While Not Eof(Objects)
	g.grass = New grass
	g\FileName$=ReadString(Objects)

	If g\FileName$ > 0 Then
	;TextureFilter "tree",4
	g\entity=LoadMesh(g\FileName$)
	g\x=ReadFloat(Objects)
	g\y=ReadFloat(Objects)
	g\z=ReadFloat(Objects)
	;g\yaw=ReadFloat(treefile)
	
		
	PositionEntity g\entity,g\x,g\y,g\z
	RotateEntity g\entity,0,Rnd(0,360),0
	EntityType g\entity,1
		
	ScaleEntity g\entity,.3,.3,.3
	
	EntityPickMode g\entity,2

	
	;EntityTexture g\entity,tex1
	;EntityAutoFade g\entity,700,900
	EndIf	
Wend
CloseFile(Objects)





;1 Key Esc
While Not KeyHit(1)

Cls

mx#=0
my#=0
mz#=0
	
;Mouse Right Button, 57 Key Space	
If MouseHit(2) And KeyDown(57)=0  

	
	
	If pEntColor > 0 Then EntityColor (pEntColor, 255, 255, 255)
	
	picked=CameraPick(camera,MouseX(),MouseY()) 


	If picked > 0
		pEntColor = PickedEntity ()
		EntityColor (pEntColor, 255, 130, 130)
	EndIf	
		
	
	
EndIf	
	


;211 Key Delete
If KeyHit(211) And picked>0 

	;FreeEntity eEntColor
	FreeEntity picked
	For check.building = Each building
		If check\entity = picked Then Delete check
	Next
	
	For chek.grass = Each grass
		If chek\entity = picked Then Delete chek
	Next
	
	picked = 0
	
	pEntColor = 0
	
	
EndIf	



	
If turnpentity = False Then
;205 Key Right
If KeyDown(205)=True Then mx#=+.5
;203 Key Left
If KeyDown(203)=True Then mx#=-.5
;208 Key Down
If KeyDown(208)=True Then mz#=-.5
;200 Key Up
If KeyDown(200)=True Then mz#=+.5
;30 Key A
If KeyDown(30) Then	my# =+.5
;44 Key Z
If KeyDown(44) Then my# =-.5
pentity = PickedEntity()
;mx = EntityX(pentity)
;my = EntityY(pentity)
;mz = EntityZ(pentity)
 If pentity > 0 And picked > 0 Then
 MoveEntity pentity,MX#,MY#,MZ#
 EndIf 
EndIf

If turnPentity = True Then
 ;205 Key Right
 If KeyDown(205)=True Then mx#=+.5
 ;203 Key Left
 If KeyDown(203)=True Then mx#=-.5
 ;208 Key Down
 If KeyDown(208)=True Then mz#=-.5
 ;200 Key Up
 If KeyDown(200)=True Then mz#=+.5
 ;30 Key A
 If KeyDown(30) Then my# =+.5
 ;44 Key Z
 If KeyDown(44) Then my# =-.5
 pentity = PickedEntity()
  If pentity > 0 And picked > 0 Then
   TurnEntity pentity,mz#,mx#,my#
  EndIf 
EndIf



UpdateWorld
RenderWorld
;Draw the GUI and update the mouse
UpdateGUI(  )


	
UserInput()

;If KeyDown(57)=0 Then
;userinput()
;EndIf



;Event Handling
Select app\Event
Case EVENT_WINDOW
Select app\WindowEvent
End Select
Case EVENT_MENU
Select app\MenuEvent
Case mnui007 
FileName$ = FileDialog( "Open File", CurrentDir(), ".3ds;.x;.b3d;" )
If FileName$ > ""
If FileType( FileName$ ) = 1 And ( Right( Lower( FileName$ ), 4 ) = ".3ds" Or Right( Lower( FileName$ ), 2 ) = ".x" Or Right( Lower( FileName$ ), 4 ) = ".b3d" )
If Mesh FreeEntity Mesh
placebuilding(FileName$)
EndIf
EndIf
		
Case mnui002
createbldfile(ZONEID$)

Case mnui003
End 

						
End Select
					
Case EVENT_GADGET
Select app\GadgetEvent
Case btn001
StartX = SendMessage( txt001,"TM_GETTEXT")
StartY = SendMessage( txt002,"TM_GETTEXT")
amount = SendMessage( txt003,"TM_GETTEXT")
placetree(startx,starty,amount)
Case createparticle 
;xacc# = SendMessage(xacceltxt,"TM_GETTEXT")
;yacc# = SendMessage(yacceltxt,"TM_GETTEXT")
;zacc# = SendMessage(zacceltxt,"TM_GETTEXT")
;distortion# = SendMessage( Disttxt,"TM_GETTEXT")
;spitDelay# =SendMessage(Splitdelaytxt,"TM_GETTEXT");
;particleMaxAge# =SendMessage( Agetxt,"TM_GETTEXT")
;useGrav = SendMessage( GravTxt,"TM_GETTEXT")
;xScale# = SendMessage( Xscaletxt,"TM_GETTEXT")
;yScale# = SendMessage( Yscaletxt ,"TM_GETTEXT")
;MostSolid = 1
;fx = 2
 
;maxAge# = SendMessage( Agetxt,"TM_GETTEXT") 
;m.myemit= New myemit
;m\entity = CreateSphere()
;m\x# = EntityX(camera)
;m\y# = EntityY(camera)
;m\z# = EntityZ(camera)
;PositionEntity m\entity,m\x#,m\y#,m\z#
;createGenerator (m\X#,M\y#,M\z#,xacc#,yacc#,zacc#,distortion#,spitDelay#,particleMaxAge#,useGrav,myGFX$,xScale#,yScale#,MostSolid,fx=2)
;Function createGenerator (x#,y#,z#,xacc#=0,yacc#=0,zacc#=0,distortion#=0.5,spitDelay=100,particleMaxAge=5,useGrav=True,myGFX$="fire.png",xScale#=0.1,yScale#=0.11,MostSolid#=1,fx=2,maxAge=-1)
;Funtion found in Particlelib.bb

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


;Scale Code

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
	
;Draw the mouse
DrawMouse(  )
updateGenerators()
updateParticles()
	
;Reset all GUI events
ResetEvents( )
Color 255,255,255

;57 Key Space
If KeyDown(57)
 
	;TranslateEntity camera,0,0,0
	control_mouseLook()
	
EndIf	
  

Flip
Wend
Destroy()
End

Function placetree(StartX#,Starty#,Count)
;place trees on the map
For grassed = 0 To Count
For icount = 1 To 4
temp$="tree"
If icount<10 Then temp$=temp$
temp$=temp$ + icount
grassX# = Rnd(StartX,Starty)
grassZ# = Rnd(StartX,Starty)
terheight#= TerrainHeight(terrain,grassX#,grassz#) 
grassy# = TerrainY(terrain,grassx,terheight#,grassz#)
g.grass = New grass

g\FileName$ = "Media\Trees\" + temp$ + ".b3d"

g\entity=LoadMesh(g\FileName$)

PositionEntity g\entity,grassx,grassy,grassZ
EntityPickMode g\entity,2


ScaleEntity g\entity,.3,.3,.3
RotateEntity g\entity,0,Rnd(1,90),0
Next
Next
End Function


Function userInput()
;catch user input


;2 Key F1
If KeyDown(59) Then TurnEntity camera,0,1,0
;3 Key F2
If KeyDown(60) Then TurnEntity camera,0,-1,0


;61 Key F3
If KeyHit(61) Then Wireframe True
;62 Key F4
If KeyHit(62)Then Wireframe False
;77 Num Right
If KeyDown(77) Then MoveEntity camera,4,0,0
;75 Num Left
If KeyDown(75) Then MoveEntity camera,-4,0,0
;72 Num Up
If KeyDown(72) Then MoveEntity camera,0,4,0
;76 Num Down/Middle
If KeyDown(76) Then MoveEntity camera,0,-4,0
;74 Num Subtract
If KeyDown(74) Then MoveEntity camera,0,0,-4
;78 Num Add
If KeyDown(78) Then MoveEntity camera,0,0,4
;82 Num 0/Ins
If KeyDown(82) Then TurnEntity camera,4,0,0
;83 Num Decimal/Del
If KeyDown(83) Then TurnEntity camera,-4,0,0

;57 Key Space
If KeyDown(57)
	;Left Button
	If MouseDown(1) Then MoveEntity camera,0,0,4
	;Right Button
	If MouseDown(2) Then MoveEntity camera,0,0,-4
	
EndIf	
	
End Function


Function placebuilding(model$)
;place a new model on the map

b.building = New building
b\entity = LoadMesh(model$)

MoveEntity camera,0,0,50

b\x = EntityX(camera)
b\y = EntityY(camera) 
b\z = EntityZ(camera)
terheight#= TerrainHeight(terrain,EntityX(camera),EntityZ(camera)) 
grassy# = TerrainY(terrain,EntityX(camera),terheight#,EntityZ(camera))

b\scaleX# =0.3
b\scaleY# =0.3
b\scaleZ# =0.3


ScaleEntity b\entity, .3,.3,.3
EntityPickMode b\entity,2
b\FileName$ = fullToLocalPath (CurrentDir$(),model$)



hit2 = False
NameEntity(b\entity,"Building")
PositionEntity b\entity,EntityX(camera),grassy,EntityZ(camera)

MoveEntity camera,0,0,-50




End Function


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

Function fullToLocalPath$(root$,fullpath$)
;takes the apps root and the full path and returns 
;only the subdirs from the full path
;if the root isn't in the full path then the whole 
;full path is returned
rootpos=Instr(fullpath$,root$)
If rootpos Then
Return Mid(fullpath$,rootpos+Len(root$))
EndIf
	
;root not in full, return full
Return fullpath$
End Function


Function control_mouseLook()
	;update mouselook for this frame
	
	mxs = MouseXSpeed()
	mys = MouseYSpeed()
		
	dest_xang# = dest_xang + mys
	dest_yang# = dest_yang - mxs
	
	xang# = CurveValue (xang, dest_xang, 3)
	yang# = CurveValue (yang, dest_yang, 3)
	
		
	RotateEntity camera,xang,yang#,0
	If dest_xang > 70 Then dest_xang = 70
	If dest_xang < -70 Then dest_xang = -70
		
End Function

Function CurveValue#(current#,destination#,curve)
	current#=current#+((destination#-current#)/curve)
	Return current#
End Function