package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.employee;

//import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.PhoneNumber;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.CurrencyType;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.PhoneNumber;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;



@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeResponseModel {

    String employeeId;
    String firstName;
    String lastName;
    String emailAddress;
    List<PhoneNumber> phoneNumbers;

    String streetAddress;
    String city;
    String province;
    String country;
    String postalCode;

    String departmentId;
    String departmentName; //comes from DepartmentIdentifier

    String title;

    BigDecimal salary;
    CurrencyType currency;
    Double commissionRate;


}
