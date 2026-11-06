package com.tesseractstudios.recipes;

import com.tesseractstudios.managers.ItemManager;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionType;

import java.util.List;

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

        // --- Custom item meta ---

        ItemStack amitem = itemManager.create("alluminum_amalgam");
        ItemMeta amitemmeta = amitem.getItemMeta();

        amitemmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#FF55FF>- ʀᴇᴘʀᴇѕᴇɴᴛᴀᴛɪᴏɴ: ᴀʟ(ʜɢ) ᴏʀ ᴀʟ–ʜɢ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#FF55FF>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ɴᴏɴᴇ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#FF55FF>- ᴍᴏʟᴇᴄᴜʟᴀʀ ᴡᴇɪɢʜᴛ: ᴜɴᴅᴇꜰɪɴᴇᴅ</color></!i>")
        ));

        amitem.setItemMeta(amitemmeta);


        // phenylacetone
        ItemStack phenylitem = itemManager.create("phenylacetone");
        ItemMeta phenylmeta = phenylitem.getItemMeta();

        phenylmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ɪᴜᴘᴀᴄ ɴᴀᴍᴇ: 1-ᴘʜᴇɴʏʟᴘʀᴏᴘᴀɴ-2-ᴏɴᴇ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ9ʜ10ᴏ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 134.18 ɢ·ᴍᴏʟ⁻¹</color></!i>")

        ));

        phenylitem.setItemMeta(phenylmeta);


        // phenylacetic acid solution
        ItemStack p2p = itemManager.create("phenylacetic_acidsolution");
        ItemMeta p2pmeta = p2p.getItemMeta();

        p2pmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ɪᴜᴘᴀᴄ ɴᴀᴍᴇ: 2-ᴘʜᴇɴʏʟᴀᴄᴇᴛɪᴄ ᴀᴄɪᴅ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ8ʜ8ᴏ2</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 136.15 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        p2p.setItemMeta(p2pmeta);


        // unpuremeth solution
        ItemStack umeth = itemManager.create("unpuremeth");
        ItemMeta umethmeta = umeth.getItemMeta();

        umethmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴄᴏᴍᴍᴏɴ ɴᴀᴍᴇ: ᴍᴇᴛʜᴀᴍᴘʜᴇᴛᴀᴍɪɴᴇ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ10ʜ15ɴ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 149.23 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        umeth.setItemMeta(umethmeta);


        // liquid meth
        ItemStack methsol = itemManager.create("liquidmeth");
        ItemMeta methsolmeta = methsol.getItemMeta();

        methsolmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴄᴏᴍᴍᴏɴ ɴᴀᴍᴇ: ᴍᴇᴛʜᴀᴍᴘʜᴇᴛᴀᴍɪɴᴇ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ10ʜ15ɴ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 149.23 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        methsol.setItemMeta(methsolmeta);


        // mercury
        ItemStack mercur = itemManager.create("mercury");
        ItemMeta mercuryM = mercur.getItemMeta();

        mercuryM.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ѕʏᴍʙᴏʟ: ʜɢ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴀᴛᴏᴍɪᴄ ɴᴜᴍʙᴇʀ: 80</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴀᴛᴏᴍɪᴄ ᴡᴇɪɢʜᴛ: 200.59 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        mercur.setItemMeta(mercuryM);


        // sulfate
        ItemStack sulfat = itemManager.create("sulfate");
        ItemMeta sulfateM = sulfat.getItemMeta();

        sulfateM.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ѕᴏ₄²⁻</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 96.06 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        sulfat.setItemMeta(sulfateM);


        // aluminum
        ItemStack al = itemManager.create("alluminum");
        ItemMeta almeta = al.getItemMeta();

        almeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ѕʏᴍʙᴏʟ: ᴀʟ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴀᴛᴏᴍɪᴄ ɴᴜᴍʙᴇʀ: 13</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴀᴛᴏᴍɪᴄ ᴡᴇɪɢʜᴛ: 26.98 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        al.setItemMeta(almeta);


        // methylamine
        ItemStack methylaminem = itemManager.create("methylamine");
        ItemMeta methylaminemeta = methylaminem.getItemMeta();

        methylaminemeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#FF55FF>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄʜ₃ɴʜ₂</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#FF55FF>- ᴍᴏʟᴇᴄᴜʟᴀʀ ᴡᴇɪɢʜᴛ: 31.06 ɢ/ᴍᴏʟ</color></!i>")
        ));

        methylaminem.setItemMeta(methylaminemeta);


        // phenylacetic acid
        ItemStack phenylacid = itemManager.create("phenylacetic_acid");
        ItemMeta acidmeta = phenylacid.getItemMeta();

        acidmeta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ɪᴜᴘᴀᴄ ɴᴀᴍᴇ: 2-ᴘʜᴇɴʏʟᴀᴄᴇᴛɪᴄ ᴀᴄɪᴅ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ8ʜ8ᴏ2</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 136.15 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        phenylacid.setItemMeta(acidmeta);


        // ---  ---  ---  ---  ---


        // --- Alluminum amalgam ---
        ShapelessRecipe amalgam = new ShapelessRecipe(new NamespacedKey(plugin, "amalgamballs"), amitem);

        amalgam.addIngredient(al);
        amalgam.addIngredient(mercur);

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
                al,
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

        // --- Organic Mix ---
        ShapelessRecipe orgmix = new ShapelessRecipe(new NamespacedKey(plugin, "orgmix"), itemManager.create("orgmix"));

        orgmix.addIngredient(Material.DEAD_BRAIN_CORAL_BLOCK);
        orgmix.addIngredient(Material.BRAIN_CORAL_BLOCK);
        orgmix.addIngredient(Material.SEA_PICKLE);

        plugin.getServer().addRecipe(orgmix);

        // --- Mercury ---
        BlastingRecipe mercury = new BlastingRecipe(
                new NamespacedKey(plugin, "mercuryconv"),
                mercur,
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
        ShapelessRecipe p2psol = new ShapelessRecipe(new NamespacedKey(plugin, "phenylaceticacidsolutionrecipe"), p2p);

        p2psol.addIngredient(Material.POTION);
        p2psol.addIngredient(phenylacid);

        plugin.getServer().addRecipe(p2psol);


        // -- meth itself.. haha (unpure) --
        ShapelessRecipe methamphetamine = new ShapelessRecipe(new NamespacedKey(plugin, "metham"), umeth);

        methamphetamine.addIngredient(amitem);
        methamphetamine.addIngredient(methylaminem);
        methamphetamine.addIngredient(phenylitem);

        plugin.getServer().addRecipe(methamphetamine);

        // brew setup

        ItemStack water = new ItemStack(Material.POTION);
        PotionMeta watermeta = (PotionMeta) water.getItemMeta();
        watermeta.setBasePotionType(PotionType.WATER);
        water.setItemMeta(watermeta);


        // PhenylAcetone Recipe
        BrewingRecipe phneylacetone = new BrewingRecipe(
                new NamespacedKey(plugin, "brewstuff"),
                phenylitem,
                RecipeChoice.exactChoice(water),
                RecipeChoice.exactChoice(p2p)

        );

        plugin.getServer().addRecipe(phneylacetone);

        // unpur -> pure

        BrewingRecipe meth = new BrewingRecipe(
                new NamespacedKey(plugin, "methpurification"),
                methsol,
                RecipeChoice.exactChoice(water),
                RecipeChoice.exactChoice(umeth)
        );

        plugin.getServer().addRecipe(meth);

        // organic mix -> methylamine

        BrewingRecipe organic = new BrewingRecipe(
                new NamespacedKey(plugin, "methylamine"),
                methylaminem,
                RecipeChoice.exactChoice(water),
                RecipeChoice.exactChoice(itemManager.create("orgmix"))
        );

        plugin.getServer().addRecipe(organic);

    }



}

//