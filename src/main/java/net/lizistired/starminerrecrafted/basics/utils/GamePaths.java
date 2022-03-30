package net.lizistired.starminerrecrafted.basics.utils;

import java.nio.file.Path;
import net.fabricmc.loader.api.FabricLoader;
import net.lizistired.starminerrecrafted.mixin.MixinPlayerSkinProvider;
import net.minecraft.client.MinecraftClient;

public class GamePaths {
    private GamePaths() {
    }

    public static Path getGameDirectory() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static Path getAssetsDirectory() {
        return ((MixinPlayerSkinProvider)MinecraftClient.getInstance().getSkinProvider()).getSkinCacheDirectory().getParentFile().toPath();
    }
}
