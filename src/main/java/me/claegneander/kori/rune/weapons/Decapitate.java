package me.claegneander.kori.rune.weapons;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.rune.Rune;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.Random;

public class Decapitate extends Rune implements Listener {
    PDCs pdc = new PDCs();

    public Decapitate() {
        super(Component.text("Decapitate")
                        .color(TextColor.fromHexString(Color.GRAY.getHEX()))
                        .decoration(TextDecoration.ITALIC, false),
                1, 5, EnchantmentTarget.WEAPON);
    }
    @EventHandler
    public void onEvent(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        if(player == null){return;}
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        if (!pdc.hasPDCInteger(itemInMainHand, Use.key(getName()))){return;}
        //Create the entity head item, and drop it naturally.
    }
}
