package com.example.ashtodo;

import java.util.ArrayList;

public class TodoItems {
    int id;
    String title;
    String priority;
    String date;
    String time;
    ArrayList<SubItems> subItems;
    String itemsConcatenate;

    public TodoItems() {
    }

    public TodoItems(String title, String priority, String date, String time, ArrayList<SubItems> subItems ) {
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.subItems = subItems;

    }

    public TodoItems(int id, String title, String priority, String date, String time, ArrayList<SubItems> subItems) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.subItems = subItems;
        this.itemsConcatenate = concatenate(subItems);

    }

    public TodoItems(int id, String title, String priority, String date, String time,
                     ArrayList<SubItems> subItems, String itemsConcatenate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.subItems = subItems;
        this.itemsConcatenate = itemsConcatenate;
    }

    public static String concatenate(ArrayList<SubItems> arrayList)
    {
       SubItems  itemsConcatenate  = arrayList.get(0);
       String con = null;
       for(int i = 1; i< arrayList.size(); i++)
        {
            con = itemsConcatenate +  "," + arrayList.get(i);
        }

        return con;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<SubItems> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<SubItems> subItems) {
        this.subItems = subItems;
    }

    public String getItemsConcatenate() {
        return itemsConcatenate;
    }

    public void setItemsConcatenate(String itemsConcatenate) {
        this.itemsConcatenate = itemsConcatenate;
    }

    @Override
    public String toString() {
        return "TodoItems{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", priority='" + priority + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", subItems=" + subItems +
                '}';
    }
}
