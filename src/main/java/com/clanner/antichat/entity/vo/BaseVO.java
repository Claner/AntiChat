package com.clanner.antichat.entity.vo;

import com.clanner.antichat.entity.Tip;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Clanner
 */
public abstract class BaseVO {
    @JsonIgnore
    private Tip tip;

    public Tip getTip() {
        return tip;
    }

    public void setTip(Tip tip) {
        this.tip = tip;
    }
}
