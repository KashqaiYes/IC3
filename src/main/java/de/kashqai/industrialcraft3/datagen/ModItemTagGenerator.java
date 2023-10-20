package de.kashqai.industrialcraft3.datagen;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> future,
                               CompletableFuture<TagLookup<Block>> completableFuture,  @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, future, completableFuture, IndustrialCraft3.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        //add ItemTags here e.g

    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
