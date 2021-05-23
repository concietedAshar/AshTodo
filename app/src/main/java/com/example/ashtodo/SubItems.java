package com.example.ashtodo;

public class SubItems {
    String subItems;

    public SubItems() {
    }

    public SubItems(String subItems) {
        this.subItems = subItems;
    }

    public String getSubItems() {
        return subItems;
    }

    public void setSubItems(String subItems) {
        this.subItems = subItems;
    }

    @Override
    public String toString() {
        return "SubItems{" +
                "subItems='" + subItems + '\'' +
                '}';
    }
}
