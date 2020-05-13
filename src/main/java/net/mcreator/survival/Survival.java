
package net.mcreator.survival;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.JanksonConfigSerializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.mcreator.survival.config.SurvivalConfig;
import net.mcreator.survival.entity.GhostEntity;
import net.mcreator.survival.item.*;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.tag.ItemTags;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.Item;

import net.fabricmc.api.ModInitializer;

public class Survival implements ModInitializer {
	public static final Item StoneRock = new StoneRock();
	public static final Item GrassVine = new GrassVine();
	public static final Item Saw = new Saw();
	public static final Item Iron_Embedded_Stone = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
	public static final Item Old_Rag = new Item(new Item.Settings().group(ItemGroup.MISC).maxCount(64));
	//technical items
	public static final Item Cow_Caucus_Drop = new Item(new Item.Settings());
	public static final Item Sheep_Caucus_drop = new Item(new Item.Settings());
	public static final Item Pig_Caucus_drop = new Item(new Item.Settings());
	public static final Item Chicken_Caucus_drop = new Item(new Item.Settings());
	public static final Item Flint_Recipe_Item = new Item(new Item.Settings());
	public static final Item Stick_Recipe_Item = new Item(new Item.Settings());
	public static final Item Oak_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Birch_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Spruce_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Acacia_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Jungle_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Dark_Oak_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Crimson_Plank_Recipe_Item = new Item(new Item.Settings());
	public static final Item Warped_Plank_Recipe_Item = new Item(new Item.Settings());
	//entities. currently need to fix
	/*public static final EntityType<GhostEntity> Ghost =
			Registry.register(
					Registry.ENTITY_TYPE,
					new Identifier("survival", "ghost"),
					FabricEntityTypeBuilder.create(SpawnGroup.MONSTER, GhostEntity::new).size(EntityDimensions.fixed(1, 2)).build()
			);

	 */

	@Override
	public void onInitialize() {
		AutoConfig.register(SurvivalConfig.class, JanksonConfigSerializer::new);
		Registry.register(Registry.ITEM, new Identifier("survival", "stone_rock"), StoneRock);
		Registry.register(Registry.ITEM, new Identifier("survival", "grass_vine"), GrassVine);
		Registry.register(Registry.ITEM, new Identifier("survival", "saw"), Saw);
		Registry.register(Registry.ITEM, new Identifier("survival","cow_caucus_drop"), Cow_Caucus_Drop);
		Registry.register(Registry.ITEM, new Identifier("survival","sheep_caucus_drop"), Sheep_Caucus_drop);
		Registry.register(Registry.ITEM, new Identifier("survival","pig_caucus_drop"), Pig_Caucus_drop);
		Registry.register(Registry.ITEM, new Identifier("survival","chicken_caucus_drop"), Chicken_Caucus_drop);
		Registry.register(Registry.ITEM, new Identifier("survival","flint"), Flint_Recipe_Item);
		Registry.register(Registry.ITEM, new Identifier("survival","stick"), Stick_Recipe_Item);
		Registry.register(Registry.ITEM, new Identifier("survival", "iron_stone"), Iron_Embedded_Stone);
		SurvivalConfig config = AutoConfig.getConfigHolder(SurvivalConfig.class).getConfig();
		if (config.StrippedLogPlanks() == true) {
			Registry.register(Registry.ITEM, new Identifier("survival", "oak_planks"), Oak_Plank_Recipe_Item);
			Registry.register(Registry.ITEM, new Identifier("survival", "birch_planks"), Birch_Plank_Recipe_Item);
		}
		//shields
		Registry.register(Registry.ITEM, new Identifier("survival", "cow_caucus"), new CorpseShield(new Item.Settings().group(ItemGroup.MISC), 5000, 5, ItemTags.PLANKS));//TODO remove repair item if possible
		Registry.register(Registry.ITEM, new Identifier("survival", "sheep_caucus"), new CorpseShield(new Item.Settings().group(ItemGroup.MISC), 5000, 5, ItemTags.PLANKS));
		Registry.register(Registry.ITEM, new Identifier("survival", "pig_caucus"), new CorpseShield(new Item.Settings().group(ItemGroup.MISC), 5000, 5, ItemTags.PLANKS));
		Registry.register(Registry.ITEM, new Identifier("survival", "chicken_caucus"), new CorpseShield(new Item.Settings().group(ItemGroup.MISC), 5000, 5, ItemTags.PLANKS));
		//config registry
		UnlitTorchesContent.registerItem();

	}
}
