package com.company.dunzo.Beverages;

import com.company.dunzo.Ingredients.*;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class GreenTea extends Beverage {
    private Builder builder;

    public GreenTea(Builder builder) {
        this.builder = builder;
    }

    public static class Builder extends Beverage {
        private HotWater hotWater;
        private GreenMixture greenMixture;
        private GingerSyrup gingerSyrup;
        private SugarSyrup sugarSyrup;

        public Builder addHotWater(HotWater hotWater) {
            this.hotWater = hotWater;
            if(this.isInProgress()) {
                String status = hotWater.addIngredient(hotWater.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("GreenTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public Builder addGreenMixture(GreenMixture greenMixture) {
            this.greenMixture = greenMixture;
            if(this.isInProgress()) {
                String status = greenMixture.addIngredient(greenMixture.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("GreenTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public Builder addSugarSyrup(SugarSyrup sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            if(this.isInProgress()) {
                String status = sugarSyrup.addIngredient(sugarSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("GreenTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public Builder addGingerSyrup(GingerSyrup gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            if(this.isInProgress()) {
                String status = gingerSyrup.addIngredient(gingerSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("GreenTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public GreenTea build()
        {
            if(this.isInProgress()) this.setSuccessful(true);
            return new GreenTea(this);
        }
    }
}
