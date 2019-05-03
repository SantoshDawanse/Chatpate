package com.dawnsoft.chatpate.model;


public class ChatpateItem {

    private String itemName;
    private boolean isChecked;
    private int itemAmount;

    public ChatpateItem(String itemName, boolean isChecked) {
        this.itemName = itemName;
        this.isChecked = isChecked;
    }

    public ChatpateItem(String itemName, int itemAmount) {
        this.itemName = itemName;
        this.itemAmount = itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public void setItemAmount(int itemAmount) {
        this.itemAmount = itemAmount;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
