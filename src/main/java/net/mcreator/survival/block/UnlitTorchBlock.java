package net.mcreator.survival.block;

import net.mcreator.survival.api.ICanLightUnlitTorch;
import net.mcreator.survival.api.IHasAdvancedLightFunctions;
import net.mcreator.survival.config.SurvivalConfig;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.mcreator.survival.item.TorchTypes;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.TorchBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class UnlitTorchBlock extends TorchBlock {
    public final TorchTypes type;

    public UnlitTorchBlock(Settings settings, TorchTypes type) {
        super(settings.nonOpaque().noCollision(), ParticleTypes.FLAME);
        this.type = type;
    }

    @SuppressWarnings("deprecation")
    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        SurvivalConfig config = AutoConfig.getConfigHolder(SurvivalConfig.class).getConfig();
        boolean itemCanLight = false;
        if (config.getItemsThatCanLightList() != null) {
            for (String itemID : config.getItemsThatCanLightList()) {
                String s = itemStack.getTranslationKey().replace('.', ':');
                if (s.substring(s.indexOf(':') + 1).equals(itemID)) {
                    itemCanLight = true;
                    break;
                }
            }
        }
        if (itemStack.getItem() == Items.FLINT_AND_STEEL || itemStack.getItem() instanceof ICanLightUnlitTorch || itemStack.getItem() == type.litItem || itemCanLight) {
            if (itemStack.getItem() instanceof ICanLightUnlitTorch) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), ((ICanLightUnlitTorch) itemStack.getItem()).soundPlayedOnUse(), SoundCategory.NEUTRAL, 1.0F, 1.0F);
            } else if (itemStack.getItem() == Items.FLINT_AND_STEEL) {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FLINTANDSTEEL_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            } else {
                world.playSound(player, pos.getX(), pos.getY(), pos.getZ(), SoundEvents.ITEM_FIRECHARGE_USE, SoundCategory.NEUTRAL, 1.0F, 1.0F);
            }
            if (!world.isClient()) {
                if (itemStack.getItem() instanceof IHasAdvancedLightFunctions) {
                    ((IHasAdvancedLightFunctions) itemStack.getItem()).onTorchLight();
                }
                if (itemStack.getItem() == type.litItem && config.canLitTorchMoveUnlitToInventory()) {
                    player.giveItemStack(new ItemStack(type.litBlock));
                    world.setBlockState(pos, Blocks.AIR.getDefaultState());
                } else if (itemStack.getItem() instanceof ICanLightUnlitTorch && ((ICanLightUnlitTorch) itemStack.getItem()).addLitTorchToInventory()) {
                    player.giveItemStack(new ItemStack(type.litBlock));
                    world.setBlockState(pos, type.litBlock.getDefaultState());
                    if (((ICanLightUnlitTorch) itemStack.getItem()).depletedOnUse() && !player.isCreative()) {
                        player.inventory.removeOne(itemStack);
                    }
                } else {
                    if (itemStack.getItem() instanceof ICanLightUnlitTorch) {
                        if (((ICanLightUnlitTorch) itemStack.getItem()).depletedOnUse() && !player.isCreative()) {
                            player.inventory.removeOne(itemStack);
                        }
                    } else if (itemStack.getItem() != type.litItem && !player.isCreative()) {
                        player.inventory.removeOne(itemStack);
                    }
                    world.setBlockState(pos, type.litBlock.getDefaultState());
                }
                itemStack.damage(1, player, (playerEntity) -> playerEntity.sendToolBreakStatus(hand));
            }
        }
        return ActionResult.SUCCESS;
    }

    // Used to disable the particles that a torch block usually generates.
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {}
}