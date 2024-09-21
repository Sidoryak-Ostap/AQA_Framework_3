package task_5;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.nio.file.Files;

public class Task5XML {

    public static void main(String[] args) {
        XmlMapper xmlMapper = new XmlMapper();

        try{
            File inputXML = new File("src\\main\\resources\\input.xml");
            File outputXML = new File("src\\main\\resources\\output.xml");

            WeatherData weatherData = xmlMapper.readValue(Files.readString(inputXML.getAbsoluteFile().toPath()), WeatherData.class);
            System.out.println(weatherData);

            weatherData.setTemperature(100.4);
            System.out.println(weatherData);

            xmlMapper.writeValue(outputXML, weatherData);

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