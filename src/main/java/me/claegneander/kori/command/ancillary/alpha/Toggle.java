package me.claegneander.kori.command.ancillary.alpha;

import me.claegneander.kori.Main;
import me.claegneander.kori.command.ancillary.Ancillary;
import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.item.consumable.Socket_Expander;
import me.claegneander.kori.item.consumable.Tier_Upgrader;
import me.claegneander.kori.misc.enums.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Toggle implements Ancillary {
    private final Main plugin = Main.getPlugin(Main.class).getInstance();
    private final ConsoleCommandSender console = plugin.getConsole();
    private final PDCs pdc = new PDCs();
    private final Socket_Expander socketExpander = new Socket_Expander();
    private final Tier_Upgrader tierUpgrader = new Tier_Upgrader();
    List<String> keys;
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (!(sender instanceof Player player)) {
            console.sendMessage(Component.text("You must be a player to use this command.")
                    .color(TextColor.fromHexString(Color.ERROR.getHEX())));
            return;
        }
        if (!player.hasPermission(getPermission())) {
            player.sendMessage(Component.text("Missing permission: " + getPermission())
                    .color(TextColor.fromHexString(Color.ERROR.getHEX())));
            return;
        }
        keys = new ArrayList<>();
        keys.add(socketExpander.KEY);
        keys.add(tierUpgrader.KEY);
        if (args.length > 1) {
            boolean value = false;
            for(String s : keys){
                if(args[1].equalsIgnoreCase(s)){
                    if(pdc.hasPDCString(player, s + ".toggle")){
                        value = Boolean.parseBoolean(pdc.getPDCString(player, s + ".toggle"));
                    }
                    if(value){
                        pdc.setPDCString(player, s + ".toggle", String.valueOf(false));
                        player.sendMessage(Component.text("The key " + s + " has been toggled off.")
                                .color(TextColor.fromHexString(Color.INFO.getHEX())));
                    }else{
                        pdc.setPDCString(player, s + ".toggle", String.valueOf(true));
                        player.sendMessage(Component.text("The key " + s + " has been toggled on.")
                                .color(TextColor.fromHexString(Color.INFO.getHEX())));
                    }
                }
            }
        }
    }

    @Override
    public String getPermission() {
        return "kori.commands.toggle";
    }

    @Override
    public String getUsage() {
        return "/kori toggle [KEY]";
    }

    @Override
    public String getDescription() {
        return "Toggles the desired function.";
    }
}
