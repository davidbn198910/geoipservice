package com.odav1d.geoservice.integration.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrencyApiResponse {

    private Meta meta;
    private Data data;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public static class Meta {
        @JsonProperty("last_updated_at")
        private String lastUpdatedAt;

        public String getLastUpdatedAt() {
            return lastUpdatedAt;
        }

        public void setLastUpdatedAt(String lastUpdatedAt) {
            this.lastUpdatedAt = lastUpdatedAt;
        }
    }

    public static class Data {
        @JsonProperty("USD")
        private Currency usd;

        public Currency getUsd() {
            return usd;
        }

        public void setUsd(Currency usd) {
            this.usd = usd;
        }
    }

    public static class Currency {
        private String code;
        private double value;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public double getValue() {
            return value;
        }

        public void setValue(double value) {
            this.value = value;
        }
    }
}
