package com.example.establishmentdatamodel;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
"Hygiene",
"Structural",
"ConfidenceInManagement"
})
public class Scores {

@JsonProperty("Hygiene")
private Integer Hygiene;
@JsonProperty("Structural")
private Integer Structural;
@JsonProperty("ConfidenceInManagement")
private Integer ConfidenceInManagement;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

/**
*
* @return
* The Hygiene
*/
@JsonProperty("Hygiene")
public Integer getHygiene() {
return Hygiene;
}

/**
*
* @param Hygiene
* The Hygiene
*/
@JsonProperty("Hygiene")
public void setHygiene(Integer Hygiene) {
this.Hygiene = Hygiene;
}

/**
*
* @return
* The Structural
*/
@JsonProperty("Structural")
public Integer getStructural() {
return Structural;
}

/**
*
* @param Structural
* The Structural
*/
@JsonProperty("Structural")
public void setStructural(Integer Structural) {
this.Structural = Structural;
}

/**
*
* @return
* The ConfidenceInManagement
*/
@JsonProperty("ConfidenceInManagement")
public Integer getConfidenceInManagement() {
return ConfidenceInManagement;
}

/**
*
* @param ConfidenceInManagement
* The ConfidenceInManagement
*/
@JsonProperty("ConfidenceInManagement")
public void setConfidenceInManagement(Integer ConfidenceInManagement) {
this.ConfidenceInManagement = ConfidenceInManagement;
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
