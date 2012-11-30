Global app.Application = Null

Const EVENT_WINDOW  	= 1
Const EVENT_MENU		= 2
Const EVENT_GADGET		= 3

Global SC_FORM$				= "210,210,210"		;Form Background Colour
Global SC_FORMTEXT$			= "0,0,0"			;Form Text Colour (Labels, Buttons etc)
Global SC_FORMTITLE$		= "80,140,200"		;Form Titlebar Colour
Global SC_FORMTITLEITEM$	= "140,200,255"		;Form Titlebar Item Colour (Caption / Buttons)

Global SC_MENU$				= "210,210,210"		;Main Menu Colour
Global SC_MENUSEL$			= "100,160,220"		;Selected Menu Item Colour
Global SC_MENUSTRIP$		= "80,140,200"		;Colour of left strip
Global SC_MENUSTRIPITEM$	= "135,195,255"     ;Colour of items in left strip
Global SC_MENUTEXT$			= "0,0,0"			;Menu Text Colour
Global SC_MENUTEXTSEL$		= "0,0,0"			;Selected Menu Text Colour

Global SC_GADGET$			= "250,250,250" 	;Base colour of certain gadgets
Global SC_GADGETSTRIP$		= "80,140,200"		;Colour of left strip in certain gadgets
Global SC_GADGETSTRIPITEM$	= "135,195,255"		;Colour of left strip items in certain gadgets

Global SC_INPUT$			= "240,240,240"		;Input Background Colour (Text Boxes, Spinners etc)
Global SC_INPUTTEXT$		= "0,0,0"			;Input Text Colour
Global SC_INPUTTEXTSEL$		= "255,255,255"		;Selected Input Text Colour
Global SC_INPUTHILIGHT$ 	= "100,160,220"		;Input Highlight Colour (Background colour of selected text)

Global ModVersion = False ;ONLY FOR USE WITH GUI EDITOR... SHOULD BE FALSE AT ALL TIMES
Global SnapWindows = False ;SET WITH SetWindowSnap(  )
Global SNAP_STRENGTH = 5 ;Strength of snap in pixels

.Arrow
Data -16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-16777216,-65536,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-16777216,-65536,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-328966,-16777216,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-16777216,-65536,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-16777216,-65536,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-328966,-16777216,-65536
Data -16777216,-328966,-328966,-328966,-328966,-328966,-328966,-16777216,-16777216,-16777216,-16777216,-16777216
Data -16777216,-328966,-328966,-328966,-16777216,-328966,-328966,-16777216,-65536,-65536,-65536,-65536
Data -16777216,-328966,-328966,-16777216,-16777216,-328966,-328966,-16777216,-65536,-65536,-65536,-65536
Data -16777216,-328966,-16777216,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536,-65536,-65536
Data -16777216,-16777216,-65536,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536,-65536,-65536
Data -16777216,-65536,-65536,-65536,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-328966,-328966,-16777216,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-65536,-65536

.IBeam
Data -16777216,-16777216,-16777216,-65536,-16777216,-16777216,-16777216
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-65536,-65536,-65536
Data -16777216,-16777216,-16777216,-65536,-16777216,-16777216,-16777216

.Block
Data -65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536
Data -65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536
Data -65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536
Data -65536,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-65536
Data -65536,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-16777216,-65536
Data -16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-16777216,-16777216
Data -16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-16777216,-16777216
Data -16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-16777216,-16777216
Data -16777216,-16777216,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216
Data -16777216,-16777216,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216
Data -16777216,-16777216,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216
Data -65536,-16777216,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-65536
Data -65536,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-65536
Data -65536,-65536,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-65536,-65536
Data -65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-16777216,-16777216,-16777216,-16777216,-16777216,-16777216,-65536,-65536,-65536,-65536,-65536

.Dropper
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-13619152,-13619152,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-13619152,-4737097,-13487566,-12698050
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-13619152,-4473928,-13619152,-4737097,-7895161,-11250604,-13224395
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-12698050,-4737097,-13224394,-4737097,-7895161,-11579569,-13619152,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-13619152,-4737097,-7895161,-11053225,-13224394,-11316397,-13224394,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-13619152,-11579569,-13619152,-12698050,-12763843,-8487301,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-65536,-7488563,-7948343,-13619152,-13619152,-13619152,-12763843,-13619152,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-65536,-7488563,-1,-8473914,-11170655,-13619152,-13619152,-12698050,-65536,-65536,-65536
Data -65536,-65536,-65536,-65536,-65536,-7225906,-1,-788231,-11170655,-14217832,-65536,-13619152,-65536,-65536,-65536,-65536
Data -65536,-65536,-65536,-65536,-7423027,-1,-722694,-5912362,-14217831,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -65536,-65536,-65536,-7225906,-1,-722694,-5912362,-14217319,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -65536,-65536,-7225906,-1,-788231,-5977898,-14217831,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -65536,-10643283,-1,-722694,-5912362,-14217832,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -65536,-5977898,-788231,-5912362,-14217832,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -5846569,-657158,-14217831,-14217831,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536
Data -65536,-14217319,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536,-65536

Type Application

	;Environment
	Field W, H
	
	;Frame Rate
	Field FPeriod, FTime, FRate, FElapsed, FTicks, FTween#, FLimit, FPS#

	;Mouse
	Field NoImage, MArrow, MIBeam, MBlock, MDropper, MCurrent, MX, MY, MZ, MXS#, MYS#, MZS#, MB1, MB2, MB3
	
	;Timers
	Field Timer
	
	;Messages
	Field Event, WindowEvent, WindowEventData$, MenuEvent, MenuEventData$, GadgetEvent, GadgetEventData$
	
	Field Quit
	
	;Fonts
	Field fntWindow, fntTab, fntMenu, fntButton, fntCheckBox, fntComboBox, fntGroupBox, fntLabel, fntListBox, fntProgressBar, fntRadio, fntSpinner, fntTextBox, fntTreeView
	
	;Active Gadgets
	Field overWin.Window, topWin.Window, actMenu.MenuTitle, actCombo.ComboBox, actOwner$
	
	;Tool Tip
	Field ToolTip$, ToolTipTimer, ToolTipDelay
	
End Type

Type Window

	Field ID, CID, RID$, X, Y, W, H, FX, FY, MY, DX, DY, TH, MH, SMH, STH
	Field Caption$, Icon, IconSource$, CHandle$, Centered
	Field TitleBar, Menu, MinBtn, CloseBtn, CloseBtnActive, CloseBtnState, MinBtnActive, MinBtnState
	Field Dragging, DragX, DragY, Minimised, Closed, ClosedFake, Locked, AlwaysOnTop, AlwaysOnTopFake

End Type

Type Tab

	Field ID, CID, X, Y, W, H, IH, XOFF, CHandle$, Visible
	Field Owner.Window, Active.TabPage

End Type

Type TabPage

	Field ID, CID, Caption$, Image, ImageSource$, X, W, Disabled, CHandle$, Visible
	Field Owner.Tab
	Field ToolTip$

End Type

Type MenuTitle

	Field ID, CID, RID$, X, Y, W, DW, DH, IH, SBW, YOFF, Caption$, Active, State, ActiveItem, Disabled, CHandle$, Visible
	Field Owner.Window
	Field ToolTip$
	
End Type

Type MenuItem

	Field ID, CID, RID$, Icon, IconSource$, Checked, AllowCheck, Caption$, ShortCut$, State, X, Y, W, H, YOFF, DW, DH, SubMenu, Active, Disabled, GroupID, Visible
	Field Owner.MenuTitle, ParentMenu.MenuItem, CHandle$
	Field ToolTip$
	
End Type

Type Button

	Field ID, CID, X, Y, W, H, Caption$[32], Active, State, TState, Lines, Image, ImageSource$, Border, Popup, GroupID, Disabled, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$, DrawMode
	Field ToolTip$
	
End Type

Type CheckBox

	Field ID, CID, X, Y, W, H, Caption$, Checked, Active, State, Disabled, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type ComboBox

	Field ID, CID, X, Y, W, H, DH, IH, SW, Active, Index, Item$[512], Icon[512], IconSource$[512], Count, Disabled
	Field Inc, SDelay, MaxItems, ScrollY, RH, ScrollW, Timer, ScrollH, DragY, Visible
	Field TBState, TBActive, BBState, BBActive, SBActive
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type GroupBox

	Field ID, CID, X, Y, W, H, Caption$, BG, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Image

	Field ID, CID, Image, ImageSource$, X, Y, W, H, Align, VAlign, Mask, DrawMode, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type ImageBox

	Field ID, CID, Image, ImageSource$, X, Y, W, H, MX, MY, Align, VAlign, Border, DrawMode, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Label

	Field ID, CID, X, Y, W, H, Caption$[32], Lines, Align, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type ListBox

	Field ID, CID, X, Y, W, H, IH, SW, RH, Count, CountVisible, Item$[1024], Icon[1024], IconSource$[1024], ActiveIndex, Disabled
	Field Active, TBActive, TBState, BBActive, BBState, SBActive, SBState, Timer, DragY, Visible
	Field ScrollY, ScrollW, ScrollH, Inc, SDelay, Snap
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type ProgressBar

	Field ID, CID, X, Y, W, H, Value, Percent, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Radio

	Field ID, CID, X, Y, W, H, Caption$, Checked, Active, State, GroupID, Disabled, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Scrollbar

	Field ID, CID, X, Y, W, H, Value#, Min#, Max#, Mode, Dir, DragX, DragY, SX#, SY#, SW#, Disabled, Visible
	Field BActive, BState, LBActive, LBState, RBActive, RBState
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Slider

	Field ID, CID, X, Y, W, H, Value#, Min#, Max#, Mode, Dir, DragX, DragY, SX#, SY#, Disabled, Visible
	Field SR, SG, SB, ER, EG, EB
	Field BActive, BState
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Spinner

	Field ID, CID, X, Y, W, H, Value#, Inc#, Min#, Max#, Mode, Timer, TimerInc, Disabled, ButtonsOnly, Visible
	Field TBActive, TBState, BBActive, BBState
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type TextBox

	Field ID, CID, X, Y, W, H, RH, IH, Caption$[10240], LineCount, LineCountVisible, Disabled, Visible
	Field ScrollX#, ScrollY#, ScrollW, ScrollH#, Inc, SDelay, Timer, CursorTimer, Key, KeyTimer
	Field LBActive, LBState, RBActive, RBState, TBActive, TBState, BBActive, BBState, SBActive, SBState, DragX, DragY
	Field LineStart, LineEnd, MultiLine, Mode, Snap, DCTimer, DCLick
	Field SelStart, SelEnd
	Field Active, State, SActive
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$

End Type

Type TreeView

	Field ID, CID, X, Y, W, H, IH, RH, NodeW, Count, CountVisible, YOFF, WOFF, Selected, CurrentIndex, Caption$, ParentCaption$
	Field TBActive, TBState, BBActive, BBState, SBActive, SBState, Timer, DragY, NumChildren
	Field ScrollY, ScrollW, ScrollH, Inc, Snap, SDelay, Disabled, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	Field ToolTip$
	
End Type

Type Node

	Field ID, CID, Caption$, Icon, IconSource$, Active, Y, YOFF, Count, Layer, HasChildren, CurrentNode
	Field Owner.TreeView, ParentNode.Node, Disabled, Visible
	Field PrevNode.Node, NextNode.Node, CHandle$

End Type

Type Circle

	Field ID, CID, X, Y, W, H, FillR, FillG, FillB, OutR, OutG, OutB, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	
End Type

Type Square

	Field ID, CID, X, Y, W, H, FillR, FillG, FillB, OutR, OutG, OutB, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	
End Type

Type Triangle

	Field ID, CID, X, Y, W, H, FillR, FillG, FillB, OutR, OutG, OutB, Visible
	Field Owner.Window, TabOwner.TabPage, CHandle$
	
End Type

Function ResetEvents()

	app\Event = 0
	app\WindowEvent = 0
	app\MenuEvent = 0
	app\GadgetEvent = 0
	
	app\GadgetEventData = 0

End Function

Function ParseID$( ID )

	win.Window = Object.Window( ID )
	If win <> Null Return "win"
	
	tab.Tab = Object.Tab( ID )
	If tab <> Null Return "tab"
	
	tabp.TabPage = Object.TabPage( ID )
	If tabp <> Null Return "tabp"
	
	mnut.MenuTitle = Object.MenuTitle( ID )
	If mnut <> Null Return "mnut"
	
	mnui.MenuItem = Object.MenuItem( ID )
	If mnui <> Null Return "mnui"
	
	btn.Button = Object.Button( ID )
	If btn <> Null Return "btn"
	
	chk.CheckBox = Object.CheckBox( ID )
	If chk <> Null Return "chk"
	
	cbo.ComboBox = Object.ComboBox( ID )
	If cbo <> Null Return "cbo"
	
	grp.GroupBox = Object.GroupBox( ID )
	If grp <> Null Return "grp"
	
	img.Image = Object.Image( ID )
	If img <> Null Return "img"
	
	imgbox.ImageBox = Object.ImageBox( ID )
	If imgbox <> Null Return "imgbox"
	
	lbl.Label = Object.Label( ID )
	If lbl <> Null Return "lbl"
	
	lst.ListBox = Object.ListBox( ID )
	If lst <> Null Return "lst"
	
	prg.ProgressBar = Object.ProgressBar( ID )
	If prg <> Null Return "prg"
	
	rad.Radio = Object.Radio( ID )
	If rad <> Null Return "rad"
	
	scroll.ScrollBar = Object.ScrollBar( ID )
	If scroll <> Null Return "scroll"
	
	sld.Slider = Object.Slider( ID )
	If sld <> Null Return "sld"
	
	spn.Spinner = Object.Spinner( ID )
	If spn <> Null Return "spn"
	
	txt.TextBox = Object.TextBox( ID )
	If txt <> Null Return "txt"
	
	tree.TreeView = Object.TreeView( ID )
	If tree <> Null Return "tree"
	
	node.Node = Object.Node( ID )
	If node <> Null Return "node"

End Function

Function Initialise(  )

	SeedRnd MilliSecs()
	If app = Null app.Application	= New Application
	
	app\W			= GraphicsWidth()
	app\H 			= GraphicsHeight()
	
	Restore Arrow
	app\MArrow		= CreateImage(12, 21)
	For A = 0 To 20
		For B = 0 To 11
			Read RGB
			WritePixel B, A, RGB, ImageBuffer( app\MArrow )
		Next
	Next
	Restore IBeam
	app\MIBeam		= CreateImage(7, 17)
	For A = 0 To 16
		For B = 0 To 6
			Read RGB
			WritePixel B, A, RGB, ImageBuffer( app\MIBeam )
		Next
	Next
	Restore Block
	app\MBlock		= CreateImage(16, 16)
	For A = 0 To 15
		For B = 0 To 15
			Read RGB
			WritePixel B, A, RGB, ImageBuffer( app\MBlock )
		Next
	Next
	Restore Dropper
	app\MDropper	= CreateImage(16, 16)
	For A = 0 To 15
		For B = 0 To 15
			Read RGB
			WritePixel B, A, RGB, ImageBuffer( app\MDropper )
		Next
	Next
	MaskImage app\MArrow, 255, 0, 0
	MaskImage app\MIbeam, 255, 0, 0
	MaskImage app\MBlock, 255, 0, 0
	MaskImage app\MDropper, 255, 0, 0
	MidHandle app\MIBeam
	MidHandle app\MBlock
	HandleImage app\MDropper, 0, 15
	app\MCurrent		= app\MArrow
	
	app\fntWindow		= LoadFont("Tahoma", 14)
	app\fntTab			= LoadFont("Tahoma", 13)
	app\fntMenu			= LoadFont("Tahoma", 13)
	app\fntButton		= LoadFont("Tahoma", 13)
	app\fntCheckBox		= LoadFont("Tahoma", 13)
	app\fntComboBox		= LoadFont("Tahoma", 13)
	app\fntGroupBox		= LoadFont("Tahoma", 13)
	app\fntLabel		= LoadFont("Tahoma", 13)
	app\fntListBox		= LoadFont("Tahoma", 13)
	app\fntProgressBar	= LoadFont("Tahoma", 13)
	app\fntRadio		= LoadFont("Tahoma", 13)
	app\fntSpinner		= LoadFont("Tahoma", 13)
	app\fntTextBox		= LoadFont("Tahoma", 13)
	app\fntTreeView		= LoadFont("Tahoma", 13)
	
	app\actOwner = "window"
	
	app\ToolTip = ""
	app\ToolTipTimer = 0
	app\ToolTipDelay = 10

End Function

Function Destroy(  )

	If app\fntWindow FreeFont app\fntWindow
	If app\fntTab FreeFont app\fntTab
	If app\fntMenu FreeFont app\fntMenu
	If app\fntButton FreeFont app\fntButton
	If app\fntCheckBox FreeFont app\fntCheckBox
	If app\fntComboBox FreeFont app\fntComboBox
	If app\fntGroupBox FreeFont app\fntGroupBox
	If app\fntLabel FreeFont app\fntLabel
	If app\fntListBox FreeFont app\fntListBox
	If app\fntProgressBar FreeFont app\fntProgressBar
	If app\fntRadio FreeFont app\fntRadio
	If app\fntSpinner FreeFont app\fntSpinner
	If app\fntTextBox FreeFont app\fntTextBox
	If app\fntTreeView FreeFont app\fntTreeView
	
	For win.Window = Each Window
		If win\Icon FreeImage win\Icon
		Delete win
	Next
	For tab.Tab = Each Tab
		Delete tab
	Next
	For tabp.TabPage = Each TabPage
		If tabp\Image FreeImage tabp\Image
		Delete tabp
	Next
	For mnut.MenuTitle = Each MenuTitle
		Delete mnut
	Next
	For mnui.MenuItem = Each MenuItem
		If mnui\Icon FreeImage mnui\Icon
		Delete mnui
	Next
	For btn.Button = Each Button
		If btn\Image FreeImage btn\Image
		Delete btn
	Next
	For chk.CheckBox = Each CheckBox
		Delete chk
	Next
	For cbo.ComboBox = Each ComboBox
		For A = 0 To cbo\Count - 1
			If cbo\Icon[A] FreeImage cbo\Icon[A]
		Next
		Delete cbo
	Next
	For grp.GroupBox = Each GroupBox
		Delete grp
	Next
	For img.Image = Each Image
		If img\Image FreeImage img\Image
		Delete img
	Next
	For imgbox.ImageBox = Each ImageBox
		If imgbox\Image FreeImage imgbox\Image
		Delete imgbox
	Next
	For lbl.Label = Each Label
		Delete lbl
	Next
	For lst.ListBox = Each ListBox
		For A = 0 To lst\Count - 1
			If lst\Icon[A] FreeImage lst\Icon[A]
		Next
		Delete lst
	Next
	For prg.ProgressBar = Each ProgressBar
		Delete prg
	Next
	For rad.Radio = Each Radio
		Delete rad
	Next
	For scroll.ScrollBar = Each ScrollBar
		Delete scroll
	Next
	For sld.Slider = Each Slider
		Delete sld
	Next
	For spn.Spinner = Each Spinner
		Delete spn
	Next
	For txt.TextBox = Each TextBox
		Delete txt
	Next
	For tree.TreeView = Each TreeView
		Delete tree
	Next
	For node.Node = Each Node
		If node\Icon FreeImage node\Icon
		Delete node
	Next
	If app\MArrow FreeImage app\MArrow
	If app\MIBeam FreeImage app\MIBeam
	If app\MBlock FreeImage app\MBlock
	If app\MDropper FreeImage app\MDropper
	
	If app <> Null Delete app

End Function

