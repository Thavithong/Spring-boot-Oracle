/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;

/**
 *
 * @author stl_sdd_thavithong
 */
public abstract class ResponseAbstract {

    @JsonProperty("status")
    protected String status;

    @JsonProperty("error")
    protected String error;

    @JsonProperty("message")
    protected String message;

    @JsonProperty("timestamp")
    protected Date timestamp = new Date();

    public ResponseAbstract() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
    
    

}
