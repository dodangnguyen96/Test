package com.example.teslocal.model;

public class upLoadFile {
    @JsonProperty("purpose")
    private String purpose;

    @JsonProperty("filename")
    private String filename;

    @JsonProperty("id")
    private String id;

    @JsonProperty("status")
    private String status;

    @JsonProperty("created_at")
    private long createdAt;

    @JsonProperty("updated_at")
    private long updatedAt;

    @JsonProperty("object")
    private String object;
}
