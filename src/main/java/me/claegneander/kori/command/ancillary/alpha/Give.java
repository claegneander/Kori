package me.claegneander.kori.command.ancillary.alpha;

import me.claegneander.kori.Main;
import me.claegneander.kori.command.ancillary.Ancillary;
import me.claegneander.kori.item.Generator;
import me.claegneander.kori.item.armor.LightningBoots;
import me.claegneander.kori.item.armor.LightningChestplate;
import me.claegneander.kori.item.armor.LightningHelmet;
import me.claegneander.kori.item.armor.LightningLeggings;
import me.claegneander.kori.item.consumable.SocketExpander;
import me.claegneander.kori.item.consumable.TierUpgrader;
import me.claegneander.kori.item.weapon.LightningBlade;
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
        items.put(Use.key(new LightningBlade().getName()), new LightningBlade().get());
        items.put(Use.key(new LightningHelmet().getName()), new LightningHelmet().get());
        items.put(Use.key(new LightningChestplate().getName()), new LightningChestplate().get());
        items.put(Use.key(new LightningLeggings().getName()), new LightningLeggings().get());
        items.put(Use.key(new LightningBoots().getName()), new LightningBoots().get());
        items.put(Use.key(new SocketExpander().getName()), new SocketExpander().get());
        items.put(Use.key(new TierUpgrader().getName()), new TierUpgrader().get());
        return items;
    }
}
