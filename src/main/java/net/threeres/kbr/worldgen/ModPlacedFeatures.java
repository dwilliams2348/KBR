package net.threeres.kbr.worldgen;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.threeres.kbr.KBR;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature> TestOre = RegisterKey("test_ore");

    public static void bootstrap(BootstapContext<PlacedFeature> context){
        var configureFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
        register(context, TestOre, configureFeatures.getOrThrow(ModConfiguredFeatures.TestOre), ModOrePlacement.commonOrPlacement(12,
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(128))));
    }

    private static ResourceKey<PlacedFeature> RegisterKey(String name){
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(KBR.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
