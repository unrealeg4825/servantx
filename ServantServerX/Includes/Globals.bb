;Current Screen resolution x and y size. 
;Useful For relative/scalable positioning of 2d images, such as the in game menu images 
Global xvalue = (GraphicsWidth()/2)
Global yvalue = (GraphicsHeight()/2)


Global gLastMessageID
Const maxcharlength=51
Const LOWESTMESSAGERENDER=79
Const EDITMODE=True


Global ZoneName
Global Terrain
Global tex2
Global grass
Global ZoneID
Const  fpsupdate = 1000 ;cannot be less than 1000
Global fpscount
Global fpslastupdated
Global fpslastcount#
Global CP_X#
Global CP_Y#
Global WORLD$
Global SKYFORMAT$
Global CP_Z#
Global showinv
Global Gravity# = 0.16								;Game gravity
Global PlayerGravity# = -0.3
Global autowalk
Global FlyMode=0									;if 1 then flymode is on
Global WalkSpeed#=.4								;this handled the walking motion
Global Jumped=0										;Jump check
Global grassMesh
Global grassTexture
Global grassSurface
Global grassRange#
Global Spectre
Const Water_Col = 7
Const Wep_col = 8
Global entity

Type LogData
	Field Name$			; LOG NAME
	Field Value$        ; LOG VALUE
End Type

Type Valuable
	Field ID$			; NUMBER OF VALUABLE
	Field Value$		; VALUE OF VALUABLE
End Type

Type Vertices
	Field x#
	Field y#
	Field z#
End Type

Dim Vertex.Vertices(VertexCount)

Type Shop
	Field Items$		; ITEMS IT HAS (LIKE NPCS)
	Field GOL			; HOW MANY GOLDS THE SHOP KEEPER HAS
	Field POT			; HOW MANY POTIONS
	Field Weapons$		; WEAPONS FOR SALE
	Field Armors$		; ARMORS FOR SALE
End Type


Dim SlotName$(10)

puking = False
WORLD$ = "lvl"
; lets you use nice pngs Or bmps instead of jpgs.  affects skybox textures 
; only, not heightmaps or terrain textures.
SKYFORMAT$ = "bmp"

Const Lightning_Count=3
Global flash=0
Type lightning
	Field ent
	Field surf
	Field alpha#
End Type

Type lightningbolt
	Field x#,y#,z#,start,entity1,entity2,entity3
End Type

Global myname$
Global maxarrows = 50 ; max. number of bullets active
Global currbull = 0
Global Arrowspeed# = 1
Global reload_after = 50
Global Arrowcount = 50
Global Arrowgravity# =-.6
Dim Valuables$(500)

Global sound
Global camera
Global raining
Global gservertime#				;servertime
Global gdecmin# = 1.0/60.0		;1 server minute in millisecs
Global wep_type 
Global wep_power
Global Drinkbeer
Global AlcoholTolerance
Global recharge 
Global sendcounter 
Global CX#,CY#,CZ#
Global Health
Const TYPE_SHOOT = 1
Global chatstring$
Global chatenabled
Global grass1 
Global grass2
Global night
Global gGameTime$			
Const tomb_col = 6

Dim sounds(99)

Type obj
	Field x#,y#,z#
	Field entity
	Field FileName$ 
	Field yaw,pitch,roll
	Field visible
	Field scalex#,scaley#,scalez#
End Type

Type rocks
	Field x#,y#,z#
	Field entity
	Field FileName$
End Type


;Create a player
Type pdata
	Field X#,Y#,Z#,oldX#,OldY#,OldZ#,name$,net_id%,entity,yaw#,packetyaw#,namesprite,model,sex
	Field Experience,health,mana,strength,dexterity,Lvl,constitution,luck,charisma,Hitpoints,intelligence,hunger,Energy
	Field dataused,anim,splineid,packettime,lasttime,initialized,nomovement,packetx#,packety#,packetz#,Zone
	
