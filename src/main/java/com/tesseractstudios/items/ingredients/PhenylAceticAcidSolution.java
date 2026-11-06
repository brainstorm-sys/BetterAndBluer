package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class PhenylAceticAcidSolution {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public PhenylAceticAcidSolution(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("phenylacetic_acidsolution", Material.NETHER_WART, "blockingbad:ingredients/phenylacetic_acidsolution", mm.deserialize("P2P Solution"),
                ItemManager.DataComponent.of(DataComponentTypes.MAX_STACK_SIZE, 1));
    }
}
