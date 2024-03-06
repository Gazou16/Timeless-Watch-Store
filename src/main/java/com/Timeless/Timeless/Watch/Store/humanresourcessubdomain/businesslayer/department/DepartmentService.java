package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.businesslayer.department;


import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.department.DepartmentRequestModel;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.department.DepartmentResponseModel;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface DepartmentService {

    List<DepartmentResponseModel> getAllDepartments();
    DepartmentResponseModel getDepartmentByDepartmentId(String departmentId);
    DepartmentResponseModel addDepartment(DepartmentRequestModel departmentRequestModel);
    DepartmentResponseModel updateDepartment(DepartmentRequestModel departmentRequestModel, String departmentId);
    void removeDepartmentByDepartmentId(String departmentId);
}
