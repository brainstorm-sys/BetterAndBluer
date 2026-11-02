package com.gfr.betterandbluer.recipes;

import com.gfr.betterandbluer.managers.ItemManager;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.BlastFurnace;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionType;

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
        methylamine.addIngredient(Material.POTION);

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

        // -- meth itself.. haha (unpure) --
        ShapelessRecipe methamphetamine = new ShapelessRecipe(new NamespacedKey(plugin, "metham"), itemManager.create("unpuremeth"));

        methamphetamine.addIngredient(itemManager.create("alluminum_amalgam"));
        methamphetamine.addIngredient(itemManager.create("methylamine"));
        methamphetamine.addIngredient(itemManager.create("phenylacetone"));

        plugin.getServer().addRecipe(methamphetamine);

        ItemStack water = new ItemStack(Material.POTION);
        PotionMeta watermeta = (PotionMeta) water.getItemMeta();
        watermeta.setBasePotionType(PotionType.WATER);
        water.setItemMeta(watermeta);


        // PhenylAcetone Recipe
        BrewingRecipe test = new BrewingRecipe(
                new NamespacedKey(plugin, "brewstuff"),
                itemManager.create("phenylacetone"),
                RecipeChoice.exactChoice(water),
                RecipeChoice.exactChoice(itemManager.create("phenylacetic_acidsolution"))

        );

        plugin.getServer().addRecipe(test);

        // unpur -> pure

        BrewingRecipe meth = new BrewingRecipe(
                new NamespacedKey(plugin, "methpurification"),
                itemManager.create("liquidmeth"),
                RecipeChoice.exactChoice(water),
                RecipeChoice.exactChoice(itemManager.create("unpuremeth"))
        );

        plugin.getServer().addRecipe(meth);

    }



}

//