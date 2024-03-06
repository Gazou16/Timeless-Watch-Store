package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.mapperlayer;


import com.Timeless.Timeless.Watch.Store.common.EmployeeIdentifier;
//import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.Address;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.Address;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.Employee;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee.Salary;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "employeeRequestModel.phoneNumbers", target = "phoneNumberList")
    @Mapping(source = "employeeRequestModel.title", target = "positionTitle")
    @Mapping(expression = "java(salary)", target = "salary")
    Employee requestModelToEntity(EmployeeRequestModel employeeRequestModel,
                                  EmployeeIdentifier employeeIdentifier,
                                  DepartmentIdentifier departmentIdentifier,
                                  Address address,
                                  Salary salary);
}
