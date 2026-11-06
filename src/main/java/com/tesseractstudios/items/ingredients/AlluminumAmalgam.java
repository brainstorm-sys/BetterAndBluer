package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class AlluminumAmalgam {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public AlluminumAmalgam(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("alluminum_amalgam", Material.PAPER, "blockingbad:ingredients/alluminum_amalgam", mm.deserialize("<color:#AEAEAE><shadow:#2B2626:1>Aluminum Amalgam</shadow></color>"));
    }
}
