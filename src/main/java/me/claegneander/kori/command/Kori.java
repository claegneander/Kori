package me.claegneander.kori.command;

import me.claegneander.kori.command.ancillary.Ancillary;
import me.claegneander.kori.command.ancillary.alpha.Give;
import me.claegneander.kori.command.ancillary.alpha.NV;
import me.claegneander.kori.command.ancillary.alpha.Toggle;
import me.claegneander.kori.misc.enums.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Map;

/*
TODO: Add in the help alpha command.
TODO: Add in the socket alpha command.
TODO: Add in socket.add, socket.remove beta commands.
 */
public class Kori implements CommandExecutor {

    private final Map<String, Ancillary> commands;
    private final Map<String, String> permissions;
    private final Map<String, String> usages;
    private final Map<String, String> descriptions;

    public Kori(){
        commands = new HashMap<>();
        permissions = new HashMap<>();
        usages = new HashMap<>();
        descriptions = new HashMap<>();

        commands.put("give", new Give());
        commands.put("nv", new NV());
        commands.put("toggle", new Toggle());

        for(String s : commands.keySet()){
            permissions.put(s, commands.get(s).getPermission());
            usages.put(s, commands.get(s).getUsage());
            descriptions.put(s, commands.get(s).getDescription());
        }
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player player) {
            if (args.length >= 1) {
                try {
                    Ancillary a = commands.get(args[0].toLowerCase());
                    if (a != null) {
                        a.execute(sender, args);
                    } else {
                        player.sendMessage(Component.text("Invalid ancillary command.").color(TextColor.fromHexString(Color.ERROR.getHEX())));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
    public Map<String, Ancillary> getCommands() {
        return commands;
    }

    public Map<String, String> getPermissions() {
        return permissions;
    }

    public Map<String, String> getUsages() {
        return usages;
    }

    public Map<String, String> getDescriptions() {
        return descriptions;
    }
}
