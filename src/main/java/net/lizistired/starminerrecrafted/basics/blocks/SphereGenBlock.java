package net.lizistired.starminerrecrafted.basics.blocks;

import net.lizistired.starminerrecrafted.MainInitClient;
import net.lizistired.starminerrecrafted.basics.blockentities.SphereGenBlockEntity;
import net.lizistired.starminerrecrafted.basics.config.SRConfig;
import net.lizistired.starminerrecrafted.basics.utils.NewSphereGen;
import net.lizistired.starminerrecrafted.basics.utils.RegistryHelper;
import net.minecraft.block.*;
import net.minecraft.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.lizistired.starminerrecrafted.MainInitClient.*;

import java.util.List;
import java.util.Random;

import static net.lizistired.starminerrecrafted.MainInitClient.*;


public class SphereGenBlock extends BlockWithEntity {
    private static final Random RANDOM = new Random();
    public SphereGenBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new SphereGenBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }


    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        //List<BlockState> possibleStates = Registry.BLOCK.getRandom(RANDOM).getStateManager().getStates();
        //BlockState state1 = possibleStates.get(RANDOM.nextInt(possibleStates.size()));
        BlockEntity blockEntity = world.getBlockEntity(pos);
        if (blockEntity instanceof SphereGenBlockEntity) {
            //NewSphereGen.drawSphere(pos, getConfig().getRadius(), world, getConfig().getBlockState());
            NewSphereGen.drawSphere(pos, getConfig().getRadius(), world, Blocks.SAND.getDefaultState());
            world.removeBlock(pos, false);
        }
    }
}
