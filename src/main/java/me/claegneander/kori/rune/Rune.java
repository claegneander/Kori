package me.claegneander.kori.rune;

import net.kyori.adventure.text.Component;
import org.bukkit.enchantments.EnchantmentTarget;

public class Rune {

    private final Component name;
    private final int minimumLevel, maximumLevel;

    public Rune(Component name, int minimumLevel, int maximumLevel, EnchantmentTarget target) {
        this.name = name;
        this.minimumLevel = minimumLevel;
        this.maximumLevel = maximumLevel;
    }

    public Component getName() {
        return name;
    }

    public int getMinimumLevel() {
        return minimumLevel;
    }

    public int getMaximumLevel() {
        return maximumLevel;
    }
}
