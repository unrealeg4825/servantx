;Icons.bb must be included in your main code if you want to see the images
function FileDialog$( Title$ = "Open File", StartDir$="", Filter$=".*", Save=false )
	
	winFileDlg		= Window( -1,-1, 300, 195, Title$, 0, true, false, false, true )
	SendMessage( winFileDlg, "WM_SETMODAL" )
	lstFile			= ListBox (2, 2, 292, 140 )
	btnFileUp		= Button( 2, 147, 20, 20, "", imgOpen )
	if Save			txtFileSource = TextBox( 25, 147, 122, 20, false, "Standard", -1, 10, false )
	btnFileCancel	= Button( 150, 147, 70, 20, "Cancel" )
	if Save = false
		btnFileOk		= Button( 224, 147, 70, 20, "Open" )
	else
		btnFileOk		= Button( 224, 147, 70, 20, "Save" )
	endif
	
	SetBuffer BackBuffer()
	
	if StartDir$ > ""
		CurrDir$ = StartDir$
	else
		CurrDir$ = currentdir()
	endif
	
	if len( CurrDir$ ) > 3
		if right( CurrDir$, 1 ) = "\"
			CurrDir$ = left( CurrDir$, len( CurrDir$ ) - 1 )
		endif
	endif

	SendMessage( lstFile, "LM_RESET" )
	Dir = readdir( CurrDir$ )
	repeat
	
		File$ = nextfile( Dir )
		if Filetype( CurrDir$ + "\" + File$ ) = 2 and File$ > ".."
		    AddListBoxItem( lstFile,-1, File$, imgOpen )
		endif
		
	until File$ = ""
	closedir Dir
	
	Dir = readdir( CurrDir$ )
	repeat
	
		File$ = nextfile( Dir )
		for A = 0 to CountItems( Filter$, ";" ) - 1
			Ext$ = lower( trim(Parse( Filter$, A, ";" )) )
			if (filetype( CurrDir$ + "\" + File$ ) = 1 and right( lower( File$ ), len( Ext$ ) ) = Ext$) or (filetype( CurrDir$ + "\" + File$ ) = 1 and Ext$ = ".*")
	    		AddListBoxItem( lstFile,-1, File$, imgNew )
	    	endif
	    next
		
	until File$ = ""
	closedir Dir
	
	Ret$ = ""
	Repeat
		UpdateGUI()
		
		Select app\Event
			case EVENT_WINDOW
				select app\WindowEvent
					case winFileDlg
						select app\WindowEventData
							case "Closed"
								Done = true
						end select
				end select
			Case EVENT_GADGET
				Select app\GadgetEvent
					case lstFile
						SelItem$ = SendMessage( lstFile, "LM_GETCAPTION" )						
						if (CurrDir$ > "" and Filetype( CurrDir$ + "\" + SelItem$ ) = 2) or (CurrDir$ = "" and filetype( SelItem$ ) = 2) ;Folder
							if CurrDir$ > ""
								CurrDir$ = CurrDir$ + "\" + SelItem$
							else
								CurrDir$ = Selitem$
							endif
							SendMessage( lstFile, "LM_RESET" )
							Dir = readdir( CurrDir$ )
							repeat
							
								File$ = nextfile( Dir )
								if Filetype( CurrDir$ + "\" + File$ ) = 2 and File$ > ".."
								    AddListBoxItem( lstFile,-1, File$, imgOpen )
								endif
								
							until File$ = ""
							closedir Dir
							
							Dir = readdir( CurrDir$ )
							repeat
							
								File$ = nextfile( Dir )
								for A = 0 to CountItems( Filter$, ";" ) - 1
									Ext$ = lower( trim(Parse( Filter$, A, ";" )) )
									if (filetype( CurrDir$ + "\" + File$ ) = 1 and right( lower( File$ ), len( Ext$ ) ) = Ext$) or (filetype( CurrDir$ + "\" + File$ ) = 1 and Ext$ = ".*")
							    		AddListBoxItem( lstFile,-1, File$, imgNew )
							    	endif
							    next
								
							until File$ = ""
							closedir Dir
						elseif filetype( CurrDir$ + "\" + SelItem$ ) = 1
							if Save SendMessage( txtFileSource, "TM_SETTEXT", 0, SelItem$ )
						endif
					case btnFileUp
						if len( CurrDir$ ) > 2
							Slash = 0
							repeat
								Slash = instr(CurrDir$, "\", Slash+1)
								if Slash > 0
									LastSlash = Slash
								endif
							until Slash = 0
							CurrDir$ = left( CurrDir$, LastSlash-1 )
							SendMessage( lstFile, "LM_RESET" )
							Dir = readdir( CurrDir$ )
							repeat
							
								File$ = nextfile( Dir )
								if Filetype( CurrDir$ + "\" + File$ ) = 2 and File$ > ".."
								    AddListBoxItem( lstFile,-1, File$, imgOpen )
								endif
								
							until File$ = ""
							closedir Dir
							
							Dir = readdir( CurrDir$ )
							repeat
								File$ = nextfile( Dir )
								for A = 0 to CountItems( Filter$, ";" ) - 1
									Ext$ = lower( trim(Parse( Filter$, A, ";" )) )
									if (filetype( CurrDir$ + "\" + File$ ) = 1 and right( lower( File$ ), len( Ext$ ) ) = Ext$) or (filetype( CurrDir$ + "\" + File$ ) = 1 and Ext$ = ".*")
							    		AddListBoxItem( lstFile,-1, File$, imgNew )
							    	endif
							    next
							until File$ = ""
							closedir Dir
						elseif len( CurrDir$ ) = 2
							SendMessage( lstFile, "LM_RESET" )
							for A = 65 to 90
								if filetype(chr(A) + ":") = 2
									AddListBoxItem( lstFile,-1, chr(A) + ":" )
								endif
							next
							CurrDir$ = ""
						endif
					case btnFileCancel
						Done = true
						Ret$ = "Cancel"
					case btnFileOk
						Done = true
						if right( CurrDir$, 1 ) = "\" CurrDir$ = left( CurrDir$, len( CurrDir$ ) - 1 )
						if Save = false
							Ret$ = CurrDir$ + "\" + SelItem$
						else
							Ret$ = CurrDir$ + "\" + SendMessage( txtFileSource, "TM_GETTEXT" )
						endif
				end select
		end select

		DrawMouse()
		ResetEvents()

		Flip
		Cls

	Until Done=True
	flushkeys
	UpdateGUI()

	DeleteWindow( winFileDlg )
	return Ret$

end function
