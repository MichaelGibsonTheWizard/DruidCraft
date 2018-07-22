package druidcraft.block;

import druidcraft.item.ModItems;
import druidcraft.tileentity.TileEntityAltar;
import druidcraft.tileentityspecialrenderer.TESRAltar;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;

public class BlockAltar extends BlockBase implements ITileEntityProvider {
    public static final IProperty<Boolean> IS_SPHERE = PropertyBool.create("is_sphere");
    //public static final PropertyInteger ELEMENT = PropertyInteger.create("element", 0, 4);

    public BlockAltar(String name) {
        super(Material.ANVIL, name);
        setHardness(3f);
        setResistance(5f);

        //setDefaultState(blockState.getBaseState().withProperty(ELEMENT, 0));
        setDefaultState(blockState.getBaseState().withProperty(IS_SPHERE, false));
    }

    @Override
    public BlockAltar setCreativeTab(CreativeTabs tab) {
        super.setCreativeTab(tab);
        return this;
    }

    @Override
    public IBlockState getActualState(IBlockState state, IBlockAccess worldIn, BlockPos pos) {
        return state.withProperty(IS_SPHERE, false);
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new TileEntityAltar();
    }

    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0,
                new ModelResourceLocation(getRegistryName(), "inventory"));

        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAltar.class, new TESRAltar());


    }

    @Override
    @SideOnly(Side.CLIENT)
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess worldIn, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public boolean isBlockNormalCube(IBlockState blockState) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState blockState) {
        return false;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState();
                //.withProperty(IS_SPHERE, (meta & 8) != 0);
                //.withProperty(ELEMENT, meta & ~8);
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return 0;
        //return (state.getValue(IS_SPHERE) ? 8 : 0); // Necessary inverse of the getStateFromMeta operation.
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, IS_SPHERE);
    }

    @Nullable
    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityAltar();
    }

    private TileEntityAltar getTE(World world, BlockPos pos) {
        return (TileEntityAltar) world.getTileEntity(pos);
    }
    /*
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            System.out.println("Clicked");
            if (playerIn.getHeldItem(hand).getItem().equals(ModItems.flameEssence)) {
                System.out.println("With Dagger");
                worldIn.setBlockState(pos, state.withProperty(ELEMENT, 1));
            }
        }
        return true;
    }
    */
}
