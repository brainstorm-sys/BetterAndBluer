package com.gfr.betterandbluer.listeners;

import com.gfr.betterandbluer.managers.ItemManager;
import io.papermc.paper.datacomponent.DataComponentTypes;
import io.papermc.paper.datacomponent.item.FoodProperties;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.sound.Sound;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.block.BrewingStand;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BrewingStartEvent;
import org.bukkit.event.inventory.BrewEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitScheduler;
import org.checkerframework.checker.units.qual.Current;

import javax.naming.Name;
import java.util.*;


public class MethListener implements Listener {
    private final JavaPlugin plugin;
    private final ItemManager itemManager;
    private final NamespacedKey itemKey;
    private final Map<UUID, ItemStack[]> preCrafCache = new HashMap<>();

    public MethListener(JavaPlugin plugin, ItemManager itemManager) {
        this.plugin = plugin;
        this.itemManager = itemManager;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        this.itemKey = new NamespacedKey(plugin, "test");
    }

    private final Map<UUID, UUID> uuidStore = new HashMap<>();

    // -- Custom Crafting Logic --


    @EventHandler
    public void onGrindStoneClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();


        // phenylacetic acid
        ItemStack pa = itemManager.create("phenylacetic_acid");
        ItemMeta pameta = pa.getItemMeta();


        pameta.lore(List.of(
                Component.text(""),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ɪᴜᴘᴀᴄ ɴᴀᴍᴇ: 2-ᴘʜᴇɴʏʟᴀᴄᴇᴛɪᴄ ᴀᴄɪᴅ</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴇᴄᴜʟᴀʀ ꜰᴏʀᴍᴜʟᴀ: ᴄ8ʜ8ᴏ2</color></!i>"),
                MiniMessage.miniMessage().deserialize("<!i><color:#F35BF3>- ᴍᴏʟᴀʀ ᴍᴀѕѕ: 136.15 ɢ·ᴍᴏʟ⁻¹</color></!i>")
        ));

        pa.setItemMeta(pameta);

        // ---  ---  ---  ---


