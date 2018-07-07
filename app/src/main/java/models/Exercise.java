package models;

import java.util.Date;
import java.util.List;

public class Exercise {

    private String name;
    private String type;
    private int id;

    public Exercise(Exercise d)
    {
        name = d.name;
        type = d.type;
        id = d.id;

    }

    public Exercise(String n, String t, int i)
    {
        name = n;
        type = t;
        id = i;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setType(String t)
    {
        type = t;
    }

    public void setId(int i)
    {
        id = i;
    }
}
