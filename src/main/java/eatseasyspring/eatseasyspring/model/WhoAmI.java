package eatseasyspring.eatseasyspring.model;


public class WhoAmI {
    private int majorApiVersion;
    private int minorApiVersion;
    private int buildApiVersion;

    public WhoAmI() {
        this.majorApiVersion = -1;
        this.minorApiVersion = -1;
        this.buildApiVersion = -1;
    }

    public WhoAmI(int majorApiVersion, int minorApiVersion, int buildApiVersion) {
        this.majorApiVersion = majorApiVersion;
        this.minorApiVersion = minorApiVersion;
        this.buildApiVersion = buildApiVersion;
    }

    public int getMajorApiVersion() {
        return majorApiVersion;
    }

    public void setMajorApiVersion(int majorApiVersion) {
        this.majorApiVersion = majorApiVersion;
    }

    public int getMinorApiVersion() {
        return minorApiVersion;
    }

    public void setMinorApiVersion(int minorApiVersion) {
        this.minorApiVersion = minorApiVersion;
    }

    public int getBuildApiVersion() {
        return buildApiVersion;
    }

    public void setBuildApiVersion(int buildApiVersion) {
        this.buildApiVersion = buildApiVersion;
    }

    @Override
    public String toString() {
        return majorApiVersion + "." + minorApiVersion + "." + buildApiVersion;
    }
}
