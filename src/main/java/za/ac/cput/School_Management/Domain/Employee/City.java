/*  Kegomoditswe Leshope - 219189048
    City.java
    10 June 2022
 */

package za.ac.cput.School_Management.Domain.Employee;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Embeddable
public class City{
    @Id
    @NotNull
    private  String cityId;
    @NotNull
    private  String cityName;
    @NotNull
    private  Country country;

    protected City (){

    }

//constructor

    private City (Builder builder){
        this.cityId = builder.cityId;
        this.cityName = builder.cityName;
        this.country = builder.country;
    }

//getters

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

//builder

    public static class Builder{
        private String cityId;
        private String cityName;
        private Country country;

        public Builder cityId(String cityId){
            this.cityId = cityId;
            return this;
        }

        public Builder cityName(String cityName){
            this.cityName = cityName;
            return this;
        }

        public Builder country(Country country){
            this.country = country;
            return this;
        }

        public Builder copy (City city){
            this.cityId = city.cityId;
            this.cityName = city.cityName;
            this.country = city.country;
            return this;
        }

        public City build(){
            return new City(this);
        }
    }

//equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return cityId.equals(city.cityId) && cityName.equals(city.cityName) && country.equals(city.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, cityName, country);
    }

//toString

    @Override
    public String toString() {
        return "City{" +
                "cityId='" + cityId + '\'' +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                '}';
    }

}
