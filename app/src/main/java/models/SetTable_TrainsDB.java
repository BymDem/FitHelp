package models;

public class SetTable_TrainsDB {

    private int weight;
    private int number;

    public SetTable_TrainsDB(SetTable_TrainsDB d)
    {
        weight = d.weight;
        number = d.number;
    }

    public SetTable_TrainsDB(int w, int n)
    {
        weight = w;
        number = n;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getType()
    {
        return number;
    }

    public void setWeight(int w)
    {
        weight = w;
    }

    public void setNumber(int n)
    {
        number = n;
    }
}
