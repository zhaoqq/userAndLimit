package com.dao.role_access;

import com.entity.AccessEntity;
import com.entity.RoleEntity;
import com.entity.Role_AccessEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("role_accessDao")
public class Role_AccessDAO implements  InfRole_AccessDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 新增数据权限
     * @param role_Access 数据权限对象
     * @return 数据权限Id (失败返回-1)
     */
    @Override
    public int save(Role_AccessEntity role_Access) {
        int id = -1;
        try {
            hibernateTemplate.save(role_Access);
            hibernateTemplate.flush();
            id = role_Access.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除数据权限
     * @param role_Access 数据权限对象
     */
    @Override
    public void delete(Role_AccessEntity role_Access) {
        try {
            hibernateTemplate.delete(role_Access);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 通过指定Id删除数据权限
     * @param id 数据权限Id
     */
    @Override
    public void delete(Integer id) {
        try {
            Role_AccessEntity role_Access = this.searchById(id);
            hibernateTemplate.delete(role_Access);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 更新数据权限信息
     * @param role_Access 数据权限对象
     */
    @Override
    public void update(Role_AccessEntity role_Access) {
        try {
            hibernateTemplate.update(role_Access);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部数据权限信息
     * @return 数据权限列表
     */
    @Override
    public List<Role_AccessEntity> showAll() {
        List<Role_AccessEntity> list = new ArrayList<>();
        try {
            String queryString = "from Role_AccessEntity";
            list = (List<Role_AccessEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询数据权限
     * @param propertyName 数据权限对象属性
     * @param value 属性值
     * @return 数据权限列表
     */
    @Override
    public List<Role_AccessEntity> searchByProperty(String propertyName, Object value) {
        List<Role_AccessEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.Role_AccessEntity as model where model."
                    + propertyName + "=?";
            list = (List<Role_AccessEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过数据权限Id查询
     * @param id 数据权限Id
     * @return 数据权限对象
     */
    @Override
    public Role_AccessEntity searchById(Integer id) {
        Role_AccessEntity role_Access = null;
        try {
            List<Role_AccessEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                role_Access = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_Access;
        }
    }

    @Override
    public Role_AccessEntity searchByRoleAndAccess(RoleEntity role_id, AccessEntity access_id) {
        Role_AccessEntity role_access = null;
        System.out.println("role:\n"+role_id+"\naccess:\n"+access_id);
//        RoleEntity role = new RoleEntity();
//        role.setId(role_id.getId());
        try {
            String queryString = "from Role_AccessEntity as model where model.role.id="
                    + role_id.getId()+ " and model.access.id=" + access_id.getId();
            List<Role_AccessEntity> result = (List<Role_AccessEntity>) hibernateTemplate.find(queryString);
            if(!result.isEmpty()) {
                role_access = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_access;
        }
    }

    /***
     * 通过数据权限名查询数据权限
     * @param name 数据权限名
     * @return 数据权限对象
     */
    @Override
    public Role_AccessEntity searchByName(String name) {
        Role_AccessEntity role_Access = null;
        try {
            List<Role_AccessEntity> result = this.searchByProperty("name", name);
            if(!result.isEmpty()) {
                role_Access = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_Access;
        }
    }

    /**
     * 通过指定角色Id查询数据权限
     * @param role_id 角色Id
     * @return 数据权限列表
     */
    @Override
    public List<Role_AccessEntity> searchByRoleId(Integer role_id) {
        List<Role_AccessEntity> list = new ArrayList<>();
        try {
            list = this.searchByProperty("role.id", role_id);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }


    /***
     * 查找数据权限
     * @param role_Access 数据权限对象
     * @return 属性匹配的数据权限列表
     */
    @Override
    public List<Role_AccessEntity> search(Role_AccessEntity role_Access) {
        List<Role_AccessEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(role_Access);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 统计数据权限数目
     * @return 数据权限数目
     */
    @Override
    public int countRole_Access() {
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
