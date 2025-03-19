package OOP_NEW_YEAR.Second_Term.Day_05;

import java.util.Objects;

public class EventLog {
    private String[] events;
    private int currIndex;

    public EventLog(){
        this.events = new String[100];
        this.currIndex = 0;
    }

    public int getCurrIndex() {
        return currIndex;
    }

    public void setCurrIndex(int currIndex) {
        this.currIndex = currIndex;
    }

    public String[] getEvents() {
        return events;
    }

    public void setEvents(String[] events) {
        this.events = events;
    }

    public void addEvent(String event){
        this.getEvents()[this.getCurrIndex()] = event;
        this.setCurrIndex(this.getCurrIndex() + 1);
    }

    public void print(){
        for (String event : this.events){
            System.out.println(event);
        }
    }

    public void editEvent(int indexOfEvent, String newEvent) throws IndexException{
        if (Objects.equals(this.getEvents()[indexOfEvent], "")){
            throw  new IndexException();
        } else this.events[indexOfEvent] = newEvent;
    }

    public void removeEvent(int indexOfEvent){
        if (Objects.equals(this.getEvents()[indexOfEvent], "")){
            throw  new IndexException();
        } else  this.events[indexOfEvent] = "";
    }


}
