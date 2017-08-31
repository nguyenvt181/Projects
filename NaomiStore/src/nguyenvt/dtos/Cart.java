package nguyenvt.dtos;

import java.io.Serializable;
import java.util.HashMap;

public class Cart implements Serializable {
    public HashMap<Integer, ProductDTO> hashMap;

    public Cart() {
        this.hashMap = new HashMap<>();
    }

    public HashMap<Integer, ProductDTO> getHashMap() {
        return hashMap;
    }

    public void addCart(ProductDTO productDTO) throws Exception {
        if (this.hashMap.containsKey(productDTO.getProductId())){
            int currentQuantity = this.hashMap.get(productDTO.getProductId()).getProductQuantity();
            productDTO.setProductQuantity(currentQuantity + 1);
            productDTO.setProductPrice((currentQuantity + 1) * productDTO.getProductPrice());
        }
        this.hashMap.put(productDTO.getProductId(), productDTO);
    }

    public void removeCart(int id) throws Exception {
        if (this.hashMap.containsKey(id)){
            this.hashMap.remove(id);
        }
    }

    public void updateCart(int id, int quantity, float unitPrice) throws Exception {
        if (this.hashMap.containsKey(id)){
            this.hashMap.get(id).setProductQuantity(quantity);
            this.hashMap.get(id).setProductPrice(quantity * unitPrice);
        }
    }
}
