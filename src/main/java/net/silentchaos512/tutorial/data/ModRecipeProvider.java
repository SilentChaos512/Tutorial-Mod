package net.silentchaos512.tutorial.data;

import net.minecraft.data.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;
import net.silentchaos512.tutorial.TutorialMod;
import net.silentchaos512.tutorial.setup.ModBlocks;
import net.silentchaos512.tutorial.setup.ModItems;

import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider {
    public ModRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapelessRecipe(ModItems.SILVER_INGOT.get(), 9)
                .addIngredient(ModBlocks.SILVER_BLOCK.get())
                .addCriterion("has_item", hasItem(ModItems.SILVER_INGOT.get()))
                .build(consumer);

        ShapedRecipeBuilder.shapedRecipe(ModBlocks.SILVER_BLOCK.get())
                .key('#', ModItems.SILVER_INGOT.get())
                .patternLine("###")
                .patternLine("###")
                .patternLine("###")
                .addCriterion("has_item", hasItem(ModItems.SILVER_INGOT.get()))
                .build(consumer);

        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 200)
                .addCriterion("has_item", hasItem(ModBlocks.SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 100)
                .addCriterion("has_item", hasItem(ModBlocks.SILVER_ORE.get()))
                .build(consumer, modId("silver_ingot_blasting"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(TutorialMod.MOD_ID, path);
    }
}
