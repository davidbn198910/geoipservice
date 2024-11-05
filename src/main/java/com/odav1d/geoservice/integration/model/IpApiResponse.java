package com.odav1d.geoservice.integration.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class IpApiResponse {

    private String ip;
    private String type;
    private String continentCode;
    private String continentName;
    private String countryCode;
    private String countryName;
    private String regionCode;
    private String regionName;
    private String city;
    private String zip;
    private double latitude;
    private double longitude;
    private String msa;
    private String dma;
    private double radius;
    private String ipRoutingType;
    private String connectionType;
    private Location location;

    @JsonProperty("ip")
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("continent_code")
    public String getContinentCode() {
        return continentCode;
    }

    public void setContinentCode(String continentCode) {
        this.continentCode = continentCode;
    }

    @JsonProperty("continent_name")
    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("country_name")
    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @JsonProperty("region_code")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @JsonProperty("region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @JsonProperty("msa")
    public String getMsa() {
        return msa;
    }

    public void setMsa(String msa) {
        this.msa = msa;
    }

    @JsonProperty("dma")
    public String getDma() {
        return dma;
    }

    public void setDma(String dma) {
        this.dma = dma;
    }

    @JsonProperty("radius")
    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @JsonProperty("ip_routing_type")
    public String getIpRoutingType() {
        return ipRoutingType;
    }

    public void setIpRoutingType(String ipRoutingType) {
        this.ipRoutingType = ipRoutingType;
    }

    @JsonProperty("connection_type")
    public String getConnectionType() {
        return connectionType;
    }

    public void setConnectionType(String connectionType) {
        this.connectionType = connectionType;
    }

    @JsonProperty("location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public static class Location {

        private int geonameId;
        private String capital;
        private List<Language> languages;
        private String countryFlag;
        private String countryFlagEmoji;
        private String countryFlagEmojiUnicode;
        private String callingCode;
        private boolean isEu;

        @JsonProperty("geoname_id")
        public int getGeonameId() {
            return geonameId;
        }

        public void setGeonameId(int geonameId) {
            this.geonameId = geonameId;
        }

        @JsonProperty("capital")
        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        @JsonProperty("languages")
        public List<Language> getLanguages() {
            return languages;
        }

        public void setLanguages(List<Language> languages) {
            this.languages = languages;
        }

        @JsonProperty("country_flag")
        public String getCountryFlag() {
            return countryFlag;
        }

        public void setCountryFlag(String countryFlag) {
            this.countryFlag = countryFlag;
        }

        @JsonProperty("country_flag_emoji")
        public String getCountryFlagEmoji() {
            return countryFlagEmoji;
        }

        public void setCountryFlagEmoji(String countryFlagEmoji) {
            this.countryFlagEmoji = countryFlagEmoji;
        }

        @JsonProperty("country_flag_emoji_unicode")
        public String getCountryFlagEmojiUnicode() {
            return countryFlagEmojiUnicode;
        }

        public void setCountryFlagEmojiUnicode(String countryFlagEmojiUnicode) {
            this.countryFlagEmojiUnicode = countryFlagEmojiUnicode;
        }

        @JsonProperty("calling_code")
        public String getCallingCode() {
            return callingCode;
        }

        public void setCallingCode(String callingCode) {
            this.callingCode = callingCode;
        }

        @JsonProperty("is_eu")
        public boolean isEu() {
            return isEu;
        }

        public void setEu(boolean isEu) {
            this.isEu = isEu;
        }
    }

    public static class Language {

        private String code;
        private String name;
        private String nativeName;

        @JsonProperty("code")
        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        @JsonProperty("name")
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @JsonProperty("native")
        public String getNativeName() {
            return nativeName;
        }

        public void setNativeName(String nativeName) {
            this.nativeName = nativeName;
        }
    }
}
