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
        "_id",
        "Scores",
        "AddressLine2",
        "SchemeType",
        "BusinessTypeID",
        "LocalAuthorityEmailAddress",
        "LocalAuthorityName",
        "RatingDate",
        "AddressLine1",
        "PostCode",
        "NewRatingPending",
        "BusinessType",
        "FHRSID",
        "LocalAuthorityBusinessID",
        "LocalAuthorityCode",
        "RatingKey",
        "LocalAuthorityWebSite",
        "BusinessName",
        "RatingValue",
        "Geocode"
})
public class Establishment {

    @JsonProperty("_id")
    private String Id;
    @JsonProperty("Scores")
    private Scores Scores;
    @JsonProperty("AddressLine2")
    private String AddressLine2;
    @JsonProperty("SchemeType")
    private String SchemeType;
    @JsonProperty("BusinessTypeID")
    private Integer BusinessTypeID;
    @JsonProperty("LocalAuthorityEmailAddress")
    private String LocalAuthorityEmailAddress;
    @JsonProperty("LocalAuthorityName")
    private String LocalAuthorityName;
    @JsonProperty("RatingDate")
    private String RatingDate;
    @JsonProperty("AddressLine1")
    private String AddressLine1;
    @JsonProperty("PostCode")
    private String PostCode;
    @JsonProperty("NewRatingPending")
    private Boolean NewRatingPending;
    @JsonProperty("BusinessType")
    private String BusinessType;
    @JsonProperty("FHRSID")
    private String FHRSID;
    @JsonProperty("LocalAuthorityBusinessID")
    private String LocalAuthorityBusinessID;
    @JsonProperty("LocalAuthorityCode")
    private Integer LocalAuthorityCode;
    @JsonProperty("RatingKey")
    private String RatingKey;
    @JsonProperty("LocalAuthorityWebSite")
    private String LocalAuthorityWebSite;
    @JsonProperty("BusinessName")
    private String BusinessName;
    @JsonProperty("RatingValue")
    private String RatingValue;
    @JsonProperty("Geocode")
    private Geocode Geocode;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     *
     * @return
     * The Id
     */
    @JsonProperty("_id")
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    @JsonProperty("_id")
    public void setId(String Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     * The Scores
     */
    @JsonProperty("Scores")
    public Scores getScores() {
        return Scores;
    }

    /**
     *
     * @param Scores
     * The Scores
     */
    @JsonProperty("Scores")
    public void setScores(Scores Scores) {
        this.Scores = Scores;
    }

    /**
     *
     * @return
     * The AddressLine2
     */
    @JsonProperty("AddressLine2")
    public String getAddressLine2() {
        return AddressLine2;
    }

    /**
     *
     * @param AddressLine2
     * The AddressLine2
     */
    @JsonProperty("AddressLine2")
    public void setAddressLine2(String AddressLine2) {
        this.AddressLine2 = AddressLine2;
    }

    /**
     *
     * @return
     * The SchemeType
     */
    @JsonProperty("SchemeType")
    public String getSchemeType() {
        return SchemeType;
    }

    /**
     *
     * @param SchemeType
     * The SchemeType
     */
    @JsonProperty("SchemeType")
    public void setSchemeType(String SchemeType) {
        this.SchemeType = SchemeType;
    }

    /**
     *
     * @return
     * The BusinessTypeID
     */
    @JsonProperty("BusinessTypeID")
    public Integer getBusinessTypeID() {
        return BusinessTypeID;
    }

    /**
     *
     * @param BusinessTypeID
     * The BusinessTypeID
     */
    @JsonProperty("BusinessTypeID")
    public void setBusinessTypeID(Integer BusinessTypeID) {
        this.BusinessTypeID = BusinessTypeID;
    }

    /**
     *
     * @return
     * The LocalAuthorityEmailAddress
     */
    @JsonProperty("LocalAuthorityEmailAddress")
    public String getLocalAuthorityEmailAddress() {
        return LocalAuthorityEmailAddress;
    }

    /**
     *
     * @param LocalAuthorityEmailAddress
     * The LocalAuthorityEmailAddress
     */
    @JsonProperty("LocalAuthorityEmailAddress")
    public void setLocalAuthorityEmailAddress(String LocalAuthorityEmailAddress) {
        this.LocalAuthorityEmailAddress = LocalAuthorityEmailAddress;
    }

    /**
     *
     * @return
     * The LocalAuthorityName
     */
    @JsonProperty("LocalAuthorityName")
    public String getLocalAuthorityName() {
        return LocalAuthorityName;
    }

    /**
     *
     * @param LocalAuthorityName
     * The LocalAuthorityName
     */
    @JsonProperty("LocalAuthorityName")
    public void setLocalAuthorityName(String LocalAuthorityName) {
        this.LocalAuthorityName = LocalAuthorityName;
    }

    /**
     *
     * @return
     * The RatingDate
     */
    @JsonProperty("RatingDate")
    public String getRatingDate() {
        return RatingDate;
    }

    /**
     *
     * @param RatingDate
     * The RatingDate
     */
    @JsonProperty("RatingDate")
    public void setRatingDate(String RatingDate) {
        this.RatingDate = RatingDate;
    }

    /**
     *
     * @return
     * The AddressLine1
     */
    @JsonProperty("AddressLine1")
    public String getAddressLine1() {
        return AddressLine1;
    }

    /**
     *
     * @param AddressLine1
     * The AddressLine1
     */
    @JsonProperty("AddressLine1")
    public void setAddressLine1(String AddressLine1) {
        this.AddressLine1 = AddressLine1;
    }

    /**
     *
     * @return
     * The PostCode
     */
    @JsonProperty("PostCode")
    public String getPostCode() {
        return PostCode;
    }

    /**
     *
     * @param PostCode
     * The PostCode
     */
    @JsonProperty("PostCode")
    public void setPostCode(String PostCode) {
        this.PostCode = PostCode;
    }

    /**
     *
     * @return
     * The NewRatingPending
     */
    @JsonProperty("NewRatingPending")
    public Boolean getNewRatingPending() {
        return NewRatingPending;
    }

    /**
     *
     * @param NewRatingPending
     * The NewRatingPending
     */
    @JsonProperty("NewRatingPending")
    public void setNewRatingPending(Boolean NewRatingPending) {
        this.NewRatingPending = NewRatingPending;
    }

    /**
     *
     * @return
     * The BusinessType
     */
    @JsonProperty("BusinessType")
    public String getBusinessType() {
        return BusinessType;
    }

    /**
     *
     * @param BusinessType
     * The BusinessType
     */
    @JsonProperty("BusinessType")
    public void setBusinessType(String BusinessType) {
        this.BusinessType = BusinessType;
    }

    /**
     *
     * @return
     * The FHRSID
     */
    @JsonProperty("FHRSID")
    public String getFHRSID() {
        return FHRSID;
    }

    /**
     *
     * @param FHRSID
     * The FHRSID
     */
    @JsonProperty("FHRSID")
    public void setFHRSID(String FHRSID) {
        this.FHRSID = FHRSID;
    }

    /**
     *
     * @return
     * The LocalAuthorityBusinessID
     */
    @JsonProperty("LocalAuthorityBusinessID")
    public String getLocalAuthorityBusinessID() {
        return LocalAuthorityBusinessID;
    }

    /**
     *
     * @param LocalAuthorityBusinessID
     * The LocalAuthorityBusinessID
     */
    @JsonProperty("LocalAuthorityBusinessID")
    public void setLocalAuthorityBusinessID(String LocalAuthorityBusinessID) {
        this.LocalAuthorityBusinessID = LocalAuthorityBusinessID;
    }

    /**
     *
     * @return
     * The LocalAuthorityCode
     */
    @JsonProperty("LocalAuthorityCode")
    public Integer getLocalAuthorityCode() {
        return LocalAuthorityCode;
    }

    /**
     *
     * @param LocalAuthorityCode
     * The LocalAuthorityCode
     */
    @JsonProperty("LocalAuthorityCode")
    public void setLocalAuthorityCode(Integer LocalAuthorityCode) {
        this.LocalAuthorityCode = LocalAuthorityCode;
    }

    /**
     *
     * @return
     * The RatingKey
     */
    @JsonProperty("RatingKey")
    public String getRatingKey() {
        return RatingKey;
    }

    /**
     *
     * @param RatingKey
     * The RatingKey
     */
    @JsonProperty("RatingKey")
    public void setRatingKey(String RatingKey) {
        this.RatingKey = RatingKey;
    }

    /**
     *
     * @return
     * The LocalAuthorityWebSite
     */
    @JsonProperty("LocalAuthorityWebSite")
    public String getLocalAuthorityWebSite() {
        return LocalAuthorityWebSite;
    }

    /**
     *
     * @param LocalAuthorityWebSite
     * The LocalAuthorityWebSite
     */
    @JsonProperty("LocalAuthorityWebSite")
    public void setLocalAuthorityWebSite(String LocalAuthorityWebSite) {
        this.LocalAuthorityWebSite = LocalAuthorityWebSite;
    }

    /**
     *
     * @return
     * The BusinessName
     */
    @JsonProperty("BusinessName")
    public String getBusinessName() {
        return BusinessName;
    }

    /**
     *
     * @param BusinessName
     * The BusinessName
     */
    @JsonProperty("BusinessName")
    public void setBusinessName(String BusinessName) {
        this.BusinessName = BusinessName;
    }

    /**
     *
     * @return
     * The RatingValue
     */
    @JsonProperty("RatingValue")
    public String getRatingValue() {
        return RatingValue;
    }

    /**
     *
     * @param RatingValue
     * The RatingValue
     */
    @JsonProperty("RatingValue")
    public void setRatingValue(String RatingValue) {
        this.RatingValue = RatingValue;
    }

    /**
     *
     * @return
     * The Geocode
     */
    @JsonProperty("Geocode")
    public Geocode getGeocode() {
        return Geocode;
    }

    /**
     *
     * @param Geocode
     * The Geocode
     */
    @JsonProperty("Geocode")
    public void setGeocode(Geocode Geocode) {
        this.Geocode = Geocode;
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
