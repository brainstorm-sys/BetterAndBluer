package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class Mercury {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public Mercury(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("mercury", Material.BUCKET, "goodfellows:ingredients/mercury", mm.deserialize("Mercury"));
    }
}
