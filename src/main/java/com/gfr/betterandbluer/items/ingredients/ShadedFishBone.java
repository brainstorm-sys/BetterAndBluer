package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;

public class ShadedFishBone {

    private final ItemManager itemManager;

    public ShadedFishBone(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("shadedbone", Material.PAPER, "goodfellows:ingredients/shadedbone", Component.text("Shaded Fish Bone"));
    }

}
