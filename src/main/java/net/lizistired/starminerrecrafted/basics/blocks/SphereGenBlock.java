package net.lizistired.starminerrecrafted.basics.blocks;

import net.lizistired.starminerrecrafted.basics.blockentities.SphereGenBlockEntity;
import net.lizistired.starminerrecrafted.basics.utils.RegistryHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


public class SphereGenBlock extends BlockWithEntity {
    public SphereGenBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new SphereGenBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegistryHelper.SphereGenBlockEntity, (world1, pos, state1, be) -> net.lizistired.starminerrecrafted.basics.blockentities.SphereGenBlockEntity.tick(world1, pos, state1, be));
    }
}
