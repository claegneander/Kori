package me.claegneander.kori.item;

import me.claegneander.kori.Main;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.*;

public class Stats {
    static ConsoleCommandSender console = Main.getPlugin(Main.class).getConsole();
    static Random random = new Random();

    public static void generateStats(ItemBase itemBase, ItemStack itemStack){
        generateArmor(itemBase, itemStack);
        generateArmorToughness(itemBase, itemStack);
        generateKnockbackResistance(itemBase, itemStack);
        generateAttackSpeed(itemBase, itemStack);
        generateAttackDamage(itemBase, itemStack);
    }
    public static void generateMaxHealth(ItemBase itemBase, ItemStack itemStack) {
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinHealth();
        double maximum = itemBase.getTier().getMaxHealth();
        double value = 0;
        while (value < minimum) {
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the damage value of the itemStack. */
        EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Attribute attribute = Attribute.GENERIC_MAX_HEALTH;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "maxHealth", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
        itemMeta.addAttributeModifier(attribute, modifier);
        itemStack.setItemMeta(itemMeta);
    }
    public static void generateArmor(ItemBase itemBase, ItemStack itemStack){
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinArmor();
        double maximum = itemBase.getTier().getMaxArmor();
        double value = 0;
        while(value < minimum){
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the armor value of the itemStack. */
        for(Material material : armorMaterials()) {
            if (itemStack.getType().equals(material)) {
                EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                Attribute attribute = Attribute.GENERIC_ARMOR;
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "armor", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
                itemMeta.addAttributeModifier(attribute, modifier);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }

    public static void generateArmorToughness(ItemBase itemBase, ItemStack itemStack){
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinArmorToughness();
        double maximum = itemBase.getTier().getMaxArmorToughness();
        double value = 0;
        while(value < minimum){
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the armor toughness value of the itemStack. */
        for(Material material : armorMaterials()) {
            if (itemStack.getType().equals(material)) {
                EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                Attribute attribute = Attribute.GENERIC_ARMOR_TOUGHNESS;
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "armorToughness", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
                itemMeta.addAttributeModifier(attribute, modifier);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }
    public static void generateKnockbackResistance(ItemBase itemBase, ItemStack itemStack){
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinKnockbackResistance();
        double maximum = itemBase.getTier().getMaxKnockbackResistance();
        double value = 0;
        while(value < minimum){
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the knockback resistance value of the itemStack. */
        for(Material material : armorMaterials()) {
            if (itemStack.getType().equals(material)) {
                EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                Attribute attribute = Attribute.GENERIC_KNOCKBACK_RESISTANCE;
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "knockbackResistance", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
                itemMeta.addAttributeModifier(attribute, modifier);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }
    public static void generateAttackSpeed(ItemBase itemBase, ItemStack itemStack){
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinAttackSpeed();
        double maximum = itemBase.getTier().getMaxAttackSpeed();
        double value = 0;
        while(value < minimum){
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the attack speed value of the itemStack. */
        for(Material material : weaponMaterials()) {
            if (itemStack.getType().equals(material)) {
                EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                Attribute attribute = Attribute.GENERIC_ATTACK_SPEED;
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "attackSpeed", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
                itemMeta.addAttributeModifier(attribute, modifier);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }
    public static void generateAttackDamage(ItemBase itemBase, ItemStack itemStack){
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinDamage();
        double maximum = itemBase.getTier().getMaxDamage();
        double value = 0;
        while(value < minimum){
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the damage value of the itemStack. */
        for(Material material : weaponMaterials()) {
            if (itemStack.getType().equals(material)) {
                EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
                ItemMeta itemMeta = itemStack.getItemMeta();
                Attribute attribute = Attribute.GENERIC_ATTACK_DAMAGE;
                AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "damage", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
                itemMeta.addAttributeModifier(attribute, modifier);
                itemStack.setItemMeta(itemMeta);
            }
        }
    }
    public static void generateMovementSpeed(ItemBase itemBase, ItemStack itemStack) {
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinMovementSpeed();
        double maximum = itemBase.getTier().getMaxMovementSpeed();
        double value = 0;
        while (value < minimum) {
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the damage value of the itemStack. */
        EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Attribute attribute = Attribute.GENERIC_MOVEMENT_SPEED;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "movementSpeed", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
        itemMeta.addAttributeModifier(attribute, modifier);
        itemStack.setItemMeta(itemMeta);
    }
    public static void generateLuck(ItemBase itemBase, ItemStack itemStack) {
        /* This gets us a random value between our min and max for the tier. */
        double minimum = itemBase.getTier().getMinLuck();
        double maximum = itemBase.getTier().getMaxLuck();
        double value = 0;
        while (value < minimum) {
            value = random.nextDouble(maximum);
        }
        DecimalFormat df = new DecimalFormat("0.00");
        value = Double.parseDouble(df.format(value));

        /* This is where we set the damage value of the itemStack. */
        EquipmentSlot equipmentSlot = getEquipmentSlot(itemStack);
        ItemMeta itemMeta = itemStack.getItemMeta();
        Attribute attribute = Attribute.GENERIC_LUCK;
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "luck", value, AttributeModifier.Operation.ADD_SCALAR, equipmentSlot);
        itemMeta.addAttributeModifier(attribute, modifier);
        itemStack.setItemMeta(itemMeta);
    }
    public static EquipmentSlot getEquipmentSlot(ItemStack itemStack){
        EquipmentSlot equipmentSlot = EquipmentSlot.HAND;
        for(Material material : armorMaterials()) {
            if (itemStack.getType().equals(material)) {
                if (material.name().endsWith("HELMET")) {
                    equipmentSlot = EquipmentSlot.HEAD;
                }
                if (material.name().endsWith("CHESTPLATE")) {
                    equipmentSlot = EquipmentSlot.CHEST;
                }
                if (material.name().endsWith("LEGGINGS")) {
                    equipmentSlot = EquipmentSlot.LEGS;
                }
                if (material.name().endsWith("BOOTS")) {
                    equipmentSlot = EquipmentSlot.FEET;
                }
                if (material.name().endsWith("ELYTRA")) {
                    equipmentSlot = EquipmentSlot.CHEST;
                }
            }
        }
        return equipmentSlot;
    }
    public static List<Material> armorMaterials(){
        List<Material> materials = new ArrayList<>();
        for(Material m : Material.values()){
            ItemStack i = new ItemStack(m);
            if(i.getType().name().endsWith("HELMET") || i.getType().name().endsWith("CHESTPLATE") ||
                    i.getType().name().endsWith("LEGGINGS") || i.getType().name().endsWith("BOOTS") ||
                    i.getType().name().endsWith("ELYTRA")){
                materials.add(m);
            }
        }
        return materials;
    }
    public static List<Material> weaponMaterials(){
        List<Material> materials = new ArrayList<>();
        for(Material m : Material.values()){
            ItemStack i = new ItemStack(m);
            if(i.getType().name().endsWith("SWORD") || i.getType().name().endsWith("PICKAXE") ||
                    i.getType().name().endsWith("AXE") || i.getType().name().endsWith("SHOVEL") ||
                    i.getType().name().endsWith("TRIDENT") || i.getType().name().endsWith("HOE")){
                materials.add(m);
            }
        }
        return materials;
    }

}
