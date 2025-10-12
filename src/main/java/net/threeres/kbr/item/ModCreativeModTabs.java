package net.threeres.kbr.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.threeres.kbr.KBR;
import net.threeres.kbr.block.ModBlocks;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KBR.MOD_ID);

    public static final RegistryObject<CreativeModeTab> KBR_TAB =
            CREATIVE_MODE_TABS.register("kbr_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.TEST_ITEM.get()))
                    .title(Component.translatable("creativetab.kbr_tab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.TEST_ITEM.get()); // the order of these items is the order they are shown in game

                        //how to add vanilla items
                        output.accept(Items.DRAGON_EGG);

                        //adding block items
                        output.accept(ModBlocks.TEST_BLOCK.get());
                        output.accept(ModBlocks.TEST_ORE.get());
                    })
                    .build());

    public static void Register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
