package net.lizistired.starminerrecrafted.basics.structures;
//todo get this whole thing to work, some old Forge functions need redoing for Fabric


//import net.minecraft.block.Block;
//import net.minecraft.nbt.NbtCompound;
//import net.minecraft.util.math.BlockBox;
//import net.minecraft.world.World;
//import net.lizistired.starminerrecrafted.basics.structures.ComponentStar;
//
//import java.util.Iterator;
//import java.util.Random;
//
//public class StructureStarStart {
//    public StructureStarStart(World par1World, Random par2Random, int par3, int par4) {
//        super(par3, par4);
//        ComponentStar componentStar = new ComponentStar(0, par2Random, (par3 << 4) + 2, (par4 << 4) + 2, par1World);
//        this.components.add(componentStar);
//        componentStar.buildComponent(componentStar, this.components, par2Random);
//        this.updateBoundingBox();
//        this.markAvailableHeight(par1World, par2Random, 68);
//    }
//
//    public void generateStructureImmidiate(World par1World, Random par2Random, BlockBox par3StructureBoundingBox, Block[] blocksData, byte[] blockMetas) {
//        Iterator iterator = this.components.iterator();
//
//        while(iterator.hasNext()) {
//            ComponentStar structurecomponent = (ComponentStar)iterator.next();
//            if (structurecomponent.getBoundingBox().intersectsWith(par3StructureBoundingBox) && !structurecomponent.addComponentParts(par1World, par2Random, par3StructureBoundingBox, blocksData, blockMetas)) {
//                iterator.remove();
//            }
//        }
//
//    }
//
//    public void func_143022_a(NbtCompound par1NBTTagCompound) {
//    }
//
//    public void func_143017_b(NbtCompound par1NBTTagCompound) {
//    }
//}
//