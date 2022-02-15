package net.lizistired.starminerrecrafted.basics.blockentities;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import me.shedaniel.autoconfig.annotation.Config;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
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
    public double gravityRange;
    public double starRad;
    public int type;
    public short workStateX;
    public short workStateY;
    public short workStateZ;
    public boolean workFast;
    public static Direction relativeDirection = DOWN;
    public static int gravityRadius = 10;
    public static final Logger LOGGER = LogManager.getLogger(namespace);

    public GravityCoreBlockEntity(BlockPos pos, BlockState state) {
        super(GravityCoreBlockEntity, pos, state);
        this.gravityRange = 0.0;
        this.starRad = 0.0;
        this.type = 0;
        this.workStateX = 0;
        this.workStateY = 0;
        this.workStateZ = 0;
        this.workFast = false;
    }

    public static void tick(World world, BlockPos pos, BlockState state, GravityCoreBlockEntity be) {
        boolean isFurtherX;
        boolean isFurtherY;
        boolean isFurtherZ;


        if (be.getWorld().isPlayerInRange(pos.getX(), pos.getY(), pos.getZ(), gravityRadius)) {
            PlayerEntity player = be.getWorld().getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), gravityRadius, false);
            BlockPos playerPos = player.getBlockPos();

            isFurtherX = playerPos.getX() > pos.getX();
            isFurtherY = playerPos.getY() > pos.getY();
            isFurtherZ = playerPos.getZ() > pos.getZ();

            if (playerPos.getX() == pos.getX()) {relativeDirection = DOWN;} else {
                if (isFurtherX) {
                    relativeDirection = EAST;
                } else {
                    relativeDirection = WEST;
                }
            }

            //if (playerPos.getY() != pos.getY()) {
           //    if (isFurtherY) {
           //        relativeDirection = DOWN;
           //    } else {
           //        relativeDirection = UP;
           //    }
           //}
           //else {relativeDirection = DOWN;}
//
           //if (playerPos.getZ() != pos.getZ()) {
           //    if (isFurtherZ) {
           //        relativeDirection = NORTH;
           //    } else {
           //        relativeDirection = SOUTH;
           //    }
           //}
           //else {relativeDirection = DOWN;}



            if (player.getInventory().getMainHandStack().getItem() == Items.STICK) {
                GravityChangerAPI.setGravityDirection(player, relativeDirection);
            }
            else {
                GravityChangerAPI.setGravityDirection(player, DOWN);
                player.setNoGravity(true);
            }

            //player.sendSystemMessage(Text.of("There is a gravity core in the: " + relativeDirection + " direction!"), Util.NIL_UUID);

        }
        else {
            //PlayerEntity player = be.getWorld().getClosestPlayer(pos.getX(), pos.getY(), pos.getZ(), gravityRadius + 50, false);
            //if (player != null) {
            //    GravityChangerAPI.setGravityDirection(player, DOWN);
            //}
        }
    }

    /*public void fixInValidRange() {
        if (this.gravityRange < 0.0) {
            this.gravityRange = 0.0;
        }
        if (this.gravityRange > Config.maxGravityRad) {
            this.gravityRange = (double)Config.maxGravityRad;
        }
        if (this.starRad < 0.0) {
            this.starRad = 0.0;
        }
        if (this.starRad > Config.maxStarRad) {
            this.starRad = (double)Config.maxStarRad;
        }
    }*/
}