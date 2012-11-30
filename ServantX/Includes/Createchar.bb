SetBuffer BackBuffer(  )
HidePointer
Global sex
Include "includes\blitzui.bb"
LoadColourScheme( "misc\slate.cs" )
;Load fonts and mouse cursors
;and collect information
Initialise(  )
Global exitcase
;Window


xvalueChar = (GraphicsWidth()/2) - 104
yvalueChar = (GraphicsHeight()/2) - 238

win002 = Window( xvalueChar, yvalueChar, 209, 476, "Character generation", "0", 0, 0, 0, 0 )
sendbut = Button( 9, 419, 179, 16, "Enter Game", "0", 1, 0, 0 )
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
;Windows must only be set as modal after
;the interface has been created.
SendMessage( win002, "WM_SETMODAL" )
exitcase = 0
Repeat

	;Draw the GUI and update the mouse
	UpdateGUI(  )
	
	;Event Handling
	Select app\Event
		Case EVENT_WINDOW
			Select app\WindowEvent
			End Select
		Case EVENT_MENU
			Select app\MenuEvent
			End Select
		Case EVENT_GADGET
			Select app\GadgetEvent
			Case chk001
			mysex = 1
			Case chk002
			mysex = 2
			Case chk003
			goodorbad = 1
			Case chk004
			goodorbad = 2
			
			Case sendbut
				
				myname$=SendMessage(nametxt, "TM_GETTEXT")
				charactermodel = 1
				
				;check to see if name has been entered
				If myname$ <> ""
					exitcase = 1
					
				EndIf
				
			End Select
	End Select
	
	;Draw the mouse
	DrawMouse(  )
	
	;Reset all GUI events
	ResetEvents(  )

	Flip
	Cls
	Until KeyHit(1) Or exitcase = 1


;~IDEal Editor Parameters:
;~C#Blitz3D