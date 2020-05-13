#crafting commands
execute as @a if entity @s[scores={StickCraft=1..}] run function survival:recipes_random/stick
execute as @a if entity @s[scores={FlintCraft=1..}] run function survival:recipes_random/flint
#clearing commands
clear @s survival:stick 1
clear @s survival:flint 1