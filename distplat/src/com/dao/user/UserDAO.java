package com.dao.user;

import com.entity.UserEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Administrator on 2016/5/17.
 */

@Repository
public class UserDAO implements InfUserDAO{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /***
     * 查找用户
     * @param user 用户对象
     * @return 属性匹配的用户列表
     */
    @Override
    public List<UserEntity> search(UserEntity user) {
        List<UserEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(user);
            //hibernateTemplate.saveOrUpdate(user);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 插入用户对象
     * @param user 用户对象
     * @return 用户Id (失败返回-1)
     */
    public int save(UserEntity user) {
        int id = -1;
        try {
            hibernateTemplate.save(user);
            hibernateTemplate.flush();
            id = user.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /***
     * 删除用户
     * @param user 用户对象
     */
    public void delete(UserEntity user) {
        try {
            hibernateTemplate.delete(user);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 通过指定Id删除用户
     * @param id 用户Id
     */
    public void deleteById(Integer id) {
        try {
            UserEntity user = this.searchById(id);
            hibernateTemplate.delete(user);
        } catch (Exception e) {
            throw e;
        }
    }

    /***
     * 更新用户信息
     * @param user 用户对象
     */
    public void update(UserEntity user){
        try {
            hibernateTemplate.update(user);
        } catch(Exception e) {
            throw e;
        }
    }

    /***
     * 查询全部用户信息
     * @return 用户列表
     */
    public List<UserEntity> showAll() {
        List<UserEntity> list = new ArrayList<>();
        try {
            String queryString = "from UserEntity";
            list = (List<UserEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过指定属性名查询用户
     * @param propertyName 用户对象属性
     * @param value 属性值
     * @return 用户列表
     */
    public List<UserEntity> searchByProperty(String propertyName, Object value) {
        List<UserEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.UserEntity as model where model."
                    + propertyName + "=?";
            list = (List<UserEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /***
     * 通过用户Id查询
     * @param id 用户Id
     * @return 用户对象
     */
    public UserEntity searchById(Integer id) {
        UserEntity user = null;
        try {
            List<UserEntity> result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                user = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return user;
        }
    }

    /***
     * 通过用户名查询用户
     * @param username 用户名
     * @return 用户对象
     */
    public UserEntity searchByUsername(String username) {
        UserEntity user = null;
        try {
            List<UserEntity> result = this.searchByProperty("username", username);
            if(!result.isEmpty()) {
                user = result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return user;
        }
    }

    /***
     * 统计用户数目
     * @return 用户数目
     */
    public int countUser() {
        int count = 0;
        try {
            count = this.showAll().size();
        } catch (Exception e) {
            throw e;
        } finally {
            return count;
        }
    }

    /***
     * 通过页码查询用户
     * @param begin 当前页码
     * @param pageSize 每页记录数
     * @return 用户列表
     */
    public List<UserEntity> searchByPage(int begin, int pageSize) {
        List<UserEntity> list = new ArrayList<>();
        DetachedCriteria criteria = DetachedCriteria.forClass(UserEntity.class);
        try {
            list = (List<UserEntity>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }


}
