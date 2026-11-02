package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class NMethamphetamine {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public NMethamphetamine(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("n_methamphetamine", Material.PAPER, "goodfellows:ingredients/n_methamphetamine", mm.deserialize("<b><gradient:#61C6EE:#A3DEFF:#61C6EE>Methamphetamine</gradient></b>"));
    }
}
