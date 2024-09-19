package task_6;

import javax.persistence.*;
import java.io.Serializable;



@Entity
@Table(name = "weather_data")
public class WeatherData implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private Boolean isHumid;

    @Column
    private Double temperature;

    @Column
    private String time;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getIsHumid() {
        return isHumid;
    }

    public void setIsHumid(Boolean humid) {
        isHumid = humid;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "WeatherData{" +
                "id=" + id +
                ", isHumid=" + isHumid +
                ", temperature=" + temperature +
                ", time='" + time + '\'' +
                '}';
    }
}