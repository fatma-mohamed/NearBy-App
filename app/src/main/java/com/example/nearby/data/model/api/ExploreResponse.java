package com.example.nearby.data.model.api;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ExploreResponse {
    @SerializedName("totalResults")
    private Integer totalResults;

    @SerializedName("groups")
    private ArrayList<ExploreGroupResponse> groups;

    public ExploreResponse(Integer totalResults, ArrayList<ExploreGroupResponse> groups) {
        this.totalResults = totalResults;
        this.groups = groups;
    }

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public ArrayList<ExploreGroupResponse> getGroups() {
        return groups;
    }

    public void setGroups(ArrayList<ExploreGroupResponse> groups) {
        this.groups = groups;
    }
}
