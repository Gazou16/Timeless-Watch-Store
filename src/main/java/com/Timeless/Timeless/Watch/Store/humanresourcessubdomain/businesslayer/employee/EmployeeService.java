package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.businesslayer.employee;

import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.employee.EmployeeRequestModel;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.employee.EmployeeResponseModel;
import java.util.List;



public interface EmployeeService {

    List<EmployeeResponseModel> getAllEmployees();
    EmployeeResponseModel getEmployeeByEmployeeId(String employeeId);
    EmployeeResponseModel addEmployee(EmployeeRequestModel employeeRequestModel);
    EmployeeResponseModel updateEmployee(EmployeeRequestModel employeeRequestModel, String employeeId);
    void removeEmployee(String employeeId);
}
