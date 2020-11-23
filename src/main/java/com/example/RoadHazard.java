package com.example;

public class RoadHazard {
    private Extra extra;

    public RoadHazard(Extra extra) {
        this.extra = extra;
        //type = extra.getType();
    }

    public double getCost() {

        if(extra.getType().equals("AAA"))
        {
            return extra.getCost() + 80.00;
        }
        else if (extra.getType().equals("Flat Tire"))
        {
            return extra.getCost() + 25.00;
        }
        else if (extra.getType().equals("Cracked Windshield"))
        {
            return extra.getCost() + 250.00;
        }
        return extra.getCost();

    }
}
