package com.ebupt.cu.util;

import lombok.extern.slf4j.Slf4j;

/**
 * @ClassName PageUtils
 * @Description
 * @Author WuJing
 * @Date 2020/11/12 23:55
 * @Version V1.0
 **/

@Slf4j
public class PageUtils {

    public static boolean canPaginate(Integer total, Integer pageSize, Integer pageNo) {

        if (pageSize < 1 || pageNo < 0) {
            log.info(" ==== pageSize={}|pageNo={}====不能分页", pageSize, pageNo);
            return false;
        }
        Integer countPage = total / pageSize + (total % pageSize > 0 ? 1 : 0);

        if (pageNo > countPage + 1) {
            log.info(" ==== countPage={}|pageNo={}，当前页码已经超过了最大页码数====", countPage, pageNo);
            return false;
        }
        return true;
    }
}
