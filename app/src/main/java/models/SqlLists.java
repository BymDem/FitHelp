package models;

import java.util.ArrayList;
import java.util.List;

public class SqlLists {
        public ArrayList<String> TrainSql = new ArrayList<String>();
        public ArrayList<String> DietSql = new ArrayList<String>();
        public ArrayList<String> MeasSql = new ArrayList<String>();

        public SqlLists()
        {
            createTrainList();
            createDietList();
            createMeasList();

        }

        private void createTrainList()
        {
            //-- Таблица: Exercise
            TrainSql.add("CREATE TABLE Exercise (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, train_id INTEGER REFERENCES Train (id));");
            //-- Таблица: ExerciseName
            TrainSql.add("CREATE TABLE ExerciseName (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, exercise_id INTEGER REFERENCES Exercise (id), name TEXT UNIQUE);");
            //-- Таблица: Set
            TrainSql.add("CREATE TABLE SSet (weight INTEGER, number INTEGER, id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, exercise_id INTEGER REFERENCES Exercise (id));");
            //-- Таблица: Train
            TrainSql.add("CREATE TABLE Train (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, name TEXT, data DATE);");
            //-- Таблица: Type
            TrainSql.add("CREATE TABLE Type (id INTEGER PRIMARY KEY UNIQUE, name TEXT UNIQUE, exercise_id INTEGER REFERENCES Exercise (id));");

        }

        private void createDietList()
        {
            //-- Таблица: Day
            DietSql.add("CREATE TABLE Day (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, data DATE, ccal INTEGER, protein INTEGER, fat INTEGER, carbohydrate INTEGER);");
            //-- Таблица: FoodIntake
            DietSql.add("CREATE TABLE FoodIntake (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, day_id INTEGER REFERENCES Day (id), name TEXT, time TIME NOT NULL, ccal INTEGER, protein INTEGER, fat INTEGER, carbohydrate INTEGER);");
            //-- Таблица: Product
            DietSql.add("CREATE TABLE Product (" +
                    " id INTEGER PRIMARY KEY AUTOINCREMENT" +
                    " UNIQUE," +
                    " food_intake_id INTEGER REFERENCES FoodIntake (id)," +
                    " name         TEXT," +
                    " ccal         INTEGER," +
                    " protein      INTEGER," +
                    " fat          INTEGER," +
                    " carbohydrate INTEGER," +
                    " weight       INTEGER," +
                    " information  TEXT" +
                    ");");
        }

        private void createMeasList()
        {
            //-- Таблица: Measurement
            MeasSql.add("CREATE TABLE Measurement (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, measurements_id INTEGER REFERENCES Measurements (id), type TEXT, value INTEGER);");
            //-- Таблица: Measurements
            MeasSql.add("CREATE TABLE Measurements (id INTEGER PRIMARY KEY AUTOINCREMENT UNIQUE, data DATA);");
        }
}
