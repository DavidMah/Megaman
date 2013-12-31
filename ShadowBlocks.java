/* Name: David
 * File: ShadowBlocks.java
 * Description: TODO: Describe what this file does
 */
import acm.graphics.*;
public class ShadowBlocks extends GCompound
{
	public ShadowBlocks()
	{
	GPolygon Wall = new GPolygon(370.0, 125.0);
	add(Wall);
	Wall.addVertex(370.0, 125.0);
	Wall.addVertex(369.0, 955.0);
	Wall.addVertex(496.0, 955.0);
	Wall.addVertex(496.0, 1276.0);
	Wall.addVertex(370.0, 1277.0);
	Wall.addVertex(368.0, 1979.0);
	Wall.addVertex(497.0, 1979.0);
	Wall.addVertex(498.0, 1916.0);
	Wall.addVertex(626.0, 1915.0);
	Wall.addVertex(625.0, 1978.0);
	Wall.addVertex(817.0, 1978.0);
	Wall.addVertex(817.0, 1915.0);
	Wall.addVertex(1201.0, 1915.0);
	Wall.addVertex(1201.0, 2173.0);
	Wall.addVertex(944.0, 2173.0);
	Wall.addVertex(942.0, 2301.0);
	Wall.addVertex(882.0, 2302.0);
	Wall.addVertex(882.0, 2874.0);
	Wall.addVertex(1395.0, 2873.0);
	Wall.addVertex(1395.0, 3001.0);
	Wall.addVertex(1650.0, 2999.0);
	Wall.addVertex(1650.0, 2937.0);
	Wall.addVertex(1713.0, 2936.0);
	Wall.addVertex(1715.0, 2842.0);
	Wall.addVertex(1905.0, 2843.0);
	Wall.addVertex(1908.0, 3000.0);
	Wall.addVertex(2033.0, 2999.0);
	Wall.addVertex(2035.0, 2938.0);
	Wall.addVertex(2162.0, 2937.0);
	Wall.addVertex(2163.0, 2876.0);
	Wall.addVertex(2288.0, 2873.0);
	Wall.addVertex(2289.0, 2937.0);
	Wall.addVertex(2353.0, 2939.0);
	Wall.addVertex(2354.0, 3000.0);
	Wall.addVertex(2482.0, 2999.0);
	Wall.addVertex(2482.0, 2938.0);
	Wall.addVertex(2547.0, 2936.0);
	Wall.addVertex(2549.0, 2873.0);
	Wall.addVertex(2610.0, 2875.0);
	Wall.addVertex(2610.0, 2939.0);
	Wall.addVertex(2740.0, 2939.0);
	Wall.addVertex(2740.0, 2874.0);
	Wall.addVertex(2803.0, 2874.0);
	Wall.addVertex(2804.0, 2809.0);
	Wall.addVertex(2865.0, 2809.0);
	Wall.addVertex(2866.0, 2936.0);
	Wall.addVertex(2928.0, 2938.0);
	Wall.addVertex(2930.0, 3000.0);
	Wall.addVertex(2995.0, 3000.0);
	Wall.addVertex(2994.0, 2875.0);
	Wall.addVertex(3059.0, 2872.0);
	Wall.addVertex(3060.0, 2810.0);
	Wall.addVertex(3119.0, 2810.0);
	Wall.addVertex(3121.0, 2872.0);
	Wall.addVertex(3248.0, 2872.0);
	Wall.addVertex(3251.0, 2777.0);
	Wall.addVertex(3313.0, 2777.0);
	Wall.addVertex(3313.0, 2937.0);
	Wall.addVertex(3378.0, 2938.0);
	Wall.addVertex(3379.0, 3002.0);
	Wall.addVertex(3504.0, 2999.0);
	Wall.addVertex(3506.0, 2937.0);
	Wall.addVertex(3571.0, 2935.0);
	Wall.addVertex(3572.0, 2875.0);
	Wall.addVertex(3697.0, 2876.0);
	Wall.addVertex(3697.0, 2936.0);
	Wall.addVertex(3826.0, 2938.0);
	Wall.addVertex(3826.0, 2873.0);
	Wall.addVertex(3892.0, 2873.0);
	Wall.addVertex(3894.0, 2810.0);
	Wall.addVertex(3951.0, 2811.0);
	Wall.addVertex(3955.0, 2871.0);
	Wall.addVertex(4015.0, 2873.0);
	Wall.addVertex(4018.0, 2937.0);
	Wall.addVertex(4144.0, 2936.0);
	Wall.addVertex(4147.0, 2875.0);
	Wall.addVertex(4272.0, 2874.0);
	Wall.addVertex(4272.0, 3193.0);
	Wall.addVertex(3955.0, 3193.0);
	Wall.addVertex(3952.0, 3514.0);
	Wall.addVertex(4943.0, 3514.0);
	Wall.addVertex(4944.0, 3705.0);
	Wall.addVertex(5390.0, 3705.0);
	Wall.addVertex(5390.0, 4000.0);
	Wall.addVertex(0.0, 4000.0);
	Wall.addVertex(0.0, 0.0);

	GPolygon RightWall = new GPolygon();
	
	RightWall.addVertex(5390.0, 3705.0);
	RightWall.addVertex(5394.0, 3389.0);
	RightWall.addVertex(4018.0, 3385.0);
	RightWall.addVertex(4018.0, 3322.0);
	RightWall.addVertex(4338.0, 3319.0);
	RightWall.addVertex(4337.0, 2616.0);
	RightWall.addVertex(1330.0, 1594.0);
	RightWall.addVertex(1327.0, 2616.0);
	RightWall.addVertex(1391.0, 2618.0);
	RightWall.addVertex(1392.0, 2744.0);
	RightWall.addVertex(947.0, 2743.0);
	RightWall.addVertex(945.0, 2491.0);
	RightWall.addVertex(1267.0, 2491.0);
	RightWall.addVertex(1265.0, 1786.0);
	RightWall.addVertex(752.0, 1785.0);
	RightWall.addVertex(752.0, 1727.0);
	RightWall.addVertex(496.0, 1724.0);
	RightWall.addVertex(497.0, 1405.0);
	RightWall.addVertex(627.0, 1402.0);
	RightWall.addVertex(629.0, 959.0);
	RightWall.addVertex(753.0, 954.0);
	RightWall.addVertex(753.0, 125.0);
	RightWall.addVertex(370.0, 124.0);
	
	GPolygon Block1 = new GPolygon();
	add(Block1);
	Block1.addVertex(498.0, 443.0);
	Block1.addVertex(626.0, 444.0);
	Block1.addVertex(625.0, 699.0);
	Block1.addVertex(498.0, 698.0);


	GPolygon Block2 = new GPolygon();
	add(Block2);
	Block2.addVertex(530.0, 860.0);
	Block2.addVertex(530.0, 892.0);
	Block2.addVertex(590.0, 893.0);
	Block2.addVertex(591.0, 860.0);

	}
}
