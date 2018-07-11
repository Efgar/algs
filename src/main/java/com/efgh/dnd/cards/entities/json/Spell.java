
package com.efgh.dnd.cards.entities.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang3.BooleanUtils;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "name",
    "newName",
    "level",
    "school",
    "castingTime",
    "range",
    "components",
    "duration",
    "description",
    "higherLevel",
    "emote",
        "concentration",
    "attack",
    "save"
})
public class Spell {

    @JsonProperty("name")
    private String name;
    @JsonProperty("newName")
    private String newName;
    @JsonProperty("level")
    private Integer level;
    @JsonProperty("school")
    private String school;
    @JsonProperty("castingTime")
    private String castingTime;
    @JsonProperty("range")
    private String range;
    @JsonProperty("components")
    private Components components;
    @JsonProperty("duration")
    private String duration;
    @JsonProperty("description")
    private String description;
    @JsonProperty("higherLevel")
    private String higherLevel;
    @JsonProperty("emote")
    private String emote;
    @JsonProperty("concentration")
    private Boolean concentration;
    @JsonProperty("attack")
    private Attack attack;
    @JsonProperty("save")
    private Save save;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnore
    private String cardIcon = "robe";
    @JsonIgnore
    private String cardColor = "maroon";

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("newName")
    public String getNewName() {
        return newName;
    }

    @JsonProperty("newName")
    public void setNewName(String newName) {
        this.newName = newName;
    }

    @JsonProperty("level")
    public Integer getLevel() {
        return level;
    }

    @JsonProperty("level")
    public void setLevel(Integer level) {
        this.level = level;
    }

    @JsonProperty("school")
    public String getSchool() {
        return school;
    }

    @JsonProperty("school")
    public void setSchool(String school) {
        this.school = school;
    }

    @JsonProperty("castingTime")
    public String getCastingTime() {
        return castingTime;
    }

    @JsonProperty("castingTime")
    public void setCastingTime(String castingTime) {
        this.castingTime = castingTime;
    }

    @JsonProperty("range")
    public String getRange() {
        return range;
    }

    @JsonProperty("range")
    public void setRange(String range) {
        this.range = range;
    }

    @JsonProperty("components")
    public Components getComponents() {
        return components;
    }

    @JsonProperty("components")
    public void setComponents(Components components) {
        this.components = components;
    }

    @JsonProperty("duration")
    public String getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(String duration) {
        this.duration = duration;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("higherLevel")
    public String getHigherLevel() {
        return higherLevel;
    }

    @JsonProperty("higherLevel")
    public void setHigherLevel(String higherLevel) {
        this.higherLevel = higherLevel;
    }

    @JsonProperty("emote")
    public String getEmote() {
        return emote;
    }

    @JsonProperty("emote")
    public void setEmote(String emote) {
        this.emote = emote;
    }

    @JsonProperty("concentration")
    public Boolean getConcentration() {
        return concentration;
    }

    @JsonProperty("concentration")
    public String getConcentrationFormatted() {
        return BooleanUtils.isTrue(getConcentration())?" (Concentration)":"";
    }

    @JsonProperty("concentration")
    public void setConcentration(Boolean concentration) {
        this.concentration = concentration;
    }

    @JsonProperty("attack")
    public Attack getAttack() {
        return attack;
    }

    @JsonProperty("attack")
    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    @JsonProperty("save")
    public Save getSave() {
        return save;
    }

    @JsonProperty("save")
    public void setSave(Save save) {
        this.save = save;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getCardIcon() {
        return cardIcon;
    }

    public void setCardIcon(String cardIcon) {
        this.cardIcon = cardIcon;
    }

    public String getCardColor() {
        return cardColor;
    }

    public void setCardColor(String cardColor) {
        this.cardColor = cardColor;
    }



    public String getSpellFormat(){
        String formattedSpell = "{\n" +
                "  \"count\": 1,\n" +
                "  \"color\": \""+getCardColor()+"\",\n" +
                "  \"title\": \"" + getName() + "\",\n" +
                "  \"icon\": \"white-book-" + getLevel() + "\",\n" +
                "  \"icon_back\": \""+getCardIcon()+"\",\n" +
                "  \"contents\": [\n" +
                "    \"subtitle | " + getSchool() + "\",\n" +
                "    \"rule\",\n" +
                "    \"property | Casting time | " + getCastingTime() + "\",\n" +
                "    \"property | Duration | " + getDuration() + getConcentrationFormatted() + "\",\n" +
                "    \"property | Range | " + getRange() + "\",\n" +
                "    " + getComponents().getComponentBlockFormatted() + "," +
                "    \"rule\",\n" +
                "    " + getFormattedLongText(getDescription()) + "," +
                "    \"fill | 1\"\n" +
                "    " + getAtHigherLevelFormatted() +
                "  ],\n" +
                "  \"tags\": [\n" +
                "    \"spell\",\n" +
                "    \"" + getSchool() + "\"\n" +
                "  ]\n" +
                "}";
        return formattedSpell;
    }

    private String getAtHigherLevelFormatted(){
        String formattedText = "";
        if(getHigherLevel() != null){
            formattedText = "    ,\"section | At higher levels\",\n" +
                    getFormattedLongText(getHigherLevel());
        }
        return formattedText;
    }

    private String getFormattedLongText(String textToFormat){
        if(textToFormat == null){
            return "";
        }
        return "\"text | " + textToFormat.replace("\n", "\",\n    \"text | ") + "\"\n";
    }

}
