package models;

import java.util.Date;
import java.util.List;

public class Train {

    private String name;
    private Date date;
    private int id;


    public Train()
    {

    }
    public Train(Train d)
    {
        name = d.name;
        date = d.date;
        id = d.id;
    }

    public Train(String n, Date d, int i)
    {
        name = n;
        date = d;
        id = i;
    }

    public String getName()
    {
        return name;
    }

    public Date getDate()
    {
        return date;
    }

    public int getId()
    {
        return id;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setDate(Date d)
    {
        date = d;
    }

    public void setId(int i)
    {
        id = i;
    }
}
