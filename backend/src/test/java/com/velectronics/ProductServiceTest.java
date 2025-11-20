package com.velectronics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.velectronics.model.Product;
@Test public class ProductServiceTest {
    @Test public void sample(){ Product p = new Product(1L,"X","d",100.0,""); assertEquals(100.0, p.getPrice()); }
}
