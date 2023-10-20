package de.kashqai.industrialcraft3.datagen;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import de.kashqai.industrialcraft3.block.ModBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, IndustrialCraft3.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {


        this.tag(BlockTags.FENCES)
                .add(ModBlocks.TIN_FENCE.get());
        this.tag(BlockTags.WALLS)
                .add(ModBlocks.TIN_WALL.get());
        this.tag(BlockTags.FENCE_GATES)
                .add(ModBlocks.TIN_FENCE_GATE.get());








    }

    @Override
    public String getName() {
        return "Block Tags";
    }
}
