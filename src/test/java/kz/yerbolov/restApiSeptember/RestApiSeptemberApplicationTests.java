package kz.yerbolov.restApiSeptember;

import kz.yerbolov.restApiSeptember.entities.Category;
import kz.yerbolov.restApiSeptember.entities.Item;
import kz.yerbolov.restApiSeptember.entities.ItemDTO;
import kz.yerbolov.restApiSeptember.mapper.ItemMapper;
import kz.yerbolov.restApiSeptember.repositories.CategoryRepository;
import kz.yerbolov.restApiSeptember.repositories.ItemRepository;
import kz.yerbolov.restApiSeptember.services.ItemService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class RestApiSeptemberApplicationTests {
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ItemService itemService;
	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemMapper itemMapper;
	@Test
	void contextLoads() {
	}
	@Test
	void getAllItemsTest(){
		List<ItemDTO> items = itemService.getAllItems();
		Assertions.assertNotNull(items);
	}
	@Test
	void getItemTest() {
		Item item = itemRepository.findById(12L).orElse(null);

		if (item != null) {
			ItemDTO itemDTO = itemService.getItem(item.getId());
			Assertions.assertNotNull(itemDTO);
		} else {
			Assertions.fail("Item not found");
		}
	}
	@Test
	void addItemTest(){
		Category category = categoryRepository.findAllById(3L);
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		ItemDTO itemDTO = ItemDTO.builder()
				.name("SmartSamsungWatch")
				.price(500)
				.amount(454)
				.categories(categories)
				.build();
		itemRepository.deleteAll();
		ItemDTO initStateItem = itemService.addItem(itemDTO);
		List<Item> items = itemRepository.findAll();
		Item finalStateItem = items.get(0);
		Assertions.assertNotNull(finalStateItem);
		Assertions.assertEquals(initStateItem.getId(), finalStateItem.getId());
		Assertions.assertEquals(initStateItem.getName(), finalStateItem.getName());
		Assertions.assertEquals(initStateItem.getPrice(), finalStateItem.getPrice());
		Assertions.assertEquals(initStateItem.getAmount(), finalStateItem.getAmount());
		Assertions.assertEquals(initStateItem.getCategories().get(0).getId(), finalStateItem.getCategories().get(0).getId());
	}
	@Test
	void updItemTest() {
		Category category = categoryRepository.findAllById(3L);
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		ItemDTO newItemDTO = ItemDTO.builder()
				.name("SmartSamsungWatch")
				.price(500)
				.amount(454)
				.categories(categories)
				.build();
		itemRepository.deleteAll();
		ItemDTO initialStateItem = itemService.addItem(newItemDTO);
		initialStateItem.setName("UpdatedName");
		initialStateItem.setPrice(600);
		ItemDTO finalStateItem = itemService.updItem(initialStateItem);
		List<Item> items = itemRepository.findAll();
		Item updatedItem = items.get(0);
		Assertions.assertNotNull(updatedItem);
		Assertions.assertEquals(initialStateItem.getId(), finalStateItem.getId());
		Assertions.assertEquals(initialStateItem.getName(), finalStateItem.getName());
		Assertions.assertEquals(initialStateItem.getPrice(), finalStateItem.getPrice());
		Assertions.assertEquals(initialStateItem.getAmount(), finalStateItem.getAmount());
		Assertions.assertEquals(initialStateItem.getCategories().get(0).getId(), finalStateItem.getCategories().get(0).getId());
	}
	@Test
	void deleteItemTest(){
		Item item = Item.builder()
				.name("TestItem")
				.price(500)
				.amount(454)
				.build();
		itemRepository.save(item);
		Long itemId = item.getId();
		itemService.deleteItem(itemId);
		Item deletedItem = itemRepository.findById(itemId).orElse(null);
		Assertions.assertNull(deletedItem);
	}
	@Test
	void mapToDTOTest(){
		Category category = categoryRepository.findAllById(3L);
		List<Category> categories = new ArrayList<>();
		categories.add(category);
		Item item = Item.builder()
				.id(1L)
				.name("iphone 10")
				.price(988000)
				.amount(458)
				.categories(categories)
				.build();
		ItemDTO itemDTO = itemMapper.mapToDTO(item);
		Assertions.assertNotNull(itemDTO);
		Assertions.assertEquals(item.getId(), itemDTO.getId());
		Assertions.assertEquals(item.getName(), itemDTO.getName());
		Assertions.assertEquals(item.getPrice(), itemDTO.getPrice());
		Assertions.assertEquals(item.getAmount(), itemDTO.getAmount());
		Assertions.assertEquals(item.getCategories().get(0).getId(), itemDTO.getCategories().get(0).getId());
	}
}
