package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class OrganicMix {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public OrganicMix(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("orgmix", Material.PAPER, "blockingbad:ingredients/orgmix", mm.deserialize("<color:#AEAEAE>Organic Mix</color>"));
    }
}
