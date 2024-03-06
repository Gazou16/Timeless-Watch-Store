package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.mapperlayer;


import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface EmployeeResponseMapper {

    @Mapping(expression = "java(employee.getEmployeeIdentifier().getEmployeeId())", target = "employeeId")
    @Mapping(expression = "java(employee.getAddress().getStreetAddress())", target = "streetAddress")
    @Mapping(expression = "java(employee.getAddress().getCity())", target = "city")
    @Mapping(expression = "java(employee.getAddress().getProvince())", target = "province")
    @Mapping(expression = "java(employee.getAddress().getCountry())", target = "country")
    @Mapping(expression = "java(employee.getAddress().getPostalCode())", target = "postalCode")
    @Mapping(source = "employee.phoneNumberList", target = "phoneNumbers")
    @Mapping(source = "employee.positionTitle", target = "title")
    @Mapping(expression = "java(employee.getSalary().getSalary())", target = "salary")
    @Mapping(expression = "java(employee.getSalary().getCurrency())", target = "currency")
    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    @Mapping(expression = "java(department.getName())", target = "departmentName")
    EmployeeResponseModel entityToResponseModel(Employee employee, Department department);

}