package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.presentationlayer.department;

import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.Position;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentResponseModel {

    String departmentId;
    String name;
    Integer headCount;

    List<Position> positions;

}
