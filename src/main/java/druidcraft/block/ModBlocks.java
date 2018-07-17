package druidcraft.block;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.registries.IForgeRegistry;

public class ModBlocks {
    public static BlockAltar blockAltar = new BlockAltar("block_altar").setCreativeTab(CreativeTabs.DECORATIONS);
    public static void register(IForgeRegistry<Block> registry) {
        registry.registerAll(
                blockAltar
        );
    }

    public static void registerItemBlocks(IForgeRegistry<Item> registry) {
        registry.registerAll(
                blockAltar.createItemBlock()
        );
    }

    public static void registerModels() {
        blockAltar.registerItemModel(Item.getItemFromBlock(blockAltar));
    }
}
