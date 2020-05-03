
package net.mcreator.survival.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

public class GrassVine extends Item {
	public GrassVine() {
		super(new Settings().group(ItemGroup.MISC).maxCount(64));
	}
}
