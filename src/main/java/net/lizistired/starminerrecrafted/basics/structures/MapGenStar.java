package net.lizistired.starminerrecrafted.basics.structures;
//todo get this whole thing to work, some old Forge functions need redoing for Fabric
//
//
//import net.minecraft.block.Block;
//import net.minecraft.structure.StructureStart;
//import net.minecraft.util.math.MathHelper;
//import net.minecraft.world.World;
//import net.lizistired.starminerrecrafted.basics.structures.StructureStarStart;
//
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Random;
//
//public class MapGenStar {
//    public int maxDistanceBetweenStars;
//    public int minDistanceBetweenStars;
//
//    public MapGenStar() {
//        this.maxDistanceBetweenStars = 16;
//        this.minDistanceBetweenStars = 8;
//    }
//
//    public MapGenStar(Map par1Map) {
//        this();
//        Iterator iterator = par1Map.entrySet().iterator();
//
//        while(iterator.hasNext()) {
//            Map.Entry entry = (Map.Entry)iterator.next();
//            if (((String)entry.getKey()).equals("distance")) {
//                this.maxDistanceBetweenStars = MathHelper.parseIntWithDefaultAndMax((String)entry.getValue(), this.maxDistanceBetweenStars, this.minDistanceBetweenStars + 1);
//            }
//        }
//
//    }
//
//    public boolean generateStructuresImmidiateInChunk(World par1World, Random par2Random, int par3, int par4, Block[] blocksData, byte[] blockMetas) {
//        int k = par3 << 4;
//        int l = par4 << 4;
//        boolean flag = false;
//        Iterator iterator = this.structureMap.values().iterator();
//
//        while(iterator.hasNext()) {
//            StructureStarStart structurestart = (StructureStarStart)iterator.next();
//            if (structurestart.isSizeableStructure() && structurestart.getBoundingBox().intersectsWith(k, l, k + 15, l + 15)) {
//                structurestart.generateStructureImmidiate(par1World, par2Random, new StructureBoundingBox(k, l, k + 15, l + 15), blocksData, blockMetas);
//                flag = true;
//            }
//        }
//
//        return flag;
//    }
//
//    public String func_143025_a() {
//        return "Star";
//    }
//
//    protected boolean canSpawnStructureAtCoords(int parX, int parY) {
//        int k = parX;
//        int l = parY;
//        if (parX < 0) {
//            parX -= this.maxDistanceBetweenStars - 1;
//        }
//
//        if (parY < 0) {
//            parY -= this.maxDistanceBetweenStars - 1;
//        }
//
//        int i1 = parX / this.maxDistanceBetweenStars;
//        int j1 = parY / this.maxDistanceBetweenStars;
//        Random random = this.worldObj.setRandomSeed(i1, j1, 58939324);
//        i1 *= this.maxDistanceBetweenStars;
//        j1 *= this.maxDistanceBetweenStars;
//        i1 += random.nextInt(this.maxDistanceBetweenStars - this.minDistanceBetweenStars);
//        j1 += random.nextInt(this.maxDistanceBetweenStars - this.minDistanceBetweenStars);
//        return k == i1 && l == j1;
//    }
//
//    protected StructureStart getStructureStart(int par1, int par2) {
//        return new StructureStarStart(this.worldObj, this.rand, par1, par2);
//    }
//}
//