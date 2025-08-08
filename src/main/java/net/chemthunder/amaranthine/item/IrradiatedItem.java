package net.chemthunder.amaranthine.item;

import net.chemthunder.amaranthine.init.ModStatusEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class IrradiatedItem extends Item {
    public IrradiatedItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult use(World world, PlayerEntity user, Hand hand) {
        user.addStatusEffect(new StatusEffectInstance(ModStatusEffects.INSANITY, 999999999, 1));



        return super.use(world, user, hand);
    }
}
