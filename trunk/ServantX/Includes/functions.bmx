Function Collide_with_Zone_warps()

If myzone = 1 Then
If xEntityX(player_pivot) > 2540 Then 'Left zone
CreateZone(2)
EndIf

If xEntityZ(player_pivot) < 1 Then 'north zone
CreateZone(3)
EndIf


If xEntityX(player_pivot) < 1 Then 'Left zone
CreateZone(4)
EndIf

If xEntityZ(player_pivot) > 2540 Then 'north zone
CreateZone(3)
EndIf
EndIf

If myzone = 2 Then

If xEntityX(player_pivot) > 2540 Then 'Left zone
CreateZone(3)
EndIf

If xEntityZ(player_pivot) < 1 Then 'north zone
CreateZone(4)
EndIf


If xEntityX(player_pivot) < 1 Then 'Left zone
CreateZone(2)
EndIf

If xEntityZ(player_pivot) > 2540 Then 'north zone
CreateZone(1)
EndIf
EndIf

If myzone = 3 Then

If xEntityX(player_pivot) > 2540 Then 'Left zone
CreateZone(4)
EndIf

If xEntityZ(player_pivot) < 1 Then 'north zone
CreateZone(2)
EndIf


If xEntityX(player_pivot) < 1 Then 'Left zone
CreateZone(1)
EndIf

If xEntityZ(player_pivot) > 2540 Then 'north zone
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
	'Create a lightning bolt sequence with sprites And position ready For use, also set the various alpha levels
	l:lightningbolt = New lightningbolt
	l.x=gx
	l.z=gz
	terheight#= xTerrainHeight(Terrain,l.x,l.z) 
	spoty#=xTerrainY(Terrain,l.x,terheight,l.z)
	ly#=spoty+1000
	l.entity1 = xLoadSprite ("sprites\lightning1frame1.png",2)
	l.entity2 = xLoadSprite ("sprites\lightning1frame2.png",2)
	l.entity3 = xLoadSprite ("sprites\lightning1frame2.png",2)
	xEntityFX l.entity1,25
	xEntityFX l.entity2,25
	xEntityFX l.entity3,25
	xScaleSprite l.entity1,50,1250
	xScaleSprite l.entity2,50,1250
	xScaleSprite l.entity3,50,1250
	xSpriteViewMode l.entity1,2
	xSpriteViewMode l.entity2,2
	xSpriteViewMode l.entity3,2
	xPositionEntity l.entity1,gx,gy,gz
	xPositionEntity l.entity2,gx,gy,gz
	xPositionEntity l.entity3,gx,gy,gz
	ly#=Rnd(0,360)
	xRotateEntity l.entity1,0,ly,0
	xRotateEntity l.entity2,0,ly,0
	xRotateEntity l.entity3,0,ly,0
	
	xEmitSound thunder,l.entity1
	l.start=MilliSecs()
	flash=255
End Function

Function CreatePlayer:pdata(name$, id)
	Local p:pdata = New pdata
		
'For mssg.MsgInfo = Each MsgInfo
	p.initialized=False						'haven't got enough position data for spline
	'p\name = Mid$(msg\msgData,1,4) 
	p.name = Left(name$,Len(name$)-2)
	'p\model = Mid$(msg\msgData,5,4)
	p.model = Int(Mid(name$,Len(name$)-1,1))
	'p\sex = Mid$(msg\msgData,9,4)
	p.sex = Int(Mid(name$,Len(name$),1))
	p.net_id = id
	
	'p\x = 0
	'p\y = -200
	'p\z = 0

	
	
	temp=p.model
	
	'p\splineID = BP_CreateSpline()
	
	Select p.model 
       	Case 2              'amazon 
			p.entity = xCopyEntity(Amazon) 
			
		Case 3
		    p.entity = xCopyEntity(Spectra) 
	
		Default               'knight 
        	p.entity = xCopyEntity(player) 
			'p\entity = LoadAnimMesh("media/models/player/knight.b3d")
    End Select 
	p.lasttime=250
	p.packettime=MilliSecs()
	
    xRotateEntity p.entity,0,90,0
    xScaleEntity p.entity,2.3,2.3,2.3
    createtext(p.name,p.entity)
    p.namesprite = 1

   'gE_IdEmitter = EPS_Init_Emitter(109.0,5.0,2.02,2.0,180.0, p\entity,1.7,1.6,1.6,camera,3,1,1,1,0.0)
    'EPS_Init_Particule(gE_IdEmitter ,1.34,1.17,5.03,0.0,handle_texture,1,1.0,3,1,1.0,0.0,0.0,1.0,0.0,0.0,0,0)
    'EPS_Init_ParticuleColor( gE_IdEmitter,95.0,118.0,137.0,48.0,101.0,57.0,0.0,58.0,17.0)
'Next
	Return p
End Function

Function createtext(ctname$,ctent)
		
	tagWidth = Len(ctname$)*(xFontWidth()/4)
	tagheight = xFontHeight()+1
	
	nametex = xCreateTexture(tagWidth,tagheight, 1+4+8)
	nameimg = xCreateImage(tagWidth,tagheight)
	xSetBuffer xImageBuffer(nameimg)
	xColor 254,149,0
	xText 0,0,ctname$
	'Text 2,0,ctname$
	'Text 0,2,ctname$
	'Text 2,2,ctname$
	'Color 255,0,0
	'Text 1,1,ctname$


	xMaskImage nameimg, 0, 0, 0
	
	xCopyRect 0,0, tagWidth, tagheight, 0, 0, xImageBuffer(nameimg), xTextureBuffer(nametex)
			
		
	xSetBuffer xBackBuffer()
	
	TEXTUREmask(nametex)
	
		
	spr = xCreateSprite(ctent)
	xSpriteViewMode spr,1
	
	
	xEntityTexture spr,nametex

	xScaleSprite spr,1.5,.5
	xPositionEntity spr,0,2.5,0
	'FreeTexture nametex
	Return spr
End Function

Function TEXTUREmask( texture , sr=0 , sg=0 , sb=0, st = 1 )

	TW = xTextureWidth( texture )
	TH = xTextureHeight( texture )
	xSetBuffer xTextureBuffer( texture )
	xLockBuffer 
	For j = 0 To TH- 1
		For i = 0 To TW - 1
			argb = xReadPixelFast( i,j, xTextureBuffer( texture ) )
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
			xWritePixelFast i , j , argb, xTextureBuffer( texture )
		Next
	Next			
	xUnlockBuffer
	xSetBuffer xBackBuffer()
		
End Function

