package oops.inheritance.basic_experiments.composition_2;

import java.util.*;
class House {
    private List<Room> rooms;

    public House() {
        rooms = new ArrayList<>();  //tightly coupled 
        rooms.add(new Room("Living Room"));
        rooms.add(new Room("Bedroom"));
    }
}

class Room {
    private String name;

    public Room(String name) {
        this.name = name;
    }
}

