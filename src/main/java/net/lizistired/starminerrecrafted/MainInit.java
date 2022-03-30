package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.networking.v1.PacketSender;
import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;
import net.lizistired.starminerrecrafted.basics.utils.RegistryHelper;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class MainInit extends GravityChangerAPI implements ModInitializer {

    public static String namespace = "starminerrecrafted";
    public static final Logger LOGGER = LogManager.getLogger(namespace);
    RegistryHelper regHelp = new RegistryHelper();

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        Entity myEntity;
        regHelp.registerEverything();
        LOGGER.info("Init server.");
        //ServerPlayConnectionEvents.JOIN.register(this::testingFunction);
    }



    void testingFunction(ServerPlayNetworkHandler handler, PacketSender sender, MinecraftServer server) {
        server.getOverworld().onDimensionChanged(server.getOverworld().getRandomAlivePlayer());
        handler.player.setNoGravity(true);
        handler.player.setNoDrag(true);

        LOGGER.info(server.getCurrentPlayerCount());


        //world.onPlayerChangeDimension(world.getPlayers());

        //    for (int i = 0; i < world.getServer().getCurrentPlayerCount(); i++) {
        //        try {
        //            LOGGER.info(world.getPlayers().get(i).toString());
        //            world.getPlayers().get(i).setNoGravity(false);
        //            world.getPlayers().get(i).setNoDrag(false);
        //        } catch (Exception e) {
        //            e.printStackTrace();
        //        }
        //    }
        //});
    }
}