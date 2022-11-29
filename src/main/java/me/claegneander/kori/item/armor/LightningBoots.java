package me.claegneander.kori.item.armor;

import me.claegneander.kori.item.ItemBase;
import me.claegneander.kori.item.Socket;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

public class LightningBoots extends ItemBase {

    public LightningBoots() {
        super(Component.text("Lightning Boots").color(TextColor.fromHexString(Color.BLUE.getHEX())),
                Material.NETHERITE_BOOTS, Tier.LEGENDARY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("Boots imbued with lightning.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 8);
        addEnchantment(Enchantment.DURABILITY, 8);
        setSockets(Socket.get(getTier()));
        return create();
    }
}
