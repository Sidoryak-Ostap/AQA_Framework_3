package task_7.one_to_many;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="city_one_to_many")
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;


    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Weather> data;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Weather> getData() {
        return data;
    }

    public void setData(List<Weather> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", data=" + data +
                '}';
    }
}
