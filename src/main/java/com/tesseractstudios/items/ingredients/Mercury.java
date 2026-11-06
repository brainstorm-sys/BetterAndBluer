package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class Mercury {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public Mercury(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("mercury", Material.PAPER, "goodfellows:ingredients/mercury", mm.deserialize("Mercury"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1));
    }
}
