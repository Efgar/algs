
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
    "ability",
    "damage",
    "damageType"
})
public class Save {

    @JsonProperty("ability")
    private String ability;
    @JsonProperty("damage")
    private String damage;
    @JsonProperty("damageType")
    private String damageType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ability")
    public String getAbility() {
        return ability;
    }

    @JsonProperty("ability")
    public void setAbility(String ability) {
        this.ability = ability;
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

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
