package appeng.api.storage;

import appeng.api.IAppEngApi;
import appeng.api.networking.security.BaseActionSource;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * A Registry of External Storage handlers.
 * <p/>
 * Do not implement obtain via {@link IAppEngApi}.registries().getExternalStorageRegistry()
 */
public interface IExternalStorageRegistry {

    /**
     * A registry for StorageBus interactions
     *
     * @param esh
     */
    void addExternalStorageInterface(IExternalStorageHandler esh);

    /**
     * @param te
     * @param opposite
     * @param channel
     * @param mySrc
     * @return the handler for a given tile / forge direction
     */
    IExternalStorageHandler getHandler(TileEntity te, ForgeDirection opposite, StorageChannel channel, BaseActionSource mySrc);

}