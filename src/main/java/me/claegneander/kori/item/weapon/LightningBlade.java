package me.claegneander.kori.item.weapon;

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

public class LightningBlade extends ItemBase {

    public LightningBlade() {
        super(Component.text("Lightning Blade").color(TextColor.fromHexString(Color.BLUE.getHEX())),
                Material.NETHERITE_SWORD, Tier.LEGENDARY, 0, true, true);
    }
    public ItemStack get(){
        addLore(Component.text("A blade imbued with lightning.").color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.DAMAGE_ALL, 8);
        addEnchantment(Enchantment.DURABILITY, 8);
        addRune(Runes.LIGHTNING, 8);
        setSockets(Socket.get(getTier()));
        return create();
    }
}
