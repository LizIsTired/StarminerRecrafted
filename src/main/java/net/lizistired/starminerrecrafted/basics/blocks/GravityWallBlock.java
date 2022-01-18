package net.lizistired.starminerrecrafted.basics.blocks;

import net.minecraft.block.Block;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.BlockView;

import java.util.List;

public class GravityWallBlock extends Block {
    /*@Override
    public void appendTooltip(ItemStack itemStack, BlockView world, List<Text> tooltip, TooltipContext tooltipContext) {
        tooltip.add( new TranslatableText("block.starminerrecrafted.gravitywall.tooltip") );
    }*/
    public GravityWallBlock(Settings settings) {
        super(settings);
    }
}
