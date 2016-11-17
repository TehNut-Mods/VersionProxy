package tehnut.versionproxy.one_eleven;

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
        return ItemStack.field_190927_a;
    }

    @Override
    public ItemStack fromNBT(NBTTagCompound stackNBT) {
        return new ItemStack(stackNBT);
    }

    @Override
    public boolean isValid(@Nullable ItemStack stack) {
        assert stack != null;
        return stack.func_190926_b();
    }

    @Override
    public int getStackSize(@Nullable ItemStack stack) {
        assert stack != null;
        return stack.func_190916_E();
    }

    @Override
    public ItemStack incrStackSize(@Nullable ItemStack stack, int amount) {
        assert stack != null;
        stack.func_190917_f(amount);
        return stack;
    }

    @Override
    public ItemStack decrStackSize(@Nullable ItemStack stack, int amount) {
        assert stack != null;
        stack.func_190918_g(amount);
        return stack;
    }
}
