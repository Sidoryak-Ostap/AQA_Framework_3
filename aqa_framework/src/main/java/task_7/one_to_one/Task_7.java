package task_7.one_to_one;

import org.hibernate.Session;
import org.hibernate.Transaction;
import task_6.HibernateUtil;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Task_7 {
    private static Random random = new Random();
    private static List<String> countries = Arrays.asList("USA", "Ukraine", "France", "Poland", "German");
    private static List<String> cities = Arrays.asList("City1", "City2", "City3", "City4", "City5");


    public static void main(String[] args) {



        Session session = HibernateUtil.getSessionFactory().openSession();

        Weather weather = generateWeather();
        City city = generateCity();

        weather.setCity(city);
        city.setData(weather);


        Transaction transaction = session.beginTransaction();


        //Create
        session.save(city);
        Long cityId = city.getId();

        // Read
        City retrievedCity = session.get(City.class, cityId);
        System.out.println("Retrieved City: " + retrievedCity);

        Weather retrievedWeather = retrievedCity.getData();
        System.out.println("Retrieved Weather of the city: " + retrievedCity);

        // Update
        retrievedCity.setCity(cities.get(random.nextInt(countries.size())));
        retrievedCity.setCountry(countries.get(random.nextInt(countries.size())));
        session.update(retrievedCity);
        System.out.println(retrievedCity);

        //Delete
        session.delete(retrievedCity);

        transaction.commit();

        HibernateUtil.shutdown();


    }

    private static City generateCity(){
        int randomIndex = random.nextInt(countries.size());
        City city = new City();

        city.setCity(cities.get(randomIndex));
        city.setCountry(countries.get(randomIndex));
        return city;
    }

    private static Weather generateWeather(){
        Weather weather = new Weather();

        weather.setTime(new Date().toString());
        weather.setIsHumid(true);
        weather.setTemperature(10 + (30-10) * random.nextDouble());
        return weather;
    }

}


//General:
//Implement OneToOne, OneToMany, and ManyToMany relations in your models from the previous task.(Task_6)
//Test it by CRUD.