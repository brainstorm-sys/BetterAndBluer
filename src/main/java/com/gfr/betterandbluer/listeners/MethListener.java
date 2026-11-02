package com.gfr.betterandbluer.listeners;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.checkerframework.checker.units.qual.Current;

import javax.naming.Name;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class MethListener implements Listener {
    private final JavaPlugin plugin;
    private final ItemManager itemManager;
    private final NamespacedKey itemKey;
    private final Map<UUID, ItemStack[]> preCrafCache = new HashMap<>();

    public MethListener(JavaPlugin plugin, ItemManager itemManager) {
        this.plugin = plugin;
        this.itemManager = itemManager;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.itemKey = new NamespacedKey(plugin, "test");
    }

    // -- Custom Crafting Logic --

    @EventHandler
    public void onGrindStoneClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        ItemStack test = itemManager.create("test");
        itemManager.getItemId(test);
        itemManager.getCustomItem(itemManager.getItemId(test));


        if (e.getClickedBlock() != null) {

            if (e.getClickedBlock().getType() == Material.GRINDSTONE) {
                if (itemManager.getItemId(e.getItem()).equals("honeycocoapaste")) {
                    e.setCancelled(true);


                    var loc = e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);

                    player.getWorld().playSound(
                            Sound.sound(Key.key("minecraft:block.grindstone.use"), Sound.Source.BLOCK, 1f, 1f),
                            loc.getX(), loc.getY(), loc.getZ()
                    );
                    item.setAmount(item.getAmount() - 1);
                    if (item.getAmount() <= 0) {
                        player.getInventory().setItemInMainHand(itemManager.create("phenylacetic_acid"));
                    }

                    else {
                        player.give(itemManager.create("phenylacetic_acid"));
                    }
                }
            }
        }
    }

    // --- fish logic ---

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){

        System.out.println("If this works then lammy's gay");
        Player player = e.getPlayer();
        ItemStack eatitem = player.getInventory().getItemInMainHand();

        // - idk dawg test -, ok works ez
        if(eatitem.getType() == Material.TROPICAL_FISH){
            e.setCancelled(true);
            eatitem.setAmount(eatitem.getAmount() -1);
            if (eatitem.getAmount() <= 0) {
                player.getInventory().setItemInMainHand(itemManager.create("fish_bone"));
            }

            else {
                player.give(itemManager.create("fish_bone"));
            }
        }


    }

    // -- custom crafting logic (where it replaces existing items in crafting grid)

    // my god i gotta figure out logic so it can replace items with empty bucket to make it realistic... :skull:
    // sry if it looks weird and janky, pls do lmk if there can be better logic
    // gonna be my first logic made all by myself without any ai / google help. I'm proud of it.


    /*@EventHandler
    public void onCraft(CraftItemEvent e) {
        Bukkit.getLogger().info("cat 6 - CraftItemEvent fired");

        Player p = (Player) e.getWhoClicked();

        ItemStack[] currentMatrix = e.getInventory().getMatrix();

        for (int i = 0; i < currentMatrix.length; i++) {
            if (currentMatrix[i] != null) {
                currentMatrix[i] = currentMatrix[i].clone();
            }
        }

        Bukkit.getLogger().info("cat 8 - Captured matrix:");

        for (int i = 0; i < currentMatrix.length; i++) {
            ItemStack item = currentMatrix[i];

            Bukkit.getLogger().info(
                    "Slot " + i + ": " +
                            (item == null ? "NULL" :
                                    item.getType() + " x" + item.getAmount() +
                                            " | ID: " + itemManager.getItemId(item))
            );
        }

        Bukkit.getLogger().info("cat 9 - Scheduling task");

        Bukkit.getScheduler().runTask(plugin, () -> {
            Bukkit.getLogger().info("cat 10 - Scheduled task running");

            Bukkit.getLogger().info("cat 11 - Top inventory: "
                    + p.getOpenInventory().getTopInventory().getType());

            if (!(p.getOpenInventory().getTopInventory() instanceof CraftingInventory)) {
                Bukkit.getLogger().info("cat 12 - NOT A CRAFTING INVENTORY");
                return;
            }

            CraftingInventory currentInv =
                    (CraftingInventory) p.getOpenInventory().getTopInventory();

            Bukkit.getLogger().info("cat 13 - Processing saved matrix");

            for (int i = 0; i < currentMatrix.length; i++) {
                ItemStack originalItem = currentMatrix[i];

                Bukkit.getLogger().info("cat 14 - Checking matrix index " + i);

                if (originalItem == null || originalItem.getType() == Material.AIR) {
                    Bukkit.getLogger().info("cat 15 - Empty slot " + i);
                    continue;
                }

                String itemId = itemManager.getItemId(originalItem);

                Bukkit.getLogger().info("cat 16 - Item ID: " + itemId);

                if ("mercury".equals(itemId)) {
                    Bukkit.getLogger().info("cat 17 - MERCURY FOUND AT INDEX " + i);

                    ItemStack bucket = new ItemStack(Material.BUCKET);

                    ItemMeta meta = bucket.getItemMeta();

                    if (meta != null) {
                        meta.getPersistentDataContainer().set(
                                itemKey,
                                PersistentDataType.STRING,
                                "mercury_bucket"
                        );

                        bucket.setItemMeta(meta);
                    }

                    int slot = i + 1;

                    Bukkit.getLogger().info("cat 18 - Replacing inventory slot " + slot);

                    currentInv.setItem(slot, bucket);
                }
            }

            Bukkit.getLogger().info("cat 19 - Updating inventory");

            p.updateInventory();

            Bukkit.getLogger().info("cat 20 - Finished");
        });
    }*/
    @EventHandler
    public void OnCraft(CraftItemEvent e){
        Player p = (Player) e.getWhoClicked();

        ItemStack[] matrix = e.getInventory().getMatrix();

        if(!(p.getOpenInventory().getTopInventory() instanceof CraftingInventory)) return;

        // the holy grail that took almost 2 days to figure out
        for(int i=0; i < matrix.length; i++){
            if(matrix[i] != null){
                matrix[i] = matrix[i].clone();
            }
        }

        Bukkit.getScheduler().runTask(plugin, ()-> {
            if(!(p.getOpenInventory().getTopInventory() instanceof CraftingInventory)) return;

            CraftingInventory Inv = (CraftingInventory) p.getOpenInventory().getTopInventory();

            for(int i = 0; i < matrix.length; i++){
                ItemStack item = matrix[i];

                if(item == null || item.getType() == Material.AIR) continue;

                if(itemManager.getItemId(item).equals("mercury")){
                    ItemStack bucket = new ItemStack(Material.BUCKET);
                    ItemMeta meta = bucket.getItemMeta();

                    if(meta != null){
                        meta.getPersistentDataContainer().set(
                                itemKey,
                                PersistentDataType.STRING,
                                "buckethahanoob"
                        );

                        bucket.setItemMeta(meta);

                    }

                    int slot = i + 1;
                    Inv.setItem(slot, bucket);
                }
            }

            p.updateInventory();

        });

    }

// jesus it works, tears in my fricking eyes
}
