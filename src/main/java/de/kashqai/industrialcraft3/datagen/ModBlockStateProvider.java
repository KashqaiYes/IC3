package de.kashqai.industrialcraft3.datagen;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import de.kashqai.industrialcraft3.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, IndustrialCraft3.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.TIN_BLOCK);
        blockWithItem(ModBlocks.RAW_TIN_BLOCK);
        blockWithItem(ModBlocks.LEAD_BLOCK);
        blockWithItem(ModBlocks.DEEPSLATE_TIN_ORE);
        blockWithItem(ModBlocks.TIN_ORE);
        blockWithItem(ModBlocks.LEAD_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_LEAD_ORE);



        stairsBlock((StairBlock) ModBlocks.TIN_STAIRS.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));
        slabBlock((SlabBlock) ModBlocks.TIN_SLAB.get(), blockTexture(ModBlocks.TIN_BLOCK.get()), blockTexture(ModBlocks.TIN_BLOCK.get()));



        blockItem(ModBlocks.TIN_SLAB);
        blockItem(ModBlocks.TIN_STAIRS);
        blockItem(ModBlocks.TIN_PRESSURE_PLATE);
        blockItem(ModBlocks.TIN_FENCE_GATE);



        buttonBlock((ButtonBlock) ModBlocks.TIN_BUTTON.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));
        pressurePlateBlock((PressurePlateBlock) ModBlocks.TIN_PRESSURE_PLATE.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));



        fenceBlock((FenceBlock) ModBlocks.TIN_FENCE.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));
        fenceGateBlock((FenceGateBlock) ModBlocks.TIN_FENCE_GATE.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));
        wallBlock((WallBlock) ModBlocks.TIN_WALL.get(), blockTexture(ModBlocks.TIN_BLOCK.get()));



        horizontalBlock(ModBlocks.ELECTRIC_FURNACE.get(),
                new ModelFile.UncheckedModelFile(modLoc("block/electric_furnace")));

    }

    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("industrialcraft3:block/" + ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
