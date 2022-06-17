/*  Kegomoditswe Leshope - 219189048
    City.java
    10 June 2022
 */

package za.ac.cput.School_Management.Domain;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class City{
    @Id
    @NotNull
    private  String Id;
    @NotNull
    private  String cityName;
    @Embedded
    private Country country;

    protected City (){
    }
//constructor

    private City (Builder builder){
        this.Id = builder.Id;
        this.cityName = builder.cityName;
        this.country = builder.country;
    }

//getters

    public String getCityId() {
        return Id;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

//builder
//equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Id.equals(city.Id) && cityName.equals(city.cityName) && country.equals(city.country);
    }
    @Override
    public int hashCode() {
        return Objects.hash(Id, cityName, country);
    }
    @Override
    public String toString() {
        return "City{" +
                "cityId='" + Id + '\'' +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                '}';
    }
    public static class Builder{
        private String Id;
        private String cityName;
        private Country country;

        public Builder cityId(String cityId){
            this.Id = cityId;
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
            this.Id = city.Id;
            this.cityName = city.cityName;
            this.country = city.country;
            return this;
        }

        public City build(){
            return new City(this);
        }
    }

}
