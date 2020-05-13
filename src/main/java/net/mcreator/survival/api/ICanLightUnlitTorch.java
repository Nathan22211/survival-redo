package net.mcreator.survival.api;

import net.minecraft.sound.SoundEvent;

/**
 * @author Maowcraft
 *
 * This interface is used to mark an item as being able to light an unlit torch block.
 */
public interface ICanLightUnlitTorch {
    /**
     * Is a lit torch added to the player's inventory when this item is used?
     * @return boolean
     */
    default boolean addLitTorchToInventory() {
        return false;
    }

    /**
     * Is this item depleted when it is used to light a torch?
     * @return boolean
     */
    default boolean depletedOnUse() {
        return true;
    }

    /**
     * What sound should be played when you use this item to light a torch?
     * @return SoundEvent
     */
    SoundEvent soundPlayedOnUse();
}
