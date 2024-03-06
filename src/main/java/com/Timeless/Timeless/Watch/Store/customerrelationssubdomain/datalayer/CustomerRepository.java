
package com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    Customer findByCustomerIdentifier_CustomerId(String customerId);


    //manually made delete by email
    Customer findCustomerByEmailAddress(String emailAddress);


    //manually made get by address and country
    List<Customer> findAllByAddress_Country(String address_country);
}