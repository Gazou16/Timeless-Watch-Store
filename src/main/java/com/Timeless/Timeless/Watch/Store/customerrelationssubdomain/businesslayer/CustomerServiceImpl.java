package com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.businesslayer;



import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.CustomerIdentifier;
import com.Timeless.Timeless.Watch.Store.utils.exceptions.NotFoundException;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.Address;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.Customer;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.CustomerRepository;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datamapperlayer.CustomerRequestMapper;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datamapperlayer.CustomerResponseMapper;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer.CustomerResponseModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerResponseMapper customerResponseMapper;
    private final CustomerRequestMapper customerRequestMapper;


    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerResponseMapper customerResponseMapper,
                               CustomerRequestMapper customerRequestMapper) {
        this.customerRepository = customerRepository;
        this.customerResponseMapper = customerResponseMapper;
        this.customerRequestMapper = customerRequestMapper;
    }

    @Override
    public List<CustomerResponseModel> getCustomers() {
        List<Customer> customers = customerRepository.findAll();
        return customerResponseMapper.entityListToResponseModelList(customers);
    }

    @Override
    public CustomerResponseModel getCustomerByCustomerId(String customerId) {
        Customer customer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (customer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        return customerResponseMapper.entityToResponseModel(customer);
    }

    @Override
    public CustomerResponseModel addCustomer(CustomerRequestModel customerRequestModel) {
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());

        Customer customer = customerRequestMapper.requestModelToEntity(customerRequestModel, new CustomerIdentifier(), address);

        customer.setAddress(address);
        return customerResponseMapper.entityToResponseModel(customerRepository.save(customer));
    }

    @Override
    public CustomerResponseModel updateCustomer(CustomerRequestModel customerRequestModel, String customerId) {

        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        //check if a customer with the provided UUID exists in the system. If it doesn't, return null
        //later, when we implement exception handling, we'll return an exception
        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }
        Address address = new Address(customerRequestModel.getStreetAddress(), customerRequestModel.getCity(),
            customerRequestModel.getProvince(), customerRequestModel.getCountry(), customerRequestModel.getPostalCode());
        Customer updatedCustomer = customerRequestMapper.requestModelToEntity(customerRequestModel,
            existingCustomer.getCustomerIdentifier(), address);
        updatedCustomer.setId(existingCustomer.getId());

        Customer response = customerRepository.save(updatedCustomer);
        return customerResponseMapper.entityToResponseModel(response);
    }

    @Override
    public void removeCustomer(String customerId) {
        Customer existingCustomer = customerRepository.findByCustomerIdentifier_CustomerId(customerId);

        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customerId: " + customerId);
        }

        customerRepository.delete(existingCustomer);
    }


    //manually made delete by email
    @Override
    public void removeCustomerByEmail(String email) {
        Customer existingCustomer = customerRepository.findCustomerByEmailAddress(email);

        if (existingCustomer == null) {
            throw new NotFoundException("Unknown customer Email: " + email);
        }

        customerRepository.delete(existingCustomer);
    }

    //manually made get by country and more param
    @Override
    public List<CustomerResponseModel> getCustomersByCountryByPhone(String country,
            Map<String, String> queryParams){

        List<Customer> customers;
        customers = customerRepository.findAllByAddress_Country(country);

        Set<String> keys = queryParams.keySet();

    return customerResponseMapper.entityListToResponseModelList(customers);
    }
}
