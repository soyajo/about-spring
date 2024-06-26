package com.soyajo.aboutspring.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;


@Data
@AllArgsConstructor
public class Order {

    private Long memberId;
    private String itemName;
    private int itemPrice;
    private int discountPrice;

    
    public int calculatePrice() {
        return itemPrice - discountPrice;
    }
}
