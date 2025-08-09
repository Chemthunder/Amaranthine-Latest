package net.chemthunder.amaranthine;

import net.chemthunder.amaranthine.init.ModSounds;
import net.chemthunder.amaranthine.init.ModStatusEffects;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class AmaranthineClient implements ClientModInitializer {
    public void onInitializeClient() {
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player == null) {
                return;
            }

            if (client.player.hasStatusEffect(ModStatusEffects.INSANITY) && client.player.getRandom().nextFloat() > 0.99f) {
                client.player.playSound(ModSounds.INSANITY_VOICES, 0.5f, 0);
            }
        });
    }
}
