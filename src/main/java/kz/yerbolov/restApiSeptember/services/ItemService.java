package kz.yerbolov.restApiSeptember.services;

import kz.yerbolov.restApiSeptember.entities.Item;
import kz.yerbolov.restApiSeptember.entities.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO addItem(ItemDTO itemDTO);
    List <ItemDTO> getAllItems();
    ItemDTO getItem(Long id);
    ItemDTO updItem(ItemDTO updItem);
    void deleteItem(Long id);
    List <ItemDTO> getAllItemsSorted();
    ItemDTO updateItemBundle(ItemDTO updItem);
    List<ItemDTO> findBySearch(String name);
    List<ItemDTO> findBySearchByInt(int price, int amount);
}
