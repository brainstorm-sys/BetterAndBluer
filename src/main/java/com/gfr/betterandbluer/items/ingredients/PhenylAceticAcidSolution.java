package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class PhenylAceticAcidSolution {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public PhenylAceticAcidSolution(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("phenylacetic_acidsolution", Material.PAPER, "goodfellows:ingredients/phenylacetic_acidsolution", mm.deserialize("P2P Solution"));
    }
}
