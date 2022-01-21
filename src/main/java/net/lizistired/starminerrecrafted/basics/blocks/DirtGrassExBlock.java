package net.lizistired.starminerrecrafted.basics.blocks;

import ca.weblite.objc.Client;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockRenderView;

import java.awt.*;

public class DirtGrassExBlock extends Block {

    /*@Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.starminerrecrafted.g_core.tooltip") );
    }*/
    public DirtGrassExBlock(Settings settings) {
        super(settings);
        try {getBlockColor();} catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*public int getBlockColor(){
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0,d1);
    }*/

    //todo get this to work, currently causes a crash without an exception handler
    @Environment(EnvType.CLIENT)
    public void getBlockColor() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos), this);
    }
}