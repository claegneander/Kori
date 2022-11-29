package me.claegneander.kori.item;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.item.consumable.SocketExpander;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Socket {
    static PDCs pdc = new PDCs();

    private final static Component SOCKET = Component.text("[Socket]").color(TextColor.fromHexString(Color.DEFAULT.getHEX()));

    public static List<Component> get(Tier tier){
        int minimum = tier.getMinimumSockets();
        int maximum = tier.getMaximumSockets();
        Random random = new Random();
        int amount = 0;
        while(amount < minimum + 1){
            amount = random.nextInt((maximum - minimum + 1) + minimum);
        }
        List<Component> sockets = new ArrayList<>();
        for(int x = 0; x < amount; x++){
            sockets.add(SOCKET);
        }
        return sockets;
    }
    public static boolean hasSockets(ItemStack itemStack){
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            List<Component> lore = itemMeta.lore();
            if(lore != null) {
                return lore.contains(SOCKET);
            }
        }
        return false;
    }
    public static ItemStack addSocket(Player player, ItemStack itemStack) {
        if (pdc.hasPDCString(itemStack, Tier.KEY)) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta != null) {
                List<Component> lore = itemMeta.lore();
                List<Component> temp = new ArrayList<>();
                List<Component> sockets = new ArrayList<>();
                if (lore != null) {
                    for (Component c : lore) {
                        if (c.equals(SOCKET)) {
                            sockets.add(c);
                        }else{
                            temp.add(c);
                        }
                    }
                }
                Tier tier = Use.checkForTier(itemStack);
                if(tier != null) {
                    int maximum = tier.getMaximumSockets();
                    if(sockets.size() < maximum){
                        sockets.add(SOCKET);
                        player.sendMessage(Component.text("A socket has been added to your item.")
                                .color(TextColor.fromHexString(Color.SUCCESS.getHEX())));
                        SocketExpander socketExpander = new SocketExpander();
                        pdc.setPDCString(player, socketExpander.KEY, String.valueOf(false));
                    }else{
                        player.sendMessage(Component.text("That item has the maximum amount of sockets already.")
                                .color(TextColor.fromHexString(Color.ERROR.getHEX())));
                    }
                }
                temp.addAll(sockets);
                itemMeta.lore(temp);
                itemStack.setItemMeta(itemMeta);
            }
        }
        return itemStack;
    }
    public static ItemStack removeSocket(Player player, ItemStack itemStack) {
        if (pdc.hasPDCString(itemStack, Tier.KEY)) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta != null) {
                List<Component> lore = itemMeta.lore();
                List<Component> temp = new ArrayList<>();
                List<Component> sockets = new ArrayList<>();
                if (lore != null) {
                    for (Component c : lore) {
                        if (c.equals(SOCKET)) {
                            sockets.add(c);
                        }else{
                            temp.add(c);
                        }
                    }
                }
                Tier tier = Use.checkForTier(itemStack);
                if(tier != null) {
                    int minimum = tier.getMinimumSockets();
                    if(sockets.size() > minimum){
                        sockets.remove(sockets.size() - 1);
                        player.sendMessage(Component.text("A socket has been removed from your item.")
                                .color(TextColor.fromHexString(Color.SUCCESS.getHEX())));
                        /*
                        SocketRemover socketRemover = new SocketRemover();
                        pdc.setPDCString(player, socketRemover.KEY, String.valueOf(false));
                        */
                    }else{
                        player.sendMessage(Component.text("That item has no sockets to remove.")
                                .color(TextColor.fromHexString(Color.ERROR.getHEX())));
                    }
                }
                temp.addAll(sockets);
                itemMeta.lore(temp);
                itemStack.setItemMeta(itemMeta);
            }
        }
        return itemStack;
    }
    /* This will replace the first available socket with a component. */
    public static ItemStack replaceSocket(Player player, ItemStack itemStack, Component component) {
        if (pdc.hasPDCString(itemStack, Tier.KEY)) {
            ItemMeta itemMeta = itemStack.getItemMeta();
            if (itemMeta != null) {
                List<Component> lore = itemMeta.lore();
                List<Component> temp = new ArrayList<>();
                List<Component> sockets = new ArrayList<>();
                if (lore != null) {
                    for (Component c : lore) {
                        if (c.equals(SOCKET)) {
                            sockets.add(c);
                        }else{
                            temp.add(c);
                        }
                    }
                }
                if(sockets.size() != 0) {
                    sockets.set(0, component);
                    player.sendMessage(Component.text("Gemstone has been put in a socket.")
                            .color(TextColor.fromHexString(Color.SUCCESS.getHEX())));
                }else{
                    player.sendMessage(Component.text("No available sockets.")
                            .color(TextColor.fromHexString(Color.ERROR.getHEX())));
                }
                temp.addAll(sockets);
                itemMeta.lore(temp);
                itemStack.setItemMeta(itemMeta);
            }
        }
        return itemStack;
    }

}
