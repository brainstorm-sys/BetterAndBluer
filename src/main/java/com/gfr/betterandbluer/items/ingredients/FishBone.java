package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class FishBone {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public FishBone(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("fish_bone", Material.PAPER, "goodfellows:ingredients/fish_bone", mm.deserialize("Fish Bone"));
    }
}