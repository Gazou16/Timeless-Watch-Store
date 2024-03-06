package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.mapperlayer;


import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.Department;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.department.DepartmentRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface DepartmentRequestMapper {

    @Mapping(target = "id", ignore = true)
    //@Mapping(expression = "java(departmentIdentifier)", target = "departmentIdentifier")
    Department requestModelToEntity(DepartmentRequestModel departmentRequestModel, DepartmentIdentifier departmentIdentifier);

}
