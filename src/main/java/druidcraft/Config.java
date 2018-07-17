package druidcraft;

import druidcraft.proxy.CommonProxy;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.Level;

public class Config {
    private static final String CATEGORY_GENERAL = "general";
    private static final String CATEGORY_DIMENSIONS = "dimensions";

    // Defines the normal amount of ambient mana; affects power of spells and recharge rate of mana.
    public static int manaLevel = 1;

    public static void readConfig() {
        Configuration config = CommonProxy.config;
        try {
            config.load();
            initGeneralConfig(config);
            initDimensionConfig(config);
        }
        catch (Exception exception) {
            DruidCraft.logger.log(Level.ERROR, "Problem loading config file", exception);
        }
        finally {
            if (config.hasChanged()) {
                config.save();
            }
        }
    }

    private static void initGeneralConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_GENERAL, "General configuration");
        manaLevel = config.getInt("manaLevel", CATEGORY_GENERAL, 1, 0, 5,
                "Change this to adjust the power level of this mod: 1 is the default, 0 is the minimum and 5 is the max.");
    }

    private static void initDimensionConfig(Configuration config) {
        config.addCustomCategoryComment(CATEGORY_DIMENSIONS, "Dimension configuration");
    }
}
