package tehnut.versionproxy.one_ten;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import tehnut.versionproxy.VersionProxyMain;
import tehnut.versionproxy.iface.IItemStackHelper;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ItemStackHelper implements IItemStackHelper {

    private static final Field _STACK_SIZE;
    private static final Method _LOAD_FROM_NBT;

    static {
        try {
            String fieldName = VersionProxyMain.IS_DEV ? "stackSize" : "field_77994_a";
            _STACK_SIZE = ItemStack.class.getDeclaredField(fieldName);
            _STACK_SIZE.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("Could not reflect the \"stackSize\" field in ItemStack.");
        }

        try {
            String methodName = VersionProxyMain.IS_DEV ? "loadItemStackFromNBT" : "func_77949_a";
            _LOAD_FROM_NBT = ItemStack.class.getMethod(methodName, NBTTagCompound.class);
            _LOAD_FROM_NBT.setAccessible(true);
        } catch (Exception e) {
            throw new RuntimeException("Could not reflect the \"loadItemStackFromNBT\" method in ItemStack.");
        }
    }

    ItemStackHelper() {
        // No-op
    }

    @Override
    public ItemStack getInvalid() {
        return null;
    }

    @Override
    public ItemStack fromNBT(NBTTagCompound stackNBT) {
        try {
            return (ItemStack) _LOAD_FROM_NBT.invoke(null, stackNBT);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean isValid(@Nullable ItemStack stack) {
        return stack != null;
    }

    @Override
    public int getStackSize(@Nullable ItemStack stack) {
        if (!isValid(stack))
            return 0;

        try {
            return (Integer) _STACK_SIZE.get(stack);
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public ItemStack incrStackSize(@Nullable ItemStack stack, int amount) {
        if (!isValid(stack))
            return null;

        int size = getStackSize(stack);
        try {
            int newSize = size + amount;
            if (newSize <= 0)
                return null;

            _STACK_SIZE.set(stack, size + amount);
        } catch (Exception e) {
            return stack;
        }

        return stack;
    }

    @Override
    public ItemStack decrStackSize(@Nullable ItemStack stack, int amount) {
        return incrStackSize(stack, -amount);
    }

    @Override
    public CreativeTabs createTab(String label, final ItemStack displayStack) {
        return new CreativeTabs(label) {
            @Override
            public ItemStack getTabIconItem() {
                return null;
            }

            @Override
            public ItemStack getIconItemStack() {
                return displayStack;
            }
        };
    }
}
