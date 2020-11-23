package com.example;

public class Maintenance {
    private Extra extra;

    public Maintenance(Extra extra)
    {
        this.extra = extra;
        //type = extra.getType();
    }

    public double getCost() {

        if (extra.getType().equals("Oil change"))
        {
            return extra.getCost() + 45.00;
        }
        else if (extra.getType().equals("Tire Rotation"))
        {
            return extra.getCost() + 80.00;
        }
        else if (extra.getType().equals("Alignemnt"))
        {
            return extra.getCost() + 75.00;
        }
        return extra.getCost();
    }
}
