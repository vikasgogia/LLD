package entities;

import entities.task.Task;

import java.util.List;

public class Sprint {

    private static int idCounter = 0;
    private int id;
    private String name;
    private int begin, end;

    public Sprint(String name, int begin, int end) {
        this.id = ++idCounter;
        this.name = name;
        this.begin = begin;
        this.end = end;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBegin() {
        return begin;
    }

    public void setBegin(int begin) {
        this.begin = begin;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
}
