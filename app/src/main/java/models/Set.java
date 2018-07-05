package models;

public class Set {

    private int weight;
    private int number;

    public Set(Set d)
    {
        weight = d.weight;
        number = d.number;
    }

    public Set(int w, int n)
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
