var LootTweaker = libcd.require("libcd.loot.LootTweaker");
var Conditions = libcd.require("libcd.loot.Conditions");
var Functions = libcd.require("libcd.loot.Functions");
var Entries = libcd.require("libcd.loot.Entries");

var grassTable = LootTweaker.getTable("minecraft:blocks/tall_grass");
var mainGPool = grassTable.getPool(0);
var grass_vineEntry = Entries.item("survival:grass_vine");
mainGPool.addEntries(grass_vineEntry);