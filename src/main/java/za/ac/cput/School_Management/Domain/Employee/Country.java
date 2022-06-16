/*  Kegomoditswe Leshope - 219189048
    Country.java
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
public class Country {
    @Id @NotNull private String countryId;
    @NotNull private String countryName;

    protected Country (){

    }

//constructor

    private Country (Builder builder){
        this.countryId = builder.countryId;
        this.countryName = builder.countryName;
    }

//getter

    public String getCountryId() {
        return countryId;
    }

    public String getCountryName() {
        return countryName;
    }


//builder

    public static class Builder{
        private String countryId,countryName;

        public Builder countryId (String countryId){
            this.countryId = countryId;
            return this;
        }

        public Builder countryName (String countryName){
            this.countryName = countryName;
            return this;
        }

        public Builder copy (Country country){
            this.countryId = country.countryId;
            this.countryName = country.countryName;
            return this;
        }

        public Country build (){
            return new Country(this);
        }
    }

    public static class CountryId{
        private String countryName;

        public CountryId(String countryName){
            this.countryName = countryName;
        }

        public String getCountryName(){
            return countryName;
        }
    }

//equals and hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return countryId.equals(country.countryId) && countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {

        return Objects.hash(countryId, countryName);
    }

//toString

    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + countryId + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
}
