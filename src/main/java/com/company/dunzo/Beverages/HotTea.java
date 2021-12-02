package com.company.dunzo.Beverages;

import com.company.dunzo.Ingredients.*;
import com.company.dunzo.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class HotTea extends Beverage {

    private Builder builder;

    public HotTea(Builder builder) {
        this.builder = builder;
    }

    public static class Builder extends Beverage {
        private HotWater hotWater;
        private HotMilk hotMilk;
        private TeaLeavesSyrup teaLeavesSyrup;
        private GingerSyrup gingerSyrup;
        private SugarSyrup sugarSyrup;

        public Builder addHotWater(HotWater hotWater) {
            this.hotWater = hotWater;
            if(this.isInProgress()) {
                String status = hotWater.addIngredient(hotWater.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("HotTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public Builder addTeaLeavesSyrup(TeaLeavesSyrup teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            if(this.isInProgress()) {
                String status = teaLeavesSyrup.addIngredient(teaLeavesSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("HotTea cannot be prepared because " + status);
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
                    setError("HotTea cannot be prepared because " + status);
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
                    setError("HotTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public Builder addHotMilk(HotMilk hotMilk) {
            this.hotMilk = hotMilk;
            if(this.isInProgress()) {
                String status = hotMilk.addIngredient(hotMilk.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("HotTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            return this;
        }

        public HotTea build()
        {
            if(this.isInProgress()) this.setSuccessful(true);
            return new HotTea(this);
        }
    }
}
