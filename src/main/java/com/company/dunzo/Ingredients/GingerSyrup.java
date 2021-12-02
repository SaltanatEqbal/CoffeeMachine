package com.company.dunzo.Ingredients;

import com.company.dunzo.dto.Response;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class GingerSyrup implements Ingredient {

    private Response response;
    private int requiredQuantity;

    @Override
    public String addIngredient(int requiredAmount) {
        String status = null;
        int available = response.getMachine().getTotal_items_quantity().getGinger_syrup();
        if(available >= requiredAmount)
        {
            response.getMachine().getTotal_items_quantity().setGinger_syrup(available - requiredAmount);
            status = Status.Success.toString();
        }
        else if(available == 0)
        {
            status = "item ginger_syrup is not available";
        }
        else
        {
            status = "item ginger_syrup is not sufficient";
        }
        return status;
    }
}
