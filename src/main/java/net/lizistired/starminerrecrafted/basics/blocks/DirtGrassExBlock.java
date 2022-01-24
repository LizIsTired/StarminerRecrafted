package net.lizistired.starminerrecrafted.basics.blocks;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.color.world.BiomeColors;


public class DirtGrassExBlock extends Block {

    /*@Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.starminerrecrafted.g_core.tooltip") );
    }*/
    public DirtGrassExBlock(Settings settings) {
        super(settings);
        getBlockColor();
    }

    /*public int getBlockColor(){
        double d0 = 0.5D;
        double d1 = 1.0D;
        return ColorizerGrass.getGrassColor(d0,d1);
    }*/

    @Environment(EnvType.CLIENT)
    public void getBlockColor() {
        ColorProviderRegistry.BLOCK.register((state, view, pos, tintIndex) -> BiomeColors.getGrassColor(view, pos), this);
    }
}