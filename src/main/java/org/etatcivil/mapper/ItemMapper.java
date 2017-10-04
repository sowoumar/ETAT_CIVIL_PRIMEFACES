package org.etatcivil.mapper;

import org.etatcivil.dto.ItemDto;
import org.etatcivil.model.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper(uses = {OrderMapper.class})
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    ItemDto itemToItemDto(Item item);

    List<ItemDto> itemsToItemsDtos(List<Item> items);
}
