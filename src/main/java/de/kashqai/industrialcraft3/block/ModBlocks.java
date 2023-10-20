package de.kashqai.industrialcraft3.block;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import de.kashqai.industrialcraft3.block.custom.ElectricFurnaceBlock;
import de.kashqai.industrialcraft3.item.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, IndustrialCraft3.MOD_ID);

    public static final RegistryObject<Block> TIN_BLOCK = registerBlock("tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_ORE = registerBlock("tin_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,5)));
    public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = registerBlock("deepslate_tin_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_IRON_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,5)));
    public static final RegistryObject<Block> RAW_TIN_BLOCK = registerBlock("raw_tin_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> LEAD_ORE = registerBlock("lead_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.COPPER_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,5)));
    public static final RegistryObject<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_COPPER_ORE)
                    .strength(5f).requiresCorrectToolForDrops(), UniformInt.of(3,5)));
    public static final RegistryObject<Block> LEAD_BLOCK = registerBlock("lead_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> TIN_STAIRS = registerBlock("tin_stairs",
            () -> new StairBlock(() -> ModBlocks.TIN_BLOCK.get().defaultBlockState(),BlockBehaviour.Properties.copy(Blocks.CUT_COPPER_STAIRS)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_SLAB = registerBlock("tin_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CUT_COPPER_SLAB)
                    .strength(5f).requiresCorrectToolForDrops()));



    public static final RegistryObject<Block> TIN_PRESSURE_PLATE = registerBlock("tin_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.CUT_COPPER_STAIRS).strength(5f).requiresCorrectToolForDrops(),
                    BlockSetType.IRON));
    public static final RegistryObject<Block> TIN_BUTTON = registerBlock("tin_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.CUT_COPPER_SLAB)
                    .strength(5f).requiresCorrectToolForDrops(), BlockSetType.IRON, 10, true));



    public static final RegistryObject<Block> TIN_FENCE = registerBlock("tin_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TIN_FENCE_GATE = registerBlock("tin_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops(), SoundEvents.FENCE_GATE_OPEN, SoundEvents.FENCE_GATE_CLOSE));
    public static final RegistryObject<Block> TIN_WALL = registerBlock("tin_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5f).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ELECTRIC_FURNACE = registerBlock("electric_furnace",
            () -> new ElectricFurnaceBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));







    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }


    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
