/*  Kegomoditswe Leshope - 219189048
    Country.java
    10 June 2022
 */

package za.ac.cput.School_Management.Domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Embeddable
public class Country {
    @Id @NotNull private String Id;
    @NotNull private String countryName;

    protected Country (){
    }

//constructor
    private Country (Builder builder){
        this.Id = builder.Id;
        this.countryName = builder.countryName;
    }

//getter
    public String getCountryId() {
        return Id;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country = (Country) o;
        return Id.equals(country.Id) && countryName.equals(country.countryName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, countryName);
    }

    @Override
    public String toString() {
        return "Country{" +
                "countryId='" + Id + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }
//builder
    public static class Builder {
        private String Id,countryName;

        public Builder countryId (String countryId){
            this.Id = countryId;
            return this;
        }

        public Builder countryName (String countryName){
            this.countryName = countryName;
            return this;
        }

        public Builder copy (Country country){
            this.Id = country.Id;
            this.countryName = country.countryName;
            return this;
        }

        public Country build (){
            return new Country(this);
        }
    }

}
