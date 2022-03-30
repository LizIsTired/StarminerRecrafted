package net.lizistired.starminerrecrafted.basics.blockentities;

import net.lizistired.starminerrecrafted.basics.utils.SphereGen;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;
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
    }