Function SendMessage$( ID, Message$, Param1$="", Param2$="" )

	Message$ = Upper( Message$ )

	win.Window = Object.Window( ID )
	If win <> Null
		Select Message
			Case "WM_SETHANDLE"
				win\CHandle = Param1
			Case "WM_GETHANDLE"
				Return win\CHandle
			Case "WM_SETICON"
				If FileType( Param1 ) = 1
					If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
						If win\Icon FreeImage win\Icon
						win\Icon = LoadImage( Param1 )
						MidHandle win\Icon
						MaskImage win\Icon, 255, 0, 0
						win\IconSource = Param1
					EndIf
				EndIf
			Case "WM_GETICON"
				Return win\IconSource
			Case "WM_BRINGTOFRONT"
				Insert win Before First Window
			Case "WM_MINIMIZE", "WM_MINIMISE"
				win\Minimised = True
			Case "WM_MAXIMIZE", "WM_MAXIMISE"
				win\Minimised = False
			Case "WM_RESTORE"
				win\Minimised = 1 - win\Minimised
			Case "WM_GETMINIMIZEDSTATE", "WM_GETMINIMISEDSTATE"
				Return win\Minimised
			Case "WM_CLOSE"
				win\Closed = True
				Insert win After Last Window
				If win = app\topWin
					app\topWin = Null
				EndIf
				For topwin.Window = Each Window
					If topwin\AlwaysOnTop = True
						If topwin\Closed = False
							Insert topwin Before First Window
							app\topWin = topwin
							Exit
						EndIf
					EndIf
				Next
				app\Event = EVENT_WINDOW
				app\WindowEvent = win\ID
			Case "WM_OPEN"
				win\Closed = False
				If app\topWin <> Null
					If app\topWin\AlwaysOnTop = False
						app\topWin = win
						Insert win Before First Window
					Else
						If win\AlwaysOnTop = False
							Insert win After First Window
						Else
							app\topWin = win
							Insert win Before First Window
						EndIf
					EndIf
				Else
					app\topWin = win
					Insert win Before First Window
				EndIf
			Case "WM_SETCENTERED"
				If Param1 = "" Param1 = True
				win\Centered = Param1
			Case "WM_GETCENTERED"
				Return win\Centered
			Case "WM_VISIBLE"
				Return 1 - win\Closed
			Case "WM_GETVISIBLEFAKE"
				Return 1 - win\ClosedFake
			Case "WM_SETVISIBLEFAKE"
				win\ClosedFake = Param1
			Case "WM_SETPOS"
				If Param1 > "" win\X = Param1
				If Param2 > "" win\Y = Param2
			Case "WM_GETPOS"
				If Param1 = True
					Return win\X
				Else
					Return win\Y
				EndIf
			Case "WM_SETSIZE"
				If Param1 > "" win\W = Param1
				If Param2 > "" win\H = Param2
			Case "WM_GETSIZE"
				If Param1 > ""
					Return win\W
				Else
					Return win\H
				EndIf
			Case "WM_SETTEXT"
				win\Caption = Param1
			Case "WM_GETTEXT"
				Return win\Caption
			Case "WM_SETLOCKED"
				If Param1 = "" Param1 = True
				win\Locked = Param1
			Case "WM_GETLOCKED"
				Return win\Locked
			Case "WM_SETMODAL"
				If Param1 = "" Param1 = True
				win\AlwaysOnTop = Param1
				If win\Closed = False
					app\topWin = win
					Insert win Before First Window
				EndIf
			Case "WM_GETMODAL"
				Return win\AlwaysOnTop
			Case "WM_SETMODALFAKE"
				If Param1 = "" Param1 = True
				win\AlwaysOnTopFake = Param1
				app\topWin = win
			Case "WM_GETMODALFAKE"
				Return win\AlwaysOnTopFake
			Case "WM_GETMENU"
				Return win\Menu
			Case "WM_SETTITLEBAR"
				If Param1 = "" Param1 = True
				win\TitleBar = Param1
				If win\TitleBar = True
					win\TH = 22
					win\MY = 22
					win\FY = 2 + 22 + win\MH
				Else
					win\TH = 0
					win\MY = 0
					win\FY = 2 + win\MH
				EndIf
			Case "WM_SETMINBUTTON"
				If Param1 = "" Param1 = True
				win\MinBtn = Param1
			Case "WM_SETCLOSEBUTTON"
				If Param1 = "" Param1 = True
				win\CloseBtn = Param1
			Case "WM_SETMENU"
				If Param1 = "" Param1 = True
				win\Menu = Param1
				If win\Menu = True
					win\MH = win\SMH
					win\FY = 2 + win\MH + win\TH
				Else
					win\MH = 0
					win\FY = 2 + win\TH
				EndIf
			Case "WM_GETTITLEBAR"
				Return win\TitleBar
			Case "WM_GETMINBUTTON"
				Return win\MinBtn
			Case "WM_GETCLOSEBUTTON"
				Return win\CloseBtn
		End Select
	EndIf
	tab.Tab = Object.Tab( ID )
	If tab <> Null
		Select Message
			Case "TM_SETHANDLE"
				tab\CHandle = Param1
			Case "TM_GETHANDLE"
				Return tab\CHandle
			Case "TM_SETINDEX"
				Count = 0
				tabp.TabPage = Last TabPage
				While tabp <> Null
					If tabp\Owner = tab
						Count = Count + 1
						If Count = Int(Param1)
							tab\Active = tabp
							Exit
						EndIf
					EndIf
					tabp = Before tabp
				Wend
			Case "TM_GETINDEX"
				Count = 0
				tabp.TabPage = Last TabPage
				While tabp <> Null
					Count = Count + 1
					If tab\Active = tabp
						Return Count
					EndIf
					tabp = Before tabp
				Wend
				Return 0
			Case "TM_SETTEXT"
				If tab\Active <> Null
					tab\Active\Caption = Param1
				EndIf
			Case "TM_GETTEXT"
				If tab\Active <> Null
					Return tab\Active\Caption
				EndIf
			Case "TM_SETPOS"
				If Param1 > "" tab\X = Param1
				If Param2 > "" tab\Y = Param2
			Case "TM_GETPOS"
				If Param1 > "" Return tab\X
				If Param2 > "" Return tab\Y
			Case "TM_SETSIZE"
				If Param1 > "" tab\W = Param1
				If Param2 > "" tab\H = Param2
			Case "TM_GETSIZE"
				If Param1 > "" Return tab\W
				If Param2 > "" Return tab\H
		End Select
	EndIf
	tabp.TabPage = Object.TabPage( ID )
	If tabp <> Null
		Select Message
			Case "TM_SETHANDLE"
				tabp\CHandle = Param1
			Case "TM_GETHANDLE"
				Return tabp\CHandle
			Case "TM_SETTEXT"
				tabp\Caption = Param1
			Case "TM_GETTEXT"
				Return tabp\Caption
			Case "TM_DISABLE"
				tabp\Disabled = True
			Case "TM_ENABLE"
				tabp\Disabled = False
			Case "TM_GETENABLED"
				Return 1 - tabp\Disabled
			Case "TM_SETSIZE"
				If Param1 > "" tabp\W = Param1
				If Param2 > "" tabp\Owner\IH = Param2
			Case "TM_GETSIZE"
				If Param1 > "" Return tabp\W
				If Param2 > "" Return tabp\Owner\IH
			Case "TM_SETIMAGE"
				If FileType( Param1 ) = 1
					If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
						If tabp\Image FreeImage tabp\Image
						tabp\Image = LoadImage( Param1 )
						MidHandle tabp\Image
						If Param2 = True
							MaskImage tabp\Image, 255, 0, 0
						EndIf
						tabp\ImageSource = Param1
					EndIf
				EndIf
			Case "TM_GETIMAGE"
				Return tabp\ImageSource
		End Select
	EndIf
	mnut.MenuTitle = Object.MenuTitle( ID )
	If mnut <> Null
		Select Message
			Case "MM_SETHANDLE"
				mnut\CHandle = Param1
			Case "MM_GETHANDLE"
				Return mnut\CHandle
			Case "MM_SETSIZE"
				If Param1 > "" mnut\W = Param1
				If Param2 > ""
					mnut\Owner\MH = Param2
					mnut\Owner\SMH = mnut\Owner\MH
					mnut\Owner\FY = mnut\Owner\TH + mnut\Owner\MH + 2
				EndIf
			Case "MM_GETSIZE"
				If Param1 > "" Return mnut\W
				If Param2 > "" Return mnut\Owner\MH
			Case "MM_SETTEXT"
				mnut\Caption = Param1
			Case "MM_GETTEXT"
				Return mnut\Caption
			Case "MM_CLOSE"
				mnut\Active = False
			Case "MM_OPEN"
				mnut\Active = True
				app\Event = EVENT_MENU
				app\MenuEvent = mnut\ID
			Case "MM_DISABLE"
				mnut\Disabled = True

			Case "MM_ENABLE"
				mnut\Disabled = False
			Case "MM_GETENABLED"
				Return 1 - mnut\Disabled
			
		End Select
	EndIf
	mnui.MenuItem = Object.MenuItem( ID )
	If mnui <> Null
		Select Message
			Case "MM_SETHANDLE"
				mnui\CHandle = Param1
			Case "MM_GETHANDLE"
				Return mnui\CHandle
			Case "MM_SETTEXT"
				mnui\Caption = Param1
			Case "MM_GETTEXT"
				Return mnui\Caption
			Case "MM_SETSHORTCUT"
				mnui\ShortCut = Param1
			Case "MM_GETSHORTCUT"
				Return mnui\ShortCut
			Case "MM_GETSIZE"
				If Param1 > ""
					If mnui\ParentMenu = Null
						Return mnui\Owner\DW
					Else
						Return mnui\ParentMenu\DW
					EndIf
				EndIf
				If Param2 > "" Return mnui\Owner\IH
			Case "MM_SETSIZE"
				If Param1 > ""
					If mnui\ParentMenu = Null
						mnui\Owner\DW = Param1
					Else
						mnui\ParentMenu\DW = Param1
					EndIf
				EndIf
				If Param2 > ""
					mnui\Owner\IH = Param2
					For mnut.MenuTitle = Each MenuTitle
						If mnut = mnui\Owner
							mnut\DH = 2
							For mnui2.MenuItem = Each MenuItem
								If mnui2\Owner = mnut
									If mnui2\Caption <> "-"
										mnut\DH = mnut\DH + mnut\IH
									Else
										mnut\DH = mnut\DH + mnut\IH / 2
									EndIf
								EndIf
							Next
							Exit
						EndIf
					Next
				EndIf
			Case "MM_SETICON"
				If FileType( Param1 ) = 1
					If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
						If mnui\Icon FreeImage mnui\Icon
						mnui\Icon = LoadImage( Param1 )
						mnui\AllowCheck = False
						mnui\Checked = False
						MidHandle mnui\Icon
						MaskImage mnui\Icon, 255, 0, 0
						mnui\IconSource = Param1
					EndIf
				EndIf
			Case "MM_SETID"
				mnui\GroupID = Param1
				If mnui\GroupID > 0
					mnui\AllowCheck = True
				EndIf
			Case "MM_GETID"
				Return mnui\GroupID
			Case "MM_GETICON"
				Return mnui\IconSource
			Case "MM_UNHIGHLIGHT"
				mnui\State = 0
				mnui\Active = False
			Case "MM_HIGHLIGHT"
			    mnui\State =-1
			    mnui\Active = True
			Case "MM_ENABLECHECK"
				mnui\AllowCheck = Param1
			Case "MM_GETENABLECHECK"
				Return mnui\AllowCheck
			Case "MM_SETCHECKED"
				mnui\Checked = Param1
				If mnui\Checked = True
					If mnui\GroupID > 0
						For mnui2.MenuItem = Each MenuItem
							If mnui2\GroupID = mnui\GroupID And mnui2 <> mnui
								mnui2\Checked = False
							EndIf
						Next
					EndIf
					mnui\AllowCheck = True
				EndIf
			Case "MM_GETCHECKED"
				Return mnui\Checked
			Case "MM_DISABLE"
				mnui\Disabled = True
			Case "MM_ENABLE"
				mnui\Disabled = False
			Case "MM_GETENABLED"
				Return 1 - mnui\Disabled
			
		End Select
	EndIf
	btn.Button = Object.Button( ID )
	If btn <> Null
		Select Message
			Case "BM_SETHANDLE"
				btn\CHandle = Param1
			Case "BM_GETHANDLE"
				Return btn\CHandle
			Case "BM_SETTEXT"
				btn\Lines = CountItems(Param1, Chr(10))
				For A = 0 To btn\Lines - 1
					btn\Caption[A] = Parse(Param1, A, Chr(10))
				Next
			Case "BM_SETMULTILINETEXT"
				btn\Caption[Param1] = Param2
				If Int(Param1) + 1 > btn\Lines
					btn\Lines = Int(Param1) + 1
				EndIf
			Case "BM_GETTEXT"
				If Param1 = "" Param1 = 0
				Return btn\Caption[Param1]
			Case "BM_SETIMAGE"
				If FileType( Param1 ) = 1
					If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
						If btn\Image FreeImage btn\Image
						btn\Image = LoadImage( Param1 )
						If btn\Image
							MidHandle btn\Image
							If Param2 = True
								MaskImage btn\Image, 255, 0, 0
							EndIf
						EndIf
						btn\ImageSource = Param1
					EndIf
				Else
					If Param1
						btn\Image = CopyImage( Param1 )
						If btn\Image
							MidHandle btn\Image
							If Param2 = True
								MaskImage btn\ImageSource, 255, 0, 0
							EndIf
						EndIf
					Else
						If Param1 =""
							If btn\Image FreeImage btn\Image
							btn\Image = 0
							btn\ImageSource = ""
						EndIf
					EndIf
				EndIf
			Case "BM_SETBORDER"
				If Param1 = "" Param1 = True
				btn\Border = Param1
			Case "BM_SETPOPUP"
				If Param1 = "" Param1 = True
				btn\Popup = Param1
			Case "BM_SETID"
				btn\GroupID = Param1
			Case "BM_DESELECT"
				btn\Active = False
				btn\State = 0
				If btn\GroupID > 0
					btn\TState = False
				EndIf
			Case "BM_SELECT", "BM_SETCHECKED"
				If btn\GroupID > 0
					If Message = "BM_SELECT"
						For gad.Button = Each Button
							If gad\GroupID = btn\GroupID And gad <> btn
								gad\TState = False
							EndIf
						Next
						btn\TState = True
					Else
						btn\TState = Param1
						If btn\TState = True
							For gad.Button = Each Button
								If gad\GroupID = btn\GroupID And gad <> btn
									gad\TState = False
								EndIf
							Next
						EndIf
					EndIf
				EndIf
				If Message = "BM_SELECT"
					app\Event = EVENT_GADGET
					app\GadgetEvent = btn\ID
				EndIf
			Case "BM_GETCHECKED"
				If btn\GroupID > 0
					Return btn\TState
				Else
					Return False
				EndIf
			Case "BM_GETSELECTEDINDEX"
				If btn\GroupID > 0
					Count = 0
					btn2.Button = Last Button
					While btn2 <> Null
						If btn2\GroupID = btn\GroupID
							Count = Count + 1
							If btn2\TState = True
								Return Count
							EndIf
						EndIf
						btn2 = Before btn2
					Wend
					Return 0
				Else
					Return 0
				EndIf
			Case "BM_GETSELECTEDCAPTION"
				If btn\GroupID > 0
					For btn2.Button = Each Button
						If btn2\GroupID = btn\GroupID
							If btn2\TState = True
								Return btn2\Caption[0]
							EndIf
						EndIf
					Next
				EndIf
			Case "BM_GETSTATE"
				Return btn\TState
			Case "BM_SETPOS"
				If Param1 > "" btn\X = Param1
				If Param2 > "" btn\Y = Param2
			Case "BM_GETPOS"
				If Param1 > "" Return btn\X
				If Param2 > "" Return btn\Y
			Case "BM_SETSIZE"
				If Param1 > "" btn\W = Param1
				If Param2 > "" btn\H = Param2
			Case "BM_GETSIZE"
				If Param1 > "" Return btn\W
				If Param2 > "" Return btn\H
			Case "BM_DISABLE"
				btn\Disabled = True
			Case "BM_ENABLE"
				btn\Disabled = False
			Case "BM_GETENABLED"
				Return 1 - btn\Disabled
			Case "BM_SETDRAWMODE"
				btn\DrawMode = Param1
			Case "BM_GETDRAWMODE"
				Return btn\DrawMode
			
		End Select
	EndIf
	chk.CheckBox = Object.CheckBox( ID )
	If chk <> Null
		Select Message
			Case "CM_SETHANDLE"
				chk\CHandle = Param1
			Case "CM_GETHANDLE"
				Return chk\CHandle
			Case "CM_SETTEXT"
				chk\Caption = Param1
			Case "CM_GETTEXT"
				Return chk\Caption
			Case "CM_SETCHECKED"
				chk\Checked = Param1
			Case "CM_GETCHECKED"
				Return chk\Checked
			Case "CM_SETPOS"
				If Param1 > "" chk\X = Param1
				If Param2 > "" chk\Y = Param2
			Case "CM_GETPOS"
				If Param1 > "" Return chk\X
				If Param2 > "" Return chk\Y
			Case "CM_DISABLE"
				chk\Disabled = True
			Case "CM_ENABLE"
				chk\Disabled = False
			Case "CM_GETENABLED"
				Return 1 - chk\Disabled
			
		End Select
	EndIf
	cbo.ComboBox = Object.ComboBox( ID )
	If cbo <> Null
		Select Message
			Case "CM_SETHANDLE"
				cbo\CHandle = Param1
			Case "CM_GETHANDLE"
				Return cbo\CHandle
			Case "CM_CLOSE"
				cbo\Active = False
			Case "CM_OPEN"
				cbo\Active = True
			Case "CM_GETCOUNT"
				Return cbo\Count
			Case "CM_SETINDEX"
				cbo\Index = Param1
			Case "CM_GETINDEX"
				Return cbo\Index
			Case "CM_SETCAPTION", "CM_SETTEXT"
				For A = 0 To 32
					If cbo\Item[A] = Param1
						cbo\Index = A
					EndIf
				Next
			Case "CM_GETCAPTION", "CM_GETTEXT"
				Return cbo\Item[cbo\Index]
			Case "CM_GETICON"
				If cbo\Index > 0
					Return cbo\Icon[cbo\Index]
				Else
					Return 0
				EndIf
			Case "CM_RESET"
				cbo\Count = 0
				cbo\DH = 2
				For A = 0 To 32
					cbo\Item[A] = ""
				Next
				cbo\Index = 0
			Case "CM_SETPOS"
				If Param1 > "" cbo\X = Param1
				If Param2 > "" cbo\Y = Param2
			Case "CM_GETPOS"
				If Param1 > "" Return cbo\X
				If Param2 > "" Return cbo\Y
			Case "CM_SETSIZE"
				If Param1 > "" cbo\W = Param1
				If Param2 > "" cbo\H = Param2
			Case "CM_GETSIZE"
				If Param1 > "" Return cbo\W
				If Param2 > "" Return cbo\H
			Case "CM_DISABLE"
				cbo\Disabled = True
			Case "CM_ENABLE"
				cbo\Disabled = False
			Case "CM_GETENABLED"
				Return 1 - cbo\Disabled
		End Select
	EndIf
	grp.GroupBox = Object.GroupBox( ID )
	If grp <> Null
		Select Message
			Case "GM_SETHANDLE"
				grp\CHandle = Param1
			Case "GM_GETHANDLE"
				Return grp\CHandle
			Case "GM_SETTEXT"
				grp\Caption = Param1
			Case "GM_GETTEXT"
				Return grp\Caption
			Case "GM_SETPOS"
				If Param1 > "" grp\X = Param1
				If Param2 > "" grp\Y = Param2
			Case "GM_GETPOS"
				If Param1 > "" Return grp\X
				If Param2 > "" Return grp\Y
			Case "GM_SETSIZE"
				If Param1 > "" grp\W = Param1
				If Param2 > "" grp\H = Param2
			Case "GM_GETSIZE"
				If Param1 > "" Return grp\W
				If Param2 > "" Return grp\H
			
		End Select
	EndIf
	img.Image = Object.Image( ID )
	If img <> Null
		For img.Image = Each Image
			If img\ID = ID
				Exit
			EndIf
		Next
		
		Select Message
			Case "IM_SETHANDLE"
				img\CHandle = Param1
			Case "IM_GETHANDLE"
				Return img\CHandle
			Case "IM_SETPOS"
				If Param1 > "" img\X = Param1
				If Param2 > "" img\Y = Param2
			Case "IM_GETPOS"
				If Param1 > "" Return img\X
				If Param2 > "" Return img\Y
			Case "IM_SETSIZE"
				If Param1 > "" img\W = Param1
				If Param2 > "" img\H = Param2
			Case "IM_GETSIZE"
				If Param1 > "" Return img\W
				If Param2 > "" Return img\H
			Case "IM_SETIMAGE"
				If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
					If img\Image FreeImage img\Image
					img\Image = LoadImage( Param1 )
					img\ImageSource = Param1
					If img\Image
						If Param2 = True
							MaskImage img\Image, 255, 0, 0
						EndIf
						img\W = ImageWidth( img\Image )
						img\H = ImageHeight( img\Image )
					EndIf
				Else
					If Param1
						img\Image = CopyImage( Param1 )
					Else
						If img\Image FreeImage img\Image
						img\Image = 0
						img\ImageSource = ""
					EndIf
				EndIf
			Case "IM_GETIMAGE"
				Return img\ImageSource
			Case "IM_SETMASK"
				img\Mask = Param1
			Case "IM_SETDRAWMODE"
				img\DrawMode = Param1
			Case "IM_GETDRAWMODE"
				Return img\DrawMode
				
		End Select
	EndIf
	imgbox.ImageBox = Object.ImageBox( ID )
	If imgbox <> Null
		Select Message
			Case "IM_SETHANDLE"
				imgbox\CHandle = Param1
			Case "IM_GETHANDLE"
				Return imgbox\CHandle
			Case "IM_SETPOS"
				If Param1 > "" imgbox\X = Param1
				If Param2 > "" imgbox\Y = Param2
			Case "IM_GETPOS"
				If Param1 > "" Return imgbox\X
				If Param2 > "" Return imgbox\Y
			Case "IM_SETSIZE"
				If Param1 > "" imgbox\W = Param1
				If Param2 > "" imgbox\H = Param2
				If imgbox\Image
					If imgbox\ImageSource > ""
						If imgbox\Image FreeImage imgbox\Image
						imgbox\Image = LoadImage( imgbox\ImageSource )
					EndIf
					ResizeImage imgbox\Image, imgbox\W, imgbox\H
				EndIf
			Case "IM_GETSIZE"
				If Param1 > "" Return imgbox\W
				If Param2 > "" Return imgbox\H
			Case "IM_SETIMAGE"
				If Right( Lower( Param1 ), 4 ) = ".bmp" Or Right( Lower( Param1 ), 4 ) = ".jpg"
					If imgbox\Image FreeImage imgbox\Image
					imgbox\Image = LoadImage( Param1 )
					imgbox\ImageSource = Param1
					If imgbox\Image
						If Param2 = True
							MaskImage imgbox\Image, 255, 0, 0
						EndIf
						imgbox\W = ImageWidth( imgbox\Image )
						imgbox\H = ImageHeight( imgbox\Image )
					EndIf
				Else
					If Param1
						imgbox\Image = CopyImage( Param1 )
					Else
						If imgbox\Image FreeImage imgbox\Image
						imgbox\Image = 0
					EndIf
				EndIf
			Case "IM_GETIMAGE"
				Return imgbox\ImageSource
			Case "IM_SETBORDER"
				imgbox\Border = Param1
			Case "IM_GETBORDER"
				Return imgbox\Border
			Case "IM_SETDRAWMODE"
				imgbox\DrawMode = Param1
			Case "IM_GETDRAWMODE"
				Return imgbox\DrawMode
				
		End Select
	EndIf
	lbl.Label = Object.Label( ID )
	If lbl <> Null
		Select Message
			Case "LM_SETHANDLE"
				lbl\CHandle = Param1
			Case "LM_GETHANDLE"
				Return lbl\CHandle
			Case "LM_SETTEXT"
				lbl\Lines = CountItems( Param1, Chr(10) )
				For A = 0 To lbl\Lines - 1
					lbl\Caption[A] = Parse(Param1, A, Chr(10) )
				Next
			Case "LM_GETTEXT"
				If Param1 = "" Param1 = 0
				Return lbl\Caption[Param1]
			Case "LM_SETPOS"
				If Param1 > "" lbl\X = Param1
				If Param2 > "" lbl\Y = Param2	
			Case "LM_GETPOS"
				If Param1 > "" Return lbl\X
				If Param2 > "" Return lbl\Y
			Case "LM_GETCOUNT"
				Return lbl\Lines
			Case "LM_SETALIGN"
				lbl\Align = Param1
			Case "LM_GETALIGN"
				Return lbl\Align
				
		End Select
	EndIf
	lst.ListBox = Object.ListBox( ID )
	If lst <> Null
		Select Message
			Case "LM_SETHANDLE"
				lst\CHandle = Param1
			Case "LM_GETHANDLE"
				Return lst\CHandle
			Case "LM_SETINDEX"
				lst\ActiveIndex = Param1
			Case "LM_GETINDEX"
				Return lst\ActiveIndex
			Case "LM_GETCAPTION", "LM_GETTEXT"
				If Param1 = ""
					If lst\ActiveIndex > 0
						Return lst\Item[lst\ActiveIndex-1]
					Else
						Return ""
					EndIf
				Else
					If Param1 > 0
						Return lst\Item[Int(Param1)-1]
					EndIf
				EndIf
			Case "LM_SETCAPTION", "LM_SETTEXT"
				lst\Item[Param1] = Param2
				If Param1 > lst\Count
					lst\Count = Param1
				EndIf
			Case "LM_GETICON"
				If Param1 = ""
					If lst\ActiveIndex > 0
						Return lst\IconSource[lst\ActiveIndex-1]
					Else
						Return 0
					EndIf
				Else
					If Param1 > 0
						Return lst\IconSource[Int(Param1)-1]
					EndIf
				EndIf
			Case "LM_SETSCROLL"
				lst\RH = (lst\Count * lst\IH) - (lst\H - 2)
				lst\ScrollY = Interpolate( Param1, 0, 100, 0, lst\RH )
				If lst\ScrollY < 0 lst\ScrollY = 0
				If lst\ScrollY > lst\RH lst\ScrollY = lst\RH
			Case "LM_RESET"
				lst\ActiveIndex = 0
				For A = 0 To lst\Count
					lst\Item[A] = ""
					If lst\Icon[A] FreeImage lst\Icon[A]
					lst\Icon[A] = 0
				Next
				lst\Count = 0
				lst\ScrollY = 0
			Case "LM_SETPOS"
				If Param1 > "" lst\X = Param1
				If Param2 > "" lst\Y = Param2
			Case "LM_GETPOS"
				If Param1 > "" Return lst\X
				If Param2 > "" Return lst\Y
			Case "LM_SETSIZE"
				If Param1 > "" lst\W = Param1
				If Param2 > "" lst\H = Param2
			Case "LM_GETSIZE"
				If Param1 > "" Return lst\W
				If Param2 > "" Return lst\H
			Case "LM_GETCOUNT"
				Return lst\Count
			Case "LM_DISABLE"
				lst\Disabled = True
			Case "LM_ENABLE"
				lst\Disabled = False
			Case "LM_GETENABLED"
				Return 1 - lst\Disabled
			Case "LM_GETITEMCAPTION"
				Return lst\Item[Int(Param1)-1]
			Case "LM_DELETEITEM"
				If Param1 <= lst\Count And Param1 > 0
					lst\Item[Int(Param1)-1] = ""
					If Param2 = True
						If Param1 < lst\Count
							For A = Param1 To lst\Count
								lst\Item[A-1] = lst\Item[A]
								lst\Item[A] = ""
							Next
						EndIf
					EndIf
					lst\Count = lst\Count - 1
				EndIf
			
		End Select
	EndIf
	prg.ProgressBar = Object.ProgressBar( ID )
	If prg <> Null
		Select Message
			Case "PM_SETHANDLE"
				prg\CHandle = Param1
			Case "PM_GETHANDLE"
				Return prg\CHandle
			Case "PM_SETVALUE", "PM_SETTEXT"
				prg\Percent = Param1
			Case "PM_GETVALUE", "PM_GETTEXT"
				Return prg\Percent
			Case "PM_SETPOS"
				If Param1 > "" prg\X = Param1
				If Param2 > "" prg\Y = Param2
			Case "PM_GETPOS"
				If Param1 > "" Return prg\X
				If Param2 > "" Return prg\Y
			Case "PM_SETSIZE"
				If Param1 > "" prg\W = Param1
				If Param2 > "" prg\H = Param2
			Case "PM_GETSIZE"
				If Param1 > "" Return prg\W
				If Param2 > "" Return prg\H
			
		End Select
	EndIf
	rad.Radio = Object.Radio( ID )
	If rad <> Null
		Select Message
			Case "RM_GETINDEX"
				gad2.Radio = Last Radio
				Count = 1
				While gad2 <> Null
					If gad2\GroupID = rad\GroupID
						If gad2\Checked = True
							Return Count
						Else
							Count = Count + 1
						EndIf
					EndIf
					gad2 = Before gad2
				Wend
				Return 0
			Case "RM_SETINDEX"
				gad2.Radio = Last Radio
				Count = 1
				While gad2 <> Null
					If gad2\GroupID = rad\GroupID
						If Param1 = Count
							gad2\Checked = True
						Else
							gad2\Checked = False
						EndIf
						Count = Count + 1
					EndIf
					gad2 = Before gad2
				Wend
			Case "RM_SETHANDLE"
				rad\CHandle = Param1
			Case "RM_GETHANDLE"
				Return rad\CHandle
			Case "RM_SETTEXT"
				rad\Caption = Param1
			Case "RM_GETTEXT"
				Return rad\Caption
			Case "RM_SETCHECKED"
				If Param1 = True
					For gad2.Radio = Each Radio
						If gad2\GroupID = rad\GroupID And gad2 <> rad
							gad2\Checked = False
						EndIf
					Next
					rad\Checked = True
				Else
					rad\Checked = False
				EndIf
			Case "RM_GETCHECKED"
				Return rad\Checked
			Case "RM_GETID"
				Return rad\GroupID
			Case "RM_SETID"
				rad\GroupID = Param1
			Case "RM_SETPOS"
				If Param1 > "" rad\X = Param1
				If Param2 > "" rad\Y = Param2
			Case "RM_GETPOS"
				If Param1 > "" Return rad\X
				If Param2 > "" Return rad\Y
			Case "RM_DISABLE"
				rad\Disabled = True
			Case "RM_ENABLE"
				rad\Disabled = False
			Case "RM_GETENABLED"
				Return 1 - rad\Disabled
			
		End Select
	EndIf
	scroll.ScrollBar = Object.ScrollBar( ID )
	If scroll <> Null
		Select Message
			Case "SM_SETHANDLE"
				scroll\CHandle = Param1
			Case "SM_GETHANDLE"
				Return scroll\CHandle
			Case "SM_SETVALUE"
				scroll\Value = Param1
				If scroll\Mode = 0
					scroll\Value = Int(scroll\Value)
				EndIf
				If scroll\Value < scroll\Min scroll\Value = scroll\Min
				If scroll\Value > scroll\Max scroll\Value = scroll\Max
				If scroll\Dir = 0
					scroll\SX = Interpolate(scroll\Value, scroll\Min, scroll\Max, scroll\H-1, scroll\W-1-scroll\H-scroll\SW)
				Else
					scroll\SY = Interpolate(scroll\Value, scroll\Min, scroll\Max, scroll\H-1, scroll\W-1-scroll\H-scroll\SW)
				EndIf
			Case "SM_GETVALUE"
				Return scroll\Value
			Case "SM_SETSCROLLWIDTH"
				scroll\SW = Param1
			Case "SM_GETSCROLLWIDTH"
				Return scroll\SW
			Case "SM_SETMODE"
				scroll\Mode = Param1
			Case "SM_GETMODE"
				Return scroll\Mode
			Case "SM_SETDIR"
				scroll\Dir = Param1
				If scroll\Dir = 0
					scroll\SY = 0
					scroll\SX = Interpolate(scroll\Value, scroll\Min, scroll\Max, scroll\H-1, scroll\W-1-scroll\H-scroll\SW)
				Else
					scroll\SX = 0
					scroll\SY = Interpolate(scroll\Value, scroll\Min, scroll\Max, scroll\H-1, scroll\W-1-scroll\H-scroll\SW)
				EndIf
			Case "SM_GETDIR"
				Return scroll\Dir
			Case "SM_SETLIMIT"
				If Param1 > "" scroll\Min = Param1
				If Param2 > "" scroll\Max = Param2
			Case "SM_GETLIMIT"
				If Param1 > "" Return scroll\Min
				If Param2 > "" Return scroll\Max
			Case "SM_SETPOS"
				If Param1 > "" scroll\X = Param1
				If Param2 > "" scroll\Y = Param2
			Case "SM_GETPOS"
				If Param1 > "" Return scroll\X
				If Param2 > "" Return scroll\Y
			Case "SM_SETSIZE"
				If Param1 > "" scroll\W = Param1
				If Param2 > "" scroll\H = Param2
			Case "SM_GETSIZE"
				If Param1 > "" Return scroll\W
				If Param2 > "" Return scroll\H
			Case "SM_DISABLE"
				scroll\Disabled = True
			Case "SM_ENABLE"
				scroll\Disabled = False
			Case "SM_GETENABLED"
				Return 1 - scroll\Disabled
				
		End Select
	EndIf
	sld.Slider = Object.Slider( ID )
	If sld <> Null
		Select Message
			Case "SM_SETHANDLE"
				sld\CHandle = Param1
			Case "SM_GETHANDLE"
				Return sld\CHandle
			Case "SM_SETDIR"
				sld\Dir = Param1
				If sld\Dir = 0
					sld\SY = 0
					sld\SX = Interpolate(sld\Value, sld\Min, sld\Max, 0, sld\W-sld\H)
				Else
					sld\SX = 0
					sld\SY = Interpolate(sld\Value, sld\Min, sld\Max, 0, sld\W-sld\H)
				EndIf
			Case "SM_GETDIR"
				Return sld\Dir
			Case "SM_SETMODE"
				sld\Mode = Param1
			Case "SM_GETMODE"
				Return sld\Mode
			Case "SM_SETLIMIT"
				If Param1 > "" sld\Min = Param1
				If Param2 > "" sld\Max = Param2
			Case "SM_GETLIMIT"
				If Param1 > "" Return sld\Min
				If Param2 > "" Return sld\Max
			Case "SM_GETSTARTRGB"
				Return sld\SR + "," + sld\SG + "," + sld\SB
			Case "SM_GETENDRGB"
				Return sld\ER + "," + sld\EG + "," + sld\EB
			Case "SM_SETSTARTRGB"
				sld\SR = Trim(Parse(Param1, 0, ","))
				sld\SG = Trim(Parse(Param1, 1, ","))
				sld\SB = Trim(Parse(Param1, 2, ","))
			Case "SM_SETENDRGB"
				sld\ER = Trim(Parse(Param1, 0, ","))
				sld\EG = Trim(Parse(Param1, 1, ","))
				sld\EB = Trim(Parse(Param1, 2, ","))
			Case "SM_SETVALUE"
				sld\Value = Param1
				If sld\Mode = 0
					sld\Value = Int(sld\Value)
				EndIf
				If sld\Value < sld\Min sld\Value = sld\Min
				If sld\Value > sld\Max sld\Value = sld\Max
				If sld\Dir = 0
					sld\SX = Interpolate(sld\Value, sld\Min, sld\Max, 0, sld\W-sld\H)
				Else
					sld\SY = Interpolate(sld\Value, sld\Min, sld\Max, 0, sld\W-sld\H)
				EndIf
			Case "SM_GETVALUE"
				Return sld\Value
			Case "SM_SETPOS"
				If Param1 > "" sld\X = Param1
				If Param2 > "" sld\Y = Param2
			Case "SM_GETPOS"
				If Param1 > "" Return sld\X
				If Param2 > "" Return sld\Y
			Case "SM_SETSIZE"
				If Param1 > "" sld\W = Param1
				If Param2 > "" sld\H = Param2
			Case "SM_GETSIZE"
				If Param1 > "" Return sld\W
				If Param2 > "" Return sld\H
			Case "SM_DISABLE"
				sld\Disabled = True
			Case "SM_ENABLE"
				sld\Disabled = False
			Case "SM_GETENABLED"
				Return 1 - sld\Disabled
			
		End Select
	EndIf
	spn.Spinner = Object.Spinner( ID )
	If spn <> Null
		Select Message
			Case "SM_SETHANDLE"
				spn\CHandle = Param1
			Case "SM_GETHANDLE"
				Return spn\CHandle
			Case "SM_SETVALUE", "SM_SETTEXT"
				spn\Value = Param1
				If spn\Value < spn\Min spn\Value = spn\Min
				If spn\Value > spn\Max spn\Value = spn\Max
			Case "SM_GETVALUE", "SM_GETTEXT"
				If spn\Mode = 0
					Return Int(spn\Value)
				Else
					Return spn\Value
				EndIf
			Case "SM_GETLIMIT"
				If Param1 > "" Return spn\Min
				If Param2 > "" Return spn\Max
			Case "SM_SETLIMIT"
				If Param1 > "" spn\Min = Param1
				If Param2 > "" spn\Max = Param2
			Case "SM_SETINC"
				spn\Inc = Param1
			Case "SM_GETINC"
				Return spn\Inc
			Case "SM_SETMODE"
				spn\Mode = Param1
			Case "SM_GETMODE"
				Return spn\Mode
			Case "SM_GETBUTTONS"
				Return spn\ButtonsOnly
			Case "SM_SETBUTTONS"
				spn\ButtonsOnly = Param1
			Case "SM_SETPOS"
				If Param1 > "" spn\X = Param1
				If Param2 > "" spn\Y = Param2
			Case "SM_GETPOS"
				If Param1 > "" Return spn\X
				If Param2 > "" Return spn\Y
			Case "SM_SETSIZE"
				If Param1 > "" spn\W = Param1
				If Param2 > "" spn\H = Param2
			Case "SM_GETSIZE"
				If Param1 > "" Return spn\W
				If Param2 > "" Return spn\H
			Case "SM_DISABLE"
				spn\Disabled = True
			Case "SM_ENABLE"
				spn\Disabled = False
			Case "SM_GETENABLED"
				Return 1 - spn\Disabled
			
		End Select
	EndIf
	txt.TextBox = Object.TextBox( ID )
	If txt <> Null
		Select Message
			Case "TM_SETHANDLE"
				txt\CHandle = Param1
			Case "TM_GETHANDLE"
				Return txt\CHandle
			Case "TM_SETINC"
				txt\Inc = Param1
			Case "TM_GETINC"
				Return txt\Inc
			Case "TM_SETSDELAY"
				txt\SDelay = Param1
			Case "TM_GETSDELAY"
				Return txt\SDelay
			Case "TM_SETMULTI"
				txt\MultiLine = Param1
			Case "TM_GETMULTI"
				Return txt\MultiLine
			Case "TM_SETMODE"
				txt\Mode = Param1
			Case "TM_GETMODE"
				Return txt\Mode
			Case "TM_SETTEXT"
				If Param1 >= 0
					txt\Caption[Param1] = Param2
					If Int(Param1)+1 > txt\LineCount
						txt\LineCount = Int(Param1)+1
					EndIf
				Else
					For A = 0 To txt\LineCount
						txt\Caption[A] = ""
					Next
					txt\LineCount = 1
					txt\LineStart = 0
					txt\LineEnd = 0
					txt\SelStart = 0
					txt\SelEnd = 0
					txt\ScrollY = 0
				EndIf
			Case "TM_GETTEXT"
				If Param1 = "" Param1 = 0
				Return txt\Caption[Param1]
			Case "TM_GETCOUNT"
				Return txt\LineCount
			Case "TM_SELECTALL"
				txt\LineStart = 0
				txt\LineEnd = txt\LineCount - 1
				txt\SelStart = 0
				txt\SelEnd = Len(txt\Caption[txt\LineCount-1])
			Case "TM_SETPOS"
				If Param1 > "" txt\X = Param1
				If Param2 > "" txt\Y = Param2
			Case "TM_GETPOS"
				If Param1 > "" Return txt\X
				If Param2 > "" Return txt\Y
			Case "TM_SETSIZE"
				If Param1 > "" txt\W = Param1
				If Param2 > "" txt\H = Param2
			Case "TM_GETSIZE"
				If Param1 > "" Return txt\W
				If Param2 > "" Return txt\H
			Case "TM_SETFOCUS"
				If Param1 = "" Param1 = True
				txt\Active = Param1
			Case "TM_DISABLE"
				txt\Disabled = True
			Case "TM_ENABLE"
				txt\Disabled = False
			Case "TM_GETENABLED"
				Return 1 - txt\Disabled
			
		End Select
	EndIf
	tree.TreeView = Object.TreeView( ID )
	If tree <> Null
		Select Message
			Case "TM_SETHANDLE"
				tree\CHandle = Param1
			Case "TM_GETHANDLE"
				Return tree\CHandle
			Case "TM_GETCAPTION", "TM_GETTEXT"
				Return tree\Caption
			Case "TM_GETPARENTCAPTION"
				Return tree\ParentCaption
			Case "TM_SETPOS"
				If Param1 > "" tree\X = Param1
				If Param2 > "" tree\Y = Param2
			Case "TM_GETPOS"
				If Param1 > "" Return tree\X
				If Param2 > "" Return tree\Y
			Case "TM_SETSIZE"
				If Param1 > "" tree\W = Param1
				If Param2 > "" tree\H = Param2
			Case "TM_GETSIZE"
				If Param1 > "" Return tree\W
				If Param2 > "" Return tree\H
			Case "TM_DISABLE"
				tree\Disabled = True
				For node.Node = Each Node
					If node\Owner = tree
						node\Disabled = True
					EndIf
				Next
			Case "TM_ENABLE"
				tree\Disabled = False
				For node.Node = Each Node
					If node\Owner = tree
						node\Disabled = False
					EndIf
				Next
			Case "TM_GETENABLED"
				Return 1 - tree\Disabled
					
		End Select
	EndIf
	node.Node = Object.Node( ID )
	If node <> Null
		Select Message
			Case "NM_SETHANDLE"
				node\CHandle = Param1
			Case "NM_GETHANDLE"
				Return node\CHandle
			Case "NM_SETTEXT"
				node\Caption = Param1
			Case "NM_GETTEXT"
				Return node\Caption
			Case "NM_DISABLE"
				node\Disabled = True
			Case "NM_ENABLE"
				node\Disabled = False
			Case "NM_GETENABLED"
				Return 1 - node\Disabled
		
		End Select
	EndIf

