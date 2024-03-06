
package com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datamapperlayer;


import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.Address;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.Customer;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.datalayer.CustomerIdentifier;
import com.Timeless.Timeless.Watch.Store.customerrelationssubdomain.presentationlayer.CustomerRequestModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerRequestMapper {


    @Mapping(target = "id", ignore = true)
    Customer requestModelToEntity(CustomerRequestModel customerRequestModel,
                                  CustomerIdentifier customerIdentifier,
                                  Address address);
}
