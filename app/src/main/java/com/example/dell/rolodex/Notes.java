package com.example.dell.rolodex;

public class Notes {

    int id;
    String Notedescription;

    public Notes (int id, String Notedescription){
        this.id = id;
        this.Notedescription = Notedescription;
    }

    public Notes(){}

    public String getNotedescription() {
        return Notedescription;
    }

    public void setNotedescription(String notedescription) {
        Notedescription = notedescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
