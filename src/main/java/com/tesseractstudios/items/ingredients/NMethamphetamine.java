package com.tesseractstudios.items.ingredients;

import com.tesseractstudios.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class NMethamphetamine {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();
    private final Key EMPTY = Key.key("minecraft", "intentionally_empty");

    public NMethamphetamine(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("n_methamphetamine", Material.DRIED_KELP, "goodfellows:ingredients/n_methamphetamine", mm.deserialize("<b><gradient:#61C6EE:#A3DEFF:#61C6EE>Methamphetamine</gradient></b>"),
                ItemManager.DataComponent.of(DataComponentTypes.CONSUMABLE, Consumable.consumable()
                                .animation(ItemUseAnimation.BOW)
                                .hasConsumeParticles(false)
                                .consumeSeconds(1f)
                                .sound(EMPTY)
                        .build())
                );
    }
}
