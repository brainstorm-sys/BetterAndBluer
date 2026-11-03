package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class UnpureMeth {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public UnpureMeth(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("unpuremeth", Material.PAPER, "goodfellows:ingredients/unpuremeth", mm.deserialize("<color:#FCD05C>Unpure Meth</color>"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 32));
    }
}
