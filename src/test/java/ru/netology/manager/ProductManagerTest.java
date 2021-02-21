package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.TShirt;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {
    ProductManager manager = new ProductManager();

    private Product firstBook = new Book(1, "Book1", 10, "Author1");
    private Product secondBook = new Book(2, "Book2", 20, "Author2");
    private Product thirdBook = new Book(3, "Book3", 30, "Author3");
    private Product firstTShirt = new TShirt(4, "Smartphone1", 10, "Producer1");
    private Product secondTShirt = new TShirt(5, "Smartphone2", 20, "Producer2");
    private Product thirdTShirt = new TShirt(6, "Smartphone3", 30, "Producer3");
    private Product firstBookTShirt = new Book(7, "Smartphone1", 10, "Producer1");
    private Product firstPhoneTShirt = new TShirt(8, "Book1", 10, "Author1");

    @BeforeEach
    public void setUp() {
        manager.add(firstBook);
        manager.add(secondBook);
        manager.add(thirdBook);
        manager.add(firstTShirt);
        manager.add(secondTShirt);
        manager.add(thirdTShirt);
        manager.add(firstBookTShirt);
        manager.add(firstPhoneTShirt);
    }

    @Test
    public void shouldRemoveExistProductById() {
        manager.removeById(8);
        Product[] actual = manager.getAll();
        Product[] expected = new Product[]{firstBookTShirt, thirdTShirt, secondTShirt, firstTShirt, thirdBook, secondBook, firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveNoneExistProductById() {
        assertThrows(NotFoundException.class, () -> manager.removeById(9));
    }

    @Test
    public void shouldRemoveNoneExist2ProductById() {
        assertThrows(NotFoundException.class, () -> manager.removeById(0));
    }
}