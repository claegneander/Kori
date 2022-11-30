package me.claegneander.kori.item.consumable;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.item.ItemBase;
import me.claegneander.kori.item.Socket;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Socket_Expander extends ItemBase implements Listener {
    PDCs pdc = new PDCs();
    public final String KEY = Use.key(getName());
    public Socket_Expander() {
        super(Component.text("Socket Expander").color(TextColor.fromHexString(Color.LIGHT_BLUE.getHEX())),
                Material.AMETHYST_SHARD, Tier.RARE, 101, true, false);
    }
    public ItemStack get(){
        addLore(Component.text("A crystal with magical properties.")
                .color(TextColor.fromHexString(Color.BLUE.getHEX())));
        addEnchantment(Enchantment.DURABILITY, 1);
        ItemStack itemStack = create();
        itemStack = addFlag(itemStack, ItemFlag.HIDE_ENCHANTS);
        return itemStack;
    }
    @EventHandler
    public void onEvent(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_AIR) {
            return;
        }
        Player player = event.getPlayer();
        ItemStack itemInMainHand = player.getInventory().getItemInMainHand();
        ItemStack socketExpander = get();
        boolean addingSocket = Boolean.parseBoolean(pdc.getPDCString(player, KEY));
        if (pdc.getPDCString(player, KEY + ".toggle").equals(String.valueOf(true))) {
            if (!addingSocket) {
                if (itemInMainHand.isSimilar(socketExpander)) {
                    pdc.setPDCString(player, KEY, String.valueOf(true));
                    itemInMainHand.setAmount(itemInMainHand.getAmount() - 1);
                    player.sendMessage(Component.text("Right click with an item to add a socket.")
                            .color(TextColor.fromHexString(Color.INFO.getHEX())));
                    return;
                }
            }
            if (addingSocket) {
                if (Objects.equals(pdc.getPDCString(itemInMainHand, "isSocketable"), String.valueOf(true))) {
                    ItemStack itemStack = Socket.addSocket(player, itemInMainHand);
                    player.getInventory().setItemInMainHand(itemStack);
                }
            }
        }
    }
}
