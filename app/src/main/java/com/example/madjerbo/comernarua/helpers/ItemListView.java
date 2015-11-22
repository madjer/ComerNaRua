package com.example.madjerbo.comernarua.helpers;

/**
 * Created by madjerbo on 11/15/15.
 */
public class ItemListView {
    private String title;
    private int iconeRid;
    private String desc;
    private boolean open;

    public ItemListView() {
        this("", -1, "", false);
    }
    public ItemListView(String texto, int iconeRid, String textoDesc, boolean open) {
        this.title = texto;
        this.iconeRid = iconeRid;
        this.desc = textoDesc;
        this.open = open;
    }
    public int getIconeRid() {
        return iconeRid;
    }
    public void setIconeRid(int iconeRid) {
        this.iconeRid = iconeRid;
    }
    public String getTitle() {
        return title;
    }
    public String getDesc() {
        return desc;
    }
    public void setOpen(boolean value){
        open = value;
    }
    public boolean getOpen() {
        return open;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setTitle(String texto) {
        this.title = texto;
    }
}

