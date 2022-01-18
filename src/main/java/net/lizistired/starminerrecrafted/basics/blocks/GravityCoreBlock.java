package net.lizistired.starminerrecrafted.basics.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

import java.util.List;

public class GravityCoreBlock extends Block {
    /*@Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.starminerrecrafted.g_core.tooltip") );
    }*/
    public GravityCoreBlock(AbstractBlock.Settings settings) {
        super(settings);
    }
}
