package org.etatcivil.mapper;

import org.etatcivil.dto.ItemDto;
import org.etatcivil.dto.OrderDto;
import org.etatcivil.model.Item;
import org.etatcivil.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Component
@Mapper(uses = {ItemMapper.class})
public interface OrderMapper {

    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    OrderDto carToCarDto(Order order);
}
