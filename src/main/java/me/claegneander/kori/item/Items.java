package me.claegneander.kori.item;

import me.claegneander.kori.item.consumable.Socket_Expander;
import me.claegneander.kori.item.consumable.Tier_Upgrader;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Items {

    private static List<ItemStack> constantItems;

    public Items(){
        constantItems = new ArrayList<>();
        constantItems.add(new Socket_Expander().get());
        constantItems.add(new Tier_Upgrader().get());
    }
    public static List<ItemStack> getConstants(){
        return constantItems;
    }
}
