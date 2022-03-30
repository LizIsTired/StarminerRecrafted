package net.lizistired.starminerrecrafted.basics.config;

import net.lizistired.starminerrecrafted.MainInitClient;
import net.lizistired.starminerrecrafted.basics.utils.JsonFile;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.nio.file.Path;

import static net.lizistired.starminerrecrafted.MainInitClient.LOGGER;

public class SRConfig extends JsonFile {
    private transient final MainInitClient MainInitClient;

    private String blockName = "starminerrecrafted:dirtgrassex";
    private int radius = 3;

    public SRConfig(Path file, MainInitClient mainInitClient) {
        super(file);
        this.MainInitClient = mainInitClient;
    }

    public BlockState getBlockState(){
        try {
             return Registry.BLOCK.get(new Identifier(blockName.toLowerCase())).getDefaultState();
        } catch (ClassCastException e) {
            LOGGER.error(e + "\nThere was an error loading the specified block from the config, make sure a valid block name is specified. Falling back to \"minecraft:stone\".");
            blockName = "starminerrecrafted:dirtgrassex";
            save();
            return Blocks.STONE.getDefaultState();
        }
    }
    public int getRadius(){
        return radius;
    }
}
