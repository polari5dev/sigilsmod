package xyz.polari5dev.SigilsMod.commands;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

import xyz.polari5dev.SigilsMod.sigils.Sigils;

public class SigilCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        if (args.length >= 3 && args[0].equalsIgnoreCase("give")) {

            Player target = Bukkit.getPlayer(args[1]);

            if (target == null) {
                source.getSender().sendMessage("Player not found!");
                return;
            }

            ItemStack sigil = Sigils.create(args[2]);

            if (sigil == null) {
                source.getSender().sendMessage("Unknown sigil!");
                return;
            }

            target.getInventory().addItem(sigil);

            source.getSender().sendMessage(
                    "Gave " + target.getName() + " a " + args[2] + " sigil!");
        }
    }
}