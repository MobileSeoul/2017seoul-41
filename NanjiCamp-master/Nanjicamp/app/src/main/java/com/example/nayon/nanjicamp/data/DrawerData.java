package com.example.nayon.nanjicamp.data;

/**
 * Created by nayong on 2017. 4. 17..
 */

public class DrawerData {
    private int viewType, fragPos, iconRes;
    private String title;

    public DrawerData(int viewType, int fragPos, int iconRes, String title) {
        this.viewType = viewType;
        this.fragPos = fragPos;
        this.iconRes = iconRes;
        this.title = title;
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public int getFragPos() {
        return fragPos;
    }

    public void setFragPos(int fragPos) {
        this.fragPos = fragPos;
    }

    public int getIconRes() {
        return iconRes;
    }

    public void setIconRes(int iconRes) {
        this.iconRes = iconRes;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
