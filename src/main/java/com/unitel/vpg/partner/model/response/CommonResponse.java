/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.unitel.vpg.partner.model.TransLog;
import java.util.List;

/**
 *
 * @author stl_sdd_thavithong
 */
public class CommonResponse extends ResponseAbstract {

    @JsonProperty("data")
    protected List<TransLog> data;

    public List<TransLog> getData() {
        return data;
    }

    public void setData(List<TransLog> data) {
        this.data = data;
    }

}
