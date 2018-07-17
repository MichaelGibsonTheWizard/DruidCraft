package druidcraft;

import druidcraft.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = DruidCraft.MOD_ID, name = DruidCraft.NAME, version = DruidCraft.VERSION)
public class DruidCraft {
    public static final String MOD_ID = "druidcraft";
    public static final String NAME = "DruidCraft";
    public static final String VERSION = "0.1.0";

    @SidedProxy(clientSide = "druidcraft.proxy.ClientProxy", serverSide = "druidcraft.proxy.ServerProxy")
    public static CommonProxy proxy;

    @Mod.Instance(MOD_ID)
    public static DruidCraft instance;

    public static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        proxy.preInit(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {
        proxy.postInit(event);
    }
}
