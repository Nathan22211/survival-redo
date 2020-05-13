package net.mcreator.survival.api;

/**
 * @author Maowcraft
 *
 * This interface gives an item more functionality when it lights a torch.
 */
public interface IHasAdvancedLightFunctions {
    /**
     * An optional method that is triggered when an unlit torch is lit using this item.
     */
    default void onTorchLight() {}
}
