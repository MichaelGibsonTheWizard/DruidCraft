package druidcraft.block;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockAltar extends BlockBase {
    public BlockAltar(String name) {
        super(Material.ANVIL, name);
        setHardness(3f);
        setResistance(5f);
    }

    @Override
    public BlockAltar setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }
}
