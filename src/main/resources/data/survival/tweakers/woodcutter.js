var RecipeTweaker = libcd.require("libcd.recipe.RecipeTweaker");
var TweakerUtils = libcd.require("libcd.util.TweakerUtils");
//configure recipe wood types here
var woodTypes = ["minecraft:oak", "minecraft:birch", "minecraft:spruce", "minecraft:acacia", "minecraft:jungle", "minecraft:dark_oak", "minecraft:warped", "minecraft:crimson"];

RecipeTweaker.removeRecipesFor("minecraft:ladder", "corail_woodcutter:woodcutting");
RecipeTweaker.removeRecipesFor("minecraft:bowl", "corail_woodcutter:woodcutting");
RecipeTweaker.removeRecipesFor("minecraft:stone_button", "minecraft:crafting_shapeless");
RecipeTweaker.removeRecipesFor("minecraft:stone_pressure_plate", "minecraft:crafting_shaped");
for(var i = 0; i < woodTypes.length; ++i) {
    RecipeTweaker.addRecipe(RecipeTweaker.builder("corail_woodcutter:woodcutting").ingredient("ingredient", woodTypes[i] + "_planks").property("result", woodTypes[i] + "_button").property("count", 30).idStack(woodTypes[i] + "_button").build());
    RecipeTweaker.addRecipe(RecipeTweaker.builder("corail_woodcutter:woodcutting").ingredient("ingredient", woodTypes[i] + "_planks").property("result", woodTypes[i] + "_pressure_plate").property("count", 20).idStack(woodTypes[i] + "_pressure_plate").build());
}
for(var i = 0; i < woodTypes.length; ++i) {
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_button", "minecraft:crafting_shapeless");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_pressure_plate", "minecraft:crafting_shaped");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_door", "corail_woodcutter:woodcutting");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_slab", "minecraft:crafting_shaped");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_stairs", "minecraft:crafting_shaped");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_trapdoor", "corail_woodcutter:woodcutting");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_fence", "corail_woodcutter:woodcutting");
    RecipeTweaker.removeRecipesFor(woodTypes[i] + "_fence_gate", "corail_woodcutter:woodcutting");
}