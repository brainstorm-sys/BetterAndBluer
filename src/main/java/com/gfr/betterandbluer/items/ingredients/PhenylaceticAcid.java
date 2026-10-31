package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class PhenylaceticAcid {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public PhenylaceticAcid(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("phenylacetic_acid", Material.PAPER, "goodfellows:ingredients/phenylacetic_acid", mm.deserialize("Phenylacetic Acid"));
    }
}
