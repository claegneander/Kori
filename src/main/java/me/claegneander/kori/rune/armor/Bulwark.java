package me.claegneander.kori.rune.armor;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.rune.Rune;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Bulwark extends Rune implements Listener {
    PDCs pdc = new PDCs();

    public Bulwark() {
        super(Component.text("Bulwark")
                        .color(TextColor.fromHexString(Color.GRAY.getHEX()))
                        .decoration(TextDecoration.ITALIC, false),
                1, 5, EnchantmentTarget.ARMOR);
    }
    @EventHandler
    public void onEvent(EntityDamageByEntityEvent event){
        if(event.getDamager() instanceof  Player player) {
            ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
            if (pdc.hasPDCInteger(itemInMainHand, Use.key(getName()))) {
                Random random = new Random();
                int chance = random.nextInt(10001);
                int level = pdc.getPDCInteger(itemInMainHand, Use.key(getName()));
                chance = chance + (level * 100);
                if (chance < 1001) {
                    //DO BULWARK!
                }
            }
        }
    }
}
