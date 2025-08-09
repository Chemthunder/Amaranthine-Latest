package net.chemthunder.amaranthine.item;

import net.chemthunder.amaranthine.init.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class AmaranthineItem extends Item {
    public AmaranthineItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        BlockState state = context.getWorld().getBlockState(context.getBlockPos());
        PlayerEntity user = context.getPlayer();
        if (user != null && user.isSneaking() && state.isOf(Blocks.RAW_GOLD_BLOCK)) {
            ItemStack stack = user.getMainHandStack();
            if (stack.isOf(ModItems.AMARANTHINE_SHARD)) {
                stack.decrement(1);
                user.giveItemStack(ModItems.IRRADIATED_AMARANTHINE_SHARD.getDefaultStack());
                user.playSound(SoundEvents.BLOCK_BEACON_ACTIVATE, 0.8F, 1.0F);
            }
            return ActionResult.SUCCESS;
        }


        return super.useOnBlock(context);
    }
}
