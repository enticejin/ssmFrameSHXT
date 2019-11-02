/**
 * MenuMapper.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-06-12 15:23:20
 **/
package com.shxt.back.menu.mapper;

import java.util.List;

import com.shxt.back.menu.model.Menu;

public interface MenuMapper {
    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-06-12 15:23:20
     * 
     **/
    int delete(Integer menu_id);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-06-12 15:23:20
     * 
     **/
    int add(Menu menu);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-06-12 15:23:20
     * 
     **/
    Menu load(Integer menu_id);

    /**
     * menu
     * 方法描述:
     * @param  
     * @return 
     * @throws 
     * @author 胖先生
     * @date 2019-06-12 15:23:20
     * 
     **/
    int update(Menu menu);
    List<Menu> noList(int fk_role_id);
    List<Menu> fatherList(int fk_role_id);
}