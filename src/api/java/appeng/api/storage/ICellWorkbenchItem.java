package appeng.api.storage;

import appeng.api.config.FuzzyMode;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public interface ICellWorkbenchItem {

    /**
     * if this return false, the item will not be treated as a cell, and cannot be inserted into the work bench.
     *
     * @param is
     * @return true if the item should be editable in the cell workbench.
     */
    boolean isEditable(ItemStack is);

    /**
     * used to edit the upgrade slots on your cell, should have a capacity of 0-24, you are also responsible for
     * implementing the valid checks, and any storage/usage of them.
     * <p/>
     * onInventoryChange will be called when saving is needed.
     */
    IInventory getUpgradesInventory(ItemStack is);

    /**
     * Used to extract, or mirror the contents of the work bench onto the cell.
     * <p/>
     * - This should have exactly 63 slots, any more, or less might cause issues.
     * <p/>
     * onInventoryChange will be called when saving is needed.
     */
    IInventory getConfigInventory(ItemStack is);

    /**
     * @return the current fuzzy status.
     */
    FuzzyMode getFuzzyMode(ItemStack is);

    /**
     * sets the setting on the cell.
     */
    void setFuzzyMode(ItemStack is, FuzzyMode fzMode);

}
