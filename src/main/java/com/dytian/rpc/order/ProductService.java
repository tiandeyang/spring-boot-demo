package com.dytian.rpc.order;

import com.yixin.xv.weixin.rpc.IProductService;
import com.yixin.xv.weixin.rpc.Product;

public class ProductService implements IProductService {
    @Override
    public Product findProductById(long id) {
        Product product = new Product();
        product.setId(id);
        product.setName("tianye");
        product.setPrice(1.0);
        return product;
    }
}
