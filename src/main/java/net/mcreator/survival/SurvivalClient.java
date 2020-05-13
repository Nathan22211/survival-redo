package net.mcreator.survival;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.mcreator.survival.config.SurvivalConfig;
import net.mcreator.survival.item.UnlitTorchesContent;
import net.minecraft.client.render.RenderLayer;

@Environment(EnvType.CLIENT)
public class SurvivalClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        AutoConfig.getGuiRegistry(SurvivalConfig.class);
        BlockRenderLayerMap.INSTANCE.putBlock(UnlitTorchesContent.UNLIT_TORCH, RenderLayer.getCutout());
    }
}
