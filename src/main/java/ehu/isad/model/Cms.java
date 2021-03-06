package ehu.isad.model;

import javafx.scene.control.Hyperlink;

public class Cms  {
    private Hyperlink url;
    private String cms;
    private String version;
    private String lastUpdated;


    public Cms(String url, String cms, String version, String lastUpdated) {
        this.url = new Hyperlink(url);
        this.cms = cms;
        this.version = version;
        this.lastUpdated = lastUpdated;
    }


    public Hyperlink getUrl() { return url; }

    public String getCms() {
        return cms;
    }

    public String getVersion() {
        return version;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setUrl(String url) { this.url = new Hyperlink(url); }

    public void setCms(String cms) {
        this.cms = cms;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
