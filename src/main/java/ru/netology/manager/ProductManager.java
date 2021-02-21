package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.Product;
import ru.netology.repository.RepositoryProduct;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductManager {

    private RepositoryProduct repository = new RepositoryProduct();

    public void add(Product item) {
        repository.save(item);
    }

    public Product[] getAll() {
        return repository.getAll();
    }

    public void removeById(int id) {

        try {
            repository.findById(id);
            repository.removeById(id);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Element with id: " + id + " not found");
            e.printStackTrace();
        }

    }

}
