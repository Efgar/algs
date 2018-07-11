
package com.efgh.dnd.cards.entities.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "size",
    "type",
    "alignment",
    "AC",
    "HP",
    "speed",
    "strength",
    "dexterity",
    "constitution",
    "intelligence",
    "wisdom",
    "charisma",
    "savingThrows",
    "skills",
    "senses",
    "languages",
    "challenge",
    "traits",
    "actions",
    "legendaryPoints",
    "legendaryActions"
})
public class Monster {

    @JsonProperty("name")
    private String name;
    @JsonProperty("size")
    private String size;
    @JsonProperty("type")
    private String type;
    @JsonProperty("alignment")
    private String alignment;
    @JsonProperty("AC")
    private String aC;
    @JsonProperty("HP")
    private String hP;
    @JsonProperty("speed")
    private String speed;
    @JsonProperty("strength")
    private Integer strength;
    @JsonProperty("dexterity")
    private Integer dexterity;
    @JsonProperty("constitution")
    private Integer constitution;
    @JsonProperty("intelligence")
    private Integer intelligence;
    @JsonProperty("wisdom")
    private Integer wisdom;
    @JsonProperty("charisma")
    private Integer charisma;
    @JsonProperty("savingThrows")
    private String savingThrows;
    @JsonProperty("skills")
    private String skills;
    @JsonProperty("senses")
    private String senses;
    @JsonProperty("languages")
    private String languages;
    @JsonProperty("challenge")
    private String challenge;
    @JsonProperty("traits")
    private List<Trait> traits = null;
    @JsonProperty("actions")
    private List<Action> actions = null;
    @JsonProperty("legendaryPoints")
    private Integer legendaryPoints;
    @JsonProperty("legendaryActions")
    private List<LegendaryAction> legendaryActions = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("size")
    public String getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(String size) {
        this.size = size;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("alignment")
    public String getAlignment() {
        return alignment;
    }

    @JsonProperty("alignment")
    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }

    @JsonProperty("AC")
    public String getAC() {
        return aC;
    }

    @JsonProperty("AC")
    public void setAC(String aC) {
        this.aC = aC;
    }

    @JsonProperty("HP")
    public String getHP() {
        return hP;
    }

    @JsonProperty("HP")
    public void setHP(String hP) {
        this.hP = hP;
    }

    @JsonProperty("speed")
    public String getSpeed() {
        return speed;
    }

    @JsonProperty("speed")
    public void setSpeed(String speed) {
        this.speed = speed;
    }

    @JsonProperty("strength")
    public Integer getStrength() {
        return strength;
    }

    @JsonProperty("strength")
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    @JsonProperty("dexterity")
    public Integer getDexterity() {
        return dexterity;
    }

    @JsonProperty("dexterity")
    public void setDexterity(Integer dexterity) {
        this.dexterity = dexterity;
    }

    @JsonProperty("constitution")
    public Integer getConstitution() {
        return constitution;
    }

    @JsonProperty("constitution")
    public void setConstitution(Integer constitution) {
        this.constitution = constitution;
    }

    @JsonProperty("intelligence")
    public Integer getIntelligence() {
        return intelligence;
    }

    @JsonProperty("intelligence")
    public void setIntelligence(Integer intelligence) {
        this.intelligence = intelligence;
    }

    @JsonProperty("wisdom")
    public Integer getWisdom() {
        return wisdom;
    }

    @JsonProperty("wisdom")
    public void setWisdom(Integer wisdom) {
        this.wisdom = wisdom;
    }

    @JsonProperty("charisma")
    public Integer getCharisma() {
        return charisma;
    }

    @JsonProperty("charisma")
    public void setCharisma(Integer charisma) {
        this.charisma = charisma;
    }

    @JsonProperty("savingThrows")
    public String getSavingThrows() {
        return savingThrows;
    }

    @JsonProperty("savingThrows")
    public void setSavingThrows(String savingThrows) {
        this.savingThrows = savingThrows;
    }

    @JsonProperty("skills")
    public String getSkills() {
        return skills;
    }

    @JsonProperty("skills")
    public void setSkills(String skills) {
        this.skills = skills;
    }

    @JsonProperty("senses")
    public String getSenses() {
        return senses;
    }

    @JsonProperty("senses")
    public void setSenses(String senses) {
        this.senses = senses;
    }

    @JsonProperty("languages")
    public String getLanguages() {
        return languages;
    }

    @JsonProperty("languages")
    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @JsonProperty("challenge")
    public String getChallenge() {
        return challenge;
    }

    @JsonProperty("challenge")
    public void setChallenge(String challenge) {
        this.challenge = challenge;
    }

    @JsonProperty("traits")
    public List<Trait> getTraits() {
        return traits;
    }

    @JsonProperty("traits")
    public void setTraits(List<Trait> traits) {
        this.traits = traits;
    }

    @JsonProperty("actions")
    public List<Action> getActions() {
        return actions;
    }

    @JsonProperty("actions")
    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    @JsonProperty("legendaryPoints")
    public Integer getLegendaryPoints() {
        return legendaryPoints;
    }

    @JsonProperty("legendaryPoints")
    public void setLegendaryPoints(Integer legendaryPoints) {
        this.legendaryPoints = legendaryPoints;
    }

    @JsonProperty("legendaryActions")
    public List<LegendaryAction> getLegendaryActions() {
        return legendaryActions;
    }

    @JsonProperty("legendaryActions")
    public void setLegendaryActions(List<LegendaryAction> legendaryActions) {
        this.legendaryActions = legendaryActions;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
