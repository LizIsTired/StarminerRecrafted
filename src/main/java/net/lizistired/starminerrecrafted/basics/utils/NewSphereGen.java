package net.lizistired.starminerrecrafted.basics.utils;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NewSphereGen {

    public static void drawSphere(BlockPos center, float radius, World world, BlockState blockState) {
        double maxR2 = Math.floor(radius * radius);
        double x, y, z;
        x = center.getX();
        y = center.getY();
        z = center.getZ();
        double zx = Math.floor(radius);
        for (x = 0;; ++x) {
            //max z for this x value.
            while (x * x + zx * zx > maxR2 && zx >= x)
                --zx;
            if (zx < x)
                break; //with this x, z can't be largest
            z = zx;
            for (y = 0;; ++y) {
                while (x * x + y * y + z * z > maxR2 && z >= x && z >= y)
                    --z;
                if (z < x || z < y)
                    break; //with this x and y, z can't be largest
                fillAll(x, y, z, world, center, blockState); //... and up to 23 reflections of it
            }
        }
    }

    static void fill1(double x, double y, double z, World world, BlockPos center, BlockState blockState) {
        world.setBlockState(new BlockPos(x, y, z), blockState);
    }

    static void fillSigns(double x, double y, double z, World world, BlockPos center, BlockState blockState) {
        fill1(x, y, z, world, center, blockState);
        for (;;) {
            if ((z = -z) >= 0) {
                if ((y = -y) >= 0) {
                    if ((x = -x) >= 0) {
                        break;
                    }
                }
            }
            fill1(x, y, z, world, center, blockState);
        }
    }

    static void fillAll(double x, double y, double z, World world, BlockPos center, BlockState blockState) {
        fillSigns(x, y, z, world, center, blockState);
        if (z > y) {
            fillSigns(x, z, y, world, center, blockState);
        }
        if (z > x && z > y) {
            fillSigns(z, y, x, world, center, blockState);
        }
    }
}
