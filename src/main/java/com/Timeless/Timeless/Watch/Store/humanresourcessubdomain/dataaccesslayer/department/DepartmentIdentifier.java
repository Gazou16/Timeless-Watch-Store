package com.Timeless.Timeless.Watch.Store.humanresourcessubdomain.dataaccesslayer.department;

import jakarta.persistence.Embeddable;

import java.util.UUID;

/**
 * @author Christine Gerard
 * @created 01/30/2024
 * @project cardealership-ws-2024
 */

@Embeddable
public class DepartmentIdentifier {

    private String departmentId;

    public DepartmentIdentifier() {
        this.departmentId = UUID.randomUUID().toString();
    }

    public String getDepartmentId() {
        return departmentId;
    }
}
