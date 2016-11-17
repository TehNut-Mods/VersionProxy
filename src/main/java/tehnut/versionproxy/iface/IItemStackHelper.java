package tehnut.versionproxy.iface;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import javax.annotation.Nullable;

public interface IItemStackHelper {

    /**
     * Obtains a copy of an invalid ItemStack.
     *
     * In 1.10, this returns {@code null}.
     * In 1.11, this returns {@code ItemStack.EMPTY_STACK}.
     *
     * @return an invalid ItemStack.
     */
    ItemStack getInvalid();

    /**
     * Loads an ItemStack instance from an NBTTagCompound.
     *
     * In 1.10, this forwards to {@code ItemStack.loadItemStackFromNBT(stackNBT)}
     * In 1.11, this forwards to {@code new ItemStack(stackNBT)}
     *
     * @param stackNBT - The NBT compound to load the Stack from
     * @return the stack that was loaded from NBT. This may return an invalid stack if the NBT provided was not able
     * to supply all the needed ItemStack information.
     */
    ItemStack fromNBT(NBTTagCompound stackNBT);

    /**
     * Checks if the provided stack is valid.
     *
     * In 1.10, this checks if the stack is {@code null}.
     * In 1.11, this forwards to {@code ItemStack#isValid()}
     *
     * @param stack - The ItemStack to check validity of
     * @return whether or not the ItemStack is valid
     */
    boolean isValid(@Nullable ItemStack stack);

    /**
     * Gets the current stackSize of the ItemStack.
     *
     * In 1.10, this uses {@code ItemStack#stackSize}
     * In 1.11, this uses {@code ItemStack#getStackSize()}
     *
     * @param stack - The ItemStack to get the size of
     * @return the current stackSize of the ItemStack
     */
    int getStackSize(@Nullable ItemStack stack);

    /**
     * Adds the given amount to the stackSize of the ItemStack.
     *
     * In 1.10, this uses {@code stackSize += amount}
     * In 1.11, this uses {@code ItemStack#incrStackSize(amount)}
     *
     * @param stack - The ItemStack to increase the size of
     * @param amount - The amount to increase the size by
     * @return the modified ItemStack. If the given ItemStack is invalid, this will return an invalid ItemStack.
     */
    ItemStack incrStackSize(@Nullable ItemStack stack, int amount);

    /**
     * Adds the given amount to the stackSize of the ItemStack.
     *
     * In 1.10, this uses {@code stackSize -= amount}
     * In 1.11, this uses {@code ItemStack#decrStackSize(amount)}
     *
     * @param stack - The ItemStack to decrease the size of
     * @param amount - The amount to decrease the size by
     * @return the modified ItemStack. If the given ItemStack is invalid or the stackSize falls to {@code <= 0}, this will
     * return an invalid ItemStack.
     */
    ItemStack decrStackSize(@Nullable ItemStack stack, int amount);
}
