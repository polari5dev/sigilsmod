package xyz.polari5dev.SigilsMod.commands;

import org.bukkit.Bukkit;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class SigilCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack source, String[] args) {

        if (args.length == 0) {
            source.getSender().sendRichMessage(
                    "<red>Usage: /sigil give <player> <sigil>");
            return;
        }

        if (args[0].equalsIgnoreCase("give")) {
            source.getSender().sendRichMessage(
                    "<green>You used /sigil give!");
        }

        if (args[1].equalsIgnoreCase("a")) {
            // do this next
        }

        if (args[2].equalsIgnoreCase("blank")) {
            Bukkit.dispatchCommand(
                    Bukkit.getConsoleSender(),
                    "give playerName diamond 1");
            source.getSender().sendRichMessage(
                    "<purple>Gave a Nether Star, because sigils don't exist!");
        }
    }
}