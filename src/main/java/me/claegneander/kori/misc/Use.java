package me.claegneander.kori.misc;

import me.claegneander.kori.Main;
import me.claegneander.kori.data.PDCs;
import me.claegneander.kori.item.consumable.TierUpgrader;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import me.claegneander.kori.rune.Rune;
import me.claegneander.kori.rune.Runes;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.TextReplacementConfig;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.bukkit.ChatColor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Use {
    private static final Runes RUNES = Main.getPlugin(Main.class).getRunes();
    private static final PDCs pdc = new PDCs();
    static Random random = new Random();
    /* These methods perform various checks for us. */
    /* --------------------------------------------------------------------------------------------------------------*/
    /* This method checks to see if a string input is a valid Integer. */
    public static boolean isInt(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public static Tier checkForTier(ItemStack itemStack) {
        HashMap<Component, Tier> tier = new HashMap<>();
        for (Tier t : Tier.values()) {
            tier.put(t.getName(), t);
        }
        List<Component> lore = itemStack.lore();
        if (lore == null) {
            return null;
        }
        for (Component c : lore) {
            for (Component r : tier.keySet()) {
                if (c.equals(r)) {
                    return tier.get(r);
                }
            }
        }
        return null;
    }
    /* These methods generate various objects for us. */
    /* --------------------------------------------------------------------------------------------------------------*/
    /* This will provide a tier at random. */
    public static Tier generateTier(){
        List<Tier> temp = List.of(Tier.values());
        Random random = new Random();
        int x = random.nextInt(temp.size());
        return temp.get(x);
    }
    /* This will provide a list of enchantments based on tier at random. */
    public static List<Enchantment> generateEnchantments(Tier tier){
        int minimum = tier.getMinimumEnchantmentLevel();
        int maximum = tier.getMaximumEnchantmentLevel();
        int amount = 0;
        while(amount < minimum + 1){
            amount = random.nextInt((maximum - minimum + 1) + minimum);
        }
        List<Enchantment> allEnchantments = Arrays.asList(Enchantment.values());
        List<Enchantment> enchantments = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            int x = random.nextInt(allEnchantments.size());
            if(!enchantments.contains(allEnchantments.get(x))){
                enchantments.add(allEnchantments.get(x));
            }
        }
        return enchantments;
    }
    /* This will provide a list of runes based on tier at random. */
    public static List<Rune> generateRunes(Tier tier){
        int minimum = tier.getMinimumEnchantmentLevel();
        int maximum = tier.getMaximumEnchantmentLevel();
        int amount = 0;
        while(amount < minimum + 1){
            amount = random.nextInt((maximum - minimum + 1) + minimum);
        }
        List<Rune> runes = new ArrayList<>();
        for(int i = 0; i < amount; i++){
            int x = random.nextInt(RUNES.getRunes().size());
            if(!runes.contains(RUNES.getRunes().get(x))){
                runes.add(RUNES.getRunes().get(x));
            }
        }
        return runes;
    }

    /* These methods convert various inputs into more acceptable output for us. */
    /* --------------------------------------------------------------------------------------------------------------*/
    /* This will convert any Integer into the corresponding Roman Numeral. */
    public static String IntegerToRomanNumerals(int x) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanLetters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < values.length; i++) {
            while (x >= values[i]) {
                x = x - values[i];
                s.append(romanLetters[i]);
            }
        }
        return new String(s);
    }
    public static ItemStack upgradeTier(Player player, ItemStack itemStack) {
        Tier tier = Use.checkForTier(itemStack);
        Tier newTier = tier;
        if (tier != null) {
            boolean same = false;
            for (Tier t : Tier.values()) {
                if (same) {
                    newTier = t;
                    break;
                }
                if (tier.equals(t)) {
                    same = true;
                }
            }
            List<Component> lore = itemStack.lore();
            if (lore == null) {
                return null;
            }
            for(int i = 0; i < lore.size(); i++){
                if(lore.get(i).equals(tier.getName())){
                    lore.set(i, newTier.getName());
                    player.sendMessage(Component.text("Tier has been upgraded.")
                            .color(TextColor.fromHexString(Color.SUCCESS.getHEX())));
                    TierUpgrader tierUpgrader = new TierUpgrader();
                    pdc.setPDCString(player, tierUpgrader.KEY, String.valueOf(false));
                    break;
                }
            }
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.lore(lore);
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }
    public static String strip(Component component){
        String s = PlainTextComponentSerializer.plainText().serialize(component);
        s = s.replaceAll("[!@#$%^&*()_\\-\\[\\]]", "");
        return s;
    }
    public static String key(Component component){
        String s = strip(component);
        s = s.replace(" ", "_");
        return s;
    }

}
