package task_6;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Task_6 {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();

        //Create
        WeatherData weatherData = new WeatherData();
        weatherData.setTemperature(28.4);


        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(weatherData);
        transaction.commit();

        //Update
        weatherData.setIsHumid(true);
        transaction = session.beginTransaction();
        session.update(weatherData);
        transaction.commit();

        //Read
        weatherData = session.get(WeatherData.class, id);
        System.out.println(weatherData);

        //Delete
        session.delete(weatherData);
        weatherData = session.get(WeatherData.class, id);
        System.out.println(weatherData);


        HibernateUtil.shutdown();
    }
}


//Install MySQL server (or any SQL like db)
//Make at least two tables (Entities from the previous task or any additional if needed)
//Make models for those Entities (from Task_5)
//Setup Hibernate for those Entities and local DB
//Check basic CRUD (create, read, update, and delete the BD records using Hibernate)
//Generate a few rows into all tables