Function create_water_ripple(entity,surface,colindex)
If xEntityCollided(entity,colindex) Then
For rr:rain_ripple=EachIn rain_ripples
            rr.ent = xCopyEntity(ripple)
			rr.life#=rr.life#-1
			xScaleSprite rr.ent,4*(1-rr.life#/10),4*(1-rr.life#/10)
			xEntityAlpha rr.ent,rr.life#/10*0.5
rx=xEntityX(rr.ent)
rz=xEntityZ(rr.ent)
waterheight= xTerrainHeight(surface,rx,rz) 
waterspoty#=xTerrainY(surface,rx,waterheight,rz)
xPositionEntity rr.ent,xEntityX(entity,True),waterspoty#,xEntityZ(entity,True)
			If rr.life#=<0
				xFreeEntity rr.ent
				ListRemove(rain_ripples,rr)
			EndIf
		Next

End If
End Function

Function CreateZone(ZONEID$,tombs=False)

	Local Doc:xmlDocument = New xmlDocument
	Doc.Load("Media\Zone\"+zoneID+"\zone.t3x")
	Local DocRoot:xmlNode = Doc.Root:xmlNode()
	Terrain = xCreateTerrain(32)
	'xScaleEntity Terrain,0.01,0.01,0.01
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
									o:obj = New obj
									o.FileName=bnode.Attribute("filename").value
									If o.FileName <> 0 Then
										'TextureFilter "tree",4
										o.entity=xLoadMesh(o.FileName)
										o.x=Float(bnode.Attribute("xloc").value)
										o.y=Float(bnode.Attribute("yloc").value)
										o.z=Float(bnode.Attribute("zloc").value)
										
										o.pitch=Float(bnode.Attribute("pitch").value)
										o.yaw=Float(bnode.Attribute("yaw").value)
										o.roll=Float(bnode.Attribute("roll").value)
											
										o.scaleX# =Float(bnode.Attribute("xscale").value)
										o.scaleY# =Float(bnode.Attribute("yscale").value)
										o.scaleZ# =Float(bnode.Attribute("zscale").value)
									
										xPositionEntity o.entity,o.x,o.y,o.z
										xRotateEntity o.entity,o.pitch,o.yaw,o.roll
										xEntityType o.entity,1
										xScaleEntity o.entity,o.scaleX#,o.scaleY#,o.scaleZ#

										xEntityPickMode o.entity,2	
									EndIf						
							End Select
						
							bnode = bnode.NextSibling()
						Wend
					
					EndIf
					
				Case "NODES"
					If cnode.HasChildren()
					
						Local nnode:xmlNode = cnode.FirstChild()
						While nnode <> Null
						
							Select nnode.Name
							
								Case "ND"
									Local n:node = New node
									n.x# = Float(nnode.Attribute("xloc").value)
									n.y# = Float(nnode.Attribute("yloc").value)
									n.z# = Float(nnode.Attribute("zloc").value)
							End Select
						
							nnode = nnode.NextSibling()
						Wend
					
					EndIf	
				Rem
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
				End Rem
			End Select
		
			cnode = cnode.NextSibling()
		Wend
	Else
		Return
	EndIf

End Function


Function CreateZone_OLD(zoneID,tombs=False)
LeaveZone()
If tombs = False
DebugLog("Loading Zone: "+zoneID)
Terrain = xLoadTerrain("Media\Zone\"+zoneID+"\lvl_hmap"+zoneID+".bmp")
tex2 = xLoadTexture("Media\Zone\"+zoneID+"\lvl_detail"+zoneID+".bmp")
grasst = xLoadTexture("Media\Zone\"+zoneID+"\lvl_tmap"+zoneID+".jpg")
'ScaleTexture grasst,256,256
xScaleEntity Terrain,10,300,10
xPositionEntity Terrain,0,0,0,True
xScaleTexture tex2,0.01,0.01
xTerrainDetail Terrain,2000
xEntityTexture Terrain,grasst
xEntityTexture Terrain,tex2,0,1
xEntityType Terrain,1

grassMesh=xCreateMesh()
grassTexture=xLoadTexture("sprites\Zone\"+zoneID+"\grass.png",3)
'EntityFX grassMesh,1
'EntityAlpha grassmesh,0.5
grassSurface=xCreateSurface(grassMesh)
xEntityTexture grassMesh,grassTexture
grassRange#=100

positiongrass(Terrain)

'loadnpc(zoneID)

treefile:TStream = ReadFile("Media\Zone\"+zoneID+"\obj"+zoneID+".t3d")
While Not Eof(treefile)
	o:obj = New obj
	olen = ReadInt(treefile)
	o.FileName=ReadString(treefile,olen)
	'TextureFilter "tree",4
	o.entity=xLoadMesh(o.FileName)
	o.x=ReadFloat(treefile)
	o.y=ReadFloat(treefile)
	o.z=ReadFloat(treefile)
	'o\yaw=ReadFloat(treefile)
	xPositionEntity o.entity,o.x,o.y,o.z
	xRotateEntity o.entity,0,Rnd(0,360),0
	xEntityType o.entity,1
	xScaleEntity o.entity,.3,.3,.3
	'EntityTexture o\entity,tex1
	xEntityAutoFade o.entity,700,900	
Wend
CloseFile(treefile)

buildingsf:TStream = ReadFile("Media\Zone\"+zoneID+"\buildings"+zoneID+".t3d")
While Not Eof(buildingsf)
	o:obj = New obj
	olen = ReadInt(buildingsf)
	o.FileName=ReadString(buildingsf,olen)
	'TextureFilter "tree",4
	o.entity=xLoadMesh(o.FileName)
	o.x=ReadFloat(buildingsf)
	o.y=ReadFloat(buildingsf)
	o.z=ReadFloat(buildingsf)
	o.pitch=ReadFloat(buildingsf)
	o.yaw=ReadFloat(buildingsf)
	o.roll=ReadFloat(buildingsf)
	
	o.scaleX# =ReadFloat(buildingsf)
	o.scaleY# =ReadFloat(buildingsf)
	o.scaleZ# =ReadFloat(buildingsf)
	
	
	xPositionEntity o.entity,o.x,o.y,o.z
	xRotateEntity o.entity,o.pitch,o.yaw,o.roll
	xEntityType o.entity,1
	xScaleEntity o.entity,.3,.3,.3
	'EntityTexture o\entity,tex1
	xEntityAutoFade o.entity,700,900	
Wend
CloseFile(buildingsf)


wepsFile:TStream = ReadFile("Char\Data\"+zoneID+"\weps.dat")
While Not Eof(wepsFile)
	w:weapons = New Weapons
	w.file = ReadLine(wepsFile)
	w.name$ = ReadLine(wepsfile)
	w.ID = Int(ReadLine(wepsfile) )
	w.x=Int(ReadLine(wepsfile))
	w.y=Int(ReadLine(wepsfile))
	w.z=Int(ReadLine(wepsfile))
	w.weight=Int(ReadLine(wepsfile))
    w.Strength=Int(ReadLine(wepsfile))
    
	
	
	w.entity = xCopyEntity(Celticaxe)
	'w\entity = LoadMesh(w\file)
	xPositionEntity w.entity,w.x,w.y,w.z
	xEntityType w.entity,Wep_col
	xScaleEntity w.entity,.3,.3,.3
	xEntityAutoFade w.entity,700,900	
	xEntityPickMode w.entity,2
Wend
CloseFile(wepsFile)




Else

	tomb = xLoadMesh("Media\gfx\TOMB\"+zoneID+".b3d")

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


    playerx#=xEntityX(player_pivot,True)
	playerz#=xEntityZ(player_pivot,True)
	terheight= xTerrainHeight(Terrain, playerx#, playerz#) 
	spoty#=xTerrainY(Terrain,playerx#,terheight, playerz#)

End Function

Function debugtext()
	'Text 50,50,sound '"PING: " + BP_getmyping%()
	'Text 50,60,Entitycollide(camera,townborder)'EntityX(camera,True)
	'Text 50,70,EntityY(camera,True)
	'Text 50,80,EntityZ(camera,True)'"Server Time : " + gservertime
	'Text 50,90,grassmapscale + " : " + tempgrassx# + " : " + tempgrassy#
	'For p.pData = Each pdata
	'Text 50,100,"current cloud cover = " + weatherdensity$
	'Text 50,140,TrisRendered()
	If wanttoleave=True Then
		timetoquit=Int((quitdelay-leavingworld)/1000.0)
		xText 50,120,"REQUESTING EXIT WORLD (" + timetoquit + " secs) - MOVE TO CANCEL"
	EndIf
	xSetFont fntArial
	xColor 158,13,6
	xText 143,38,gDate
	
End Function

Function Distance#(x1#, y1#, x2#, y2#)
	width# = x1# - x2#
	height# = y1# - y2#
	ddist# = Sqr(width# * width# + height# * height#) 
	Return ddist#

End Function

Function FindBreak(msg$,cnt,bChr$=" ")
	Local break%=1
	For i=0 To cnt
		break=Instr(msg,bChr,break+1)
		If Not break Exit
	Next
	Return break
End Function

Function Find:User(nick$)
	For u:user=EachIn Users
		If u.nick=nick Return u:user
	Next
End Function

Function FindPdata:pdata(id:Int)
	'Hunt For the player information that matches id%
	For p:pdata = EachIn pdatas
		If p.net_id = id Then Return p
	Next
End Function

'------FPS CODE--------------
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
'---------------------------------

'----------------------------Main MENU-------------------------
Function mainmenu()
xCls
 menubackground = xLoadImage("misc\menu\menuback.bmp")
 startbutt = xLoadImage("misc\menu\startbutt.bmp")
 Optionsbutt = xLoadImage("misc\menu\optionsbutt.bmp")
 Creditsbutt = xLoadImage("misc\menu\Creditsbutt.bmp")
 Exitbutt = xLoadImage("misc\menu\Exitbutt.bmp")
 startbutt2 = xLoadImage("misc\menu\startbutt2.bmp")
 Optionsbutt2 = xLoadImage("misc\menu\optionsbutt2.bmp")
 Creditsbutt2 = xLoadImage("misc\menu\Creditsbutt2.bmp")
 Exitbutt2 = xLoadImage("misc\menu\Exitbutt2.bmp")
 pointer = xLoadImage("misc\pointer.png")
xSetBuffer xBackBuffer()
xHidePointer 
While Not KeyHit(1)
xCls
startimg = 1
optionimg = 1
Creditimg = 1
Exitimg = 1



If xImagesOverlap(startbutt,xvalue - (xImageWidth(startbutt)/2)-32,yvalue - (xImageHeight(startbutt)/2)-32 - 140,pointer,xMouseX()-88,xMouseY()-27) Then
startimg = 0
EndIf

If xImagesOverlap(Optionsbutt,xvalue - (xImageWidth(Optionsbutt)/2)-32,yvalue - (xImageHeight(Optionsbutt)/2)-32 - 80,pointer,xMouseX()-88,xMouseY()-27) Then
optionimg = 0
EndIf

If xImagesOverlap(Creditsbutt,xvalue - (xImageWidth(Creditsbutt)/2)-32,yvalue - (xImageHeight(Creditsbutt)/2)-32 - 20,pointer,xMouseX()-88,xMouseY()-27) Then
Creditimg = 0
EndIf

If xImagesOverlap(Exitbutt,xvalue - (xImageWidth(Exitbutt)/2)-32,yvalue - (xImageHeight(Exitbutt)/2)-32 + 40,pointer,xMouseX()-88,xMouseY()-27) Then
Exitimg = 0
EndIf

If xMouseDown(1) And xImageRectOverlap(Optionsbutt2,xvalue - (xImageWidth(Optionsbutt2)/2),yvalue - (xImageHeight(Optionsbutt2)/2) - 80,xMouseX(),xMouseY(),1,1) Then
'options()
EndIf

If xMouseDown(1) And xImageRectOverlap(Creditsbutt2,xvalue - (xImageWidth(Creditsbutt2)/2),yvalue - (xImageHeight(Creditsbutt2)/2) - 20,xMouseX(),xMouseY(),1,1) Then
'Credits()
EndIf


If xMouseDown(1) And xImageRectOverlap(Exitbutt2,xvalue - (xImageWidth(Exitbutt2)/2),yvalue - (xImageHeight(Exitbutt2)/2) + 40,xMouseX(),xMouseY(),1,1) Then
End
EndIf




xDrawImage menubackground,xvalue - (xImageWidth(menubackground)/2) - 1,yvalue - (xImageHeight(menubackground)/2) - 45

If startimg = 1 Then
	xDrawImage startbutt,xvalue - (xImageWidth(startbutt)/2),yvalue - (xImageHeight(startbutt)/2) - 140
Else
	xDrawImage startbutt2,xvalue - (xImageWidth(startbutt2)/2),yvalue - (xImageHeight(startbutt2)/2) - 140
EndIf

If optionimg = 1 Then
	xDrawImage Optionsbutt,xvalue - (xImageWidth(Optionsbutt)/2),yvalue - (xImageHeight(Optionsbutt)/2) - 80
Else
	xDrawImage Optionsbutt2,xvalue - (xImageWidth(Optionsbutt2)/2),yvalue - (xImageHeight(Optionsbutt2)/2) - 80
EndIf

If Creditimg = 1 Then
	xDrawImage Creditsbutt,xvalue - (xImageWidth(Creditsbutt)/2),yvalue - (xImageHeight(Creditsbutt)/2) - 20
Else
	xDrawImage Creditsbutt2,xvalue - (xImageWidth(Creditsbutt2)/2),yvalue - (xImageHeight(Creditsbutt2)/2) - 20
EndIf

If Exitimg = 1 Then
	xDrawImage Exitbutt,xvalue - (xImageWidth(Exitbutt)/2),yvalue - (xImageHeight(Exitbutt)/2) + 40
Else
	xDrawImage Exitbutt2,xvalue - (xImageWidth(Exitbutt2)/2),yvalue - (xImageHeight(Exitbutt2)/2) + 40
EndIf


xDrawImage pointer,xMouseX(),xMouseY()




xFlip
If xMouseDown(1) And xImageRectOverlap(startbutt2 ,xvalue - (xImageWidth(startbutt2)/2),yvalue - (xImageHeight(startbutt2)/2) - 140,xMouseX(),xMouseY(),1,1) Then
Return
EndIf
Wend

xFreeImage menubackground
xFreeImage startbutt
xFreeImage startbutt2
xFreeImage Optionsbutt
xFreeImage Optionsbutt2
xFreeImage Creditsbutt
xFreeImage Creditsbutt2
xFreeImage Exitbutt
xFreeImage Exitbutt2
xFreeImage pointer 

End Function
'-------------------------------------------End MENU------------------------------------------

Function GammaFade(speed)
	If speed=0 Return 0
	f=-255*(speed>0)
	Repeat
		f=f+speed
		For g=0 To 255
			'xSetGamma g,g,g, g+f,g+f,g+f
		Next
		'xUpdateGamma
		Delay 1
		If f<=-255 Or f>=0 Then Exit
	Forever	
End Function

Function GammaReset()
 For g=0 To 255
  'xSetGamma g,g,g, g,g,g
 Next
 'xUpdateGamma
End Function

Function GetAction:String(msg$)
	Local break=Instr(msg," ")
	If Not break Return ""
	
	If Upper(Left(msg,break))=(Chr(1)+"ACTION ") And Mid(msg,Len(msg),1)=Chr(1)
		Return Mid(msg,break+1,Len(msg)-break-1)
	Else
		Return ""
	EndIf
End Function

Function GetCommand$(msg$,bChr$=" ")
	Local break=Instr(msg,bChr)
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

Function GetFromTo$(msg$,sChr$,sCnt,eChr$,eCnt)
	Local cStart=FindBreak(msg,sCnt,sChr);If Not cStart Then cStart=1
	Local cEnd=FindBreak(msg,eCnt,eChr)
	
	Return Mid(msg,cStart,cEnd-cStart)
End Function

Function GetPar$(msg$,par=0,bChr$=" ")
	Local sbreak=1,ebreak
	
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

'-----------------NETFUNCTIONS
Function HandleMessages()	'Deal with all the messages that were received this frame.
	For mssg:MsgInfo = EachIn MsgInfo_list	'MsgInfo is the Type list BlitzPlay uses For received packets
		Select mssg.msgType			'Check against the msgType
			Case BP_PLAYERHASJOINED	
				'Someone joined!
				If mssg.msgfrom <> 1 Then
					p:pdata = CreatePlayer(mssg.msgData, mssg.msgFrom)
					visibleMessageAdd(" joined.",p.Name,1,$ffffff,$ffffff) 
					
					
	            EndIf                              
    	        'p\entity = LoadAnimMesh("models\run.b3d")

        	Case BP_PLAYERHASLEFT          'Someone Left! 
            	p:pdata = FindPdata(mssg.msgFrom) 
                If p<>Null Then  
					visibleMessageAdd(" left the world.",p.Name,1,$ffffff,$ffffff)
                	xFreeEntity (p.entity) 
					
'					DeleteFile p\name+".png"
                    ListRemove(pdatas,p)
                EndIf
        	Case BP_HOSTHASLEFT			'The host Left, lets close down the game.
				For p:pdata = EachIn pdatas
					ListRemove(pdatas,p)
					DeleteFile(p.name+".png")
				Next
				BP_EndSession ()
				End
			Case 1		'A positional update
				p:pdata = FindPdata(mssg.msgFrom)
				
				If p<>Null Then			'error check To make sure this person is in the game		
					'PositionEntity p\entity,p\packetx,p\packety,p\packetz
					p.x=xEntityX(p.entity)
					p.y=xEntityY(p.entity)
					p.z=xEntityZ(p.entity)
					
				    p.packetx# = BP_StrToFloat(Mid$(mssg.msgData,1,4))
					p.packety# = BP_StrToFloat(Mid$(mssg.msgData,5,4))
					p.packetz# = BP_StrToFloat(Mid$(mssg.msgData,9,4))
										
					newyaw#=BP_StrToFloat(Mid$(mssg.msgData,13,4))

					xPositionEntity temppivot,p.packetx,p.packety,p.packetz
					xRotateEntity temppivot,0,newyaw+180,0
					'spd#=EntityDistance (p\entity,temppivot)/2.0
					'MoveEntity temppivot,0,spd,0
					
								
					
					x2# =xEntityX(temppivot)
					z2# =xEntityZ(temppivot)

					'PositionEntity temppivot,p\x,p\y,p\z
					'RotateEntity temppivot,0,EntityYaw(p\entity),0
					'MoveEntity temppivot,0,spd,0
					'x1#=EntityX(temppivot)
					'z1#=EntityZ(temppivot)
					'
					p.yaw=newyaw

										
					p.lasttime=MilliSecs()-p.packettime
					'If ani\id=1 Then DebugLog ani\lasttime
					p.packettime=MilliSecs()
					
					If p.initialized=False Then
						p.x=p.packetx
						p.y=p.packety
						p.z=p.packetz
						x1=p.packetx
						x2=p.packetx
						z1=p.packetz
						z2=p.packetz
						p.packettime=MilliSecs()
						p.lasttime=250
						xPositionEntity p.entity,p.x,p.y,p.z
						p.initialized=True
					EndIf
					
					'BP_Initspline (p\splineid,p\x,p\z,x1,z1,x2,z2,p\packetx,p\packetz)
					
					
					xRotateEntity p.entity,0,p.yaw,0
					p.dataused=False
			
					DebugLog "PACKET IN:" + p.net_id +" - " + p.packetx + "," + p.packetz + " -- " + p.x + "," + p.z
					
				End If	
				
				
          	Case 4    
            	p:pdata=FindPdata(mssg.msgFrom)
            	p.model = Int(Mid$(mssg.msgData,1,4) )'Mid$(msg\msgData,Len(msg\msgData)-1,1)
                p.sex = Int(Mid$(mssg.msgData,5,4) )'Mid$(msg\msgData,Len(msg\msgData),1)

			Case 5
			
     	  		tUID$=Left(mssg.msgData,Instr(mssg.msgData,":")) 
      	  		tMsg$=Mid(mssg.msgData,Instr(mssg.msgData,":")+1) 
				
				If mssg.msgfrom = 1 Then
					
					If Left(mssg.msgdata,7)="SYSTEM:" And Instr(mssg.msgdata,"was kicked")>0 Then
						
						'a player was kicked, remove his model
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
						tempmsg$=mssg.msgdata
						tempmsg = Replace (tempmsg,"SYSTEM:","")
						tempmsg = Replace (tempmsg," was kicked.","")
					
						If myname=tempmsg Then End
						For kp:pdata = EachIn pdatas
							If kp.name = tempmsg Then
								xFreeEntity (kp.entity) 
	                        	DeleteFile kp.name+".png"
								ListRemove(pdatas,kp)
							EndIf
						Next
					EndIf
					'copied from below
					If Left(mssg.msgdata,7)="SYSTEM:" Or Left(mssg.msgdata,3)="|A:"
						'hmmm
						'server message don't display in chat
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
					EndIf	
				Else
					If Left(mssg.msgdata,7)="SYSTEM:" Or Left(mssg.msgdata,3)="|A:"
						'hmmm
						'server message don't display in chat
					visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff)

					Else
						visibleMessageAdd(tMsg$,tUID$,0,$ffffff,$ffffff) 
					EndIf
				EndIf	
					
					
					
					
					
					
					
					
					
					'COLLECT PLAYER POSITION FROM SERVER
' 
'					If Left(msg\msgdata,11)="SYSTEM:PLPS"
'						playerpos$=Replace(msg\msgdata,"SYSTEM:PLPS ","")
'						DebugLog "PLAYER WARPED TO " + playerpos
'						axis=0
'						For icount = 1 To Len(playerpos)
'							If Mid$(playerpos,icount,1)="-" Then 
'								Select axis
'									Case 0
'										'X axis
'										newposx#=Left(playerpos,icount-1)
'										nextstartpos=icount+1
'										axis=1
'									Case 1
'										'Y axis
'										newposy#=Mid(playerpos,nextstartpos,(icount-nextstartpos)-1)
'										newposz#=Mid(playerpos,icount+1)
'								End Select
'							EndIf
'						Next
'						PositionEntity player_pivot,newposx,newposy+5,newposz
'					EndIf
					
			Case 6
				'we just arrived on the zone, get initial position from server
				initx# = BP_StrToFloat(Mid$(mssg.msgData,1,4))
				inity# = BP_StrToFloat(Mid$(mssg.msgData,5,4))
				initz# = BP_StrToFloat(Mid$(mssg.msgData,9,4))
				inityaw#=BP_StrToFloat(Mid$(mssg.msgData,13,4))
				model =  BP_StrToFloat(Mid$(mssg.msgData,17,4))
				mysex =  BP_StrToFloat(Mid$(mssg.msgData,21,4))
				Health = BP_StrToFloat(Mid$(mssg.msgData,25,4))
				INITZone = BP_StrToFloat(Mid$(mssg.msgData,29,4))
				'Ignore this playerstart crap until we got some solid real place to put someone, going to use
				'My own playerstart node in the zone file to tell the game where to put the player.		
				
				'going to use a temporary function to get playerstart
				Local mpstart:Float[] = GetPlayerstart()
				If mpstart <> Null Then
					xPositionEntity player_pivot,mpstart[0],mpstart[1],mpstart[2]
				EndIf
				xRotateEntity player_pivot,0,inityaw,0
				DebugLog "Got start coords of " + initx + "," + inity + "," + initz + ",yaw=" + inityaw
				initilizedplayerposition=True
			Case 7
				'animals update
				tix#=BP_StrToFloat(Mid(mssg.msgdata,1,4))
				tiz#=BP_StrToFloat(Mid(mssg.msgdata,5,4))
				tiy#=BP_StrToFloat(Mid(mssg.msgdata,9,4))
				tid= BP_StrToInt  (Mid(mssg.msgdata,13))
				updateAnimalPosition(tid,tix,tiz,tiy)
			Case 8
				'lightning
				lx#=BP_StrToFloat(Mid(mssg.msgdata,1,4))
				lz#=BP_StrToFloat(Mid(mssg.msgdata,5,4))
				 Create_lightning(lx,lz,250,500,20) 
			Case 9
				'weather
				weatherdensity$= BP_StrToFloat(Mid(mssg.msgdata,1,4))
				'DebugLog "weather = " + weatherdensity$
			Case 10
				'time of day			
				If Left(mssg.msgdata,1)="T" Then
					gGameTime=Mid(mssg.msgdata,2)
					gservertime=Float(gGameTime)
					'DebugLog "TIME SET TO " + convertGameTime()
				Else
					gDate=Mid(mssg.msgdata,2)
					'DebugLog "CURRENT DATE SET TO " + gdate
				EndIf
		End Select
		ListRemove(MsgInfo_list,mssg)
	Next
End Function

Function GetPlayerstart:Float[]()

	Local myplayerstart:Float[3]
	
	For n:node = EachIn nodes
	
		myplayerstart[0] = n.x
		myplayerstart[1] = n.y
		myplayerstart[2] = n.z
		
		Return myplayerstart
	
	Next

End Function

Function InfoF(t$,set)
	i:Info = New Info
	i.txt$ = t$
	i.set = set
	ListRemove(Infos,i)
	ListAddFirst(Infos,i)
End Function

Function irc_log(iText$,iColor=$FFFFFF,from$="",fColor=$3399FF)
	Local i=0
	action$=GetAction(iText)

	If action<>""
		iText=action
		action=1
	EndIf

	visibleMessageAdd(iText,from,Int(action),iColor,fColor)
End Function

Function LeaveZone()
xFreeEntity Terrain

For o:obj = EachIn  objs
If o.entity > 0 Then
xFreeEntity o.entity
'o\entity = 0'added by me
EndIf

Next

'For p.pdata = Each pdata
'FreeEntity p\entity
'Next

xFreeTexture tex2
xFreeTexture grasst
End Function

Function loadnpc(ZoneID)

npcloadfile:TStream = ReadFile("Char\Data\"+ZoneID+"\npc.dat")
While Not Eof(npcloadfile) 
n:npcs = New NPCS
	n.name = ReadLine(npcloadfile)
	model$ = ReadLine(npcloadfile)
	'n\splineID = BP_CreateSpline()
	n.entity = xLoadMesh("Media\models\Player\Spectre\Spectre.3DS")
	xScaleEntity n.entity,2.3,2.3,2.3
	xEntityType n.entity,2
    createtext(n.name,n.entity)
    n.namesprite = 1
    n.x# = Float(ReadLine(npcloadfile))
    n.z# = Float(ReadLine(npcloadfile))
    terheight= xTerrainHeight(Terrain,n.x#,n.z#) 
	spoty#=xTerrainY(Terrain,n.x#,terheight,n.z#)
    xPositionEntity n.entity,n.x#,65,n.z#,True
    n.SIDE = Int(ReadLine(npcloadfile))
    n.speed = Int(ReadLine(npcloadfile))
Wend
CloseFile(npcloadfile)
End Function

'---------------------lookcam Function-------------------------
Function CurveValue#(Currentt#,destination#,curve)
	Currentt#=Currentt#+((destination#-Currentt#)/curve)
	Return Currentt#
End Function

Function MouseArea(x, y, width, height)
	If xMouseX() >= x And xMouseX() <= x + width
		If xMouseY() >= y And xMouseY() <= y + height
			Return True
		Else
			Return False
		End If
	Else
		Return False
	End If

End Function
'---------------------------------------------------------------

Function mainsplash()
	splash1 = xLoadImage ("media\gfx\splash\bpsplash.jpg")
	GammaFade -5
	xDrawImage splash1,xGraphicsWidth()/2 - (xImageWidth(splash1)/2),xGraphicsHeight()/2 - xImageHeight(splash1)/2
	GammaFade 5
	Delay 2000
	GammaFade -3
	xCls
	GammaFade 3
	xFreeImage splash1
End Function

Function MakeSkyBox(file$)
	m=xCreateMesh()
	'front face
	b=xLoadBrush( file$+"_FR.bmp",49 )
	ss=xCreateSurface( m,b )
	xAddVertex ss,-1,+1,-1,0,0;xAddVertex ss,+1,+1,-1,1,0
	xAddVertex ss,+1,-1,-1,1,1;xAddVertex ss,-1,-1,-1,0,1
	xAddTriangle ss,0,1,2;xAddTriangle ss,0,2,3
	xFreeBrush b
	'Right face
	b=xLoadBrush( file$+"_LF.bmp",49 )
	ss=xCreateSurface( m,b )
	xAddVertex ss,+1,+1,-1,0,0;xAddVertex ss,+1,+1,+1,1,0
	xAddVertex ss,+1,-1,+1,1,1;xAddVertex ss,+1,-1,-1,0,1
	xAddTriangle ss,0,1,2;xAddTriangle ss,0,2,3
	xFreeBrush b
	'back face
	b=xLoadBrush( file$+"_BK.bmp",49 )
	ss=xCreateSurface( m,b )
	xAddVertex ss,+1,+1,+1,0,0;xAddVertex ss,-1,+1,+1,1,0
	xAddVertex ss,-1,-1,+1,1,1;xAddVertex ss,+1,-1,+1,0,1
	xAddTriangle ss,0,1,2;xAddTriangle ss,0,2,3
	xFreeBrush b
	'Left face
	b=xLoadBrush( file$+"_RT.bmp",49 )
	ss=xCreateSurface( m,b )
	xAddVertex ss,-1,+1,+1,0,0;xAddVertex ss,-1,+1,-1,1,0
	xAddVertex ss,-1,-1,-1,1,1;xAddVertex ss,-1,-1,+1,0,1
	xAddTriangle ss,0,1,2;xAddTriangle ss,0,2,3
	xFreeBrush b
	'top face
	b=xLoadBrush( file$+"_UP.bmp",49 )
	ss=xCreateSurface( m,b )
	xAddVertex ss,-1,+1,+1,0,1;xAddVertex ss,+1,+1,+1,0,0
	xAddVertex ss,+1,+1,-1,1,0;xAddVertex ss,-1,+1,-1,1,1
	xAddTriangle ss,0,1,2;xAddTriangle ss,0,2,3
	xFreeBrush b

	xScaleMesh m,1700,1700,1700
	xFlipMesh m
	xEntityFX m,1
	Return m

End Function

Function moveanimals()
	playx#=xEntityX(player_pivot) 
	playz#=xEntityZ(player_pivot)
	For ani:animal=EachIn animals
		anix#=xEntityX(ani.entity)
		aniz#=xEntityZ(ani.entity)
		
		anitime#=(MilliSecs()-ani.timestamp)/(ani.lasttime*1.0)
		
'		If ani\id=1 Then DebugLog anitime

		If ani.distancetoplayer<3000 '400
			
			
			'If anitimet>1 Then anitime=1.0
			'terhieght= TerrainHeight(terrain,anix,aniz) 
			'spoty#=TerrainY(terrain,anix,terhieght,aniz)
			
			'PositionEntity ani\entity,BP_GetSplineX# (ani\SplineID, anitime),spoty,BP_GetSpliney# (ani\SplineID, anitime)
			'thisyaw#=ATan2(EntityX(ani\entity)-anix,EntityZ(ani\entity)-aniz)
			'RotateEntity ani\entity,0,360-thisyaw,0'360-ani\yaw,0,True	
		'Else
			'If EntityY(ani\entity)<meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5
		     '  PositionEntity ani\entity,EntityX(ani\entity),meshterrain_height(EntityX(ani\entity),EntityZ(ani\entity))+5,EntityZ(ani\entity)
	        'EndIf
			
			
			xPositionEntity temppivot,ani.packetx,ani.packety,ani.packetz

						
			distAni# = xEntityDistance (ani.entity, temppivot)
			
			If distAni# > 0.5
			
			xPointEntity ani.entity, temppivot
			
			xMoveEntity ani.entity, 0,0,0.5
			
			
			EndIf
			
			
			
			
			'PositionEntity ani\entity,ani\packetx,spoty#,ani\packetz
		
		
		
		
		
		
		
		'EndIf
	EndIf
	
	Next
End Function

Function moveplayers()
	For p:pdata=EachIn pdatas
	'	If p\nomovement=True Then
	'		'player hasn't moved, don't use spline
	'		terhieght= TerrainHeight(terrain,EntityX(p\entity),EntityZ(p\entity)) 
	'		spoty#=TerrainY(terrain,EntityX(p\entity),terhieght,EntityZ(p\entity))
	'		PositionEntity p\entity,p\x,spoty,p\z
	'		If p\name="Miles" Then DebugLog "no movement"
	'	Else
			'movement, use spline
			
			'anitime#=(MilliSecs()-p\packettime)/(p\lasttime*1.0)
			'If anitimet>1 Then 
			'	anitime=1.0
				'PositionEntity p\entity,p\packetx,p\packety,p\packetz
				
			'camm change
			
			xPositionEntity temppivot,p.packetx,p.packety,p.packetz

			distPL# = xEntityDistance (p.entity, temppivot)
			
			If distPL > 0.5
			
			xPointEntity p.entity, temppivot
			
			
			
			xMoveEntity p.entity, 0,0,0.5
			
						
			EndIf
			
				
					
			'Else
				
			'	newx#=BP_GetSplineX# (p\SplineID, anitime)
			'	newz#=BP_GetSpliney# (p\SplineID, anitime)
			
			'	terheight= TerrainHeight(terrain,newx,newz) 
			'	spoty#=TerrainY(terrain,newx,terheight,newz)
			'	PositionEntity p\entity,newx,p\packety-2,newz
			'EndIf
			'DebugLog "SPLINES CLC:" + p\net_id +" - " + p\x + "," + p\z + " - " + newx + "," + newz
		'rotate player To Current facing
		xRotateEntity p.entity,0,p.yaw,0	
		xEntityAutoFade p.entity,300,1000
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




	If initilizedplayerposition=False Then Return 'dont move Until player has been positioned
			'***forward And backward ***
	
	CP_Z= 0
	CP_X= 0
	CP_Y=0
	If autowalk = 1 Then
	CP_Z = WalkSpeed#
	moved=15
    EndIf
   
	If xKeyDown(200) Or (xKeyDown(17) And chatenabled = False) Then 
		wanttoleave=False
	    moved=15
		CP_Z = WalkSpeed#
	ElseIf xKeyDown(208) Or (xKeyDown(31) And chatenabled = False) Then
		wanttoleave=False
		moved=15
	  	CP_Z = -WalkSpeed#
	EndIf
	
	If xKeyHit(207) Then
	autowalk = Not autowalk
	EndIf
	
	
	If xKeyDown(54) Then							'Walk key (Right Shift)
		WalkSpeed# = .2
	Else
		WalkSpeed# = .4
	EndIf

	'***  Left And Right ***
	If xKeyDown(203) Or (xKeyDown(30) And chatenabled = False) Then 
		wanttoleave=False
		
		
		dest_yang# = dest_yang + 1.5
		
		yang# = CurveValue (yang, dest_yang, 3)
		
		xRotateEntity player_pivot, 0, yang, 0
		
	'Strafe	
	'	CP_X = -WalkSpeed#
		
	ElseIf xKeyDown(205) Or (xKeyDown(32) And chatenabled = False) Then 
		wanttoleave=False
		
		
		dest_yang# = dest_yang - 1.5
		
		yang# = CurveValue (yang, dest_yang, 3)
		
		xRotateEntity player_pivot, 0, yang, 0
		
	'Strafe	
	'	CP_X = WalkSpeed#
		
	EndIf
	
	If xMouseHit(2) Then 
	 CP_Y = 1
	EndIf
	
	If xKeyDown(157) =1 And Jumped =0				'Jump (Right Ctrl)
		PlayerGravity# = 2
		Jumped =1
	EndIf

	'first/third person views
	If xKeyHit(61) Then 
		xShowEntity player
		xPositionEntity camera,0,5,-10
	EndIf
	
	If xKeyHit(62) Then 
		xPositionEntity camera,0,2.5,-3
		xHideEntity player
	EndIf
	
	 xMoveEntity player_pivot,CP_X,CP_Y,CP_Z
	
	 playerx#=xEntityX(player_pivot,True)
	 playerz#=xEntityZ(player_pivot,True)
	 playery# = xEntityY(player_pivot,True)
	
	'Jumped = 0
	'PlayerGravity# = 0.0
	'terheight= xTerrainHeight(Terrain, playerx#, playerz#) 
	'spoty#=xTerrainY(Terrain, playerx#,terheight, playerz#)
	
  'If xEntityY(player_pivot) < spoty# Then 
	'DebugLog "SPOTY: "+spoty#+" PLAYER Y: "+xEntityY(player_pivot)
	'xPositionEntity player_pivot,playerx#,spoty#+1, playerz#,True
 	'playery# = xEntityY(player_pivot,True)
	'make sure player model sits on ground properly
 ' Else	
	If xEntityCollided( player_pivot, 1)
			'do nothing If player is in contact with terrain
			PlayerGravity# = 0.0
			Jumped =0
	Else
 			PlayerGravity# = PlayerGravity# - Gravity#
			xmoveEntity player_pivot,0,PlayerGravity#*.01,0
	EndIf
' EndIf
'PositionEntity player,EntityX(player_pivot),EntityY(player_pivot),EntityZ(player_pivot)

End Function

Function PointDistance#(x1#, y1#, z1#, x2#, y2#, z2#)
	width# = x1# - x2#
	height# = y1# - y2#
	depth# = z1# - z2#
	Return Sqr(witdh * width + depth * depth + height * height)

End Function

Function positiongrass(parent)
	' MAKE GRASS And PLACE IT-----------------------
	xPositionEntity grassMesh,0,0,0
	For a=0 To 1000
		stalk:grassStalk = New grassStalk
		stalk.x=xEntityX(player_pivot,True)+(Rnd(0,grassRange*2.0)-grassRange)
		stalk.z=xEntityZ(player_pivot,True)+(Rnd(0,grassRange*2.0)-grassRange)

		stalk.y=xTerrainHeight (parent,stalk.x,stalk.z)
		stalk.y=xTerrainY(parent,stalk.x,stalk.y,stalk.z)
			
		stalk.ang=Rnd(0,90)
		stalk.lowx#=Rnd(0.5,2)
		stalk.v1=xAddVertex(grassSurface,stalk.x+(Sin(stalk.ang)*stalk.lowx),stalk.y,stalk.z+(Cos(stalk.ang)*stalk.lowx))
		stalk.v2=xAddVertex(grassSurface,stalk.x-(Sin(stalk.ang)*stalk.lowx) ,stalk.y,stalk.z-(Cos(stalk.ang)*stalk.lowx))
		stalk.v3=xAddVertex(grassSurface,stalk.x+(Sin(stalk.ang)*stalk.lowx),stalk.y+Rnd(1.5,3),stalk.z+(Cos(stalk.ang)*stalk.lowx))
		stalk.v4=xAddVertex(grassSurface,stalk.x-(Sin(stalk.ang)*stalk.lowx) ,stalk.y+Rnd(1.5,3),stalk.z-(Cos(stalk.ang)*stalk.lowx))
		xVertexTexCoords grassSurface,stalk.v1,0.01,0.01
		xVertexTexCoords grassSurface,stalk.v2,0.01,.99
		xVertexTexCoords grassSurface,stalk.v3,.99,0.01
		xVertexTexCoords grassSurface,stalk.v1,.99,.99
		
		stalk.t1=xAddTriangle(grassSurface,stalk.v1,stalk.v2,stalk.v3)
		stalk.t2=xAddTriangle(grassSurface,stalk.v3,stalk.v2,stalk.v4)
		stalk.t3=xAddTriangle(grassSurface,stalk.v1,stalk.v3,stalk.v2)
		stalk.t4=xAddTriangle(grassSurface,stalk.v3,stalk.v4,stalk.v2)
	Next
	xUpdateNormals grassMesh

	GRASSINITIALIZED=True

End Function

Function PutInInventory(Entity,Name$,Class)

For w:weapons = EachIn Weaponsl
	I:Inventory = New inventory
	I.amount = 1
	I.typeobj =Class
	I.name$ = Name$
	I.Icon = Class
   'AddIcon(TypeOf)
Next
End Function

Function renderMessages()
	'render the latest messages, renders in any order - just takes each message Object And throws it To the screen
	xSetBuffer xImageBuffer(gThisBox)
	xClsColor 0,0,0
	xCls
	xDrawImage gTextBox,0,0
	 
	For tempmessage:message = EachIn Messages
		'render To correct position
		If tempmessage.From=""
			xColor 0,0,tempmessage.iColor
			xText 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage.id )*15),tempmessage.itext$
		Else
			If tempmessage.action
				xColor 0,0,$F800F8
				xText 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage.id )*15),"* "+tempmessage.from+" "
		    
				xColor 0,0,$F800F8
				xText 15+xStringWidth("* "+tempmessage.from+": "),LOWESTMESSAGERENDER-((gLastMessageID-tempmessage.id )*15),tempmessage.itext$
			Else
				xColor 255,0,0
				xText 15,LOWESTMESSAGERENDER-((gLastMessageID-tempmessage.id )*15),"<"+tempmessage.from+"> "
		    
				xColor 2,255,34
				xText 15+xStringWidth("<"+tempmessage.from+"> "),LOWESTMESSAGERENDER-((gLastMessageID-tempmessage.id )*15),tempmessage.itext$
			EndIf
		EndIf
		  
		'Text 30,430-((gLastMessageID-tempmessage\id )*20),tempmessage\itext$
		If gLastMessageID>(tempmessage.id+30) Then
			ListRemove(messages,tempmessage)
		EndIf
	Next
	 
	xColor 255,255,255
	 
	thismessage$=""
	 
	If Len(cText+"_")>maxcharlength
		'scroll user message
		startchar=Len(cText+"_")-maxcharlength
		thismessage$=Mid$(cText+"_",startchar)	  
	Else
		thismessage$=cText+"_"
	EndIf
	 
	xText 15,xImageHeight(gTextBox)-20,thismessage$
	 
	xSetBuffer xBackBuffer()
	 
	xDrawImage gThisBox,0,xGraphicsHeight()-xImageHeight(gThisBox)
End Function

Function servantsplash()
	splash1 = xLoadImage("media\gfx\splash\logo2.jpg")
	GammaFade -5
	xDrawImage splash1,xGraphicsWidth()/2 - (xImageWidth(splash1)/2),xGraphicsHeight()/2 - xImageHeight(splash1)/2
	GammaFade 3
	Delay 2000
	GammaFade -3
	xCls
	GammaFade 5
	xFreeImage splash1
End Function

Function SaveScreenshot() 
	iFileNumber = 0 
	Repeat 
		iFileNumber = iFileNumber + 1 
		sFileName$ = "Screenshot" + "0" +(3 - Len(""+iFileNumber+"")) + iFileNumber + ".bmp" 
	Until Not(FileType(sFileName)) 
	xSaveBuffer xBackBuffer(), sFileName 	
End Function

Function updateAnimalPosition(tid,tix#,tiz#,tiy#)
	For ani:animal=EachIn animals
		If ani.id=tid Then
			ani.x=xEntityX(ani.entity)
			ani.z=xEntityZ(ani.entity)
			ani.distancetoplayer=xEntityDistance(camera,ani.entity)
			
				
			ani.packetx=tix
			ani.packetz=tiz
			ani.yaw=ani.packetyaw		'turn To face last heading
			ani.packetyaw=tiy
    		'drop animal To the terrain height
			terhieght= xTerrainHeight(Terrain,xEntityX(ani.entity),xEntityZ(ani.entity)) 
			
			
			spoty#=xTerrainY(Terrain,xEntityX(ani.entity),terhieght,xEntityZ(ani.entity))
			
			ani.packety = spoty
			
			trex#=xTerrainX(Terrain,ani.x,xEntityY(ani.entity),ani.z)
			trez#=xTerrainZ(Terrain,ani.x,xEntityY(ani.entity),ani.z)
			'If EntityY(ani.entity)<meshterrain_height(EntityX(ani.entity),EntityZ(ani.entity))+5
		    '   PositionEntity ani.entity,EntityX(ani.entity),meshterrain_height(EntityX(ani.entity),EntityZ(ani.entity))+5,EntityZ(ani.entity)
	        'EndIf

			'calc spline coords
			'get the packet info And the Current position And calc the middle spline points
			xPositionEntity temppivot,ani.packetx,spoty,ani.packetz
			xRotateEntity temppivot,0,ani.packetyaw,0
			'spd#=EntityDistance (ani.entity,temppivot)
			'MoveEntity temppivot,0,-spd,0
					
			x2# =xEntityX(temppivot)
			z2# =xEntityZ(temppivot)

			'PositionEntity temppivot,ani.x,EntityY(ani.entity),ani.z
			'RotateEntity temppivot,0,EntityYaw(ani.entity),0
			'MoveEntity temppivot,0,spd,0
			'x1# =EntityX(temppivot)'p.x + Sin(p.yaw)
			'z1# =EntityZ(temppivot)'p.z + Cos(p.yaw)
								
'			x1#=ani.x + (Sin(ani.yaw)*2)
'			z1#=ani.z + (Cos(ani.yaw)*2)
'			x2#=ani.packetx - (Sin(ani.packetyaw)*2)
'			z2#=ani.packetz - (Cos(ani.packetyaw)*2)

			'BP_Initspline (ani.splineid,ani.x,ani.z,x1,z1,x2,z2,ani.packetx,ani.packetz)
	
			ani.lasttime=MilliSecs()-ani.timestamp
			'If ani.id=1 Then DebugLog ani.lasttime
			ani.timestamp=MilliSecs()
			Return
		EndIf
	Next
	
	'animal with this ID is New, Create it with no spline info this time round
	ani:animal=New animal
	ani.entity = xCopyEntity(player)'LoadAnimMesh("media/models/player/knight.b3d")
	
	
	'EntityAutoFade ani.entity,200,350
	xAnimate ani.entity,1,0.8,knight_A_walk,1'run knight_A_walk
    xScaleEntity ani.entity,2.3,2.3,2.3
	ani.id=tid
	ani.x=tix
	ani.packetx=tix
	ani.z=tiz
	ani.packetz=tiz
	ani.yaw=tiy
	ani.packetyaw=tiy
	'ani.splineid=BP_CreateSpline()
	'get the packet info And the Current position And calc the middle spline points
	x1#=ani.x' + (Sin(ani.yaw))
	z1#=ani.z' + (Cos(ani.yaw))
	x2#=ani.packetx '- (Sin(ani.packetyaw))
	z2#=ani.packetz '- (Cos(ani.packetyaw))

	'BP_Initspline (ani.splineid,ani.x,ani.z,x1,z1,x2,z2,ani.packetx,ani.packetz)
	
	ani.timestamp=MilliSecs()
	ani.lasttime=4000
End Function

Function UpdateCubemap(tex,camera,entity)

	tex_sz=xTextureWidth(tex)

	' Show the camera we have specifically created For updating the cubemap
	xShowEntity camera
	
	' Hide entity that will have cubemap applied To it. This is so we can get cubemap from its position, without it blocking the view
	xHideEntity entity

	' Position camera where the entity is - this is where we will be rendering views from For cubemap
	xPositionEntity camera,xEntityX#(entity),xEntityY#(entity),xEntityZ#(entity)

	xCameraClsMode camera,False,True
	
	' Set the camera's viewport so it is the same size as our texture - so we can fit entire screen contents into texture
	xCameraViewport camera,0,0,tex_sz,tex_sz

	' Update cubemap

	' do Left view	
	xSetCubeFace tex,0
	xRotateEntity camera,0,90,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' do forward view
	xSetCubeFace tex,1
	xRotateEntity camera,0,0,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' do Right view	
	xSetCubeFace tex,2
	xRotateEntity camera,0,-90,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' do backward view
	xSetCubeFace tex,3
	xRotateEntity camera,0,180,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' do up view
	xSetCubeFace tex,4
	xRotateEntity camera,-90,0,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' do down view
	xSetCubeFace tex,5
	xRotateEntity camera,90,0,0
	xRenderWorld
	xCopyRect 0,0,tex_sz,tex_sz,0,0,xBackBuffer(),xTextureBuffer(tex)
	
	' Show entity again
	xShowEntity entity
	
	' Hide the cubemap camera
	xHideEntity camera
	
End Function

Function updateGrass(parent)
	Local update
	modx#=xEntityX(player_pivot)
	modz#=xEntityZ(player_pivot)
	For stalk:grassstalk=EachIn grassStalks
		update=False
		
		If stalk.x<modx-grassRange Then
			stalk.x=stalk.x+(grassRange*2)
			update=True
		EndIf
		
		If stalk.x>modx+grassRange Then
			stalk.x=stalk.x-(grassRange*2)
			update=True
		EndIf

		If stalk.z<modz-grassRange Then
			stalk.z=stalk.z+(grassRange*2)
			update=True
		EndIf
		
		If stalk.z>modz+grassRange Then
			stalk.z=stalk.z-(grassRange*2)
			update=True
		EndIf

		'update this stalk
		If update=True Then
			'check foliage map
'				tempgrassx# = tcx/grassmapscale'ngx/grassmapscale
'				tempgrassy# = 256-(tcz/grassmapscale)'ngz/grassmapscale
'				col=(ReadPixelFast(ngx/grassmapscale,256-(ngz/grassmapscale),ImageBuffer(grassmap)) Shr 16) And $ff
'
'				If col>0 Then
'					PositionEntity foliage.entity,ngx,ngy+0.4,ngz
'					RotateEntity foliage.entity,Sin((MilliSecs()/20.0)+ngx)*20,EntityYaw(foliage.entity),0

		
		
			'move this stalk
			stalk.y=xTerrainHeight (parent,stalk.x,stalk.z)
			stalk.y=xTerrainY(parent,stalk.x,stalk.y,stalk.z)
			xVertexCoords grassSurface,stalk.v1,stalk.x+(Sin(stalk.ang)*stalk.lowx),stalk.y,stalk.z+(Cos(stalk.ang)*stalk.lowx)
			xVertexCoords grassSurface,stalk.v2,stalk.x-(Sin(stalk.ang)*stalk.lowx) ,stalk.y,stalk.z-(Cos(stalk.ang)*stalk.lowx)
			xVertexCoords grassSurface,stalk.v3,stalk.x+(Sin(stalk.ang)*stalk.lowx),stalk.y+Rnd(1.5,3),stalk.z+(Cos(stalk.ang)*stalk.lowx)
			xVertexCoords grassSurface,stalk.v4,stalk.x-(Sin(stalk.ang)*stalk.lowx) ,stalk.y+Rnd(1.5,3),stalk.z-(Cos(stalk.ang)*stalk.lowx)
		EndIf
	Next
	
	'UpdateNormals grassMesh
End Function

Function Update_Lightning(camera)
	For a:lightning=EachIn lightnings
		a.alpha=a.alpha-.1
		If a.alpha<1 Then 
			xEntityAlpha a.ent,a.alpha
			xEntityColor a.ent,255*a.alpha,255*a.alpha,255
		End If
		If a.alpha<0 Then xFreeEntity a.ent; ListRemove(lightnings,a)	
	Next
	If flash>0 Then flash=flash-20
	If flash<0 Then flash=0
End Function

Function updateRain(amountofRain)
	' // Create Rain
	If rain_delay<MilliSecs()-amountofRain
		For t=1 To (Int(weatherdensity)/8)
			r:rain=New rain
			r.x#=xEntityX#(player_pivot)-(Sin(xEntityYaw#(player_pivot))*Rnd(768))-(Sin(xEntityYaw#(player_pivot)+90)*Rnd(-384,384))
			r.y#=384+Rnd(128)
			r.z#=xEntityZ#(player_pivot)+(Cos(xEntityYaw#(player_pivot))*Rnd(768))+(Cos(xEntityYaw#(player_pivot)+90)*Rnd(-384,384))
			r.xv#=Rnd(-1,1)
			r.yv#=Rnd(0,-4)
			r.zv#=Rnd(-1,1)
			r.xvg#=0
			r.yvg#=-1
			r.xvg#=0
		Next
		rain_delay=MilliSecs()
	EndIf
'	rain_delay=rain_delay-1

	' // Update Rain
	If Not KeyDown(57)
		xClearSurface rain_surface
		For r:rain=EachIn rains
			r.lx#=r.x#
			r.ly#=r.y#
			r.lz#=r.z#
			r.x#=r.x#+r.xv#
			r.y#=r.y#+r.yv#
			r.z#=r.z#+r.zv#
			r.xv#=r.xv#+r.xvg#
			r.yv#=r.yv#+r.yvg#
			r.zv#=r.zv#+r.zvg#
			r.ang#=xEntityYaw#(player_pivot)
			r.v1=xAddVertex(rain_surface,r.lx#-(Sin(r.ang#+90)*-0.3),r.ly#,r.lz#+(Cos(r.ang#+90)*-0.3))
			r.v2=xAddVertex(rain_surface,r.lx#-(Sin(r.ang#+90)*0.3),r.ly#,r.lz#+(Cos(r.ang#+90)*0.3))
			r.v3=xAddVertex(rain_surface,r.x#-(Sin(r.ang#+90)*-0.3),r.y#,r.z#+(Cos(r.ang#+90)*-0.3))
			r.v4=xAddVertex(rain_surface,r.x#-(Sin(r.ang#+90)*0.3),r.y#,r.z#+(Cos(r.ang#+90)*0.3))
			xVertexColor rain_surface,r.v1,0,0,0,0
			xVertexColor rain_surface,r.v2,0,0,0,0
			xVertexColor rain_surface,r.v3,50,50,150,0.25
			xVertexColor rain_surface,r.v4,50,50,150,0.25
			r.t1=xAddTriangle(rain_surface,r.v1,r.v2,r.v3)
			r.t2=xAddTriangle(rain_surface,r.v3,r.v2,r.v4)
			r.t3=xAddTriangle(rain_surface,r.v1,r.v3,r.v2)
			r.t4=xAddTriangle(rain_surface,r.v3,r.v4,r.v2)
			If r.y#<=xTerrainY#(Terrain,r.x#,r.y#,r.z#)
'				If TerrainY#(terrain,r.x#,r.y#,r.z#)<96
'					rr.rain_ripple=New rain_ripple
'					rr.life#=10
'					rr.ent=CopyEntity(rain_ripple)
'					SpriteViewMode rr.ent,2
'					PositionEntity rr.ent,r.x#,96,r.z#
'					RotateEntity rr.ent,90,0,0
'					RotateSprite rr.ent,Rnd(360)
'					EntityBlend rr.ent,1
'					EntityAlpha rr.ent,0.75
'					EntityColor rr.ent,144,192,255
'					rs.rain_splash=New rain_splash
'					rs.life#=15
'					rs.ent=CopyEntity(rain_splash)
'					PositionEntity rs.ent,r.x#,96,r.z#
'					RotateSprite rs.ent,Rand(0,1)*180
'					EntityBlend rs.ent,1
'					EntityAlpha rs.ent,0.75
'					EntityColor rs.ent,144,192,255
'					rr.rain_ripple=New rain_ripple
'					rr.life#=10
'					rr.ent=CopyEntity(rain_ripple)
'					r.x#=r.x#+Rnd(-128,128)
'					r.z#=r.z#+Rnd(-128,128)
'					SpriteViewMode rr.ent,2
'					PositionEntity rr.ent,r.x#,96,r.z#
'					RotateEntity rr.ent,90,0,0
'					RotateSprite rr.ent,Rnd(360)
'					EntityBlend rr.ent,1
'					EntityAlpha rr.ent,0.75
'					EntityColor rr.ent,144,192,255
'					rs.rain_splash=New rain_splash
'					rs.life#=15
'					rs.ent=CopyEntity(rain_splash)
'					PositionEntity rs.ent,r.x#,TerrainY#(terrain,r.x#,r.y#,r.z#),r.z#
'					RotateSprite rs.ent,Rand(0,1)*180
'					EntityBlend rs.ent,1
'					EntityAlpha rs.ent,0.75
'					EntityColor rs.ent,144,192,255
'					Else
					rs:rain_splash=New rain_splash
					rs.life#=15
					rs.ent=xCopyEntity(rain_splashh)
					xPositionEntity rs.ent,r.x#,xTerrainY#(Terrain,r.x#,r.y#,r.z#),r.z#
					xRotateSprite rs.ent,Rand(0,1)*180
					xEntityBlend rs.ent,1
					xEntityAlpha rs.ent,0.75
					xEntityColor rs.ent,144,192,255
					rs:rain_splash=New rain_splash
					rs.life#=15
					rs.ent=xCopyEntity(rain_splashh)
					r.x#=r.x#+Rnd(-128,128)
					r.z#=r.z#+Rnd(-128,128)
					xPositionEntity rs.ent,r.x#,xTerrainY#(Terrain,r.x#,r.y#,r.z#),r.z#
					xRotateSprite rs.ent,Rand(0,1)*180
					xEntityBlend rs.ent,1
					xEntityAlpha rs.ent,0.75
					xEntityColor rs.ent,144,192,255
'				EndIf
				ListRemove(rains,r)
			EndIf
		Next
		xUpdateNormals rain_mesh
		For rs:rain_splash=EachIn rain_splashes
			rs.life#=rs.life#-1
			xScaleSprite rs.ent,2*(1-rs.life#/15)+1,1*Cos(rs.life#*12-90)+1
			xEntityAlpha rs.ent,rs.life#/15*0.5
			If rs.life#=<0
				xFreeEntity rs.ent
				ListRemove(rain_splashes,rs)
			EndIf
		Next
		For rr:rain_ripple=EachIn rain_ripples
			rr.life#=rr.life#-1
			xScaleSprite rr.ent,4*(1-rr.life#/10),4*(1-rr.life#/10)
			xEntityAlpha rr.ent,rr.life#/10*0.5
			If rr.life#=<0
				xFreeEntity rr.ent
				ListRemove(rain_ripples,rr)
			EndIf
		Next
	EndIf
		'rain noise
	xChannelVolume chlrainl,currentcloudalpha
	xChannelVolume chlrainh,currentcloudalpha/2.0

End Function

Function UpdateWater(surface,mesh)
' Create a wave effect by moving all the vertices in the mesh up And down using Sin
' Try editing:
' Freq#=MilliSecs()/10 
'                   ^ The Bigger the divide, the slower the water moves
' Vertex(a)\z#=Sin(freq+Vertex(a)\x#*300+Vertex(a)\y#*400)*1.125
'                                                         ^ The Bigger the Multiply The Higher 
'                                                           the waves will be, Lower = smaller

For a=0 To VertexCount-1 
Freq#=MilliSecs()/10
TVertex[a].z#=Sin(freq+TVertex[a].x#*300+TVertex[a].y#*400)*1.125
xVertexCoords surface,a,TVertex[a].x#,TVertex[a].y#,TVertex[a].z#
Next

xUpdateNormals mesh

End Function

Function visibleMessageAdd(messagee$,from$,action,iColor,iFromColor)
	'add a visible message To the list
	Local tempMessage:Message
	While Len(messagee$)>maxcharlength
		gLastMessageID=gLastMessageID+1
		tempmessage = New Message
		tempmessage.id=gLastMessageID
		tempmessage.from=from
		tempmessage.action=action
		tempmessage.icolor=iColor
		tempmessage.fcolor=iFromColor
		  
		'find the last space on that line
		For icount = maxcharlength To 1 Step-1
			If Mid$(messagee$,icount,1)=" " Then
				lastspace=icount
				icount = -1   'To break the loop
			EndIf
		Next
		 
		If lastspace<2 Then 
			lastspace = maxcharlength
		EndIf
		tempmessage.itext$=Left(messagee$,lastspace)
		messagee$=Mid$(messagee$,lastspace)
	Wend
	 
	gLastMessageID=gLastMessageID+1
	tempMessage:Message = New Message
	tempmessage.from=from
	tempmessage.action=action
	tempmessage.icolor=iColor
	tempmessage.fcolor=iFromColor
	tempmessage.id=gLastMessageID
	tempmessage.itext$=Left(messagee$,maxcharlength)
End Function



'~IDEal Editor Parameters:
'~F#0#3F#E0#18F#197#1A0#1A6#1AE#22D#23B#242#24D#252#259#25D#264#350#38E#3DA#414
'~F#447#4C1#536#593#69B
'~C#Blitz3D