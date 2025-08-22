package net.chemthunder.amaranthine.item;

import net.chemthunder.amaranthine.init.ModItems;
import net.chemthunder.amaranthine.init.ModSounds;
import net.chemthunder.amaranthine.init.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IrradiatedItem extends Item {
    public IrradiatedItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        ItemStack stack = user.getMainHandStack();
        ItemStack offStack = user.getOffHandStack();


        if (stack.isOf(ModItems.IRRADIATED_AMARANTHINE_SHARD)) {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.INSANITY, 999999999, 0));
            user.playSound(ModSounds.INSANITY_VOICES);
            stack.decrement(1);
            user.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE);
            return super.use(world, user, hand);
        }

        if (offStack.isOf(ModItems.IRRADIATED_AMARANTHINE_SHARD)) {
            user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.INSANITY, 999999999, 0));
            user.playSound(ModSounds.INSANITY_VOICES);
            user.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE);
            offStack.decrement(1);
            return super.use(world, user, hand);
        }
        return ActionResult.PASS;
    }
}
