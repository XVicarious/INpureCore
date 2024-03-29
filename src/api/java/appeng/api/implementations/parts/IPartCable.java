package appeng.api.implementations.parts;

import appeng.api.networking.IGridHost;
import appeng.api.parts.BusSupport;
import appeng.api.parts.IPart;
import appeng.api.parts.IPartHost;
import appeng.api.util.AECableType;
import appeng.api.util.AEColor;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.EnumSet;

/**
 * Implemented on the {@link IPart}s cable objects that can be placed at {@link ForgeDirection}.UNKNWON in
 * {@link IPartHost}s
 */
public interface IPartCable extends IPart, IGridHost {

    /**
     * does this cable support buses?
     */
    BusSupport supportsBuses();

    /**
     * @return the current color of the cable.
     */
    AEColor getCableColor();

    /**
     * @return the Cable type.
     */
    AECableType getCableConnectionType();

    /**
     * Change the color of the cable, this should cost a small amount of dye, or something.
     *
     * @param newColor
     * @return if the color change was successful.
     */
    boolean changeColor(AEColor newColor, EntityPlayer who);

    /**
     * Change sides on the cables node.
     * <p/>
     * Called by AE, do not invoke.
     *
     * @param sides
     */
    void setValidSides(EnumSet<ForgeDirection> sides);

}
