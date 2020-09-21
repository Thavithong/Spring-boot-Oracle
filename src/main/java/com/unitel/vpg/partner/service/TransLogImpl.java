/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.service;

import com.unitel.vpg.partner.controller.ApplicationController;
import com.unitel.vpg.partner.model.TransLog;
import com.unitel.vpg.partner.model.TransactionLog;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author stl_sdd_thavithong
 */
public class TransLogImpl implements TransLogService {

    private static final Logger logger = Logger.getLogger(ApplicationController.class.getSimpleName());
    SimpleDateFormat sdfFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    private JdbcTemplate jdbcTemp;

    public TransLogImpl(DataSource dataSource) {
        jdbcTemp = new JdbcTemplate(dataSource);
    }

    @Override
    public List<TransLog> getDataByValue(String system_trace) {
        String sql = "SELECT * FROM VPG.TRANS_LOG WHERE  request_date >= TRUNC(SYSDATE-1) AND system_trace= " + system_trace + "";
        logger.info(sql);
        List<TransLog> list = jdbcTemp.query(sql, new RowMapper<TransLog>() {
//        List<TransLog> list = jdbcTemp.query("SELECT CLIENT_ID, REQUEST_DATE, SYSTEM_TRACE, PROCESS_CODE, CUST_CODE, TRANS_AMOUNT, RESPONSE_CODE, PURSE_NAME  FROM VPG.TRANS_LOG WHERE  request_date >= TRUNC(SYSDATE) AND system_trace= " + system_trace + " ", new RowMapper<TransLog>() {
            @Override
            public TransLog mapRow(ResultSet rs, int rowNum) throws SQLException {
                logger.info("#TransLogImpl -> get data from database successfully! ");
                TransLog item = new TransLog();
                item.setClientId(rs.getString("CLIENT_ID"));
                String dateReq = rs.getString("REQUEST_DATE");
                item.setRequestDate(dateReq);
                item.setSystemTrace(rs.getString("SYSTEM_TRACE"));
                item.setProcessCode(rs.getString("PROCESS_CODE"));
                item.setCustCode(rs.getString("CUST_CODE"));
                item.setTransAmount(rs.getLong("TRANS_AMOUNT"));
                item.setResponseCode(rs.getString("RESPONSE_CODE"));
                item.setPurseName(rs.getString("PURSE_NAME"));
                logger.log(Level.INFO, "Client Id : {0} , Rrequest Date : {1} , System Trace : {2} , Process Code : {3} , Cust Id : {4} , Trans Amount : {5} , Response Code : {6} , Purse Name : {7}",
                        new Object[]{item.getClientId(), item.getRequestDate(), item.getSystemTrace(), item.getProcessCode(), item.getCustCode(), item.getTransAmount(), item.getResponseCode(), item.getPurseName()});
                return item;
            }
        });
        return list;
    }

}
