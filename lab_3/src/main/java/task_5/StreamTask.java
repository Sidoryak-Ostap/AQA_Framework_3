package task_5;

import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamTask {

    public static void main(String[] args) {
        Random random  = new Random();

        int n = 10;

        if(args.length>0)
        {
          n = Integer.parseInt(args[0]);
        }

        try {
            List<WeatherData> inputList =  IntStream.range(1,n).mapToObj(i -> {
                WeatherData weatherData = new WeatherData();

                weatherData.setIsHumid(random.nextBoolean());
                weatherData.setTemperature(random.nextDouble()*100);
                weatherData.setTime(UUID.randomUUID().toString().substring(0,10));

                return weatherData;
            }).collect(Collectors.toList());


            inputList.stream().forEach(System.out::println);

            System.out.println();

            List <WeatherData> outputList = inputList.stream()
                    .filter(item -> item.getTime().contains("d"))
                    .sorted(Comparator.comparing(WeatherData::getIsHumid))
                    .sorted(Comparator.comparing(WeatherData::getTemperature))
                    .collect(Collectors.toList());

            outputList.forEach(System.out::println);


        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}


/*
 Stream Task:
a) Generate 10 random objects using a class from a previous task
b) Sort it using any two fields using stream.
c) Filter it by any two fields custom filter.
d) Collect it to List with *main field(s). */