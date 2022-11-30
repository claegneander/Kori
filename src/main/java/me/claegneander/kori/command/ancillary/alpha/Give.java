package me.claegneander.kori.command.ancillary.alpha;

import me.claegneander.kori.Main;
import me.claegneander.kori.command.ancillary.Ancillary;
import me.claegneander.kori.item.Generator;
import me.claegneander.kori.item.sets.angelic.Angelic_Chestplate;
import me.claegneander.kori.item.sets.angelic.Angelic_Helmet;
import me.claegneander.kori.item.sets.angelic.Angelic_Leggings;
import me.claegneander.kori.item.sets.thunder.Thunder_Boots;
import me.claegneander.kori.item.sets.thunder.Thunder_Chestplate;
import me.claegneander.kori.item.sets.thunder.Thunder_Helmet;
import me.claegneander.kori.item.sets.thunder.Thunder_Leggings;
import me.claegneander.kori.item.consumable.SocketExpander;
import me.claegneander.kori.item.consumable.TierUpgrader;
import me.claegneander.kori.item.sets.thunder.Lightning_Blade;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

public class Give implements Ancillary {
    private final Main plugin = Main.getPlugin(Main.class).getInstance();
    private final ConsoleCommandSender console = plugin.getConsole();
    @Override
    public void execute(CommandSender sender, String[] args) {
        if(sender instanceof Player player){
            if(player.hasPermission(getPermission())) {
                Player target = player;
                int amount = 1;
                if (args.length > 2) {
                    if (Use.isInt(args[2])) {
                        amount = Integer.parseInt(args[2]);
                    }
                    if (args.length > 3) {
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            if (args[3].equalsIgnoreCase(p.getName())) {
                                target = p;
                            }
                        }
                    }
                    for (int i = 0; i < amount; i++) {
                        for (String s : getItems().keySet()) {
                            if (args[1].equalsIgnoreCase(s)) {
                                Location l = target.getLocation();
                                if (player.getInventory().firstEmpty() != -1) {
                                    target.getInventory().addItem(getItems().get(s));
                                } else {
                                    l.getWorld().dropItemNaturally(l, getItems().get(s));
                                }
                            }
                        }
                        if (args[1].equalsIgnoreCase("generate")) {
                            Tier tier = Use.generateTier();
                            if(args.length > 3){
                                for(Tier t: Tier.values()) {
                                    if (args[3].equalsIgnoreCase(Use.key(t.getName()))) {
                                        tier = t;
                                    }
                                }
                            }
                            Generator g = new Generator();
                            ItemStack item = g.generate(tier);
                            Location l = target.getLocation();
                            if (player.getInventory().firstEmpty() != -1) {
                                target.getInventory().addItem(item);
                            } else {
                                l.getWorld().dropItemNaturally(l, item);
                            }
                        }
                    }
                }
            }else{
                player.sendMessage(Component.text("Missing permission: " + getPermission())
                        .color(TextColor.fromHexString(Color.ERROR.getHEX())));
            }
        }else{
            console.sendMessage(Component.text("You must be a player to use this command.")
                    .color(TextColor.fromHexString(Color.ERROR.getHEX())));
        }
    }

    @Override
    public String getPermission() {
        return "kori.commands.give";
    }

    @Override
    public String getUsage() {
        return "/kori give [ItemStack itemStack] (int amount) (Player player)";
    }

    @Override
    public String getDescription() {
        return "Gives the player an specific item.";
    }
    public HashMap<String, ItemStack> getItems(){
        HashMap<String, ItemStack> items = new HashMap<>();
        items.put(Use.key(new Angelic_Helmet().getName()), new Angelic_Helmet().get());
        items.put(Use.key(new Angelic_Chestplate().getName()), new Angelic_Chestplate().get());
        items.put(Use.key(new Angelic_Leggings().getName()), new Angelic_Leggings().get());
        items.put(Use.key(new Lightning_Blade().getName()), new Lightning_Blade().get());
        items.put(Use.key(new Thunder_Helmet().getName()), new Thunder_Helmet().get());
        items.put(Use.key(new Thunder_Chestplate().getName()), new Thunder_Chestplate().get());
        items.put(Use.key(new Thunder_Leggings().getName()), new Thunder_Leggings().get());
        items.put(Use.key(new Thunder_Boots().getName()), new Thunder_Boots().get());
        items.put(Use.key(new SocketExpander().getName()), new SocketExpander().get());
        items.put(Use.key(new TierUpgrader().getName()), new TierUpgrader().get());
        return items;
    }
}
