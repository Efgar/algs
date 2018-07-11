package com.efgh.dnd.cards.entities.business;

public enum Classes {
    BARBARIAN("Barbarian", "q", "class-barbarian"),
    BARD("Bard", "a", "class-bard"),
    CLERIC("Cleric", "blue", "class-cleric"),
    MONK("Monk", "d", "class-monk"),
    PALADIN("Paladin", "DarkGoldenrod", "class-paladin"),
    DRUID("Druid", "green", "class-druid"),
    RANGER("Ranger", "f", "class-ranger"),
    WIZARD("Wizard", "maroon", "class-wizard"),
    SORCERER("Sorcerer", "g", "class-sorcerer"),
    WARLOCK("Warlock", "purple", "class-warlock");

    private String name;
    private String icon;
    private String color;

    Classes(String name, String color, String icon){
        this.name = name;
        this.icon = icon;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public String getIcon() {
        return icon;
    }

    public String getColor() {
        return color;
    }

    public static Classes getClassByName(String className){
        for (Classes clas: Classes.values()) {
            if(clas.getName().equalsIgnoreCase(className)){
                return clas;
            }
        }
        System.out.println("NO CLASS NAMED " + className);
        return null;
    }
}
