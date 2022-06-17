package za.ac.cput.School_Management.Factory.Employee;

import za.ac.cput.School_Management.Domain.Employee.Address;
import za.ac.cput.School_Management.Domain.Employee.City;
import za.ac.cput.School_Management.Helper.StringHelper;


public class AddressFactory {
    public static Address build(String unitNumber, String complexName, String streetNumber,String streetName, String postalCode, City city)

    {
        StringHelper.isEmptyOrNull("unitNumber");
        StringHelper.isEmptyOrNull("complexName");
        StringHelper.isEmptyOrNull("streetNumber");
        StringHelper.isEmptyOrNull("streetName");
        StringHelper.isEmptyOrNull("postalCode");
        StringHelper.isEmptyOrNull("streetNumber");

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
