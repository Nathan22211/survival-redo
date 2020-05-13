package net.mcreator.survival.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.SkeletonEntity;

import net.minecraft.world.World;

public class GhostEntity extends SkeletonEntity {
    public GhostEntity(EntityType<? extends SkeletonEntity> entityType, World world) {
        super(entityType, world);
    }
}


