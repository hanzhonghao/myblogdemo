package com.zhonghao.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 系统资源(t_resource)
 * @author tt
 *
 */
@Data
public class SysResource implements java.io.Serializable {
    
    private Long id;
    private String url;
    private Long createUser;
    private Long createTime;

}
