package com.ebupt.cu.web.model.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName CommonRequest
 * @Description
 * @Author Leipei
 * @Date 2020/11/18 17:36
 * @Version V1.0
 **/
@Data
public class CommonRequest implements Serializable {
    private Integer pageNo = 1;
    private Integer pageSize = 10;
}
