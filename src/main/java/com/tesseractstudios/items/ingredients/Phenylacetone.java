package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class Phenylacetone {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public Phenylacetone(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("phenylacetone", Material.GLASS_BOTTLE, "goodfellows:ingredients/phenylacetone", mm.deserialize("<color:#FCD05C><shadow:#473D24:1>Phenylacetone</shadow></color>"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1)
                );
    }
}