End Type

Type grass
	Field x#,y#,z#
	Field entity
End Type

Type NPCS
	Field X#,Y#,Z#,oldX#,OldY#,OldZ#,name$,net_id%,entity,yaw#,packetyaw#,namesprite,model
	Field Experience,health,mana,strength,dexterity,Lvl,constitution,luck,charisma,Hitpoints,intelligence,hunger,Energy
	Field dataused,anim,splineid,packettime,lasttime,initialized,nomovement,packetx#,packety#,packetz#
	Field SIDE,Speed
	
End Type
Global WeaponsClass
Global WeaponName$



Type inventory
    Field wielded.Weapons
	Field amount
	Field holding
	Field Typeobj
	Field name$
	Field damage
	Field magicid
	Field bodyposition
	Field active
	Field container
	Field wieght
	Field size
	Field holdingcontainerID
	Field identifiedAsMagicItem 
	Field QuestItem
	Field spoils
	Field Icon
End Type

Type Weapons
	Field entity
	Field x#,y#,z#
	Field name$
	Field HP
	Field weight
	Field Strength
	Field Parent
	Field InventoryIcon
	Field InvetorySlot
	Field ID
	Field file$
End Type


Type Info
	Field txt$,set
End Type

Type User
	Field Nick$
End Type

Type Message
	Field Action%
	Field iText$,iColor%
	Field From$,fColor%
	Field id
End Type

; Modify these if you like :)
Const  WATER_GRID_SIZE = 16
Global WATER_HEIGHT# = 8.2

; Setup the water grid value
Dim WaterY(WATER_GRID_SIZE+1,WATER_GRID_SIZE+1)
For q = 0 To WATER_GRID_SIZE
	For j = 0 To WATER_GRID_SIZE
		WaterY(q,j) = Rnd(0,360)
	Next 
Next


Type Splashtex
	Field x#,y#
	Field sx#,sy#
	Field ox#,oy#
	Field c#
End Type

Type Splash3D
	Field sprite
	Field x#,y#,z#
	Field texture
	Field frame#,frames
	Field active
End Type

Type Rain3D
	Field sprite
	Field x#,y#,z#
	Field sx#,sy#,sz#
	Field active
End Type

Type Ring3D
	Field sprite
	Field x#,y#,z#
	Field texture
	Field frame#,frames
	Field active
End Type

Global experiance =10
Global energy = 54
Global weight = 30
Global Armor = 45
Global Strength = 80
Global Wisdom = 20
Global Dexterity = 66
Global Consitution = 73
Global luck = 70
Global hitpoints = 85
Global intelligence = 38
Global hunger = 10
Global mana = 100
Global level = 1

Type animal
	Field x#
	Field z#
	Field packetx#
	Field packetz#
	Field packety#
	Field y#
	Field yaw#
	Field packetyaw#
	Field entity
	Field id
	Field timestamp
	Field lasttime#
	Field splineid%
	Field distancetoplayer#
	

	
End Type

Global npccount = 20
Global s.Splashtex
Global s3d.Splash3D
Global r3d.Rain3D
Global t3d.Ring3D

SeedRnd MilliSecs()

; Colors
Global envr = 76
Global envg = 100
Global envb = 110

Global RainSpeed# = 2.0

;animation variables

Global initilizedplayerposition	;used to flag initial playerposition received
Global temppivot
Global dt
Global INITZone
Global helps ;help screen on/off toggle
Global myzone
Global oldmoved,moved ;playeranimation toggle

Global gDate$



Global FXCamera,CubeLightMapSize,CubeLightMapTexture,WaterMapSize,WaterMapTexture,waterdirection
Type entity
	Field ent
End Type

CubeLightMapSize = 256 ; the resolution of the dynamic lightmap *not used in this demo*
WaterMapSize = 256 ; the resolution of the water

Type bumptexture
	Field filename$
End Type
;~IDEal Editor Parameters:
;~C#Blitz3D