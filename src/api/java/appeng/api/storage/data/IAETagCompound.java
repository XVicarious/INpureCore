package appeng.api.storage.data;

import appeng.api.features.IItemComparison;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Don't cast this... either compare with it, or copy it.
 * <p/>
 * Don't Implement.
 */
public interface IAETagCompound {

    /**
     * @return a copy ( the copy will not be a IAETagCompount, it will be a NBTTagCompound )
     */
    public NBTTagCompound getNBTTagCompoundCopy();

    /**
     * compare to other NBTTagCompounds or IAETagCompounds
     *
     * @param a
     * @return true, if they are the same.
     */
    @Override
    boolean equals(Object a);

    /**
     * @return the special comparison for this tag
     */
    IItemComparison getSpecialComparison();

}