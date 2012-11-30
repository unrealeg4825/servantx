'-----------Load MODELS----------------
Global cam_pivot = xCreatePivot()
xCls
xSetBuffer xBackBuffer()
xFlip
debugfile:TStream = WriteFile("Debuglog.txt")

WriteLine debugfile,"DATE: " + CurrentDate() + " : " + "TIME: " + CurrentTime() 
xCls
loading = xLoadImage("loadingnew.jpg")
xDrawImage loading,(xGraphicsWidth()/2) - (xImageWidth(loading)/2),(xGraphicsHeight()/2) - (xImageHeight(loading)/2)
xColor 255,0,0
xRect 260,465,10,15,1
xFlip
WriteLine debugfile,"loading image"


Global player_pivot = xCreatePivot()

WriteLine debugfile,"PPIVOT"

Global ambiant1 = xLoadSound("misc/sounds/ambiant1.mp3")

WriteLine debugfile,"Ambient sounds 1"


Global ambiant2 = xLoadSound("misc/sounds/ambiant2.mp3")

WriteLine debugfile,"Ambient sounds 2"

Global nighthowl = xLoadSound("misc/sounds/nighthowl.mp3")

WriteLine debugfile,"Ambient sounds 3"


Global sign = xLoadAnimMesh("media/models/signs/sign.3ds")

WriteLine debugfile,"Signs"


Global Handle_Texture = xLoadTexture("misc/flare1.bmp",2)

WriteLine debugfile,"Handle Textures"

Global help = xLoadImage("misc/help.bmp")

WriteLine debugfile,"Help"

xRect 260,465,40,15,1
xFlip

'Global pike = LoadMesh("Media\gfx\Weapons\Spears\Pike.3ds")
'RotateEntity pike,0,90,0
'ScaleEntity pike,.3,.3,.3


Global Celticaxe = xLoadMesh("Media\gfx\Weapons\axe01.b3d")

WriteLine debugfile,"Celtic Axe"

Global Celticaxeimg = xLoadImage("misc\celticaxeimg.png")

WriteLine debugfile,"CSIMG"

xScaleEntity Celticaxe,.05,.05,.05
xEntityPickMode Celticaxe,2
xNameEntity Celticaxe,"Celtic Axe"

WriteLine debugfile,"CS1properties"

xRect 260,465,80,15,1
xFlip

Global tex1 = xLoadTexture("fulltree2.bmp",4)


WriteLine debugfile,"Tex1"

Global spellbox = xLoadImage("misc/spellbox.png")

WriteLine debugfile,"GUI part 1"


Global statusbox = xLoadSprite("misc/status.png",4)

WriteLine debugfile,"GUI part 2"

Global healthpic = xLoadSprite("misc/health.png",4)

WriteLine debugfile,"GUI part 3"

Global manapic = xLoadSprite("misc/mana.png",4)

WriteLine debugfile,"GUI part 4"

Global invbutt = xLoadImage("sprites/invbutt.png")
xScaleImage invbutt,1.12,1.17

WriteLine debugfile,"GUI part 5"

Global charbutt = xLoadImage("sprites/charbutt.png")

WriteLine debugfile,"GUI part 6"
xScaleImage charbutt,1.17,1.17

Global datepic = xLoadImage("misc/datebox.png")

WriteLine debugfile,"GUI part 7"

Global inv = xLoadImage("sprites/inv.png")

WriteLine debugfile,"GUI part 8"

Global ripple = xLoadSprite("ripple.bmp")
'RotateEntity ripple,90,0,0
'SpriteViewMode ripple,2
WriteLine debugfile,"GUI part 9"

Global woodtex = xLoadTexture("Media\models\compass.jpg")

WriteLine debugfile,"GUI part 10"

Global compasspointertex = xLoadTexture("Media\models\pointer.jpg",3)

WriteLine debugfile,"GUI part 11"
Global compassbase = xCreateCylinder(12,1)
Global compass = xCreateCube(compassbase)'LoadMesh("Media\models\arrowcom.3ds",compassbase)
xEntityTexture compass,compasspointertex

WriteLine debugfile,"COMPASS MODEL MADE"
xRect 260,465,130,15,1
xFlip
Global thunder= xLoadSound("misc/sounds/thunder.wav")

WriteLine debugfile,"Thunder.wav"


xRect 260,465,380,15,1
xFlip
Global Tomb1 = xLoadMesh("Media\gfx\TOMB\tomb.b3d")
'Global Tombentrance = LoadMesh("Media\gfx\TOMB\entrance.b3d")
WriteLine debugfile,"Tomb1.b3d"
Global gTextBox = xLoadImage("misc\textbox.png")
WriteLine debugfile,"GUI part 12"

Global characterinfo = xLoadImage("sprites\stats.png")
WriteLine debugfile,"GUI part 13"

xRect 260,465,400,15,1
xFlip
Global rainsound = xLoadSound("misc\sounds\rain.wav")

WriteLine debugfile,"Rain.wav"

Global gThisBox = xLoadImage("misc\textbox.png")
'Spectre = LoadAnimMesh("Media\models\Player\Spectre\Spectre.3DS")
'Global Spectremove = ExtractAnimSeq(Spectre,0,40,0)

WriteLine debugfile,"GUI part 14"

xRect 260,465,480,15,1
xFlip
WriteLine debugfile,"Graphics Engine Started ok! " + "DATE: " + CurrentDate() + " : " + "TIME: " + CurrentTime() 
CloseFile(debugfile)
'~IDEal Editor Parameters:
'~C#Blitz3D