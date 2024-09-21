package task_5;
import java.io.Serializable;

public class WeatherData implements Serializable {

    private Boolean isHumid;
    private Double temperature;
    private String time;

    public Boolean getIsHumid() {
        return isHumid;
    }

    public void setIsHumid(boolean humid) {
        isHumid = humid;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
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
                "isHumid=" + isHumid +
                ", temperature=" + temperature +
                ", time='" + time + '\'' +
                '}';
    }
}