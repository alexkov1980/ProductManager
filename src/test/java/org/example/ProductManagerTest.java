package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProductManagerTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    Product book1 = new Book(1, "Мертвые души", 800, "Гоголь");
    Product smartphone1 = new Smartphone(2, "Samsung", 20_000, "Корея");
    Product book2 = new Book(3, "Отцы и дети", 700, "Тургенев");
    Product book3 = new Book(4, "Ревизор", 500, "Гоголь");
    Product smartphone2 = new Smartphone(5, "Iphone", 50_000, "Китай");

    @BeforeEach
    public void setup() {
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);
        manager.add(smartphone1);
        manager.add(smartphone2);
    }

    @Test
    public void shouldFindBookName() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("Отцы и дети");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindBookName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Петр");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindSmartPhoneName() {
        Product[] expected = {smartphone1};
        Product[] actual = manager.searchBy("Samsung");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindSmartPhoneName() {
        Product[] expected = {};
        Product[] actual = manager.searchBy("Nokia");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAuthor() {
        Product[] expected = {smartphone2};
        Product[] actual = manager.searchBy("Китай");
        Assertions.assertArrayEquals(expected, actual);
    }
}
