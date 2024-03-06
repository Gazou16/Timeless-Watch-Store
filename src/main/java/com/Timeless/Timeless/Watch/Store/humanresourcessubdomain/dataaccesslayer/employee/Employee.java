package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.employee;


import com.Timeless.Timeless.Watch.Store.common.EmployeeIdentifier;
import com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department.DepartmentIdentifier;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;



@Entity
@Table(name="employees")
@Data
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Embedded
    private EmployeeIdentifier employeeIdentifier;

    private String firstName;
    private String lastName;
    private String emailAddress;

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "employee_phonenumbers",
            joinColumns = @JoinColumn(name="employee_id"))
    private List<PhoneNumber> phoneNumberList;

    @Embedded
    private Address address;

    @Embedded
    private DepartmentIdentifier departmentIdentifier;
    private String positionTitle;

    @Embedded
    private Salary salary;
    private Double commissionRate;

    public Employee(@NotNull String firstName,
                    @NotNull String lastName,
                    @NotNull String email,
                    @NotNull List<PhoneNumber> phoneNumberList,
                    @NotNull Address address,
                    @NotNull DepartmentIdentifier departmentIdentifier,
                    @NotNull String title,
                    @NotNull Salary salary,
                    @NotNull Double commissionRate
                   ) {
        this.employeeIdentifier = new EmployeeIdentifier();
        this.address = address;
        this.phoneNumberList = phoneNumberList;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = email;
        this.salary = salary;
        this.commissionRate = commissionRate;
        this.departmentIdentifier = departmentIdentifier;
        this.positionTitle = title;
    }
}
