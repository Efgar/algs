
package com.efgh.dnd.cards.entities.json;

import java.util.ArrayList;
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
    "archetypes",
    "spells"
})
public class Class {

    @JsonProperty("name")
    private String name;
    @JsonProperty("archetypes")
    private List<Archetype> archetypes = new ArrayList<>();
    @JsonProperty("spells")
    private List<String> spells = new ArrayList<>();
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

    @JsonProperty("archetypes")
    public List<Archetype> getArchetypes() {
        return archetypes;
    }

    @JsonProperty("archetypes")
    public void setArchetypes(List<Archetype> archetypes) {
        this.archetypes = archetypes;
    }

    @JsonProperty("spells")
    public List<String> getSpells() {
        return spells;
    }

    @JsonProperty("spells")
    public void setSpells(List<String> spells) {
        this.spells = spells;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public void merge(Class classToAdd) {
        getSpells().addAll(classToAdd.getSpells());
        for (Archetype archetypeToAdd: classToAdd.getArchetypes()) {
            Archetype aux = getArchetypeByName(archetypeToAdd.getName());
            if(aux == null){
                getArchetypes().add(archetypeToAdd);
            }else{
                aux.merge(archetypeToAdd);
            }
        }
    }

    public Archetype getArchetypeByName(String archetypeName){
        return getArchetypes().parallelStream().filter( archetype -> archetype.getName().equalsIgnoreCase(archetypeName)).findFirst().orElse(null);
    }
}
