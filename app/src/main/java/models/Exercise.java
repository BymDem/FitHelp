package models;

import java.util.Date;
import java.util.List;

public class Exercise {

    private String name;
    private String type;
    private List<Set> setList;

    public Exercise(Exercise d)
    {
        name = d.name;
        type = d.type;
        setList = d.setList;

    }

    public Exercise(String n, String t, List<Set> set_list)
    {
        name = n;
        type = t;
        setList = set_list;
    }

    public String getName()
    {
        return name;
    }

    public String getType()
    {
        return type;
    }

    public List<Set> getSetList()
    {
        return setList;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setType(String t)
    {
        type = t;
    }

    public void setSetList(List<Set> set_list)
    {
        setList = set_list;
    }
}