End Function

Function Window( X = 0, Y = 0, W = 100, H = 100, Caption$ = "Window", Icon$ = 0, TitleBar = True, Menu = False, MinBtn = True, CloseBtn = True )

	gad.Window = New Window
	
	gad\ID = Handle( gad )
	
	If X <-1 X = app\W / Abs(X)
	If Y <-1 Y = app\H / Abs(Y)
	If W < 0 W = app\W / Abs(W)
	If H < 0 H = app\H / Abs(H)
	
	If X =-1 X = app\W / 2 - W / 2
	If Y =-1 Y = app\H / 2 - H / 2
	
	gad\X = X
	gad\Y = Y		
	gad\W = W
	gad\H = H
	
	gad\Caption = Caption

	gad\MY = 0
	gad\FX = 2
	gad\FY = 2
	
	gad\TitleBar = TitleBar
	gad\Menu = Menu
	
	gad\MinBtn = MinBtn
	gad\CloseBtn = CloseBtn
	
	gad\Minimised = False
	gad\Closed = False
	
	gad\SMH = 20
	If gad\TitleBar = True
		gad\TH = 22
		gad\MY = gad\MY + gad\TH
		gad\FY = gad\FY + gad\TH
	EndIf
	If gad\Menu = True
		gad\MH = gad\SMH
		gad\FY = gad\FY + gad\MH
	EndIf
	
	If Right(Lower(Icon), 4) = ".bmp" Or Right(Lower(Icon), 4) = ".jpg"
		gad\IconSource = Icon
		gad\Icon = LoadImage( Icon )
		If gad\Icon
			If ImageWidth(gad\Icon) > gad\TH-2
				ResizeImage gad\Icon, gad\TH-2, ImageHeight(gad\Icon)
			EndIf
			If ImageHeight(gad\Icon) > gad\TH-2
				ResizeImage gad\Icon, ImageWidth(gad\Icon), gad\TH-2
			EndIf
			MidHandle gad\Icon
			MaskImage gad\Icon, 255, 0, 0
		EndIf
	Else
		If Icon
			gad\Icon = CopyImage( Icon )
			If ImageWidth(gad\Icon) > gad\TH-2
				ResizeImage gad\Icon, gad\TH-2, ImageHeight(gad\Icon)
			EndIf
			If ImageHeight(gad\Icon) > gad\TH-2
				ResizeImage gad\Icon, ImageWidth(gad\Icon), gad\TH-2
			EndIf
			MidHandle gad\Icon
		EndIf
	EndIf
	
	gad\DX = gad\FX + 2
	gad\DY = gad\FY + 2
	
	app\actOwner = "window"
	
	If app\topWin <> Null
		If app\topWin\AlwaysOnTop = False
			Insert gad Before First Window
		Else
			If app\topWin\Closed = False
				Insert gad After First Window
			Else
				Insert gad Before First Window
			EndIf
		EndIf
	Else
		Insert gad Before First Window
	EndIf
	Return Handle( gad )
	
End Function

Function Tab( X = 0, Y = 0, W = 50, H = 50 )

	gad.Tab = New Tab
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	gad\IH = 20
	gad\Visible = True
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	Insert gad Before First Tab
	Return Handle( gad )

End Function

Function TabPage( Caption$ = "Tab Page", Image$ = 0 )

	gad.TabPage = New TabPage
	
	gad\ID = Handle( gad )
	
	gad\Caption = Caption
	If Right( Lower(Image), 4 ) = ".bmp" Or Right( Lower(Image), 4 ) = ".jpg"
		gad\Image = LoadImage( Image )
		If gad\Image
			MidHandle gad\Image
			MaskImage gad\Image, 255, 0, 0
		EndIf
		gad\ImageSource = Image
	Else
		If Image
			gad\Image = CopyImage( Image )
			If gad\Image
				MidHandle gad\Image
			EndIf
		EndIf
	EndIf
	gad\Owner = First Tab
	
	SetFont app\fntTab
	If gad\Caption > ""
		gad\W = StringWidth(gad\Caption)+10
	Else
		If gad\Image
			gad\W = ImageWidth(gad\Image)+10
		EndIf
	EndIf
	gad\Visible = True
	gad\Owner\Active = gad
	
	app\actOwner = "tab"
	
	Insert gad Before First TabPage
	Return Handle( gad )

End Function

Function CloseTab()

	app\actOwner = "window"

End Function

Function MenuTitle( Caption$ = "Menu Title" )

	gad.MenuTitle = New MenuTitle
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	gad\Caption = Caption
	
	gad\DW = 50
	gad\DH = 2
	
	gad\IH = 20
	gad\SBW = 20
	gad\Visible = True
	
	SetFont app\fntMenu
	gad\W = StringWidth(gad\Caption) + 10
	
	Insert gad Before First MenuTitle
	Return Handle( gad )

End Function

Function MenuItem( Owner = 0, Caption$ = "Menu Item", Shortcut$ = "", Icon$ = 0, AllowCheck = False, Checked = False, GroupID = 0 )

	If Owner = 0
		mnut.MenuTitle = First MenuTitle
		If mnut <> Null
			Owner = mnut\ID
		EndIf
	EndIf
	
	GadType$ = ParseID( Owner )
	Select GadType$
		Case "mnut"
			gad.MenuItem = New MenuItem
			For mnut.MenuTitle = Each MenuTitle
				If mnut\ID = Owner
					gad\Owner = mnut
					Exit
				EndIf
			Next
		Case "mnui"
			gad.MenuItem = New MenuItem
			For mnui.MenuItem = Each MenuItem
				If mnui\ID = Owner
					gad\Owner = mnui\Owner
					gad\ParentMenu = mnui
					gad\ParentMenu\SubMenu = True
					Exit
				EndIf
			Next
		Default
			Return 0
	End Select
	
	gad\ID = Handle( gad )
	gad\Caption = Caption
	gad\ShortCut = ShortCut
	gad\GroupID = GroupID
	gad\Visible = True
	
	If gad\GroupID > 0
		For mnui.MenuItem = Each MenuItem
			If mnui\GroupID = gad\GroupID
				mnui\Checked = False
			EndIf
		Next
	EndIf
	gad\Checked = Checked
	
	Icon = Lower( Icon )
	If Right( Icon, 4 ) = ".bmp" Or Right( Icon, 4 ) = ".jpg"
		gad\IconSource = Icon
		gad\Icon = LoadImage( Icon )
		If gad\Icon
			MaskImage gad\Icon, 255, 0, 0
			If ImageWidth(gad\Icon) > gad\Owner\SBW-2
				ResizeImage gad\Icon, gad\Owner\SBW-2, ImageHeight(gad\Icon)
			EndIf
			If ImageHeight(gad\Icon) > gad\Owner\SBW-2
				ResizeImage gad\Icon, ImageWidth(gad\Icon), gad\Owner\SBW-2
			EndIf
			MidHandle gad\Icon
		EndIf
	Else
		If Icon		
			gad\Icon = CopyImage( Icon )
			If ImageWidth(gad\Icon) > gad\Owner\SBW-2
				ResizeImage gad\Icon, gad\Owner\SBW-2, ImageHeight(gad\Icon)
			EndIf
			If ImageHeight(gad\Icon) > gad\Owner\SBW-2
				ResizeImage gad\Icon, ImageWidth(gad\Icon), gad\Owner\SBW-2
			EndIf
			MidHandle gad\Icon
		EndIf
	EndIf
	gad\AllowCheck = AllowCheck
	
	If gad\Caption <> "-"
		gad\DW = 50
		gad\DH = 2

        SetFont app\fntMenu
		If gad\ParentMenu = Null
			gad\Owner\DH = gad\Owner\DH + gad\Owner\IH
			If gad\ShortCut = ""
				If StringWidth(gad\Caption)+gad\Owner\SBW+2+15 > gad\Owner\DW
					gad\Owner\DW = StringWidth(gad\Caption)+gad\Owner\SBW+2+15
				EndIf
			Else
				If StringWidth(gad\Caption)+gad\Owner\SBW+2+15+StringWidth(gad\ShortCut)+10 > gad\Owner\DW
					gad\Owner\DW = StringWidth(gad\Caption)+gad\Owner\SBW+2+15+StringWidth(gad\ShortCut)+10
				EndIf
			EndIf
		Else
			gad\ParentMenu\DH = gad\ParentMenu\DH + gad\Owner\IH
			If gad\ShortCut = ""
				If StringWidth(gad\Caption)+gad\Owner\SBW+2+15 > gad\ParentMenu\DW
					gad\ParentMenu\DW = StringWidth(gad\Caption)+gad\Owner\SBW+2+15
				EndIf
			Else
				If StringWidth(gad\Caption)+gad\Owner\SBW+2+15+StringWidth(gad\ShortCut)+10 > gad\ParentMenu\DW
					gad\ParentMenu\DW = StringWidth(gad\Caption)+gad\Owner\SBW+2+15+StringWidth(gad\ShortCut)+10
				EndIf
			EndIf
		EndIf
	Else
		If gad\ParentMenu = Null
			gad\Owner\DH = gad\Owner\DH + gad\Owner\IH/2
		Else
			gad\Owner\DH = gad\Owner\DH + gad\Owner\IH/2
		EndIf
	EndIf
	
	Insert gad Before First MenuItem
	Return Handle( gad )

End Function

Function MenuBar( Owner = 0 )


	MenuItem( Owner, "-" )

End Function

Function Button( X = 0, Y = 0, W = 80, H = 25, Caption$ = "Button", Image$ = 0, Border = True, Popup = False, GroupID = 0 )

	gad.Button = New Button
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	gad\Visible = True
	
	gad\Lines = CountItems(Caption$, Chr(10))
	For A = 0 To gad\Lines
		gad\Caption[A] = Parse(Caption, A, Chr(10))
	Next
	
	If Right(Lower(Image), 4) = ".bmp" Or Right(Lower(Image), 4) = ".jpg"
		gad\ImageSource = Image
		gad\Image = LoadImage( Image )
		If gad\Image
			MaskImage gad\Image, 255, 0, 0
			MidHandle gad\Image
			
			FreeImage Image
		EndIf
	Else
		If Image
			gad\Image = CopyImage( Image )
			If gad\Image MidHandle gad\Image
		EndIf
	EndIf
	
	gad\GroupID = GroupID
	
	gad\Border = Border
	gad\Popup = Popup
	
	Insert gad Before First Button
	Return Handle( gad )

End Function

Function CheckBox( X = 0, Y = 0, Caption$ = "Button", Checked = False )

	gad.CheckBox = New CheckBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\Caption = Caption
	gad\Checked = Checked
	gad\Visible = True
	
	Insert gad Before First CheckBox
	Return Handle( gad )

End Function

Function ComboBox( X = 0, Y = 0, W = 0, H = 20, ItemHeight = 16, MaxItems = 0, Inc =-1, SDelay = 10, GadgetStrip = True )

	gad.ComboBox = New ComboBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	gad\DH = 2
	gad\IH = ItemHeight
	If Inc =-1 Inc = gad\IH
	If Inc <-1 Inc = Abs( Inc )
	gad\Inc = Inc
	gad\SDelay = 10
	gad\MaxItems = MaxItems
	
	If GadgetStrip = False
		gad\SW = 0
	Else
		gad\SW = 20
	EndIf
	gad\ScrollW = gad\H - 2
	gad\Visible = True
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	Insert gad Before First ComboBox
	Return Handle( gad )

End Function

Function AddComboBoxItem( ID = 0, Index = 0, Caption$ = "", Icon$ = 0 )

	If ID = 0
		gad.ComboBox = First ComboBox
	Else
		For gad.ComboBox = Each ComboBox
			If gad\ID = ID
				Exit
			EndIf
		Next
	EndIf
	
	If gad <> Null
		If Index = 0
			Index = gad\Count + 1
			If Index = 0
				Index = 1
			EndIf
		EndIf
		
		If gad\Item[Index-1] = ""
			gad\DH = gad\DH + gad\IH
		EndIf
		gad\Item[Index-1] = Caption
		If Right( Lower(Icon), 4 ) = ".bmp" Or Right( Lower(Icon), 4 ) = ".jpg"
			gad\Icon[Index-1] = LoadImage( Icon )
			If gad\Icon[Index-1]
				MidHandle gad\Icon[Index-1]
				MaskImage gad\Icon[Index-1], 255, 0, 0
				gad\IconSource[Index-1] = Icon
			EndIf
		Else
			If Icon
				gad\Icon[Index-1] = CopyImage( Icon )
				MidHandle gad\Icon[Index-1]
			EndIf
		EndIf
		If Index > gad\Count And Caption > ""
			gad\Count = Index
		EndIf
	EndIf

End Function

Function GroupBox( X = 0, Y = 0, W = 100, H = 100, Caption$ = "Group Box", Background = True )

	gad.GroupBox = New GroupBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	gad\Visible = True
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf

	gad\Caption = Caption
	SetFont app\fntGroupBox
	If gad\Caption > ""
		If gad\Y < FontHeight()/2
			gad\Y = FontHeight()/2
		EndIf
		If gad\TabOwner <> Null
			If gad\Y < gad\TabOwner\Owner\IH + 3 + FontHeight()/2
				gad\Y = gad\TabOwner\Owner\IH + 3 + FontHeight()/2
			EndIf
		EndIf
	EndIf
	
	gad\BG = Background
	
	Insert gad Before First GroupBox
	Return Handle( gad )

End Function

Function Image( X, Y, W, H, Image$, Align$ = "Left", VAlign$ = "Middle" )

	gad.Image = New Image
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	If gad\X < 0 And gad\X >-11 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 And gad\Y >-11 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	gad\Visible = True
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	If Right( Lower(Image), 4 ) = ".bmp" Or Right( Lower(Image), 4 ) = ".jpg"
		gad\ImageSource = Image
		gad\Image = LoadImage( Image )
	Else
		If Image
			gad\Image = CopyImage( Image )
		EndIf
	EndIf
	If gad\Image
		If gad\W > 0
			ResizeImage gad\Image, gad\W, ImageHeight( gad\Image )
		Else
			gad\W = ImageWidth( gad\Image )
		EndIf
		If gad\H > 0
			ResizeImage gad\Image, ImageWidth( gad\Image ), gad\H
		Else
			gad\H = ImageHeight( gad\Image )
		EndIf
	EndIf
	If Lower(Align) = "left" Align = 0
	If Lower(Align) = "center" Align = 1
	If Lower(Align) = "right" Align = 2
	gad\Align = Align
	If Lower(VAlign) = "top" VAlign = 0
	If Lower(VAlign) = "middle" VAlign = 1
	If Lower(VAlign) = "bottom" VAlign = 2
	gad\VAlign = VAlign
	
	Insert gad Before First Image
	Return Handle( gad )

End Function

Function ImageBox( X, Y, W, H, Image$, Border$ = "Outer", Align$ = "Left", VAlign$ = "Middle" )

	gad.ImageBox = New ImageBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	gad\Visible = True
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	If Right( Lower(Image), 4 ) = ".bmp" Or Right( Lower(Image), 4 ) = ".jpg"
		gad\ImageSource = Image
		gad\Image = LoadImage( Image )
	Else
		If Image
			gad\Image = CopyImage( Image )
		EndIf
	EndIf
	If gad\Image <> 0
		If gad\W > 0
			ResizeImage gad\Image, gad\W, ImageHeight( gad\Image )
		Else
			gad\W = ImageWidth( gad\Image )
		EndIf
		If gad\H > 0
			ResizeImage gad\Image, ImageWidth( gad\Image ), gad\H
		Else
			gad\H = ImageHeight( gad\Image )
		EndIf
	EndIf
	If Lower(Border) = "outer" Border = 0
	If Lower(Border) = "inner" Border = 1
	If Lower(Border) = "none" Border = 2
	gad\Border = Border
	If Lower(Align) = "left" Align = 0
	If Lower(Align) = "center" Align = 1
	If Lower(Align) = "right" Align = 2
	gad\Align = Align
	If Lower(VAlign) = "top" VAlign = 0
	If Lower(VAlign) = "middle" VAlign = 1
	If Lower(VAlign) = "bottom" VAlign = 2
	gad\VAlign = VAlign
	
	Insert gad Before First ImageBox
	Return Handle( gad )

End Function

Function Label( X = 0, Y = 0, Caption$ = "Label", Align$ = "Left" )

	gad.Label = New Label
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	gad\Visible = True
	
	If Lower(Align) = "left" Align = 0
	If Lower(Align) = "center" Align = 1
	If Lower(Align) = "right" Align = 2
	gad\Align = Align
	
	gad\W = 0
	gad\Lines = CountItems(Caption$, Chr(10))
	SetFont app\fntLabel
	For A = 0 To gad\Lines
		gad\Caption[A] = Parse(Caption$, A, Chr(10))
		If StringWidth(gad\Caption[A]) > gad\W
			gad\W = StringWidth(gad\Caption[A])
		EndIf
	Next
	
	Insert gad Before First Label
	Return Handle( gad )

End Function

Function ListBox( X = 0, Y = 0, W = 0, H = 0, ItemHeight = 20, Inc =-1, SDelay = 10, Snap = True, GadgetStrip = True )

	gad.ListBox = New ListBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	gad\Count = 0
	gad\IH = ItemHeight
	
	gad\Snap = Snap
	gad\Visible = True
	
	;Scrollbar Increment. Set to -1 to "snap" to list items
	gad\Inc = Inc
	If gad\Inc =-1
		gad\Inc = gad\IH
	EndIf
	
	;Scrolling Delay
	gad\SDelay = SDelay

    If gad\IH = 0 gad\IH = 16
	gad\CountVisible = gad\H / gad\IH
	If Snap = True gad\H = gad\CountVisible * gad\IH + 2
	
	If GadgetStrip = True
		gad\SW = 20
	Else
		gad\SW = 0
	EndIf
	gad\ScrollW = 19
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf

	Insert gad Before First ListBox
	Return Handle( gad )

End Function

Function AddListBoxItem( ID = 0, Index = 0, Caption$ = "", Icon$ = 0 )

	If ID = 0
		gad.ListBox = First ListBox
	Else
		For gad.ListBox = Each ListBox
			If gad\ID = ID
				Exit
			EndIf
		Next
	EndIf
	
	If Index <= 0
		Index = gad\Count + 1
	EndIf
	gad\Item[Index-1] = Caption
	
	Icon = Lower( Icon )
	If Right( Icon, 4 ) = ".bmp" Or Right( Icon, 4 ) = ".jpg"
		gad\Icon[Index-1] = LoadImage( Icon )
		If gad\Icon[Index-1]
			If ImageWidth(gad\Icon[Index-1]) > gad\SW-2
				ResizeImage gad\Icon[Index-1], gad\SW-2, ImageHeight(gad\Icon[Index-1])
			EndIf
			If ImageHeight(gad\Icon[Index-1]) > gad\SW-2
				ResizeImage gad\Icon[Index-1], ImageWidth(gad\Icon[Index-1]), gad\SW-2
			EndIf
			MidHandle gad\Icon[Index-1]
			MaskImage gad\Icon[Index-1], 255, 0, 0
			gad\IconSource[Index-1] = Icon
		EndIf
	Else
		If Icon
			gad\Icon[Index-1] = CopyImage( Icon )
			If ImageWidth(gad\Icon[Index-1]) > gad\SW-2
				ResizeImage gad\Icon[Index-1], gad\SW-2, ImageHeight(gad\Icon[Index-1])
			EndIf
			If ImageHeight(gad\Icon[Index-1]) > gad\SW-2
				ResizeImage gad\Icon[Index-1], ImageWidth(gad\Icon[Index-1]), gad\SW-2
			EndIf
			MidHandle gad\Icon[Index-1]
		ElseIf Icon = "" Or Icon = 0
			If gad\Icon[Index-1] FreeImage gad\Icon[Index-1]
			gad\Icon[Index-1] = 0
			gad\IconSource[Index-1] = ""
		EndIf
	EndIf
		
	If Index > gad\Count
		gad\Count = Index
	EndIf

End Function

Function ProgressBar( X = 0, Y = 0, W = 0, H = 0, Percent = 0 )

	gad.ProgressBar = New ProgressBar
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	gad\Visible = True
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	If Percent > 100 Percent = 100
	If Percent < 0 Percent = 0
	gad\Percent = Percent
	
	Insert gad Before First ProgressBar
	Return Handle( gad )

End Function

Function Radio( X = 0, Y = 0, Caption$ = "Button", Checked = False, GroupID = 1 )

	gad.Radio = New Radio
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)

	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\Caption = Caption
	gad\Checked = Checked
	gad\Visible = True
	
	If GroupID <= 0 GroupID = 1
	gad\GroupID = GroupID
	
	If gad\Checked = True
		For rad.Radio = Each Radio
			If rad\GroupID = gad\GroupID And rad <> gad
				rad\Checked = False
			EndIf
		Next
	EndIf
	
	Insert gad Before First Radio
	Return Handle( gad )

End Function

