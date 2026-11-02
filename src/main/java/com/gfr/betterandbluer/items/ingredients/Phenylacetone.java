package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
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
        itemManager.register("phenylacetone", Material.GLASS_BOTTLE, "goodfellows:ingredients/phenylacetone", mm.deserialize("Phenylacetone"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1)
                );
    }
}
