;Particle Library (c) 2002 Binary People Ltd. All rights reserved.

Const MAX_PARTICLES=5000

;Const GRAVITY#=-0.005
Const GRAVITY#=-0.01900

Type particle
	Field x#				;currentx
	Field y#				;currenty
	Field z#				;currentz
	
	Field age				;current age
	Field maxage			;max age - die if age = this
	
	Field gfx				;reference to the sprite
	
	Field xacc#				;current x acceleration
	Field yacc#				;current y acceleration
	Field zacc#				;current z acceleration
	Field MostSolid#		;transparency minimum (or is it max?)
	Field useGrav
	Field ID				;unique ID - not used yet
End Type

Type generator
	Field x#				;generator location
	Field y#
	Field z#
	Field xacc#				;generator defaults for x,y,z acceleration
	Field yacc#
	Field zacc#				
	Field distortion#		;acceleration randomizer
	Field spitDelay			;timer delay between spits
	Field particleLife
	Field useGrav
	Field ID				;unique ID - not used yet
	Field lastSpit
	Field gfx				;master sprite
	Field fx				;entityfx
	Field xScale#
	Field yScale#
	Field MostSolid#
	Field born				;the millisec the generator was born
	Field maxAge			;max age of generator, -1 = immortal IN MILLISECS
End Type



Function createGenerator (x#,y#,z#,xacc#=0,yacc#=0,zacc#=0,distortion#=0.5,spitDelay=100,particleMaxAge=5,useGrav=True,myGFX$="fire.png",xScale#=0.1,yScale#=0.11,MostSolid#=1,fx=2,maxAge=-1)
;	create a particle generator
	ng.generator = New generator
	ng\x=x
	ng\y=y
	ng\z=z
	ng\xacc=xacc
	ng\yacc=yacc
	ng\zacc=zacc
	ng\distortion = distortion

	ng\spitDelay = spitDelay
	ng\particleLife=particleMaxAge
	ng\useGrav=useGrav
	ng\gfx=LoadSprite(myGFX$,fx)
	HideEntity ng\gfx
	ng\xScale=xScale
	ng\yScale=yScale
	ng\MostSolid=mostsolid
	ng\id = Rand(1,32000)  			;crappy id generator - REWRITE
	ng\born=MilliSecs()
	If maxAge=-1 Then 
		ng\maxAge=-1
	Else
		ng\maxage=MilliSecs() + maxAge
	EndIf
	
	Return ng\id
End Function

Function createparticle (myGen.generator)
	For count.particle = Each particle
		icount=icount+1
	Next
	
	If icount>MAX_PARTICLES Return

	np.particle = New particle
	np\x=mygen\x
	np\y=mygen\y
	np\z=mygen\z
	
	;randomize acceleration of particle
	np\xacc=mygen\xacc + Rnd (-myGen\distortion/2, myGen\distortion/2)
	np\yacc=mygen\yacc + Rnd (-myGen\distortion/2, myGen\distortion/2)
	np\zacc=mygen\zacc + Rnd (-myGen\distortion/2, myGen\distortion/2)
	np\useGrav=myGen\useGrav
	np\maxage = myGen\particleLife
	
	np\MostSolid = myGen\MostSolid
	
	np\gfx = CopyEntity (mygen\gfx)
	EntityFX np\gfx,mygen\fx
	ScaleSprite np\gfx,mygen\xscale,mygen\yscale

End Function

Function UpdateGenerators()
	For a.generator = Each generator
		If a\lastSpit + a\spitDelay < MilliSecs() Then
			createParticle (a)
			a\lastSpit = MilliSecs()
		EndIf
		If a\maxage>-1
			If MilliSecs()> a\maxage Then
				FreeEntity a\gfx
				Delete a
			EndIf
		EndIf
	Next
End Function

Function updateParticles()	
	For a.particle = Each particle
		
		;move particle
		
		If a\useGrav=True Then
			a\yacc=a\yacc + GRAVITY	
		EndIf
		
		a\x=a\x+a\xacc
		a\y=a\y+a\yacc 
		a\z=a\z+a\zacc
		
		PositionEntity a\gfx,a\x,a\y,a\z
		
		;age checking
		a\age=a\age+1
		alpha#=a\mostsolid-((a\mostsolid/a\maxage) * a\age)
		EntityAlpha a\gfx, alpha
		If a\age>a\maxage Then
			FreeEntity a\gfx
			Delete a
		EndIf
	Next
End Function