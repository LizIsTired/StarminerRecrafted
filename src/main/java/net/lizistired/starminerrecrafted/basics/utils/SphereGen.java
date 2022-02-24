package net.lizistired.starminerrecrafted.basics.utils;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.apache.logging.log4j.Logger;
import java.util.HashSet;


public class SphereGen {
    public static HashSet<Vec3d> generate(BlockPos center, Vec3d dimensions, int resolution) {
        var points = new HashSet<Vec3d>();
        for (int phiStep = 0; phiStep < resolution; phiStep++) {
            for (int thetaStep = 0; thetaStep < resolution / 2; thetaStep++) {
                var phi = (double)phiStep / resolution * Math.PI * 2;
                var theta = (double)thetaStep / resolution * Math.PI * 2;
                points.add(new Vec3d(
                        center.getX() + dimensions.x * Math.sin(theta) * Math.cos(phi),
                        center.getY() + dimensions.y * Math.sin(theta) * Math.sin(phi),
                        center.getZ() + dimensions.z * Math.cos(theta)
                ));
            }
        }
        return points;
    }

    public void createSphere(World world, BlockPos pos, Block block, double radius, Logger logger, int res){
        try {
            Vec3d dimensions = new Vec3d(radius, radius, radius);
            HashSet<Vec3d> points = generate(pos, dimensions, res);

            for (Vec3d point : points) {
                world.setBlockState(new BlockPos(point.getX(), point.getY(), point.getZ()), block.getDefaultState());
            }
        } catch (Exception e) {
            logger.error(e);
        }
    }

    public void createSphere(World world, BlockPos pos, Block block, double radius, int res){
        try {
            Vec3d dimensions = new Vec3d(radius, radius, radius);
            HashSet<Vec3d> points = generate(pos, dimensions, res);

            for (Vec3d point : points) {
                world.setBlockState(new BlockPos(point.getX(), point.getY(), point.getZ()), block.getDefaultState());
            }
        } catch (Exception e) {
        }
    }
}