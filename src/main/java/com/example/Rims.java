package com.example;

public class Rims {
    private Extra extra;

    public Rims(Extra extra) {
        this.extra = extra;
       
        //type = extra.getType();
    }

    public double getCost() {

        if(extra.getType().equals("BBS"))
        {
            return extra.getCost() + 395.00;
        }
        else if (extra.getType().equals("Enkei"))
        {
            return extra.getCost() + 410.00;
        }
        else if (extra.getType().equals("Konig Crown"))
        {
            return extra.getCost() + 450.00;
        }
        return extra.getCost();

    }
}
