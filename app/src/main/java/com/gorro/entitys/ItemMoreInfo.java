package com.gorro.entitys;

/**
 * Created by gorro on 17/05/15.
 */
public class ItemMoreInfo {

    int resource;
    String title;

    public ItemMoreInfo(int resource, String title) {
        this.resource = resource;
        this.title = title;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
