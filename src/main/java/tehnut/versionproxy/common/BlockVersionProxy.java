package tehnut.versionproxy.common;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockVersionProxy extends Block {

    public BlockVersionProxy(Material material, MapColor mapColor) {
        super(material, mapColor);
    }

    public BlockVersionProxy(Material material) {
        super(material);
    }

    // Proxy methods

    protected void neighborChangedProxy(IBlockState state, World world, BlockPos pos, Block block) {

    }

    public boolean onBlockActivatedProxy(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        return false;
    }

    // Soft Overrides - Override their Proxy variants instead.

    // @Override - Soft override - 1.11
    public final void neighborChanged(IBlockState state, World world, BlockPos pos, Block block, BlockPos neighborPos) {
        neighborChangedProxy(state, world, pos, block);
    }

    // @Override - Soft override - 1.10
    public final void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block block) {
        neighborChangedProxy(state, worldIn, pos, block);
    }

    // @Override - Soft override - 1.11
    public final boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ) {
        return onBlockActivatedProxy(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }

    // @Override - Soft override - 1.10
    public final boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
        return onBlockActivatedProxy(world, pos, state, player, hand, side, hitX, hitY, hitZ);
    }
}
