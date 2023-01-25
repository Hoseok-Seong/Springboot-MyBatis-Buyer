package shop.mtcoding.buyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import shop.mtcoding.buyer.model.Product;
import shop.mtcoding.buyer.model.ProductRepository;
import shop.mtcoding.buyer.model.Purchase;
import shop.mtcoding.buyer.model.PurchaseRepository;

@Service
public class PurchaseDeleteService {

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public int 삭제하기(int id) {
        Purchase purchase = purchaseRepository.findById(id);
        Product product = productRepository.findById(purchase.getProductId());
        if (product == null) {
            return -1;
        }

        int result = productRepository.updateById(product.getId(), product.getName(),
                product.getPrice(), product.getQty() + purchase.getCount());

        if (result != 1) {
            return -1;
        }

        int result2 = purchaseRepository.deleteById(id);

        if (result2 != 1) {
            return -1;
        }

        return 1;
    }
}
