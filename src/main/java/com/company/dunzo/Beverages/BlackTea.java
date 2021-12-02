package com.company.dunzo.Beverages;

import com.company.dunzo.Ingredients.*;
import com.company.dunzo.enums.Status;
import lombok.*;

@NoArgsConstructor
@Getter
public class BlackTea extends Beverage {
    private Builder builder;

    public BlackTea(Builder builder) {
        this.builder = builder;
    }

    public static class Builder extends Beverage {
        private HotWater hotWater;
        private TeaLeavesSyrup teaLeavesSyrup;
        private GingerSyrup gingerSyrup;
        private SugarSyrup sugarSyrup;

        public Builder addHotWater(HotWater hotWater) {
            this.hotWater = hotWater;
            if(this.isInProgress()) {
                String status = hotWater.addIngredient(hotWater.getRequiredQuantity());

                if (!CheckStatus(status)) {
                    setError("BlackTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            //System.out.println("addWater" + this.isInProgress() + ":" + this.getError());
            return this;
        }

        public Builder addTeaLeavesSyrup(TeaLeavesSyrup teaLeavesSyrup) {
            this.teaLeavesSyrup = teaLeavesSyrup;
            if(this.isInProgress()) {
                String status = teaLeavesSyrup.addIngredient(teaLeavesSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("BlackTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            //System.out.println("addTea" + this.isInProgress() + ":" + this.getError());
            return this;
        }

        public Builder addSugarSyrup(SugarSyrup sugarSyrup) {
            this.sugarSyrup = sugarSyrup;
            if(this.isInProgress()) {
                String status = sugarSyrup.addIngredient(sugarSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("BlackTea cannot be prepared because " + status);
                    setInProgress(false);
                }
                //System.out.println("addSugar" + this.isInProgress() + ":" + this.getError()) ;
            }
            return this;
        }

        public Builder addGingerSyrup(GingerSyrup gingerSyrup) {
            this.gingerSyrup = gingerSyrup;
            if(this.isInProgress()) {
                String status = gingerSyrup.addIngredient(gingerSyrup.getRequiredQuantity());
                if (!CheckStatus(status)) {
                    setError("BlackTea cannot be prepared because " + status);
                    setInProgress(false);
                }
            }
            //System.out.println("addGinger" + this.isInProgress() + ":" + this.getError());
            return this;
        }

        public BlackTea build()
        {
            if(this.isInProgress()) this.setSuccessful(true);
            return new BlackTea(this);
        }
    }
}
