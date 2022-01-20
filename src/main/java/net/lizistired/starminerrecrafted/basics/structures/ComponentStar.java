package net.lizistired.starminerrecrafted.basics.structures;
//todo get this whole thing to work, some old Forge functions need redoing for Fabric, this is the big one

/* import jp.mc.ancientred.starminer.api.IZeroGravityWorldProvider;
import jp.mc.ancientred.starminer.basics.SMModContainer;
import jp.mc.ancientred.starminer.basics.block.gravitized.WorldGenForestG;
import jp.mc.ancientred.starminer.basics.block.gravitized.WorldGenSavannaTreeG;
import jp.mc.ancientred.starminer.basics.block.gravitized.WorldGenTaiga2G;
import jp.mc.ancientred.starminer.basics.block.gravitized.WorldGenTreesG;
import jp.mc.ancientred.starminer.basics.tileentity.TileEntityGravityGenerator;
 */



/* import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComponentStar {
    private int starRad;
    private int ringRad;
    private int centerY;
    private int starSeed;
    private final Random rand = new Random();
    private final WorldGenForestG wordGenForestG = new WorldGenForestG(false);
    private final WorldGenSavannaTreeG worldGenSavannaTreeG = new WorldGenSavannaTreeG(false);
    private final WorldGenTreesG worldGenTreesG = new WorldGenTreesG(false);
    private final WorldGenTaiga2G worldGenTaiga2G = new WorldGenTaiga2G(false);
    private final ComponentStar.BlockMeta GRASSSET_GRASS;
    private final ComponentStar.BlockMeta GRASSSET_FERN;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_DANDELION;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_POPPY;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_BLUEORCHID;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_ALLIUM;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_HOUSTONIA;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_TULIPRED;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_TULIPORANGE;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_TULIPWHITE;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_TULIPPINK;
    private final ComponentStar.BlockMeta GRASSSET_PLANT_OXEYEDAISY;
    private final ComponentStar.TreeSet TREESET_OAK;
    private final ComponentStar.TreeSet TREESET_SPRUCE;
    private final ComponentStar.TreeSet TREESET_BIRCH;
    private final ComponentStar.TreeSet TREESET_JUNGLE;
    private final ComponentStar.TreeSet TREESET_ACACIA;
    private final ComponentStar.TreeSet TREESET_ROOFED_OAK;
    private final ComponentStar.BlockMeta GRASSSET_GROWSTONE;
    private final ComponentStar.BlockMeta[][] GRASSSET_LST;
    private final ComponentStar.TreeSet[][] TREESET_LST;
    private static ComponentStar.StarBiomeType[] STAR_BIOMES = new ComponentStar.StarBiomeType[0];
    public static Block[] BEDROCK_BLOCKS;
    public static Block[] ORE_BLOCKS;
    public static Block[] ORE_BLOCKS_RARE;
    public static Block[] ORE_BLOCKS_S_RARE;

    public ComponentStar() {
        this.GRASSSET_GRASS = new ComponentStar.BlockMeta(SMModContainer.TallGrassGravitizedBlock, 1);
        this.GRASSSET_FERN = new ComponentStar.BlockMeta(SMModContainer.TallGrassGravitizedBlock, 2);
        this.GRASSSET_PLANT_DANDELION = new ComponentStar.BlockMeta(SMModContainer.PlantYelGravitizedBlock, 0);
        this.GRASSSET_PLANT_POPPY = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 0);
        this.GRASSSET_PLANT_BLUEORCHID = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 1);
        this.GRASSSET_PLANT_ALLIUM = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 2);
        this.GRASSSET_PLANT_HOUSTONIA = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 3);
        this.GRASSSET_PLANT_TULIPRED = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 4);
        this.GRASSSET_PLANT_TULIPORANGE = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 5);
        this.GRASSSET_PLANT_TULIPWHITE = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 6);
        this.GRASSSET_PLANT_TULIPPINK = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 7);
        this.GRASSSET_PLANT_OXEYEDAISY = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 8);
        this.TREESET_OAK = new ComponentStar.TreeSet(0, false);
        this.TREESET_SPRUCE = new ComponentStar.TreeSet(1, false);
        this.TREESET_BIRCH = new ComponentStar.TreeSet(2, false);
        this.TREESET_JUNGLE = new ComponentStar.TreeSet(3, false);
        this.TREESET_ACACIA = new ComponentStar.TreeSet(0, true);
        this.TREESET_ROOFED_OAK = new ComponentStar.TreeSet(1, true);
        this.GRASSSET_GROWSTONE = new ComponentStar.BlockMeta(Blocks.GLOWSTONE, 0);
        this.GRASSSET_LST = new ComponentStar.BlockMeta[][]{{this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_PLANT_DANDELION, this.GRASSSET_PLANT_POPPY}, {this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_PLANT_DANDELION, this.GRASSSET_PLANT_POPPY, this.GRASSSET_PLANT_BLUEORCHID, this.GRASSSET_PLANT_ALLIUM, this.GRASSSET_PLANT_HOUSTONIA, this.GRASSSET_PLANT_TULIPRED, this.GRASSSET_PLANT_TULIPORANGE, this.GRASSSET_PLANT_TULIPWHITE, this.GRASSSET_PLANT_TULIPPINK, this.GRASSSET_PLANT_OXEYEDAISY}, {this.GRASSSET_FERN}, {this.GRASSSET_GRASS}};
        this.TREESET_LST = new ComponentStar.TreeSet[][]{{this.TREESET_OAK}, {this.TREESET_SPRUCE}, {this.TREESET_BIRCH}, {this.TREESET_JUNGLE}, {this.TREESET_ACACIA}, {this.TREESET_ROOFED_OAK}, {this.TREESET_OAK, this.TREESET_SPRUCE, this.TREESET_BIRCH, this.TREESET_JUNGLE, this.TREESET_ACACIA, this.TREESET_ROOFED_OAK}};
    }

    public ComponentStar(int par1, Random par2Random, int par3, int par4, World world) {
        super(par1);
        this.GRASSSET_GRASS = new ComponentStar.BlockMeta(SMModContainer.TallGrassGravitizedBlock, 1);
        this.GRASSSET_FERN = new ComponentStar.BlockMeta(SMModContainer.TallGrassGravitizedBlock, 2);
        this.GRASSSET_PLANT_DANDELION = new ComponentStar.BlockMeta(SMModContainer.PlantYelGravitizedBlock, 0);
        this.GRASSSET_PLANT_POPPY = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 0);
        this.GRASSSET_PLANT_BLUEORCHID = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 1);
        this.GRASSSET_PLANT_ALLIUM = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 2);
        this.GRASSSET_PLANT_HOUSTONIA = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 3);
        this.GRASSSET_PLANT_TULIPRED = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 4);
        this.GRASSSET_PLANT_TULIPORANGE = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 5);
        this.GRASSSET_PLANT_TULIPWHITE = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 6);
        this.GRASSSET_PLANT_TULIPPINK = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 7);
        this.GRASSSET_PLANT_OXEYEDAISY = new ComponentStar.BlockMeta(SMModContainer.PlantRedGravitizedBlock, 8);
        this.TREESET_OAK = new ComponentStar.TreeSet(0, false);
        this.TREESET_SPRUCE = new ComponentStar.TreeSet(1, false);
        this.TREESET_BIRCH = new ComponentStar.TreeSet(2, false);
        this.TREESET_JUNGLE = new ComponentStar.TreeSet(3, false);
        this.TREESET_ACACIA = new ComponentStar.TreeSet(0, true);
        this.TREESET_ROOFED_OAK = new ComponentStar.TreeSet(1, true);
        this.GRASSSET_GROWSTONE = new ComponentStar.BlockMeta(Blocks.GLOWSTONE, 0);
        this.GRASSSET_LST = new ComponentStar.BlockMeta[][]{{this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_PLANT_DANDELION, this.GRASSSET_PLANT_POPPY}, {this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_GRASS, this.GRASSSET_PLANT_DANDELION, this.GRASSSET_PLANT_POPPY, this.GRASSSET_PLANT_BLUEORCHID, this.GRASSSET_PLANT_ALLIUM, this.GRASSSET_PLANT_HOUSTONIA, this.GRASSSET_PLANT_TULIPRED, this.GRASSSET_PLANT_TULIPORANGE, this.GRASSSET_PLANT_TULIPWHITE, this.GRASSSET_PLANT_TULIPPINK, this.GRASSSET_PLANT_OXEYEDAISY}, {this.GRASSSET_FERN}, {this.GRASSSET_GRASS}};
        this.TREESET_LST = new ComponentStar.TreeSet[][]{{this.TREESET_OAK}, {this.TREESET_SPRUCE}, {this.TREESET_BIRCH}, {this.TREESET_JUNGLE}, {this.TREESET_ACACIA}, {this.TREESET_ROOFED_OAK}, {this.TREESET_OAK, this.TREESET_SPRUCE, this.TREESET_BIRCH, this.TREESET_JUNGLE, this.TREESET_ACACIA, this.TREESET_ROOFED_OAK}};
        this.starSeed = par2Random.nextInt();
        if (world.provider instanceof IZeroGravityWorldProvider) {
            if (par2Random.nextInt(5) == 1) {
                this.starRad = 24 + par2Random.nextInt(12);
                this.ringRad = this.getExpandBoundRad();
                this.centerY = 77 + par2Random.nextInt(50);
            } else {
                this.starRad = 24 + par2Random.nextInt(30);
                this.ringRad = 0;
                this.centerY = 57 + par2Random.nextInt(70);
            }
        } else {
            this.starRad = 10 + par2Random.nextInt(12);
            this.ringRad = 0;
            this.centerY = 100 + par2Random.nextInt(80);
        }

        int bound = this.starRad + 2 + this.getExpandBoundRad();
        this.boundingBox = new StructureBoundingBox(par3 - bound, this.centerY - bound, par4 - bound, par3 + bound, this.centerY + bound, par4 + bound);
    }

    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random) {
    }

    private int getExpandBoundRad() {
        return (int)((float)this.starRad * 1.2F);
    }

    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox chunkBoundingBox) {
        this.rand.setSeed((long)(this.starSeed + this.boundingBox.minX + this.boundingBox.minZ));
        int cx = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minX;
        int cy = this.centerY;
        int cz = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minZ;
        if (!(par1World.provider instanceof IZeroGravityWorldProvider)) {
            Block surfaceBlockA = BEDROCK_BLOCKS[this.rand.nextInt(BEDROCK_BLOCKS.length)];
            int rad = this.starRad - 1;
            int xMin = chunkBoundingBox.minX;
            int xMax = chunkBoundingBox.maxX;
            int yMin = cy - rad;
            int yMax = cy + rad;
            int zMin = chunkBoundingBox.minZ;
            int zMax = chunkBoundingBox.maxZ;
            double radPow = rad * rad;
            double var10000 = (rad + 1) * (rad + 1);
            double radSub3Pow = (rad - 3) * (rad - 3);
            double radSub4Pow = (rad - 4) * (rad - 4);

            for(int x = xMin; x <= xMax; ++x) {
                double xFar = x - cx;
                xFar *= xFar;
                if (!(xFar >= radPow)) {
                    for(int y = yMin; y <= yMax; ++y) {
                        if (y >= 0 && 255 >= y) {
                            double yFar = y - cy;
                            yFar *= yFar;
                            double xyFar = xFar + yFar;
                            if (!(xyFar >= radPow)) {
                                for(int z = zMin; z <= zMax; ++z) {
                                    double zFar = z - cz;
                                    zFar *= zFar;
                                    double distancePow = xyFar + zFar;
                                    if (distancePow < radPow) {
                                        if (distancePow > radSub3Pow) {
                                            par1World.setBlock(x, y, z, surfaceBlockA, 0, 2);
                                        } else if (distancePow > radSub4Pow) {
                                            int randInt = this.rand.nextInt(700);
                                            if (randInt < 1) {
                                                par1World.setBlock(x, y, z, ORE_BLOCKS_S_RARE[this.rand.nextInt(ORE_BLOCKS_S_RARE.length)], 0, 2);
                                            } else if (randInt < 8) {
                                                par1World.setBlock(x, y, z, ORE_BLOCKS_RARE[this.rand.nextInt(ORE_BLOCKS_RARE.length)], 0, 2);
                                            } else if (randInt < 80) {
                                                par1World.setBlock(x, y, z, ORE_BLOCKS[this.rand.nextInt(ORE_BLOCKS.length)], 0, 2);
                                            } else {
                                                par1World.setBlock(x, y, z, surfaceBlockA, 0, 2);
                                            }
                                        } else if (distancePow < 6.25D) {
                                            par1World.setBlock(x, y, z, SMModContainer.InnerCoreBlock, 0, 2);
                                        } else if (distancePow < 16.0D) {
                                            par1World.setBlock(x, y, z, SMModContainer.OuterCoreBlock, 0, 2);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (chunkBoundingBox.isVecInside(cx, cy, cz)) {
            this.placeBlockAtCurrentPosition(par1World, SMModContainer.GravityCoreBlock, 0, cx, cy, cz, chunkBoundingBox);
            TileEntityGravityGenerator tileEntityGravity = (TileEntityGravityGenerator)par1World.getTileEntity(cx, cy, cz);
            tileEntityGravity.starRad = this.starRad;
            tileEntityGravity.gravityRange = this.starRad + 8;
            tileEntityGravity.resetWorkState();
        }

        return true;
    }

    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox chunkBoundingBox, Block[] blocksData, byte[] blockMetas) {
        this.rand.setSeed((long)(this.starSeed + this.boundingBox.minX + this.boundingBox.minZ));
        boolean makeDimples = this.rand.nextBoolean();
        jp.mc.ancientred.starminer.basics.structure.ComponentStar.StarBiomeType starBiome = STAR_BIOMES[this.rand.nextInt(STAR_BIOMES.length)];
        Block surfaceBlockB = BEDROCK_BLOCKS[this.rand.nextInt(BEDROCK_BLOCKS.length)];
        Block surfaceBlockA = starBiome.sufBlock;
        int cx = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minX;
        int cy = this.centerY;
        int cz = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minZ;
        int rad = this.starRad;
        int xMin = chunkBoundingBox.minX;
        int xMax = chunkBoundingBox.maxX;
        int yMin = cy - (rad + 2);
        int yMax = cy + rad + 2;
        int zMin = chunkBoundingBox.minZ;
        int zMax = chunkBoundingBox.maxZ;
        double radPow = rad * rad;
        double radPls1Pow = (rad + 1) * (rad + 1);
        double radPls3Pow = (rad + 2) * (rad + 2);
        double radSub1Pow = (rad - 1) * (rad - 1);
        double radSub3Pow = (rad - 3) * (rad - 3);
        double radSub4Pow = (rad - 4) * (rad - 4);
        boolean plantGrass = starBiome.grassRate > 0;

        for(int x = xMin; x <= xMax; ++x) {
            double xFar = x - cx;
            boolean xComp = xFar < 0.0D;
            xFar *= xFar;
            if (!(xFar > radPls3Pow)) {
                for(int y = yMin; y <= yMax; ++y) {
                    if (y >= 0 && 255 >= y) {
                        double yFar = y - cy;
                        boolean yComp = yFar < 0.0D;
                        yFar *= yFar;
                        double xyFar = xFar + yFar;
                        if (!(xyFar > radPls3Pow)) {
                            for(int z = zMin; z <= zMax; ++z) {
                                double zFar = z - cz;
                                boolean zComp = zFar < 0.0D;
                                zFar *= zFar;
                                double distancePow = xyFar + zFar;
                                int targetIdIndex;
                                if (distancePow < radPow) {
                                    targetIdIndex = y << 8 | z - zMin << 4 | x - xMin;
                                    blocksData[targetIdIndex] = Blocks.AIR;
                                    blockMetas[targetIdIndex] = 0;
                                    if (distancePow > radSub3Pow) {
                                        if (distancePow >= radSub1Pow) {
                                            blocksData[targetIdIndex] = surfaceBlockA;
                                            blockMetas[targetIdIndex] = 0;
                                        } else {
                                            blocksData[targetIdIndex] = surfaceBlockB;
                                            blockMetas[targetIdIndex] = 0;
                                        }
                                    } else if (distancePow > radSub4Pow) {
                                        int randInt = this.rand.nextInt(700);
                                        if (randInt < 1) {
                                            blocksData[targetIdIndex] = ORE_BLOCKS_S_RARE[this.rand.nextInt(ORE_BLOCKS_S_RARE.length)];
                                            blockMetas[targetIdIndex] = 0;
                                        } else if (randInt < 8) {
                                            blocksData[targetIdIndex] = ORE_BLOCKS_RARE[this.rand.nextInt(ORE_BLOCKS_RARE.length)];
                                            blockMetas[targetIdIndex] = 0;
                                        } else if (randInt < 80) {
                                            blocksData[targetIdIndex] = ORE_BLOCKS[this.rand.nextInt(ORE_BLOCKS.length)];
                                            blockMetas[targetIdIndex] = 0;
                                        } else {
                                            blocksData[targetIdIndex] = surfaceBlockB;
                                            blockMetas[targetIdIndex] = 0;
                                        }
                                    } else if (distancePow < 6.25D) {
                                        blocksData[targetIdIndex] = SMModContainer.InnerCoreBlock;
                                        blockMetas[targetIdIndex] = 0;
                                    } else if (distancePow < 16.0D) {
                                        blocksData[targetIdIndex] = SMModContainer.OuterCoreBlock;
                                        blockMetas[targetIdIndex] = 0;
                                    }
                                } else if (distancePow < radPls1Pow) {
                                    if (plantGrass && this.rand.nextInt(100) <= starBiome.grassRate && (!(Math.abs(xFar - zFar) <= radPow * 0.1D) || !(yFar <= radPow * 0.5D)) && (!(Math.abs(xFar - yFar) <= radPow * 0.1D) || !(zFar <= radPow * 0.5D)) && (!(Math.abs(yFar - zFar) <= radPow * 0.1D) || !(xFar <= radPow * 0.5D))) {
                                        double fixedFar;
                                        if (xFar > zFar && xFar > yFar) {
                                            if (xComp) {
                                                fixedFar = x + 1 - cx;
                                            } else {
                                                fixedFar = x - 1 - cx;
                                            }

                                            fixedFar *= fixedFar;
                                            distancePow = fixedFar + yFar + zFar;
                                        } else if (zFar >= xFar && zFar > yFar) {
                                            if (zComp) {
                                                fixedFar = z + 1 - cz;
                                            } else {
                                                fixedFar = z - 1 - cz;
                                            }

                                            fixedFar *= fixedFar;
                                            distancePow = xFar + yFar + fixedFar;
                                        } else {
                                            if (yComp) {
                                                fixedFar = y + 1 - cy;
                                            } else {
                                                fixedFar = y - 1 - cy;
                                            }

                                            fixedFar *= fixedFar;
                                            distancePow = xFar + fixedFar + zFar;
                                        }

                                        if (!(distancePow >= radPow) || !(distancePow < radPls1Pow)) {
                                            targetIdIndex = y << 8 | z - zMin << 4 | x - xMin;
                                            ComponentStar.BlockMeta[] grassSet = this.GRASSSET_LST[starBiome.grassSet];
                                            ComponentStar.BlockMeta grass = grassSet[this.rand.nextInt(grassSet.length)];
                                            blocksData[targetIdIndex] = grass.block;
                                            blockMetas[targetIdIndex] = (byte)grass.meta;
                                        }
                                    }
                                } else if (distancePow <= radPls3Pow) {
                                    targetIdIndex = y << 8 | z - zMin << 4 | x - xMin;
                                    if (blocksData[targetIdIndex] == null) {
                                        byte meta;
                                        if (xFar > zFar && xFar > yFar) {
                                            if (xComp) {
                                                meta = 3;
                                            } else {
                                                meta = 2;
                                            }
                                        } else if (zFar >= xFar && zFar > yFar) {
                                            if (zComp) {
                                                meta = 5;
                                            } else {
                                                meta = 4;
                                            }
                                        } else if (yComp) {
                                            meta = 1;
                                        } else {
                                            meta = 0;
                                        }

                                        blocksData[targetIdIndex] = Blocks.AIR;
                                        blockMetas[targetIdIndex] = (byte)(meta + 1);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        if (this.ringRad != 0) {
            this.makeRing(par1World, par2Random, chunkBoundingBox, blocksData, blockMetas);
        }

        if (starBiome.treeRate > 0) {
            this.makeTrees(par1World, par2Random, chunkBoundingBox, blocksData, blockMetas, starBiome);
        } else if (makeDimples) {
            this.makeDimples(par1World, par2Random, chunkBoundingBox, blocksData, blockMetas, surfaceBlockA);
        }

        return true;
    }

    private void makeRing(World par1World, Random par2Random, StructureBoundingBox chunkBoundingBox, Block[] blocksData, byte[] blockMetas) {
        this.rand.setSeed(this.starSeed);
        int ringRoatX = this.rand.nextInt(90);
        int ringRoatZ = this.rand.nextInt(90);
        int rad = this.starRad + this.getExpandBoundRad();
        int wa = (int)((float)this.starRad * 0.7F);
        int cx = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minX;
        int cy = this.centerY;
        int cz = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minZ;
        int prevPosX = 0;
        int posX = false;
        int prevPosY = 0;
        int posY = false;
        int prevPosZ = 0;
        int posZ = false;
        byte blockColorToUse = 0;
        int colorCnt = 0;

        for(int distance = rad - wa; distance <= rad; ++colorCnt) {
            if ((colorCnt & 1) == 0) {
                blockColorToUse = (byte)this.rand.nextInt(16);
            }

            for(int angle = 0; angle < 360; ++angle) {
                double dXYZ0 = Math.cos((double)angle * 3.141592653589793D / 180.0D) * (double)distance;
                double dXYZ1 = 0.0D;
                double dXYZ2 = Math.sin((double)angle * 3.141592653589793D / 180.0D) * (double)distance;
                float f1 = MathHelper.cos((float)ringRoatX);
                float f2 = MathHelper.sin((float)ringRoatX);
                double d1 = dXYZ1 * (double)f1 + dXYZ2 * (double)f2;
                double d2 = dXYZ2 * (double)f1 - dXYZ1 * (double)f2;
                f1 = MathHelper.cos((float)ringRoatZ);
                f2 = MathHelper.sin((float)ringRoatZ);
                double d0 = dXYZ0 * (double)f1 + d1 * (double)f2;
                d1 = d1 * (double)f1 - dXYZ0 * (double)f2;
                int posX = cx + (int)d0;
                int posY = cy + (int)d1;
                int posZ = cz + (int)d2;
                if ((prevPosX != posX || prevPosY != posY || prevPosZ != posZ) && posY >= 0 && posY <= 255 && posX >= chunkBoundingBox.minX && posX <= chunkBoundingBox.maxX && posZ >= chunkBoundingBox.minZ && posZ <= chunkBoundingBox.maxZ) {
                    int targetIdIndex = posY << 8 | posZ - chunkBoundingBox.minZ << 4 | posX - chunkBoundingBox.minX;
                    blocksData[targetIdIndex] = Blocks.BLUE_STAINED_GLASS;
                    blockMetas[targetIdIndex] = blockColorToUse;
                }

                prevPosX = posX;
                prevPosY = posY;
                prevPosZ = posZ;
            }

            ++distance;
        }

    }

    private void makeTrees(World par1World, Random par2Random, StructureBoundingBox chunkBoundingBox, Block[] blocksData, byte[] blockMetas, jp.mc.ancientred.starminer.basics.structure.ComponentStar.StarBiomeType starBiome) {
        this.rand.setSeed(this.starSeed);
        ComponentStar.TreeSet[] treeSets = this.TREESET_LST[this.rand.nextInt(this.TREESET_LST.length)];
        int cx = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minX;
        int cy = this.centerY;
        int cz = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minZ;
        int posX = false;
        int posY = false;
        int posZ = false;
        byte blockColorToUse = false;
        int workDistance = this.starRad;
        this.wordGenForestG.setChunkProviderSupportData(chunkBoundingBox, blocksData, blockMetas);
        this.worldGenSavannaTreeG.setChunkProviderSupportData(chunkBoundingBox, blocksData, blockMetas);
        this.worldGenTreesG.setChunkProviderSupportData(chunkBoundingBox, blocksData, blockMetas);
        this.worldGenTaiga2G.setChunkProviderSupportData(chunkBoundingBox, blocksData, blockMetas);
        int genCount = (int)(12.566370614359172D * (double)this.starRad * (double)this.starRad * ((double)starBiome.treeRate / 1000.0D)) / 2;
        genCount += this.rand.nextInt(genCount);

        for(int i = 0; i < genCount; ++i) {
            int angle = this.rand.nextInt(360);
            int ringRoatX = this.rand.nextInt(90);
            int ringRoatZ = this.rand.nextInt(90);
            ComponentStar.TreeSet treeSet = treeSets[this.rand.nextInt(treeSets.length)];
            double dXYZ0 = Math.cos((double)angle * 3.141592653589793D / 180.0D) * (double)workDistance;
            double dXYZ1 = 0.0D;
            double dXYZ2 = Math.sin((double)angle * 3.141592653589793D / 180.0D) * (double)workDistance;
            float f1 = MathHelper.cos((float)ringRoatX);
            float f2 = MathHelper.sin((float)ringRoatX);
            double d1 = dXYZ1 * (double)f1 + dXYZ2 * (double)f2;
            double d2 = dXYZ2 * (double)f1 - dXYZ1 * (double)f2;
            f1 = MathHelper.cos((float)ringRoatZ);
            f2 = MathHelper.sin((float)ringRoatZ);
            double d0 = dXYZ0 * (double)f1 + d1 * (double)f2;
            d1 = d1 * (double)f1 - dXYZ0 * (double)f2;
            int posX = cx + (int)d0;
            int posY = cy + (int)d1;
            int posZ = cz + (int)d2;
            int targetIdIndex = posY << 8 | posZ - chunkBoundingBox.minZ << 4 | posX - chunkBoundingBox.minX;
            double xFar = posX - cx;
            boolean xComp = xFar < 0.0D;
            xFar *= xFar;
            double yFar = posY - cy;
            boolean yComp = yFar < 0.0D;
            yFar *= yFar;
            double zFar = posZ - cz;
            boolean zComp = zFar < 0.0D;
            zFar *= zFar;
            byte meta;
            if (xFar > zFar && xFar > yFar) {
                if (xComp) {
                    meta = 3;
                } else {
                    meta = 2;
                }
            } else if (zFar >= xFar && zFar > yFar) {
                if (zComp) {
                    meta = 5;
                } else {
                    meta = 4;
                }
            } else if (yComp) {
                meta = 1;
            } else {
                meta = 0;
            }

            int minTreeHeight = 4 + this.rand.nextInt(6);
            if (treeSet == this.TREESET_OAK) {
                this.worldGenTreesG.metaWood = 0;
                this.worldGenTreesG.metaLeaves = 0;
                this.worldGenTreesG.setAsNewTreeSet(false);
                this.worldGenTreesG.minTreeHeight = minTreeHeight;
                this.worldGenTreesG.dir = meta;
                this.worldGenTreesG.generate((World)null, this.rand, posX, posY, posZ);
            }

            if (treeSet == this.TREESET_SPRUCE) {
                this.worldGenTaiga2G.minTreeHeight = minTreeHeight;
                this.worldGenTaiga2G.dir = meta;
                this.worldGenTaiga2G.generate((World)null, this.rand, posX, posY, posZ);
            }

            if (treeSet == this.TREESET_BIRCH) {
                this.wordGenForestG.minTreeHeight = minTreeHeight;
                this.wordGenForestG.dir = meta;
                this.wordGenForestG.generate((World)null, this.rand, posX, posY, posZ);
            }

            if (treeSet == this.TREESET_JUNGLE) {
                this.worldGenTreesG.metaWood = 3;
                this.worldGenTreesG.metaLeaves = 3;
                this.worldGenTreesG.setAsNewTreeSet(false);
                this.worldGenTreesG.minTreeHeight = minTreeHeight;
                this.worldGenTreesG.dir = meta;
                this.worldGenTreesG.generate((World)null, this.rand, posX, posY, posZ);
            }

            if (treeSet == this.TREESET_ACACIA) {
                this.worldGenSavannaTreeG.minTreeHeight = minTreeHeight;
                this.worldGenSavannaTreeG.dir = meta;
                this.worldGenSavannaTreeG.generate((World)null, this.rand, posX, posY, posZ);
            }

            if (treeSet == this.TREESET_ROOFED_OAK) {
                this.worldGenTreesG.metaWood = 1;
                this.worldGenTreesG.metaLeaves = 1;
                this.worldGenTreesG.setAsNewTreeSet(true);
                this.worldGenTreesG.minTreeHeight = minTreeHeight;
                this.worldGenTreesG.dir = meta;
                this.worldGenTreesG.generate((World)null, this.rand, posX, posY, posZ);
            }
        }

    }

    private void makeDimples(World par1World, Random par2Random, StructureBoundingBox chunkBoundingBox, Block[] blocksData, byte[] blockMetas, Block surfaceBlock) {
        this.rand.setSeed(this.starSeed);
        int cx = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minX;
        int cy = this.centerY;
        int cz = this.starRad + 2 + this.getExpandBoundRad() + this.boundingBox.minZ;
        int dimpleCPosX = false;
        int posX = false;
        int dimpleCPosY = false;
        int posY = false;
        int dimpleCPosZ = false;
        int posZ = false;
        byte blockColorToUse = false;
        int workDistance = this.starRad + 4;
        double starRadPow = this.starRad * this.starRad;
        double var10000 = (this.starRad - 1) * (this.starRad - 1);
        double starRadPls2Pow = (this.starRad + 2) * (this.starRad + 2);

        for(int i = 0; i < 1; ++i) {
            int r = this.rand.nextInt(360);
            int ringRoatX = this.rand.nextInt(90);
            int ringRoatZ = this.rand.nextInt(90);
            int dimpleRad = this.starRad / 4 + this.rand.nextInt(this.starRad / 4);
            double dimpleRadPow = dimpleRad * dimpleRad;
            double dimpleRadSub1Pow = (dimpleRad - 2) * (dimpleRad - 2);
            double dXYZ0 = Math.cos((double)r * 3.141592653589793D / 180.0D) * (double)workDistance;
            double dXYZ1 = 0.0D;
            double dXYZ2 = Math.sin((double)r * 3.141592653589793D / 180.0D) * (double)workDistance;
            float f1 = MathHelper.cos((float)ringRoatX);
            float f2 = MathHelper.sin((float)ringRoatX);
            double d1 = dXYZ1 * (double)f1 + dXYZ2 * (double)f2;
            double d2 = dXYZ2 * (double)f1 - dXYZ1 * (double)f2;
            f1 = MathHelper.cos((float)ringRoatZ);
            f2 = MathHelper.sin((float)ringRoatZ);
            double d0 = dXYZ0 * (double)f1 + d1 * (double)f2;
            d1 = d1 * (double)f1 - dXYZ0 * (double)f2;
            int dimpleCPosX = cx + (int)d0;
            int dimpleCPosY = cy + (int)d1;
            int dimpleCPosZ = cz + (int)d2;
            int targetIdIndex = dimpleCPosY << 8 | dimpleCPosZ - chunkBoundingBox.minZ << 4 | dimpleCPosX - chunkBoundingBox.minX;

            for(int posX = dimpleCPosX - dimpleRad; posX <= dimpleCPosX + dimpleRad; ++posX) {
                double xFarFromDimpleC = posX - dimpleCPosX;
                xFarFromDimpleC *= xFarFromDimpleC;
                double xFarFromStarC = posX - cx;
                xFarFromStarC *= xFarFromStarC;
                if (!(xFarFromDimpleC > dimpleRadPow) && !(xFarFromStarC > starRadPls2Pow)) {
                    for(int posY = dimpleCPosY - dimpleRad; posY <= dimpleCPosY + dimpleRad; ++posY) {
                        if (posY >= 0 && 255 >= posY) {
                            double yFarFromDimpleC = posY - dimpleCPosY;
                            yFarFromDimpleC *= yFarFromDimpleC;
                            double xyFarFromDimpleC = xFarFromDimpleC + yFarFromDimpleC;
                            double yFarFromStarC = posY - cy;
                            yFarFromStarC *= yFarFromStarC;
                            double xyFarFromStarC = xFarFromStarC + yFarFromStarC;
                            if (!(xyFarFromDimpleC > dimpleRadPow) && !(xyFarFromStarC > starRadPls2Pow)) {
                                for(int posZ = dimpleCPosZ - dimpleRad; posZ <= dimpleCPosZ + dimpleRad; ++posZ) {
                                    double zFarFromDimpleC = posZ - dimpleCPosZ;
                                    zFarFromDimpleC *= zFarFromDimpleC;
                                    double xyzFarFromDimpleC = zFarFromDimpleC + xyFarFromDimpleC;
                                    double zFarFromStarC = posZ - cz;
                                    zFarFromStarC *= zFarFromStarC;
                                    double xyzFarFromStarC = zFarFromStarC + xyFarFromStarC;
                                    if (!(xyzFarFromDimpleC > dimpleRadPow) && !(xyzFarFromStarC > starRadPls2Pow)) {
                                        if (xyzFarFromDimpleC >= dimpleRadSub1Pow) {
                                            if (!(xyzFarFromStarC > starRadPow) && posX >= chunkBoundingBox.minX && posX <= chunkBoundingBox.maxX && posZ >= chunkBoundingBox.minZ && posZ <= chunkBoundingBox.maxZ) {
                                                targetIdIndex = posY << 8 | posZ - chunkBoundingBox.minZ << 4 | posX - chunkBoundingBox.minX;
                                                blocksData[targetIdIndex] = surfaceBlock;
                                                blockMetas[targetIdIndex] = 0;
                                            }
                                        } else if (xyzFarFromDimpleC < dimpleRadSub1Pow && posX >= chunkBoundingBox.minX && posX <= chunkBoundingBox.maxX && posZ >= chunkBoundingBox.minZ && posZ <= chunkBoundingBox.maxZ) {
                                            targetIdIndex = posY << 8 | posZ - chunkBoundingBox.minZ << 4 | posX - chunkBoundingBox.minX;
                                            blocksData[targetIdIndex] = Blocks.AIR;
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

    }

    protected void func_143012_a(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setInteger("starRad", this.starRad);
        par1NBTTagCompound.setInteger("ringRad", this.ringRad);
        par1NBTTagCompound.setInteger("centerY", this.centerY);
        par1NBTTagCompound.setInteger("starSeed", this.starSeed);
    }

    protected void func_143011_b(NBTTagCompound par1NBTTagCompound) {
        this.starRad = par1NBTTagCompound.getInteger("starRad");
        this.ringRad = par1NBTTagCompound.getInteger("ringRad");
        this.centerY = par1NBTTagCompound.getInteger("centerY");
        this.starSeed = par1NBTTagCompound.getInteger("starSeed");
    }

    static {
        STAR_BIOMES = ComponentStar.StarBiomeType.makeList(STAR_BIOMES);
        BEDROCK_BLOCKS = new Block[]{Blocks.DIRT, Blocks.SANDSTONE, Blocks.COBBLESTONE, Blocks.STONE, Blocks.NETHERRACK, Blocks.SPONGE, Blocks.CLAY};
        ORE_BLOCKS = new Block[]{Blocks.GLOWSTONE, Blocks.COAL_ORE, Blocks.IRON_ORE, Blocks.REDSTONE_ORE, Blocks.GLOWSTONE, Blocks.LAPIS_ORE};
        ORE_BLOCKS_RARE = new Block[]{Blocks.GOLD_ORE, Blocks.EMERALD_ORE, Blocks.DIAMOND_ORE, Blocks.IRON_BLOCK, Blocks.LAPIS_BLOCK};
        ORE_BLOCKS_S_RARE = new Block[]{Blocks.GOLD_BLOCK, Blocks.DIAMOND_BLOCK, Blocks.EMERALD_BLOCK};
    }

    private enum StarBiomeType {
        grassStar(SMModContainer.DirtGrassExBlock, 5, 50, 0, 0, 0),
        grassStarRich(SMModContainer.DirtGrassExBlock, 2, 40, 1, 0, 0),
        forestStar(SMModContainer.DirtGrassExBlock, 3, 15, 0, 20, 4),
        stoneStar(Blocks.STONE, 1, 10, 2, 0, 0),
        mossyStar(Blocks.MOSSY_COBBLESTONE, 1, 10, 2, 4, 3),
        snowStar(Blocks.SNOW, 1, 20, 3, 4, 2),
        iceStar(Blocks.PACKED_ICE, 1, 0, 0, 0, 0),
        spongeStar(Blocks.SPONGE, 1, 0, 0, 0, 0),
        clayStar(Blocks.CLAY, 1, 10, 3, 10, 0),
        netherStar(Blocks.NETHERRACK, 1, 0, 0, 0, 0),
        sandStoneStar(Blocks.SANDSTONE, 1, 0, 0, 0, 0);

        public Block sufBlock;
        public int frequency;
        public int grassRate;
        public int grassSet;
        public int treeRate;
        public int treeSet;

        StarBiomeType(Block argSurfBlock, int argFrequency, int argGrassRate, int argGrassSet, int argTreeRate, int argTreeSet) {
            this.sufBlock = argSurfBlock;
            this.frequency = argFrequency;
            this.grassRate = argGrassRate;
            this.grassSet = argGrassSet;
            this.treeRate = argTreeRate;
            this.treeSet = argTreeSet;
        }

        public static ComponentStar.StarBiomeType[] makeList(ComponentStar.StarBiomeType[] gen) {
            ArrayList<ComponentStar.StarBiomeType> list = new ArrayList();
            ComponentStar.StarBiomeType[] arr$ = values();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                ComponentStar.StarBiomeType elem = arr$[i$];

                for(int i = 0; i < elem.frequency; ++i) {
                    list.add(elem);
                }
            }

            return list.toArray(gen);
        }
    }

    private class TreeSet {
        public int meta;
        public boolean asNewTrees;

        public TreeSet(int meta, boolean asNewTrees) {
            this.meta = meta;
            this.asNewTrees = asNewTrees;
        }
    }

    private class BlockMeta {
        public Block block;
        public int meta;

        public BlockMeta(Block block, int meta) {
            this.block = block;
            this.meta = meta;
        }
    }
}
*/