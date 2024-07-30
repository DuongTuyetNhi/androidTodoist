package enums;

public enum Color {
    BERRY_RED("Berry red"),
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    OLIVE_GREEN("Olive green"),
    LIME_GREEN("Lime green"),
    GREEN("Green"),
    MINT_GREEN("Mint green"),
    TEAL("Teal"),
    SKY_BLUE("Sky blue"),
    LIGHT_BLUE("Light blue"),
    BLUE("Blue"),
    GRAPE("Grape"),
    VIOLET("Violet"),
    LAVENDER("Lavender"),
    MAGENTA("Magenta"),
    SALMON("Salmon"),
    CHARCOAL("Charcoal"),
    GRAY("Gray"),
    TAUPE("Taupe");

    private final String color;

    Color(String color) {
        this.color = color;
    }
    public String getValueColor(){
        return color;
    }
}
