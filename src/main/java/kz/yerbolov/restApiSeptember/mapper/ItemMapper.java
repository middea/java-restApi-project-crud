package kz.yerbolov.restApiSeptember.mapper;

import kz.yerbolov.restApiSeptember.entities.Item;
import kz.yerbolov.restApiSeptember.entities.ItemDTO;
import org.mapstruct.Mapper;

import java.util.List;
@Mapper(componentModel = "spring")
public interface ItemMapper {
    ItemDTO mapToDTO(Item item);
    Item mapToEntity(ItemDTO itemDTO);
    List<ItemDTO> mapToDTOList(List<Item> items);
    List <Item> mapToEntityList(List<ItemDTO> itemDTOS);
}
