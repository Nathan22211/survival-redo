
package net.mcreator.survival.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class Saw extends Item {
	public Saw() {
		super(new Settings().group(ItemGroup.MISC).maxCount(64));
	}
}
