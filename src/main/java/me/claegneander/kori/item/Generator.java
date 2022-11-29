package me.claegneander.kori.item;

import me.claegneander.kori.misc.Use;
import me.claegneander.kori.misc.enums.Color;
import me.claegneander.kori.misc.enums.Tier;
import me.claegneander.kori.rune.Rune;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Generator {
    Random random = new Random();

    public ItemStack generate(Tier tier){
        Material material = generateMaterial(tier);
        ItemBase itemBase = new ItemBase(null, material, tier,
                0, true, true);

        int minimum = tier.getMinimumEnchantmentLevel();
        int maximum = tier.getMaximumEnchantmentLevel();
        for(Enchantment e : Use.generateEnchantments(tier)){
            int level = random.nextInt((maximum - minimum + 1) + minimum);
            if(level == 0){
                level = 1;
            }
            itemBase.addEnchantment(e, level);
        }
        for(Rune r : Use.generateRunes(tier)){
            int level = random.nextInt((maximum - minimum + 1) + minimum);
            if(level == 0){
                level = 1;
            }
            itemBase.addRune(r, level);
        }
        itemBase.setSockets(Socket.get(tier));
        return itemBase.create();
    }
    public Material generateMaterial(Tier tier){
        int x = random.nextInt(getTierMaterials(tier).size());
        return getTierMaterials(tier).get(x);
    }
    public List<Material> getTierMaterials(Tier tier) {
        List<Material> materials = new ArrayList<>();
        if (tier == Tier.COMMON) {
            materials.addAll(getWooden());
            materials.addAll(getLeather());
            return materials;
        }
        if (tier == Tier.UNCOMMON) {
            materials.addAll(getWooden());
            materials.addAll(getLeather());
            materials.addAll(getStone());
            materials.addAll(getChainmail());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.RARE) {
            materials.addAll(getStone());
            materials.addAll(getChainmail());
            materials.addAll(getIron());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.EPIC) {
            materials.addAll(getIron());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.FABLE) {
            materials.addAll(getIron());
            materials.addAll(getGold());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.MYTHIC) {
            materials.addAll(getGold());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.RELIC) {
            materials.addAll(getGold());
            materials.addAll(getDiamond());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.LEGENDARY) {
            materials.addAll(getDiamond());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.TRANSCENDENT) {
            materials.addAll(getDiamond());
            materials.addAll(getNetherite());
            materials.addAll(getGeneral());
            return materials;
        }
        if (tier == Tier.GODLY) {
            materials.addAll(getNetherite());
            materials.addAll(getGeneral());
            return materials;
        }
        return null;
    }

    /* Carrot on a Stick, Warped Fungus on a Stick, and Elytra are missing. */
    public List<Material> getGeneral(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.FISHING_ROD);
        materials.add(Material.FLINT_AND_STEEL);
        materials.add(Material.TURTLE_HELMET);
        materials.add(Material.TRIDENT);
        materials.add(Material.BOW);
        materials.add(Material.CROSSBOW);
        materials.add(Material.SHEARS);
        materials.add(Material.SHIELD);
        return materials;
    }
    public List<Material> getWooden(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.WOODEN_SWORD);
        materials.add(Material.WOODEN_AXE);
        materials.add(Material.WOODEN_PICKAXE);
        materials.add(Material.WOODEN_SHOVEL);
        materials.add(Material.WOODEN_HOE);
        return materials;
    }
    public List<Material> getStone(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.STONE_SWORD);
        materials.add(Material.STONE_AXE);
        materials.add(Material.STONE_PICKAXE);
        materials.add(Material.STONE_SHOVEL);
        materials.add(Material.STONE_HOE);
        return materials;
    }
    public List<Material> getLeather(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.LEATHER_HELMET);
        materials.add(Material.LEATHER_CHESTPLATE);
        materials.add(Material.LEATHER_LEGGINGS);
        materials.add(Material.LEATHER_BOOTS);
        return materials;
    }
    public List<Material> getChainmail(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.CHAINMAIL_HELMET);
        materials.add(Material.CHAINMAIL_CHESTPLATE);
        materials.add(Material.CHAINMAIL_LEGGINGS);
        materials.add(Material.CHAINMAIL_BOOTS);
        return materials;
    }
    public List<Material> getGold(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.GOLDEN_SWORD);
        materials.add(Material.GOLDEN_AXE);
        materials.add(Material.GOLDEN_PICKAXE);
        materials.add(Material.GOLDEN_SHOVEL);
        materials.add(Material.GOLDEN_HOE);
        materials.add(Material.GOLDEN_HELMET);
        materials.add(Material.GOLDEN_CHESTPLATE);
        materials.add(Material.GOLDEN_LEGGINGS);
        materials.add(Material.GOLDEN_BOOTS);
        return materials;
    }
    public List<Material> getIron(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.IRON_SWORD);
        materials.add(Material.IRON_AXE);
        materials.add(Material.IRON_PICKAXE);
        materials.add(Material.IRON_SHOVEL);
        materials.add(Material.IRON_HOE);
        materials.add(Material.IRON_HELMET);
        materials.add(Material.IRON_CHESTPLATE);
        materials.add(Material.IRON_LEGGINGS);
        materials.add(Material.IRON_BOOTS);
        return materials;
    }
    public List<Material> getDiamond(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.DIAMOND_SWORD);
        materials.add(Material.DIAMOND_AXE);
        materials.add(Material.DIAMOND_PICKAXE);
        materials.add(Material.DIAMOND_SHOVEL);
        materials.add(Material.DIAMOND_HOE);
        materials.add(Material.DIAMOND_HELMET);
        materials.add(Material.DIAMOND_CHESTPLATE);
        materials.add(Material.DIAMOND_LEGGINGS);
        materials.add(Material.DIAMOND_BOOTS);
        return materials;
    }
    public List<Material> getNetherite(){
        List<Material> materials = new ArrayList<>();
        materials.add(Material.NETHERITE_SWORD);
        materials.add(Material.NETHERITE_AXE);
        materials.add(Material.NETHERITE_PICKAXE);
        materials.add(Material.NETHERITE_SHOVEL);
        materials.add(Material.NETHERITE_HOE);
        materials.add(Material.NETHERITE_HELMET);
        materials.add(Material.NETHERITE_CHESTPLATE);
        materials.add(Material.NETHERITE_LEGGINGS);
        materials.add(Material.NETHERITE_BOOTS);
        return materials;
    }
}
