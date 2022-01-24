package net.lizistired.starminerrecrafted.basics.blocks;

import net.lizistired.starminerrecrafted.basics.blockentities.GravityCoreBlockEntity;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import static net.lizistired.starminerrecrafted.basics.utils.RegistryHelper.GravityCoreBlockEntity;

//todo get this to render correctly
public class GravityCoreBlock extends BlockWithEntity {


    public GravityCoreBlock(AbstractBlock.Settings settings) {
        super(settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state){
        return new GravityCoreBlockEntity(pos, state);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, GravityCoreBlockEntity, (world1, pos, state1, be) -> net.lizistired.starminerrecrafted.basics.blockentities.GravityCoreBlockEntity.tick(world1, pos, state1, be));
    }
}
