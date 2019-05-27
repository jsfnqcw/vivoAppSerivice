package com.nju.second.Controller.pojo;

import org.hibernate.validator.constraints.Range;
import javax.validation.constraints.NotBlank;


public class amountPojo {
    @Range(min = 1, message = "改动的金额至少为一")
    int amount;

    public amountPojo(int amount){
        this.amount = amount;
    }

    public int getAmount(){
        return amount;
    }

    public void setAmount(){
        this.amount = amount;
    }

}
