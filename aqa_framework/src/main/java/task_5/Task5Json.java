package task_5;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.nio.file.Files;

public class Task5Json {

    public static void main(String[] args) {


        ObjectMapper objectMapper = new ObjectMapper();

        try {

            File inputJson = new File("src\\main\\resources\\input.json");
            File outputJson = new File("src\\main\\resources\\output.json");

            WeatherData weatherData = objectMapper.readValue(Files.readString(inputJson.getAbsoluteFile().toPath()), WeatherData.class);

            System.out.println(weatherData);
            weatherData.setTemperature(25.4);
            weatherData.setIsHumid(false);
            System.out.println(weatherData);


            objectMapper.writeValue(outputJson, weatherData);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}


/*
* The general task for all:
Serialization-Deserialization:
a) Make some complex models using your variant.
b) Make it serializable.
c) Read JSON from “input.json”
d) and deserialize it to POJO.
e) Then change a few fields and save it to “output.json”.
f) Do the same for XML.
*/