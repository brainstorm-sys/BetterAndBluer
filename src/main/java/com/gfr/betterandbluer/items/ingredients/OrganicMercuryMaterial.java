package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class OrganicMercuryMaterial {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public OrganicMercuryMaterial(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("organicmercurymaterial", Material.BUCKET, "goodfellows:ingredients/organicmercurymaterial", mm.deserialize("Organic Mercury Material"));
    }
}
