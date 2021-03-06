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

    public void removeById(int id) {
            repository.removeById(id);
    }
}
