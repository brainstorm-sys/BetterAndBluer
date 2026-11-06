package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class Methylamine {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public Methylamine(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("methylamine", Material.GLASS_BOTTLE, "blockingbad:ingredients/methylamine", mm.deserialize("<color:#ACACAC><shadow:#313C2E:1>Methylamine</shadow></color>"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1));
    }
}
