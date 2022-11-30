package me.claegneander.kori.command.ancillary.alpha;

import me.claegneander.kori.Main;
import me.claegneander.kori.command.ancillary.Ancillary;
import me.claegneander.kori.misc.enums.Color;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class NV implements Ancillary {
    private final Main plugin = Main.getPlugin(Main.class).getInstance();
    private final ConsoleCommandSender console = plugin.getConsole();
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
        if (args.length >= 1) {
            if (args[0].equalsIgnoreCase("nv")) {
                if (player.hasPotionEffect(PotionEffectType.NIGHT_VISION)) {
                    player.removePotionEffect(PotionEffectType.NIGHT_VISION);
                } else {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 60000, 1));
                }
            }
        }
    }

    @Override
    public String getPermission() {
        return "kori.commands.nv";
    }

    @Override
    public String getUsage() {
        return "/kori nv";
    }

    @Override
    public String getDescription() {
        return "Toggles on night vision for the player.";
    }
}
