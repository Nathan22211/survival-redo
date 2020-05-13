package net.mcreator.survival.item;

import me.crimsondawn45.fabricshieldlib.object.FabricShield;
import net.minecraft.item.Item;
import net.minecraft.tag.Tag.Identified;

public class CorpseShield extends FabricShield
{
    public CorpseShield(Settings settings, int cooldownTicks, int durability, Identified<Item> planks)
    {
        super(settings, cooldownTicks, durability, planks);
    }
}
