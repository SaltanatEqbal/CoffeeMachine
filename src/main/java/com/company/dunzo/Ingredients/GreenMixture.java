package com.company.dunzo.Ingredients;

import com.company.dunzo.dto.Response;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GreenMixture implements Ingredient {
    private Response response;
    private int requiredQuantity;

    @Override
    public String addIngredient(int requiredAmount) {
        String status = null;
        int available = response.getMachine().getTotal_items_quantity().getGreen_mixture();
        if(available >= requiredAmount)
        {
            status = Status.Success.toString();
        }
        else if(available == 0)
        {
            status = "item green_mixture is not available";
        }
        else
        {
            status = "item green_mixture is not sufficient";
        }
        return status;
    }
}