Function ScrollBar( X = 0, Y = 0, W = 100, H = 6, SW = 20, Value# = 0.0, Min# = 0.0, Max# = 100.0, Mode$ = "Integer", Dir$ = "Horizontal" )

	gad.ScrollBar = New ScrollBar
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\Min = Min
	gad\Max = Max
	gad\Visible = True
	
	gad\SW = SW
	
	gad\Value = Value
	If gad\Value < gad\Min gad\Value = gad\Min
	If gad\Value > gad\Max gad\Value = gad\Max
	gad\SX = Interpolate(gad\Value, gad\Min, gad\Max, gad\H-1, gad\W-gad\H-gad\SW-1)
	gad\SY = Interpolate(gad\Value, gad\Min, gad\Max, gad\H-1, gad\W-gad\H-gad\SW-1)
	
	Mode = Lower(Mode)
	If Mode = "integer" Or Mode = "int"
		Mode = 0
	Else
		Mode = 1
	EndIf
	gad\Mode = Mode
	
	Dir$ = Lower(Dir$)
	If Dir = "horizontal"
		Dir = 0
	ElseIf Dir = "vertical"
		Dir = 1
	EndIf
	gad\Dir = Dir
	
	Insert gad Before First ScrollBar
	Return Handle( gad )

End Function

Function Slider( X = 0, Y = 0, W = 100, H = 6, Value# = 0.0, Min# = 0.0, Max# = 100.0, Mode$ = "Integer", Dir$ = "Horizontal", SRGB$="210,210,210", ERGB$="210,210,210" )

	gad.Slider = New Slider
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\Min = Min
	gad\Max = Max
	gad\Visible = True
	
	gad\SR = Parse(SRGB, 0, ",")
	gad\SG = Parse(SRGB, 1, ",")
	gad\SB = Parse(SRGB, 2, ",")
	gad\ER = Parse(ERGB, 0, ",")
	gad\EG = Parse(ERGB, 1, ",")
	gad\EB = Parse(ERGB, 2, ",")
	
	gad\Value = Value
	If gad\Value < gad\Min gad\Value = gad\Min
	If gad\Value > gad\Max gad\Value = gad\Max
	gad\SX = Interpolate(gad\Value, gad\Min, gad\Max, 0, gad\W-gad\H)
	
	Mode = Lower(Mode)
	If Mode = "integer" Or Mode = "int"
		Mode = 0
	Else
		Mode = 1
	EndIf
	gad\Mode = Mode
	
	Dir$ = Lower(Dir$)
	If Dir = "horizontal"
		Dir = 0
	ElseIf Dir = "vertical"
		Dir = 1
	EndIf
	gad\Dir = Dir
	
	Insert gad Before First Slider
	Return Handle( gad )

End Function

Function Spinner( X = 0, Y = 0, W = 100, H = 20, Value# = 0.0, Min# = 0.0, Max# = 100.0, Inc# = 1.0, Mode$ = "Integer", ButtonsOnly = False )

	gad.Spinner = New Spinner
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\Value = Value
	gad\Inc = Inc
	gad\Visible = True
	
	gad\Min = Min
	gad\Max = Max
	
	gad\ButtonsOnly = ButtonsOnly
	
	Mode = Lower(Mode)
	If Mode > 1
		If Mode = "integer" Or Mode = "int"
			Mode = 0
		Else
			Mode = 1
		EndIf
	EndIf
	gad\Mode = Mode
	
	Insert gad Before First Spinner
	Return Handle( gad )

End Function

Function TextBox( X = 0, Y = 0, W = 0, H = 0, MultiLine = False, Mode$="Standard", Inc =-1, SDelay = 10, Snap = True )

	gad.TextBox = New TextBox
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	SetFont app\fntTextBox
	gad\IH = 18
	
	gad\MultiLine = MultiLine
	gad\Snap = Snap
	gad\Visible = True
	
	Mode = Lower( Mode )
	
	If Mode = "standard"
		Mode = 0
	ElseIf Mode = "numeric" Or Mode = "integer"
		Mode = 1
	ElseIf Mode = "float"
		Mode = 2
	EndIf
	gad\Mode = Mode
	
	gad\LineCount = 1
				
	;Scrollbar Increment. Set to -1 to "snap" to list items
	gad\Inc = Inc
	If gad\Inc =-1
		gad\Inc = gad\IH
	EndIf
	
	;Scrolling Delay
	gad\SDelay = SDelay
	
	gad\ScrollW = 19
	
	gad\LineCountVisible = gad\H / gad\IH
	If Snap = True
		If gad\MultiLine = True
			gad\H = gad\LineCountVisible * gad\IH + 3
		Else
			gad\H = gad\IH + 3
		EndIf
	EndIf
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	Insert gad Before First TextBox
	Return Handle( gad )

End Function

Function TreeView( X = 0, Y = 0, W = 50, H = 50, ItemHeight = 20, Inc =-1, SDelay = 10, Snap = True )

	gad.TreeView = New TreeView
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	gad\Count = 0
	gad\IH = ItemHeight
	gad\NodeW = gad\IH / 2
	If gad\NodeW Mod 2 = 0
		gad\NodeW = gad\NodeW + 1
	EndIf
	
	;Scrollbar Increment. Set to -1 to "snap" to list items
	gad\Inc = Inc
	If gad\Inc =-1
		gad\Inc = gad\IH
	EndIf
	
	;Scrolling Delay
	gad\SDelay = SDelay
	gad\Visible = True

	If gad\IH = 0 gad\IH = 16
	gad\CountVisible = gad\H / gad\IH
	If Snap = True gad\H = gad\CountVisible * gad\IH + 2
	
	gad\ScrollW = 19
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	Insert gad Before First TreeView
	Return Handle( gad )

End Function

Function Circle( X = 0, Y = 0, W = 20, H = 20, FillRGB$="255,0,0", OutlineRGB$="0,0,0" )

	gad.Circle = New Circle
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\FillR = Parse(FillRGB, 0, ",")
	gad\FillG = Parse(FillRGB, 1, ",")
	gad\FillB = Parse(FillRGB, 2, ",")
	gad\OutR = Parse(OutlineRGB, 0, ",")
	gad\OutG = Parse(OutlineRGB, 1, ",")
	gad\OutB = Parse(OutlineRGB, 2, ",")
	
	Insert gad Before First Circle
	Return Handle( gad )

End Function

Function Square( X = 0, Y = 0, W = 20, H = 20, FillRGB$="255,0,0", OutlineRGB$="0,0,0" )

	gad.Square = New Square
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\FillR = Parse(FillRGB, 0, ",")
	gad\FillG = Parse(FillRGB, 1, ",")
	gad\FillB = Parse(FillRGB, 2, ",")
	gad\OutR = Parse(OutlineRGB, 0, ",")
	gad\OutG = Parse(OutlineRGB, 1, ",")
	gad\OutB = Parse(OutlineRGB, 2, ",")
	
	Insert gad Before First Square
	Return Handle( gad )

End Function

Function Triangle( X = 0, Y = 0, W = 20, H = 20, FillRGB$="255,0,0", OutlineRGB$="0,0,0" )

	gad.Triangle = New Triangle
	
	gad\ID = Handle( gad )
	
	gad\Owner = First Window
	If app\actOwner = "tab"
		gad\TabOwner = First TabPage
	EndIf
	
	gad\X = X
	gad\Y = Y
	gad\W = W
	gad\H = H
	
	If gad\X < 0 gad\X = gad\Owner\W / Abs(gad\X)
	If gad\Y < 0 gad\Y = gad\Owner\H / Abs(gad\Y)
	If gad\W < 0 gad\W = gad\Owner\W / Abs(gad\W)
	If gad\H < 0 gad\H = gad\Owner\H / Abs(gad\H)
	
	If gad\TabOwner <> Null
		gad\X = gad\X + gad\TabOwner\Owner\X + 1
		gad\Y = gad\Y + gad\TabOwner\Owner\Y + gad\TabOwner\Owner\IH + 3
	EndIf
	
	gad\FillR = Parse(FillRGB, 0, ",")
	gad\FillG = Parse(FillRGB, 1, ",")
	gad\FillB = Parse(FillRGB, 2, ",")
	gad\OutR = Parse(OutlineRGB, 0, ",")
	gad\OutG = Parse(OutlineRGB, 1, ",")
	gad\OutB = Parse(OutlineRGB, 2, ",")
	
	Insert gad Before First Triangle
	Return Handle( gad )

End Function

Function AddTreeViewNode( Owner = 0, Caption$ = "Node", Icon = 0 )

	If Owner = 0
		tree.TreeView = First TreeView
		If tree <> Null
			Owner = tree\ID
		EndIf
	EndIf
	
	OwnerType$ = ParseID( Owner )
	Select OwnerType$
		Case "tree"
			For tree.TreeView = Each TreeView
				If tree\ID = Owner
					gad.Node = New Node
					gad\ID = Handle( gad )
					gad\Owner = tree
					gad\Layer = 0
					tree\Count = tree\Count + 1
					Exit
				EndIf
			Next
		Case "node"
			For node.Node = Each Node
				If node\ID = Owner
					gad.Node = New Node
					gad\ID = Handle( gad )
					gad\Owner = node\Owner
					gad\ParentNode = node
					gad\Layer = node\Layer + 1
					node\Count = node\Count + 1
					node\HasChildren = True
					Exit
				EndIf
			Next
	End Select
	
	gad\Caption = Caption
	gad\Visible = True
	If Icon
		gad\Icon = CopyImage( Icon )
		MidHandle gad\Icon
	EndIf
	
	Insert gad Before First Node
	Return Handle( gad )

End Function

Function UpdateGUI( XOFF = 0, YOFF = 0 )

	UpdateMouse( XOFF, YOFF )
	UpdateWindow(  )

End Function

Function UpdateMouse( XOFF = 0, YOFF = 0 )

	app\MX = MouseX() - XOFF
	app\MY = MouseY() - YOFF
	app\MZ = MouseZ()
	app\MXS = MouseXSpeed()
	app\MYS = MouseYSpeed()
	app\MZS = MouseZSpeed()
	
	If app\MXS <> 0 Or app\MYS <> 0
		app\ToolTip = ""
		app\ToolTipTimer = 0
	EndIf
	
	;Left Mouse Button
	If app\MB1 = 0
		If MouseDown(1)
			app\MB1 = 1
		EndIf
	ElseIf app\MB1 = 1
		If MouseDown(1)
			app\MB1 = 2
		Else
			app\MB1 = 0
		EndIf
	ElseIf app\MB1 = 2
		If MouseDown(1)=False
			app\MB1 = 3
		EndIf
	ElseIf app\MB1 = 3
		app\MB1 = 0
	EndIf
	
	;Right Mouse Button
	If app\MB2 = 0
		If MouseDown(2)
			app\MB2 = 1
		EndIf
	ElseIf app\MB2 = 1
		If MouseDown(2)
			app\MB2 = 2
		Else
			app\MB2 = 0
		EndIf
	ElseIf app\MB2 = 2
		If MouseDown(2)=False
			app\MB2 = 3
		EndIf
	ElseIf app\MB2 = 3
		app\MB2 = 0
	EndIf
	
	;Middle Mouse Button
	If app\MB3 = 0
		If MouseDown(3)
			app\MB3 = 1
		EndIf
	ElseIf app\MB3 = 1
		If MouseDown(3)
			app\MB3 = 2
		Else
			app\MB3 = 0
		EndIf
	ElseIf app\MB3 = 2
		If MouseDown(3)=False
			app\MB3 = 3
		EndIf
	ElseIf app\MB3 = 3
		app\MB3 = 0
	EndIf
	
End Function

Function DrawMouse(  )

	Ok = False
	If app\MCurrent
		DrawImage app\MCurrent, app\MX, app\MY
		Ok = True
	EndIf
	
	DrawToolTip(  )
	
	Return Ok

End Function

Function DrawToolTip(  )
	If app\ToolTip > ""
		SetFont app\fntLabel
		
		X = app\MX
		Y = app\MY + ImageHeight(app\MCurrent) + 2
		W = StringWidth( app\ToolTip ) + 7
		H = FontHeight() + 5
		
		If X + W > app\W X = app\W - W - 5
		If Y + H > app\H Y = app\H - H - 5
		
		SetColor( SC_INPUT )
		Rect X, Y, W, H
		Color 0, 0, 0
		Rect X, Y, W, H, 0
		
		SetColor( SC_INPUTTEXT )
		Text X+W/2, Y+H/2, app\ToolTip, 1, 1
	EndIf
End Function

Function UpdateWindow(  )

	;Z-Order
	app\overWin = Null
	For zgad.Window = Each Window
		If zgad\Closed = False

			If zgad\Minimised = False
				H = zgad\H
			Else
				H = zgad\TH
			EndIf
			If MouseOver( zgad\X, zgad\Y, zgad\W, H )
				app\overWin = zgad
				If app\actMenu = Null
					If app\MB1 = 1
						If app\topWin = Null; Or zgad\AlwaysOnTop = True
							Insert zgad Before First Window
							app\topWin = zgad
						Else
							If app\topWin <> Null
								If app\topWin\AlwaysOnTop = True
									If app\topWin\Closed = True
										Insert zgad Before First Window
										app\topWin = zgad
									EndIf
								Else
									Insert zgad Before First Window
									app\topWin = zgad
							    EndIf
							EndIf
						EndIf
					EndIf
				EndIf
				Exit
			EndIf
		EndIf
	Next
	
	app\MCurrent = app\MArrow
	
	gad.Window = Last Window
	While gad <> Null
		
		If gad\Closed = False
			
			SetFont app\fntWindow
			
			;Dragging
			If gad\TitleBar = True And gad\Locked = False
				If gad = First Window
					If MouseOver( gad\X, gad\Y, gad\W, gad\TH ) And NoActiveGadgets()
						If app\MB1 = 1
							gad\DragX = gad\X - app\MX
							gad\DragY = gad\Y - app\MY
							gad\Dragging = True
							
							If gad\CloseBtn = True
								If MouseOver( gad\X+gad\W-1-(gad\TH-8)-3, gad\Y+5, gad\TH-8, gad\TH-8 )
									gad\Dragging = False
								EndIf
							EndIf
							If gad\MinBtn = True
								If gad\CloseBtn = False
									If MouseOver( gad\X+gad\W-1-(gad\TH-8)-3, gad\Y+5, gad\TH-8, gad\TH-8 )
										gad\Dragging = False
									EndIf
								Else
									If MouseOver( gad\X+gad\W-1-(gad\TH-8)-3-1-(gad\TH-8), gad\Y+5, gad\TH-8, gad\TH-8 )
										gad\Dragging = False
									EndIf	
								EndIf
							EndIf
						EndIf
					EndIf
					
					If gad\Dragging = True
						If app\MB1 = 2
							If SnapWindows = False; or gad\Minimised = true
								gad\X = app\MX + gad\DragX
								gad\Y = app\MY + gad\DragY
							Else
								If app\MX + gad\DragX < SNAP_STRENGTH And app\MX + gad\DragX >-SNAP_STRENGTH
									gad\X = 0
								ElseIf app\MX + gad\DragX + gad\W < app\W + SNAP_STRENGTH And app\MX + gad\DragX + gad\W > app\W - SNAP_STRENGTH
									gad\X = app\W - gad\W
								Else
									For win.Window = Each Window
										If win <> gad And win\Closed = False And win\Minimised = False
											If app\MX + gad\DragX < win\X + SNAP_STRENGTH And app\MX + gad\DragX > win\X - SNAP_STRENGTH
												If gad\Y + gad\H >= win\Y And gad\Y <= win\Y + win\H
													gad\X = win\X
													Exit
												Else
													gad\X = app\MX + gad\DragX
												EndIf
											ElseIf app\MX + gad\DragX + gad\W < win\X + SNAP_STRENGTH And app\MX + gad\DragX + gad\W > win\X - SNAP_STRENGTH
												If gad\Y + gad\H >= win\Y And gad\Y <= win\Y + win\H
													gad\X = win\X - gad\W
													Exit
												Else
													gad\X = app\MX + gad\DragX
												EndIf
											Else
												gad\X = app\MX + gad\DragX
											EndIf
											If app\MX + gad\DragX < win\X + win\W + SNAP_STRENGTH And app\MX + gad\DragX > win\X + win\W - SNAP_STRENGTH
												If gad\Y + gad\H >= win\Y And gad\Y <= win\Y + win\H
													gad\X = win\X + win\W
													Exit
												Else
													gad\X = app\MX + gad\DragX
												EndIf
											ElseIf app\MX + gad\DragX + gad\W < win\X + win\W + SNAP_STRENGTH And app\MX + gad\DragX + gad\W > win\X + win\W - SNAP_STRENGTH
												If gad\Y + gad\H >= win\Y And gad\Y <= win\Y + win\H
													gad\X = win\X + win\W - gad\W
													Exit
												Else
													gad\X = app\MX + gad\DragX
												EndIf
											Else
												gad\X = app\MX + gad\DragX
											EndIf
										EndIf
									Next
								EndIf
								If app\MY + gad\DragY < SNAP_STRENGTH And app\MY + gad\DragY >-SNAP_STRENGTH
									gad\Y = 0
								ElseIf app\MY + gad\DragY + gad\H < app\H + SNAP_STRENGTH And app\MY + gad\DragY + gad\H > app\H - SNAP_STRENGTH
									gad\Y = app\H - gad\H
								Else
									For win.Window = Each Window
										If win <> gad And win\Closed = False And win\Minimised = False
											If app\MY + gad\DragY < win\Y + SNAP_STRENGTH And app\MY + gad\DragY > win\Y - SNAP_STRENGTH
												If gad\X + gad\W >= win\X And gad\X <= win\X + win\W
													gad\Y = win\Y
													Exit
												Else
													gad\Y = app\MY + gad\DragY
												EndIf
											ElseIf app\MY + gad\DragY + gad\H < win\Y + SNAP_STRENGTH And app\MY + gad\DragY + gad\H > win\Y - SNAP_STRENGTH
												If gad\X + gad\W >= win\X And gad\X <= win\X + win\W
													gad\Y = win\Y - gad\H
													Exit
												Else
													gad\Y = app\MY + gad\DragY
												EndIf
											Else
												gad\Y = app\MY + gad\DragY
											EndIf
											If app\MY + gad\DragY < win\Y + win\H + SNAP_STRENGTH And app\MY + gad\DragY > win\Y + win\H - SNAP_STRENGTH
												If gad\X + gad\W >= win\X And gad\X <= win\X + win\W
													gad\Y = win\Y + win\H
													Exit
												Else
													gad\Y = app\MY + gad\DragY
												EndIf
											ElseIf app\MY + gad\DragY + gad\H < win\Y + win\H + SNAP_STRENGTH And app\MY + gad\DragY + gad\H > win\Y + win\H - SNAP_STRENGTH
												If gad\X + gad\W >= win\X And gad\X <= win\X + win\W
													gad\Y = win\Y + win\H - gad\H
													Exit
												Else
													gad\Y = app\MY + gad\DragY
												EndIf
											Else
												gad\Y = app\MY + gad\DragY
											EndIf
										EndIf
									Next
								EndIf
							EndIf
						ElseIf app\MB1 = 0
							If gad\Dragging = True
								gad\Dragging = False
								app\Event = EVENT_WINDOW
								app\WindowEvent = gad\ID
								app\WindowEventData = "Dragging"
							EndIf
						EndIf
					EndIf
				EndIf
			EndIf
			
			;Background
			If gad\Minimised = False
				SetColor(SC_FORM)
				Rect gad\X, gad\Y, gad\W, gad\H
			EndIf
			
			;Title Bar
			If gad\TitleBar = True
				If gad = First Window
					SetColor(SC_FORMTITLE)
				Else
					SetColor(SC_FORMTITLE,-40)
				EndIf
				Rect gad\X+1, gad\Y+1, gad\W-2, gad\TH
				If gad = First Window
					SetColor( SC_FORMTITLE, 40 )
				Else
					SetColor( SC_FORMTITLE )
				EndIf
				Rect gad\X+1, gad\Y+1, gad\W-1, gad\TH, 0
				Color 0, 0, 0
				Rect gad\X, gad\Y, gad\W, gad\TH+1, 0
				
				SetColor( SC_FORMTITLEITEM )
				If gad\Icon
					DrawImage gad\Icon, gad\X+1+1+(gad\TH-2)/2, gad\Y+1+gad\TH/2
					Text gad\X+1+4+(gad\TH-2), gad\Y+1+gad\TH/2, gad\Caption, 0, 1
				Else
					Text gad\X+1+4, gad\Y+1+gad\TH/2, gad\Caption, 0, 1
				EndIf
				
				If gad\CloseBtn = True
					;Close Button
					If MouseOver( gad\X+gad\W-1-(gad\TH-8)-3, gad\Y+5, gad\TH-8, gad\TH-8 ) And gad = First Window
						gad\CloseBtnState =-1
						If app\MB1 = 1
							gad\CloseBtnActive = True
						ElseIf app\MB1 = 2
							If gad\CloseBtnActive = True
								gad\CloseBtnState =-2
							EndIf
						ElseIf app\MB1 = 0
							If gad\CloseBtnActive = True
								gad\CloseBtnActive = False
								gad\CloseBtnState =-1
								app\Event = EVENT_WINDOW
								app\WindowEvent = gad\ID
								app\WindowEventData = "Closed"
								gad\Closed = True
								For win.Window = Each Window
									If win\AlwaysOnTop = True And win\Closed = False
										Insert win Before First Window
										app\topWin = win
										Exit
									EndIf
								Next
							EndIf
						EndIf
					Else
						gad\CloseBtnState = 0
						If app\MB1 = 0
							If gad\CloseBtnActive = True
								gad\CloseBtnActive = False
							EndIf
						EndIf
					EndIf
					If gad\CloseBtnState =-2
						SetColor( SC_FORMTITLEITEM, 80 )
						XOFF = 1
					ElseIf gad\CloseBtnState =-1
						SetColor( SC_FORMTITLEITEM, 80 )
						XOFF = 0
					Else
						XOFF = 0
						SetColor( SC_FORMTITLEITEM )
					EndIf
					B = gad\Y+2+gad\TH/3+XOFF
					For A = gad\X+gad\W-1-gad\TH/3-6+XOFF To gad\X+gad\W-1-(gad\TH/3)-6+XOFF+gad\TH/3-1
						Plot A, B
						Plot (gad\X+gad\W-1-(gad\TH/3)-4+XOFF+gad\TH/3-1)+(gad\Y+gad\TH/3+XOFF-B), B
						B = B + 1
					Next
					X = 1+(gad\TH-8)
				Else
					X = 0
				EndIf
				
				If gad\MinBtn = True
					;Min Button
					If MouseOver( gad\X+gad\W-1-(gad\TH-8)-3-X, gad\Y+5, gad\TH-8, gad\TH-8 ) And gad = First Window
						gad\MinBtnState =-1
						If app\MB1 = 1
							gad\MinBtnActive = True
						ElseIf app\MB1 = 2
							If gad\MinBtnActive = True
								gad\MinBtnState =-2
							EndIf
						ElseIf app\MB1 = 0
							If gad\MinBtnActive = True
								gad\MinBtnActive = False
								gad\MinBtnState =-1
								gad\Minimised = 1 - gad\Minimised
								app\Event = EVENT_WINDOW
								app\WindowEvent = gad\ID
								If gad\Minimised = True
									app\WindowEventData = "Minimised"
								Else
									app\WindowEventData = "Maximised"
								EndIf
							EndIf
						EndIf
					Else
						gad\MinBtnState = 0
						If app\MB1 = 0
							If gad\MinBtnActive = True
								gad\MinBtnActive = False
							EndIf
						EndIf
					EndIf
					If gad\MinBtnState = 0
						SetColor(SC_FORMTITLEITEM)
					Else
						SetColor( SC_FORMTITLEITEM, 40 )
					EndIf
					If gad\Minimised = False
						If gad\MinBtnState =-2
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3+1, gad\Y+5+(gad\TH-8)-4+1, (gad\TH-8)-6, 1
						Else
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3, gad\Y+5+(gad\TH-8)-4, (gad\TH-8)-6, 1
						EndIf
					Else
						If gad\MinBtnState =-2
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3+1, gad\Y+2+gad\TH/3+1, (gad\TH-8)-6, gad\TH/3, 0
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3+1, gad\Y+2+gad\TH/3+1, (gad\TH-8)-6, 2
						Else
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3, gad\Y+2+gad\TH/3, (gad\TH-8)-6, gad\TH/3, 0
							Rect gad\X+gad\W-1-(gad\TH-8)-3-X+3, gad\Y+2+gad\TH/3, (gad\TH-8)-6, 2
						EndIf
					EndIf
				EndIf
			EndIf
			
			If gad\Minimised = False
				
				;Form Border
				SetColor(SC_FORM, 40)
				If gad\Menu = False
					Rect gad\X+1, gad\Y+gad\TH+1, gad\W-1, gad\H-gad\TH-1, 0
				Else
					Rect gad\X+1, gad\Y+gad\MY+1, gad\W-1, gad\H-gad\MY-1, 0
				EndIf
				
				;Main Border
				Color 0, 0, 0
				Rect gad\X, gad\Y, gad\W, gad\H, 0

				UpdateTab( gad )
				UpdateImage( gad )
				UpdateButton( gad )
				UpdateCheckBox( gad )
				UpdateGroupBox( gad )
				UpdateImageBox( gad )
				UpdateLabel( gad )
				UpdateListBox( gad )
				UpdateProgressBar( gad )
				UpdateRadio( gad )
				UpdateScrollBar( gad )
				UpdateSlider( gad )
				UpdateSpinner( gad )
				UpdateTextBox( gad )
				UpdateTreeView( gad )
				UpdateComboBox( gad )
				UpdateCircle( gad )
				UpdateSquare( gad )
				UpdateTriangle( gad )
				UpdateMenuTitle( gad )
			EndIf
		EndIf
		
		gad = Before gad
	Wend

End Function

Function UpdateTab( win.Window )

	gad.Tab = Last Tab
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False
			
				;Drawing
				SetColor( SC_FORM, 40 )
				Rect win\X+win\FX+gad\X+1, win\Y+win\FY+gad\Y+gad\IH+1, gad\W-1, gad\H-gad\IH-1, 0
				
				Color 0, 0, 0
				Rect win\X+win\FX+gad\X, win\Y+win\FY+gad\Y+gad\IH, gad\W, gad\H-gad\IH, 0
				
				gad\XOFF = 0
				UpdateTabPage( gad )
				
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateTabPage( tab.Tab )

	gad.TabPage = Last TabPage
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\Owner = tab And gad\Owner\Owner\Minimised = False And gad\Owner\Owner\Closed = False
			
				SetFont app\fntTab
				
				;Drawing
				If tab\Active = gad
				
					gad\X = tab\XOFF
					Color 0, 0, 0
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF, tab\Owner\Y+tab\Owner\FY+tab\Y, gad\W, tab\IH+1, 0
					
					SetColor( SC_FORM )
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+2, tab\Owner\Y+tab\Owner\FY+tab\Y+tab\IH, gad\W-3, 2

					SetColor( SC_FORM, 40 )
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+1, tab\Owner\Y+tab\Owner\FY+tab\Y+1, gad\W-2, 1
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+1, tab\Owner\Y+tab\Owner\FY+tab\Y+1, 1, tab\IH
					
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Text tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2+1, tab\Owner\Y+tab\Owner\FY+tab\Y+tab\IH/2+1, gad\Caption, 1, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					If gad\Image
						DrawImage gad\Image, tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2, tab\Owner\Y+tab\Owner\FY+tab\Y+tab\IH/2
					EndIf
					Text tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2, tab\Owner\Y+tab\Owner\FY+tab\Y+tab\IH/2, gad\Caption, 1, 1
					
				Else					
					SetColor( SC_FORM, 40 )
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+1, tab\Owner\Y+tab\Owner\FY+tab\Y+4+1, gad\W-1, tab\IH-4, 0
					Color 0, 0, 0
					Rect tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF, tab\Owner\Y+tab\Owner\FY+tab\Y+4, gad\W, tab\IH+1-4, 0
				
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Text tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2+1, tab\Owner\Y+tab\Owner\FY+tab\Y+4+tab\IH/2+1, gad\Caption, 1, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					If gad\Image
						DrawImage gad\Image, tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2, tab\Owner\Y+tab\Owner\FY+tab\Y+tab\IH/2+4
					EndIf
					Text tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF+gad\W/2, tab\Owner\Y+tab\Owner\FY+tab\Y+4+tab\IH/2, gad\Caption, 1, 1
				EndIf
				
				Valid = True
				If tab\Owner <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF, tab\Owner\Y+tab\Owner\FY+tab\Y, gad\W, tab\IH ) = True And NoActiveGadgets() And tab\Owner = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				If gad\Disabled = True Valid = False
				
				If MouseOver( tab\Owner\X+tab\Owner\FX+tab\X+tab\XOFF, tab\Owner\Y+tab\Owner\FY+tab\Y+4, gad\W, tab\IH-4 ) = True And NoActiveGadgets() And tab\Owner = app\overWin And Valid = True
					If app\MB1 = 1
						tab\Active = gad
						app\Event = EVENT_GADGET
						app\GadgetEvent = gad\ID
					EndIf
				EndIf
				tab\XOFF = tab\XOFF + gad\W + 1
				
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateMenuTitle( win.Window )

	gad.MenuTitle = Last MenuTitle
	
	X = 0
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\Owner = win And gad\Owner\Menu = True And gad\Owner\Minimised = False And gad\Owner\Closed = False
				
				SetFont app\fntMenu
				
				gad\X = win\X+win\FX+X
				gad\Y = win\Y+1+win\MY+win\MH
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
						If ModVersion
							gad\Active = False
						EndIf
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				If win <> app\overWin
					Valid = False
				EndIf
				If MouseOver( win\X+win\FX+X, win\Y+1+win\MY, gad\W, win\MH ) And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
					gad\State =-1
					If app\actMenu <> Null
						app\actMenu\Active = False
						app\actMenu = gad
						gad\Active = True
						app\Event = EVENT_MENU
						app\MenuEvent = gad\ID
					EndIf
					If app\MB1 = 1
						gad\Active = 1 - gad\Active
					EndIf
					If gad\Active = True
						app\actMenu = gad
					Else
						app\actMenu = Null
					EndIf
					app\Event = EVENT_MENU
					app\MenuEvent = gad\ID
				Else
					gad\State = 0
					If app\MB1 = 1
						If gad\ActiveItem = False
							If gad\Active = True
								gad\Active = False
								app\actMenu = Null
							EndIf
						EndIf
					EndIf
				EndIf
				
				;Drawing
				If gad\State =-1
					SetColor( SC_MENUSTRIP )
					Rect win\X+win\FX+X, win\Y+1+win\MY+1, gad\W, win\MH
					SetColor( SC_MENUSTRIP, 40 )
					Rect win\X+win\FX+X+1, win\Y+1+win\MY+1+1, gad\W-1, win\MH-1, 0
					Color 0, 0, 0
					Rect win\X+win\FX+X, win\Y+1+win\MY+1, gad\W, win\MH, 0
				EndIf
				If gad\Active = True Or (ModVersion = True And gad\Owner\ID <> winTools)
					If gad\Active = True
			    		SetColor( SC_MENUSTRIP )
			    		Rect win\X+win\FX+X+1, win\Y+1+win\MY+1, gad\W-1, win\MH
			    		SetColor( SC_MENUSTRIP, 40 )
			    		Rect win\X+win\FX+X+1, win\Y+1+win\MY+2, gad\W-1, win\MH-1, 0
						Color 0, 0, 0
						Rect win\X+win\FX+X, win\Y+1+win\MY+1, gad\W, win\MH, 0
					EndIf
					
					If ModVersion = True And gad\Owner\ID <> winTools
						Ok = False
						If gad\ID <> SelControl
							For mnui.MenuItem = Each MenuItem
								If mnui\Owner = gad
									If mnui\ID = SelControl
										Ok = True
									EndIf
								EndIf
							Next
						Else
							Ok = True
						EndIf
					Else
						Ok = True
					EndIf
					If gad\DH > 2 And Ok = True
						;Drop Down Menu
						SetColor(SC_MENU)
						Rect win\X+win\FX+X, win\Y+1+win\MY+win\MH, gad\DW, gad\DH
						SetColor(SC_MENUSTRIP)
						Rect win\X+win\FX+X+1, win\Y+1+win\MY+win\MH, gad\SBW, gad\DH
						SetColor(SC_MENUSTRIP, 40)
						Rect win\X+win\FX+X+1, win\Y+1+win\MY+win\MH, gad\SBW+1, gad\DH, 0
						SetColor(SC_MENUSTRIP,-40)
						Rect win\X+win\FX+X, win\Y+1+win\MY+win\MH, gad\SBW+1, gad\DH, 0
						SetColor(SC_MENU, 40)
						Rect win\X+win\FX+X+gad\SBW+1, win\Y+1+win\MY+win\MH+1, gad\DW-gad\SBW-1, gad\DH-1, 0
						Color 0, 0, 0
						Rect win\X+win\FX+X, win\Y+1+win\MY+win\MH, gad\DW, gad\DH, 0
						SetColor(SC_MENUSTRIP)
						Rect win\X+win\FX+X+2, win\Y+1+win\MY+win\MH, gad\SBW-2, 1
						SetColor(SC_MENUSTRIP, 40)
						Plot win\X+win\FX+X+1, win\Y+1+win\MY+win\MH
					EndIf
				EndIf
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Text win\X+win\FX+gad\W/2+X+1, win\Y+1+win\MY+win\MH/2+1, gad\Caption, 1, 1
					SetColor( SC_FORM,-60 )
				Else
					If gad\State =-1 Or gad\Active = True
						SetColor( SC_MENUSTRIPITEM )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
				EndIf
				Text win\X+win\FX+gad\W/2+X, win\Y+1+win\MY+win\MH/2, gad\Caption, 1, 1
				
				gad\YOFF = 1
				gad\ActiveItem = False
				UpdateMenuItem( gad )
				
				X = X + gad\W
			EndIf

		EndIf
		gad = Before gad
	Wend


End Function

Function UpdateMenuItem( mnut.MenuTitle )

	gad.MenuItem = Last MenuItem
	
	While gad <> Null
	
		If gad\Owner <> Null
			If (mnut\Active = True Or (ModVersion = True And mnut\Owner\ID <> winTools)) And gad\Owner = mnut
			
				SetFont app\fntMenu
			
				gad\YOFF = 2
			
				Valid = True
				
				Ok = True
				If ModVersion = True And mnut\Owner\ID <> winTools
					Ok = False
					If gad\ParentMenu = Null
						If mnut\ID <> SelControl
							For mnui.MenuItem = Each MenuItem
								If mnui\Owner = mnut
									If mnui\ID = SelControl
										Ok = True
									EndIf
								EndIf
							Next
							If Ok = False
								Valid = False
							EndIf
						EndIf
					Else
						If gad\ParentMenu\ID <> SelControl
							For mnui.MenuItem = Each MenuItem
								If mnui\ID = SelControl
									If mnui\Owner = gad\Owner
										If mnui\ParentMenu = gad\ParentMenu
											Ok = True
											Exit
										Else
											mnusi.MenuItem = mnui
											Done = False
											Repeat
												If mnusi\ParentMenu = gad
													Ok = True
													Done = True
													Exit
												Else
													If mnusi\ParentMenu <> Null
														If mnusi\ParentMenu\ParentMenu = gad\ParentMenu
															Ok = True
															Done = True
															Exit
														Else
															mnusi = mnusi\ParentMenu
														EndIf
													Else
														Ok = False
														Done = True
														Exit
													EndIf
												EndIf
											Forever
											If Done = True Exit
										EndIf
									Else
										Ok = False
										Exit
									EndIf
								EndIf
							Next
						Else
							Ok = True
						EndIf
						If Ok = False
							Valid = False
						EndIf
					EndIf
				EndIf
				
				If gad\ParentMenu = Null
					gad\X = mnut\X
					gad\Y = mnut\Y+mnut\YOFF
					gad\W = mnut\DW
					gad\H = mnut\DH
				Else
					gad\X = gad\ParentMenu\X+gad\ParentMenu\W-1
					gad\Y = gad\ParentMenu\Y+gad\ParentMenu\YOFF
					gad\W = gad\ParentMenu\DW
					gad\H = gad\ParentMenu\DH
					If gad\ParentMenu\Active = False
						gad\Active = False
						If ModVersion = False
							Valid = False
						Else
							If mnut\Owner\ID = winTools
								Valid = False
							EndIf
						EndIf
					EndIf
				EndIf
				
				If mnut\Owner <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						If ModVersion = True
							If mnut\Owner\ID = winTools
								Valid = False
							EndIf
						Else
							Valid = False
						EndIf
						gad\Active = False
					EndIf
				EndIf
				
				If Valid = True
					If gad\Caption <> "-"
						If MouseOver( gad\X, gad\Y, gad\W, mnut\IH )
							gad\Owner\ActiveItem = True
							app\ToolTipTimer = app\ToolTipTimer + 1
							If app\ToolTipTimer > app\ToolTipDelay
								app\ToolTip = gad\ToolTip
							EndIf
						EndIf
						If gad\Disabled = True Valid = False
						If MouseOver( gad\X, gad\Y, gad\W, mnut\IH ) And Valid = True
							If ModVersion = False Or mnut\Owner\ID = winTools
								gad\State =-1
								If gad\SubMenu = True
									gad\Active = True
								EndIf
								If app\MB1 = 2
									gad\State =-2
								ElseIf app\MB1 = 3
									If gad\SubMenu = False
										If gad\AllowCheck = False
											mnut\Active = False
											app\actMenu = Null
										Else
											If gad\GroupID > 0
												For mnui.MenuItem = Each MenuItem
													If mnui\GroupID = gad\GroupID
														mnui\Checked = False
													EndIf
												Next
												gad\Checked = True
											Else
												gad\Checked = 1 - gad\Checked
												mnut\Active = False
												app\actMenu = Null
											EndIf
											app\MenuEventData = gad\Checked
										EndIf
									EndIf
									app\Event = EVENT_MENU
									app\MenuEvent = gad\ID
								EndIf
							EndIf
						Else
							If gad\ParentMenu = Null
								If MouseOver( gad\X, mnut\Y+1, gad\W, mnut\DH-2 ) = True Or gad\SubMenu = False Or gad\Active = False
									gad\State = 0
									gad\Active = False
								EndIf
							Else
								If MouseOver( gad\X, gad\ParentMenu\Y+1, gad\W, gad\DH-2 ) = True Or gad\SubMenu = False Or gad\Active = False
									gad\State = 0
									gad\Active = False
								EndIf
							EndIf
						EndIf
					
						;Drawing
						If gad\State < 0
							SetColor(SC_MENUSEL)
							Rect gad\X + 1, gad\Y, gad\W-2, mnut\IH
							SetColor(SC_MENUSEL,-40)
							Rect gad\X + 1, gad\Y, gad\W-2, mnut\IH, 0
							SetColor(SC_MENUSEL, 40)
							Rect gad\X + 1, gad\Y, gad\W-2, 1
							Rect gad\X + 1, gad\Y, 1, mnut\IH
						EndIf
						
						If gad\Disabled = True
							SetColor( SC_MENU, 60 )
							Text gad\X+mnut\SBW+1+4+1, gad\Y+mnut\IH/2+1, gad\Caption, 0, 1
							If gad\SubMenu = False
								Text gad\X+gad\W-1-4-StringWidth(gad\ShortCut)+1, gad\Y+mnut\IH/2+1, gad\ShortCut, 0, 1
							EndIf
							SetColor( SC_MENU,-60 )
						Else
							If gad\State >-1
								SetColor( SC_MENUTEXT )
					    	Else
					    		SetColor( SC_MENUTEXTSEL )
							EndIf
						EndIf
						Text gad\X+mnut\SBW+1+4, gad\Y+mnut\IH/2, gad\Caption, 0, 1
						If gad\SubMenu = False
							Text gad\X+gad\W-1-4-StringWidth(gad\ShortCut), gad\Y+mnut\IH/2, gad\ShortCut, 0, 1
						EndIf
						
						If gad\Icon <> 0 And gad\AllowCheck = False
							DrawImage gad\Icon, gad\X+1+mnut\SBW/2, gad\Y+mnut\IH/2
						EndIf
						
						;Checkable
						If gad\AllowCheck = True
							If gad\Checked = True
								If gad\State < 0
									SetColor(SC_MENUSTRIPITEM, 40)
								Else
									SetColor(SC_MENUSTRIPITEM)
								EndIf
								Rect gad\X+1+mnut\SBW/2-5+3, gad\Y+mnut\IH/2-5+3, 4, 4
							EndIf
						EndIf
						
						If gad\SubMenu = True
							Rect gad\X+gad\W - 7, gad\Y+mnut\IH/2-2, 1, 5
							Rect gad\X+gad\W - 6, gad\Y+mnut\IH/2-1, 1, 3
							Rect gad\X+gad\W - 5, gad\Y+mnut\IH/2, 1, 1
						EndIf
						
						If gad\Active = True Or (ModVersion = True And mnut\Owner\ID <> winTools)
							If ModVersion = True And mnut\Owner\ID <> winTools
								Ok = False
								If gad\ParentMenu = Null
									If gad\ID <> SelControl
										For mnui.MenuItem = Each MenuItem
											If mnui\ID = SelControl
												If mnui\Owner = gad\Owner
													If mnui\ParentMenu = gad\ParentMenu
														Ok = False
														Exit
													Else
														mnusi.MenuItem = mnui
														Done = False
														Repeat
															If mnusi\ParentMenu = gad
																Ok = True
																Done = True
																Exit
															Else
																If mnusi\ParentMenu <> Null
																	;if mnusi\ParentMenu\ParentMenu = gad\ParentMenu
																	;	Ok = true
																	;	Done = true
																	;	exit
																	;else
																		mnusi = mnusi\ParentMenu
																	;endif
																Else
																	Ok = False
																	Done = True
																	Exit
																EndIf
															EndIf
														Forever
														If Done = True Exit
													EndIf
												Else
													Ok = False
													Exit
												EndIf
											EndIf
										Next
									Else
										Ok = True
									EndIf
								Else
									If gad\ID <> SelControl
										For mnui.MenuItem = Each MenuItem
											If mnui\ID = SelControl
												If mnui\Owner = gad\Owner
													If mnui\ParentMenu = gad\ParentMenu
														Ok = False
														Exit
													Else
														mnusi.MenuItem = mnui
														Done = False
														Repeat
															If mnusi\ParentMenu = gad
																Ok = True
																Done = True
																Exit
															Else
																If mnusi\ParentMenu <> Null
																	;if mnusi\ParentMenu\ParentMenu = gad\ParentMenu
																	;	Ok = true
																	;	Done = true
																	;	exit
																	;else
																		mnusi = mnusi\ParentMenu
																	;endif
																Else
																	Ok = False
																	Done = True
																	Exit
																EndIf
															EndIf
														Forever
														If Done = True Exit
													EndIf
												Else
													Ok = False
													Exit
												EndIf
											EndIf
										Next
									Else
										Ok = True
									EndIf
								EndIf
							EndIf
							If gad\DH > 2 And Ok = True
								;Drop Down Sub Menu
								SetColor(SC_MENU)
								Rect gad\X+gad\W-1, gad\Y+1, gad\DW, gad\DH
								SetColor(SC_MENUSTRIP)
								Rect gad\X+gad\W, gad\Y+1, mnut\SBW, gad\DH
								SetColor(SC_MENUSTRIP, 40)
								Rect gad\X+gad\W, gad\Y+2, mnut\SBW+1, gad\DH-1, 0
								SetColor(SC_MENUSTRIP,-40)
								Rect gad\X+gad\W-1, gad\Y+1, mnut\SBW+1, gad\DH, 0
								SetColor(SC_MENU, 40)
								Rect gad\X+gad\W+mnut\SBW, gad\Y+2, gad\DW-mnut\SBW-1, gad\DH-1, 0
								Color 0, 0, 0
								Rect gad\X+gad\W-1, gad\Y+1, gad\DW, gad\DH, 0
							EndIf
						EndIf
						
						If gad\ParentMenu = Null
							mnut\YOFF = mnut\YOFF + gad\Owner\IH
						Else
							gad\ParentMenu\YOFF = gad\ParentMenu\YOFF + gad\Owner\IH
						EndIf
					Else
						If MouseOver( gad\X, gad\Y, gad\W, mnut\IH/2 )
							gad\Owner\ActiveItem = True
						EndIf
						Color 0, 0, 0
						Rect gad\X+mnut\SBW+1+4, gad\Y+mnut\IH/4, gad\W-mnut\SBW-1-8, 1
						SetColor(SC_MENU, 40)
						Rect gad\X+mnut\SBW+1+4+1, gad\Y+mnut\IH/4+1, gad\W-mnut\SBW-1-8, 1
						
						If gad\ParentMenu = Null
							mnut\YOFF = mnut\YOFF + gad\Owner\IH/2
						Else
							gad\ParentMenu\YOFF = gad\ParentMenu\YOFF + gad\Owner\IH/2
						EndIf
					EndIf
				EndIf
			Else
				If gad\Owner = mnut
					gad\State = 0
					If ModVersion = False Or mnut\Owner\ID = winTools gad\Active = False
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateButton( win.Window )

	gad.Button = Last Button
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
				
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And gad\Visible = True And Valid = True
			
				SetFont app\fntButton
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				If gad\Disabled = True Valid = False

				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\State =-1
					If gad\Popup
			    		SetColor(SC_FORM,-40)
			    		Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
			    		SetColor(SC_FORM, 40)
			    		Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, 1
			    		Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, 1, gad\H-1
			    	EndIf
					If app\MB1 = 1
						If gad\GroupID > 0
							If gad\TState = False
								gad\TState = True
								For btn.Button = Each Button
									If btn\GroupID = gad\GroupID And btn <> gad
										btn\TState = False
									EndIf
								Next
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
							Else
								gad\TState = False
							EndIf
						Else
							gad\Active = True
						EndIf
					ElseIf app\MB1 = 2
						If gad\Active = True
							gad\State =-2
						EndIf
					ElseIf app\MB1 = 0
						If gad\Active = True
							gad\Active = False
							app\Event = EVENT_GADGET
							app\GadgetEvent = gad\ID
						EndIf
					EndIf
				Else
					gad\State = 0
					If app\MB1 = 0
						If gad\Active = True
							gad\Active = False
						EndIf
					EndIf
				EndIf
				
				Y = gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2
				If gad\Lines Mod 2 = 0 ;Even
					Y = Y - ((gad\Lines/2) * FontHeight())/2
				Else ;Odd
					Y = Y - (gad\Lines-1)/2 * FontHeight()
				EndIf
				
				;Drawing
				If gad\State >-2 And gad\TState = False
					If gad\Image
						If gad\DrawMode = 0
							DrawImage gad\Image, gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2
				    	Else
				    		DrawBlock gad\Image, gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2
				    	EndIf
					EndIf
					For A = 0 To gad\Lines-1
						If gad\Disabled = True
							SetColor( SC_FORM, 60 )
							Text gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2+1, Y+1, gad\Caption[A], 1, 1
							SetColor( SC_FORM,-60 )
						Else
							SetColor( SC_FORMTEXT )
						EndIf
						Text gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2, Y, gad\Caption[A], 1, 1
						Y = Y + FontHeight()
			    	Next
					SetColor(SC_FORM, 40)
				Else
					If gad\Image
						If gad\DrawMode = 0
							DrawImage gad\Image, gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+1
				    	Else
				    		DrawBlock gad\Image, gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+1
				    	EndIf
					EndIf
			    	For A = 0 To gad\Lines-1
			    		If gad\Disabled = True
							SetColor( SC_FORM, 60 )
							Text gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2+1+1, Y+1+1, gad\Caption[A], 1, 1
							SetColor( SC_FORM,-60 )
						Else
							SetColor( SC_FORMTEXT )
						EndIf
						Text gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2+1, Y+1, gad\Caption[A], 1, 1
						Y = Y + FontHeight()
			    	Next
			    	SetColor(SC_FORM, 40)
			    	Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
			    	SetColor(SC_FORM,-40)
			    	Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, 1
			    	Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, 1, gad\H-1
				EndIf
				If gad\Border
			    	Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
					Color 0, 0, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0			
			    EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateCheckBox( win.Window )

	gad.CheckBox = Last CheckBox
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntCheckBox
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				gad\W = FontHeight()+4+StringWidth(gad\Caption)
				gad\H = FontHeight(  )
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight()+4+StringWidth(gad\Caption), FontHeight() ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight()+4+StringWidth(gad\Caption), FontHeight() ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\State =-1
					If app\MB1 = 1
						gad\Active = True
					ElseIf app\MB1 = 2
						If gad\Active = True
							gad\State =-2
						EndIf
					ElseIf app\MB1 = 0
						If gad\Active = True
							gad\Active = False
							gad\Checked = 1 - gad\Checked
							app\Event = EVENT_GADGET
							app\GadgetEvent = gad\ID
							app\GadgetEventData = gad\Checked
						EndIf
					EndIf
				Else
					gad\State = 0
					If app\MB1 = 0
						If gad\Active = True
							gad\Active = False
						EndIf
					EndIf
				EndIf
				
				;Drawing
				If gad\Disabled = True
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_GADGETSTRIP )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight(), FontHeight()
				
				If gad\State =-2
					SetColor( SC_GADGETSTRIP,-60 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, FontHeight()-1, FontHeight()-1, 0
				EndIf
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight(), FontHeight(), 0
				If gad\Checked = True
					If gad\State = 0
						If gad\Disabled = True
							SetColor( SC_FORM )
						Else
							SetColor( SC_GADGETSTRIPITEM )
						EndIf
					Else
						SetColor( SC_GADGETSTRIPITEM, 60 )
					EndIf
					If gad\State >-2
						Rect gad\Owner\X+gad\Owner\FX+gad\X+4, gad\Owner\Y+gad\Owner\FY+gad\Y+4, FontHeight()-8, FontHeight()-8
						;line gad\Owner\X+gad\Owner\FX+gad\X+4, gad\Owner\Y+gad\Owner\FY+gad\Y+4, gad\Owner\X+gad\Owner\FX+gad\X+fontheight()-5, gad\Owner\Y+gad\Owner\FY+gad\Y+fontheight()-5
						;line gad\Owner\X+gad\Owner\FX+gad\X+4, gad\Owner\Y+gad\Owner\FY+gad\Y+fontheight()-5, gad\Owner\X+gad\Owner\FX+gad\X+fontheight()-5, gad\Owner\Y+gad\Owner\FY+gad\Y+4
					Else
						Rect gad\Owner\X+gad\Owner\FX+gad\X+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+4+1, FontHeight()-8, FontHeight()-8
						;line gad\Owner\X+gad\Owner\FX+gad\X+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+4+1, gad\Owner\X+gad\Owner\FX+gad\X+fontheight()-5+1, gad\Owner\Y+gad\Owner\FY+gad\Y+fontheight()-5+1
						;line gad\Owner\X+gad\Owner\FX+gad\X+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+fontheight()-5+1, gad\Owner\X+gad\Owner\FX+gad\X+fontheight()-5+1, gad\Owner\Y+gad\Owner\FY+gad\Y+4+1
					EndIf
				EndIf
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Text gad\Owner\X+gad\Owner\FX+gad\X+FontHeight()+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\Caption
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_FORMTEXT )
				EndIf
				Text gad\Owner\X+gad\Owner\FX+gad\X+FontHeight()+4, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\Caption
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateComboBox( win.Window )

	gad.ComboBox = Last ComboBox
	
	While gad <> Null
	
		If gad\Owner <> Null
		
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntComboBox
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					If app\MB1 = 1
						gad\Active = 1 - gad\Active
						If gad\Active = True
							app\actCombo = gad
						Else
							app\actCombo = Null
						EndIf
					EndIf
				Else
					If gad\Count <= gad\MaxItems Or gad\MaxItems = 0
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\W, gad\DH-1 ) = False
							If app\MB1 = 1
								If gad\Active = True
									gad\Active = False
									app\actCombo = Null
								EndIf
							EndIf
						EndIf
					Else
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\W, gad\MaxItems*gad\IH + 2 ) = False
							If app\MB1 = 1
								If gad\Active = True
									gad\Active = False
									app\actCombo = Null
								EndIf
							EndIf
						EndIf
					EndIf
				EndIf
				
				;Drawing
				SetColor( SC_GADGET )
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W-gad\H, gad\H
				
				SetColor( SC_GADGET,-60 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-gad\H, gad\H-1, 0

				;Button
				If gad\Active = True
					SetColor( SC_FORM,-40 )
					XOFF = 1
				Else
					SetColor( SC_FORM, 40 )
					XOFF = 0
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\H-1, 0
				
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2-1+XOFF+1, 6, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+XOFF+1, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+1+XOFF+1, 2, 1
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_FORMTEXT )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2-1+XOFF, 6, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+XOFF, 4, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+1+XOFF, 2, 1
				
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				
				If gad\Disabled = True
					SetColor( SC_INPUT,-60 )
				Else
					SetColor( SC_INPUTTEXT )
				EndIf
				Text gad\Owner\X+gad\Owner\FX+gad\X+2+4, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2, gad\Item[gad\Index], 0, 1

				If gad\Active = True
					If gad\MaxItems = 0 Or gad\Count <= gad\MaxItems
						SetColor( SC_GADGETSTRIP )
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\SW, gad\DH
						SetColor( SC_GADGETSTRIP,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\SW, gad\DH-1, 0
						SetColor( SC_GADGETSTRIP, 40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\SW, gad\DH-1, 0
						SetColor( SC_GADGET )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W-gad\SW, gad\DH
						SetColor( SC_GADGET,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\W-gad\SW, gad\DH-1, 0
						Color 0, 0, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W, gad\DH, 0
					
						Viewport gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W, gad\DH
					Else
						SetColor( SC_GADGETSTRIP )
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\SW, 2 + gad\MaxItems * gad\IH
						SetColor( SC_GADGETSTRIP,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\SW, 2 + gad\MaxItems * gad\IH-1, 0
						SetColor( SC_GADGETSTRIP, 40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\SW, 2 + gad\MaxItems * gad\IH-1, 0
						SetColor( SC_GADGET )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W-gad\SW, 2 + gad\MaxItems * gad\IH
						SetColor( SC_GADGET,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\W-gad\SW, 2 + gad\MaxItems * gad\IH-1, 0
						Color 0, 0, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W, 2 + gad\MaxItems * gad\IH, 0
					
						Viewport gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W, 2 + gad\MaxItems * gad\IH
					EndIf
					
					Y = 0
					For A = 0 To gad\Count
						If gad\Item[A] > ""
							If A*gad\IH-gad\ScrollY < gad\MaxItems*gad\IH Or gad\MaxItems = 0
								If gad\Count > gad\MaxItems And gad\MaxItems > 0 SWOFF = gad\ScrollW+1 Else SWOFF = 0
								If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+(gad\IH*Y)-gad\ScrollY, gad\W-2-SWOFF, gad\IH ) = True
									If (((gad\Count <= MaxItems And app\MY < gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+gad\DH) Or (gad\Count > MaxItems And app\MY < gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+gad\MaxItems*gad\IH+1)) And app\MY > gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H) Or gad\MaxItems = 0
									SetColor( SC_INPUTHILIGHT );SetColor( SC_COLOR1, 20 )
									Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+(gad\IH*Y)-gad\ScrollY, gad\W-2-SWOFF, gad\IH
									SetColor( SC_INPUTHILIGHT,-40 );SetColor( SC_COLOR1,-20 )
									Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+(gad\IH*Y)-gad\ScrollY, gad\W-2-SWOFF, gad\IH, 0
									SetColor( SC_INPUTHILIGHT, 40 );SetColor( SC_COLOR1, 60 )
									Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+(gad\IH*Y)-gad\ScrollY, gad\W-2-SWOFF, 1
									Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H+(gad\IH*Y)-gad\ScrollY, 1, gad\IH
									
									If app\MB1 = 3
										gad\Index = A
										gad\Active = False
										app\actCombo = Null
										app\Event = EVENT_GADGET
										app\GadgetEvent = gad\ID
										app\GadgetEventData = gad\Item[gad\Index]
									EndIf
									SetColor( SC_INPUTTEXTSEL )
									Else
									SetColor( SC_INPUTTEXT )
									EndIf
								Else
									SetColor( SC_INPUTTEXT )
								EndIf
								
								If gad\Icon[A]
									DrawImage gad\Icon[A], gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SW/2, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1+gad\IH/2+(gad\IH*Y)-gad\ScrollY
								EndIf
								Text gad\Owner\X+gad\Owner\FX+gad\X+4+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1+gad\IH/2+(gad\IH*Y)-gad\ScrollY, gad\Item[A], 0, 1
								Y = Y + 1
							EndIf
						EndIf
					Next
					Viewport 0, 0, app\W, app\H
					
					gad\RH = (gad\Count * gad\IH) - (gad\MaxItems*gad\IH)
				
					If gad\Count > gad\MaxItems And gad\MaxItems > 0
					
						SetColor( SC_FORM,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\ScrollW-1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+gad\H, 1, gad\MaxItems*gad\IH-gad\ScrollW*2, 0
					
						;Top Button
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\ScrollW, gad\ScrollW ) = True And Valid = True
							gad\TBState =-1
							If app\MB1 = 1
								gad\TBActive = True
								gad\Timer = 0
							ElseIf app\MB1 = 2
								If gad\TBActive = True
									gad\TBState =-2
									If gad\Timer = 0
										If gad\ScrollY > 0
											gad\ScrollY = gad\ScrollY - gad\Inc
										EndIf
										If gad\ScrollY <= 0
											gad\ScrollY = 0
										EndIf
									EndIf
									gad\Timer = gad\Timer + 1
									If gad\Timer > gad\SDelay
										gad\Timer = 0
									EndIf
								EndIf
							EndIf
						Else
							gad\TBState = 0
						EndIf
						If app\MB1 = 0
							If gad\TBActive = True
								gad\TBActive = False
							EndIf
						EndIf
						
						If gad\TBState =-2
							XOFF = 1
						Else
							XOFF = 0
						EndIf
						
						SetColor( SC_FORM )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\ScrollW, gad\ScrollW
						If gad\TBState >-2
							SetColor( SC_FORM, 40 )
						Else
							SetColor( SC_FORM,-40 )
						EndIf
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\ScrollW+1, gad\ScrollW+1, 0
						
						If gad\Disabled = True
							SetColor( SC_FORM, 60 )
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF+1+gad\H, 2, 1
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF+1+gad\H, 4, 1
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF+1+gad\H, 6, 1
							SetColor( SC_FORM,-60 )
						Else
							SetColor( SC_FORMTEXT )
						EndIf
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF+gad\H, 2, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF+gad\H, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF+gad\H, 6, 1
					
						;Bottom Button
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-gad\ScrollW+gad\H, gad\ScrollW, gad\ScrollW ) = True And Valid = True
							gad\BBState =-1
							If app\MB1 = 1
								gad\BBActive = True
								gad\Timer = 0
							ElseIf app\MB1 = 2
								If gad\BBActive = True
									gad\BBState =-2
									If gad\Timer = 0
										If gad\ScrollY < gad\RH
											gad\ScrollY = gad\ScrollY + gad\Inc
										EndIf
										If gad\ScrollY >= gad\RH
											gad\ScrollY = gad\RH
										EndIf
									EndIf
									gad\Timer = gad\Timer + 1
									If gad\Timer > gad\SDelay
										gad\Timer = 0
									EndIf
								EndIf
							EndIf
						Else
							gad\BBState = 0
						EndIf
						If app\MB1 = 0
							If gad\BBActive = True
								gad\BBActive = False
							EndIf
						EndIf
						
						If gad\BBState =-2
							XOFF = 1
						Else
							XOFF = 0
						EndIf
						
						SetColor( SC_FORM )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-gad\ScrollW+gad\H, gad\ScrollW, gad\ScrollW
						If gad\BBState >-2
							SetColor( SC_FORM, 40 )
						Else
							SetColor( SC_FORM,-40 )
						EndIf
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-gad\ScrollW+gad\H, gad\ScrollW+1, gad\ScrollW+1, 0
						
						If gad\Disabled = True
							SetColor( SC_FORM, 60 )
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2-1+XOFF+1+gad\H, 6, 1
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2+XOFF+1+gad\H, 4, 1
							Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2+1+XOFF+1+gad\H, 2, 1
							SetColor( SC_FORM,-60 )
						Else
							SetColor( SC_FORMTEXT )
						EndIf
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2-1+XOFF+gad\H, 6, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2+XOFF+gad\H, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-1-gad\ScrollW/2+1+XOFF+gad\H, 2, 1
					
						;Scroll Bar
						SBS# = gad\MaxItems*gad\IH+2 - 4 - gad\ScrollW*2
						gad\ScrollH = SBS - gad\Count
						If gad\ScrollH < 6 gad\ScrollH = 6
						SY# = Interpolate(gad\ScrollY, 0, gad\RH, 0, SBS-gad\ScrollH)
						
						SetColor( SC_FORM, 40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW+2+gad\H, gad\ScrollW, SBS
						
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+SY+gad\H, gad\ScrollW, gad\ScrollH ) = True And Valid = True
							If app\MB1 = 1
								gad\SBActive = True
								gad\DragY = app\MY - (gad\Owner\Y+gad\Owner\FY+gad\Y+SY)
							EndIf
						EndIf
						If app\MB1 = 2
							If gad\SBActive = True
								SY = app\MY - gad\DragY - (gad\Owner\Y+gad\Owner\FY+gad\Y)
								If SY < 0 SY = 0
								If SY > SBS-gad\ScrollH SY = SBS-gad\ScrollH
								gad\ScrollY = Interpolate( SY, 0, SBS-gad\ScrollH, 0, gad\RH )
							EndIf
						ElseIf app\MB1 = 0
							If gad\SBActive = True
								gad\SBActive = False
							EndIf
						EndIf
						
						SetColor( SC_FORM )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+SY+gad\H, gad\ScrollW, gad\ScrollH
						SetColor( SC_FORM,-40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+SY+gad\H, gad\ScrollW, gad\ScrollH, 0
						SetColor( SC_FORM, 40 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+SY+gad\H, gad\ScrollW, 1, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+SY+gad\H, 1, gad\ScrollH, 0								
					
						Color 0, 0, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW+gad\H, gad\ScrollW, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\MaxItems*gad\IH-gad\ScrollW-1+gad\H, gad\ScrollW, 1
	                    Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, 1, gad\MaxItems*gad\IH

						Color 0, 0, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\W, 2 + gad\MaxItems * gad\IH, 0
					Else
						gad\ScrollY = 0
					EndIf
					Color 0, 0, 0
					;Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H, gad\W, gad\H, 0
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateGroupBox( win.Window )

	gad.GroupBox = Last GroupBox
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntGroupBox
				
				;Drawing
				SetColor( SC_FORM,-40 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W, gad\H, 0
				SetColor( SC_FORM, 40 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				If gad\Caption > ""
					If gad\BG
						SetColor( SC_FORM )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+5+1, gad\Owner\Y+gad\Owner\FY+gad\Y-FontHeight()/2+1, StringWidth(gad\Caption)+8, FontHeight()
					EndIf
					SetColor( SC_FORMTEXT )
					Text gad\Owner\X+gad\Owner\FX+gad\X+9+1, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\Caption, 0, 1
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateImage( win.Window )

	gad.Image = Last Image
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				If MouseOver(	gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				;Drawing
				If gad\Image
					If gad\DrawMode = 0
						DrawImage gad\Image, gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y
					Else
						DrawBlock gad\Image, gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y
					EndIf
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateImageBox( win.Window )

	gad.ImageBox = Last ImageBox
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				If MouseOver(	gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin
					app\Event = EVENT_GADGET
					app\GadgetEvent = gad\ID
					app\GadgetEventData = Int(app\MX - gad\Owner\X - gad\Owner\FX - gad\X) + "/" + Int(app\MY - gad\Owner\Y - gad\Owner\FY - gad\Y)
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
			    ;Drawing
				If gad\Image DrawBlock gad\Image, gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y

				If gad\Border = 0
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				ElseIf gad\Border = 1
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateLabel( win.Window )

	gad.Label = Last Label
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntLabel
				Y = gad\Owner\Y+gad\Owner\FY+gad\Y
				W = 0
				
				gad\H = 0
				;Drawing
				SetColor( SC_FORMTEXT )
				For A = 0 To gad\Lines-1
					If gad\Align = 0
						Text gad\Owner\X+gad\Owner\FX+gad\X, Y, gad\Caption[A]
					ElseIf gad\Align = 1
						Text gad\Owner\X+gad\Owner\FX+gad\X, Y, gad\Caption[A], 1
					ElseIf gad\Align = 2
						Text gad\Owner\X+gad\Owner\FX+gad\X-StringWidth(gad\Caption[A]), Y, gad\Caption[A]
					EndIf
					If StringWidth(gad\Caption[A]) > W
						W = StringWidth(gad\Caption[A])
						gad\W = W
					EndIf
					Y = Y + FontHeight()
					gad\H = gad\H + FontHeight()
			    Next
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, W, Y-(gad\Owner\Y+gad\Owner\FY+gad\Y)) = True And NoActiveGadgets() And win = app\overWin
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateListBox( win.Window )

	gad.ListBox = Last ListBox
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntListBox
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
					If app\MB2 = 1
						gad\ActiveIndex = 0
					EndIf
				EndIf
				
				If gad\Disabled = True Valid = False
				
				;Drawing
				SetColor( SC_GADGET )
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				SetColor( SC_GADGET,-60 )
				If gad\SW > 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\SW, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-gad\SW, gad\H-1, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-gad\SW, gad\H-1, 0
				EndIf	
				If gad\SW > 0
					If gad\Disabled = True
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_GADGETSTRIP )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\SW-1, gad\H-2
					If gad\Disabled = True
						SetColor( SC_FORM,-100 )
					Else
						SetColor( SC_GADGETSTRIP,-40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\SW-1, gad\H, 0
					If gad\Disabled = True
						SetColor( SC_FORM,-20 )
					Else
						SetColor( SC_GADGETSTRIP, 40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\SW-1, 1, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H, 0
				EndIf
				
				Viewport gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				
				;List Items
				OverItem = False
				For A = 0 To gad\Count - 1
					If 1+A*gad\IH-gad\ScrollY < gad\H And 1+gad\IH+A*gad\IH-gad\ScrollY > 0
						If gad\Count > gad\CountVisible
							WOFF = gad\ScrollW + 1
						Else
							WOFF = 0
						EndIf
						
						If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+A*gad\IH-gad\ScrollY, gad\W-2-WOFF, gad\IH ) = True And MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
							OverItem = True
							If app\MB1 = 1
								gad\Active = True
								gad\ActiveIndex = A+1
							ElseIf app\MB1 = 2
								If gad\Active = True
									gad\ActiveIndex = A+1
								EndIf
							ElseIf app\MB1 = 0
								If gad\Active = True
									gad\Active = False
									If gad\ActiveIndex = A + 1
										app\Event = EVENT_GADGET
										app\GadgetEvent = gad\ID
										app\GadgetEventData = gad\Item[A]
									EndIf
								EndIf
							EndIf
						EndIf
												
						If gad\ActiveIndex-1 = A And gad\Disabled = False
							SetColor( SC_INPUTHILIGHT )
							Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+A*gad\IH-gad\ScrollY, gad\W-2-WOFF, gad\IH
							SetColor( SC_INPUTHILIGHT,-40 )
							Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+A*gad\IH-gad\ScrollY, gad\W-2-WOFF, gad\IH, 0
							SetColor( SC_INPUTHILIGHT, 40 )
							Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+A*gad\IH-gad\ScrollY, gad\W-2-WOFF, 1, 0
							Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+A*gad\IH-gad\ScrollY, 1, gad\IH, 0
							SetColor( SC_INPUTTEXTSEL )
						Else
							SetColor( SC_INPUTTEXT )
						EndIf
						If gad\Icon[A]
							DrawImage gad\Icon[A], gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SW/2, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\IH/2+A*gad\IH-gad\ScrollY
						EndIf
						If gad\Disabled = True
							SetColor( SC_INPUT,-60 )
						EndIf
						Text gad\Owner\X+gad\Owner\FX+gad\X+gad\SW+4, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Item[A], 0, 1
					EndIf
				Next
				Viewport 0, 0, app\W, app\H
				
				If OverItem = False
					If gad\Active = True
						gad\ActiveIndex = 0
						app\Event = EVENT_GADGET
						app\GadgetEvent = gad\ID
						app\GadgetEventData = ""
					EndIf
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W - WOFF, gad\H ) And NoActiveGadgets() And win = app\overWin And Valid = True
						If app\MB1 = 1
							gad\Active = False
							gad\ActiveIndex = 0
							app\Event = EVENT_GADGET
							app\GadgetEvent = gad\ID
							app\GadgetEventData = ""
						EndIf
					EndIf
				EndIf
				
				gad\RH = (gad\Count * gad\IH) - (gad\H - 2)
				
				If gad\Count > gad\CountVisible
				
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\ScrollW-1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW, 1, gad\H-2-gad\ScrollW*2, 0
				
					;Top Button
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						gad\TBState =-1
						If app\MB1 = 1
							gad\TBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\TBActive = True
								gad\TBState =-2
								If gad\Timer = 0
									If gad\ScrollY > 0
										gad\ScrollY = gad\ScrollY - gad\Inc
									EndIf
									If gad\ScrollY <= 0
										gad\ScrollY = 0
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\TBState = 0
					EndIf
					If app\MB1 = 0
						If gad\TBActive = True
							gad\TBActive = False
						EndIf
					EndIf
					
					If gad\TBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW, gad\ScrollW
					If gad\TBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF+1, 2, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF+1, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF+1, 6, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF, 2, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF, 6, 1
				
					;Bottom Button
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						gad\BBState =-1
						If app\MB1 = 1
							gad\BBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\BBActive = True
								gad\BBState =-2
								If gad\Timer = 0
									If gad\ScrollY < gad\RH
										gad\ScrollY = gad\ScrollY + gad\Inc
									EndIf
									If gad\ScrollY >= gad\RH
										gad\ScrollY = gad\RH
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\BBState = 0
					EndIf
					If app\MB1 = 0
						If gad\BBActive = True
							gad\BBActive = False
						EndIf
					EndIf
					
					If gad\BBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW
					If gad\BBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2-1+XOFF+1, 6, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+XOFF+1, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+1+XOFF+1, 2, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2-1+XOFF, 6, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+XOFF, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+1+XOFF, 2, 1
				
					;Scroll Bar
					SBS# = gad\H - 4 - gad\ScrollW*2
					gad\ScrollH = SBS - gad\Count
					If gad\ScrollH < 6 gad\ScrollH = 6
					SY# = Interpolate(gad\ScrollY, 0, gad\RH, 0, SBS-gad\ScrollH)
					
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW+2, gad\ScrollW, SBS
					
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							gad\SBActive = True
							gad\DragY = app\MY - (gad\Owner\Y+gad\Owner\FY+gad\Y+SY)
						EndIf
					EndIf
					If app\MB1 = 2
						If gad\SBActive = True
							SY = app\MY - gad\DragY - (gad\Owner\Y+gad\Owner\FY+gad\Y)
							If SY < 0 SY = 0
							If SY > SBS-gad\ScrollH SY = SBS-gad\ScrollH
							gad\ScrollY = Interpolate( SY, 0, SBS-gad\ScrollH, 0, gad\RH )
						EndIf
					ElseIf app\MB1 = 0
						If gad\SBActive = True
							gad\SBActive = False
						EndIf
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH, 0
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, 1, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, 1, gad\ScrollH, 0								
				
					Color 0, 0, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW, gad\ScrollW, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-2, gad\ScrollW, 1
                    Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				EndIf
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateProgressBar( win.Window )

	gad.ProgressBar = Last ProgressBar
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntProgressBar
				
				gad\Value = Interpolate( gad\Percent, 0, 100, 0, gad\W )
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				;Drawing
				SetColor( SC_FORM,-40 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
				
				SetColor( SC_GADGETSTRIP, 40 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\Value-2, gad\H-2, 0
				
				SetColor( SC_GADGETSTRIP,-40 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\Value-1, gad\H-1, 0
				
				SetColor( SC_GADGETSTRIP )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+2, gad\Owner\Y+gad\Owner\FY+gad\Y+2, gad\Value-4, gad\H-4
				
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				SetColor( SC_FORMTEXT )
				Text gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2, gad\Percent + "%", 1, 1
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateRadio( win.Window )

	gad.Radio = Last Radio
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntRadio
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				gad\W = FontHeight()+4+StringWidth(gad\Caption)
				gad\H = FontHeight()
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight()+4+StringWidth(gad\Caption), FontHeight() ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
					gad\State =-1
					If app\MB1 = 1
						gad\Active = True
					ElseIf app\MB1 = 2
						If gad\Active = True
							gad\State =-2
						EndIf
					ElseIf app\MB1 = 0
						If gad\Active = True
							gad\Active = False	
							For rad.Radio = Each Radio
								If rad\GroupID = gad\GroupID And rad <> gad
									rad\Checked = False
								EndIf
							Next
							gad\Checked = True
							app\Event = EVENT_GADGET
							app\GadgetEvent = gad\ID
						EndIf
					EndIf
				Else
					gad\State = 0
					If app\MB1 = 0
						If gad\Active = True
							gad\Active = False
						EndIf
					EndIf
				EndIf
				
				;Drawing
				If gad\Disabled = True
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_GADGETSTRIP )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight(), FontHeight()
				
				If gad\State =-2
					SetColor( SC_GADGETSTRIP,-60 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, FontHeight()-1, FontHeight()-1, 0
				EndIf
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, FontHeight(), FontHeight(), 0
				If gad\Checked = True
					If gad\State = 0
						If gad\Disabled = True
							SetColor( SC_FORM )
						Else
							SetColor( SC_GADGETSTRIPITEM )
						EndIf
					Else
						SetColor( SC_GADGETSTRIPITEM, 60 )
					EndIf
					If gad\State >-2
						Rect gad\Owner\X+gad\Owner\FX+gad\X+4, gad\Owner\Y+gad\Owner\FY+gad\Y+4, FontHeight()-8, FontHeight()-8
					Else
						Rect gad\Owner\X+gad\Owner\FX+gad\X+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+4+1, FontHeight()-8, FontHeight()-8
					EndIf
				EndIf
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Text gad\Owner\X+gad\Owner\FX+gad\X+FontHeight()+4+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\Caption
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_FORMTEXT )
				EndIf
				Text gad\Owner\X+gad\Owner\FX+gad\X+FontHeight()+4, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\Caption
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateScrollBar( win.Window )

	gad.ScrollBar = Last ScrollBar
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
				
				SetColor( SC_FORM,-40 )
				If gad\Dir = 0
					gad\SY = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
				Else
					gad\SX = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\W-1, 0
				EndIf
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
				    app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				If gad\Dir = 0
					W = gad\SW
					H = gad\H - 2
					X = gad\W-1-H
					Y = 1
				Else
					W = gad\H - 2
					H = gad\SW
					X = 1
					;Y = gad\W-1-H
					Y = gad\W-1-(gad\H-2)
				EndIf
				
				;Left/Top Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-2, gad\H-2 ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\LBState =-1
					If app\MB1 = 1
						gad\LBActive = True
					ElseIf app\MB1 = 2
						If gad\LBActive = True
							gad\LBState =-2
							If gad\Dir = 0
								If gad\SX > gad\H - 1
									gad\SX = gad\SX - 1
									gad\Value = Interpolate( gad\SX, gad\H - 1, gad\W - gad\H - gad\SW - 1, gad\Min, gad\Max)
									app\Event = EVENT_GADGET
									app\GadgetEvent = gad\ID
									If gad\Mode = 0
										app\GadgetEventData = Int(gad\Value)
									Else
										app\GadgetEventData = gad\Value
									EndIf
								EndIf
							Else
								If gad\SY > gad\H - 1
									gad\SY = gad\SY - 1
									gad\Value = Interpolate( gad\SY, gad\H - 1, gad\W - gad\H - gad\SW - 1, gad\Min, gad\Max)
									app\Event = EVENT_GADGET
									app\GadgetEvent = gad\ID
									If gad\Mode = 0
										app\GadgetEventData = Int(gad\Value)
									Else
										app\GadgetEventData = gad\Value
									EndIf
								EndIf
							EndIf
						EndIf
					ElseIf app\MB1 = 0
						If gad\LBActive = True
							gad\LBActive = False
						EndIf
					EndIf
				Else
					gad\LBState = 0
					If app\MB1 = 0
						If gad\LBActive = True
							gad\LBActive = False
						EndIf
					EndIf
				EndIf
				
				;Right/Bottom Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+X, gad\Owner\Y+gad\Owner\FY+gad\Y+Y, gad\H-2, gad\H-2 ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\RBState =-1
					If app\MB1 = 1
						gad\RBActive = True
					ElseIf app\MB1 = 2
						If gad\RBActive = True
							gad\RBState =-2
							If gad\Dir = 0
								If gad\SX < gad\W - gad\H - gad\SW - 1
									gad\SX = gad\SX + 1
									gad\Value = Interpolate( gad\SX, gad\H - 1, gad\W - gad\H - gad\SW - 1, gad\Min, gad\Max)
									app\Event = EVENT_GADGET
									app\GadgetEvent = gad\ID
									If gad\Mode = 0
										app\GadgetEventData = Int(gad\Value)
									Else
										app\GadgetEventData = gad\Value
									EndIf
								EndIf
							Else
								If gad\SY < gad\W - gad\H - gad\SW - 1
									gad\SY = gad\SY + 1
									gad\Value = Interpolate( gad\SY, gad\H - 1, gad\W - gad\H - gad\SW - 1, gad\Min, gad\Max)
									app\Event = EVENT_GADGET
									app\GadgetEvent = gad\ID
									If gad\Mode = 0
										app\GadgetEventData = Int(gad\Value)
									Else
										app\GadgetEventData = gad\Value
									EndIf
								EndIf
							EndIf
						EndIf
					ElseIf app\MB1 = 0
						If gad\RBActive = True
							gad\RBActive = False
						EndIf
					EndIf
				Else
					gad\RBState = 0
					If app\MB1 = 0
						If gad\RBActive = True
							gad\RBActive = False
						EndIf
					EndIf
				EndIf				
				
				;Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, W, H ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\BState =-1
					If app\MB1 = 1
						gad\BActive = True
						gad\DragX = app\MX - gad\SX
						gad\DragY = app\MY - gad\SY
					EndIf
				EndIf
				
				If app\MB1 = 2
					If gad\BActive = True
						gad\BState =-2
						If gad\Dir = 0
							gad\SX = app\MX - gad\DragX
							If gad\SX < gad\H-1 gad\SX = gad\H-1
							If gad\SX > gad\W - gad\H - 1 - gad\SW gad\SX = gad\W - gad\H - 1 - gad\SW
							gad\Value = Interpolate( gad\SX, gad\H-1, gad\W - gad\H-1-gad\SW, gad\Min, gad\Max )
						Else
							gad\SY = app\MY - gad\DragY
							If gad\SY < gad\H-1 gad\SY = gad\H-1
							If gad\SY > gad\W - gad\H - 1 - gad\SW gad\SY = gad\W - gad\H - 1 - gad\SW
							gad\Value = Interpolate( gad\SY, gad\H-1, gad\W - gad\H-1-gad\SW, gad\Min, gad\Max )
						EndIf
						app\Event = EVENT_GADGET
						app\GadgetEvent = gad\ID
						If gad\Mode = 0
							app\GadgetEventData = Int(gad\Value)
						Else
							app\GadgetEventData = gad\Value
						EndIf
						If Mode = 0 gad\Value = Int(gad\Value)	
						app\Event = EVENT_GADGET
						app\GadgetEvent = gad\ID
						app\GadgetEventData = gad\Value
					EndIf
				ElseIf app\MB1 = 0
					If gad\BActive = True
						gad\BActive = False
					EndIf
				EndIf
				
				If gad\BState >-2
					SetColor( SC_FORM, 40 )
					XOFF = 0
				Else
					SetColor( SC_FORM,-40 )
					XOFF = 1
				EndIf
				
				;Left/Top Button
				Color 0, 0, 0
				If gad\LBState >-2
					XOFF = 0
					SetColor( SC_FORM, 40 )
				Else
					XOFF = 1
					SetColor( SC_FORM,-40 )
				EndIf
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\H-1, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\H-1, 0
				EndIf
				
				Color 0, 0, 0
				If gad\Dir = 0
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF+1, 1, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF+1, 1, 3
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-0+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-3+XOFF+1, 1, 5
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF, 1, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF, 1, 3
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-0+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-3+XOFF, 1, 5
				Else
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF+1, 1, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF+1, 3, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-3+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-0+XOFF+1, 5, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF, 1, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF, 3, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-3+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-0+XOFF, 5, 1
				EndIf
				
				;Right/Bottom Button
				Color 0, 0, 0
				If gad\RBState >-2
					XOFF = 0
					SetColor( SC_FORM, 40 )
				Else
					XOFF = 1
					SetColor( SC_FORM,-40 )
				EndIf
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\H-1, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-1-(gad\H-2), gad\H-1, gad\H-1, 0
				EndIf
				
				Color 0, 0, 0
				If gad\Dir = 0
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-0+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF+1, 1, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF+1, 1, 3
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-3+XOFF+1, 1, 5
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-0+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-1+XOFF, 1, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-2+XOFF, 1, 3
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-1-H+gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2-3+XOFF, 1, 5
				Else
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-0+XOFF+1, 1, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-1+XOFF+1, 3, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-3+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-2+XOFF+1, 5, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-0+XOFF, 1, 1

					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-1+XOFF, 3, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\H/2-3+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H/2-2+XOFF, 5, 1
				EndIf
				
				;Button
				SetColor( SC_FORM )
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\SW, gad\H-2
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, gad\SW
				EndIf
				
				SetColor( SC_FORM,-40 )
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\SW, gad\H-2, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, gad\SW, 0
				EndIf
				SetColor( SC_FORM, 40 )
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\SW, 1, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, 1, gad\H-2, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, 1, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, 1, gad\SW, 0
				EndIf
					
				;Border
				Color 0, 0, 0
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\H-1, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\H, gad\W, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-1, gad\H, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\W-gad\H, gad\H, 1
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateSlider( win.Window )

	gad.Slider = Last Slider
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
				
				If gad\SR = gad\ER And gad\SG = gad\EG And gad\SB = gad\EB
					Color gad\SR, gad\SG, gad\SB
					If gad\Dir = 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
					Else
						Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\H, gad\W
					EndIf
				Else
					For A = 1 To gad\W-2 Step 5
						NR = Interpolate( A, 1, gad\W-2, gad\SR, gad\ER )
						NG = Interpolate( A, 1, gad\W-2, gad\SG, gad\EG )
						NB = Interpolate( A, 1, gad\W-2, gad\SB, gad\EB )
						Color NR, NG, NB
						If gad\Dir = 0
							If A+5 < gad\W-2
								Rect gad\Owner\X+gad\Owner\FX+gad\X+A, gad\Owner\Y+gad\Owner\FY+gad\Y+1, 5, gad\H-2
							Else
								Rect gad\Owner\X+gad\Owner\FX+gad\X+A, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-2-A+1, gad\H-2
							EndIf
						Else
							If A+5 < gad\W-2
								Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+A, gad\H-2, 5
							Else
								Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+A, gad\H-2, gad\W-2-A+1
							EndIf
						EndIf
					Next
				EndIf
				
				SetColor( SC_FORM,-40 )
				If gad\Dir = 0
					gad\SY = 0
					If gad\SR <> gad\ER And gad\SG <> gad\EG And gad\SB <> gad\EB
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
					EndIf
				Else
					gad\SX = 0
					If gad\SR <> gad\ER And gad\SG <> gad\EG And gad\SB <> gad\EB
						Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, gad\W-1, 0
					EndIf
				EndIf
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
				    app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				;Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, gad\H-2 ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
					gad\BState =-1
					If app\MB1 = 1
						gad\BActive = True
						gad\DragX = app\MX - gad\SX
						gad\DragY = app\MY - gad\SY
					EndIf
				EndIf
				
				If app\MB1 = 2
					If gad\BActive = True
						gad\BState =-2
						If gad\Dir = 0
							gad\SX = app\MX - gad\DragX
							If gad\SX < 0 gad\SX = 0
							If gad\SX > gad\W - (gad\H-2) - 2 gad\SX = gad\W - (gad\H-2) - 2
							gad\Value = Interpolate( gad\SX, 0, gad\W - (gad\H-2)-2, gad\Min, gad\Max )
						Else
							gad\SY = app\MY - gad\DragY
							If gad\SY < 0 gad\SY = 0
							If gad\SY > gad\W - (gad\H-2) - 2 gad\SY = gad\W - (gad\H-2) - 2
							gad\Value = Interpolate( gad\SY, 0, gad\W - (gad\H-2)-2, gad\Min, gad\Max )
						EndIf
						If Mode = 0 gad\Value = Int(gad\Value)	
						app\Event = EVENT_GADGET
						app\GadgetEvent = gad\ID
						app\GadgetEventData = gad\Value
					EndIf
				ElseIf app\MB1 = 0
					If gad\BActive = True
						gad\BActive = False
					EndIf
				EndIf
				
				If gad\BState >-2
					SetColor( SC_FORM, 40 )
					XOFF = 0
				Else
					SetColor( SC_FORM,-40 )
					XOFF = 1
				EndIf
				
				;Button
				If gad\Disabled = True
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_GADGETSTRIP )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, gad\H-2
				
				If gad\Disabled = True
					SetColor( SC_FORM,-100 )
				Else
					SetColor( SC_GADGETSTRIP,-40 )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, gad\H-2, 0
				
				If gad\Disabled = True
					SetColor( SC_FORM,-20 )
				Else
					SetColor( SC_GADGETSTRIP, 40 )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, gad\H-2, 1, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1+gad\SX, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\SY, 1, gad\H-2, 0
				
				;Border
				Color 0, 0, 0
				If gad\Dir = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\H, gad\W, 0
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateSpinner( win.Window )

	gad.Spinner = Last Spinner
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntSpinner
				
				;Button Height
				If gad\H Mod 2 = 0
					BH = gad\H/2-1
				Else
					BH = gad\H/2
				EndIf
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				If gad\Disabled = True Valid = False
				
				;Drawing
				If gad\ButtonsOnly = False
					SetColor( SC_INPUT )
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W-gad\H, gad\H
				
					SetColor( SC_INPUT,-80 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-gad\H, gad\H-1, 0
				
				
					If gad\Disabled = True
						SetColor( SC_INPUT,-60 )
					Else
						SetColor( SC_INPUTTEXT )
					EndIf
					
					If gad\Mode = 0
						Text gad\Owner\X+gad\Owner\FX+gad\X+2+4, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2, Int(gad\Value), 0, 1
				    Else
				    	Text gad\Owner\X+gad\Owner\FX+gad\X+2+4, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2, gad\Value, 0, 1
				    EndIf
				EndIf
				
				;Top Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-2, BH-1 ) And NoActiveGadgets() = True And win = First Window And Valid = True
					gad\TBState =-1
					If app\MB1 = 1
						gad\TBActive = True
						gad\Timer = 0
						gad\TimerInc = 15
					ElseIf app\MB1 = 2
						If gad\TBActive = True
							gad\TBState =-2
							If gad\Timer = 0
								If gad\Mode = 0
									If Int(gad\Value) < Int(gad\Max)
										gad\Value = Int(gad\Value) + Int(gad\Inc)
									EndIf
								Else
									If gad\Value < gad\Max
										gad\Value = gad\Value + gad\Inc
									EndIf
									gad\Value = Left( gad\Value, Instr(gad\Value, ".") + Len( Mid(gad\Inc, Instr(gad\Inc, ".")+1) ) )
								EndIf
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
								If gad\Mode = 0
									app\GadgetEventData = Int(gad\Value)
								Else
									app\GadgetEventData = gad\Value
								EndIf
							EndIf
							gad\Timer = gad\Timer + 1
							If gad\Timer > gad\TimerInc
								gad\Timer = 0
								If gad\TimerInc > 0
									gad\TimerInc = gad\TimerInc - 1
								EndIf
							EndIf
						EndIf
					ElseIf app\MB1 = 0
						If gad\TBActive = True
							gad\TBActive = False
						EndIf
					EndIf
				Else
					gad\TBState = 0
					If app\MB1 = 0
						If gad\TBActive = True
							gad\TBActive = False
						EndIf
					EndIf
				EndIf
				If gad\TBState >-2
					SetColor( SC_FORM, 40 )
					XOFF = 0
				Else
					SetColor( SC_FORM,-40 )
					XOFF = 1
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\H-1, BH, 0
				
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2-1+XOFF+1, 2, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2+XOFF+1, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2+1+XOFF+1, 6, 1
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_FORMTEXT )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2-1+XOFF, 2, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2+XOFF, 4, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+BH/2+1+XOFF, 6, 1
				
				;Bottom Button
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2, gad\H-2, BH-1 ) And NoActiveGadgets() = True And win = First Window And Valid = True
					gad\BBState =-1
					If app\MB1 = 1
						gad\BBActive = True
						gad\Timer = 0
						gad\TimerInc = 15
					ElseIf app\MB1 = 2
						If gad\BBActive = True
							gad\BBState =-2
							If gad\Timer = 0
								If gad\Mode = 0
									If Int(gad\Value) > Int(gad\Min)
										gad\Value = Int(gad\Value) - Int(gad\Inc)
									EndIf
								Else
									If gad\Value > gad\Min
										gad\Value = gad\Value - gad\Inc
									EndIf
									gad\Value = Left( gad\Value, Instr(gad\Value, ".") + Len( Mid(gad\Inc, Instr(gad\Inc, ".")+1) ) )
								EndIf
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
								If gad\Mode = 0
									app\GadgetEventData = Int(gad\Value)
								Else
									app\GadgetEventData = gad\Value
								EndIf
							EndIf
							gad\Timer = gad\Timer + 1
							If gad\Timer > gad\TimerInc
								gad\Timer = 0
								If gad\TimerInc > 0
									gad\TimerInc = gad\TimerInc - 1
								EndIf
							EndIf
						EndIf
					ElseIf app\MB1 = 0
						If gad\BBActive = True
							gad\BBActive = False
						EndIf
					EndIf
				Else
					gad\BBState = 0
					If app\MB1 = 0
						If gad\BBActive = True
							gad\BBActive = False
						EndIf
					EndIf
				EndIf
				If gad\BBState >-2
					SetColor( SC_FORM, 40 )
					XOFF = 0
				Else
					SetColor( SC_FORM,-40 )
					XOFF = 1
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\H/2, gad\H-1, BH, 0
				
				If gad\Disabled = True
					SetColor( SC_FORM, 60 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2+1+XOFF+1, 2, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2+XOFF+1, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2-1+XOFF+1, 6, 1
					SetColor( SC_FORM,-60 )
				Else
					SetColor( SC_FORMTEXT )
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2+1+XOFF, 2, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2+XOFF, 4, 1
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H/2-3+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2+BH/2-1+XOFF, 6, 1
				
				;Border
				Color 0, 0, 0
				If gad\ButtonsOnly = False
					Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\H, gad\H, 0
				EndIf
				Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				If gad\H Mod 2 = 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2-1, gad\H, 2
				Else
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\H, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H/2, gad\H, 1
				EndIf
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateTextBox( win.Window )

	gad.TextBox = Last TextBox
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntTextBox
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin And Valid = True
					If gad\Disabled = False app\MCurrent = app\MIBeam
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				If gad\Disabled = True Valid = False
				
				;Drawing
				If gad\MultiLine = False
					TempIH = gad\IH
					gad\IH = gad\H - 3
				EndIf
				
				SetColor( SC_INPUT )
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				SetColor( SC_INPUT,-80 )
				Rect gad\Owner\X+gad\Owner\FX+gad\X+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\W-1, gad\H-1, 0
				
				gad\RH = (gad\LineCount * gad\IH) - (gad\H - 3)
				
				If gad\LineCount > gad\LineCountVisible And gad\H > gad\ScrollW*2 + 4 + 10
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-gad\ScrollW-1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW, 1, gad\H-2-gad\ScrollW*2, 0
					
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW, gad\H ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						app\MCurrent = app\MArrow
					EndIf
					
					;Top Button				
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						gad\TBState =-1
						If app\MB1 = 1
							gad\TBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\TBActive = True
								gad\TBState =-2
								If gad\Timer = 0
									If gad\ScrollY > 0
										gad\ScrollY = gad\ScrollY - gad\Inc
									EndIf
									If gad\ScrollY <= 0
										gad\ScrollY = 0
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\TBState = 0
					EndIf
					If app\MB1 = 0
						If gad\TBActive = True
							gad\TBActive = False
						EndIf
					EndIf
					
					If gad\TBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW, gad\ScrollW
					If gad\TBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF+1, 2, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF+1, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF+1, 6, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+XOFF, 2, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+1+XOFF, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW/2+2+XOFF, 6, 1
				
					;Bottom Button
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						gad\BBState =-1
						If app\MB1 = 1
							gad\BBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\BBActive = True
								gad\BBState =-2
								If gad\Timer = 0
									If gad\ScrollY < gad\RH
										gad\ScrollY = gad\ScrollY + gad\Inc
									EndIf
									If gad\ScrollY >= gad\RH
										gad\ScrollY = gad\RH
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\BBState = 0
					EndIf
					If app\MB1 = 0
						If gad\BBActive = True
							gad\BBActive = False
						EndIf
					EndIf
					
					If gad\BBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW
					If gad\BBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					If gad\Disabled = True
						SetColor( SC_FORM, 60 )
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2-1+XOFF+1, 6, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+XOFF+1, 4, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+1+XOFF+1, 2, 1
						SetColor( SC_FORM,-60 )
					Else
						SetColor( SC_FORMTEXT )
					EndIf
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2-1+XOFF, 6, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+XOFF, 4, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-2-gad\ScrollW/2+1+XOFF, 2, 1
					
					;Scroll Bar
					If gad\ScrollY > gad\RH gad\ScrollY = gad\RH
					SBS# = gad\H - 4 - gad\ScrollW*2
					gad\ScrollH = SBS - gad\LineCount
					If gad\ScrollH < 6 gad\ScrollH = 6
					SY# = Interpolate(gad\ScrollY, 0, gad\RH, 0, SBS-gad\ScrollH)
					
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\ScrollW+2, gad\ScrollW, SBS
					
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							gad\SBActive = True
							gad\DragY = app\MY - (gad\Owner\Y+gad\Owner\FY+gad\Y+SY)
						EndIf
					EndIf
					If app\MB1 = 2
						If gad\SBActive = True
							SY = app\MY - gad\DragY - (gad\Owner\Y+gad\Owner\FY+gad\Y)
							If SY < 0 SY = 0
							If SY > SBS-gad\ScrollH SY = SBS-gad\ScrollH
							gad\ScrollY = Interpolate( SY, 0.0, SBS-gad\ScrollH, 0.0, gad\RH )
						EndIf
					ElseIf app\MB1 = 0
						If gad\SBActive = True
							gad\SBActive = False
						EndIf
					EndIf
					
					SetColor( SC_FORM )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH
					SetColor( SC_FORM,-40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH, 0
					SetColor( SC_FORM, 40 )
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, 1, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW+1+SY, 1, gad\ScrollH, 0								
				
					Color 0, 0, 0
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+1+gad\ScrollW, gad\ScrollW, 1
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW+1, gad\Owner\Y+gad\Owner\FY+gad\Y+gad\H-gad\ScrollW-2, gad\ScrollW, 1
                    Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W-2-gad\ScrollW, gad\Owner\Y+gad\Owner\FY+gad\Y, 1, gad\H
				
					Viewport gad\Owner\X+gad\Owner\FX+gad\X+3, gad\Owner\Y+gad\Owner\FY+gad\Y+3, gad\W-gad\ScrollW-6, gad\H-5	
				
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+2, gad\Owner\Y+gad\Owner\FY+gad\Y+2, gad\W-gad\ScrollW-4, gad\H-3 ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							FlushKeys
							gad\Active = True
							gad\CursorTimer = 0
						EndIf
					Else
						If app\MB1 = 1
							If gad\Active = True
								gad\Active = False
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
								If gad\MultiLine = False
									app\GadgetEventData = gad\Caption[0]
								EndIf
							EndIf
						EndIf
					EndIf
					WOFF = gad\ScrollW - 1
				Else
					WOFF = 0
					gad\ScrollY = 0
					
					Viewport gad\Owner\X+gad\Owner\FX+gad\X+3, gad\Owner\Y+gad\Owner\FY+gad\Y+3, gad\W-5, gad\H-5	
				
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+2, gad\Owner\Y+gad\Owner\FY+gad\Y+2, gad\W-3, gad\H-3 ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							FlushKeys
							gad\Active = True
							gad\CursorTimer = 0
						ElseIf app\MB1 = 0
							If gad\SActive = True gad\SActive = False
						EndIf
					Else
						If app\MB1 = 1
							If gad\Active = True
								gad\Active = False
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
								If gad\MultiLine = False
									app\GadgetEventData = gad\Caption[0]
								EndIf
							EndIf
						ElseIf app\MB1 = 0
							If gad\SActive = True gad\SActive = False
						EndIf
					EndIf
				EndIf

				If gad\DCTimer > 0 gad\DCTimer = gad\DCTimer - 1
				
				For A = 0 To gad\LineCount - 1
					If (A+1)*gad\IH-gad\ScrollY >= 0 And (A+1)*gad\IH-gad\ScrollY <= gad\H
					If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X+2, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, gad\W-4-WOFF, gad\IH ) And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							gad\SActive = True
							gad\CursorTimer = 0
							If gad\DCTimer = 0
								gad\DClick = False
								gad\DCTimer = 30
							Else
								gad\DClick = True
								gad\DCTimer = 0
							EndIf
							XOFF = app\MX - (gad\Owner\X+gad\Owner\FX+gad\X+2-gad\ScrollX)
							gad\SelStart =-1
							gad\SelEnd =-1
							For B = 0 To Len(gad\Caption[A])
								WID = StringWidth( Left(gad\Caption[A], B) )
								If WID > XOFF
									If B > 0
										If WID - XOFF < XOFF - StringWidth( Left(gad\Caption[A], B-1) )
											gad\SelStart = B
											gad\SelEnd = B
										Else
											gad\SelStart = B - 1
											gad\SelEnd = B - 1
										EndIf
									Else
										gad\SelStart = B
										gad\SelEnd = B
									EndIf
									gad\LineStart = A
									gad\LineEnd = A
									Exit
								EndIf
							Next
							If gad\SelStart =-1
								gad\LineStart = A
								gad\LineEnd = A
								gad\SelStart = Len(gad\Caption[gad\LineStart])
								gad\SelEnd = gad\SelStart
							EndIf
						ElseIf app\MB1 = 2
							If gad\SActive = True
								XOFF = app\MX - (gad\Owner\X+gad\Owner\FX+gad\X+2-gad\ScrollX)
								gad\SelStart =-1
								For B = 0 To Len(gad\Caption[A])
									WID = StringWidth( Left(gad\Caption[A], B) )
									If WID > XOFF
										If B > 0
											If WID - XOFF < XOFF - StringWidth( Left(gad\Caption[A], B-1) )
												gad\SelStart = B
											Else
												gad\SelStart = B - 1
											EndIf
										Else
											gad\SelStart = B
										EndIf
										If app\MX > gad\Owner\X + gad\Owner\FX + gad\X + gad\W - 10
											If gad\ScrollX < StringWidth(gad\Caption[A])+6-gad\W
												gad\ScrollX = gad\ScrollX + 2
											Else
												gad\ScrollX = StringWidth(gad\Caption[A])+6-gad\W
											EndIf
										ElseIf app\MX < gad\Owner\X + gad\Owner\FX + gad\X + 10
											If gad\ScrollX > 0
												gad\ScrollX = gad\ScrollX - 2
											Else
												gad\ScrollX = 0
											EndIf
										EndIf
										gad\LineStart = A
										Exit
									EndIf
								Next
								If gad\SelStart =-1
									gad\LineStart = A
									gad\SelStart = Len(gad\Caption[gad\LineStart])
								EndIf	
							EndIf
						ElseIf app\MB1 = 0
							If gad\SActive = True
								gad\SActive = False
							EndIf
							If gad\DClick = True
								gad\DClick = False
								If gad\MultiLine = True
									gad\SelStart = 0
									gad\SelEnd = Len( gad\Caption[gad\LineCount] )
									gad\LineStart = 0
									gad\LineEnd = gad\LineCount - 1
								Else
									gad\SelStart = 0
									gad\SelEnd = Len( gad\Caption[0] )
									gad\LineStart = 0
									gad\LineEnd = 0
								EndIf
							EndIf
						EndIf
					EndIf
					
					If gad\LineStart = A
						If gad\LineEnd = gad\LineStart
							If gad\SelEnd > gad\SelStart
								If gad\Disabled = True
									SetColor( SC_INPUT,-60 )
								Else
									SetColor( SC_INPUTTEXT )
								EndIf
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelStart), 0, 1
				        		Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelEnd+1), 0, 1
								SetColor( SC_INPUTHILIGHT )
								Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Mid(gad\Caption[A], gad\SelStart+1, gad\SelEnd-gad\SelStart)), gad\IH
								SetColor( SC_INPUTTEXTSEL )
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelStart+1, gad\SelEnd-gad\SelStart), 0, 1
							Else
								If gad\Disabled = True
									SetColor( SC_INPUT,-60 )
								Else
									SetColor( SC_INPUTTEXT )
								EndIf
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelEnd), 0, 1
				        		Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelStart+1), 0, 1
								SetColor( SC_INPUTHILIGHT )
								Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Mid(gad\Caption[A], gad\SelEnd+1, gad\SelStart-gad\SelEnd)), gad\IH
								SetColor( SC_INPUTTEXTSEL )
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelEnd+1, gad\SelStart-gad\SelEnd), 0, 1
							EndIf
						ElseIf gad\LineEnd > gad\LineStart
							If gad\Disabled = True
								SetColor( SC_INPUT,-60 )
							Else
								SetColor( SC_INPUTTEXT )
							EndIf
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelStart), 0, 1
				        	SetColor( SC_INPUTHILIGHT )
				        	Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Mid(gad\Caption[A], gad\SelStart+1)), gad\IH
							SetColor( SC_INPUTTEXTSEL )
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelStart+1), 0, 1
						ElseIf gad\LineEnd < gad\LineStart
							If gad\Disabled = True
								SetColor( SC_INPUT,-60 )
							Else
								SetColor( SC_INPUTTEXT )
							EndIf
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelStart+1), 0, 1
				        	SetColor( SC_INPUTHILIGHT )
				        	Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Left(gad\Caption[A], gad\SelStart)), gad\IH
							SetColor( SC_INPUTTEXTSEL )
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelStart), 0, 1
						EndIf
					ElseIf gad\LineEnd = A
						If gad\LineEnd > gad\LineStart
							If gad\Disabled = True
								SetColor( SC_INPUT,-60 )
							Else
								SetColor( SC_INPUTTEXT )
							EndIf
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelEnd+1), 0, 1
				        	SetColor( SC_INPUTHILIGHT )
				        	Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Left(gad\Caption[A], gad\SelEnd)), gad\IH
							SetColor( SC_INPUTTEXTSEL )
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelEnd), 0, 1
						ElseIf gad\LineEnd < gad\LineStart
							If gad\Disabled = True
								SetColor( SC_INPUT,-60 )
							Else
								SetColor( SC_INPUTTEXT )
							EndIf
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Left(gad\Caption[A], gad\SelEnd), 0, 1
				        	SetColor( SC_INPUTHILIGHT )
				        	Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(Mid(gad\Caption[A], gad\SelEnd+1)), gad\IH
							SetColor( SC_INPUTTEXTSEL )
							Text gad\Owner\X+gad\Owner\FX+gad\X+2+2+StringWidth(Left(gad\Caption[A], gad\SelEnd))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, Mid(gad\Caption[A], gad\SelEnd+1), 0, 1
						EndIf
					Else
						If gad\LineEnd > gad\LineStart
							If A > gad\LineStart And A < gad\LineEnd
								SetColor( SC_INPUTHILIGHT )
								Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(gad\Caption[A]), gad\IH
								SetColor( SC_INPUTTEXTSEL )
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Caption[A], 0, 1
				    		Else
				    			If gad\Disabled = True
									SetColor( SC_INPUT,-60 )
								Else
									SetColor( SC_INPUTTEXT )
								EndIf
				    			Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Caption[A], 0, 1
							EndIf
						ElseIf gad\LineEnd < gad\LineStart
							If A > gad\LineEnd And A < gad\LineStart
								SetColor( SC_INPUTHILIGHT )
								Rect gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+A*gad\IH-gad\ScrollY, StringWidth(gad\Caption[A]), gad\IH
								SetColor( SC_INPUTTEXTSEL )
								Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Caption[A], 0, 1
				    		Else
				    			If gad\Disabled = True
									SetColor( SC_INPUT,-60 )
								Else
									SetColor( SC_INPUTTEXT )
								EndIf
				    			Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Caption[A], 0, 1
							EndIf
						Else
							If gad\Disabled = True
								SetColor( SC_INPUT,-60 )
							Else
								SetColor( SC_INPUTTEXT )
							EndIf
				    		Text gad\Owner\X+gad\Owner\FX+gad\X+2+2-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\IH/2+A*gad\IH-gad\ScrollY, gad\Caption[A], 0, 1
				    	EndIf
					EndIf
					EndIf
				Next
				
				If gad\Active = True
					gad\CursorTimer = gad\CursorTimer + 1
					If gad\CursorTimer < 30
						Color 0, 0, 0
						Rect gad\Owner\X+gad\Owner\FX+gad\X+2+1+StringWidth(Left(gad\Caption[gad\LineStart], gad\SelStart))-gad\ScrollX, gad\Owner\Y+gad\Owner\FY+gad\Y+2+gad\LineStart*gad\IH+2-gad\ScrollY, 1, gad\IH-4
					EndIf
					If gad\CursorTimer > 60 gad\CursorTimer = 0
				
					If gad\MultiLine = False
						If gad\SActive = False
