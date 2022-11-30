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

public class Thunder_Helmet extends ItemBase {

    public Thunder_Helmet() {
        super(Component.text("Thunder Helmet").color(TextColor.fromHexString(Color.LIGHT_BLUE.getHEX())),
                Material.DIAMOND_HELMET, Tier.LEGENDARY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("A helmet imbued with lightning.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
        addEnchantment(Enchantment.DURABILITY, 8);
        setSockets(Socket.get(getTier()));
        setTierColor(Color.DARK_BLUE.getHEX());
        return create();
    }
}
