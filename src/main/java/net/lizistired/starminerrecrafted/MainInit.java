package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lizistired.starminerrecrafted.basics.blocks.*;
import net.lizistired.starminerrecrafted.basics.blocks.bed.StarBedBodyBlock;
import net.lizistired.starminerrecrafted.basics.blocks.bed.StarBedHeadBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.Material;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static net.minecraft.util.math.Direction.*;


public class MainInit extends GravityChangerAPI implements ModInitializer {
    //items
    public static Item GravityControllerItem;
    public static Item StarControlerItem;
    public static Item SolarWindFanItem;
    public static Item StarBedItem;
    public static Item StardustItem;
    public static Item GrappleGunItem;
    public static Item BlockGunItem;
    public static Item GArrowItem;
    public static Item GHookItem;
    public static Item SeedGravizedItem;
    public static Item CarrotGravizedItem;
    public static Item PotatoGravizedItem;
    //blocks
    public static Block GravityCoreBlock = new GravityCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).nonOpaque());
    public static Block InnerCoreBlock = new InnerCoreBlock(FabricBlockSettings.of(Material.STONE).nonOpaque().hardness(45.0f).resistance(2000.0f).luminance(1));
    public static Block OuterCoreBlock = new OuterCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f).resistance(2000.0F).luminance(1));
    public static Block ManBazookaBlock;
    public static Block NavigatorBlock;
    public static Block GravityWallBlock = new GravityWallBlock(FabricBlockSettings.of(Material.STONE).hardness(9.0f).resistance(2.0f));
    public static Block AirExBlock = new BlockAirEx(FabricBlockSettings.of(Material.AIR));
    public static Block DirtGrassExBlock = new DirtGrassExBlock(FabricBlockSettings.of(Material.AGGREGATE));
    public static Block StarBedBodyBlock = new StarBedBodyBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
    public static Block StarBedHeadBlock = new StarBedHeadBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
    public static Block BlockRotatorBlock;
    public static Block BlockChestEx;
    public static Block CropGravitizedBlock;
    public static Block PlantYelGravitizedBlock;
    public static Block PlantRedGravitizedBlock;
    public static Block SaplingGravitizedBlock;
    public static Block CarrotGravitizedBlock;
    public static Block PotatoGravitizedBlock;
    public static Block TallGrassGravitizedBlock;

    //other things
    public static final Logger LOGGER = LogManager.getLogger("starminerrecrafted");
    Direction[] directions = {SOUTH, NORTH, EAST, WEST, UP, DOWN};
    Random rnd = new Random();
    int radius = 3;


    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {

        FabricItemGroupBuilder.create(new Identifier("starminerrecrafted", "starminer")).stacksForDisplay(itemStacks -> Registry.ITEM.forEach(item -> {
            if (Registry.ITEM.getId(item).getNamespace().equals("starminerrecrafted")) {
                itemStacks.add(new ItemStack(item));
            }
        })).icon(() -> new ItemStack(OuterCoreBlock)).build();

        RegisterItemsAndBlocks();

        ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
            PlayerEntity player = handler.getPlayer();

            ServerTickEvents.START_SERVER_TICK.register((server1) -> {
                        //if (server.getWorlds() instanceof ServerWorld) {
                        Vector3d boundingBoxStartPos = new Vector3d(player.getBlockPos().getX() - radius, player.getBlockPos().getY() - radius, player.getBlockPos().getZ() - radius);

//				todo. I need to get the direction of the player relative to a block in the format x+ x- y+ y- z+ z-, this should let me choose logic for it


                        for (int i = 0; i < radius * 2; i++) {
                            for (int i1 = 0; i1 < radius * 2; i1++) {
                                for (int i2 = 0; i2 < radius * 2; i2++) {
                                    BlockPos blockPos = new BlockPos(boundingBoxStartPos.x + i, boundingBoxStartPos.y + i1, boundingBoxStartPos.z + i2);
                                    if (server.getOverworld().getBlockState(blockPos).getBlock() == Blocks.NETHERRACK) {
                                        Direction relativeDirection = DOWN;
                                        //LOGGER.info("The block is: " + server.getOverworld().getBlockState(blockPos).getBlock() + "\nThe block position is at: " + blockPos);

                                        BlockPos playerPos = player.getBlockPos();

                                        /*this works btw*/
                                        LOGGER.info(playerPos.subtract(blockPos));
                                        Vec3i blockPosVec3 = new Vec3i(blockPos.getX(), blockPos.getY(), blockPos.getZ());
                                        Vec3i playerPosVec3 = new Vec3i(playerPos.getX(), playerPos.getY(), playerPos.getZ());
                                        int relativePosition = playerPos.compareTo(blockPosVec3);


                                        //LOGGER.info(relativePosition);


                                        //player.sendSystemMessage(Text.of("There is netherrack in the: " + relativeDirection + " direction!"), Util.NIL_UUID);

                                        //GravityChangerAPI.setGravityDirection(player, directions[rnd.nextInt(6)]);
                                        break;
                                    }
                                }
                            }
                        }
                        //}
                    }
            );


			/*

			UseBlockCallback.EVENT.register((player, world, hand, hitResult) -> {
				if (world instanceof ServerWorld) {
						Vector3d vec1 = new Vector3d (player.getBlockPos().getX() + radius, player.getBlockPos().getY() + radius, player.getBlockPos().getZ() + radius);
						Vector3d vec2 = new Vector3d(player.getBlockPos().getX() - radius, player.getBlockPos().getY() - radius, player.getBlockPos().getZ() - radius);



						for (int i = 0; i < radius * 2; i++) {

							for (int i1 = 0; i1 < radius * 2; i1++) {

								for (int i2 = 0; i2 < radius * 2; i2++) {
									BlockPos blockpos = new BlockPos(vec2.x + i, vec2.y + i1, vec2.z + i2);
									if(world.getBlockState(blockpos).getBlock() == Blocks.NETHERRACK) {
										Direction relativeDirection = DOWN;
										LOGGER.info("The block is: " + world.getBlockState(blockpos).getBlock() + "\nThe block position is at: " + blockpos);
										player.sendSystemMessage(Text.of("There is netherrack in the: " + relativeDirection + " direction!"), Util.NIL_UUID);

										GravityChangerAPI.setGravityDirection(player, directions[rnd.nextInt(6)]);
										break;
									}
								}
							}
						}
				}
				return PASS;
			});

			 */


            //player.sendSystemMessage(Text.of("Cring"), UUID.randomUUID());

            //todo add radius checks ie. add entity in block, check distance/relative position to entity and adjust accordingly
            LOGGER.info("Hello Fabric world!");

        });
    }

    void RegisterItemsAndBlocks() {
        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "g_core"), GravityCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "g_core"), new BlockItem(GravityCoreBlock, new FabricItemSettings().group(ItemGroup.MISC)));
        BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "gravitywall"), GravityWallBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "gravitywall"), new BlockItem(GravityWallBlock, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "innercore"), InnerCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "innercore"), new BlockItem(InnerCoreBlock, new FabricItemSettings().group(ItemGroup.MISC)));
        BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "outercore"), OuterCoreBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "outercore"), new BlockItem(OuterCoreBlock, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "dirtgrassex"), DirtGrassExBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "dirtgrassex"), new BlockItem(DirtGrassExBlock, new FabricItemSettings().group(ItemGroup.MISC)));

        Registry.register(Registry.BLOCK, new Identifier("starminerrecrafted", "bedstar"), StarBedBodyBlock);
        Registry.register(Registry.ITEM, new Identifier("starminerrecrafted", "bedstar"), new BlockItem(StarBedBodyBlock, new FabricItemSettings().group(ItemGroup.MISC)));

    }
}