package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import me.shedaniel.clothconfig2.api.ConfigBuilder;
import net.fabricmc.api.ClientModInitializer;

import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;

import static net.lizistired.starminerrecrafted.MainInit.namespace;
import static net.lizistired.starminerrecrafted.basics.utils.RegistryHelper.*;
import net.minecraft.client.render.RenderLayer;

import net.minecraft.text.TranslatableText;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class MainInitClient extends GravityChangerAPI implements ClientModInitializer {

    public static final Logger LOGGER = LogManager.getLogger(namespace);

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(BlockRotatorBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(GravityWallBlock, RenderLayer.getTranslucent());
        LOGGER.info("Init client.");
    }

    /*ConfigBuilder builder = ConfigBuilder.create()
            .setParentScreen(parent)
            .setTitle(new TranslatableText("title.examplemod.config"));

     */
}