package com.itline24.ecm.misc;

import org.springframework.beans.factory.annotation.Required;

public class Machine {

    private Integer cost;

    public Integer getCost() {
        return cost;
    }
    @Required
    public void setCost(Integer cost) {
        this.cost = cost;
    }
}
