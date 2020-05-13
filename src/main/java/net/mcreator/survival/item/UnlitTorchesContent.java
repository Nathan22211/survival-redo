package net.mcreator.survival.item;

import net.mcreator.survival.Survival;
import net.mcreator.survival.block.UnlitTorchBlock;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.mcreator.survival.block.UnlitWallTorchBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class UnlitTorchesContent {

    public static final Block UNLIT_TORCH;
    //public static final Block UNLIT_WALL_TORCH;
    public static final Item FireSticks;
    public static final Item IronStoneFlint;
    public static final Item NetheriteAndSteel;

    static {
        // Block
        UNLIT_TORCH = new UnlitTorchBlock(FabricBlockSettings.of(Material.PART).breakInstantly(), TorchTypes.REGULAR);
        //UNLIT_WALL_TORCH = new UnlitWallTorchBlock(FabricBlockSettings.of(Material.PART).breakInstantly(), WallTorchTypes.REGULAR);
        //item
        FireSticks = new FireItem(new Item.Settings().group(ItemGroup.TOOLS), FireItemTypes.Sticks);
        IronStoneFlint = new FireItem(new Item.Settings().group(ItemGroup.TOOLS), FireItemTypes.IronStone);
        NetheriteAndSteel = new FireItem(new Item.Settings().group(ItemGroup.TOOLS), FireItemTypes.Netherite);
    }


    public static void registerTorch() {

        Registry.register(Registry.BLOCK, new Identifier("survival", "unlit_torch"), UNLIT_TORCH);
        //Registry.register(Registry.BLOCK, new Identifier("survival", "unlit_wall_torch"), UNLIT_WALL_TORCH);
        Registry.register(Registry.ITEM, new Identifier("survival", "unlit_torch"), new BlockItem(UNLIT_TORCH, new Item.Settings().group(ItemGroup.DECORATIONS)));

    }

    public static void registerItem() {

        Registry.register(Registry.ITEM, new Identifier("survival", "fire_sticks"), FireSticks);
    }
}
