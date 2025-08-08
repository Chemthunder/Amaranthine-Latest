package net.chemthunder.amaranthine.effect;

import net.chemthunder.amaranthine.init.ModSounds;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.server.world.ServerWorld;

public class InsanityEffect extends StatusEffect {
    public InsanityEffect() {
        super(StatusEffectCategory.HARMFUL, 0xE142FD);
    }

    public boolean applyUpdateEffect(ServerWorld world, LivingEntity entity, int amplifier) {
      entity.playSound(ModSounds.INSANITY_VOICES, 5, 0);
        return super.applyUpdateEffect(world, entity, amplifier);
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 20;
        return duration % i == 0;
    }
}
