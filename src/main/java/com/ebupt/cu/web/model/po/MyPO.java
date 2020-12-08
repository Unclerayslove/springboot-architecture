package com.ebupt.cu.web.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Log
 * @Description 日志记录
 * @Author Leipei
 * @Date 2020/11/24 13:23
 * @Version V1.0
 **/
@Data
@TableName(value = "MRBT_LOG")
public class MyPO implements Serializable {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer userId;
    private String userName;
    private String provinceId;
    private String locationId;
    /**
     * 操作内容
     */
    private String operation;
    private String createTime;
    /**
     * 0：成功
     * 1：失败
     */
    private Integer status;
    /**
     * 操作过程
     */
    private String contentDetails;
    /**
     * 描述
     */
    private String remark;
}
