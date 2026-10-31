package com.gfr.betterandbluer.items.beverage;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.Consumable;
import io.papermc.paper.datacomponent.item.FoodProperties;
import io.papermc.paper.datacomponent.item.consumable.ItemUseAnimation;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Material;

public class Vodka {

    private final ItemManager itemManager;
    private final MiniMessage mm = MiniMessage.miniMessage();

    public Vodka(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    public void register() {


        itemManager.register("vodka", Material.PAPER, "goodfellows:beverage/vodka",
                mm.deserialize("Vodka"),
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
                                .animation(ItemUseAnimation.DRINK)
                                .hasConsumeParticles(false)
                                .build()
                ));
    }

}
