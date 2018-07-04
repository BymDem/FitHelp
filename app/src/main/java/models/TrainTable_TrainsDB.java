package models;

import java.util.Date;
import java.util.List;

public class TrainTable_TrainsDB {

    private String name;
    private Date date;
    private List<ExerciseTable_TrainsDB> exerciseList;

    public TrainTable_TrainsDB(TrainTable_TrainsDB d)
    {
        name = d.name;
        date = d.date;
    }

    public TrainTable_TrainsDB(String n, Date d)
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

    public List<ExerciseTable_TrainsDB> getExerciseList()
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

    public void setExerciseList(List<ExerciseTable_TrainsDB> exercise_list)
    {
        exerciseList = exercise_list;
    }
}