        if (e.getClickedBlock() != null) {

            if (e.getClickedBlock().getType() == Material.GRINDSTONE) {
                if (itemManager.getItemId(e.getItem()).equals("honeycocoapaste")) {
                    e.setCancelled(true);


                    var loc = e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);

                    player.getWorld().playSound(
                            Sound.sound(Key.key("minecraft:block.grindstone.use"), Sound.Source.BLOCK, 1f, 1f),
                            loc.getX(), loc.getY(), loc.getZ()
                    );
                    item.setAmount(item.getAmount() - 1);
                    if (item.getAmount() <= 0) {
                        player.getInventory().setItemInMainHand(pa);
                    }

                    else {
                        player.give(pa);
                    }
                }
            }
        }
    }

    // --- fish logic ---

    @EventHandler
    public void onEat(PlayerItemConsumeEvent e){

        System.out.println("If this works then lammy's gay");
        Player player = e.getPlayer();
        ItemStack eatitem = player.getInventory().getItemInMainHand();

        // - idk dawg test -, ok works ez
        if(eatitem.getType() == Material.TROPICAL_FISH){
            e.setCancelled(true);
            eatitem.setAmount(eatitem.getAmount() -1);
            if (eatitem.getAmount() <= 0) {
                player.getInventory().setItemInMainHand(itemManager.create("fish_bone"));
            }

            else {
                player.give(itemManager.create("fish_bone"));
            }
        }


    }

    // -- glass -> pure meth logic

    @EventHandler
    public void onAnvil(PlayerInteractEvent e){
        Player p = e.getPlayer();

        if (e.getClickedBlock() == null || e.getClickedBlock().getType() == Material.AIR) return;

        ItemStack mainhand = p.getInventory().getItemInMainHand();
        if (itemManager.getItemId(mainhand).equals("liquidmeth")){
            if (e.getClickedBlock().getType() == Material.ANVIL){
                e.setCancelled(true);

                //audio
                var loc = e.getClickedBlock().getLocation().add(0.5, 0.5, 0.5);

                p.getWorld().playSound(
                        Sound.sound(Key.key("minecraft:block.glass.break"), Sound.Source.BLOCK, 1f, 1f),
                        loc.getX(), loc.getY(), loc.getZ()
                );


                // Customisation

                ItemStack meth1 = itemManager.create("n_methamphetamine");
                ItemMeta meta = meth1.getItemMeta();


                meta.lore(List.of(
                        Component.text(""),
                        MiniMessage.miniMessage().deserialize("<gradient:#6179DD:#7754F4><!italic>ɪ ᴡ</!italic></gradient><gradient:#7754F4:#1FA4D7><!italic>ᴀѕ ɢᴏᴏᴅ </!italic></gradient><gradient:#1FA4D7:#5BE3EB><!italic>ᴀᴛ ɪᴛ.</!italic></gradient>"),
                        Component.text(""),
                        MiniMessage.miniMessage().deserialize("<!i><gradient:#6179DD:#7754F4><shadow:#181E37:1>-</shadow><shadow:#191D38:1>-</shadow><shadow:#1A1C39:1>-</shadow><shadow:#1A1B39:1>-</shadow></gradient><gradient:#7754F4:#1FA4D7><shadow:#1B1A3A:1>-</shadow><shadow:#1C183B:1>-</shadow><shadow:#1D173C:1>-</shadow><shadow:#1D163C:1>-</shadow><shadow:#1E153D:1>-</shadow><shadow:#1B183C:1>-</shadow><shadow:#181B3B:1>-</shadow><shadow:#151E3A:1>-</shadow><shadow:#112039:1>-</shadow><shadow:#0E2338:1>-</shadow><shadow:#0B2637:1>-</shadow></gradient><gradient:#1FA4D7:#5BE3EB><shadow:#082936:1>-</shadow><shadow:#0A2B37:1>-</shadow><shadow:#0C2E37:1>-</shadow><shadow:#0E3038:1>-</shadow><shadow:#113239:1>-</shadow><shadow:#13343A:1>-</shadow><shadow:#15373A:1>-</shadow><shadow:#17393B:1>-</shadow></gradient></!i>"),
                        MiniMessage.miniMessage().deserialize("<!i><color:#6179DD>* 70% ᴄʜᴀɴᴄᴇ ᴏꜰ ɴᴀᴜѕᴇᴀ</color></!i>"),
                        MiniMessage.miniMessage().deserialize("<!i><color:#6179DD>* 50% ᴄʜᴀɴᴄᴇ ᴏꜰ ᴅᴀʀᴋɴᴇѕѕ</color></!i>"),
                        MiniMessage.miniMessage().deserialize("<!i><color:#6179DD>* 20% ᴄʜᴀɴᴄᴇ ᴏꜰ ʙᴏᴛʜ</color></!i>"),
                        MiniMessage.miniMessage().deserialize("<!i><color:#6179DD>* 75% ᴄʜᴀɴᴄᴇ ᴏꜰ ᴘᴏɪѕᴏɴ</color></!i>"),
                        MiniMessage.miniMessage().deserialize("<!i><color:#6179DD>* ѕᴛʀᴇɴɢᴛʜ 2 + ѕᴘᴇᴇᴅ 1</color></!i>"),
                        Component.text(""),
                        MiniMessage.miniMessage().deserialize("<!i><color:#61BADD>ᴛᴀᴋᴇ ᴇɴᴏᴜɢʜ ᴛᴏ ʙᴇᴄᴏᴍᴇ ᴘᴀʀᴀɴᴏɪᴅ.</color></!i>")

                ));

                meth1.setData(DataComponentTypes.FOOD,
                        FoodProperties.food()
                                .canAlwaysEat(true)
                                .nutrition(0)
                                .saturation(0)
                                .build()
                        );

                meth1.setItemMeta(meta);


                //


                mainhand.setAmount(mainhand.getAmount() - 1);
                if(mainhand.getAmount() <= 0){
                    p.getInventory().setItemInMainHand(meth1);
                }
                else {
                    p.give(meth1);
                }

            }
        }

    }

    // -- custom crafting logic (where it replaces existing items in crafting grid)

    // my god i gotta figure out logic so it can replace items with empty bucket to make it realistic... :skull:
    // sry if it looks weird and janky, pls do lmk if there can be better logic
    // gonna be my first logic made all by myself without any ai / google help. I'm proud of it.

    @EventHandler
    public void OnCraft(CraftItemEvent e){
        Player p = (Player) e.getWhoClicked();

        ItemStack[] matrix = e.getInventory().getMatrix();

        if(!(p.getOpenInventory().getTopInventory() instanceof CraftingInventory)) return;

        // the holy grail that took almost 2 days to figure out
        for(int i=0; i < matrix.length; i++){
            if(matrix[i] != null){
                matrix[i] = matrix[i].clone();
            }
        }

        Bukkit.getScheduler().runTask(plugin, ()-> {
            if(!(p.getOpenInventory().getTopInventory() instanceof CraftingInventory)) return;

            CraftingInventory Inv = (CraftingInventory) p.getOpenInventory().getTopInventory();

            for(int i = 0; i < matrix.length; i++){
                ItemStack item = matrix[i];

                if(item == null || item.getType() == Material.AIR) continue;

                if(itemManager.getItemId(item).equals("mercury")){
                    ItemStack bucket = new ItemStack(Material.BUCKET);
                    ItemMeta meta = bucket.getItemMeta();

                    if(meta != null){
                        meta.getPersistentDataContainer().set(
                                itemKey,
                                PersistentDataType.STRING,
                                "buckethahanoob"
                        );

                        bucket.setItemMeta(meta);

                    }

                    int slot = i + 1;
                    Inv.setItem(slot, bucket);
                }

                else if (itemManager.getItemId(item).equals("phenylacetone") || itemManager.getItemId(item).equals("methylamine")){
                    ItemStack glass = new ItemStack(Material.GLASS_BOTTLE);
                    ItemMeta glassmeta = glass.getItemMeta();

                    if(glassmeta != null){
                        glassmeta.getPersistentDataContainer().set(
                                itemKey,
                                PersistentDataType.STRING,
                                "ezglassp"
                        );
                    }

                    glass.setItemMeta(glassmeta);

                    int slot = i + 1;
                    Inv.setItem(slot, glass);

                }
            }

            p.updateInventory();

        });

    }


    // IMP SHIT EXPERIMENTAL. (final part except dimension idea)

    @EventHandler
    public void onEatMeth(PlayerItemConsumeEvent e){
        Player p = e.getPlayer();
        ItemStack methItem = p.getInventory().getItemInMainHand();


        // adding potion randomness

        Random methRandom = new Random();

        double roll = methRandom.nextDouble();

        if (methItem == null || methItem.getType() == Material.AIR) return;
        if (methItem == itemManager.create("n_methamphetamine")){

            PotionEffect tuffNausea = new PotionEffect(PotionEffectType.NAUSEA, 400, 1);
            PotionEffect tuffBlindness = new PotionEffect(PotionEffectType.BLINDNESS, 400, 2);
            PotionEffect tuffPoison = new PotionEffect(PotionEffectType.POISON, 200, 1);
            PotionEffect speedHack = new PotionEffect(PotionEffectType.SPEED, 100, 1);
            PotionEffect strengthHack = new PotionEffect(PotionEffectType.STRENGTH, 100, 2);

            p.addPotionEffect(speedHack);
            p.addPotionEffect(strengthHack);

            if (roll < 0.20){
                p.addPotionEffect(tuffNausea);
                p.addPotionEffect(tuffBlindness);
            } else {
                if (methRandom.nextDouble() < 0.70){
                    p.addPotionEffect(tuffNausea);
                }
                else if (methRandom.nextDouble() < 0.50){
                    p.addPotionEffect(tuffBlindness);
                }
            }

            if (methRandom.nextDouble() < 0.70){
                p.addPotionEffect(tuffPoison);
            }

            uuidStore.put(p.getUniqueId(), p.getUniqueId());

        }


    }




// jesus it works, tears in my fricking eyes


}
