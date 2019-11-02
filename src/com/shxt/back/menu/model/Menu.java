/**
 * Menu.java
 * ©2006-2016 四海兴唐科技有限公司 
 * All rights reserved.
 * <link>胖先生作品</link>
 * 创建于: 2019-06-12 15:23:20
 **/
package com.shxt.back.menu.model;

/**
 * menu 类
 * @Description : 
 * 
 * @author 胖先生
 * @version 1.0 
 * 文件创建于: 2019-06-12 15:23:20
 **/
public class Menu {

    private Integer menu_id;
    private String menu_name;
    private String meng_url;
    private String father_menu;

    /**
     * 获取  字段:menu.menu_id
     *
     * @return  menu.menu_id
     */
    public Integer getMenu_id() {
        return menu_id;
    }

    /**
     * 设置  字段:menu.menu_id
     *
     * @param menu_id  menu.menu_id
     */
    public void setMenu_id(Integer menu_id) {
        this.menu_id = menu_id;
    }

    /**
     * 获取  字段:menu.menu_name
     *
     * @return  menu.menu_name
     */
    public String getMenu_name() {
        return menu_name;
    }

    /**
     * 设置  字段:menu.menu_name
     *
     * @param menu_name  menu.menu_name
     */
    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name == null ? null : menu_name.trim();
    }

    /**
     * 获取  字段:menu.meng_url
     *
     * @return  menu.meng_url
     */
    public String getMeng_url() {
        return meng_url;
    }

    /**
     * 设置  字段:menu.meng_url
     *
     * @param meng_url  menu.meng_url
     */
    public void setMeng_url(String meng_url) {
        this.meng_url = meng_url == null ? null : meng_url.trim();
    }

    /**
     * 获取  字段:menu.father_menu
     *
     * @return  menu.father_menu
     */
    public String getFather_menu() {
        return father_menu;
    }

    /**
     * 设置  字段:menu.father_menu
     *
     * @param father_menu  menu.father_menu
     */
    public void setFather_menu(String father_menu) {
        this.father_menu = father_menu == null ? null : father_menu.trim();
    }
}