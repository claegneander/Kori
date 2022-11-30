package me.claegneander.kori.item.sets.thunder;

import me.claegneander.kori.item.ItemBase;
import me.claegneander.kori.item.Socket;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class Thunder_Leggings extends ItemBase {

    public Thunder_Leggings() {
        super(Component.text("Thunder Leggings").color(TextColor.fromHexString(Color.LIGHT_BLUE.getHEX())),
                Material.DIAMOND_LEGGINGS, Tier.LEGENDARY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("Leggings imbued with lightning.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
        addEnchantment(Enchantment.DURABILITY, 8);
        setSockets(Socket.get(getTier()));
        setTierColor(Color.DARK_BLUE.getHEX());
        return create();
    }
}
