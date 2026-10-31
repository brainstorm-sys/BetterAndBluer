package com.gfr.betterandbluer.recipes;

import com.gfr.betterandbluer.managers.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.plugin.java.JavaPlugin;

public class MethRecipes {

    private final ItemManager itemManager;
    private final JavaPlugin plugin;


    // -- constructor --
    public MethRecipes(JavaPlugin plugin, ItemManager itemManager) {
        this.plugin = plugin;
        this.itemManager = itemManager;
    }


    // -- function --

    public void register(){

        // --- Alluminum amalgam ---
        ShapelessRecipe amalgam = new ShapelessRecipe(new NamespacedKey(plugin, "amalgamballs"), itemManager.create("alluminum_amalgam"));

        amalgam.addIngredient(itemManager.create("alluminum"));
        amalgam.addIngredient(itemManager.create("mercury"));

        plugin.getServer().addRecipe(amalgam);


        // --- Honey-Cocoa Paste ---
        ShapelessRecipe phenyl = new ShapelessRecipe(new NamespacedKey(plugin, "honeycocoapaste"), itemManager.create("honeycocoapaste"));

        phenyl.addIngredient(Material.COCOA_BEANS);
        phenyl.addIngredient(Material.HONEYCOMB);

        plugin.getServer().addRecipe(phenyl);


        // --- Phenylacetone ---
        BlastingRecipe acetone = new BlastingRecipe(
                new NamespacedKey(plugin, "reduction"),
                itemManager.create("phenylacetone"),
                RecipeChoice.exactChoice(itemManager.create("phenylacetic_acid")),
                2.0f,
                600
        );

        plugin.getServer().addRecipe(acetone);

        // --- Sulfate ---
        ShapelessRecipe sulfate = new ShapelessRecipe(new NamespacedKey(plugin, "sulfatee"), itemManager.create("sulfate").add(1));

        sulfate.addIngredient(Material.SULFUR);
        sulfate.addIngredient(Material.SULFUR);

        plugin.getServer().addRecipe(sulfate);

        /*// --- Alluminum ---
        BlastingRecipe alluminum = new BlastingRecipe(
                new NamespacedKey(plugin, "conversion"),
                itemManager.create("alluminum"),
                RecipeChoice.exactChoice(itemManager.create("sulfur")),
                2.5f,
                650
        );
        plugin.getServer().addRecipe(alluminum);*/


    }



}