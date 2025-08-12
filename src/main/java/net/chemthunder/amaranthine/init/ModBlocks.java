package net.chemthunder.amaranthine.init;

import net.chemthunder.amaranthine.Amaranthine;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.function.Function;

public interface ModBlocks {


        Block AMARANTHINE_BLOCK = createWithItem("amaranthine_block", AmethystBlock::new, AbstractBlock.Settings.copy(Blocks.AMETHYST_BLOCK)
                .mapColor(MapColor.PALE_PURPLE)
                );




    // Create and Register always
    static Block create(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return Blocks.register(RegistryKey.of(RegistryKeys.BLOCK, Amaranthine.id(name)), factory, settings);
    }

    // Create and Register if specified mod is loaded or if the current instance is a dev environment
    static Block createCompat(String name, String modId, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return FabricLoader.getInstance().isModLoaded(modId) || FabricLoader.getInstance().isDevelopmentEnvironment() ? create(name, factory, settings) : null;
    }

    // Create and Register with an item, always
    static Block createWithItem(String name, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = create(name, factory, settings);
        ModItems.create(name, (itemSettings) -> new BlockItem(block, itemSettings), (new Item.Settings()).useBlockPrefixedTranslationKey());
        return block;
    }

    // Create and Register with an item, if specified mod is loaded or if the current instance is a dev environment
    static Block createCompatWithItem(String name, String modId, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return FabricLoader.getInstance().isModLoaded(modId) || FabricLoader.getInstance().isDevelopmentEnvironment() ? createWithItem(name, factory, settings) : null;
    }

    static void init() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(ModBlocks::addNaturalEntries);
    }

    private static void addNaturalEntries(FabricItemGroupEntries entries) {
        entries.add(AMARANTHINE_BLOCK);
    }
}
