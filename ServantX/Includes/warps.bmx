'warping Grids

'Zone 1 Alinon
'Forest Of Alinon
Global warp1 = xCreateCube()

xScaleEntity warp1,3,500,2554
xPositionEntity warp1,0,0,0
xEntityType warp1,6
xEntityRadius warp1,4
xEntityAlpha warp1,0

Global warp2 = xCopyEntity(warp1)
xRotateEntity warp2,0,90,0
xPositionEntity warp2,0,0,2557
xEntityType warp2,6
xEntityRadius warp2,4

Global warp3 = xCopyEntity(warp1)
xPositionEntity warp3,2545,0,0
xEntityType warp3,6
xEntityRadius warp3,4

Global warp5 = xCopyEntity(warp1)
xRotateEntity warp5,0,90,0
xPositionEntity warp5,0,0,0
xEntityType warp5,6
xEntityRadius warp5,4


'Global warp4 = CreateCube(Tombentrance)
'EntityRadius warp4,4
'EntityType warp4,6
'~IDEal Editor Parameters:
'~C#Blitz3D