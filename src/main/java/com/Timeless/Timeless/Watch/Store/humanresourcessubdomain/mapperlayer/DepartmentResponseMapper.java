package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.mapperlayer;


import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.department.DepartmentResponseModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;



@Mapper(componentModel = "spring")
public interface DepartmentResponseMapper {

    @Mapping(expression = "java(department.getDepartmentIdentifier().getDepartmentId())", target = "departmentId")
    DepartmentResponseModel entityToResponseModel(Department department);

    List<DepartmentResponseModel> entityListToResponseModelList(List<Department> departments);
}
