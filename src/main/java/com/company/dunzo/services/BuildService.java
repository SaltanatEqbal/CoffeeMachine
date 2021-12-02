package com.company.dunzo.services;

import com.company.dunzo.Beverages.*;
import com.company.dunzo.Ingredients.*;
import com.company.dunzo.dto.Response;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BuildService {

    public static Response response;
    public static int noOfOutlets = 0;

    public static void loadData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String path = new File("src/main/resources/static/data.json").getAbsolutePath();
            response = objectMapper.readValue(new File(path), Response.class);
            noOfOutlets = response.getMachine().getOutlets().getCount_n();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public static void makeBeverages(List<Beverage> beverages)
    {
        loadData();

        List<Thread> beverageIn1Go = new ArrayList<>();

        int count = 0;
        for(Beverage beverage: beverages)
        {
            if(count <= noOfOutlets)
            {
                beverageIn1Go.add(beverage);
            }
            if(count == noOfOutlets)
            {
                MakeBeveragesAtOneTime(beverageIn1Go);
                ResetDataOfOneTime(beverageIn1Go);
                count = 0;
                loadData(); //Refill ingredients after N beverages are used in parallel.
            }
        }
        MakeBeveragesAtOneTime(beverageIn1Go);
    }

    //Selected only N beverage to be made at a time.
    public static void MakeBeveragesAtOneTime(List<Thread> beverages)
    {
        for (Thread beverage: beverages) {
            beverage.start();
        }
    }

    public static void ResetDataOfOneTime(List<Thread> beverages)
    {
        beverages = new ArrayList<>();
    }

    public static void BeverageTypeSelection(Thread beverage)
    {
        if (beverage instanceof BlackTea) {
            createBlackTea();
        } else if (beverage instanceof GreenTea) {
            createGreenTea();
        } else if (beverage instanceof HotTea) {
            createHotTea();
        } else if (beverage instanceof HotCoffee) {
            createHotCoffee();
        }
    }

    //Builder pattern to create BlackTea
    public static void createBlackTea()
    {
        int requiredHotWater = response.getMachine().getBeverages().getBlack_tea().getHot_water();
        int requiredGingerSyrup = response.getMachine().getBeverages().getBlack_tea().getGinger_syrup();
        int requiredSugarSyrup = response.getMachine().getBeverages().getBlack_tea().getSugar_syrup();
        int requiredTeaLeavesSyrup = response.getMachine().getBeverages().getBlack_tea().getTea_leaves_syrup();

        BlackTea blackTea = new BlackTea.Builder()
                .addHotWater(new HotWater(response,requiredHotWater))
                .addTeaLeavesSyrup(new TeaLeavesSyrup(response,requiredTeaLeavesSyrup))
                .addGingerSyrup(new GingerSyrup(response, requiredGingerSyrup))
                .addSugarSyrup(new SugarSyrup(response, requiredSugarSyrup))
                .build();
        if(blackTea.getBuilder().isSuccessful()) {
            System.out.println("BlackTea is prepared");
        }
        else {
            System.out.println(blackTea.getBuilder().getError());
        }
    }

    //Builder pattern to create GreenTea
    public static void createGreenTea()
    {
        int requiredHotWater = response.getMachine().getBeverages().getGreen_tea().getHot_water();
        int requiredGingerSyrup = response.getMachine().getBeverages().getGreen_tea().getGinger_syrup();
        int requiredSugarSyrup = response.getMachine().getBeverages().getGreen_tea().getSugar_syrup();
        int requiredGreenMixture = response.getMachine().getBeverages().getGreen_tea().getGreen_mixture();

        GreenTea greenTea = new GreenTea.Builder()
                .addHotWater(new HotWater(response,requiredHotWater))
                .addGreenMixture(new GreenMixture(response,requiredGreenMixture))
                .addGingerSyrup(new GingerSyrup(response, requiredGingerSyrup))
                .addSugarSyrup(new SugarSyrup(response, requiredSugarSyrup))
                .build();

        if(greenTea.getBuilder().isSuccessful()) {
            System.out.println("GreenTea is prepared");
        }
        else {
            System.out.println(greenTea.getBuilder().getError());
        }
    }

    //Builder pattern to create HotTea
    public static void createHotTea()
    {
        int requiredHotWater = response.getMachine().getBeverages().getHot_tea().getHot_water();
        int requiredGingerSyrup = response.getMachine().getBeverages().getHot_tea().getGinger_syrup();
        int requiredSugarSyrup = response.getMachine().getBeverages().getHot_tea().getSugar_syrup();
        int requiredTeaLeaves = response.getMachine().getBeverages().getHot_tea().getTea_leaves_syrup();
        int requiredHotMilk = response.getMachine().getBeverages().getHot_tea().getHot_milk();

        HotTea hotTea = new HotTea.Builder()
                .addHotWater(new HotWater(response,requiredHotWater))
                .addTeaLeavesSyrup(new TeaLeavesSyrup(response,requiredTeaLeaves))
                .addGingerSyrup(new GingerSyrup(response, requiredGingerSyrup))
                .addSugarSyrup(new SugarSyrup(response, requiredSugarSyrup))
                .addHotMilk(new HotMilk(response, requiredHotMilk))
                .build();
        if(hotTea.getBuilder().isSuccessful()) {
            System.out.println("HotTea is prepared");
        }
        else {
            System.out.println(hotTea.getBuilder().getError());
        }
    }

    //Builder pattern to create HotCoffee
    public static void createHotCoffee()
    {
        int requiredHotWater = response.getMachine().getBeverages().getHot_coffee().getHot_water();
        int requiredGingerSyrup = response.getMachine().getBeverages().getHot_coffee().getGinger_syrup();
        int requiredSugarSyrup = response.getMachine().getBeverages().getHot_coffee().getSugar_syrup();
        int requiredTeaLeaves = response.getMachine().getBeverages().getHot_coffee().getTea_leaves_syrup();
        int requiredHotMilk = response.getMachine().getBeverages().getHot_coffee().getHot_milk();

        HotCoffee hotCoffee = new HotCoffee.Builder()
                .addHotWater(new HotWater(response,requiredHotWater))
                .addTeaLeavesSyrup(new TeaLeavesSyrup(response,requiredTeaLeaves))
                .addGingerSyrup(new GingerSyrup(response, requiredGingerSyrup))
                .addSugarSyrup(new SugarSyrup(response, requiredSugarSyrup))
                .addHotMilk(new HotMilk(response, requiredHotMilk))
                .build();
        if(hotCoffee.getBuilder().isSuccessful()) {
            System.out.println("HotCoffee is prepared");
        }
        else {
            System.out.println(hotCoffee.getBuilder().getError());
        }
    }
}
