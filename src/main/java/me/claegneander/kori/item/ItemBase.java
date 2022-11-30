package me.claegneander.kori.item;

import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import me.claegneander.kori.rune.Rune;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class ItemBase {
    private final PDCs pdc = new PDCs();
    private final Random random = new Random();
    /* --- */
    private final Component name;
    private Component tierDisplay;
    private final Material material;
    private final Tier tier;
    private final int dropChance;
    private final boolean isEnchantable, isSocketable;
    private final List<Component> lore;
    private List<Component> sockets;
    private HashMap<Enchantment, Integer> enchantments;
    private HashMap<Rune, Integer> runes;

    public ItemBase(Component name, Material material, Tier tier, int dropChance,
                    boolean isEnchantable, boolean isSocketable) {
        this.name = name;
        this.material = material;
        this.tier = tier;
        this.dropChance = dropChance;
        this.isEnchantable = isEnchantable;
        this.isSocketable = isSocketable;
        lore = new ArrayList<>();
        sockets = new ArrayList<>();
        enchantments = new HashMap<>();
        runes = new HashMap<>();
        tierDisplay = getTier().getName();
    }

    public ItemStack create(){
        ItemStack itemStack = new ItemStack(getMaterial());
        ItemMeta itemMeta = itemStack.getItemMeta();
        //if(itemMeta == null){return itemStack;}
        if(getName() != null) {
            itemMeta.displayName(getName());
        }
        List<Component> temp = new ArrayList<>();
        /* This is where we add both vanilla enchantments and our custom ones called runes. */
        if(isEnchantable()){
            for(Enchantment e : enchantments.keySet()){
                itemMeta.addEnchant(e, enchantments.get(e), true);
            }
            for(Rune r : runes.keySet()){
                int level = runes.get(r);
                if(level > r.getMaximumLevel()){
                    level = r.getMaximumLevel();
                }
                if(r.getTarget().includes(material)) {
                    itemStack.setItemMeta(itemMeta);
                    itemMeta = pdc.setPDCInteger(itemStack, Use.key(r.getName()), level);
                    temp.add(Component.text(Use.strip(r.getName()) + " " + Use.IntegerToRomanNumerals(level))
                            .color(TextColor.fromHexString(Color.DEFAULT.getHEX()))
                            .decoration(TextDecoration.ITALIC, false));
                }
            }
        }
        temp.addAll(getLore());
        temp.add(tierDisplay);
        /* We add our sockets into the lore here. */
        if(isSocketable()){
            temp.addAll(getSockets());
        }
        /* Since things get funky, we periodically set our itemMeta again. */
        itemMeta.lore(temp);
        itemStack.setItemMeta(itemMeta);
        /* This is where we add PDC data for everything else to our itemStack. */
        itemMeta = pdc.setPDCString(itemStack, Tier.KEY, Use.key(getTier().getName()));
        itemStack.setItemMeta(itemMeta);
        itemMeta = pdc.setPDCInteger(itemStack, "dropChance", getDropChance());
        itemStack.setItemMeta(itemMeta);
        itemMeta = pdc.setPDCString(itemStack, "isEnchantable", String.valueOf(isEnchantable()));
        itemStack.setItemMeta(itemMeta);
        itemMeta = pdc.setPDCString(itemStack, "isSocketable", String.valueOf(isSocketable()));
        itemStack.setItemMeta(itemMeta);
        /* This is where we generate our attributes based on our tier. */
        Stats.generateStats(this, itemStack);
        //itemStack = addFlag(itemStack, ItemFlag.HIDE_ATTRIBUTES);
        /* We return our newly complete and very complicated itemStack! */
        return itemStack;
    }
    /* --- */
    public void addLore(Component component){
        lore.add(component);
    }
    public void removeLore(Component component){
        lore.remove(component);
    }
    public void addEnchantment(Enchantment enchantment, int level){
        enchantments.put(enchantment, level);
    }
    public void removeEnchantment(Enchantment enchantment){
        enchantments.remove(enchantment);
    }
    public void setEnchantments(HashMap<Enchantment, Integer> enchantments){
        this.enchantments = enchantments;
    }
    public void addRune(Rune rune, int level){
        runes.put(rune, level);
    }
    public void removeRune(Rune rune){
        runes.remove(rune);
    }
    public void setRunes(HashMap<Rune, Integer> runes){
        this.runes = runes;
    }
    public void addSocket(Component component){
        sockets.add(component);
    }
    public void removeSocket(Component component){
        sockets.remove(component);
    }
    public void setSockets(List<Component> sockets){
        this.sockets = sockets;
    }
    public ItemStack addFlag(ItemStack itemStack, ItemFlag itemFlag){
        ItemMeta itemMeta = itemStack.getItemMeta();
        if(itemMeta != null){
            itemMeta.addItemFlags(itemFlag);
        }
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
    public void setTierColor(String hexCode){
        Component c = getTier().getName();
        c = c.color(TextColor.fromHexString(hexCode));
        tierDisplay = c;
    }
    /* --- */
    public Component getName() {
        return name;
    }
    public Material getMaterial() {
        return material;
    }
    public Tier getTier() {
        return tier;
    }
    public int getDropChance() {
        return dropChance;
    }
    public boolean isEnchantable() {
        return isEnchantable;
    }
    public boolean isSocketable() {
        return isSocketable;
    }
    public List<Component> getLore() {
        return lore;
    }
    public List<Component> getSockets() {
        return sockets;
    }
    public HashMap<Enchantment, Integer> getEnchantments() {
        return enchantments;
    }
    public HashMap<Rune, Integer> getRunes() {
        return runes;
    }
}
