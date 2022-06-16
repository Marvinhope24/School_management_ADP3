package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Address;
import za.ac.cput.School_Management.Domain.Employee.City;


public class AddressFactory {
    public static Address
    NewAddress(String unitNumber, String complexName, String streetNumber,String streetName, String postalCode, City city)

    {

        if( streetNumber == null||streetNumber.equals("")){
            throw new IllegalArgumentException("street number");
        }
        if( streetName == null ||streetName.equals("")){
            throw new IllegalArgumentException("street name");
        }
        if(postalCode == null){
            throw new IllegalArgumentException("number must be between 1000-9999");
        }
        if(city == null || city.equals("")){
            throw new IllegalArgumentException("city");
        }

        return new Address.Builder()
                .setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .setCity(city)
                .build();
    }
}
