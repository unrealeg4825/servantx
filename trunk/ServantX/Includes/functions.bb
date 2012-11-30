Function Collide_with_Zone_warps()

If myzone = 1 Then
If EntityX(player_pivot) > 2540 Then ;left zone
CreateZone(2)
EndIf

If EntityZ(player_pivot) < 1 Then ;north zone
CreateZone(3)
EndIf


If EntityX(player_pivot) < 1 Then ;left zone
CreateZone(4)
EndIf

If EntityZ(player_pivot) > 2540 Then ;north zone
CreateZone(3)
EndIf
EndIf

If myzone = 2 Then

If EntityX(player_pivot) > 2540 Then ;left zone
CreateZone(3)
EndIf

If EntityZ(player_pivot) < 1 Then ;north zone
CreateZone(4)
EndIf


If EntityX(player_pivot) < 1 Then ;left zone
CreateZone(2)
EndIf

If EntityZ(player_pivot) > 2540 Then ;north zone
CreateZone(1)
EndIf
EndIf

If myzone = 3 Then

If EntityX(player_pivot) > 2540 Then ;left zone
CreateZone(4)
EndIf

If EntityZ(player_pivot) < 1 Then ;north zone
CreateZone(2)
EndIf


If EntityX(player_pivot) < 1 Then ;left zone
CreateZone(1)
EndIf

If EntityZ(player_pivot) > 2540 Then ;north zone
CreateZone(2)
EndIf
EndIf

End Function

Function convertGameTime$()
	temp$=gGameTime
	hours = Int(temp)
	mins = 60*(Float(gGameTime)-hours)
	Return hours + ":" + mins
End Function

