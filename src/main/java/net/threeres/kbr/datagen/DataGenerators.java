package net.threeres.kbr.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.threeres.kbr.KBR;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = KBR.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void GatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        PackOutput output = gen.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        gen.addProvider(event.includeServer(), new ModRecipeProvider(output));
        gen.addProvider(event.includeServer(), ModLootTableProvider.create(output));

        gen.addProvider(event.includeClient(), new ModBlockStateProvider(output, existingFileHelper));
        gen.addProvider(event.includeClient(), new ModItemModelProvider(output, existingFileHelper));

        ModBlockTagGenerator blockTagGenerator = gen.addProvider(event.includeServer(),
                new ModBlockTagGenerator(output, lookupProvider, existingFileHelper));
        gen.addProvider(event.includeServer(), new ModItemTagGenerator(output, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
