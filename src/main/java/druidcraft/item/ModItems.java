package druidcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase dagger = new ItemBase("dagger").setCreativeTab(CreativeTabs.COMBAT);
    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                dagger
        );
    }

    public static void registerModels() {
        dagger.registerItemModel();
    }
}
