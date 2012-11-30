xSetBuffer xBackBuffer(  )
xShowPointer
Global sex
'Include "includes\blitzui.bb"
'LoadColourScheme( "misc\slate.cs" )
'Load fonts And mouse cursors
'And collect information
'Initialise(  )
Global exitcase
'Window


xvalueChar = (GraphicsWidth()/2) - 104
yvalueChar = (GraphicsHeight()/2) - 238

win002 = alCreateGWindow("Character generation", 209, 276, -1, -1, AL_WinbuttonTopmost);
'win002 = Window( xvalueChar, yvalueChar, 209, 476, "Character generation", "0", 0, 0, 0, 0 )
sendbut	= alCreateGButton(win002 , "Enter Game", 9, 389, 179, 36);
'sendbut = Button( 9, 419, 179, 16, "Enter Game", "0", 1, 0, 0 )
chk001 = alCreateGToggleButton(win002, "Male", 11, 44, 50, -1, 0, "CheckBox");
chk002 = alCreateGToggleButton(win002, "Female", 62, 44, 50, -1, 0, "CheckBox");
chk003 = alCreateGToggleButton(win002, "Good", 11, 83, 50, -1, 0, "CheckBox");
chk004 = alCreateGToggleButton(win002, "Evil", 62, 83, 50, -1, 0, "CheckBox");
chk005 = alCreateGToggleButton(win002, "Mage", 11, 159, 50, -1, 0, "CheckBox");
chk006 = alCreateGToggleButton(win002, "Warrior", 62, 159, 50, -1, 0, "CheckBox");
chk007 = alCreateGToggleButton(win002, "Hunter", 11, 185, 50, -1, 0, "CheckBox");
chk008 = alCreateGToggleButton(win002, "Warlock", 62, 185, 50, -1, 0, "CheckBox");
chk009 = alCreateGToggleButton(win002, "Paladin", 11, 207, 50, -1, 0, "CheckBox");
chk010 = alCreateGToggleButton(win002, "Rogue", 62, 207, 50, -1, 0, "CheckBox");
chk011 = alCreateGToggleButton(win002, "Shaman", 11, 230, 50, -1, 0, "CheckBox");
chk012 = alCreateGToggleButton(win002, "Priest", 62, 230, 50, -1, 0, "CheckBox");
chk013 = alCreateGToggleButton(win002, "DK", 11, 269, 50, -1, 0, "CheckBox");
chk014 = alCreateGToggleButton(win002, "Monk", 62, 269, 50, -1, 0, "CheckBox");
chk015 = alCreateGToggleButton(win002, "Bard", 11, 292, 50, -1, 0, "CheckBox");
chk016 = alCreateGToggleButton(win002, "Gunner", 62, 292, 50, -1, 0, "CheckBox");
chk017 = alCreateGToggleButton(win002, "Psionist", 11, 315, 50, -1, 0, "CheckBox");
chk018 = alCreateGToggleButton(win002, "Druid", 62, 315, 50, -1, 0, "CheckBox");
chk019 = alCreateGToggleButton(win002, "Ninja", 11, 337, 50, -1, 0, "CheckBox");
chk020 = alCreateGToggleButton(win002, "Samurai", 62, 337, 50, -1, 0, "CheckBox");
lbl001 = alCreateGStatic(win002, "Player Name:", 12, 1, -1, -1, 0, "LabelJ");
lbl002 = alCreateGStatic(win002, "Stats are automaticlly generated", 20, 395, -1, -1, 0, "LabelJ");
nametxt = alCreateGTextBox(win002, "Name",  11, 13, 92, "");

Rem
chk001 = CheckBox( 11, 44, "Male", 0 )
chk002 = CheckBox( 62, 45, "Female", 0 )
chk003 = CheckBox( 11, 83, "Good", 0 )
chk004 = CheckBox( 63, 84, "Evil", 0 )
chk005 = CheckBox( 11, 159, "Sorcer", 0 )
chk006 = CheckBox( 69, 158, "Amazon", 0 )
chk007 = CheckBox( 12, 184, "Archer", 0 )
chk008 = CheckBox( 70, 185, "Netibliss", 0 )
chk009 = CheckBox( 12, 207, "Paladin", 0 )
chk010 = CheckBox( 71, 207, "Ranger", 0 )
chk011 = CheckBox( 13, 230, "Peasent", 0 )
chk012 = CheckBox( 72, 231, "Hunter", 0 )
chk013 = CheckBox( 13, 269, "Goul", 0 )
chk014 = CheckBox( 74, 269, "Stalker", 0 )
chk015 = CheckBox( 13, 292, "Warlock", 0 )
chk016 = CheckBox( 74, 292, "Night", 0 )
chk017 = CheckBox( 13, 315, "Sphene", 0 )
chk018 = CheckBox( 76, 316, "Vampire", 0 )
chk019 = CheckBox( 13, 337, "Guntrines", 0 )
chk020 = CheckBox( 76, 337, "Baki", 0 )

lbl001 = Label( 12, 1, "Player Name", 0 )
lbl002 = Label( 20, 395, "Stats are automaticlly generated", 0 )
nametxt = TextBox( 11, 13, 92, 21, 0, 0, 18, 10, 0 )
SendMessage( nametxt, "TM_SETTEXT", 0, "" )
SendMessage( win002, "WM_SETLOCKED" )
'Windows must only be set as modal after
'the interface has been created.
SendMessage( win002, "WM_SETMODAL" )
exitcase = 0
End Rem
Local event:sEvent = New sEvent
Repeat
	alGetEvent(event)
	xCLS
	'Draw the GUI And update the mouse
	AlbaLynx_Update()
	
	'Event Handling
	Select event.type_

		Case ALEVENT_CLICK
			Select event.object_
			Case chk001
			mysex = 1
			Case chk002
			mysex = 2
			Case chk003
			goodorbad = 1
			Case chk004
			goodorbad = 2
			
			Case sendbut
				
				myname$=alGetValueS(nametxt)
				charactermodel = 1
				
				'check To see If name has been entered
				If myname$ <> ""
					exitcase = 1
					
				EndIf
				
			End Select
	End Select
	
	'Draw the mouse
	'DrawMouse(  )
	
	'Reset all GUI events
	'ResetEvents(  )

	xFlip
	
	Until KeyHit(1) Or exitcase = 1


'~IDEal Editor Parameters:
'~C#Blitz3D