;							if app\MX > gad\Owner\X + gad\Owner\FX + gad\X + gad\W - 10
;								if gad\ScrollX < stringwidth(gad\Caption[A])+5-gad\W
;									gad\ScrollX = gad\ScrollX + 2
;								else
;									gad\ScrollX = stringwidth(gad\Caption[A])+5-gad\W
;								endif
;							elseif app\MX < gad\Owner\X + gad\Owner\FX + gad\X + 10
;								if gad\ScrollX > 0
;									gad\ScrollX = gad\ScrollX - 2
;								else
;									gad\ScrollX = 0
;								endif
;							endif
						EndIf
					Else
						gad\ScrollX = 0
					EndIf
					
					;Input
					gad\Key = GetKey()
					If gad\Key = 0
						Select True
							Case KeyHit(71) gad\Key = Asc("7")
							Case KeyHit(72) gad\Key = Asc("8")
							Case KeyHit(73) gad\Key = Asc("9")
							Case KeyHit(75) gad\Key = Asc("4")
							Case KeyHit(76) gad\Key = Asc("5")
							Case KeyHit(77) gad\Key = Asc("6")
							Case KeyHit(79) gad\Key = Asc("1")
							Case KeyHit(80) gad\Key = Asc("2")
							Case KeyHit(81) gad\Key = Asc("3")
							Case KeyHit(82) gad\Key = Asc("0")
							Case KeyHit(83) gad\Key = Asc(".")
						End Select
					EndIf
					
					gad\KeyTimer = gad\KeyTimer + 1
					If gad\KeyTimer > 12
						If KeyDown(14) gad\Key = 8
						If KeyDown(28) gad\Key = 13
						If KeyDown(211) gad\Key = 4
						If KeyDown(200) gad\Key = 28
						If KeyDown(208) gad\Key = 29
						If KeyDown(205) gad\Key = 30
						If KeyDown(203) gad\Key = 31
						If KeyDown(57) gad\Key = 32
						gad\KeyTimer = 0
					EndIf
				
					If gad\Key <> 0 And app\actMenu = Null And NoActiveGadgets()
						gad\KeyTimer = 0
						gad\CursorTimer = 0
						
						;Alpha
						If (gad\Key>96 And gad\Key<123) Or (gad\Key>64 And gad\Key<91) Or gad\Key=32 Or gad\Key = 46 And gad\Mode = 0
			        		If gad\LineStart = gad\LineEnd
								If gad\SelStart < gad\SelEnd
									StartPos = gad\SelStart
									EndPos = gad\SelEnd
								Else
									StartPos = gad\SelEnd
									EndPos = gad\SelStart
								EndIf
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
								gad\LineEnd = gad\LineStart
							    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
							ElseIf gad\LineStart < gad\LineEnd
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
								gad\Caption[gad\LineEnd] = ""
								For A = gad\LineStart+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
									gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
								gad\LineEnd = gad\LineStart
							    gad\SelEnd = gad\SelStart
							Else
								gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\Caption[gad\LineStart] = ""
								For A = gad\LineEnd+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
									gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
								gad\LineStart = gad\LineEnd
							    gad\SelStart = gad\SelEnd
							EndIf
							gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Chr(gad\Key) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
							gad\SelStart = gad\SelStart + 1
							gad\SelEnd = gad\SelStart
							gad\LineEnd = gad\LineStart
							If gad\MultiLine = False
								LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
								If LineLen > gad\W - 6
									gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
								ElseIf LineLen < 0
									gad\ScrollX = (LineLen+gad\ScrollX)
								EndIf
							EndIf
						;Minus
						ElseIf gad\Key = 45 And gad\Mode > 0
							If gad\SelStart = 0
								If gad\LineStart = gad\LineEnd
									If gad\SelStart < gad\SelEnd
										StartPos = gad\SelStart
										EndPos = gad\SelEnd
									Else
										StartPos = gad\SelEnd
										EndPos = gad\SelStart
									EndIf
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
									gad\LineEnd = gad\LineStart
								    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
								ElseIf gad\LineStart < gad\LineEnd
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
									gad\Caption[gad\LineEnd] = ""
									For A = gad\LineStart+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
										gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
									gad\LineEnd = gad\LineStart
								    gad\SelEnd = gad\SelStart
								Else
									gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\Caption[gad\LineStart] = ""
									For A = gad\LineEnd+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
										gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
									gad\LineStart = gad\LineEnd
								    gad\SelStart = gad\SelEnd
								EndIf
								gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Chr(gad\Key) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\SelStart = gad\SelStart + 1
								gad\SelEnd = gad\SelStart
								gad\LineEnd = gad\LineStart
								If gad\MultiLine = False
									LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
									If LineLen > gad\W - 6
										gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
									ElseIf LineLen < 0
										gad\ScrollX = (LineLen+gad\ScrollX)
									EndIf
								EndIf
							EndIf
						;Numeric
						ElseIf (gad\Key>47 And gad\Key<58) Or (gad\Key>70 And gad\Key<74) Or (gad\Key>74 And gad\Key<78) Or (gad\Key>78 And gad\Key<83)
							If gad\LineStart = gad\LineEnd
								If gad\SelStart < gad\SelEnd
									StartPos = gad\SelStart
									EndPos = gad\SelEnd
								Else
									StartPos = gad\SelEnd
									EndPos = gad\SelStart
								EndIf
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
								gad\LineEnd = gad\LineStart
							    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
							ElseIf gad\LineStart < gad\LineEnd
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
								gad\Caption[gad\LineEnd] = ""
								For A = gad\LineStart+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
									gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
								gad\LineEnd = gad\LineStart
							    gad\SelEnd = gad\SelStart
							Else
								gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\Caption[gad\LineStart] = ""
								For A = gad\LineEnd+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
									gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
								gad\LineStart = gad\LineEnd
							    gad\SelStart = gad\SelEnd
							EndIf
							gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Chr(gad\Key) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
							gad\SelStart = gad\SelStart + 1
							gad\SelEnd = gad\SelStart
							gad\LineEnd = gad\LineStart
							If gad\MultiLine = False
								LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
								If LineLen > gad\W - 6
									gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
								ElseIf LineLen < 0
									gad\ScrollX = (LineLen+gad\ScrollX)
								EndIf
							EndIf
						;Float
						ElseIf (gad\Key=46 Or gad\Key = 83) And gad\Mode = 2
							If Instr(gad\Caption[gad\LineStart], ".") = 0
								If gad\LineStart = gad\LineEnd
									If gad\SelStart < gad\SelEnd
										StartPos = gad\SelStart
										EndPos = gad\SelEnd
									Else
										StartPos = gad\SelEnd
										EndPos = gad\SelStart
									EndIf
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
									gad\LineEnd = gad\LineStart
								    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
								ElseIf gad\LineStart < gad\LineEnd
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
									gad\Caption[gad\LineEnd] = ""
									For A = gad\LineStart+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
										gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
									gad\LineEnd = gad\LineStart
								    gad\SelEnd = gad\SelStart
								Else
									gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\Caption[gad\LineStart] = ""
									For A = gad\LineEnd+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
										gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
									gad\LineStart = gad\LineEnd
								    gad\SelStart = gad\SelEnd
								EndIf
								gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Chr(gad\Key) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\SelStart = gad\SelStart + 1
								gad\SelEnd = gad\SelStart
								gad\LineEnd = gad\LineStart
								If gad\MultiLine = False
									LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
									If LineLen > gad\W - 6
										gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
									ElseIf LineLen < 0
										gad\ScrollX = (LineLen+gad\ScrollX)
									EndIf
								EndIf
							EndIf
						;Misc
						ElseIf (gad\Key>32 And gad\Key<46) Or gad\Key = 47 Or (gad\Key>57 And gad\Key<65) Or gad\Key=83 Or (gad\Key>90 And gad\Key<97) Or (gad\Key>122 And gad\Key<127) Or gad\Key=163 Or gad\Key=172 And gad\Mode = 0
							If gad\LineStart = gad\LineEnd
								If gad\SelStart < gad\SelEnd
									StartPos = gad\SelStart
									EndPos = gad\SelEnd
								Else
									StartPos = gad\SelEnd
									EndPos = gad\SelStart
								EndIf
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
								gad\LineEnd = gad\LineStart
							    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
							ElseIf gad\LineStart < gad\LineEnd
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
								gad\Caption[gad\LineEnd] = ""
								For A = gad\LineStart+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
									gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
								gad\LineEnd = gad\LineStart
							    gad\SelEnd = gad\SelStart
							Else
								gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\Caption[gad\LineStart] = ""
								For A = gad\LineEnd+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
									gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
								gad\LineStart = gad\LineEnd
							    gad\SelStart = gad\SelEnd
							EndIf
							gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Chr(gad\Key) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
							gad\SelStart = gad\SelStart + 1
							gad\SelEnd = gad\SelStart
							gad\LineEnd = gad\LineStart
							If gad\MultiLine = False
								LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
								If LineLen > gad\W - 6
									gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
								ElseIf LineLen < 0
									gad\ScrollX = (LineLen+gad\ScrollX)
								EndIf
							EndIf
						;Enter
						ElseIf gad\Key = 13
							If gad\MultiLine = False
								gad\Active = False
								app\Event = EVENT_GADGET
								app\GadgetEvent = gad\ID
								If gad\MultiLine = False
									app\GadgetEventData = gad\Caption[0]
								EndIf
							Else
								If gad\LineStart = gad\LineEnd
									If gad\SelStart < gad\SelEnd
										StartPos = gad\SelStart
										EndPos = gad\SelEnd
									Else
										StartPos = gad\SelEnd
										EndPos = gad\SelStart
									EndIf
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
									gad\LineEnd = gad\LineStart
								    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
								ElseIf gad\LineStart < gad\LineEnd
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
									gad\Caption[gad\LineEnd] = ""
									For A = gad\LineStart+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
										gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
									gad\LineEnd = gad\LineStart
								    gad\SelEnd = gad\SelStart
								Else
									gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\Caption[gad\LineStart] = ""
									For A = gad\LineEnd+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
										gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
									gad\LineStart = gad\LineEnd
								    gad\SelStart = gad\SelEnd
								EndIf
								If gad\LineStart+2 <= gad\LineCount
									For A = gad\LineStart+2 To gad\LineCount
										gad\Caption[gad\LineCount-(A-(gad\LineStart+2))] = gad\Caption[gad\LineCount-(A-(gad\LineStart+2))-1]
									Next
								EndIf
								gad\Caption[gad\LineStart+1] = Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart)
								gad\LineCount = gad\LineCount + 1
								gad\LineStart = gad\LineStart + 1
								gad\SelStart = 0
								gad\SelEnd = gad\SelStart
								gad\LineEnd = gad\LineStart
								
								If (gad\LineStart * gad\IH) - gad\ScrollY > gad\H - 4
									gad\ScrollY = gad\ScrollY + gad\IH
								EndIf
							EndIf
						;Backspace
						ElseIf gad\Key = 8
							If gad\LineStart = gad\LineEnd And gad\SelStart = gad\SelEnd
								If gad\SelStart > 0
									gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart-1) + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\SelStart = gad\SelStart - 1
									gad\SelEnd = gad\SelStart
									gad\LineEnd = gad\LineStart
								Else
									If gad\LineStart > 0
										PrevLen = Len(gad\Caption[gad\LineStart-1])
										gad\Caption[gad\LineStart-1] = gad\Caption[gad\LineStart-1] + gad\Caption[gad\LineStart]
										gad\Caption[gad\LineStart] = ""
										If gad\LineStart <= gad\LineCount-1
											For A = gad\LineStart To gad\LineCount-1
												gad\Caption[A] = gad\Caption[A+1]
											Next
										EndIf
										gad\LineCount = gad\LineCount - 1
										gad\LineStart = gad\LineStart - 1
										gad\SelStart = PrevLen
										gad\SelEnd = gad\SelStart
										gad\LineEnd = gad\LineStart
										
										If (gad\LineStart * gad\IH) - gad\ScrollY < 0
											gad\ScrollY = gad\ScrollY - gad\IH
										EndIf
									EndIf
								EndIf
							Else
								If gad\LineStart = gad\LineEnd
									If gad\SelStart < gad\SelEnd
										StartPos = gad\SelStart
										EndPos = gad\SelEnd
									Else
										StartPos = gad\SelEnd
										EndPos = gad\SelStart
									EndIf
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
									gad\LineEnd = gad\LineStart
								    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
								ElseIf gad\LineStart < gad\LineEnd
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
									gad\Caption[gad\LineEnd] = ""
									For A = gad\LineStart+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
										gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
									gad\LineEnd = gad\LineStart
								    gad\SelEnd = gad\SelStart
								Else
									gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\Caption[gad\LineStart] = ""
									For A = gad\LineEnd+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
										gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
									gad\LineStart = gad\LineEnd
								    gad\SelStart = gad\SelEnd
								EndIf
							EndIf
							If gad\MultiLine = False
								LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
								If LineLen > gad\W - 6
									gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
								ElseIf LineLen < 0
									gad\ScrollX = (LineLen+gad\ScrollX)
								EndIf
							EndIf
						;Del
						ElseIf gad\Key = 4
							If gad\LineStart = gad\LineEnd And gad\SelStart = gad\SelEnd
								If gad\SelStart < Len(gad\Caption[gad\LineStart])
									gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + Mid(gad\Caption[gad\LineStart], gad\SelStart+2)
								Else
									gad\Caption[gad\LineStart] = gad\Caption[gad\LineStart] + gad\Caption[gad\LineStart+1]
									gad\Caption[gad\LineStart+1] = ""
									If gad\LineStart+1 <= gad\LineCount-1
										For A = gad\LineStart+1 To gad\LineCount-1
											gad\Caption[A] = gad\Caption[A+1]
										Next
										gad\Caption[gad\LineCount] = ""
										gad\LineCount = gad\LineCount - 1
									EndIf
								EndIf
							Else
								If gad\LineStart = gad\LineEnd
									If gad\SelStart < gad\SelEnd
										StartPos = gad\SelStart
										EndPos = gad\SelEnd
									Else
										StartPos = gad\SelEnd
										EndPos = gad\SelStart
									EndIf
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
									gad\LineEnd = gad\LineStart
								    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
								ElseIf gad\LineStart < gad\LineEnd
									gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
									gad\Caption[gad\LineEnd] = ""
									For A = gad\LineStart+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]
										gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
									gad\LineEnd = gad\LineStart
								    gad\SelEnd = gad\SelStart
								Else
									gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
									gad\Caption[gad\LineStart] = ""
									For A = gad\LineEnd+1 To gad\LineCount
										gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
										gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
									Next
									gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
									gad\LineStart = gad\LineEnd
								    gad\SelStart = gad\SelEnd
								EndIf
							EndIf
						;Tab
						ElseIf gad\Key = 9 And gad\Mode = 0
							If gad\LineStart = gad\LineEnd
								If gad\SelStart < gad\SelEnd
									StartPos = gad\SelStart
									EndPos = gad\SelEnd
								Else
									StartPos = gad\SelEnd
									EndPos = gad\SelStart
								EndIf
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], StartPos ) + Mid( gad\Caption[gad\LineStart], EndPos+1 )
								gad\LineEnd = gad\LineStart
							    If gad\SelStart < gad\SelEnd gad\SelEnd = gad\SelStart Else gad\SelStart = gad\SelEnd
							ElseIf gad\LineStart < gad\LineEnd
								gad\Caption[gad\LineStart] = Left( gad\Caption[gad\LineStart], gad\SelStart ) + Mid( gad\Caption[gad\LineEnd], gad\SelEnd+1 )
								gad\Caption[gad\LineEnd] = ""
								For A = gad\LineStart+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineEnd-gad\LineStart)]

									gad\Caption[A+(gad\LineEnd-gad\LineStart)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineEnd-gad\LineStart)
								gad\LineEnd = gad\LineStart
							    gad\SelEnd = gad\SelStart
							Else
								gad\Caption[gad\LineEnd] = Left( gad\Caption[gad\LineEnd], gad\SelEnd ) + Mid( gad\Caption[gad\LineStart], gad\SelStart+1)
								gad\Caption[gad\LineStart] = ""
								For A = gad\LineEnd+1 To gad\LineCount
									gad\Caption[A] = gad\Caption[A+(gad\LineStart-gad\LineEnd)]
									gad\Caption[A+(gad\LineStart-gad\LineEnd)] = ""
								Next
								gad\LineCount = gad\LineCount - (gad\LineStart-gad\LineEnd)
								gad\LineStart = gad\LineEnd
							    gad\SelStart = gad\SelEnd
							EndIf
							gad\Caption[gad\LineStart] = Left(gad\Caption[gad\LineStart], gad\SelStart) + "    " + Mid(gad\Caption[gad\LineStart], gad\SelStart+1)
							gad\SelStart = gad\SelStart + 4
							gad\SelEnd = gad\SelStart
							gad\LineEnd = gad\LineStart
							If gad\MultiLine = False
								LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
								If LineLen > gad\W - 6
									gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
								ElseIf LineLen < 0
									gad\ScrollX = (LineLen+gad\ScrollX)
								EndIf
							EndIf
						;Up Arrow
						ElseIf gad\Key = 28
							If gad\LineStart > 0
								gad\LineStart = gad\LineStart - 1
								If gad\SelStart > Len(gad\Caption[gad\LineStart])
									gad\SelStart = Len(gad\Caption[gad\LineStart])
									gad\SelEnd = gad\SelStart
								EndIf
								gad\LineEnd = gad\LineStart
								If (gad\LineStart * gad\IH) - gad\ScrollY < 0
									gad\ScrollY = gad\ScrollY - gad\IH
								EndIf
							EndIf
						;Down Arrow
						ElseIf gad\Key = 29
							If gad\LineStart < gad\LineCount - 1
								gad\LineStart = gad\LineStart + 1
								If gad\SelStart > Len(gad\Caption[gad\LineStart])
									gad\SelStart = Len(gad\Caption[gad\LineStart])
									gad\SelEnd = gad\SelStart
								EndIf
								gad\LineEnd = gad\LineStart
								If (gad\LineStart * gad\IH) - gad\ScrollY > gad\H - 4
									gad\ScrollY = gad\ScrollY + gad\IH;((gad\LineStart+1) * gad\IH) - (gad\H - 3)
								EndIf
							EndIf
						;Right Arrow
						ElseIf gad\Key = 30
							If gad\SelStart < Len(gad\Caption[gad\LineStart])
								gad\SelStart = gad\SelStart + 1
								gad\SelEnd = gad\SelStart
								gad\LineEnd = gad\LineStart
								If gad\MultiLine = False
									LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
									If LineLen > gad\W - 6
										gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
									ElseIf LineLen < 0
										gad\ScrollX = (LineLen+gad\ScrollX)
									EndIf
								EndIf
							Else
								If gad\LineStart < gad\LineCount - 1
									gad\LineStart = gad\LineStart + 1
									gad\SelStart = 0
									gad\SelEnd = gad\SelStart
									gad\LineEnd = gad\LineStart
									If (gad\LineStart * gad\IH) - gad\ScrollY > gad\H - 4
										gad\ScrollY = gad\ScrollY + gad\IH;((gad\LineStart+1) * gad\IH) - (gad\H - 3)
									EndIf
								EndIf
							EndIf
						;Left Arrow
						ElseIf gad\Key = 31
							If gad\SelStart > 0
								gad\SelStart = gad\SelStart - 1
								gad\SelEnd = gad\SelStart
								gad\LineEnd = gad\LineStart
								If gad\MultiLine = False
									LineLen = StringWidth( Left(gad\Caption[0],gad\SelStart) ) - gad\ScrollX
									If LineLen > gad\W - 6
										gad\ScrollX = (LineLen+gad\ScrollX) - (gad\W - 6)
									ElseIf LineLen < 0
										gad\ScrollX = (LineLen+gad\ScrollX)
									EndIf
								EndIf
							Else
								If gad\LineStart > 0
									gad\LineStart = gad\LineStart - 1
									gad\SelStart = Len(gad\Caption[gad\LineStart])
									gad\SelEnd = gad\SelStart
									gad\LineEnd = gad\LineStart
									If (gad\LineStart * gad\IH) - gad\ScrollY < 0
										gad\ScrollY = gad\ScrollY - gad\IH
									EndIf
								EndIf
							EndIf
			        	EndIf
					EndIf
				EndIf
				
				Viewport 0, 0, app\W, app\H
				
				Color 0, 0, 0
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				
				If TempIH gad\IH = TempIH
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateTreeView( win.Window )

	gad.TreeView = Last TreeView
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				SetFont app\fntTreeView
				
				Valid = True
				If win <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				
				If MouseOver( gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H ) And NoActiveGadgets() And win = app\overWin And Valid = True
					app\ToolTipTimer = app\ToolTipTimer + 1
					If app\ToolTipTimer > app\ToolTipDelay
						app\ToolTip = gad\ToolTip
					EndIf
				EndIf
				
				If gad\Disabled = True Valid = False
				
				;Drawing
				SetColor( SC_INPUT )
				Rect win\X+win\FX+gad\X, win\Y+win\FY+gad\Y, gad\W, gad\H
				Color 0, 0, 0
				Rect win\X+win\FX+gad\X, win\Y+win\FY+gad\Y, gad\W, gad\H, 0
				
				If gad\Disabled = True
					SetColor( SC_INPUT,-60 )
				EndIf
				Rect win\X+win\FX+gad\X+1+4+gad\NodeW/2, win\Y+win\FY+gad\Y, 1, gad\H
				
				Viewport gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				
				gad\YOFF = 1
				gad\CurrentIndex = 1
				
				;List Nodes
				UpdateNodes( gad )
				
				Viewport 0, 0, app\W, app\H
				
				gad\RH = (((gad\YOFF-1)/gad\IH) * gad\IH) - (gad\H - 2)
				
				If (gad\YOFF-1)/gad\IH > gad\CountVisible
				    gad\WOFF = gad\ScrollW+1
				    
					SetColor( SC_FORM,-40 )
					Rect win\X+win\FX+gad\X+gad\W-gad\ScrollW-1, win\Y+win\FY+gad\Y+1+gad\ScrollW, 1, gad\H-2-gad\ScrollW*2, 0
				
					;Top Button
					If MouseOver( win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And (Valid = True Or ModVersion = True)
						gad\TBState =-1
						If app\MB1 = 1
							gad\TBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\TBActive = True
								gad\TBState =-2
								If gad\Timer = 0
									If gad\ScrollY > 0
										gad\ScrollY = gad\ScrollY - gad\Inc
									EndIf
									If gad\ScrollY <= 0
										gad\ScrollY = 0
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\TBState = 0
					EndIf
					If app\MB1 = 0
						If gad\TBActive = True
							gad\TBActive = False
						EndIf
					EndIf
					
					If gad\TBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1, gad\ScrollW, gad\ScrollW
					If gad\TBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					SetColor( SC_FORMTEXT )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, win\Y+win\FY+gad\Y+gad\ScrollW/2+XOFF, 2, 1
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, win\Y+win\FY+gad\Y+gad\ScrollW/2+1+XOFF, 4, 1
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, win\Y+win\FY+gad\Y+gad\ScrollW/2+2+XOFF, 6, 1
				
					;Bottom Button
					If MouseOver( win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW ) = True And NoActiveGadgets() = True And win = app\overWin And (Valid = True Or ModVersion = True)
						gad\BBState =-1
						If app\MB1 = 1
							gad\BBActive = True
							gad\Timer = 0
						ElseIf app\MB1 = 2
							If gad\BBActive = True
								gad\BBState =-2
								If gad\Timer = 0
									If gad\ScrollY < gad\RH
										gad\ScrollY = gad\ScrollY + gad\Inc
									EndIf
									If gad\ScrollY >= gad\RH
										gad\ScrollY = gad\RH
									EndIf
								EndIf
								gad\Timer = gad\Timer + 1
								If gad\Timer > gad\SDelay
									gad\Timer = 0
								EndIf
							EndIf
						EndIf
					Else
						gad\BBState = 0
					EndIf
					If app\MB1 = 0
						If gad\BBActive = True
							gad\BBActive = False
						EndIf
					EndIf
					
					If gad\BBState =-2
						XOFF = 1
					Else
						XOFF = 0
					EndIf
					
					SetColor( SC_FORM )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW, gad\ScrollW
					If gad\BBState >-2
						SetColor( SC_FORM, 40 )
					Else
						SetColor( SC_FORM,-40 )
					EndIf
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+gad\H-gad\ScrollW-1, gad\ScrollW+1, gad\ScrollW+1, 0
					
					SetColor( SC_FORMTEXT )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-2+XOFF, win\Y+win\FY+gad\Y+gad\H-2-gad\ScrollW/2-1+XOFF, 6, 1
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2-1+XOFF, win\Y+win\FY+gad\Y+gad\H-2-gad\ScrollW/2+XOFF, 4, 1
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1+gad\ScrollW/2+XOFF, win\Y+win\FY+gad\Y+gad\H-2-gad\ScrollW/2+1+XOFF, 2, 1
				
					;Scroll Bar
					If gad\ScrollY > gad\RH gad\ScrollY = gad\RH
					SBS# = gad\H - 4 - gad\ScrollW*2
					gad\ScrollH = SBS - (gad\YOFF-1)/gad\IH
					If gad\ScrollH < 6 gad\ScrollH = 6
					SY# = Interpolate(gad\ScrollY, 0, gad\RH, 0, SBS-gad\ScrollH)
					
					SetColor( SC_FORM, 40 )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+gad\ScrollW+2, gad\ScrollW, SBS
					
					If MouseOver( win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH ) = True And NoActiveGadgets() = True And win = app\overWin And Valid = True
						If app\MB1 = 1
							gad\SBActive = True
							gad\DragY = app\MY - (win\Y+win\FY+gad\Y+SY)
						EndIf
					EndIf
					If app\MB1 = 2
						If gad\SBActive = True
							SY = app\MY - gad\DragY - (win\Y+win\FY+gad\Y)
							If SY < 0 SY = 0
							If SY > SBS-gad\ScrollH SY = SBS-gad\ScrollH
							gad\ScrollY = Interpolate( SY, 0, SBS-gad\ScrollH, 0, gad\RH )
						EndIf
					ElseIf app\MB1 = 0
						If gad\SBActive = True
							gad\SBActive = False
						EndIf
					EndIf
					
					SetColor( SC_FORM )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH
					SetColor( SC_FORM,-40 )
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, gad\ScrollH, 0
					SetColor( SC_FORM, 40 )

					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW+1+SY, gad\ScrollW, 1, 0
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW+1+SY, 1, gad\ScrollH, 0								
				
					Color 0, 0, 0
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+1+gad\ScrollW, gad\ScrollW, 1
					Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW+1, win\Y+win\FY+gad\Y+gad\H-gad\ScrollW-2, gad\ScrollW, 1
                    Rect win\X+win\FX+gad\X+gad\W-2-gad\ScrollW, win\Y+win\FY+gad\Y, 1, gad\H
				Else
					gad\WOFF = 0
					gad\ScrollY = 0
				EndIf
				Color 0, 0, 0
				Rect win\X+win\FX+gad\X, win\Y+win\FY+gad\Y, gad\W, gad\H, 0
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateNodes( tree.TreeView )

	gad.Node = Last Node
	
	While gad <> Null
		If gad\Owner <> Null
			If gad\ParentNode <> Null
				If gad\ParentNode\Active = True
					Valid = True
					XOFF = gad\Layer * (tree\NodeW+4)
					YOFF = gad\ParentNode\Y + tree\IH + gad\ParentNode\YOFF
				Else
					gad\Active = False
					Valid = False
				EndIf
			Else
				Valid = True
				XOFF = 0
				YOFF = tree\YOFF
			EndIf
			If gad\Owner = tree And Valid = True
				gad\YOFF = 0
				gad\Y = YOFF
				
				Valid = True
				If tree\Owner <> app\topWin And app\topWin <> Null
					If app\topWin\Closed = False
						Valid = False
					EndIf
				EndIf
				If gad\Disabled = True Valid = False
				
				If MouseOver( tree\Owner\X+tree\Owner\FX+tree\X+1, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, tree\W-2-tree\WOFF, tree\IH ) = True And tree\Owner = app\overWin And NoActiveGadgets() = True And Valid = True
				    If app\MY > tree\Owner\Y+tree\Owner\FY+tree\Y And app\MY < tree\Owner\Y+tree\Owner\FY+tree\Y+tree\H
					If app\MB1 = 1
						tree\Selected = tree\CurrentIndex
						tree\Caption = gad\Caption
						If gad\ParentNode <> Null
							tree\ParentCaption = gad\ParentNode\Caption
						Else
							tree\ParentCaption = ""
						EndIf
					EndIf
					EndIf
				EndIf
				
				;Drawing
				If tree\Selected = tree\CurrentIndex And gad\Disabled = False
					SetColor( SC_INPUTHILIGHT )
					Rect tree\Owner\X+tree\Owner\FX+tree\X+1, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, tree\W-2-tree\WOFF, tree\IH
					SetColor( SC_INPUTHILIGHT,-40 )
					Rect tree\Owner\X+tree\Owner\FX+tree\X+1, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, tree\W-2-tree\WOFF, tree\IH, 0
					SetColor( SC_INPUTHILIGHT, 40 )
					Rect tree\Owner\X+tree\Owner\FX+tree\X+1, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, tree\W-2-tree\WOFF, 1
					Rect tree\Owner\X+tree\Owner\FX+tree\X+1, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, 1, tree\IH
				EndIf
			
				;If gad\Disabled = True
				;	SetColor( SC_INPUT,-60 )
				;Else	
					Color 0, 0, 0
				;EndIf
                Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW+4-9, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\IH/2-tree\ScrollY, 7, 1

				gad\CurrentNode = 0
				If gad\ParentNode <> Null
					gad\ParentNode\CurrentNode = gad\ParentNode\CurrentNode + 1
				EndIf
				
				If gad\Layer > 0
               	 	For A = 0 To gad\Layer
               	 		If gad\ParentNode\CurrentNode < gad\ParentNode\Count Or A > 0
               	 			Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW/2-(A*(tree\NodeW+4)), tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, 1, tree\IH
						Else
							Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW/2-(A*(tree\NodeW+4)), tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, 1, tree\IH/2+1
						EndIf
					Next
				Else
					Rect tree\Owner\X+tree\Owner\FX+tree\X+1+4+tree\NodeW/2, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF-tree\ScrollY, 1, tree\IH
				EndIf
				
				If tree\Selected = tree\CurrentIndex And gad\Disabled = False
					SetColor( SC_INPUTTEXTSEL )
				Else
					If gad\Disabled = True
						SetColor( SC_INPUT,-60 )
					Else
						SetColor( SC_INPUTTEXT )
					EndIf
				EndIf
				
				If gad\Icon
					DrawImage gad\Icon, tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW+4+ImageWidth(gad\Icon)/2, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\IH/2-tree\ScrollY
					Text tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW+4+ImageWidth(gad\Icon)+4, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\IH/2-tree\ScrollY, gad\Caption, 0, 1
				Else
					Text tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW+4, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\IH/2-tree\ScrollY, gad\Caption, 0, 1
				EndIf
				
				If gad\HasChildren = True
					If gad\Disabled = True
						SetColor( SC_INPUT,-60 )
					Else
						SetColor( SC_GADGETSTRIP )
					EndIf
					Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\NodeW/2-tree\ScrollY, tree\NodeW, tree\NodeW
					Color 0, 0, 0
					Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\NodeW/2-tree\ScrollY, tree\NodeW, tree\NodeW, 0
				
					If gad\Disabled = True
						SetColor( SC_INPUT )
					Else
						SetColor( SC_GADGETSTRIP, 60 )
					EndIf
					Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+2, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\IH/2-tree\ScrollY, tree\NodeW-4, 1
					If gad\Active = False
						Rect tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4+tree\NodeW/2, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\NodeW/2+2-tree\ScrollY, 1, tree\NodeW-4
					EndIf
					
					If MouseOver( tree\Owner\X+tree\Owner\FX+tree\X+XOFF+1+4, tree\Owner\Y+tree\Owner\FY+tree\Y+YOFF+tree\NodeW/2-tree\ScrollY, tree\NodeW, tree\NodeW ) = True And tree\Owner = app\overWin And NoActiveGadgets() = True And Valid = True
						If app\MB1 = 1
							gad\Active = 1 - gad\Active
						EndIf
					EndIf
				EndIf
				
				tree\CurrentIndex = tree\CurrentIndex + 1
				If gad\ParentNode = Null
					tree\YOFF = tree\YOFF + tree\IH
					If gad\Active = True
						tree\YOFF = tree\YOFF + tree\IH * gad\Count
					EndIf
				Else
					gad\ParentNode\YOFF = gad\ParentNode\YOFF + tree\IH
					If gad\Active = True
						TempNode.Node = gad
						Repeat
							If TempNode\ParentNode <> Null
								TempNode\ParentNode\YOFF = TempNode\ParentNode\YOFF + tree\IH * gad\Count
								TempNode = TempNode\ParentNode
							Else
								Exit
							EndIf
						Forever
						tree\YOFF = tree\YOFF + tree\IH * gad\Count
					EndIf
				EndIf
			EndIf
		EndIf
	
		gad = Before gad
	Wend

End Function

Function UpdateCircle( win.Window )

	gad.Circle = Last Circle
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				Color gad\FillR, gad\FillG, gad\FillB
				Oval gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				
				Color gad\OutR, gad\OutG, gad\OutB
				Oval gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateSquare( win.Window )

	gad.Square = Last Square
	
	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				Color gad\FillR, gad\FillG, gad\FillB
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H
				
				Color gad\OutR, gad\OutG, gad\OutB
				Rect gad\Owner\X+gad\Owner\FX+gad\X, gad\Owner\Y+gad\Owner\FY+gad\Y, gad\W, gad\H, 0
				
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function UpdateTriangle( win.Window )

	gad.Triangle = Last Triangle
	

	While gad <> Null
	
		If gad\Owner <> Null
			If gad\TabOwner <> Null
				If gad\TabOwner\Owner\Active = gad\TabOwner
					Valid = True
				Else
					Valid = False
				EndIf
			Else
				Valid = True
			EndIf
			If gad\Owner = win And gad\Owner\Minimised = False And gad\Owner\Closed = False And Valid = True
			
				For A = 0 To gad\H
					Color gad\FillR, gad\FillG, gad\FillB
					Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2-(A/2), gad\Owner\Y+gad\Owner\FY+gad\Y+A, A, 1
					Color gad\OutR, gad\OutG, gad\OutB
					;if A = 0
					;	rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2, gad\Owner\Y+gad\Owner\FY+gad\Y+A, 1, 1
					If A = gad\H
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2-(A/2), gad\Owner\Y+gad\Owner\FY+gad\Y+A, A, 1
					Else
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2-(A/2), gad\Owner\Y+gad\Owner\FY+gad\Y+A, 1, 1
						Rect gad\Owner\X+gad\Owner\FX+gad\X+gad\W/2-(A/2)+A-1, gad\Owner\Y+gad\Owner\FY+gad\Y+A, 1, 1
					EndIf
				Next
			EndIf
		EndIf
		gad = Before gad
	Wend

End Function

Function SetToolTip( ID, Caption$ )
	
	tabp.TabPage = Object.TabPage( ID )
	If tabp <> Null
		tabp\ToolTip$ = Caption$
		Return True
	EndIf
	mnut.MenuTitle = Object.MenuTitle( ID )
	If mnut <> Null
		mnut\ToolTip$ = Caption$
		Return True
	EndIf
	mnui.Menuitem = Object.Menuitem( ID )
	If mnui <> Null
		mnui\ToolTip$ = Caption$
		Return True
	EndIf
	btn.Button = Object.Button( ID )
	If btn <> Null
		btn\ToolTip$ = Caption$
		Return True
	EndIf
	chk.CheckBox = Object.CheckBox( ID )
	If chk <> Null
	   	chk\ToolTip$ = Caption$
		Return True
	EndIf
	cbo.ComboBox = Object.ComboBox( ID )
	If cbo <> Null
		cbo\ToolTip$ = Caption$
		Return True
	EndIf
	img.Image = Object.Image( ID )
	If img <> Null
		img\ToolTip$ = Caption$
		Return True
	EndIf
	lbl.Label = Object.Label( ID )
	If lbl <> Null
		lbl\ToolTip$ = Caption$
		Return True
	EndIf
	lst.ListBox = Object.ListBox( ID )
	If lst <> Null
		lst\ToolTip$ = Caption$
		Return True
	EndIf
	prg.ProgressBar = Object.ProgressBar( ID )
	If mnut <> Null
		prg\ToolTip$ = Caption$
		Return True
	EndIf
	rad.Radio = Object.Radio( ID )
	If rad <> Null
		rad\ToolTip$ = Caption$
		Return True
	EndIf
	sld.Slider = Object.Slider( ID )
	If sld <> Null
		sld\ToolTip$ = Caption$
		Return True
	EndIf
	spn.Spinner = Object.Spinner( ID )
	If spn <> Null
		spn\ToolTip$ = Caption$
		Return True
	EndIf
	txt.TextBox = Object.TextBox( ID )
	If txt <> Null
		txt\ToolTip$ = Caption$
		Return True
	EndIf
	tree.TreeView = Object.TreeView( ID )
	If tree <> Null
		tree\ToolTip$ = Caption$
		Return True
	EndIf
	
	Return False

End Function

Function ShortCut( Key1$, Key2$="" )

	Key1$ = Lower( Key1$ )
	Key2$ = Lower( Key2$ )
	
	Select Key1$
		Case "esc"
			Key1 = 1
		Case "lctrl", "ctrl"
			Key1 = 29
		Case "lshift", "shift"
			Key1 = 42
		Case "lalt", "alt"
			Key1 = 56
		Case "rctrl"
			Key1 = 157
		Case "rshift"
			Key1 = 54
		Case "ralt"
			Key1 = 184
		Case "f1"
			Key1 = 59
		Case "f2"
			Key1 = 60
		Case "f3"
			Key1 = 61
		Case "f4"
			Key1 = 62
		Case "f5"
			Key1 = 63
		Case "f6"
			Key1 = 64
		Case "f7"
			Key1 = 65
		Case "f8"
			Key1 = 66
		Case "f9"
			Key1 = 67
		Case "f10"
			Key1 = 68
	End Select
	
	Select Key2$
		Case "lctrl", "ctrl"
			Key2 = 29
		Case "lshift", "shift"
			Key2 = 42
		Case "lalt", "alt"
			Key2 = 56
		Case "rctrl"
			Key2 = 157
		Case "rshift"
			Key2 = 54
		Case "ralt"
			Key2 = 184
		Case "f1"
			Key2 = 59
		Case "f2"
			Key2 = 60
		Case "f3"
			Key2 = 61
		Case "f4"
			Key2 = 62
		Case "f5"
			Key2 = 63
		Case "f6"
			Key2 = 64
		Case "f7"
			Key2 = 65
		Case "f8"
			Key2 = 66
		Case "f9"
			Key2 = 67
		Case "f10"
			Key2 = 68
	End Select
	
	If KeyDown( Key1 )
		If Key2 > ""
			If KeyDown( Key2 )
				Return True
			Else
				Return False
			EndIf
		Else
			Return True
		EndIf
	Else
		Return False
	EndIf

End Function

Function MouseOver( X = 0, Y = 0, W = 0, H = 0 )

	If app\MX >= X And app\MX < X + W And app\MY >= Y And app\MY < Y + H
		Return True
	Else
		Return False
	EndIf

End Function

Function Parse$( Message$, Item, Sep$ = "," )

	Local fas, count, spos, epos
	Repeat
		fas = Instr(message$,sep$,fas+1)
		count = count + 1
	Until fas = 0 Or count = item
	If fas = 0 And item > 0;item > count
		Return ""
	EndIf
	spos = fas+1
	epos = Instr(message$+sep$,sep$,fas+1)
	Return Mid$(message$,spos,(epos-spos))
	
End Function

Function CountItems( Message$, Sep$ )

	Local fas, count
	Repeat
		fas = Instr(message$,sep$,fas+1)
		If fas<>0 Then count = count + 1
	Until fas = 0
	Return count+1

End Function

Function SetColor( RGBColor$, Offset = 0 )

	R = Int(Parse(RGBColor, 0)) + Offset
	G = Int(Parse(RGBColor, 1)) + Offset
	B = Int(Parse(RGBColor, 2)) + Offset
	
	If R > 255 R = 255
	If R < 0 R = 0
	
	If G > 255 G = 255
	If G < 0 G = 0
	
	If B > 255 B = 255
	If B < 0 B = 0
	
	Color R, G, B

End Function

Function NoActiveGadgets()

	If app\actMenu <> Null Or app\actCombo <> Null
		Return False
	Else
		Return True
	EndIf

End Function

Function LoadColourScheme( Source$ )

	If FileType( Source$ ) = 1
		File = ReadFile( Source$ )
		SC_FORM = ReadString( File )
		SC_FORMTEXT = ReadString( File )
		SC_FORMTITLE = ReadString( File )
		SC_FORMTITLEITEM = ReadString( File )
		SC_MENU = ReadString( File )
		SC_MENUSEL = ReadString( File )
		SC_MENUSTRIP = ReadString( File )
		SC_MENUSTRIPITEM = ReadString( File )
		SC_MENUTEXT = ReadString( File )
		SC_MENUTEXTSEL = ReadString( File )
		SC_GADGET = ReadString( File )
		SC_GADGETSTRIP = ReadString( File )
		SC_GADGETSTRIPITEM = ReadString( File )
		SC_INPUT = ReadString( File )
		SC_INPUTTEXT = ReadString( File )
		SC_INPUTTEXTSEL = ReadString( File )
		SC_INPUTHILIGHT = ReadString( File )
		CloseFile File
		Return True
	Else
		Return False
	EndIf

End Function

Function SetWindowSnap( Value = False, Strength = 5 )

	SnapWindows = Value
	SNAP_STRENGTH = Strength

End Function

Function Interpolate#(value#, vMin#, vMax#, retMin#, retMax#)

	Return retMin + ((value-vMin) * (retMax - retMin)) / (vMax-vMin)
	
End Function

Function DeleteWindow( ID )
	For win.Window = Each Window
		If win\ID = ID
			If win\Icon FreeImage win\Icon
			For tab.Tab = Each Tab
				If tab\Owner = win
					For tabp.TabPage = Each TabPage
						If tabp\Owner = tab
							If tabp\Image FreeImage tabp\Image
							Delete tabp
						EndIf
					Next
					Delete tab
				EndIf
			Next
			For mnut.MenuTitle = Each MenuTitle
				If mnut\Owner = win
					For mnui.MenuItem = Each MenuItem
						If mnui\Owner = mnut
							If mnui\Icon FreeImage mnui\Icon
							Delete mnui
						EndIf
					Next
					Delete mnut
				EndIf
			Next
			For btn.Button = Each Button
				If btn\Owner = win
					If btn\Image FreeImage btn\Image
					Delete btn
				EndIf
			Next
			For chk.CheckBox = Each CheckBox
				If chk\Owner = win Delete chk
			Next
			For cbo.ComboBox = Each ComboBox
				If cbo\Owner = win Delete chk
			Next
			For grp.GroupBox = Each GroupBox
				If grp\Owner = win Delete grp
			Next
			For img.Image = Each Image
				If img\Owner = win
					If img\Image FreeImage img\Image
					Delete img
				EndIf
			Next
			For imgbox.ImageBox = Each ImageBox
				If imgbox\Owner = win
					If imgbox\Image FreeImage imgbox\Image
					Delete imgbox
				EndIf
			Next
			For lbl.Label = Each Label
				If lbl\Owner = win Delete lbl
			Next
			For lst.ListBox = Each ListBox
				If lst\Owner = win Delete lst
			Next
			For prg.ProgressBar = Each ProgressBar
				If prg\Owner = win Delete prg
			Next
			For rad.Radio = Each Radio
				If rad\Owner = win Delete rad
			Next
			For scroll.ScrollBar = Each ScrollBar
				If scroll\Owner = win Delete scroll
			Next
			For sld.Slider = Each Slider
				If sld\Owner = win Delete sld
			Next
			For spn.Spinner = Each Spinner
				If spn\Owner = win Delete spn
			Next
			For txt.TextBox = Each TextBox
				If txt\Owner = win Delete txt
			Next
			For tree.TreeView = Each TreeView
				If tree\Owner = win
					For node.Node = Each Node
						If node\Owner = tree Delete node
					Next
					Delete tree
				EndIf
			Next
			Delete win
			Return True
		EndIf
	Next
	Return False
End Function

Function HideGadget( ID )

	tabp.TabPage = Object.TabPage( ID )
	If tabp <> Null
		tabp\Visible = False
		Return True
	EndIf
	mnut.MenuTitle = Object.MenuTitle( ID )
	If mnut <> Null
		mnut\Visible = False
		Return True
	EndIf
	mnui.Menuitem = Object.Menuitem( ID )
	If mnui <> Null
		mnui\Visible = False
		Return True
	EndIf
	btn.Button = Object.Button( ID )
	If btn <> Null
		btn\Visible = False
		Return True
	EndIf
	chk.CheckBox = Object.CheckBox( ID )
	If chk <> Null
	   	chk\Visible = False
		Return True
	EndIf
	cbo.ComboBox = Object.ComboBox( ID )
	If cbo <> Null
		cbo\Visible = False
		Return True
	EndIf
	img.Image = Object.Image( ID )
	If img <> Null
		img\Visible = False
		Return True
	EndIf
	lbl.Label = Object.Label( ID )
	If lbl <> Null
		lbl\Visible = False
		Return True
	EndIf
	lst.ListBox = Object.ListBox( ID )
	If lst <> Null
		lst\Visible = False
		Return True
	EndIf
	prg.ProgressBar = Object.ProgressBar( ID )
	If mnut <> Null
		prg\Visible = False
		Return True
	EndIf
	rad.Radio = Object.Radio( ID )
	If rad <> Null
		rad\Visible = False
		Return True
	EndIf
	sld.Slider = Object.Slider( ID )
	If sld <> Null
		sld\Visible = False
		Return True
	EndIf
	spn.Spinner = Object.Spinner( ID )
	If spn <> Null
		spn\Visible = False
		Return True
	EndIf
	txt.TextBox = Object.TextBox( ID )
	If txt <> Null
		txt\Visible = False
		Return True
	EndIf
	tree.TreeView = Object.TreeView( ID )
	If tree <> Null
		tree\Visible = False
		Return True
	EndIf
	
	Return False

End Function

Function ShowGadget( ID )

	tabp.TabPage = Object.TabPage( ID )
	If tabp <> Null
		tabp\Visible = True
		Return True
	EndIf
	mnut.MenuTitle = Object.MenuTitle( ID )
	If mnut <> Null
		mnut\Visible = True
		Return True
	EndIf
	mnui.Menuitem = Object.Menuitem( ID )
	If mnui <> Null
		mnui\Visible = True
		Return True
	EndIf
	btn.Button = Object.Button( ID )
	If btn <> Null
		btn\Visible = True
		Return True
	EndIf
	chk.CheckBox = Object.CheckBox( ID )
	If chk <> Null
	   	chk\Visible = True
		Return True
	EndIf
	cbo.ComboBox = Object.ComboBox( ID )
	If cbo <> Null
		cbo\Visible = True
		Return True
	EndIf
	img.Image = Object.Image( ID )
	If img <> Null
		img\Visible = True
		Return True
	EndIf
	lbl.Label = Object.Label( ID )
	If lbl <> Null
		lbl\Visible = True
		Return True
	EndIf
	lst.ListBox = Object.ListBox( ID )
	If lst <> Null
		lst\Visible = True
		Return True
	EndIf
	prg.ProgressBar = Object.ProgressBar( ID )
	If mnut <> Null
		prg\Visible = True
		Return True
	EndIf
	rad.Radio = Object.Radio( ID )
	If rad <> Null
		rad\Visible = True
		Return True
	EndIf
	sld.Slider = Object.Slider( ID )
	If sld <> Null
		sld\Visible = True
		Return True
	EndIf
	spn.Spinner = Object.Spinner( ID )
	If spn <> Null
		spn\Visible = True
		Return True
	EndIf
	txt.TextBox = Object.TextBox( ID )
	If txt <> Null
		txt\Visible = True
		Return True
	EndIf
	tree.TreeView = Object.TreeView( ID )
	If tree <> Null
		tree\Visible = True
		Return True
	EndIf
	
	Return False

End Function
