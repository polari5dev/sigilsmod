package xyz.polari5dev.SigilsMod;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.polari5dev.SigilsMod.managers.PluginManager;
import xyz.polari5dev.SigilsMod.sigils.Sigils;
import xyz.polari5dev.SigilsMod.commands.SigilCommand;
import xyz.polari5dev.SigilsMod.listeners.PlayerListener;

public class SigilsMod extends JavaPlugin {

    @Override
    public void onEnable() {

        // Initialize managers
        PluginManager.getInstance().initialize();

        // Register listeners
        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);

        getLogger().info(getDescription().getName() + " has been enabled! Hello, User!");

        this.registerCommand("sigil", new SigilCommand());
        registerRecipes();
    }

    private void registerRecipes() {
        NamespacedKey key = new NamespacedKey(this, "strength_sigil");

        ShapedRecipe recipe = new ShapedRecipe(key, Sigils.create("strength"));

        recipe.shape(
                "SbS",
                "N D",
                "SES");

        recipe.setIngredient('D', Material.DIAMOND_BLOCK);
        recipe.setIngredient('E', Material.ENDER_EYE);
        recipe.setIngredient('N', Material.NETHERITE_INGOT);
        recipe.setIngredient('S', Material.NETHER_STAR);
        recipe.setIngredient('b', Material.BLAZE_POWDER);
        getServer().addRecipe(recipe);
    }

    @Override
    public void onDisable() {
        getLogger().info(getDescription().getName() + " has been disabled! Goodbye!");
    }

}
