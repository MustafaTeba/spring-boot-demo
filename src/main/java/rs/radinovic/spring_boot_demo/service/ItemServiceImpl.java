package rs.radinovic.spring_boot_demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.radinovic.spring_boot_demo.domain.Item;
import rs.radinovic.spring_boot_demo.domain.ItemRepository;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemServiceImpl(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public long saveItem(Item item) {
        return itemRepository.save(item).getId();
    }

    public Item findItem(long id) {
        return itemRepository.findOne(id);
    }

    public List<Item> findAllItems() {
        return itemRepository.findAll();
    }

    public Item updateItem(Item item) {
        Item oldItem = findItem(item.getId());
        if (oldItem == null) {
            throw new IllegalArgumentException("Error, trying to update non-existing item.");
        }
        return itemRepository.save(item);
    }

    public void deleteItem(long id) {
        Item item = findItem(id);
        itemRepository.delete(item);
    }
}
