package kz.yerbolov.restApiSeptember.controllers;

import kz.yerbolov.restApiSeptember.entities.ItemDTO;
import kz.yerbolov.restApiSeptember.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/item")
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping
    public List<ItemDTO> getAllItems(){
        return itemService.getAllItems();
    }
    @PostMapping
    public ItemDTO addItem(@RequestBody ItemDTO item){
        return itemService.addItem(item);
    }
    @GetMapping(value = "/{id}")
    public ItemDTO getItem(@PathVariable("id") Long id){
        return itemService.getItem(id);
    }
    @PutMapping
    public ItemDTO updItem(@RequestBody ItemDTO updatedItem){
        return itemService.updItem(updatedItem);
    }
    @DeleteMapping(value = "/{id}")
    public void deleteItem(@PathVariable("id") Long id){
        itemService.deleteItem(id);
    }
    @GetMapping(value = "/sorted-items")
    public List <ItemDTO> getAllItemsSorted(){
        return itemService.getAllItemsSorted();
    }
    @PutMapping(value = "/delete-item-bundle")
    public ItemDTO updateItemTether(@RequestBody ItemDTO updItem){
        return itemService.updateItemBundle(updItem);
    }
    @GetMapping(value = "/search")
    public List <ItemDTO> searchItems(@RequestParam(required = false, name = "item-name") String name,
                                   @RequestParam(required = false, name = "item-int") String numberT){
        if(name != null && numberT == null){
            return itemService.findBySearch(name);
        }
        else if(name == null && numberT != null){
            int number = Integer.parseInt(numberT);
            return itemService.findBySearchByInt(number, number);
        }
        return null;
    }
}
