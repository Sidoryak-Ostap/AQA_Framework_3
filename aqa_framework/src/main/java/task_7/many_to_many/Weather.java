package task_7.many_to_many;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "weather_many_to_many")
public class Weather implements Serializable {

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



    @ManyToMany(mappedBy = "data", fetch = FetchType.LAZY)
    private List<City> cities;

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


    public List<City> getCities() {
        return this.cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "id=" + id +
                ", isHumid=" + isHumid +
                ", temperature=" + temperature +
                ", time='" + time + '\'' +
                ", cities=" + cities +
                '}';
    }
}