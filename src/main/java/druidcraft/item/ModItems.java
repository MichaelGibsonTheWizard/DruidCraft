package druidcraft.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModItems {
    public static ItemBase dagger = new ItemBase("dagger").setCreativeTab(CreativeTabs.COMBAT);
    public static ItemBase flameEssence = new ItemBase("flame_essence").setCreativeTab(CreativeTabs.MISC);

    public static void register(IForgeRegistry<Item> registry) {
        registry.registerAll(
                dagger,
                flameEssence
        );
    }

    public static void registerModels() {
        dagger.registerItemModel();
        flameEssence.registerItemModel();
    }
}
