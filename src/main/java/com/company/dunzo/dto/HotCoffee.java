package com.company.dunzo.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HotCoffee {
    private int hot_water;
    private int ginger_syrup;
    private int hot_milk;
    private int sugar_syrup;
    private int tea_leaves_syrup;
}
