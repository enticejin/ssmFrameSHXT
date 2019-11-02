/**
 * RlmMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-06-12 15:24:29
 **/
package com.shxt.back.rlm.mapper;

import java.util.List;
import java.util.Map;

import com.shxt.back.rlm.model.Rlm;

public interface RlmMapper {
    int delete(Integer rlm_id);

    int add(Rlm rlm);
    Rlm load(Integer rlm_id);
    int update(Rlm rlm);
    List<Rlm> havList(int fk_role_id);
    int delMenu(Map<String, Object> map);
    int addMenu(Map<String, Object> map);
}