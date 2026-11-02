package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class LiquidMeth {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public LiquidMeth(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("liquidmeth", Material.PAPER, "goodfellows:ingredients/methliquid", mm.deserialize("Liquid Meth"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 32));
    }
}
