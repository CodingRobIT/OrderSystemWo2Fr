import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepoTest {

    @Test
    void returnAllProdukts() {
        //Given
        Product product1 = new Product("B10", "Becher");        //Anlegen zweier Produkte
        Product product2 = new Product("G15", "Glass");         //Hier Produkt 2
        Map<String, Product>productTestMap = new HashMap<>();   //
        productTestMap.put(product1.getId(),product1);
        productTestMap.put(product2.getId(),product2);
        ProductRepo productRepo1 = new ProductRepo(productTestMap);

        //WHEN
        Map<String, Product> actual = productRepo1.list();
        //THEN
        assertEquals(productTestMap, actual);
    }

    @Test
    void returnNoProdukts() {
        //Given
        //Product product1 = new Product("B10", "Becher");        //Anlegen zweier Produkte
        //Product product2 = new Product("G15", "Glass");         //Hier Produkt 2
        Map<String, Product>productTestMap = new HashMap<>();
        //productTestMap.put(product1.getId(),product1);
        //productTestMap.put(product2.getId(),product2);
        ProductRepo productRepo1 = new ProductRepo(productTestMap);


        //WHEN
        Map<String, Product> actual = productRepo1.list();

        //THEN
        assertEquals(Collections.emptyMap(), actual);
    }

    @Test
    void getProduktTest() {
        //GIVEN
        Product product1 = new Product("B10", "Becher");
        Map<String, Product>productTestMap = new HashMap<>();
        productTestMap.put(product1.getId(), product1);
        ProductRepo productRepo1 = new ProductRepo(productTestMap);
        //WHEN
        Product actual = productRepo1.get("B10");
        //THEN
        assertEquals(product1, actual);
    }

    @Test
    void getNotProduktTest() {
        //GIVEN
        Product product1 = new Product("B10", "Becher");
        Map<String, Product> productTestMap = new HashMap<>();
        productTestMap.put(product1.getId(), product1);
        ProductRepo productRepo1 = new ProductRepo(productTestMap);
        //WHEN
        Product actual = productRepo1.get("B20");
        //THEN
        assertNull(actual);
    }


}