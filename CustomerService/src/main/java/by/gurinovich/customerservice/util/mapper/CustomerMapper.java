package by.gurinovich.customerservice.util.mapper;

import by.gurinovich.customerservice.dto.CustomerDto;
import by.gurinovich.customerservice.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

}
