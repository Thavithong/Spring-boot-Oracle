/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.controller;

import com.unitel.vpg.partner.model.TransLog;
import com.unitel.vpg.partner.model.TransactionLog;
import com.unitel.vpg.partner.model.request.TransLogReq;
import com.unitel.vpg.partner.model.response.CommonResponse;
import com.unitel.vpg.partner.model.response.ResponseAbstract;
import com.unitel.vpg.partner.service.TransLogImpl;
import com.unitel.vpg.partner.service.TransLogService;
import com.unitel.vpg.partner.utils.Constant;
import java.io.IOException;
import java.security.Principal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author stl_sdd_thavithong
 */
@RestController
@ControllerAdvice
@RequestMapping(Constant.ApiContext.TRANSACTION)
@Validated
public class ApplicationController {

    private static final Logger logger = Logger.getLogger(ApplicationController.class.getSimpleName());

    @Autowired
    TransLogService serviceLog;
    
    @GetMapping(value = Constant.ApiContext.GET)
    public ResponseEntity<String> index() {
        logger.info("----------> Start get transaction log <------------");
        return new ResponseEntity<String>("Created by Thavithong!", HttpStatus.OK);
    }

    @PostMapping(value = Constant.ApiContext.TRANS_LOG)
    public ResponseEntity<ResponseAbstract> getTransLog(Principal principal,
            @Valid @RequestBody TransLogReq request) throws IOException {
        logger.info("----------> Start get trans log <------------");
        logger.log(Level.INFO, "#TRANS_LOG -> system_trace : {0}", request.getSystemTrace());
        CommonResponse resp = new CommonResponse();
        Date date = Calendar.getInstance().getTime();
        try {
            List<TransLog> lst = serviceLog.getDataByValue(request.getSystemTrace());
            logger.log(Level.INFO, "#TRANS_LOG -> trans_log detail : {0}", lst.toString());
            if (lst.size() > 0) {
                resp.setError(Constant.ErrorCode.SUCCESS);
                resp.setMessage("Get data success");
                resp.setStatus(Constant.Status.SUCCESS);
            } else {
                resp.setError(Constant.ErrorCode.UNSUCCESS);
                resp.setMessage("No data found");
                resp.setStatus(Constant.Status.SUCCESS);
            }
            resp.setData(lst);
            resp.setTimestamp(date);
            return ResponseEntity.status(HttpStatus.OK).body(resp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp);
        }
    }

}
