package task_7.many_to_many;

import org.hibernate.Session;
import org.hibernate.Transaction;
import task_6.HibernateUtil;

import java.util.*;

public class Task_7 {
    private static Random random = new Random();
    private static List<String> countries = Arrays.asList("USA", "Ukraine", "France", "Poland", "Germany");
    private static List<String> cities = Arrays.asList("City1", "City2", "City3", "City4", "City5");

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

            transaction = session.beginTransaction();

            City city1 = generateCity();
            City city2 = generateCity();

            Weather weather1 = generateWeather();
            Weather weather2 = generateWeather();


            city1.setData(Arrays.asList(weather2, weather1));
            city2.setData(Arrays.asList(weather1));

            session.save(city1);
            session.save(city2);


            transaction.commit();
            System.out.println("Data created successfully!");

            // Read
            transaction = session.beginTransaction();
            City retrievedCity1 = session.get(City.class, city1.getId());
            City retrievedCity2 = session.get(City.class, city2.getId());

            System.out.println("Retrieved City 1: " + retrievedCity1);
            System.out.println("Retrieved City 2: " + retrievedCity2);
            transaction.commit();

            // Update
            transaction = session.beginTransaction();
            retrievedCity1.setCity("UpdatedCity1");
            retrievedCity1.getData().get(0).setTemperature(25.0);
            session.update(retrievedCity1);
            transaction.commit();

            System.out.println("Updated City 1: " + session.get(City.class, retrievedCity1.getId()));

            // Delete
            transaction = session.beginTransaction();
            session.delete(retrievedCity1);
            session.delete(retrievedCity2);
            transaction.commit();



        HibernateUtil.shutdown();
    }

    private static City generateCity() {
            int randomIndex = random.nextInt(countries.size());
            City city = new City();
            city.setCity(cities.get(randomIndex));
            city.setCountry(countries.get(randomIndex));
            return  city;
    }

    private static Weather generateWeather() {
            Weather weather= new Weather();

            weather.setTime(new Date().toString());
            weather.setIsHumid(true);
            weather.setTemperature(10 + (30 - 10) * random.nextDouble());
            return weather;
    }
}
