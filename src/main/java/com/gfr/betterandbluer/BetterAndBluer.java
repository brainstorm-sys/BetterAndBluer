    package com.gfr.betterandbluer;

    import com.gfr.betterandbluer.items.beverage.Beer;
    import com.gfr.betterandbluer.items.beverage.Vodka;
    import com.gfr.betterandbluer.items.beverage.Whisky;
    import com.gfr.betterandbluer.items.drugs.Meth;
    import com.gfr.betterandbluer.items.ingredients.*;
    import com.gfr.betterandbluer.listeners.MethListener;
    import com.gfr.betterandbluer.managers.ItemManager;
    import com.gfr.betterandbluer.recipes.*;
    import dev.jorel.commandapi.CommandAPI;
    import dev.jorel.commandapi.CommandAPIPaperConfig;
    import org.bukkit.inventory.ItemStack;
    import org.bukkit.plugin.java.JavaPlugin;

    public final class BetterAndBluer extends JavaPlugin {


        public static BetterAndBluer instance;


        @Override
        public void onLoad() {
            CommandAPI.onLoad(
                    new CommandAPIPaperConfig(this)
                            .silentLogs(true)
                            .fallbackToLatestNMS(false)
                            .missingExecutorImplementationMessage("An error occured")
            );
        }

        @Override

        public void onEnable() {

            instance = this;
            // Plugin startup logic
            CommandAPI.onEnable();

            // ------ MANAGERS ------
            ItemManager itemManager = new ItemManager(this);

            // ------ ITEMS --------

            // -- DRUGS --
            new Meth(itemManager).register();


            // -- INGREDIENTS --
            new Alluminum(itemManager).register();
            new AlluminumAmalgam(itemManager).register();
            new FishBone(itemManager).register();
            new Mercury(itemManager).register();
            new Methylamine(itemManager).register();
            new PhenylaceticAcid(itemManager).register();
            new NMethamphetamine(itemManager).register();
            new Phenylacetone(itemManager).register();
            new Sulfate(itemManager).register();
            new HoneyCocoaPaste(itemManager).register();
            new OrganicMercuryMaterial(itemManager).register();
            new ShadedFishBone(itemManager).register();
            new PhenylAceticAcidSolution(itemManager).register();
            new UnpureMeth(itemManager).register();
            new LiquidMeth(itemManager).register();
            new OrganicMix(itemManager).register();

            // -- RECIPE --
            new MethRecipes(this, itemManager).register();
            new MethListener(this, itemManager);


            // ------ COMMANDS ------


        }



        @Override
        public void onDisable() {
            // Plugin shutdown logic
            CommandAPI.onDisable();
            instance = null;
        }
    }
