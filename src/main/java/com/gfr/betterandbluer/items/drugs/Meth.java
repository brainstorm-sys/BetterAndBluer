package com.gfr.betterandbluer.items.drugs;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.FoodProperties;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

import java.util.List;

public class Meth {

    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    private static final Key EMPTY_SOUND = Key.key("minecraft", "entity.sniffer.sniffing");

    public Meth(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {


        itemManager.register("meth", Material.PAPER, "goodfellows:drugs/meth",
                mm.deserialize("<aqua>Meth</aqua>"),
                meta -> meta.lore(List.of(
                        Component.empty(),
                        Component.text("Its meth bro", NamedTextColor.GRAY),
                        Component.text("97.9% purity", NamedTextColor.GRAY)
                )),
                ItemManager.DataComponent.of(
                        DataComponentTypes.FOOD,
                        FoodProperties.food()
                                .canAlwaysEat(true)
                                .nutrition(0)
                                .saturation(0)
                                .build()
                ),
                ItemManager.DataComponent.of(
                        DataComponentTypes.CONSUMABLE,
                        Consumable.consumable()
                                .consumeSeconds(1.0f)
                                .animation(ItemUseAnimation.BRUSH)
                                .sound(EMPTY_SOUND)
                                .hasConsumeParticles(false)
                                .build()
                ));
    }
}