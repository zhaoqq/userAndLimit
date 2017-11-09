package com.dao.role;

import com.entity.RoleEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class RoleDAO implements  InfRoleDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 新增角色
     * @param role 角色对象
     * @return 角色Id (失败返回-1)
     */
    @Override
    public int save(RoleEntity role) {
        int id = -1;
        try {
            hibernateTemplate.save(role);
            hibernateTemplate.flush();
            id = role.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除角色
     * @param role 角色对象
     */
    @Override
    public void delete(RoleEntity role) {
        try {
            hibernateTemplate.delete(role);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 通过指定Id删除角色
     * @param id 角色Id
     */
    @Override
    public void delete(Integer id) {
        try {
            RoleEntity role = this.searchById(id);
            hibernateTemplate.delete(role);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 更新角色信息
     * @param role 角色对象
     */
    @Override
    public void update(RoleEntity role) {
        try {
            hibernateTemplate.update(role);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部角色信息
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> showAll() {
        List<RoleEntity> list = new ArrayList<>();
        try {
            String queryString = "from RoleEntity";
            list = (List<RoleEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询角色
     * @param propertyName 角色对象属性
     * @param value 属性值
     * @return 角色列表
     */
    @Override
    public List<RoleEntity> searchByProperty(String propertyName, Object value) {
        List<RoleEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.RoleEntity as model where model."
                    + propertyName + "=?";
            list = (List<RoleEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过角色Id查询
     * @param id 角色Id
     * @return 角色对象
     */
    @Override
    public RoleEntity searchById(Integer id) {
        RoleEntity role = null;
        try {
            List<RoleEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                role = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role;
        }
    }

    /***
     * 通过角色名查询角色
     * @param name 角色名
     * @return 角色对象
     */
    @Override
    public RoleEntity searchByName(String name) {
        RoleEntity role = null;
        try {
            List<RoleEntity> result = this.searchByProperty("name", name);
            if(!result.isEmpty()) {
                role = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role;
        }
    }

    /***
     * 查找角色
     * @param role 角色对象
     * @return 属性匹配的角色列表
     */
    @Override
    public List<RoleEntity> search(RoleEntity role) {
        List<RoleEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(role);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 统计角色数目
     * @return 角色数目
     */
    @Override
    public int countRole() {
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
