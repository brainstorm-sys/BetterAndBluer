package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class OrganicMercuryMaterial {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public OrganicMercuryMaterial(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("organicmercurymaterial", Material.PAPER, "blockingbad:ingredients/organicmercurymaterial", mm.deserialize("Organic Mercury Material"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1));
    }
}
