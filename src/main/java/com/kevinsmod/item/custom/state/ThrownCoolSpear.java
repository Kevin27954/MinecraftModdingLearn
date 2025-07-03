package com.kevinsmod.item.custom.state;

import com.kevinsmod.KevinsMod;
import com.kevinsmod.item.SimpleItems;
import net.minecraft.core.particles.ItemParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;

public class ThrownCoolSpear extends ThrowableItemProjectile {

    public ThrownCoolSpear(EntityType<? extends ThrownCoolSpear> entityType, Level level) {
        super(entityType, level);
    }

    public ThrownCoolSpear(EntityType<? extends ThrownCoolSpear> entityType, double x, double y, double z, Level level) {
        super(entityType, x, y, z, level);
    }

    public ThrownCoolSpear(LivingEntity shooter, Level level) {
        super(EntityType.EGG, shooter, level);
    }

    public void handleEntityEvent(byte id) {
        if (id == 3) {
            double d0 = 0.08;

            for(int i = 0; i < 8; ++i) {
                this.level().addParticle(new ItemParticleOption(ParticleTypes.ITEM, this.getItem()), this.getX(), this.getY(), this.getZ(), ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08, ((double)this.random.nextFloat() - (double)0.5F) * 0.08);
            }
        }

    }

    protected void onHit(HitResult result) {
        super.onHit(result);
        Level level = this.level();

        if(!level.isClientSide) {
            level.setBlockAndUpdate(this.getOnPos(), Blocks.OAK_LOG.defaultBlockState());

            level.broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
    }


    @Override
    protected Item getDefaultItem() {
        return SimpleItems.COOL_SPEAR.get();
    }
}
