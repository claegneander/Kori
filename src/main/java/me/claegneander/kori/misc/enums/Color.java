package me.claegneander.kori.misc.enums;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public enum Color {
    /* These are colors we use for general stuff. */
    DEFAULT("#999999"),
    INFO("#F7EA4A"),
    ERROR("#9A2A2A"),
    SUCCESS("#28DD86"),
    /* These are the colors for our rarities. */
    COMMON("#646464"),
    UNCOMMON("#455A64"),
    RARE("#1565C5"),
    EPIC("#982FAA"),
    FABLE("#D43A37"),
    MYTHIC("#DC540C"),
    RELIC("#EC980C"),
    LEGENDARY("#EFE05A"),
    TRANSCENDENT("#88BA4E"),
    GODLY("#2F7833"),
    /* These are some basic light, standard and dark colors. */
    LIGHT_RED("#FF4F4B"),
    RED("#890F0D"),
    DARK_RED("#630606"),
    LIGHT_GREEN("#9FE2BF"),
    GREEN("#68B984"),
    DARK_GREEN("#3D5656"),
    LIGHT_BLUE("#A3BBDB"),
    BLUE("#2146C7"),
    DARK_BLUE("#0008C1"),
    LIGHT_PURPLE("#DABAFF"),
    PURPLE("#3C1A7D"),
    DARK_PURPLE("#3D1365"),
    LIGHT_PINK("#FFD6EC"),
    PINK("#FFA1CF"),
    DARK_PINK("#FF74B1"),
    LIGHT_YELLOW("#FFF38C"),
    YELLOW("#F0E161"),
    DARK_YELLOW("#D9CB50"),
    LIGHT_ORANGE("#FFD8A9"),
    ORANGE("#F1A661"),
    DARK_ORANGE("#E38B29"),
    LIGHT_BROWN("#603601"),
    BROWN("#361500"),
    DARK_BROWN("#1C0A00"),
    LIGHT_GRAY("#AAAAAA"),
    GRAY("#7E7E7E"),
    DARK_GRAY("#616161"),
    ;

    private final String HEX;

    Color(String hex){
        this.HEX = hex;
    }
    public static String getRandomColor(){
        List<String> colors = new ArrayList<>();
        for(Color c : Color.values()){
            colors.add(c.getHEX());
        }
        Random random = new Random();
        int x = random.nextInt(colors.size());
        return colors.get(x);
    }
    public String getHEX(){
        return HEX;
    }
}
