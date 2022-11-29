package me.claegneander.kori.data;

import me.claegneander.kori.Main;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class PDCs {
    Main instance = Main.getPlugin(Main.class).getInstance();

    /* -------------------------------------------------------------------------------------------------------------- */
    /* ItemStacks */
    /* -------------------------------------------------------------------------------------------------------------- */
    public boolean hasPDCInteger(ItemStack itemStack, String key){
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        if (pdc.get(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.INTEGER) != null) {
            return pdc.has(new NamespacedKey(instance, key));
        }
        return false;
    }
    public Integer getPDCInteger(ItemStack itemStack, String key){
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        return pdc.get(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.INTEGER);
    }
    public ItemMeta setPDCInteger(ItemStack itemStack, String key, Integer i){
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.INTEGER, i);
        return itemMeta;
    }
    public boolean hasPDCDouble(ItemStack itemStack, String key){
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        if (pdc.get(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.DOUBLE) != null) {
            return pdc.has(new NamespacedKey(instance, key));
        }
        return false;
    }
    public Double getPDCDouble(ItemStack itemStack, String key){
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        return pdc.get(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.DOUBLE);
    }
    public ItemMeta setPDCDouble(ItemStack itemStack, String key, Double i){
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(new NamespacedKey(instance, key.toLowerCase()), PersistentDataType.DOUBLE, i);
        return itemMeta;
    }
    public boolean hasPDCString(ItemStack itemStack, String key){
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        if(pdc.get(new NamespacedKey(instance, key), PersistentDataType.STRING) != null){
            return pdc.has(new NamespacedKey(instance, key));
        }
        return false;
    }
    public String getPDCString(ItemStack itemStack, String key){
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer pdc = itemStack.getItemMeta().getPersistentDataContainer();
        return pdc.get(new NamespacedKey(instance, key), PersistentDataType.STRING);
    }
    public ItemMeta setPDCString(ItemStack itemStack, String key, String value){
        ItemMeta itemMeta = itemStack.getItemMeta();
        PersistentDataContainer pdc = itemMeta.getPersistentDataContainer();
        pdc.set(new NamespacedKey(instance, key), PersistentDataType.STRING, value);
        return itemMeta;
    }
    /* -------------------------------------------------------------------------------------------------------------- */
    /* Players */
    /* -------------------------------------------------------------------------------------------------------------- */
    public boolean hasPDCString(Player player, String key){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        if(pdc.get(new NamespacedKey(instance, key), PersistentDataType.STRING) != null){
            return pdc.has(new NamespacedKey(instance, key));
        }
        return false;
    }
    public String getPDCString(Player player, String key){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(instance, key), PersistentDataType.STRING);
    }
    public void setPDCString(Player player, String key, String value){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(instance, key), PersistentDataType.STRING, value);
    }
    public boolean hasPDCDouble(Player player, String key){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        if(pdc.get(new NamespacedKey(instance, key), PersistentDataType.DOUBLE) != null){
            return pdc.has(new NamespacedKey(instance, key));
        }
        return false;
    }
    public Double getPDCDouble(Player player, String key){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        return pdc.get(new NamespacedKey(instance, key), PersistentDataType.DOUBLE);
    }
    public void setPDCDouble(Player player, String key, Double value){
        PersistentDataContainer pdc = player.getPersistentDataContainer();
        pdc.set(new NamespacedKey(instance, key), PersistentDataType.DOUBLE, value);
    }
}
