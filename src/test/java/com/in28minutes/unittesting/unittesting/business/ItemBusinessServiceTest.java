package com.in28minutes.unittesting.unittesting.business;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.in28minutes.unittesting.unittesting.data.ItemRepository;
import com.in28minutes.unittesting.unittesting.model.Item;
@ExtendWith(MockitoExtension.class)
class ItemBusinessServiceTest {
	
	@Mock
	ItemRepository repository;
	@InjectMocks
	ItemBusinessService business;

	@Test
	void testRetreiveHardcodedItem() {
		ItemBusinessService businessService = new ItemBusinessService();
		Item item = businessService.retreiveHardcodedItem();// act
		assertNotNull(item);
//		assertEquals(new Item(1,"Ball", 10, 100),item);//assert
	}
	
	@Test
	void testSaveItem(){
		Item item = new Item(4,"Item4",30,30);
		when(repository.save(item)).thenReturn(item);
		Item newItem = business.saveItem(item);
		assertEquals("Item4", newItem.getName());
		
	}
	
	@Test
	void testRetrieveAllItems() {
		
		when(repository.findAll()).thenReturn(Arrays.asList(new Item(2,"Item2",20,20)));
		business.retrieveAllItems();
	}
	
	@Test
	void testRetrieveAllItemsZeroItem() {
		
		when(repository.findAll()).thenReturn(Arrays.asList());
		business.retrieveAllItems();
	}

}
