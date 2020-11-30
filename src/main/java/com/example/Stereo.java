package com.example;

public class Stereo {
    private Extra extra;

    public Stereo(Extra extra)
    {
        this.extra = extra;
        //type = extra.getType();
    }

    public double getCost() {

        if (extra.getType().equals("Bose"))
        {
            return extra.getCost() + 450.00;
        }
        else if (extra.getType().equals("Pioneer"))
        {
            return extra.getCost() + 285.00;
        }
        else if (extra.getType().equals("Sony"))
        {
            return extra.getCost() + 300.00;
        }
        return extra.getCost();
    }
}
