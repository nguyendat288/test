package codegym.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty(message = "not null")
    private String name;
    @Min(value = 10,message = "ít nhất là 10")
    private long dientich;
    @Min(value = 10000,message = "ít nhất là 10000")
    private long danso;
    private long gdp;
    @NotEmpty(message = "not null")
    private String mota;
    @ManyToOne
    @JoinColumn(name="countryid")
    private Country country;

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDientich() {
        return dientich;
    }

    public void setDientich(long dientich) {
        this.dientich = dientich;
    }

    public long getDanso() {
        return danso;
    }

    public void setDanso(long danso) {
        this.danso = danso;
    }

    public long getGdp() {
        return gdp;
    }

    public void setGdp(long gdp) {
        this.gdp = gdp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public City(long id, String name, long dientich, long danso, long gdp, String mota, Country country) {
        this.id = id;
        this.name = name;
        this.dientich = dientich;
        this.danso = danso;
        this.gdp = gdp;
        this.mota = mota;
        this.country = country;
    }
}