Function Create_lightning(gx#,gy#,gz#,high#,seg)
	;create a lightning bolt sequence with sprites and position ready for use, also set the various alpha levels
	l.lightningbolt = New lightningbolt
	l\x=gx
	l\z=gz
	terheight#= TerrainHeight(Terrain,l\x,l\z) 
	spoty#=TerrainY(Terrain,l\x,terheight,l\z)
	ly#=spoty+1000
	l\entity1 = LoadSprite ("sprites\lightning1frame1.png",2)
	l\entity2 = LoadSprite ("sprites\lightning1frame2.png",2)
	l\entity3 = LoadSprite ("sprites\lightning1frame2.png",2)
	EntityFX l\entity1,25
	EntityFX l\entity2,25
	EntityFX l\entity3,25
	ScaleSprite l\entity1,50,1250
	ScaleSprite l\entity2,50,1250
	ScaleSprite l\entity3,50,1250
	SpriteViewMode l\entity1,2
	SpriteViewMode l\entity2,2
	SpriteViewMode l\entity3,2
	PositionEntity l\entity1,gx,gy,gz
	PositionEntity l\entity2,gx,gy,gz
	PositionEntity l\entity3,gx,gy,gz
	ly#=Rnd(0,360)
	RotateEntity l\entity1,0,ly,0
	RotateEntity l\entity2,0,ly,0
	RotateEntity l\entity3,0,ly,0
	
	EmitSound thunder,l\entity1
	l\start=MilliSecs()
	flash=255
End Function

Function CreatePlayer.pdata(name$, id%)
	Local p.pdata = New pdata
		
;For msg.MsgInfo = Each MsgInfo
	p\initialized=False						;haven't got enough position data for spline
	;p\name = Mid$(msg\msgData,1,4) 
	p\name = Left(name$,Len(name$)-2)
	;p\model = Mid$(msg\msgData,5,4)
	p\model = Mid(name$,Len(name$)-1,1) 
	;p\sex = Mid$(msg\msgData,9,4)
	p\sex = Mid(name$,Len(name$),1)
	p\net_id = id
	
	;p\x = 0
	;p\y = -200
	;p\z = 0

	
	
	temp=p\model
	
	;p\splineID = BP_CreateSpline()
	
	Select p\model 
       	Case 2              ;amazon 
			p\entity = CopyEntity(Amazon) 
			
		Case 3
		    p\entity = CopyEntity(Spectra) 
	
		Default               ;knight 
        	p\entity = CopyEntity(player) 
			;p\entity = LoadAnimMesh("media/models/player/knight.b3d")
    End Select 
	p\lasttime=250
	p\packettime=MilliSecs()
	
    RotateEntity p\entity,0,90,0
    ScaleEntity p\entity,2.3,2.3,2.3
    createtext(p\name,p\entity)
    p\namesprite = 1

   ;gE_IdEmitter = EPS_Init_Emitter(109.0,5.0,2.02,2.0,180.0, p\entity,1.7,1.6,1.6,camera,3,1,1,1,0.0)
    ;EPS_Init_Particule(gE_IdEmitter ,1.34,1.17,5.03,0.0,handle_texture,1,1.0,3,1,1.0,0.0,0.0,1.0,0.0,0.0,0,0)
    ;EPS_Init_ParticuleColor( gE_IdEmitter,95.0,118.0,137.0,48.0,101.0,57.0,0.0,58.0,17.0)
;Next
	Return p
End Function

Function createtext(ctname$,ctent)
		
	tagWidth = Len(ctname$)*(FontWidth()/4)
	tagheight = FontHeight()+1
	
	nametex = CreateTexture(tagWidth,tagheight, 1+4+8)
	nameimg = CreateImage(tagWidth,tagheight)
	SetBuffer ImageBuffer(nameimg)
	Color 254,149,0
	Text 0,0,ctname$
	;Text 2,0,ctname$
	;Text 0,2,ctname$
	;Text 2,2,ctname$
	;Color 255,0,0
	;Text 1,1,ctname$


	MaskImage nameimg, 0, 0, 0
	
	CopyRect 0,0, tagWidth, tagheight, 0, 0, ImageBuffer(nameimg), TextureBuffer(nametex)
			
		
	SetBuffer BackBuffer()
	
	TEXTUREmask(nametex)
	
		
	spr = CreateSprite(ctent)
	SpriteViewMode spr,1
	
	
	EntityTexture spr,nametex

	ScaleSprite spr,1.5,.5
	PositionEntity spr,0,2.5,0
	;FreeTexture nametex
	Return spr
End Function

Function TEXTUREmask( texture , sr=0 , sg=0 , sb=0, st = 1 )

	TW = TextureWidth( texture )
	TH = TextureHeight( texture )
	SetBuffer TextureBuffer( texture )
	LockBuffer 
	For j = 0 To TH- 1
		For i = 0 To TW - 1
			argb = ReadPixelFast( i,j, TextureBuffer( texture ) )
			r = ( argb And $FF0000) Shr 16
			g = ( argb And $FF00 ) Shr 8  
			b = ( argb And $FF )  
			a = ( argb And $FF000000 ) Shr 24
			
			If ( r > sr-st And r < sr+st ) And  ( g > sg-st And g < sg+st ) And ( b > sb-st And b < sb+st )
				a = 0 
				
				r = 0
				g = 0
				b = 0
			
			Else
				a = 255
			EndIf
			argb = ( a Shl 24 ) Or ( r Shl 16 ) Or ( g Shl 8 ) Or b	
			WritePixelFast i , j , argb, TextureBuffer( texture )
		Next
	Next			
	UnlockBuffer
	SetBuffer BackBuffer()
		
End Function

Function create_water_ripple(entity,surface,colindex)
If EntityCollided(entity,colindex) Then
For rr.rain_ripple=Each rain_ripple
            rr\ent = CopyEntity(ripple)
			rr\life#=rr\life#-1
			ScaleSprite rr\ent,4*(1-rr\life#/10),4*(1-rr\life#/10)
			EntityAlpha rr\ent,rr\life#/10*0.5
rx=EntityX(rr\ent)
rz=EntityZ(rr\ent)
waterheight= TerrainHeight(surface,rx,rz) 
waterspoty#=TerrainY(surface,rx,waterheight,rz)
PositionEntity rr\ent,EntityX(entity,True),waterspoty#,EntityZ(entity,True)
			If rr\life#=<0
				FreeEntity rr\ent
				Delete rr.rain_ripple
			EndIf
		Next

End If
End Function

Function CreateZone(zoneID,tombs=False)
LeaveZone()
If tombs = False
Terrain = LoadTerrain("Media\Zone\"+zoneID+"\lvl_hmap"+zoneID+".bmp")
tex2 = LoadTexture("Media\Zone\"+zoneID+"\lvl_detail"+zoneID+".bmp")
grass = LoadTexture("Media\Zone\"+zoneID+"\lvl_tmap"+zoneID+".jpg")
ScaleTexture grass,256,256
ScaleEntity Terrain,10,300,10
PositionEntity Terrain,0,0,0,True
ScaleTexture tex2,8,8
TerrainDetail Terrain,2000,True
EntityTexture Terrain,grass
EntityTexture Terrain,tex2,0,1
EntityType Terrain,1

grassMesh=CreateMesh()
grassTexture=LoadTexture("sprites\Zone\"+zoneID+"\grass.png",3)
;EntityFX grassMesh,1
;EntityAlpha grassmesh,0.5
grassSurface=CreateSurface(grassMesh)
EntityTexture grassMesh,grassTexture
grassRange#=100

positiongrass(Terrain)

;loadnpc(zoneID)

treefile = ReadFile("Media\Zone\"+zoneID+"\obj"+zoneID+".t3d")
While Not Eof(treefile)
	o.obj = New obj
	o\FileName=ReadString(treefile)
	;TextureFilter "tree",4
	o\entity=LoadMesh(o\FileName)
	o\x=ReadFloat(treefile)
	o\y=ReadFloat(treefile)
	o\z=ReadFloat(treefile)
	;o\yaw=ReadFloat(treefile)
	PositionEntity o\entity,o\x,o\y,o\z
	RotateEntity o\entity,0,Rnd(0,360),0
	EntityType o\entity,1
	ScaleEntity o\entity,.3,.3,.3
	;EntityTexture o\entity,tex1
	EntityAutoFade o\entity,700,900	
Wend
CloseFile(treefile)

buildings = ReadFile("Media\Zone\"+zoneID+"\buildings"+zoneID+".t3d")
While Not Eof(buildings)
	o.obj = New obj
	o\FileName=ReadString(buildings)
	;TextureFilter "tree",4
	o\entity=LoadMesh(o\FileName)
	o\x=ReadFloat(buildings)
	o\y=ReadFloat(buildings)
	o\z=ReadFloat(buildings)
	o\pitch=ReadFloat(buildings)
	o\yaw=ReadFloat(buildings)
	o\roll=ReadFloat(buildings)
	
	o\scaleX# =ReadFloat(buildings)
	o\scaleY# =ReadFloat(buildings)
	o\scaleZ# =ReadFloat(buildings)
	
	
	PositionEntity o\entity,o\x,o\y,o\z
	RotateEntity o\entity,o\pitch,o\yaw,o\roll
	EntityType o\entity,1
	ScaleEntity o\entity,.3,.3,.3
	;EntityTexture o\entity,tex1
	EntityAutoFade o\entity,700,900	
Wend
CloseFile(buildings)


wepsFile = ReadFile("Char\Data\"+zoneID+"\weps.dat")
While Not Eof(wepsFile)
	w.weapons = New Weapons
	w\file = ReadLine(wepsFile)
	w\name$ = ReadLine(wepsfile)
	w\ID = ReadLine(wepsfile) 
	w\x=ReadLine(wepsfile)
	w\y=ReadLine(wepsfile)
	w\z=ReadLine(wepsfile)
	w\weight=ReadLine(wepsfile)
    w\Strength=ReadLine(wepsfile)
    
	
	
	w\entity = CopyEntity(Celticaxe)
	;w\entity = LoadMesh(w\file)
	PositionEntity w\entity,w\x,w\y,w\z
	EntityType w\entity,Wep_col
	ScaleEntity w\entity,.3,.3,.3
	EntityAutoFade w\entity,700,900	
	EntityPickMode w\entity,2
Wend
CloseFile(wepsFile)




Else

	tomb = LoadMesh("Media\gfx\TOMB\"+zoneID+".b3d")

EndIf
myzone = zoneID
BP_UDPMessage(0,4,zoneID,False,False)
Select zoneID
Case 1 
irc_log " You are now in Alnion.",$3366FF

Case 2
irc_log " You are now in Alnion Forest.",$3366FF

Case 3
irc_log " You are now in Forbidding lands.",$3366FF

Case 4
irc_log " You are now in Mackmore",$3366FF

Case 5 
irc_log " You are now in Mackmore Tomb",$3366FF


End Select


    playerx#=EntityX(player_pivot,True)
	playerz#=EntityZ(player_pivot,True)
	terheight= TerrainHeight(Terrain, playerx#, playerz#) 
	spoty#=TerrainY(Terrain,playerx#,terheight, playerz#)

End Function

Function debugtext()
	;Text 50,50,sound ;"PING: " + BP_getmyping%()
	;Text 50,60,Entitycollide(camera,townborder);EntityX(camera,True)
	;Text 50,70,EntityY(camera,True)
	;Text 50,80,EntityZ(camera,True);"Server Time : " + gservertime
	;Text 50,90,grassmapscale + " : " + tempgrassx# + " : " + tempgrassy#
	;For p.pData = Each pdata
	;Text 50,100,"current cloud cover = " + weatherdensity$
	;Text 50,140,TrisRendered()
	If wanttoleave=True Then
		timetoquit=Int((quitdelay-leavingworld)/1000.0)
		Text 50,120,"REQUESTING EXIT WORLD (" + timetoquit + " secs) - MOVE TO CANCEL"
	EndIf
	SetFont fntArial
	Color 158,13,6
	Text 143,38,gDate
	
End Function

Function Distance#(x1#, y1#, x2#, y2#)
	width# = x1# - x2#
	height# = y1# - y2#
	dist# = Sqr#(width * width + height * height) 
	Return dist

End Function

Function FindBreak(msg$,cnt,bChr$=" ")
	Local break%=1
	For i=0 To cnt
		break=Instr(msg,bChr,break+1)
		If Not break Exit
	Next
	Return break
End Function

Function Find.User(nick$)
	For u.user=Each User
		If u\nick=nick Return u.user
	Next
End Function

Function FindPdata.pdata(id%)
	;Hunt for the player information that matches id%
	For p.pdata = Each pdata
		If p\net_id = id Then Return p
	Next
End Function

;------FPS CODE--------------
Function fps()
	
	If MilliSecs() - fpslastupdated > fpsupdate
	
		fpslastcount# = (Float(fpscount / Float(fpsupdate/1000)))
		fpscount = 0
		fpslastupdated = MilliSecs()
	
	Else
	
		fpscount = fpscount + 1
	
	EndIf
	
	Return Int(fpslastcount)
	
End Function
;---------------------------------

;----------------------------MAIN MENU-------------------------
Function mainmenu()
Cls
 menubackground = LoadImage("misc\menu\menuback.bmp")
 startbutt = LoadImage("misc\menu\startbutt.bmp")
 Optionsbutt = LoadImage("misc\menu\optionsbutt.bmp")
 Creditsbutt = LoadImage("misc\menu\Creditsbutt.bmp")
 Exitbutt = LoadImage("misc\menu\Exitbutt.bmp")
 startbutt2 = LoadImage("misc\menu\startbutt2.bmp")
 Optionsbutt2 = LoadImage("misc\menu\optionsbutt2.bmp")
 Creditsbutt2 = LoadImage("misc\menu\Creditsbutt2.bmp")
 Exitbutt2 = LoadImage("misc\menu\Exitbutt2.bmp")
 pointer = LoadImage("misc\pointer.png")
SetBuffer BackBuffer()
HidePointer 
While Not KeyHit(1)
Cls
startimg = 1
optionimg = 1
Creditimg = 1
Exitimg = 1



If ImagesOverlap(startbutt,xvalue - (ImageWidth(startbutt)/2)-32,yvalue - (ImageHeight(startbutt)/2)-32 - 140,pointer,MouseX()-88,MouseY()-27) Then
startimg = 0
EndIf

If ImagesOverlap(Optionsbutt,xvalue - (ImageWidth(Optionsbutt)/2)-32,yvalue - (ImageHeight(Optionsbutt)/2)-32 - 80,pointer,MouseX()-88,MouseY()-27) Then
optionimg = 0
EndIf

If ImagesOverlap(Creditsbutt,xvalue - (ImageWidth(Creditsbutt)/2)-32,yvalue - (ImageHeight(Creditsbutt)/2)-32 - 20,pointer,MouseX()-88,MouseY()-27) Then
Creditimg = 0
EndIf

If ImagesOverlap(Exitbutt,xvalue - (ImageWidth(Exitbutt)/2)-32,yvalue - (ImageHeight(Exitbutt)/2)-32 + 40,pointer,MouseX()-88,MouseY()-27) Then
Exitimg = 0
EndIf

If MouseDown(1) And ImageRectOverlap(Optionsbutt2,xvalue - (ImageWidth(Optionsbutt2)/2),yvalue - (ImageHeight(Optionsbutt2)/2) - 80,MouseX(),MouseY(),1,1) Then
;options()
EndIf

If MouseDown(1) And ImageRectOverlap(Creditsbutt2,xvalue - (ImageWidth(Creditsbutt2)/2),yvalue - (ImageHeight(Creditsbutt2)/2) - 20,MouseX(),MouseY(),1,1) Then
;Credits()
EndIf


If MouseDown(1) And ImageRectOverlap(Exitbutt2,xvalue - (ImageWidth(Exitbutt2)/2),yvalue - (ImageHeight(Exitbutt2)/2) + 40,MouseX(),MouseY(),1,1) Then
End
EndIf




DrawImage menubackground,xvalue - (ImageWidth(menubackground)/2) - 1,yvalue - (ImageHeight(menubackground)/2) - 45

If startimg = 1 Then
	DrawImage startbutt,xvalue - (ImageWidth(startbutt)/2),yvalue - (ImageHeight(startbutt)/2) - 140
Else
	DrawImage startbutt2,xvalue - (ImageWidth(startbutt2)/2),yvalue - (ImageHeight(startbutt2)/2) - 140
EndIf

If optionimg = 1 Then
	DrawImage Optionsbutt,xvalue - (ImageWidth(Optionsbutt)/2),yvalue - (ImageHeight(Optionsbutt)/2) - 80
Else
	DrawImage Optionsbutt2,xvalue - (ImageWidth(Optionsbutt2)/2),yvalue - (ImageHeight(Optionsbutt2)/2) - 80
EndIf

If Creditimg = 1 Then
	DrawImage Creditsbutt,xvalue - (ImageWidth(Creditsbutt)/2),yvalue - (ImageHeight(Creditsbutt)/2) - 20
Else
	DrawImage Creditsbutt2,xvalue - (ImageWidth(Creditsbutt2)/2),yvalue - (ImageHeight(Creditsbutt2)/2) - 20
EndIf

If Exitimg = 1 Then
	DrawImage Exitbutt,xvalue - (ImageWidth(Exitbutt)/2),yvalue - (ImageHeight(Exitbutt)/2) + 40
Else
	DrawImage Exitbutt2,xvalue - (ImageWidth(Exitbutt2)/2),yvalue - (ImageHeight(Exitbutt2)/2) + 40
EndIf


DrawImage pointer,MouseX(),MouseY()




Flip
If MouseDown(1) And ImageRectOverlap(startbutt2 ,xvalue - (ImageWidth(startbutt2)/2),yvalue - (ImageHeight(startbutt2)/2) - 140,MouseX(),MouseY(),1,1) Then
Exit
EndIf
Wend

FreeImage menubackground
FreeImage startbutt
FreeImage startbutt2
FreeImage Optionsbutt
FreeImage Optionsbutt2
FreeImage Creditsbutt
FreeImage Creditsbutt2
FreeImage Exitbutt
FreeImage Exitbutt2
FreeImage pointer 

End Function
;-------------------------------------------END MENU------------------------------------------

Function GammaFade(speed)
	If speed=0 Return 0
	f=-255*(speed>0)
	Repeat
		f=f+speed
		For g=0 To 255
			SetGamma g,g,g, g+f,g+f,g+f
		Next
		UpdateGamma
		Delay 1
		If f<=-255 Or f>=0 Then Exit
	Forever	
End Function

Function GammaReset()
 For g=0 To 255
  SetGamma g,g,g, g,g,g
 Next
 UpdateGamma
End Function

Function GetAction$(msg$)
	Local break%=Instr(msg," ")
	If Not break Return ""
	
	If Upper(Left(msg,break))=(Chr(1)+"ACTION ") And Mid(msg,Len(msg),1)=Chr(1)
		Return Mid(msg,break+1,Len(msg)-break-1)
	Else
		Return ""
	EndIf
End Function

Function GetCommand$(msg$,bChr$=" ")
	Local break%=Instr(msg,bChr)
	If break Return Left(msg,break-1) Else Return msg
End Function

Function GetContext$(msg$)
	Local break1%=Instr(msg,":")
	Local break2%=Instr(msg,":",break1+1)

	Return Mid(msg,break2+1)
End Function

Function GetFromNick$(msg$)
	Return Mid(msg,Instr(msg,":")+1,(Instr(msg,"!")-Instr(msg,":")-1))
End Function

Function GetFromTo$(msg$,sChr$,sCnt%,eChr$,eCnt%)
	Local cStart%=FindBreak(msg,sCnt,sChr):If Not cStart cStart=1
	Local cEnd%=FindBreak(msg,eCnt,eChr)
	
	Return Mid(msg,cStart,cEnd-cStart)
End Function

Function GetPar$(msg$,par%=0,bChr$=" ")
	Local sbreak%=1,ebreak%
	
	For i=0 To par
		If Instr(msg,bChr,sbreak+1)
			sbreak=Instr(msg,bChr,sbreak+1)
		Else
			Exit
		EndIf
	Next
	
	ebreak=Instr(msg,bChr,sbreak+1)
	If ebreak
		Return Mid(msg,sbreak+1,ebreak-sbreak-1)
	Else
		Return Mid(msg,sbreak+1)
	EndIf
End Function

;-----------------NETFUNCTIONS
Function HandleMessages()	;Deal with all the messages that were received this frame.
	For msg.MsgInfo = Each MsgInfo	;MsgInfo is the type list BlitzPlay uses for received packets
		Select msg\msgType			;Check against the msgType
			Case BP_PLAYERHASJOINED	
				;Someone joined!
				If msg\msgfrom <> 1 Then
					p.pdata = CreatePlayer(msg\msgData, msg\msgFrom)
					visibleMessageAdd(" joined.",p\Name,1,$ffffff,$ffffff) 
					
					
	            EndIf                              
    	        ;p\entity = LoadAnimMesh("models\run.b3d")

        	Case BP_PLAYERHASLEFT          ;Someone left! 
            	p.pdata = FindPdata(msg\msgFrom) 
                If p<>Null Then  
					visibleMessageAdd(" left the world.",p\Name,1,$ffffff,$ffffff)
                	FreeEntity (p\entity) 
					
;					DeleteFile p\name+".png"
                    Delete p
                EndIf
        	Case BP_HOSTHASLEFT			;The host left, lets close down the game.
				For p.pdata = Each pdata
					Delete p
					DeleteFile p\name+".png"
				Next
				BP_EndSession ()
				End
			Case 1		;A positional update
				p.pdata = FindPdata(msg\msgFrom)
				
				If p<>Null Then			;error check to make sure this person is in the game		
					;PositionEntity p\entity,p\packetx,p\packety,p\packetz
					p\x=EntityX(p\entity)
					p\y=EntityY(p\entity)
					p\z=EntityZ(p\entity)
					
				    p\packetx# = BP_StrToFloat(Mid$(msg\msgData,1,4))
					p\packety# = BP_StrToFloat(Mid$(msg\msgData,5,4))
					p\packetz# = BP_StrToFloat(Mid$(msg\msgData,9,4))
										
					newyaw#=BP_StrToFloat(Mid$(msg\msgData,13,4))

					PositionEntity temppivot,p\packetx,p\packety,p\packetz
					RotateEntity temppivot,0,newyaw+180,0
					;spd#=EntityDistance (p\entity,temppivot)/2.0
					;MoveEntity temppivot,0,spd,0
					
								
					
					x2# =EntityX(temppivot)
					z2# =EntityZ(temppivot)

					;PositionEntity temppivot,p\x,p\y,p\z
					;RotateEntity temppivot,0,EntityYaw(p\entity),0
					;MoveEntity temppivot,0,spd,0
					;x1#=EntityX(temppivot)
					;z1#=EntityZ(temppivot)
					;
					p\yaw=newyaw

										
					p\lasttime=MilliSecs()-p\packettime
					;If ani\id=1 Then DebugLog ani\lasttime
					p\packettime=MilliSecs()
					
					If p\initialized=False Then
						p\x=p\packetx
						p\y=p\packety
						p\z=p\packetz
						x1=p\packetx
						x2=p\packetx
						z1=p\packetz
						z2=p\packetz
						p\packettime=MilliSecs()
						p\lasttime=250
						PositionEntity p\entity,p\x,p\y,p\z
						p\initialized=True
					EndIf
					
					;BP_Initspline (p\splineid,p\x,p\z,x1,z1,x2,z2,p\packetx,p\packetz)
					
					
					RotateEntity p\entity,0,p\yaw,0
					p\dataused=False
			
					DebugLog "PACKET IN:" + p\net_id +" - " + p\packetx + "," + p\packetz + " -- " + p\x + "," + p\z
					
				End If	
				
				
          	Case 4    
            	p.pdata=FindPdata(msg\msgFrom)
            	p\model = Mid$(msg\msgData,1,4) ;Mid$(msg\msgData,Len(msg\msgData)-1,1)
                p\sex = Mid$(msg\msgData,5,4) ;Mid$(msg\msgData,Len(msg\msgData),1)

			Case 5
			
     	  		tUID$=Left(msg\msgData,Instr(msg\msgData,":")) 
      	  		tMsg$=Mid(msg\msgData,Instr(msg\msgData,":")+1) 
				
				If msg\msgfrom = 1 Then
					
					If Left(msg\msgdata,7)="SYSTEM:" And Instr(msg\msgdata,"was kicked")>0 Then
						
						;a player was kicked, remove his model
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
						tempmsg$=msg\msgdata
						tempmsg = Replace (tempmsg,"SYSTEM:","")
						tempmsg = Replace (tempmsg," was kicked.","")
					
						If myname=tempmsg Then End
						For kp.pdata = Each pdata
							If kp\name = tempmsg Then
								FreeEntity (kp\entity) 
	                        	DeleteFile kp\name+".png"
								Delete kp
							EndIf
						Next
					EndIf
					;copied from below
					If Left(msg\msgdata,7)="SYSTEM:" Or Left(msg\msgdata,3)="|A:"
						;hmmm
						;server message don't display in chat
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
					EndIf	
				Else
					If Left(msg\msgdata,7)="SYSTEM:" Or Left(msg\msgdata,3)="|A:"
						;hmmm
						;server message don't display in chat
					visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff)

					Else
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
					EndIf
				EndIf	
					
					
					
					
					
					
					
					
					
					;COLLECT PLAYER POSITION FROM SERVER
; 
;					If Left(msg\msgdata,11)="SYSTEM:PLPS"
;						playerpos$=Replace(msg\msgdata,"SYSTEM:PLPS ","")
;						DebugLog "PLAYER WARPED TO " + playerpos
;						axis=0
;						For icount = 1 To Len(playerpos)
;							If Mid$(playerpos,icount,1)="-" Then 
;								Select axis
;									Case 0
;										;X axis
;										newposx#=Left(playerpos,icount-1)
;										nextstartpos=icount+1
;										axis=1
;									Case 1
;										;Y axis
;										newposy#=Mid(playerpos,nextstartpos,(icount-nextstartpos)-1)
;										newposz#=Mid(playerpos,icount+1)
;								End Select
;							EndIf
;						Next
;						PositionEntity player_pivot,newposx,newposy+5,newposz
;					EndIf
					
			Case 6
				;we just arrived on the zone, get initial position from server
				initx# = BP_StrToFloat(Mid$(msg\msgData,1,4))
				inity# = BP_StrToFloat(Mid$(msg\msgData,5,4))
				initz# = BP_StrToFloat(Mid$(msg\msgData,9,4))
				inityaw#=BP_StrToFloat(Mid$(msg\msgData,13,4))
				model =  BP_StrToFloat(Mid$(msg\msgData,17,4))
				mysex =  BP_StrToFloat(Mid$(msg\msgData,21,4))
				Health = BP_StrToFloat(Mid$(msg\msgData,25,4))
				INITZone = BP_StrToFloat(Mid$(msg\msgData,29,4))
						
				PositionEntity player_pivot,initx#,inity#+5,initz#
				RotateEntity player_pivot,0,inityaw,0
				DebugLog "Got start coords of " + initx + "," + inity + "," + initz + ",yaw=" + inityaw
				initilizedplayerposition=True
			Case 7
				;animals update
				tix#=BP_StrToFloat(Mid(msg\msgdata,1,4))
				tiz#=BP_StrToFloat(Mid(msg\msgdata,5,4))
				tiy#=BP_StrToFloat(Mid(msg\msgdata,9,4))
				tid= BP_StrToInt  (Mid(msg\msgdata,13))
				updateAnimalPosition(tid,tix,tiz,tiy)
			Case 8
				;lightning
				lx#=BP_StrToFloat(Mid(msg\msgdata,1,4))
				lz#=BP_StrToFloat(Mid(msg\msgdata,5,4))
				 Create_lightning(lx,lz,250,500,20) 
			Case 9
				;weather
				weatherdensity$= BP_StrToFloat(Mid(msg\msgdata,1,4))
				;DebugLog "weather = " + weatherdensity$
			Case 10
				;time of day			
				If Left(msg\msgdata,1)="T" Then
					gGameTime=Mid(msg\msgdata,2)
					gservertime=gGameTime
					;DebugLog "TIME SET TO " + convertGameTime()
				Else
					gDate=Mid(msg\msgdata,2)
					;DebugLog "CURRENT DATE SET TO " + gdate
				EndIf
		End Select
		Delete msg
	Next
End Function

Function Info(t$,set%)
	i.Info = New Info
	i\txt$ = t$
	i\set% = set%
	Insert i Before First Info
End Function

Function irc_log(iText$,iColor=$FFFFFF,from$="",fColor=$3399FF)
	Local i=0
	action$=GetAction(iText)

	If action<>""
		iText=action
		action=1
	EndIf

	visibleMessageAdd(iText,from,action,iColor,fColor)
End Function

Function LeaveZone()
FreeEntity Terrain

For o.obj = Each  obj
If o\entity > 0 Then
FreeEntity o\entity
;o\entity = 0;added by me
EndIf

Next

;For p.pdata = Each pdata
;FreeEntity p\entity
;Next

FreeTexture tex2
FreeTexture grass
End Function

Function loadnpc(ZoneID)
npcloadfile = ReadFile("Char\Data\"+ZoneID+"\npc.dat")
While Not Eof(npcloadfile) 
n.npcs = New NPCS
	n\name = ReadLine(npcloadfile)
	model$ = ReadLine(npcloadfile)
	;n\splineID = BP_CreateSpline()
	n\entity = LoadMesh("Media\models\Player\Spectre\Spectre.3DS")
	ScaleEntity n\entity,2.3,2.3,2.3
	EntityType n\entity,2
    createtext(n\name,n\entity)
    n\namesprite = 1
    n\x# = ReadLine(npcloadfile)
    n\z# = ReadLine(npcloadfile)
    terheight= TerrainHeight(Terrain,n\x#,n\z#) 
	spoty#=TerrainY(Terrain,n\x#,terheight,n\z#)
    PositionEntity n\entity,n\x#,65,n\z#,True
    n\SIDE = ReadLine(npcloadfile)
    n\speed = ReadLine(npcloadfile)
Wend
CloseFile(npcloadfile)
End Function

;---------------------lookcam Function-------------------------
Function CurveValue#(current#,destination#,curve)
	current#=current#+((destination#-current#)/curve)
	Return current#
End Function

Function MouseArea(x, y, width, height)
	If MouseX() >= x And MouseX() <= x + width
		If MouseY() >= y And MouseY() <= y + height
			Return True
		Else
			Return False
		End If
	Else
		Return False
	End If

End Function
;---------------------------------------------------------------

Function mainsplash()
	splash1 = LoadImage ("media\gfx\splash\bpsplash.jpg")
	GammaFade -5
	DrawImage splash1,GraphicsWidth()/2 - (ImageWidth(splash1)/2),GraphicsHeight()/2 - ImageHeight(splash1)/2
	GammaFade 5
	Delay 2000
	GammaFade -3
	Cls
	GammaFade 3
	FreeImage splash1
End Function

Function MakeSkyBox(file$)
	m=CreateMesh()
	;front face
	b=LoadBrush( file$+"_FR.bmp",49 )
	ss=CreateSurface( m,b )
	AddVertex ss,-1,+1,-1,0,0:AddVertex ss,+1,+1,-1,1,0
	AddVertex ss,+1,-1,-1,1,1:AddVertex ss,-1,-1,-1,0,1
	AddTriangle ss,0,1,2:AddTriangle ss,0,2,3
	FreeBrush b
	;right face
	b=LoadBrush( file$+"_LF.bmp",49 )
	ss=CreateSurface( m,b )
	AddVertex ss,+1,+1,-1,0,0:AddVertex ss,+1,+1,+1,1,0
	AddVertex ss,+1,-1,+1,1,1:AddVertex ss,+1,-1,-1,0,1
	AddTriangle ss,0,1,2:AddTriangle ss,0,2,3
	FreeBrush b
	;back face
	b=LoadBrush( file$+"_BK.bmp",49 )
	ss=CreateSurface( m,b )
	AddVertex ss,+1,+1,+1,0,0:AddVertex ss,-1,+1,+1,1,0
	AddVertex ss,-1,-1,+1,1,1:AddVertex ss,+1,-1,+1,0,1
	AddTriangle ss,0,1,2:AddTriangle ss,0,2,3
	FreeBrush b
	;left face
	b=LoadBrush( file$+"_RT.bmp",49 )
	ss=CreateSurface( m,b )
	AddVertex ss,-1,+1,+1,0,0:AddVertex ss,-1,+1,-1,1,0
	AddVertex ss,-1,-1,-1,1,1:AddVertex ss,-1,-1,+1,0,1
	AddTriangle ss,0,1,2:AddTriangle ss,0,2,3
	FreeBrush b
	;top face
	b=LoadBrush( file$+"_UP.bmp",49 )
	ss=CreateSurface( m,b )
	AddVertex ss,-1,+1,+1,0,1:AddVertex ss,+1,+1,+1,0,0
	AddVertex ss,+1,+1,-1,1,0:AddVertex ss,-1,+1,-1,1,1
	AddTriangle ss,0,1,2:AddTriangle ss,0,2,3
	FreeBrush b

	ScaleMesh m,1700,1700,1700
	FlipMesh m
	EntityFX m,1
	Return m

End Function

Function moveanimals()
	playx#=EntityX(player_pivot) 
	playz#=EntityZ(player_pivot)
	For ani.animal=Each animal
		anix#=EntityX(ani\entity)
		aniz#=EntityZ(ani\entity)
		
		anitime#=(MilliSecs()-ani\timestamp)/(ani\lasttime*1.0)
		
;		If ani\id=1 Then DebugLog anitime

		If ani\distancetoplayer<3000 ;400
			
			
			;If anitimet>1 Then anitime=1.0
			;terhieght= TerrainHeight(terrain,anix,aniz) 
			;spoty#=TerrainY(terrain,anix,terhieght,aniz)
			
			;PositionEntity ani\entity,BP_GetSplineX# (ani\SplineID, anitime),spoty,BP_GetSpliney# (ani\SplineID, anitime)
			;thisyaw#=ATan2(EntityX(ani\entity)-anix,EntityZ(ani\entity)-aniz)
			;RotateEntity ani\entity,0,360-thisyaw,0;360-ani\yaw,0,True	
		;Else
			;If EntityY(ani\entity)<meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5
		     ;  PositionEntity ani\entity,EntityX(ani\entity),meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5,EntityZ(ani\entity)
	        ;EndIf
			
			
			PositionEntity temppivot,ani\packetx,ani\packety,ani\packetz

						
			distAni# = EntityDistance (ani\entity, temppivot)
			
			If distAni# > 0.5
			
			PointEntity ani\entity, temppivot
			
			MoveEntity ani\entity, 0,0,0.5
			
			
			EndIf
			
			
			
			
			;PositionEntity ani\entity,ani\packetx,spoty#,ani\packetz
		
		
		
		
		
		
		
		;EndIf
	EndIf
	
	Next
End Function

Function moveplayers()
	For p.pdata=Each pdata
	;	If p\nomovement=True Then
	;		;player hasn't moved, don't use spline
	;		terhieght= TerrainHeight(terrain,EntityX(p\entity),EntityZ(p\entity)) 
	;		spoty#=TerrainY(terrain,EntityX(p\entity),terhieght,EntityZ(p\entity))
	;		PositionEntity p\entity,p\x,spoty,p\z
	;		If p\name="Miles" Then DebugLog "no movement"
	;	Else
			;movement, use spline
			
			;anitime#=(MilliSecs()-p\packettime)/(p\lasttime*1.0)
			;If anitimet>1 Then 
			;	anitime=1.0
				;PositionEntity p\entity,p\packetx,p\packety,p\packetz
				
			;camm change
			
			PositionEntity temppivot,p\packetx,p\packety,p\packetz

			distPL# = EntityDistance (p\entity, temppivot)
			
			If distPL > 0.5
			
			PointEntity p\entity, temppivot
			
			
			
			MoveEntity p\entity, 0,0,0.5
			
						
			EndIf
			
				
					
			;Else
				
			;	newx#=BP_GetSplineX# (p\SplineID, anitime)
			;	newz#=BP_GetSpliney# (p\SplineID, anitime)
			
			;	terheight= TerrainHeight(terrain,newx,newz) 
			;	spoty#=TerrainY(terrain,newx,terheight,newz)
			;	PositionEntity p\entity,newx,p\packety-2,newz
			;EndIf
			;DebugLog "SPLINES CLC:" + p\net_id +" - " + p\x + "," + p\z + " - " + newx + "," + newz
		;rotate player to current facing
		RotateEntity p\entity,0,p\yaw,0	
		EntityAutoFade p\entity,300,1000
	Next
End Function

Function ParseAction$(msg$)
	If Upper(Left(msg,4))="/ME "
		action$=Mid(msg,4)
		If Len(action)>1
			Return Chr(1)+"ACTION"+action+Chr(1)
		Else
			Return msg
		EndIf
	Else
		Return msg
	EndIf
End Function

Function control_playerMove()




	If initilizedplayerposition=False Then Return ;dont move until player has been positioned
			;***forward And backward ***
	
	CP_Z= 0
	CP_X= 0
	CP_Y=0
	If autowalk = 1 Then
	CP_Z = WalkSpeed#
	moved=15
    EndIf
   
	If KeyDown(200) Or (KeyDown(17) And chatenabled = False) Then 
		wanttoleave=False
	    moved=15
		CP_Z = WalkSpeed#
	ElseIf KeyDown(208) Or (KeyDown(31) And chatenabled = False) Then
		wanttoleave=False
		moved=15
	  	CP_Z = -WalkSpeed#
	EndIf
	
	If KeyHit(207) Then
	autowalk = Not autowalk
	EndIf
	
	
	If KeyDown(54) Then							;Walk key (Right Shift)
		WalkSpeed# = .2
	Else
		WalkSpeed# = .4
	EndIf

	;***  left and right ***
	If KeyDown(203) Or (KeyDown(30) And chatenabled = False) Then 
		wanttoleave=False
		
		
		dest_yang# = dest_yang + 1.5
		
		yang# = CurveValue (yang, dest_yang, 3)
		
		RotateEntity player_pivot, 0, yang, 0
		
	;Strafe	
	;	CP_X = -WalkSpeed#
		
	ElseIf KeyDown(205) Or (KeyDown(32) And chatenabled = False) Then 
		wanttoleave=False
		
		
		dest_yang# = dest_yang - 1.5
		
		yang# = CurveValue (yang, dest_yang, 3)
		
		RotateEntity player_pivot, 0, yang, 0
		
	;Strafe	
	;	CP_X = WalkSpeed#
		
	EndIf
	
	If MouseHit(2) Then 
	 CP_Y = 1
	EndIf
	
	If KeyDown(157) =1 And Jumped =0				;Jump (Right Ctrl)
		PlayerGravity# = 2
		Jumped =1
	EndIf

	;first/third person views
	If KeyHit(61) Then 
		ShowEntity player
		PositionEntity camera,0,5,-10
	EndIf
	
	If KeyHit(62) Then 
		PositionEntity camera,0,2.5,-3
		HideEntity player
	EndIf
	
	MoveEntity player_pivot,CP_X,CP_Y,CP_Z
	
	 playerx#=EntityX(player_pivot,True)
	 playerz#=EntityZ(player_pivot,True)
	
	terheight= TerrainHeight(Terrain, playerx#, playerz#) 
	spoty#=TerrainY(Terrain, playerx#,terheight, playerz#)
  If EntityY(player_pivot) < -100 Then 
	PositionEntity player_pivot,playerx#,spoty#+80, playerz#
  EndIf	
	;make sure player model sits on ground properly
	
	If EntityCollided( player_pivot, 1)
			;do nothing if player is in contact with terrain
			PlayerGravity# = 0.0
			Jumped =0
		Else
			PlayerGravity# = PlayerGravity# - Gravity#
		EndIf
;PositionEntity player,EntityX(player_pivot),EntityY(player_pivot),EntityZ(player_pivot)
TranslateEntity player_pivot,0,PlayerGravity#,0
End Function

Function PointDistance#(x1#, y1#, z1#, x2#, y2#, z2#)
	width# = x1# - x2#
	height# = y1# - y2#
	depth# = z1# - z2#
	Return Sqr#(witdh * width + depth * depth + height * height)

End Function

Function positiongrass(parent)
	; MAKE GRASS AND PLACE IT-----------------------
	PositionEntity grassMesh,0,0,0
	For a=0 To 1000
		stalk.grassStalk = New grassStalk
		stalk\x=EntityX(player_pivot,True)+(Rnd(0,grassRange*2.0)-grassRange)
		stalk\z=EntityZ(player_pivot,True)+(Rnd(0,grassRange*2.0)-grassRange)

		stalk\y=TerrainHeight (parent,stalk\x,stalk\z)
		stalk\y=TerrainY(parent,stalk\x,stalk\y,stalk\z)
			
		stalk\ang=Rnd(0,90)
		stalk\lowx#=Rnd(0.5,2)
		stalk\v1=AddVertex(grassSurface,stalk\x+(Sin(stalk\ang)*stalk\lowx),stalk\y,stalk\z+(Cos(stalk\ang)*stalk\lowx))
		stalk\v2=AddVertex(grassSurface,stalk\x-(Sin(stalk\ang)*stalk\lowx) ,stalk\y,stalk\z-(Cos(stalk\ang)*stalk\lowx))
		stalk\v3=AddVertex(grassSurface,stalk\x+(Sin(stalk\ang)*stalk\lowx),stalk\y+Rnd(1.5,3),stalk\z+(Cos(stalk\ang)*stalk\lowx))
		stalk\v4=AddVertex(grassSurface,stalk\x-(Sin(stalk\ang)*stalk\lowx) ,stalk\y+Rnd(1.5,3),stalk\z-(Cos(stalk\ang)*stalk\lowx))
		VertexTexCoords grassSurface,stalk\v1,0.01,0.01
		VertexTexCoords grassSurface,stalk\v2,0.01,.99
		VertexTexCoords grassSurface,stalk\v3,.99,0.01
		VertexTexCoords grassSurface,stalk\v1,.99,.99
		
		stalk\t1=AddTriangle(grassSurface,stalk\v1,stalk\v2,stalk\v3)
		stalk\t2=AddTriangle(grassSurface,stalk\v3,stalk\v2,stalk\v4)
		stalk\t3=AddTriangle(grassSurface,stalk\v1,stalk\v3,stalk\v2)
		stalk\t4=AddTriangle(grassSurface,stalk\v3,stalk\v4,stalk\v2)
	Next
	UpdateNormals grassMesh

	GRASSINITIALIZED=True
End Function

Function PutInInventory(Entity,Name$,Class)

For w.weapons = Each Weapons
	I.Inventory = New inventory
	I\amount = 1
	I\typeobj =Class
	I\name$ = Name$
	I\Icon = Class
   ;AddIcon(TypeOf)
Next
End Function

Function renderMessages()
	;render the latest messages, renders in any order - just takes each message object and throws it to the screen
	SetBuffer ImageBuffer(gThisBox)
	ClsColor 0,0,0
	Cls
	DrawImage gTextBox,0,0
	 
	For tempmessage.message = Each Message
		;render to correct position
		If tempmessage\From=""
			Color 0,0,tempmessage\iColor
			Text 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage\id )*15),tempmessage\itext$
		Else
			If tempmessage\action
				Color 0,0,$F800F8
				Text 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage\id )*15),"* "+tempmessage\from+" "
		    
				Color 0,0,$F800F8
				Text 15+StringWidth("* "+tempmessage\from+": "),LOWESTMESSAGERENDER-((gLastMessageID-tempmessage\id )*15),tempmessage\itext$
			Else
				Color 255,0,0
				Text 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage\id )*15),"<"+tempmessage\from+"> "
		    
				Color 2,255,34
				Text 15+StringWidth("<"+tempmessage\from+"> "),LOWESTMESSAGERENDER-((gLastMessageID-tempmessage\id )*15),tempmessage\itext$
			EndIf
		EndIf
		  
		;Text 30,430-((gLastMessageID-tempmessage\id )*20),tempmessage\itext$
		If gLastMessageID>(tempmessage\id+30) Then
			Delete tempmessage
		EndIf
	Next
	 
	Color 255,255,255
	 
	thismessage$=""
	 
	If Len(cText+"_")>maxcharlength
		;scroll user message
		startchar=Len(cText+"_")-maxcharlength
		thismessage$=Mid$(cText+"_",startchar)	  
	Else
		thismessage$=cText+"_"
	EndIf
	 
	Text 15,ImageHeight(gTextBox)-20,thismessage$
	 
	SetBuffer BackBuffer()
	 
	DrawImage gThisBox,0,GraphicsHeight()-ImageHeight(gThisBox)
End Function

Function servantsplash()
	splash1 = LoadImage("media\gfx\splash\logo2.jpg")
	GammaFade -5
	DrawImage splash1,GraphicsWidth()/2 - (ImageWidth(splash1)/2),GraphicsHeight()/2 - ImageHeight(splash1)/2
	GammaFade 3
	Delay 2000
	GammaFade -3
	Cls
	GammaFade 5
	FreeImage splash1
End Function

Function SaveScreenshot() 
	iFileNumber% = 0 
	Repeat 
		iFileNumber = iFileNumber + 1 
		sFileName$ = "Screenshot" + String$("0", 3 - Len(Str$(iFileNumber))) + iFileNumber + ".bmp" 
	Until Not(FileType(sFileName)) 
	SaveBuffer FrontBuffer(), sFileName 	
End Function

Function updateAnimalPosition(tid,tix#,tiz#,tiy#)
	For ani.animal=Each animal
		If ani\id=tid Then
			ani\x=EntityX(ani\entity)
			ani\z=EntityZ(ani\entity)
			ani\distancetoplayer=EntityDistance(camera,ani\entity)
			
				
			ani\packetx=tix
			ani\packetz=tiz
			ani\yaw=ani\packetyaw		;turn to face last heading
			ani\packetyaw=tiy
    		;drop animal To the terrain height
			terhieght= TerrainHeight(Terrain,EntityX(ani\entity),EntityZ(ani\entity)) 
			
			
			spoty#=TerrainY(Terrain,EntityX(ani\entity),terhieght,EntityZ(ani\entity))
			
			ani\packety = spoty
			
			trex#=TerrainX(Terrain,ani\x,EntityY(ani\entity),ani\z)
			trez#=TerrainZ(Terrain,ani\x,EntityY(ani\entity),ani\z)
			;If EntityY(ani\entity)<meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5
		    ;   PositionEntity ani\entity,EntityX(ani\entity),meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5,EntityZ(ani\entity)
	        ;EndIf

			;calc spline coords
			;get the packet info and the current position and calc the middle spline points
			PositionEntity temppivot,ani\packetx,spoty,ani\packetz
			RotateEntity temppivot,0,ani\packetyaw,0
			;spd#=EntityDistance (ani\entity,temppivot)
			;MoveEntity temppivot,0,-spd,0
					
			x2# =EntityX(temppivot)
			z2# =EntityZ(temppivot)

			;PositionEntity temppivot,ani\x,EntityY(ani\entity),ani\z
			;RotateEntity temppivot,0,EntityYaw(ani\entity),0
			;MoveEntity temppivot,0,spd,0
			;x1# =EntityX(temppivot);p\x + Sin(p\yaw)
			;z1# =EntityZ(temppivot);p\z + Cos(p\yaw)
								
;			x1#=ani\x + (Sin(ani\yaw)*2)
;			z1#=ani\z + (Cos(ani\yaw)*2)
;			x2#=ani\packetx - (Sin(ani\packetyaw)*2)
;			z2#=ani\packetz - (Cos(ani\packetyaw)*2)

			;BP_Initspline (ani\splineid,ani\x,ani\z,x1,z1,x2,z2,ani\packetx,ani\packetz)
	
			ani\lasttime=MilliSecs()-ani\timestamp
			;If ani\id=1 Then DebugLog ani\lasttime
			ani\timestamp=MilliSecs()
			Return
		EndIf
	Next
	
	;animal with this ID is new, create it with no spline info this time round
	ani.animal=New animal
	ani\entity = CopyEntity(player);LoadAnimMesh("media/models/player/knight.b3d")
	
	
	;EntityAutoFade ani\entity,200,350
	Animate ani\entity,1,0.8,knight_A_walk,1;run knight_A_walk
    ScaleEntity ani\entity,2.3,2.3,2.3
	ani\id=tid
	ani\x=tix
	ani\packetx=tix
	ani\z=tiz
	ani\packetz=tiz
	ani\yaw=tiy
	ani\packetyaw=tiy
	;ani\splineid=BP_CreateSpline()
	;get the packet info and the current position and calc the middle spline points
	x1#=ani\x; + (Sin(ani\yaw))
	z1#=ani\z; + (Cos(ani\yaw))
	x2#=ani\packetx ;- (Sin(ani\packetyaw))
	z2#=ani\packetz ;- (Cos(ani\packetyaw))

	;BP_Initspline (ani\splineid,ani\x,ani\z,x1,z1,x2,z2,ani\packetx,ani\packetz)
	
	ani\timestamp=MilliSecs()
	ani\lasttime=4000
End Function

Function UpdateCubemap(tex,camera,entity)

	tex_sz=TextureWidth(tex)

	; Show the camera we have specifically created for updating the cubemap
	ShowEntity camera
	
	; Hide entity that will have cubemap applied to it. This is so we can get cubemap from its position, without it blocking the view
	HideEntity entity

	; Position camera where the entity is - this is where we will be rendering views from for cubemap
	PositionEntity camera,EntityX#(entity),EntityY#(entity),EntityZ#(entity)

	CameraClsMode camera,False,True
	
	; Set the camera's viewport so it is the same size as our texture - so we can fit entire screen contents into texture
	CameraViewport camera,0,0,tex_sz,tex_sz

	; Update cubemap

	; do left view	
	SetCubeFace tex,0
	RotateEntity camera,0,90,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; do forward view
	SetCubeFace tex,1
	RotateEntity camera,0,0,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; do right view	
	SetCubeFace tex,2
	RotateEntity camera,0,-90,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; do backward view
	SetCubeFace tex,3
	RotateEntity camera,0,180,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; do up view
	SetCubeFace tex,4
	RotateEntity camera,-90,0,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; do down view
	SetCubeFace tex,5
	RotateEntity camera,90,0,0
	RenderWorld
	CopyRect 0,0,tex_sz,tex_sz,0,0,BackBuffer(),TextureBuffer(tex)
	
	; Show entity again
	ShowEntity entity
	
	; Hide the cubemap camera
	HideEntity camera
	
End Function

Function updateGrass(parent)
	Local update
	modx#=EntityX(player_pivot)
	modz#=EntityZ(player_pivot)
	For stalk.grassstalk=Each grassStalk
		update=False
		
		If stalk\x<modx-grassRange Then
			stalk\x=stalk\x+(grassRange*2)
			update=True
		EndIf
		
		If stalk\x>modx+grassRange Then
			stalk\x=stalk\x-(grassRange*2)
			update=True
		EndIf

		If stalk\z<modz-grassRange Then
			stalk\z=stalk\z+(grassRange*2)
			update=True
		EndIf
		
		If stalk\z>modz+grassRange Then
			stalk\z=stalk\z-(grassRange*2)
			update=True
		EndIf

		;update this stalk
		If update=True Then
			;check foliage map
;				tempgrassx# = tcx/grassmapscale;ngx/grassmapscale
;				tempgrassy# = 256-(tcz/grassmapscale);ngz/grassmapscale
;				col=(ReadPixelFast(ngx/grassmapscale,256-(ngz/grassmapscale),ImageBuffer(grassmap)) Shr 16) And $ff
;
;				If col>0 Then
;					PositionEntity foliage\entity,ngx,ngy+0.4,ngz
;					RotateEntity foliage\entity,Sin((MilliSecs()/20.0)+ngx)*20,EntityYaw(foliage\entity),0

		
		
			;move this stalk
			stalk\y=TerrainHeight (parent,stalk\x,stalk\z)
			stalk\y=TerrainY(parent,stalk\x,stalk\y,stalk\z)
			VertexCoords grassSurface,stalk\v1,stalk\x+(Sin(stalk\ang)*stalk\lowx),stalk\y,stalk\z+(Cos(stalk\ang)*stalk\lowx)
			VertexCoords grassSurface,stalk\v2,stalk\x-(Sin(stalk\ang)*stalk\lowx) ,stalk\y,stalk\z-(Cos(stalk\ang)*stalk\lowx)
			VertexCoords grassSurface,stalk\v3,stalk\x+(Sin(stalk\ang)*stalk\lowx),stalk\y+Rnd(1.5,3),stalk\z+(Cos(stalk\ang)*stalk\lowx)
			VertexCoords grassSurface,stalk\v4,stalk\x-(Sin(stalk\ang)*stalk\lowx) ,stalk\y+Rnd(1.5,3),stalk\z-(Cos(stalk\ang)*stalk\lowx)
		EndIf
	Next
	
	;UpdateNormals grassMesh
End Function

Function Update_Lightning(camera)
	For a.lightning=Each lightning
		a\alpha=a\alpha-.1
		If a\alpha<1 Then 
			EntityAlpha a\ent,a\alpha
			EntityColor a\ent,255*a\alpha,255*a\alpha,255
		End If
		If a\alpha<0 Then FreeEntity a\ent:Delete a	
	Next
	If flash>0 Then flash=flash-20
	If flash<0 Then flash=0
End Function

Function updateRain(amountofRain)
	; // Create Rain
	If rain_delay<MilliSecs()-amountofRain
		For t=1 To (Int(weatherdensity)/8)
			r.rain=New rain
			r\x#=EntityX#(player_pivot)-(Sin(EntityYaw#(player_pivot))*Rnd(768))-(Sin(EntityYaw#(player_pivot)+90)*Rnd(-384,384))
			r\y#=384+Rnd(128)
			r\z#=EntityZ#(player_pivot)+(Cos(EntityYaw#(player_pivot))*Rnd(768))+(Cos(EntityYaw#(player_pivot)+90)*Rnd(-384,384))
			r\xv#=Rnd(-1,1)
			r\yv#=Rnd(0,-4)
			r\zv#=Rnd(-1,1)
			r\xvg#=0
			r\yvg#=-1
			r\xvg#=0
		Next
		rain_delay=MilliSecs()
	EndIf
;	rain_delay=rain_delay-1

	; // Update Rain
	If Not KeyDown(57)
		ClearSurface rain_surface
		For r.rain=Each rain
			r\lx#=r\x#
			r\ly#=r\y#
			r\lz#=r\z#
			r\x#=r\x#+r\xv#
			r\y#=r\y#+r\yv#
			r\z#=r\z#+r\zv#
			r\xv#=r\xv#+r\xvg#
			r\yv#=r\yv#+r\yvg#
			r\zv#=r\zv#+r\zvg#
			r\ang#=EntityYaw#(player_pivot)
			r\v1=AddVertex(rain_surface,r\lx#-(Sin(r\ang#+90)*-0.3),r\ly#,r\lz#+(Cos(r\ang#+90)*-0.3))
			r\v2=AddVertex(rain_surface,r\lx#-(Sin(r\ang#+90)*0.3),r\ly#,r\lz#+(Cos(r\ang#+90)*0.3))
			r\v3=AddVertex(rain_surface,r\x#-(Sin(r\ang#+90)*-0.3),r\y#,r\z#+(Cos(r\ang#+90)*-0.3))
			r\v4=AddVertex(rain_surface,r\x#-(Sin(r\ang#+90)*0.3),r\y#,r\z#+(Cos(r\ang#+90)*0.3))
			VertexColor rain_surface,r\v1,0,0,0,0
			VertexColor rain_surface,r\v2,0,0,0,0
			VertexColor rain_surface,r\v3,50,50,150,0.25
			VertexColor rain_surface,r\v4,50,50,150,0.25
			r\t1=AddTriangle(rain_surface,r\v1,r\v2,r\v3)
			r\t2=AddTriangle(rain_surface,r\v3,r\v2,r\v4)
			r\t3=AddTriangle(rain_surface,r\v1,r\v3,r\v2)
			r\t4=AddTriangle(rain_surface,r\v3,r\v4,r\v2)
			If r\y#<=TerrainY#(Terrain,r\x#,r\y#,r\z#)
;				If TerrainY#(terrain,r\x#,r\y#,r\z#)<96
;					rr.rain_ripple=New rain_ripple
;					rr\life#=10
;					rr\ent=CopyEntity(rain_ripple)
;					SpriteViewMode rr\ent,2
;					PositionEntity rr\ent,r\x#,96,r\z#
;					RotateEntity rr\ent,90,0,0
;					RotateSprite rr\ent,Rnd(360)
;					EntityBlend rr\ent,1
;					EntityAlpha rr\ent,0.75
;					EntityColor rr\ent,144,192,255
;					rs.rain_splash=New rain_splash
;					rs\life#=15
;					rs\ent=CopyEntity(rain_splash)
;					PositionEntity rs\ent,r\x#,96,r\z#
;					RotateSprite rs\ent,Rand(0,1)*180
;					EntityBlend rs\ent,1
;					EntityAlpha rs\ent,0.75
;					EntityColor rs\ent,144,192,255
;					rr.rain_ripple=New rain_ripple
;					rr\life#=10
;					rr\ent=CopyEntity(rain_ripple)
;					r\x#=r\x#+Rnd(-128,128)
;					r\z#=r\z#+Rnd(-128,128)
;					SpriteViewMode rr\ent,2
;					PositionEntity rr\ent,r\x#,96,r\z#
;					RotateEntity rr\ent,90,0,0
;					RotateSprite rr\ent,Rnd(360)
;					EntityBlend rr\ent,1
;					EntityAlpha rr\ent,0.75
;					EntityColor rr\ent,144,192,255
;					rs.rain_splash=New rain_splash
;					rs\life#=15
;					rs\ent=CopyEntity(rain_splash)
;					PositionEntity rs\ent,r\x#,TerrainY#(terrain,r\x#,r\y#,r\z#),r\z#
;					RotateSprite rs\ent,Rand(0,1)*180
;					EntityBlend rs\ent,1
;					EntityAlpha rs\ent,0.75
;					EntityColor rs\ent,144,192,255
;					Else
					rs.rain_splash=New rain_splash
					rs\life#=15
					rs\ent=CopyEntity(rain_splash)
					PositionEntity rs\ent,r\x#,TerrainY#(Terrain,r\x#,r\y#,r\z#),r\z#
					RotateSprite rs\ent,Rand(0,1)*180
					EntityBlend rs\ent,1
					EntityAlpha rs\ent,0.75
					EntityColor rs\ent,144,192,255
					rs.rain_splash=New rain_splash
					rs\life#=15
					rs\ent=CopyEntity(rain_splash)
					r\x#=r\x#+Rnd(-128,128)
					r\z#=r\z#+Rnd(-128,128)
					PositionEntity rs\ent,r\x#,TerrainY#(Terrain,r\x#,r\y#,r\z#),r\z#
					RotateSprite rs\ent,Rand(0,1)*180
					EntityBlend rs\ent,1
					EntityAlpha rs\ent,0.75
					EntityColor rs\ent,144,192,255
;				EndIf
				Delete r.rain
			EndIf
		Next
		UpdateNormals rain_mesh
		For rs.rain_splash=Each rain_splash
			rs\life#=rs\life#-1
			ScaleSprite rs\ent,2*(1-rs\life#/15)+1,1*Cos(rs\life#*12-90)+1
			EntityAlpha rs\ent,rs\life#/15*0.5
			If rs\life#=<0
				FreeEntity rs\ent
				Delete rs.rain_splash
			EndIf
		Next
		For rr.rain_ripple=Each rain_ripple
			rr\life#=rr\life#-1
			ScaleSprite rr\ent,4*(1-rr\life#/10),4*(1-rr\life#/10)
			EntityAlpha rr\ent,rr\life#/10*0.5
			If rr\life#=<0
				FreeEntity rr\ent
				Delete rr.rain_ripple
			EndIf
		Next
	EndIf
		;rain noise
	ChannelVolume chlrainl,currentcloudalpha
	ChannelVolume chlrainh,currentcloudalpha/2.0

End Function

Function UpdateWater(surface,mesh)
; Create a wave effect by moving all the vertices in the mesh up and down using Sin
; Try editing:
; Freq#=MilliSecs()/10 
;                   ^ The Bigger the divide, the slower the water moves
; Vertex(a)\z#=Sin(freq+Vertex(a)\x#*300+Vertex(a)\y#*400)*1.125
;                                                         ^ The Bigger the Multiply The Higher 
;                                                           the waves will be, lower = smaller

For a=0 To VertexCount-1 
Freq#=MilliSecs()/10
Vertex(a)\z#=Sin(freq+Vertex(a)\x#*300+Vertex(a)\y#*400)*1.125
VertexCoords surface,a,Vertex(a)\x#,Vertex(a)\y#,Vertex(a)\z#
Next

UpdateNormals mesh

End Function

Function visibleMessageAdd(message$,from$,action,iColor,iFromColor)
	;add a visible message to the list
	 
	While Len(message$)>maxcharlength
		gLastMessageID=gLastMessageID+1
		tempMessage.Message = New Message
		tempmessage\id=gLastMessageID
		tempmessage\from=from
		tempmessage\action=action
		tempmessage\icolor=iColor
		tempmessage\fcolor=iFromColor
		  
		;find the last space on that line
		For icount = maxcharlength To 1 Step-1
			If Mid$(message$,icount,1)=" " Then
				lastspace=icount
				icount = -1   ;to break the loop
			EndIf
		Next
		 
		If lastspace<2 Then 
			lastspace = maxcharlength
		EndIf
		tempmessage\itext$=Left(message$,lastspace)
		message$=Mid$(message$,lastspace)
	Wend
	 
	gLastMessageID=gLastMessageID+1
	tempMessage.Message = New Message
	tempmessage\from=from
	tempmessage\action=action
	tempmessage\icolor=iColor
	tempmessage\fcolor=iFromColor
	tempmessage\id=gLastMessageID
	tempmessage\itext$=Left(message$,maxcharlength)
End Function



;~IDEal Editor Parameters:
;~F#0#3F#E0#18F#197#1A0#1A6#1AE#22D#23B#242#24D#252#259#25D#264#350#38E#3DA#414
;~F#447#4C1#536#593#69B
;~C#Blitz3D