package com.dao.role_menu;

import com.entity.Role_MenuEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Role_MenuDAO implements InfRole_MenuDAO{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 新增菜单权限
     * @param role_Menu 菜单权限对象
     * @return 菜单权限Id (失败返回-1)
     */
    @Override
    public int save(Role_MenuEntity role_Menu) {
        int id = -1;
        try {
            hibernateTemplate.save(role_Menu);
            hibernateTemplate.flush();
            id = role_Menu.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除菜单权限
     * @param role_Menu 菜单权限对象
     */
    @Override
    public void delete(Role_MenuEntity role_Menu) {
        try {
            hibernateTemplate.delete(role_Menu);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 通过指定Id删除菜单权限
     * @param id 菜单权限Id
     */
    @Override
    public void delete(Integer id) {
        try {
            Role_MenuEntity role_Menu = this.searchById(id);
            hibernateTemplate.delete(role_Menu);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 更新菜单权限信息
     * @param role_Menu 菜单权限对象
     */
    @Override
    public void update(Role_MenuEntity role_Menu) {
        try {
            hibernateTemplate.update(role_Menu);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部菜单权限信息
     * @return 菜单权限列表
     */
    @Override
    public List<Role_MenuEntity> showAll() {
        List<Role_MenuEntity> list = new ArrayList<>();
        try {
            String queryString = "from Role_MenuEntity";
            list = (List<Role_MenuEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询菜单权限
     * @param propertyName 菜单权限对象属性
     * @param value 属性值
     * @return 菜单权限列表
     */
    @Override
    public List<Role_MenuEntity> searchByProperty(String propertyName, Object value) {
        List<Role_MenuEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.Role_MenuEntity as model where model."
                    + propertyName + "=?";
            list = (List<Role_MenuEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过菜单权限Id查询
     * @param id 菜单权限Id
     * @return 菜单权限对象
     */
    @Override
    public Role_MenuEntity searchById(Integer id) {
        Role_MenuEntity role_Menu = null;
        try {
            List<Role_MenuEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                role_Menu = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_Menu;
        }
    }

    /**
     * 通过指定角色Id查询菜单权限
     * @param role_id 角色Id
     * @return 菜单权限列表
     */
    @Override
    public List<Role_MenuEntity> searchByRoleId(Integer role_id) {
        List<Role_MenuEntity> list = new ArrayList<>();
        try {
            list = this.searchByProperty("role_id", role_id);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 通过指定菜单Id查询菜单权限
     * @param menu_id 菜单Id
     * @return 菜单权限列表
     */
    @Override
    public List<Role_MenuEntity> searchByMenuId(Integer menu_id) {
        List<Role_MenuEntity> list = new ArrayList<>();
        try {
            list = this.searchByProperty("menu_id", menu_id);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }


    /***
     * 查找菜单权限
     * @param role_Menu 菜单权限对象
     * @return 属性匹配的菜单权限列表
     */
    @Override
    public List<Role_MenuEntity> search(Role_MenuEntity role_Menu) {
        List<Role_MenuEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(role_Menu);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 统计菜单权限数目
     * @return 菜单权限数目
     */
    @Override
    public int countRole_Menu() {
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
