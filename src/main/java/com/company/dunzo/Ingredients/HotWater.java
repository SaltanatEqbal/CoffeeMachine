package com.company.dunzo.Ingredients;

import com.company.dunzo.dto.Response;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Statement;

@AllArgsConstructor
@Getter
@Setter
public class HotWater implements Ingredient {
    private Response response;
    private int requiredQuantity;

    @Override
    public String addIngredient(int requiredAmount) {
        String status = null;
        int available = response.getMachine().getTotal_items_quantity().getHot_water();
        if(available >= requiredAmount)
        {
            response.getMachine().getTotal_items_quantity().setHot_water(available - requiredAmount);
            status = Status.Success.toString();
        }
        else if(available == 0)
        {
            status = "item hot_water is not available";
        }
        else
        {
            status = "item hot_water is not sufficient";
        }
        return status;
    }
}
