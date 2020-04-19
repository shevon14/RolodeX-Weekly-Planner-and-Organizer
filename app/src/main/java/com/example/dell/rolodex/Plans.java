package com.example.dell.rolodex;

public class Plans {

    int id;
    String description;
    Integer hour;
    Integer minute;
    String soundmode;
    String sunday;
    String monday;
    String tuesday;
    String wednesday;
    String thursday;
    String friday;
    String saturday;
    String notifications;
    private boolean checked = false;

    public Plans(int id, String description, Integer hour, Integer minute, String soundmode, String sunday, String monday, String tuesday, String wednesday, String thursday, String friday, String saturday, String notifications){
        this.id = id;
        this.description = description;
        this.hour =hour;
        this.minute = minute;
        this.soundmode = soundmode;
        this.sunday = sunday;
        this.monday =monday;
        this.tuesday = tuesday;
        this.wednesday = wednesday;
        this.thursday = thursday;
        this.friday = friday;
        this.saturday = saturday;
        this.notifications = notifications;
    }

    public Plans(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSoundmode() {
        return soundmode;
    }

    public void setSoundmode(String soundmode) {
        this.soundmode = soundmode;
    }

    public int getId(long id) {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public String getSunday() {
        return sunday;
    }

    public boolean isChecked() {
        return checked;
    }
    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public void onItemSelected(int position) {
    }

    public void setSunday(String sunday) {
        this.sunday = sunday;
    }

    public String getMonday() {
        return monday;
    }

    public void setMonday(String monday) {
        this.monday = monday;
    }

    public String getTuesday() {
        return tuesday;
    }

    public void setTuesday(String tuesday) {
        this.tuesday = tuesday;
    }

    public String getWednesday() {
        return wednesday;
    }

    public void setWednesday(String wednesday) {
        this.wednesday = wednesday;
    }

    public String getThursday() {
        return thursday;
    }

    public void setThursday(String thursday) {
        this.thursday = thursday;
    }

    public String getFriday() {
        return friday;
    }

    public void setFriday(String friday) {
        this.friday = friday;
    }

    public String getSaturday() {
        return saturday;
    }

    public void setSaturday(String saturday) {
        this.saturday = saturday;
    }

    public String getNotifications() {
        return notifications;
    }

    public void setNotifications(String notifications) {
        this.notifications = notifications;
    }
}
