package com.rakup.na_zvaH.service;

import com.rakup.na_zvaH.data.Item;
import com.rakup.na_zvaH.data.ItemHistory;
import com.rakup.na_zvaH.data.UserItem;
import com.rakup.na_zvaH.dto.ItemDetail;
import com.rakup.na_zvaH.repository.ItemHistoryRepository;
import com.rakup.na_zvaH.repository.ItemRepository;
import com.rakup.na_zvaH.repository.UserItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class NaZvaHService {

    @Autowired
    private UserItemRepository userItemRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ItemHistoryRepository itemHistoryRepository;

    public ItemDetail getLastItemDetail(Long userId) {
        Optional<UserItem> userItemOpt = userItemRepository.findById(userId);
        if (userItemOpt.isEmpty()) {
            return null;
        }
        UserItem userItem = userItemOpt.get();
        String lastItemName = userItem.getLastItem();

        Item foundItem = null;
        ItemHistory history = null;

        if (lastItemName != null) {
            foundItem = itemRepository.findAll().stream()
                    .filter(i -> lastItemName.equals(i.getItem()))
                    .findFirst()
                    .orElse(null);
        }

        final Item item = foundItem;
        if (item != null) {
            final Long itemId = item.getUid();
            history = itemHistoryRepository.findAll().stream()
                    .filter(h -> h.getItem() != null && h.getItem().getUid().equals(itemId))
                    .findFirst()
                    .orElse(null);
        }

        if (item == null) {
            return null;
        }

        String categoryName = (item.getCategory() != null) ? item.getCategory().getCategory() : null;
        String status = (history != null) ? history.getStatus() : null;
        Date date = (history != null) ? history.getDate() : null;

        return new ItemDetail(
                item.getItem(),
                item.getDescription(),
                status,
                categoryName,
                date
        );
    }

    public ItemDetail getItemDetail(Long itemId) {
        Optional<Item> itemOpt = itemRepository.findById(itemId);
        if (itemOpt.isEmpty()) {
            return null;
        }
        Item item = itemOpt.get();

        ItemHistory history = itemHistoryRepository.findAll().stream()
                .filter(h -> h.getItem() != null && h.getItem().getUid().equals(itemId))
                .findFirst()
                .orElse(null);

        String categoryName = (item.getCategory() != null) ? item.getCategory().getCategory() : null;
        String status = (history != null) ? history.getStatus() : null;
        Date date = (history != null) ? history.getDate() : null;

        return new ItemDetail(
                item.getItem(),
                item.getDescription(),
                status,
                categoryName,
                date
        );
    }
}
