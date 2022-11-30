package me.claegneander.kori.rune;

import me.claegneander.kori.rune.Rune;
import me.claegneander.kori.rune.armor.Angelic_Grace;
import me.claegneander.kori.rune.armor.Bulwark;
import me.claegneander.kori.rune.weapons.Decapitate;
import me.claegneander.kori.rune.weapons.Lightning;
import me.claegneander.kori.rune.weapons.Vampirism;

import java.util.ArrayList;
import java.util.List;

public class Runes {
    /* This is our manager class for all of our runes. */

    private final List<Rune> runes;
    public static final Angelic_Grace ANGELIC_GRACE = new Angelic_Grace();
    public static final Bulwark BULWARK = new Bulwark();
    public static final Decapitate DECAPITATE = new Decapitate();
    public static final Lightning LIGHTNING = new Lightning();
    public static final Vampirism VAMPIRISM = new Vampirism();

    public Runes() {
        runes = new ArrayList<>();
        runes.add(BULWARK);
        runes.add(DECAPITATE);
        runes.add(LIGHTNING);
        runes.add(VAMPIRISM);
    }
    public List<Rune> getRunes() {
        return runes;
    }
}
