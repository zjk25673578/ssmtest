package com.hanqi.model;

public class Sysmenu {
    private Integer ids;
    private String label;
    private String icon;
    private String url;
    private Integer parentid;

    public Integer getIds() {
        return ids;
    }

    public void setIds(Integer ids) {
        this.ids = ids;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    @Override
    public String toString() {
        return "Sysmenu{" +
                "ids=" + ids +
                ", label='" + label + '\'' +
                ", icon='" + icon + '\'' +
                ", parentid=" + parentid +
                '}';
    }
}
