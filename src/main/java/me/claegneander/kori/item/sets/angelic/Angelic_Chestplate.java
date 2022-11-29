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

public class Angelic_Chestplate extends ItemBase {

    public Angelic_Chestplate() {
        super(Component.text("Robes of the Angel").color(TextColor.fromHexString(Color.BLUE.getHEX())),
                Material.NETHERITE_CHESTPLATE, Tier.GODLY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("Worn by the most beautiful princess of the Therans.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 10);
        addEnchantment(Enchantment.DURABILITY, 10);
      //addRune(Runes.ANGELIC_GRACE, 1);
        setSockets(Socket.get(getTier()));
        return create();
    }
}
