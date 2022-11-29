package me.claegneander.kori.misc.enums;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;

public enum Tier {
    COMMON(Component.text("-[Common]-").color(TextColor.fromHexString(Color.COMMON.getHEX())),
            0, 1, 0, 1,
            0.05,0.1,0.05,0.1,0.05,0.1,
            0.05,0.1,0.05,0.1,0.05,0.1,
            0.05,0.1,0.05,0.1),
    UNCOMMON(Component.text("-[Uncommon]-").color(TextColor.fromHexString(Color.UNCOMMON.getHEX())),
            0, 2, 0, 2,
            0.1,0.2,0.1,0.2,0.1,0.2,
            0.1,0.2,0.1,0.2,0.1,0.2,
            0.1,0.2,0.1,0.2),
    RARE(Component.text("-[Rare]-").color(TextColor.fromHexString(Color.RARE.getHEX())),
            0, 3, 0, 3,
            0.15,0.3,0.15,0.3,0.15,0.3,
            0.15,0.3,0.15,0.3,0.15,0.3,
            0.15,0.3,0.15,0.3),
    EPIC(Component.text("-[Epic]-").color(TextColor.fromHexString(Color.EPIC.getHEX())),
            0, 4, 0, 4,
            0.2,0.4,0.2,0.4,0.2,0.4,
            0.2,0.4,0.2,0.4,0.2,0.4,
            0.2,0.4,0.2,0.4),
    RELIC(Component.text("-[Relic]-").color(TextColor.fromHexString(Color.RELIC.getHEX())),
            0, 5, 0, 5,
            0.25,0.5,0.25,0.5,0.25,0.5,
            0.25,0.5,0.25,0.5,0.25,0.5,
            0.25,0.5,0.25,0.5),
    FABLE(Component.text("-[Fable]-").color(TextColor.fromHexString(Color.FABLE.getHEX())),
            0, 6, 0, 6,
            0.3,0.6,0.3,0.6,0.3,0.6,
            0.3,0.6,0.3,0.6,0.3,0.6,
            0.3,0.6,0.3,0.6),
    MYTHIC(Component.text("-[Mythic]-").color(TextColor.fromHexString(Color.MYTHIC.getHEX())),
            0, 7, 0, 7,
            0.35,0.7,0.35,0.7,0.35,0.7,
            0.35,0.7,0.35,0.7,0.35,0.7,
            0.35,0.7,0.35,0.7),
    LEGENDARY(Component.text("-[Legendary]-").color(TextColor.fromHexString(Color.LEGENDARY.getHEX())),
            0, 8, 0, 8,
            0.4,0.8,0.4,0.8,0.4,0.8,
            0.4,0.8,0.4,0.8,0.4,0.8,
            0.4,0.8,0.4,0.8),
    TRANSCENDENT(Component.text("-[Transcendent]-").color(TextColor.fromHexString(Color.TRANSCENDENT.getHEX())),
            0, 9, 0, 9,
            0.45,0.9,0.45,0.9,0.45,0.9,
            0.45,0.9,0.45,0.9,0.45,0.9,
            0.45,0.9,0.45,0.9),
    GODLY(Component.text("-[Godly]-").color(TextColor.fromHexString(Color.GODLY.getHEX())),
            0, 10, 0, 10,
            0.5, 1.0,0.5,1.0,0.5,1.0,
            0.5,1.0,0.5,1.0,0.5,1.0,
            0.5,1.0,0.5,1.0);
    private final Component name;
    private final int minimumEnchantmentLevel, maximumEnchantmentLevel, minimumSockets, maximumSockets;
    private final double minArmor, maxArmor, minArmorToughness, maxArmorToughness, minAttackSpeed, maxAttackSpeed,
            minDamage, maxDamage, minHealth, maxHealth, minKnockbackResistance, maxKnockbackResistance,
            minLuck, maxLuck, minMovementSpeed, maxMovementSpeed;
    public static final String KEY = "tier";

    Tier(Component name, int minimumEnchantmentLevel, int maximumEnchantmentLevel, int minimumSockets, int maximumSockets,
         double minArmor, double maxArmor, double minArmorToughness, double maxArmorToughness, double minAttackSpeed,
         double maxAttackSpeed, double minDamage, double maxDamage, double minHealth, double maxHealth,
         double minKnockbackResistance, double maxKnockbackResistance, double minLuck, double maxLuck,
         double minMovementSpeed, double maxMovementSpeed) {
        this.name = name;
        this.minimumEnchantmentLevel = minimumEnchantmentLevel;
        this.maximumEnchantmentLevel = maximumEnchantmentLevel;
        this.minimumSockets = minimumSockets;
        this.maximumSockets = maximumSockets;
        this.minArmor = minArmor;
        this.maxArmor = maxArmor;
        this.minArmorToughness = minArmorToughness;
        this.maxArmorToughness = maxArmorToughness;
        this.minAttackSpeed = minAttackSpeed;
        this.maxAttackSpeed = maxAttackSpeed;
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.minHealth = minHealth;
        this.maxHealth = maxHealth;
        this.minKnockbackResistance = minKnockbackResistance;
        this.maxKnockbackResistance = maxKnockbackResistance;
        this.minLuck = minLuck;
        this.maxLuck = maxLuck;
        this.minMovementSpeed = minMovementSpeed;
        this.maxMovementSpeed = maxMovementSpeed;
    }

    public Component getName() {
        return name;
    }

    public int getMinimumEnchantmentLevel() {
        return minimumEnchantmentLevel;
    }

    public int getMaximumEnchantmentLevel() {
        return maximumEnchantmentLevel;
    }

    public int getMinimumSockets() {
        return minimumSockets;
    }

    public int getMaximumSockets() {
        return maximumSockets;
    }

    public double getMinArmor() {
        return minArmor;
    }

    public double getMaxArmor() {
        return maxArmor;
    }

    public double getMinArmorToughness() {
        return minArmorToughness;
    }

    public double getMaxArmorToughness() {
        return maxArmorToughness;
    }

    public double getMinAttackSpeed() {
        return minAttackSpeed;
    }

    public double getMaxAttackSpeed() {
        return maxAttackSpeed;
    }

    public double getMinDamage() {
        return minDamage;
    }

    public double getMaxDamage() {
        return maxDamage;
    }

    public double getMinHealth() {
        return minHealth;
    }

    public double getMaxHealth() {
        return maxHealth;
    }

    public double getMinLuck() {
        return minLuck;
    }

    public double getMaxLuck() {
        return maxLuck;
    }

    public double getMinKnockbackResistance() {
        return minKnockbackResistance;
    }

    public double getMaxKnockbackResistance() {
        return maxKnockbackResistance;
    }

    public double getMinMovementSpeed() {
        return minMovementSpeed;
    }

    public double getMaxMovementSpeed() {
        return maxMovementSpeed;
    }
}
