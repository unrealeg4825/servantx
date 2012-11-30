;warping Grids

;Zone 1 Alinon
;Forest Of Alinon
Global warp1 = CreateCube()

ScaleEntity warp1,3,500,2554
PositionEntity warp1,0,0,0
EntityType warp1,6
EntityRadius warp1,4
EntityAlpha warp1,0

Global warp2 = CopyEntity(warp1)
RotateEntity warp2,0,90,0
PositionEntity warp2,0,0,2557
EntityType warp2,6
EntityRadius warp2,4

Global warp3 = CopyEntity(warp1)
PositionEntity warp3,2545,0,0
EntityType warp3,6
EntityRadius warp3,4

Global warp5 = CopyEntity(warp1)
RotateEntity warp5,0,90,0
PositionEntity warp5,0,0,0
EntityType warp5,6
EntityRadius warp5,4


;Global warp4 = CreateCube(Tombentrance)
;EntityRadius warp4,4
;EntityType warp4,6
;~IDEal Editor Parameters:
;~C#Blitz3D