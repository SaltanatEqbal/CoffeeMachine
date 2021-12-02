package com.company.dunzo.Ingredients;

import com.company.dunzo.dto.Response;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class HotMilk implements Ingredient {
    private Response response;
    private int requiredQuantity;

    @Override
    public String addIngredient(int requiredAmount) {
        String status = null;
        int available = response.getMachine().getTotal_items_quantity().getHot_milk();
        if(available >= requiredAmount)
        {
            response.getMachine().getTotal_items_quantity().setHot_milk(available - requiredAmount);
            status = Status.Success.toString();
        }
        else if(available == 0)
        {
            status = "item hot_milk is not available";
        }
        else
        {
            status = "item hot_milk is not sufficient";
        }
        return status;
    }
}
