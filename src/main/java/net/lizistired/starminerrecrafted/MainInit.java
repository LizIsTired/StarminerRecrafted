package net.lizistired.starminerrecrafted;

import me.andrew.gravitychanger.api.GravityChangerAPI;
import net.fabricmc.api.ModInitializer;
import net.lizistired.starminerrecrafted.basics.utils.RegistryHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainInit extends GravityChangerAPI implements ModInitializer {

    public static String namespace = "starminerrecrafted";
    public static final Logger LOGGER = LogManager.getLogger(namespace);
    RegistryHelper regHelp = new RegistryHelper();

    /**
     * Runs the mod initializer.
     */
    @Override
    public void onInitialize() {
        regHelp.registerEverything();
        LOGGER.info("No crashes yet...");
    }
}