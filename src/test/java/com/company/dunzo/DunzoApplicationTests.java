package com.company.dunzo;

import com.company.dunzo.Beverages.*;
import com.company.dunzo.dto.Response;
import com.company.dunzo.services.BuildService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class DunzoApplicationTests {
    //Used builder pattern to make specific beverage.
    //Only N beverages are allowed at a time.
    //Ingredients are refilled after 1st go i.e after 1 parallel event (N beverage) are done.

    @Test
    void createAllBeverages1() {
        System.out.println("--------------------------------------------");
        List<Beverage> beverages = new ArrayList<Beverage>();
        beverages.add(new HotTea());
        beverages.add(new HotCoffee());
        beverages.add(new GreenTea());
        beverages.add(new BlackTea());
        BuildService.makeBeverages(beverages);
        System.out.println("--------------------------------------------");
    }

    @Test
    void createAllBeverages2() {

        System.out.println("--------------------------------------------");
        List<Beverage> beverages = new ArrayList<Beverage>();
        beverages.add(new BlackTea());
        beverages.add(new GreenTea());
        beverages.add(new HotTea());
        beverages.add(new HotCoffee());
        BuildService.makeBeverages(beverages);
        System.out.println("--------------------------------------------");
    }

    @Test
    void createAllBeverages3() {

        System.out.println("--------------------------------------------");
        List<Beverage> beverages = new ArrayList<Beverage>();
        beverages.add(new BlackTea());
        beverages.add(new GreenTea());
        beverages.add(new HotTea());
        beverages.add(new HotCoffee());
        beverages.add(new BlackTea());
        beverages.add(new GreenTea());
        beverages.add(new HotTea());
        BuildService.makeBeverages(beverages);
        System.out.println("--------------------------------------------");
    }
}
