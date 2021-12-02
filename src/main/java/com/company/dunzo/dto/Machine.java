package com.company.dunzo.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Machine {

    private Outlets outlets;
    private TotalQuantityItems total_items_quantity;

    private Beverages beverages;
}
