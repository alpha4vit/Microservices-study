package by.gurinovich.fraudservice.util.mapper;

import by.gurinovich.clients.FraudClient.response.FraudDto;
import by.gurinovich.fraudservice.entity.Fraud;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface FraudMapper {

    Fraud toEntity(FraudDto dto);

    FraudDto toDto(Fraud entity);
}
