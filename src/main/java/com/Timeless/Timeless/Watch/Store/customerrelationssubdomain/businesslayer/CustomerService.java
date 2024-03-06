package com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.businesslayer;


import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer.CustomerResponseModel;


import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<CustomerResponseModel> getCustomers();
    CustomerResponseModel getCustomerByCustomerId(String customerId);
    CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel);
    CustomerResponseModel updateCustomer(CustomerRequestModel updatedCustomer, String customerId);
    void removeCustomer(String customerId);



    //Manually made delete with email
    void removeCustomerByEmail(String email);

    //Manually made get the country
    List<CustomerResponseModel> getCustomersByCountryByPhone(String country, Map<String, String> queryParams);


}
