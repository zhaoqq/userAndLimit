package com.dao.role_user;

import com.entity.Role_UserEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Role_UserDAO implements  InfRole_UserDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 新增用户角色
     * @param role_User 用户角色对象
     * @return 用户角色Id (失败返回-1)
     */
    @Override
    public int save(Role_UserEntity role_User) {
        int id = -1;
        try {
            hibernateTemplate.save(role_User);
            hibernateTemplate.flush();
            id = role_User.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除用户角色
     * @param role_User 用户角色对象
     */
    @Override
    public void delete(Role_UserEntity role_User) {
        try {
            hibernateTemplate.delete(role_User);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 通过指定Id删除用户角色
     * @param id 用户角色Id
     */
    @Override
    public void delete(Integer id) {
        System.out.println("dao:"+id);
        try {
            Role_UserEntity role_User = this.searchById(id);
            hibernateTemplate.delete(role_User);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Role_UserEntity searchByUserIdAndRoleId(Integer userId, Integer roleId) {
        Role_UserEntity role_user = null;
        try {
            String queryString = "from com.entity.Role_UserEntity as model where model.user_id="
                    + userId + " and model.role_id=" + roleId;
            List<Role_UserEntity> result = (List<Role_UserEntity>) hibernateTemplate.find(queryString);
            if(!result.isEmpty()) {
                role_user = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_user;
        }
    }

    /***
     * 更新用户角色信息
     * @param role_User 用户角色对象
     */
    @Override
    public void update(Role_UserEntity role_User) {
        try {
            hibernateTemplate.update(role_User);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部用户角色信息
     * @return 用户角色列表
     */
    @Override
    public List<Role_UserEntity> showAll() {
        List<Role_UserEntity> list = new ArrayList<>();
        try {
            String queryString = "from Role_UserEntity";
            list = (List<Role_UserEntity>) hibernateTemplate.find(queryString);

        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询用户角色
     * @param propertyName 用户角色对象属性
     * @param value 属性值
     * @return 用户角色列表
     */
    @Override
    public List<Role_UserEntity> searchByProperty(String propertyName, Object value) {
        List<Role_UserEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.Role_UserEntity as model where model."
                    + propertyName + "=?";
            list = (List<Role_UserEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过用户角色Id查询
     * @param id 用户角色Id
     * @return 用户角色对象
     */
    @Override
    public Role_UserEntity searchById(Integer id) {
        Role_UserEntity role_User = null;
        try {
            List<Role_UserEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                role_User = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return role_User;
        }
    }

    /**
     * 通过指定角色Id查询用户
     * @param role_id 角色Id
     * @return 用户角色列表
     */
    @Override
    public List<Role_UserEntity> searchByRoleId(Integer role_id) {
        List<Role_UserEntity> list = new ArrayList<>();
        try {
            list = this.searchByProperty("role_id", role_id);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 通过指定用户Id查询角色
     * @param user_id 用户Id
     * @return 用户角色列表
     */
    @Override
    public List<Role_UserEntity> searchByUserId(Integer user_id) {
        List<Role_UserEntity> list = new ArrayList<>();
        try {
            list = this.searchByProperty("user_id", user_id);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 查找用户角色
     * @param role_User 用户角色对象
     * @return 属性匹配的用户角色列表
     */
    @Override
    public List<Role_UserEntity> search(Role_UserEntity role_User) {
        List<Role_UserEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(role_User);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 统计用户角色数目
     * @return 用户角色数目
     */
    @Override
    public int countRole_User() {
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
