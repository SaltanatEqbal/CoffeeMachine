package com.company.dunzo.Beverages;

import com.company.dunzo.enums.Status;
import com.company.dunzo.services.BuildService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Beverage extends Thread {

    private boolean isSuccessful;
    private String error;
    private boolean inProgress = true;

    public boolean CheckStatus(String status) {
        isSuccessful = status.equals(Status.Success.toString());
        return isSuccessful;
    }

    public void run()
    {
        BuildService.BeverageTypeSelection(this);
    }
}
