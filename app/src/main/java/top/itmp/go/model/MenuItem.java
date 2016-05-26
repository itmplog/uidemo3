package top.itmp.go.model;

import java.util.ArrayList;

import top.itmp.go.dummy;

/**
 * Created by hz on 16/5/23.
 */
public class MenuItem {
    public ArrayList<String> dummys = dummy.dummys(5);

    private String title;
    private int resId;

    public MenuItem(String title, int resId) {
        this.title = title;
        this.resId = resId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getResourceId() {
        return resId;
    }

    public void setResourceId(int resId) {
        this.resId = resId;
    }

}
