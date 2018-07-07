package models;

public class Set {

    private int weight;
    private int number;
    private int id;

    public Set(Set d)
    {
        weight = d.weight;
        number = d.number;
        id = d.id;
    }

    public Set(int w, int n, int i)
    {
        weight = w;
        number = n;
        id = i;
    }

    public int getWeight()
    {
        return weight;
    }

    public int getType()
    {
        return number;
    }

    public int getId(){
        return id;
    }

    public void setWeight(int w)
    {
        weight = w;
    }

    public void setNumber(int n)
    {
        number = n;
    }

    public void setId(int i)
    {
        id = i;
    }
}
