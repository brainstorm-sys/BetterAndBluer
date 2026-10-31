package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class HoneyCocoaPaste {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();
    public HoneyCocoaPaste(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("honeycocoapaste", Material.PAPER, "goodfellows:ingredients/honeycocoapaste", mm.deserialize("Honey-Cocoa Paste"));
    }

}
