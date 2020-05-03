
package net.mcreator.survival.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class StoneRock extends Item {
	public StoneRock() {
		super(new Settings().group(ItemGroup.MISC).maxCount(64));
	}
}
