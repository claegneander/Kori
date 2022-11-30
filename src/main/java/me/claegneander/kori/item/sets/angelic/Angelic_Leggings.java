package me.claegneander.kori.item.sets.angelic;

import me.claegneander.kori.item.ItemBase;
import me.claegneander.kori.item.Socket;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import me.claegneander.kori.rune.Runes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Angelic_Leggings extends ItemBase {

    public Angelic_Leggings() {
        super(Component.text("Greaves of the Angel").color(TextColor.fromHexString("#FFDFD3")),
                Material.NETHERITE_LEGGINGS, Tier.GODLY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("Worn by the most beautiful").color(TextColor.fromHexString("#FEC8D8")));
        addLore(Component.text("princess of the Therans.").color(TextColor.fromHexString("#FEC8D8")));
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addEnchantment(Enchantment.DURABILITY, 10);
        addRune(Runes.ANGELIC_GRACE, 1);
        setSockets(Socket.get(getTier()));
        setTierColor("#D291BC");
        return create();
    }
}
