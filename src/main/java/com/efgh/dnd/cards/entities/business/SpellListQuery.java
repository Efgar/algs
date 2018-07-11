package com.efgh.dnd.cards.entities.business;

public class SpellListQuery {
    private String className;
    private String archetypeName;
    private int minLevel;
    private int maxLevel;

    public SpellListQuery(){
        setMinLevel(0);
        setMaxLevel(0);
    }

    public SpellListQuery(String className, String archetypeName){
        setMinLevel(0);
        setMaxLevel(0);
        setClassName(className);
        setArchetypeName(archetypeName);
    }

    public SpellListQuery(String className, String archetypeName, int minLevel, int maxLevel){
        setMinLevel(minLevel);
        setMaxLevel(maxLevel);
        setClassName(className);
        setArchetypeName(archetypeName);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getArchetypeName() {
        return archetypeName;
    }

    public void setArchetypeName(String archetypeName) {
        this.archetypeName = archetypeName;
    }

    public int getMinLevel() {
        return minLevel;
    }

    public void setMinLevel(int minLevel) {
        this.minLevel = minLevel;
    }

    public int getMaxLevel() {
        return maxLevel;
    }

    public void setMaxLevel(int maxLevel) {
        this.maxLevel = maxLevel;
    }
}
