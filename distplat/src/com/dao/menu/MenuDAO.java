package com.dao.menu;

import com.entity.MenuEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuDAO implements InfMenuDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 新增菜单项
     * @param menu 菜单对象
     * @return 菜单Id (失败返回-1)
     */
    @Override
    public int save(MenuEntity menu) {
        int id = -1;
        try {
            hibernateTemplate.save(menu);
            hibernateTemplate.flush();
            id = menu.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除菜单项
     * @param menu 菜单对象
     */
    @Override
    public void delete(MenuEntity menu) {
        try {
            hibernateTemplate.delete(menu);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 通过指定Id删除菜单项
     * @param id 菜单Id
     */
    @Override
    public void delete(Integer id) {
        try {
            MenuEntity menu = this.searchById(id);
            hibernateTemplate.delete(menu);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 更新菜单信息
     * @param menu 菜单对象
     */
    @Override
    public void update(MenuEntity menu) {
        try {
            hibernateTemplate.update(menu);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部菜单信息
     * @return 菜单列表
     */
    @Override
    public List<MenuEntity> showAll() {
        List<MenuEntity> list = new ArrayList<>();
        try {
            String queryString = "from MenuEntity";
            list = (List<MenuEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询菜单
     * @param propertyName 菜单对象属性
     * @param value 属性值
     * @return 菜单列表
     */
    @Override
    public List<MenuEntity> searchByProperty(String propertyName, Object value) {
        List<MenuEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.MenuEntity as model where model."
                    + propertyName + "=?";
            list = (List<MenuEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过菜单Id查询
     * @param id 菜单Id
     * @return 菜单对象
     */
    @Override
    public MenuEntity searchById(Integer id) {
        MenuEntity menu = null;
        try {
            List<MenuEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                menu = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return menu;
        }
    }

    /***
     * 通过菜单名查询菜单
     * @param name 菜单名
     * @return 菜单对象
     */
    @Override
    public MenuEntity searchByName(String name) {
        MenuEntity menu = null;
        try {
            List<MenuEntity> result = this.searchByProperty("menu_name", name);
            if(!result.isEmpty()) {
                menu = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return menu;
        }
    }

    /***
     * 查找菜单
     * @param menu 菜单对象
     * @return 属性匹配的菜单列表
     */
    @Override
    public List<MenuEntity> search(MenuEntity menu) {
        List<MenuEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(menu);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 统计菜单数目
     * @return 菜单数目
     */
    @Override
    public int countMenu() {
        int count = 0;
        try {
            count = this.showAll().size();
        } catch (Exception e) {
            throw e;
        } finally {
            return count;
        }
    }
}
