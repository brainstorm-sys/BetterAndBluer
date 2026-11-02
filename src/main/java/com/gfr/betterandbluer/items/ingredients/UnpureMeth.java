package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class UnpureMeth {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public UnpureMeth(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("unpuremeth", Material.PAPER, "goodfellows:ingredients/unpuremeth", mm.deserialize("Unpure Meth"));
    }
}
