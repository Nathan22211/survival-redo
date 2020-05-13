package net.mcreator.survival.item;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public enum WallTorchTypes {
    REGULAR(Blocks.WALL_TORCH, Items.TORCH),
    SOUL(Blocks.SOUL_WALL_TORCH, Items.SOUL_TORCH);

    public Block litBlock;
    public Item litItem;

    WallTorchTypes(Block litBlock, Item litItem) {
        this.litBlock = litBlock;
        this.litItem = litItem;
    }
}
