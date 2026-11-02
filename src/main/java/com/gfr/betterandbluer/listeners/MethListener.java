package com.gfr.betterandbluer.listeners;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BrewingStartEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.*;
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

    // -- glass -> pure meth logic

    @EventHandler
    public void onAnvil(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;

        ItemStack mainhand = p.getInventory().getItemInMainHand();
        if (itemManager.getItemId(mainhand).equals("liquidmeth")){
            if (e.getClickedBlock().getType() == Material.ANVIL){
                e.setCancelled(true);

                //audio
                var loc = e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);

                p.getWorld().playSound(
                        Sound.sound(Key.key("minecraft:block.glass.break"), Sound.Source.BLOCK, 1f, 1f),
                        loc.getX(), loc.getY(), loc.getZ()
                );


                mainhand.setAmount(mainhand.getAmount() - 1);
                if(mainhand.getAmount() <= 0){
                    p.getInventory().setItemInMainHand(itemManager.create("n_methamphetamine"));
                }
                else {
                    p.give(itemManager.create("n_methamphetamine"));
                }

            }
        }

    }

    // -- custom crafting logic (where it replaces existing items in crafting grid)

    // my god i gotta figure out logic so it can replace items with empty bucket to make it realistic... :skull:
    // sry if it looks weird and janky, pls do lmk if there can be better logic
    // gonna be my first logic made all by myself without any ai / google help. I'm proud of it.

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

                else if (itemManager.getItemId(item).equals("phenylacetone") || itemManager.getItemId(item).equals("methylamine")){
                    ItemStack glass = new ItemStack(Material.GLASS_BOTTLE);
                    ItemMeta glassmeta = glass.getItemMeta();

                    if(glassmeta != null){
                        glassmeta.getPersistentDataContainer().set(
                                itemKey,
                                PersistentDataType.STRING,
                                "ezglassp"
                        );
                    }

                    glass.setItemMeta(glassmeta);

                    int slot = i + 1;
                    Inv.setItem(slot, glass);

                }
            }

            p.updateInventory();

        });

    }

// jesus it works, tears in my fricking eyes


}
