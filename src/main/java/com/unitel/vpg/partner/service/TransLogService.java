/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unitel.vpg.partner.service;

import com.unitel.vpg.partner.model.TransLog;
import java.util.List;

/**
 *
 * @author stl_sdd_thavithong
 */
public interface TransLogService {
    public List<TransLog> getDataByValue(String system_trace);
}
