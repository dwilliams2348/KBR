package net.threeres.kbr.block;

import net.threeres.kbr.KBR;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.threeres.kbr.block.custom.SoundBlock;
import net.threeres.kbr.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    //does not automatically register blocks as an item, RegisterBlockItem method below does this for us
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KBR.MOD_ID);

    //custom blocks
    public static final RegistryObject<Block> TEST_BLOCK =
            RegisterBlock("test_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));

    public static final RegistryObject<Block> SOUND_BLOCK =
            RegisterBlock("sound_block", () -> new SoundBlock(BlockBehaviour.Properties.copy(Blocks.WHITE_WOOL)));

    //custom ores
    public static final RegistryObject<Block> TEST_ORE =
            RegisterBlock("test_ore",  () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f)
                    .requiresCorrectToolForDrops(), UniformInt.of(3, 6)));

    private static <T extends Block> RegistryObject<T> RegisterBlock(String name, Supplier<T> block) {
        RegistryObject<T> ret = BLOCKS.register(name, block);
        RegisterBlockItem(name, ret);
        return ret;
    }

    private static <T extends Block>RegistryObject<Item> RegisterBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void Register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
