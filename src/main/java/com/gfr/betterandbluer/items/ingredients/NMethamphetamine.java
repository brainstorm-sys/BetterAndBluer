package com.gfr.betterandbluer.items.ingredients;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class NMethamphetamine {
    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public NMethamphetamine(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {
        itemManager.register("n_methamphetamine", Material.DRIED_KELP, "goodfellows:ingredients/n_methamphetamine", mm.deserialize("<b><gradient:#61C6EE:#A3DEFF:#61C6EE>Methamphetamine</gradient></b>"),
                ItemManager.DataComponent.of(DataComponentTypes.CONSUMABLE, Consumable.consumable()
                                .animation(ItemUseAnimation.BOW)
                                .hasConsumeParticles(false)
                                .consumeSeconds(1f)
                                .sound(Key.key("goodfellows", "crystal_sniff"))
                        .build())
                );
    }
}
