package net.chemthunder.amaranthine.effect;

import net.chemthunder.amaranthine.init.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.server.world.ServerWorld;

public class InsanityEffect extends StatusEffect {
    public InsanityEffect() {
        super(StatusEffectCategory.HARMFUL, 0xE142FD);
    }

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity player, int amplifier) {
        player.playSound(ModSounds.INSANITY_VOICES);
        return super.applyUpdateEffect(world, player, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 50;
        return duration % i == 0;
    }

    @Override
    public ParticleEffect createParticle(StatusEffectInstance effect) {
        return super.createParticle(effect);
    }
}


//