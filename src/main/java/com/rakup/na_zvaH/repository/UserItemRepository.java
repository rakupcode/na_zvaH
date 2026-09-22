package com.rakup.na_zvaH.repository;

import com.rakup.na_zvaH.data.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {
}
