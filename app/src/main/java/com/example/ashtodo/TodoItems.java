package com.example.ashtodo;

import java.util.ArrayList;

public class TodoItems {
    int id;
    String title;
    String priority;
    String date;
    String time;
    ArrayList<String> subItems;
    String itemsConcatenate;

    public TodoItems() {
    }

    public TodoItems(int id, String title, String priority, String date, String time, ArrayList<String> subItems) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.subItems = subItems;

    }

    public TodoItems(int id, String title, String priority, String date, String time,
                     ArrayList<String> subItems, String itemsConcatenate) {
        this.id = id;
        this.title = title;
        this.priority = priority;
        this.date = date;
        this.time = time;
        this.subItems = subItems;
        this.itemsConcatenate = itemsConcatenate;
    }

    void concatenate(ArrayList<String> arrayList)
    {
        itemsConcatenate  = arrayList.get(0);
        for(int i = 1; i< arrayList.size(); i++)
        {
            itemsConcatenate += "," + arrayList.get(i);
        }
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

    public ArrayList<String> getSubItems() {
        return subItems;
    }

    public void setSubItems(ArrayList<String> subItems) {
        this.subItems = subItems;
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
