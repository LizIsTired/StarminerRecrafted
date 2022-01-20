package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import static net.lizistired.starminerrecrafted.RegistryHelper.*;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.math.Vector3d;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.util.registry.Registry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Random;

import static net.minecraft.util.math.Direction.*;


public class MainInit extends GravityChangerAPI implements ModInitializer {

    RegistryHelper regHelp = new RegistryHelper();

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



        regHelp.registerItemsAndBlocksClass();

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
            LOGGER.info("Hello Fabric world!");

        });
    }
}