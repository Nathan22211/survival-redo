package net.mcreator.survival.item;

import net.mcreator.survival.item.UnlitTorchesContent;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;

public enum TorchTypes {
    REGULAR(UnlitTorchesContent.UNLIT_TORCH, Blocks.TORCH, Items.TORCH);
    //SOUL(UnlitTorchesContent.UNLIT_SOUL_TORCH, Blocks.SOUL_TORCH, Items.SOUL_TORCH);

    public Block unlitBlock;
    public Block litBlock;
    public Item litItem;

    TorchTypes(Block unlitBlock, Block litBlock, Item litItem) {
        this.unlitBlock = unlitBlock;
        this.litBlock = litBlock;
        this.litItem = litItem;
    }
}
