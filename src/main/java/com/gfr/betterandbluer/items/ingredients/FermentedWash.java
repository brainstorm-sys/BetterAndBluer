package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class FermentedWash {

    private final ItemManager itemManager;

    public FermentedWash(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("fermented_wash", Material.PAPER, "goodfellows:ingredients/fermented_wash", Component.text("Fermented Wash"));
    }

}
