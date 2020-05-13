package net.mcreator.survival.config;

import me.sargunvohra.mcmods.autoconfig1u.shadowed.blue.endless.jankson.Comment;
import net.mcreator.survival.Survival;
import me.sargunvohra.mcmods.autoconfig1u.ConfigData;
import me.sargunvohra.mcmods.autoconfig1u.annotation.Config;

import java.util.Arrays;
import java.util.List;

@Config(name = "survival")
public class SurvivalConfig implements ConfigData {
    @Comment("configure unlit torches feature")
    private boolean litTorchMovesUnlitToInventory = true;
    private boolean CraftMakesUnlitTorches = true;
    private boolean litTorchBurnsOut = true;
    private boolean StrippedLogPlanks = true;


    private List<String> itemsThatCanLightList;

    public List<String> getItemsThatCanLightList() {
        return itemsThatCanLightList;
    }

    public boolean canLitTorchMoveUnlitToInventory() {
        return litTorchMovesUnlitToInventory;
    }
    public boolean CraftMakesUnlitTorches() {
        return CraftMakesUnlitTorches;
    }
    public boolean litTorchBurnsOut() {
        return litTorchBurnsOut;
    }
    public boolean StrippedLogPlanks() {
        return StrippedLogPlanks;
    }

    @Override
    public void validatePostLoad() throws ValidationException {
        if (itemsThatCanLightList == null) {
            itemsThatCanLightList = Arrays.asList("minecraft:fire_charge");
        }
    }
}