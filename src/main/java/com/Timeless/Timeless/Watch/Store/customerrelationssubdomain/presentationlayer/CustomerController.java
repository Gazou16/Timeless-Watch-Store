package com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer;


import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.businesslayer.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping()
    public ResponseEntity<List<CustomerResponseModel>> getCustomers() {
        return ResponseEntity.ok().body(customerService.getCustomers());
    }

    @GetMapping("/{customerId}")
    public ResponseEntity<CustomerResponseModel> getCustomerByCustomerId(@PathVariable String customerId) {
        return ResponseEntity.ok().body(customerService.getCustomerByCustomerId(customerId));
    }

    @PostMapping()
    public ResponseEntity<CustomerResponseModel> addCustomer(@RequestBody CustomerRequestModel customerRequestModel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addCustomer(customerRequestModel));
    }

    @PutMapping("/{customerId}")
    public ResponseEntity<CustomerResponseModel> updateCustomer(@RequestBody CustomerRequestModel customerRequestModel, @PathVariable String customerId) {
        return ResponseEntity.ok().body(customerService.updateCustomer(customerRequestModel, customerId));
    }

    @DeleteMapping("/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String customerId) {
       customerService.removeCustomer(customerId);
       return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    //manually made delete by email
    @DeleteMapping()
    public ResponseEntity<Void> deleteCustomerByEmail(@RequestParam("emailAddress") String email) {
        customerService.removeCustomerByEmail(email);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


    //manually get customer by country
    //theres 2 parameter the @PathVariable and the @RequestParam
    @GetMapping("/filter/{country}")
    public ResponseEntity<List<CustomerResponseModel>> getCustomerByCountryByPhone(
            @PathVariable String country,
            @RequestParam(required = false) Map<String, String> queryParams){
        List<CustomerResponseModel> customers = customerService.getCustomersByCountryByPhone(country, queryParams);
        /*String str;
        str="The path parameter passed is: country = " + country;
        //get the parameters in the map
        Set<String> keys = queryParams.keySet();
            for(String k : keys){
                str += "\n param keys: " + k;
                str += " param values: " + queryParams.get(k);
            }*/
        return ResponseEntity.ok().body(customers);
    }
}
