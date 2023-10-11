package kz.yerbolov.restApiSeptember.services.impl;

import kz.yerbolov.restApiSeptember.entities.Item;
import kz.yerbolov.restApiSeptember.entities.ItemDTO;
import kz.yerbolov.restApiSeptember.mapper.ItemMapper;
import kz.yerbolov.restApiSeptember.repositories.ItemRepository;
import kz.yerbolov.restApiSeptember.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ItemMapper itemMapper;
    @Override
    public ItemDTO addItem(ItemDTO itemDTO) {
        Item item = new Item();
        item.setName(itemDTO.getName());
        item.setAmount(itemDTO.getAmount());
        item.setPrice(itemDTO.getPrice());
        item.setPromocode(UUID.randomUUID().toString());
        item.setCategories(itemDTO.getCategories());
        return itemMapper.mapToDTO(itemRepository.save(item));
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return itemMapper.mapToDTOList(itemRepository.findAll());
    }

    @Override
    public ItemDTO getItem(Long id) {
        return itemMapper.mapToDTO(itemRepository.findAllById(id));
    }

    @Override
    public ItemDTO updItem(ItemDTO updItem) {
        Item item = itemRepository.findAllById(updItem.getId());
        item.setName(updItem.getName());
        item.setAmount(updItem.getAmount());
        item.setPrice(updItem.getPrice());
        item.setCategories(updItem.getCategories());
        return itemMapper.mapToDTO(itemRepository.save(item));
    }

    @Override
    public void deleteItem(Long id) {
        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDTO> getAllItemsSorted() {
        return itemMapper.mapToDTOList(itemRepository.findAllByOrderByPriceAsc());
    }

    @Override
    public ItemDTO updateItemBundle(ItemDTO updItem) {
        Item item = itemRepository.findAllById(updItem.getId());
        int index = -1;
        for (int i = 0; i < item.getCategories().size(); i++) {
            if(updItem.getCategories().get(0).getId() == item.getCategories().get(i).getId()){
                index = i;
                break;
            }
        }
        item.getCategories().remove(index);
        return itemMapper.mapToDTO(itemRepository.save(item));
    }

    @Override
    public List<ItemDTO> findBySearch(String name) {
        return itemMapper.mapToDTOList(itemRepository.findAllByNameContainsIgnoreCase(name));
    }

    @Override
    public List<ItemDTO> findBySearchByInt(int price, int amount) {
        return itemMapper.mapToDTOList(itemRepository.findAllByPriceEqualsOrAmountEquals(price, amount));
    }
}
