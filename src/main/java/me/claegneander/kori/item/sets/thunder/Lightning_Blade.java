package me.claegneander.kori.item.sets.thunder;

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

public class Lightning_Blade extends ItemBase {

    public Lightning_Blade() {
        super(Component.text("Lightning Blade").color(TextColor.fromHexString(Color.LIGHT_BLUE.getHEX())),
                Material.DIAMOND_SWORD, Tier.LEGENDARY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("A blade imbued with lightning.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.DAMAGE_ALL, 8);
        addEnchantment(Enchantment.DURABILITY, 8);
        addRune(Runes.LIGHTNING, 8);
        setSockets(Socket.get(getTier()));
        setTierColor(Color.DARK_BLUE.getHEX());
        return create();
    }
}
