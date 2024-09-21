package task_7.one_to_one;

import javax.persistence.*;


@Entity
@Table(name="city")
public class City {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String country;

    @Column
    private String city;


    @OneToOne(mappedBy = "city", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Weather data;


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

    public Weather getData() {
        return data;
    }

    public void setData(Weather data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "WeatherCity{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
