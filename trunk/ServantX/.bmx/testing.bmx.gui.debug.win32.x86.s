	format	MS COFF
	extrn	___bb_appstub_appstub
	extrn	___bb_audio_audio
	extrn	___bb_bank_bank
	extrn	___bb_bankstream_bankstream
	extrn	___bb_basic_basic
	extrn	___bb_blitz_blitz
	extrn	___bb_bmploader_bmploader
	extrn	___bb_d3d7max2d_d3d7max2d
	extrn	___bb_d3d9max2d_d3d9max2d
	extrn	___bb_data_data
	extrn	___bb_directsoundaudio_directsoundaudio
	extrn	___bb_eventqueue_eventqueue
	extrn	___bb_freeaudioaudio_freeaudioaudio
	extrn	___bb_freejoy_freejoy
	extrn	___bb_freeprocess_freeprocess
	extrn	___bb_freetypefont_freetypefont
	extrn	___bb_glew_glew
	extrn	___bb_gnet_gnet
	extrn	___bb_jpgloader_jpgloader
	extrn	___bb_macos_macos
	extrn	___bb_map_map
	extrn	___bb_maxlua_maxlua
	extrn	___bb_maxml_maxml
	extrn	___bb_maxutil_maxutil
	extrn	___bb_oggloader_oggloader
	extrn	___bb_openalaudio_openalaudio
	extrn	___bb_pngloader_pngloader
	extrn	___bb_retro_retro
	extrn	___bb_tgaloader_tgaloader
	extrn	___bb_threads_threads
	extrn	___bb_timer_timer
	extrn	___bb_wavloader_wavloader
	extrn	_bbAppDir
	extrn	_bbOnDebugEnterScope
	extrn	_bbOnDebugEnterStm
	extrn	_bbOnDebugLeaveScope
	extrn	_bbStringClass
	extrn	_bbStringConcat
	extrn	_brl_retro_Replace
	extrn	_brl_standardio_Print
	public	__bb_main
	section	"code" code
__bb_main:
	push	ebp
	mov	ebp,esp
	push	ebx
	cmp	dword [_32],0
	je	_33
	mov	eax,0
	pop	ebx
	mov	esp,ebp
	pop	ebp
	ret
_33:
	mov	dword [_32],1
	push	ebp
	push	_30
	call	dword [_bbOnDebugEnterScope]
	add	esp,8
	call	___bb_blitz_blitz
	call	___bb_appstub_appstub
	call	___bb_audio_audio
	call	___bb_bank_bank
	call	___bb_bankstream_bankstream
	call	___bb_basic_basic
	call	___bb_bmploader_bmploader
	call	___bb_d3d7max2d_d3d7max2d
	call	___bb_d3d9max2d_d3d9max2d
	call	___bb_data_data
	call	___bb_directsoundaudio_directsoundaudio
	call	___bb_eventqueue_eventqueue
	call	___bb_freeaudioaudio_freeaudioaudio
	call	___bb_freetypefont_freetypefont
	call	___bb_gnet_gnet
	call	___bb_jpgloader_jpgloader
	call	___bb_map_map
	call	___bb_maxlua_maxlua
	call	___bb_maxutil_maxutil
	call	___bb_oggloader_oggloader
	call	___bb_openalaudio_openalaudio
	call	___bb_pngloader_pngloader
	call	___bb_retro_retro
	call	___bb_tgaloader_tgaloader
	call	___bb_threads_threads
	call	___bb_timer_timer
	call	___bb_wavloader_wavloader
	call	___bb_freejoy_freejoy
	call	___bb_freeprocess_freeprocess
	call	___bb_glew_glew
	call	___bb_macos_macos
	call	___bb_maxml_maxml
	push	_27
	call	dword [_bbOnDebugEnterStm]
	add	esp,4
	push	_23
	push	_22
	push	dword [_bbAppDir]
	call	_brl_retro_Replace
	add	esp,12
	push	eax
	call	_brl_standardio_Print
	add	esp,4
	push	_29
	call	dword [_bbOnDebugEnterStm]
	add	esp,4
	push	_1
	push	_23
	push	_22
	push	_22
	push	dword [_bbAppDir]
	call	_bbStringConcat
	add	esp,8
	push	eax
	call	_brl_retro_Replace
	add	esp,12
	push	eax
	push	_24
	call	_brl_retro_Replace
	add	esp,12
	push	eax
	call	_brl_standardio_Print
	add	esp,4
	mov	ebx,0
	jmp	_25
_25:
	call	dword [_bbOnDebugLeaveScope]
	mov	eax,ebx
	pop	ebx
	mov	esp,ebp
	pop	ebp
	ret
	section	"data" data writeable align 8
	align	4
_32:
	dd	0
_31:
	db	"testing",0
	align	4
_30:
	dd	1
	dd	_31
	dd	0
_28:
	db	"$BMXPATH/projects/TheServantModified/Engine/testing.bmx",0
	align	4
_27:
	dd	_28
	dd	1
	dd	1
	align	4
_23:
	dd	_bbStringClass
	dd	2147483647
	dd	1
	dw	92
	align	4
_22:
	dd	_bbStringClass
	dd	2147483647
	dd	1
	dw	47
	align	4
_29:
	dd	_28
	dd	2
	dd	1
	align	4
_1:
	dd	_bbStringClass
	dd	2147483647
	dd	0
	align	4
_24:
	dd	_bbStringClass
	dd	2147483647
	dd	74
	dw	67,58,92,66,108,105,116,122,77,97,120,92,112,114,111,106
	dw	101,99,116,115,92,84,104,101,83,101,114,118,97,110,116,77
	dw	111,100,105,102,105,101,100,92,69,110,103,105,110,101,92,77
	dw	101,100,105,97,92,109,111,100,101,108,115,92,67,105,116,121
	dw	92,122,111,110,101,97,46,51,68,83
