package com.luischacon.asteroidsinfo.db.entities;

import java.util.Map;

public class EstimatedDiameter {
    private Map<?,?> kilometers;
    private Map<?,?> meters;
    private Map<?,?> miles;
    private Map<?,?> feet;

    public Map<?,?> getMeters() {
        return meters;
    }

    @Override
    public String toString() {
        return "EstimatedDiameter{" +
                "kilometers=" + kilometers +
                ", meters=" + meters +
                ", miles=" + miles +
                ", feet=" + feet +
                '}';
    }
}
