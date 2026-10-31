package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class Barley {

    private final ItemManager itemManager;

    public Barley(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("barley", Material.PAPER, "goodfellows:ingredients/barley", Component.text("Barley"));
    }

}
