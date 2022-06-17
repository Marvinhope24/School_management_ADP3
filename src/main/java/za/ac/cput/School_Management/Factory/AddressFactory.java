package za.ac.cput.School_Management.Factory;

import za.ac.cput.School_Management.Domain.Address;
import za.ac.cput.School_Management.Domain.City;
import za.ac.cput.School_Management.Helper.StringHelper;


public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber,String streetName, String postalCode, City city)

    {
        StringHelper.isEmptyOrNull("unitNumber");
        StringHelper.isEmptyOrNull("complexName");
        StringHelper.isEmptyOrNull("streetNumber");
        StringHelper.isEmptyOrNull("streetName");
        StringHelper.isEmptyOrNull("postalCode");
        StringHelper.isEmptyOrNull("city");

        StringHelper.checkStringParam("unitNumber", unitNumber);
        StringHelper.checkStringParam("complexName", complexName);
        StringHelper.checkStringParam("streetNumber", streetNumber);
        StringHelper.checkStringParam("streetName", streetName);
        StringHelper.checkStringParam("streetNumber", streetNumber);


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
