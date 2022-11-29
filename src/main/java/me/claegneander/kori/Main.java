package me.claegneander.kori;

import me.claegneander.kori.command.Kori;
import me.claegneander.kori.item.Stats;
import me.claegneander.kori.item.consumable.SocketExpander;
import me.claegneander.kori.item.consumable.TierUpgrader;
import me.claegneander.kori.item.weapon.LightningBlade;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.rune.Runes;
import me.claegneander.kori.rune.armor.Bulwark;
import me.claegneander.kori.rune.weapons.Decapitate;
import me.claegneander.kori.rune.weapons.Lightning;
import me.claegneander.kori.rune.weapons.Vampirism;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Main extends JavaPlugin {
    private Main instance;
    private ConsoleCommandSender console;
    private Runes runes;
    @Override
    public void onEnable() {
        instance = this;
        console = instance.getServer().getConsoleSender();
        runes = new Runes();

        saveDefaultConfig();

        registerCommands();
        registerEvents();

        console.sendMessage(Component.text("[Kori]: Enabled.")
                .color(TextColor.fromHexString(Color.SUCCESS.getHEX())));
    }
    @Override
    public void onDisable() {
        runes = null;
        console.sendMessage(Component.text("[Kori]: Disabled.")
                .color(TextColor.fromHexString(Color.ERROR.getHEX())));
        console = null;
        instance = null;

    }
    public void registerCommands(){
        try{
            Objects.requireNonNull(instance.getCommand("kori")).setExecutor(new Kori());
            console.sendMessage(Component.text("[Kori]: Commands registered.")
                    .color(TextColor.fromHexString(Color.INFO.getHEX())));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void registerEvents(){
        PluginManager pm = this.getServer().getPluginManager();
        try{
            List<Listener> listeners = new ArrayList<>();
            listeners.add(new SocketExpander());
            listeners.add(new TierUpgrader());
            listeners.add(new Bulwark());
            listeners.add(new Decapitate());
            listeners.add(new Lightning());
            listeners.add(new Vampirism());
            for(Listener l : listeners){
                pm.registerEvents(l, instance);
                console.sendMessage(Component.text("[Kori]: Registering the listener: " + l)
                        .color(TextColor.fromHexString(Color.INFO.getHEX())));
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public Main getInstance(){
        return instance;
    }
    public ConsoleCommandSender getConsole() {
        return console;
    }
    public Runes getRunes(){
        return runes;
    }

}
