/**
 * Rlm.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-06-12 15:24:29
 **/
package com.shxt.back.rlm.model;

import com.shxt.back.menu.model.Menu;

/**
 * rlm 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2019-06-12 15:24:29
 **/
public class Rlm {

    private Integer rlm_id;
    private Integer fk_role_id;
    private Integer fk_menu_id;
    private Menu menu;
    public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	/**
     * 获取  字段:rlm.rlm_id
     *
     * @return  rlm.rlm_id
     */
    public Integer getRlm_id() {
        return rlm_id;
    }

    /**
     * 设置  字段:rlm.rlm_id
     *
     * @param rlm_id  rlm.rlm_id
     */
    public void setRlm_id(Integer rlm_id) {
        this.rlm_id = rlm_id;
    }

    /**
     * 获取  字段:rlm.fk_role_id
     *
     * @return  rlm.fk_role_id
     */
    public Integer getFk_role_id() {
        return fk_role_id;
    }

    /**
     * 设置  字段:rlm.fk_role_id
     *
     * @param fk_role_id  rlm.fk_role_id
     */
    public void setFk_role_id(Integer fk_role_id) {
        this.fk_role_id = fk_role_id;
    }

    /**
     * 获取  字段:rlm.fk_menu_id
     *
     * @return  rlm.fk_menu_id
     */
    public Integer getFk_menu_id() {
        return fk_menu_id;
    }

    /**
     * 设置  字段:rlm.fk_menu_id
     *
     * @param fk_menu_id  rlm.fk_menu_id
     */
    public void setFk_menu_id(Integer fk_menu_id) {
        this.fk_menu_id = fk_menu_id;
    }
}