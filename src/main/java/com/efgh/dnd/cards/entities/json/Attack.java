
package com.efgh.dnd.cards.entities.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "damage",
    "damageType",
    "secondaryDamage",
    "secondaryDamageType",
    "higherLevelDice",
    "higherLevelSecondaryDice"
})
public class Attack {

    @JsonProperty("type")
    private String type;
    @JsonProperty("damage")
    private String damage;
    @JsonProperty("damageType")
    private String damageType;
    @JsonProperty("secondaryDamage")
    private String secondaryDamage;
    @JsonProperty("secondaryDamageType")
    private String secondaryDamageType;
    @JsonProperty("higherLevelDice")
    private Integer higherLevelDice;
    @JsonProperty("higherLevelSecondaryDice")
    private Integer higherLevelSecondaryDice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("damage")
    public String getDamage() {
        return damage;
    }

    @JsonProperty("damage")
    public void setDamage(String damage) {
        this.damage = damage;
    }

    @JsonProperty("damageType")
    public String getDamageType() {
        return damageType;
    }

    @JsonProperty("damageType")
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    @JsonProperty("secondaryDamage")
    public String getSecondaryDamage() {
        return secondaryDamage;
    }

    @JsonProperty("secondaryDamage")
    public void setSecondaryDamage(String secondaryDamage) {
        this.secondaryDamage = secondaryDamage;
    }

    @JsonProperty("secondaryDamageType")
    public String getSecondaryDamageType() {
        return secondaryDamageType;
    }

    @JsonProperty("secondaryDamageType")
    public void setSecondaryDamageType(String secondaryDamageType) {
        this.secondaryDamageType = secondaryDamageType;
    }

    @JsonProperty("higherLevelDice")
    public Integer getHigherLevelDice() {
        return higherLevelDice;
    }

    @JsonProperty("higherLevelDice")
    public void setHigherLevelDice(Integer higherLevelDice) {
        this.higherLevelDice = higherLevelDice;
    }

    @JsonProperty("higherLevelSecondaryDice")
    public Integer getHigherLevelSecondaryDice() {
        return higherLevelSecondaryDice;
    }

    @JsonProperty("higherLevelSecondaryDice")
    public void setHigherLevelSecondaryDice(Integer higherLevelSecondaryDice) {
        this.higherLevelSecondaryDice = higherLevelSecondaryDice;
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
