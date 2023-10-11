package kz.yerbolov.restApiSeptember.repositories;

import jakarta.transaction.Transactional;
import kz.yerbolov.restApiSeptember.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository <Item, Long> {
    Item findAllById(Long id);
    List <Item> findAllByOrderByPriceAsc();
    List <Item> findAllByNameContainsIgnoreCase(String name);
    List <Item> findAllByPriceEqualsOrAmountEquals(int price, int amount);
}
