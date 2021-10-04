package com.example.starredgithubrepos.models;

public class Repository {
    private String RepoName;
    private String RepoDesc;
    private String repoOwner;
    private int starNumbers;

    public Repository(){}

    public Repository(String repoName, String repoDesc, String repoOwner, int starNumbers) {
        RepoName = repoName;
        RepoDesc = repoDesc;
        this.repoOwner = repoOwner;
        this.starNumbers = starNumbers;
    }

    public String getRepoName() {
        return RepoName;
    }

    public void setRepoName(String repoName) {
        RepoName = repoName;
    }

    public String getRepoDesc() {
        return RepoDesc;
    }

    public void setRepoDesc(String repoDesc) {
        RepoDesc = repoDesc;
    }

    public String getRepoOwner() {
        return repoOwner;
    }

    public void setRepoOwner(String repoOwner) {
        this.repoOwner = repoOwner;
    }

    public int getStarNumbers() {
        return starNumbers;
    }

    public void setStarNumbers(int starNumbers) {
        this.starNumbers = starNumbers;
    }
}
