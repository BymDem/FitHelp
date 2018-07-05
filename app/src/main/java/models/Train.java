package models;

import java.util.Date;
import java.util.List;

public class Train {

    private String name;
    private Date date;
    private List<Exercise> exerciseList;

    public Train(Train d)
    {
        name = d.name;
        date = d.date;
    }

    public Train(String n, Date d)
    {
        name = n;
        date = d;
    }

    public String getName()
    {
        return name;
    }

    public Date getDate()
    {
        return date;
    }

    public List<Exercise> getExerciseList()
    {
        return exerciseList;
    }

    public void setName(String n)
    {
        name = n;
    }

    public void setDate(Date d)
    {
        date = d;
    }

    public void setExerciseList(List<Exercise> exercise_list)
    {
        exerciseList = exercise_list;
    }
}
