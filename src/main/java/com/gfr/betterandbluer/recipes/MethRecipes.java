package com.gfr.betterandbluer.recipes;

import com.gfr.betterandbluer.managers.ItemManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlastFurnace;
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
        FurnaceRecipe acetone = new FurnaceRecipe(
                new NamespacedKey(plugin, "reduction"),
                itemManager.create("phenylacetone"),
                RecipeChoice.exactChoice(itemManager.create("phenylacetic_acidsolution")),
                2.0f,
                600
        );

        plugin.getServer().addRecipe(acetone);

        // --- Sulfate ---
        ShapelessRecipe sulfate = new ShapelessRecipe(new NamespacedKey(plugin, "sulfatee"), itemManager.create("sulfate").add(1));

        sulfate.addIngredient(Material.SULFUR);
        sulfate.addIngredient(Material.SULFUR);

        plugin.getServer().addRecipe(sulfate);

        // --- Alluminum ---
        BlastingRecipe alluminum = new BlastingRecipe(
                new NamespacedKey(plugin, "conversion"),
                itemManager.create("alluminum"),
                RecipeChoice.exactChoice(itemManager.create("sulfate")),
                2.5f,
                650
        );
        plugin.getServer().addRecipe(alluminum);

        // --- Organic Mercury Material ---
        ShapelessRecipe organicmercury = new ShapelessRecipe(new NamespacedKey(plugin, "organicmercury"), itemManager.create("organicmercurymaterial"));

        organicmercury.addIngredient(itemManager.create("shadedbone"));
        organicmercury.addIngredient(Material.BUCKET);

        plugin.getServer().addRecipe(organicmercury);

        // --- MethylAmine ---
        ShapelessRecipe methylamine = new ShapelessRecipe(new NamespacedKey(plugin, "methylamine"), itemManager.create("methylamine"));

        methylamine.addIngredient(Material.DEAD_BRAIN_CORAL_BLOCK);
        methylamine.addIngredient(Material.BRAIN_CORAL_BLOCK);
        methylamine.addIngredient(Material.SEA_PICKLE);
        methylamine.addIngredient(Material.LEGACY_GLASS_BOTTLE);

        plugin.getServer().addRecipe(methylamine);

        // --- Mercury ---
        BlastingRecipe mercury = new BlastingRecipe(
                new NamespacedKey(plugin, "mercuryconv"),
                itemManager.create("mercury"),
                RecipeChoice.exactChoice(itemManager.create("organicmercurymaterial")),
                3.0f,
                700

        );

        plugin.getServer().addRecipe(mercury);

        // --- Shaded Bone ---
        ShapelessRecipe shade = new ShapelessRecipe(new NamespacedKey(plugin, "shadedbone"), itemManager.create("shadedbone"));

        shade.addIngredient(itemManager.create("fish_bone"));
        shade.addIngredient(Material.INK_SAC);

        plugin.getServer().addRecipe(shade);


        // -- Phenyl Acetic Acid Solution --
        ShapelessRecipe p2psol = new ShapelessRecipe(new NamespacedKey(plugin, "phenylaceticacidsolution"), itemManager.create("phenylacetic_acidsolution"));

        p2psol.addIngredient(Material.POTION);
        p2psol.addIngredient(itemManager.create("phenylacetic_acid"));

        plugin.getServer().addRecipe(p2psol);

        // -- meth itself.. haha --
        ShapelessRecipe meth = new ShapelessRecipe(new NamespacedKey(plugin, "metham"), itemManager.create("n_methamphetamine"));

        meth.addIngredient(itemManager.create("alluminum_amalgam"));
        meth.addIngredient(itemManager.create("methylamine"));
        meth.addIngredient(itemManager.create("phenylacetone"));


        plugin.getServer().addRecipe(meth);

    }



}

//