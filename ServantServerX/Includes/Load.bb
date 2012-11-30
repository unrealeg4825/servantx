;-----------LOAD MODELS----------------
Global cam_pivot = CreatePivot()
Cls
SetBuffer FrontBuffer()
Flip
debugfile = WriteFile("Debuglog.txt")

WriteLine debugfile,"DATE: " + CurrentDate() + " : " + "TIME: " + CurrentTime() 
Cls
loading = LoadImage("loadingnew.jpg")
DrawImage loading,(GraphicsWidth()/2) - (ImageWidth(loading)/2),(GraphicsHeight()/2) - (ImageHeight(loading)/2)
Color 255,0,0
Rect 260,465,10,15,1
WriteLine debugfile,"loading image"


Global player_pivot = CreatePivot()

WriteLine debugfile,"PPIVOT"

Global ambiant1 = LoadSound("misc/sounds/ambiant1.mp3")

WriteLine debugfile,"Ambient sounds 1"


Global ambiant2 = LoadSound("misc/sounds/ambiant2.mp3")

WriteLine debugfile,"Ambient sounds 2"

Global nighthowl = LoadSound("misc/sounds/nighthowl.mp3")

WriteLine debugfile,"Ambient sounds 3"


Global sign = LoadAnimMesh("media/models/signs/sign.3ds")

WriteLine debugfile,"Signs"


Global Handle_Texture = LoadTexture("misc/flare1.bmp",2)

WriteLine debugfile,"Handle Textures"

Global help = LoadImage("misc/help.bmp")

WriteLine debugfile,"Help"

Rect 260,465,40,15,1


;Global pike = LoadMesh("Media\gfx\Weapons\Spears\Pike.3ds")
;RotateEntity pike,0,90,0
;ScaleEntity pike,.3,.3,.3


Global Celticaxe = LoadMesh("Media\gfx\Weapons\axe01.b3d")

WriteLine debugfile,"Celtic Axe"

Global Celticaxeimg = LoadImage("misc\celticaxeimg.png")

WriteLine debugfile,"CSIMG"

ScaleEntity Celticaxe,.05,.05,.05
EntityPickMode Celticaxe,2
NameEntity Celticaxe,"Celtic Axe"

WriteLine debugfile,"CS1properties"

Rect 260,465,80,15,1


Global tex1 = LoadTexture("fulltree2.bmp",4)


WriteLine debugfile,"Tex1"

Global spellbox = LoadImage("misc/spellbox.png")

WriteLine debugfile,"GUI part 1"


Global statusbox = LoadSprite("misc/status.png",4)

WriteLine debugfile,"GUI part 2"

Global healthpic = LoadSprite("misc/health.png",4)

WriteLine debugfile,"GUI part 3"

Global manapic = LoadSprite("misc/mana.png",4)

WriteLine debugfile,"GUI part 4"

Global invbutt = LoadImage("sprites/invbutt.png")
ScaleImage invbutt,1.12,1.17

WriteLine debugfile,"GUI part 5"

Global charbutt = LoadImage("sprites/charbutt.png")

WriteLine debugfile,"GUI part 6"
ScaleImage charbutt,1.17,1.17

Global datepic = LoadImage("misc/datebox.png")

WriteLine debugfile,"GUI part 7"

Global inv = LoadImage("sprites/inv.png")

WriteLine debugfile,"GUI part 8"

Global ripple = LoadSprite("ripple.bmp")
;RotateEntity ripple,90,0,0
;SpriteViewMode ripple,2
WriteLine debugfile,"GUI part 9"

Global woodtex = LoadTexture("Media\models\compass.jpg")

WriteLine debugfile,"GUI part 10"

Global compasspointertex = LoadTexture("Media\models\pointer.jpg",3)

WriteLine debugfile,"GUI part 11"
Global compassbase = CreateCylinder(12,1)
Global compass = CreateCube(compassbase);LoadMesh("Media\models\arrowcom.3ds",compassbase)
EntityTexture compass,compasspointertex

WriteLine debugfile,"COMPASS MODEL MADE"
Rect 260,465,130,15,1

Global thunder= LoadSound("misc/sounds/thunder.wav")

WriteLine debugfile,"Thunder.wav"


Rect 260,465,380,15,1
Global Tomb1 = LoadMesh("Media\gfx\TOMB\tomb.b3d")
;Global Tombentrance = LoadMesh("Media\gfx\TOMB\entrance.b3d")
WriteLine debugfile,"Tomb1.b3d"
Global gTextBox = LoadImage("misc\textbox.png")
WriteLine debugfile,"GUI part 12"

Global characterinfo = LoadImage("sprites\stats.png")
WriteLine debugfile,"GUI part 13"

Rect 260,465,400,15,1

Global rainsound = LoadSound("misc\sounds\rain.wav")

WriteLine debugfile,"Rain.wav"

Global gThisBox = LoadImage("misc\textbox.png")
;Spectre = LoadAnimMesh("Media\models\Player\Spectre\Spectre.3DS")
;Global Spectremove = ExtractAnimSeq(Spectre,0,40,0)

WriteLine debugfile,"GUI part 14"

Rect 260,465,480,15,1

WriteLine debugfile,"Graphics Engine Started ok! " + "DATE: " + CurrentDate() + " : " + "TIME: " + CurrentTime() 
CloseFile(debugfile)
;~IDEal Editor Parameters:
;~C#Blitz3D