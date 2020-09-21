/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.utils;

/**
 *
 * @author stl_sdd_thavithong
 */
public class Constant {

    public interface ContentType {

        String JSON = "application/json;charset=UTF-8";
    }

    public interface ApiContext {

        // Contexts
        String TRANSACTION = "/api/v1/transaction";
        String GET = "/get";
        String TRANS_LOG = "/trans_log";
    }

    public interface ErrorCode {

        String SUCCESS = "00";
        String UNSUCCESS = "01";
    }

    public interface Status {

        String SUCCESS = "200";
    }



}
