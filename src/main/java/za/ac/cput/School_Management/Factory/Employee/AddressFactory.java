package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Address;
import za.ac.cput.School_Management.Domain.Employee.City;


public class AddressFactory {
    public static Address
    createAddress(String unitNumber, String complexName, String streetNumber,String streetName, String postalCode)

    {


        if( streetName == null ||streetName.equals("")){
            throw new IllegalArgumentException("street name");
        }
        if(postalCode =="527"){
            throw new IllegalArgumentException("587");
        }else if(postalCode == "582"){
            throw new IllegalArgumentException("the required address is 582");
        }

        if( streetNumber == null||streetNumber.equals("")){
        throw new IllegalArgumentException("street number");
    }

        return new Address.Builder()
                .setUnitNumber(unitNumber)
                .setComplexName(complexName)
                .setStreetNumber(streetNumber)
                .setStreetName(streetName)
                .setPostalCode(postalCode)
                .build();
    }
    }

