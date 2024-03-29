package appeng.api.parts;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.util.IIcon;
import net.minecraftforge.common.util.ForgeDirection;

import java.util.EnumSet;

public interface IPartRenderHelper {

    /**
     * sets the Render Helpers Block Bounds. 0.0 - 16.0 block coords.
     * <p/>
     * No complaints about the size, I like using pixels :P
     *
     * @param minX
     * @param minY
     * @param minZ
     * @param maxX
     * @param maxY
     * @param maxZ
     */
    void setBounds(float minX, float minY, float minZ, float maxX, float maxY, float maxZ);

    /**
     * static renderer
     * <p/>
     * render a single face.
     *
     * @param x
     * @param y
     * @param z
     * @param ico
     * @param face
     * @param renderer
     */
    @SideOnly(Side.CLIENT)
    void renderFace(int x, int y, int z, IIcon ico, ForgeDirection face, RenderBlocks renderer);

    /**
     * static renderer
     * <p/>
     * render a box with a cut out box in the center.
     *
     * @param x
     * @param y
     * @param z
     * @param ico
     * @param face
     * @param edgeThickness
     * @param renderer
     */
    @SideOnly(Side.CLIENT)
    void renderFaceCutout(int x, int y, int z, IIcon ico, ForgeDirection face, float edgeThickness, RenderBlocks renderer);

    /**
     * static renderer
     * <p/>
     * render a block of specified bounds.
     *
     * @param x
     * @param y
     * @param z
     * @param renderer
     */
    @SideOnly(Side.CLIENT)
    void renderBlock(int x, int y, int z, RenderBlocks renderer);

    /**
     * render a single face in inventory renderer.
     *
     * @param IIcon
     * @param south
     * @param renderer
     */
    @SideOnly(Side.CLIENT)
    void renderInventoryFace(IIcon IIcon, ForgeDirection south, RenderBlocks renderer);

    /**
     * render a box in inventory renderer.
     *
     * @param renderer
     */
    @SideOnly(Side.CLIENT)
    void renderInventoryBox(RenderBlocks renderer);

    /**
     * inventory, and static renderer.
     * <p/>
     * set unique icons for each side of the block.
     *
     * @param Down
     * @param Up
     * @param North
     * @param South
     * @param West
     * @param East
     */
    void setTexture(IIcon Down, IIcon Up, IIcon North, IIcon South, IIcon West, IIcon East);

    /**
     * inventory, and static renderer.
     * <p/>
     * set all sides to a single IIcon.
     *
     * @param ico
     */
    void setTexture(IIcon ico);

    /**
     * configure the color multiplier for the inventory renderer.
     *
     * @param whiteVariant
     */
    void setInvColor(int whiteVariant);

    /**
     * @return the block used for rendering, might need it for some reason...
     */
    Block getBlock();

    /**
     * @return the east vector in world directions, rather then renderer
     */
    ForgeDirection getWorldX();

    /**
     * @return the up vector in world directions, rather then renderer.
     */
    ForgeDirection getWorldY();

    /**
     * @return the forward vector in world directions, rather then renderer.
     */
    ForgeDirection getWorldZ();

    /**
     * Pre-Calculates default lighting for the part, call this before using the render helper to render anything else to
     * get simplified, but faster lighting for more then one block.
     * <p/>
     * Only worth it if you render more then 1 block.
     */
    ISimplifiedBundle useSimpliedRendering(int x, int y, int z, IPart p, ISimplifiedBundle sim);

    /**
     * disables, useSimpliedRendering.
     */
    void normalRendering();

    /**
     * render a block using the current renderer state.
     *
     * @param x
     * @param y
     * @param z
     * @param renderer
     */
    void renderBlockCurrentBounds(int x, int y, int z, RenderBlocks renderer);

    /**
     * allow you to enable your part to render during the alpha pass or the standard pass.
     *
     * @param pass
     */
    void renderForPass(int pass);

    /**
     * Set which faces to render, remember to set back to ALL when you are done.
     *
     * @param complementOf
     */
    void setFacesToRender(EnumSet<ForgeDirection> complementOf);

}