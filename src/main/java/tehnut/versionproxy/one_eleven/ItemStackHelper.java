package tehnut.versionproxy.one_eleven;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tehnut.versionproxy.iface.IItemStackHelper;

import javax.annotation.Nullable;

public class ItemStackHelper implements IItemStackHelper {

    ItemStackHelper() {
        // No-op
    }

    @Override
    public ItemStack getInvalid() {
        return ItemStack.EMPTY;
    }

    @Override
    public ItemStack fromNBT(NBTTagCompound stackNBT) {
        return new ItemStack(stackNBT);
    }

    @Override
    public boolean isValid(@Nullable ItemStack stack) {
        assert stack != null;
        return stack.isEmpty();
    }

    @Override
    public int getStackSize(@Nullable ItemStack stack) {
        assert stack != null;
        return stack.getCount();
    }

    @Override
    public ItemStack incrStackSize(@Nullable ItemStack stack, int amount) {
        assert stack != null;
        stack.grow(amount);
        return stack;
    }

    @Override
    public ItemStack decrStackSize(@Nullable ItemStack stack, int amount) {
        assert stack != null;
        stack.shrink(amount);
        return stack;
    }

    @Override
    public CreativeTabs createTab(String label, final ItemStack displayStack) {
        return new CreativeTabs(label) {
            @Override
            public ItemStack getTabIconItem() {
                return displayStack;
            }
        };
    }
}
