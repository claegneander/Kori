package me.claegneander.kori.rune.armor;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.rune.Rune;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class Angelic_Grace extends Rune implements Listener {
    PDCs pdc = new PDCs();

    public Angelic_Grace() {
        super(Component.text("Angelic Grace"),
                1, 1, EnchantmentTarget.ARMOR);
    }
    @EventHandler
    public void onEvent(EntityDeathEvent event){
        if(event.getEntity() instanceof  Player player) {
            for(ItemStack i : player.getInventory().getArmorContents()) {
                if (i != null) {
                    if (pdc.hasPDCInteger(i, Use.key(getName()))) {
                        event.setCancelled(true);
                        player.setHealth(player.getMaxHealth());
                        //Make a timer of five minutes before this triggers again.
                    }
                }
            }
        }
    }
}
