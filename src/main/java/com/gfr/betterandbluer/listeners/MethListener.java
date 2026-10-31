package com.gfr.betterandbluer.listeners;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class MethListener implements Listener {
    private final JavaPlugin plugin;
    private final ItemManager itemManager;

    public MethListener(JavaPlugin plugin, ItemManager itemManager) {
        this.plugin = plugin;
        this.itemManager = itemManager;
        Bukkit.getPluginManager().registerEvents(this, plugin);
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

}
