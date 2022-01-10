package net.fabricmc.example;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.minecraft.entity.player.PlayerEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.minecraft.util.math.Direction.SOUTH;

public class ExampleMod extends GravityChangerAPI implements ModInitializer  {
	//todo your mother
	public static final Logger LOGGER = LogManager.getLogger("modid");
	//test

	/**
	 * Runs the mod initializer.
	 */
	@Override
	public void onInitialize() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			PlayerEntity player = handler.getPlayer();
			//if(player.distanceTo(server.getWorld().) < 15){} //todo add radius checks ie. add entity in block, check distance/relative position to entity and adjust accordingly
			GravityChangerAPI.setGravityDirection(player, SOUTH);
			LOGGER.info("Hello Fabric world!");
		});
	}
}
