
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
    "verbal",
    "somatic",
    "material",
    "materialMaterial"
})
public class Components {

    @JsonProperty("verbal")
    private Boolean verbal;
    @JsonProperty("somatic")
    private Boolean somatic;
    @JsonProperty("material")
    private Boolean material;
    @JsonProperty("materialMaterial")
    private String materialMaterial;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("verbal")
    public Boolean getVerbal() {
        return verbal;
    }

    @JsonProperty("verbal")
    public void setVerbal(Boolean verbal) {
        this.verbal = verbal;
    }

    @JsonProperty("somatic")
    public Boolean getSomatic() {
        return somatic;
    }

    @JsonProperty("somatic")
    public void setSomatic(Boolean somatic) {
        this.somatic = somatic;
    }

    @JsonProperty("material")
    public Boolean getMaterial() {
        return material;
    }

    @JsonProperty("material")
    public void setMaterial(Boolean material) {
        this.material = material;
    }

    @JsonProperty("materialMaterial")
    public String getMaterialMaterial() {
        return materialMaterial;
    }

    @JsonProperty("materialMaterial")
    public void setMaterialMaterial(String materialMaterial) {
        this.materialMaterial = materialMaterial;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public String getComponentBlockFormatted(){
        if(getVerbal() == null && getSomatic() == null && getMaterial() == null){
            return "";
        }
        String formattedText = "\"property | Components | " + (BooleanUtils.isTrue(getVerbal())?"V,":"") + (BooleanUtils.isTrue(getSomatic())?"S,":"") + (BooleanUtils.isTrue(getMaterial())?"M":"") + "\"";
        formattedText = formattedText.replace(",\"", "\"");
        formattedText += (getMaterialMaterial() != null ? ",\n\"property | Material component | " + getMaterialMaterial() + "\"" : "");
        return formattedText;
    }

}
