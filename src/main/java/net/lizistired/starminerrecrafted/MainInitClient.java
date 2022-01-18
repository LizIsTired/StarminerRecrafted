package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.lizistired.starminerrecrafted.basics.blocks.*;
import net.lizistired.starminerrecrafted.basics.blocks.bed.StarBedBodyBlock;
import net.lizistired.starminerrecrafted.basics.blocks.bed.StarBedHeadBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.client.render.RenderLayer;


public class MainInitClient extends GravityChangerAPI implements ClientModInitializer {
    //blocks
    public static Block GravityCoreBlock = new GravityCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(1.0f).nonOpaque());
    public static Block InnerCoreBlock = new InnerCoreBlock(FabricBlockSettings.of(Material.STONE).nonOpaque().hardness(45.0f).resistance(2000.0f).luminance(1));
    public static Block OuterCoreBlock = new OuterCoreBlock(FabricBlockSettings.of(Material.STONE).hardness(4.0f).resistance(2000.0F).luminance(1));
    public static Block GravityWallBlock = new GravityWallBlock(FabricBlockSettings.of(Material.STONE).hardness(9.0f).resistance(2.0f));
    public static Block AirExBlock = new BlockAirEx(FabricBlockSettings.of(Material.AIR));
    public static Block DirtGrassExBlock = new DirtGrassExBlock(FabricBlockSettings.of(Material.AGGREGATE));
    public static Block StarBedBodyBlock = new StarBedBodyBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));
    public static Block StarBedHeadBlock = new StarBedHeadBlock(FabricBlockSettings.of(Material.WOOL).hardness(0.2f));


    /**
     * Runs the mod initializer.
     */
    @Override
    @Environment(EnvType.CLIENT)
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(GravityCoreBlock, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(InnerCoreBlock, RenderLayer.getCutout());
    }
}