package com.zhonghao.helper;


import com.zhonghao.entity.SysParam;
import com.zhonghao.model.dto.SysParamDTO;

public class SysParamConvertUtil {

    public static SysParam sysParamDTO2SysParam(SysParamDTO dto, SysParam param) {
        if (param == null) {
            param = new SysParam();
        }
        if (dto == null) {
            throw new IllegalArgumentException("sysParamDTO must not be null");
        }
        param.setParamName(dto.getParamName());
        param.setParamValue(dto.getParamValue());
        return param;
    }

}
