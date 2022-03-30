package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import static net.lizistired.starminerrecrafted.MainInit.namespace;
import static net.lizistired.starminerrecrafted.basics.utils.KeybindingHelper.*;
import static net.lizistired.starminerrecrafted.basics.utils.RegistryHelper.*;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.lizistired.starminerrecrafted.basics.config.SRConfig;
import net.lizistired.starminerrecrafted.basics.utils.GamePaths;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.RenderLayer;

import net.minecraft.text.TranslatableText;
import net.minecraft.util.Util;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Path;


public class MainInitClient extends GravityChangerAPI implements ClientModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(namespace);
    private static MainInitClient instance;
    public static MainInitClient getInstance() {
        return instance;
    }
    public MainInitClient() {
        instance = this;
    }
    //config assignment
    private static SRConfig config;
    public static SRConfig getConfig() {
        return config;
    }

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitializeClient() {
        //config
        Path SRFolder = GamePaths.getConfigDirectory().resolve("starminer");
        config = new SRConfig(SRFolder.getParent().resolve("starminer.json"), this);
        getConfig().load();
        //keybinds
        registerKeyBindings();

        BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRotatorBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GravityWallBlock, RenderLayer.getTranslucent());
        LOGGER.info("Init client.");
        ClientTickEvents.END_CLIENT_TICK.register(this::asyncTick);
    }
    private void asyncTick(MinecraftClient client){
        if (keyBinding2.wasPressed()){
            getConfig().load();
            LOGGER.info("Reloaded config");
            client.player.sendSystemMessage(new TranslatableText("debug.starminerrecrafted.reload"), Util.NIL_UUID);
        }
    }

    /*ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(new TranslatableText("title.examplemod.config"));

     */
}