package net.lizistired.starminerrecrafted.basics.blockentities;

import net.lizistired.starminerrecrafted.basics.utils.SphereGen;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import static net.lizistired.starminerrecrafted.MainInit.namespace;
import static net.lizistired.starminerrecrafted.basics.utils.RegistryHelper.SphereGenBlockEntity;

public class SphereGenBlockEntity extends BlockEntity {

    public static final Logger LOGGER = LogManager.getLogger(namespace);
    static SphereGen sphereGen = new SphereGen();
    static boolean hasActivated = false;

    public SphereGenBlockEntity(BlockPos pos, BlockState state) {
        super(SphereGenBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, SphereGenBlockEntity be) {
        if (!hasActivated) {
            sphereGen.createSphere(world, pos, Blocks.WATER, 64, LOGGER, 1024);
        }
    }
}
