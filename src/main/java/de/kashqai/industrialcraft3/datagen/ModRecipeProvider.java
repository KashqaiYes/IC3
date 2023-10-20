package de.kashqai.industrialcraft3.datagen;

import de.kashqai.industrialcraft3.IndustrialCraft3;
import de.kashqai.industrialcraft3.block.ModBlocks;
import de.kashqai.industrialcraft3.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> TIN_SMELTABLES = List.of(ModItems.RAW_TIN.get());
    private static final List<ItemLike> LEAD_SMELTABLES = List.of(ModItems.RAW_LEAD.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
//Tin Slab
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_SLAB.get())
                .pattern("###")
                .define('#', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.TIN_INGOT.get()).build()))
                .save(pWriter);
//Tin Stairs
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_STAIRS.get())
                .pattern("#  ")
                .pattern("## ")
                .pattern("###")
                .define('#', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.TIN_INGOT.get()).build()))
                .save(pWriter);
//Tin Pressure Plate
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_PRESSURE_PLATE.get())
                .pattern("##")
                .define('#', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.TIN_INGOT.get()).build()))
                .save(pWriter);
//Tin Button
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.TIN_BUTTON.get())
                .pattern("#  ")
                .define('#', ModItems.TIN_INGOT.get())
                .unlockedBy("has_tin_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.TIN_INGOT.get()).build()))
                .save(pWriter);





        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.RAW_TIN.get(), RecipeCategory.MISC, ModBlocks.RAW_TIN_BLOCK.get(),
                "industrialcraft3:raw_tin", "tin", "industrialcraft3:raw_tin_block", "raw_tin");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), RecipeCategory.MISC, ModBlocks.TIN_BLOCK.get(),
                "industrialcraft3:tin_ingot", "tin", "industrialcraft3:tin_block", "tin_ingot");
        nineBlockStorageRecipes(pWriter, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), RecipeCategory.MISC, ModBlocks.LEAD_BLOCK.get(),
                "industrialcraft3:raw_lead", "lead", "industrialcraft3:lead_block", "lead_ingot");


        oreSmelting(pWriter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 200, "tin");
        oreSmelting(pWriter, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.25f, 200, "lead");


        oreBlasting(pWriter, TIN_SMELTABLES, RecipeCategory.MISC, ModItems.TIN_INGOT.get(), 0.25f, 130, "tin");
        oreBlasting(pWriter, LEAD_SMELTABLES, RecipeCategory.MISC, ModItems.LEAD_INGOT.get(), 0.25f, 130, "lead");




    }









    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike),
                    has(itemlike)).save(pFinishedRecipeConsumer, IndustrialCraft3.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}