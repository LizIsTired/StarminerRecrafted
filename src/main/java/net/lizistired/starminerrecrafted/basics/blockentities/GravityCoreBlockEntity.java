package net.lizistired.starminerrecrafted.basics.blockentities;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static net.lizistired.starminerrecrafted.MainInit.namespace;
import static net.lizistired.starminerrecrafted.basics.utils.RegistryHelper.GravityCoreBlockEntity;
import static net.minecraft.util.math.Direction.*;

public class GravityCoreBlockEntity extends BlockEntity {

    public static final Logger LOGGER = LogManager.getLogger(namespace);

    public GravityCoreBlockEntity(BlockPos pos, BlockState state) {
        super(GravityCoreBlockEntity, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, GravityCoreBlockEntity be) {
        PlayerEntity player = be.getWorld().getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), 5, false);
        Direction relativeDirection = DOWN;
        if (player != null) {
            BlockPos playerPos = player.getBlockPos();
            LOGGER.info(playerPos.subtract(pos));
            Vec3i blockPosVec3 = new Vec3i(pos.getX(), pos.getY(), pos.getZ());
            Vec3i playerPosVec3 = new Vec3i(playerPos.getX(), playerPos.getY(), playerPos.getZ());
            int relativePosition = playerPos.compareTo(blockPosVec3);
            player.sendSystemMessage(Text.of("There is a gravity core in the: " + relativeDirection + " direction!"), Util.NIL_UUID);
        }
    }
}