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
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.SILVER_INGOT.get(), 9)
                .requires(ModBlocks.SILVER_BLOCK.get())
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.SILVER_BLOCK.get())
                .define('#', ModItems.SILVER_INGOT.get())
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .unlockedBy("has_item", has(ModItems.SILVER_INGOT.get()))
                .save(consumer);

        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 200)
                .unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, modId("silver_ingot_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.SILVER_ORE.get()), ModItems.SILVER_INGOT.get(), 0.7f, 100)
                .unlockedBy("has_item", has(ModBlocks.SILVER_ORE.get()))
                .save(consumer, modId("silver_ingot_blasting"));
    }

    private static ResourceLocation modId(String path) {
        return new ResourceLocation(TutorialMod.MOD_ID, path);
    }
}
