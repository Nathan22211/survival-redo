package net.mcreator.survival.item;

import net.mcreator.survival.api.ICanLightUnlitTorch;
import net.minecraft.item.FlintAndSteelItem;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class FireItem extends FlintAndSteelItem implements ICanLightUnlitTorch {
    public FireItem(Settings settings, FireItemTypes type) {
        super(settings.maxDamage(type.damage));
    }

    @Override
    public boolean depletedOnUse() {
        return false;
    }

    @Override
    public SoundEvent soundPlayedOnUse() {
        return SoundEvents.ITEM_FLINTANDSTEEL_USE;
    }
}
