package models;

import java.util.Date;
import java.util.List;

public class ExerciseTable_TrainsDB {

    private String name;
    private String type;
    private List<SetTable_TrainsDB> setList;

    public ExerciseTable_TrainsDB(ExerciseTable_TrainsDB d)
    {
        name = d.name;
        type = d.type;
        setList = d.setList;

    }

    public ExerciseTable_TrainsDB(String n, String t, List<SetTable_TrainsDB> set_list)
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

    public List<SetTable_TrainsDB> getSetList()
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

    public void setSetList(List<SetTable_TrainsDB> set_list)
    {
        setList = set_list;
    }
}
