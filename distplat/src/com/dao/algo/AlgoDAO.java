package com.dao.algo;

import com.entity.AlgorithmEntity;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */
@Repository
public class AlgoDAO implements InfAlgoDAO {
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;

    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 查询所有算法
     * @return 算法列表
     */
    public List<AlgorithmEntity> showAll() {
        List<AlgorithmEntity> list = new ArrayList<>();
        try {
            String queryString = "from AlgorithmEntity ";
            list = (List<AlgorithmEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 插入算法
     * @param algo 算法对象
     * @return 算法Id (失败返回-1)
     */
    public int save(AlgorithmEntity algo) {
        int id = -1;
        try {
            hibernateTemplate.save(algo);
            hibernateTemplate.flush();
            id = algo.getId();
        } catch(Exception e) {
            throw e;
        } finally {
            return id;
        }
    }

    /**
     * 删除算法
     * @param algo 算法对象
     */
    public void delete(AlgorithmEntity algo) {
        try {
            hibernateTemplate.delete(algo);
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * 通过算法Id删除算法
     * @param id 算法Id
     */
    public void deleteById(Integer id) {
        try {
            AlgorithmEntity algo = this.searchById(id);
            hibernateTemplate.delete(algo);
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * 更新算法
     * @param algo 算法对象
     */
    public void update(AlgorithmEntity algo) {
        try {
            hibernateTemplate.update(algo);
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * 通过属性查询算法
     * @param propertyName 算法属性名
     * @param value 属性值
     * @return 算法列表
     */
    public List<AlgorithmEntity> searchByProperty(String propertyName, Object value) {
        List<AlgorithmEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.AlgorithmEntity as model where model."
                    + propertyName + "=?";
            list = (List<AlgorithmEntity>) hibernateTemplate.find(queryString, value);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 通过算法Id查询算法
     * @param id 算法Id
     * @return 算法对象
     */
    public AlgorithmEntity searchById(Integer id) {
        AlgorithmEntity algo = null;
        try {
            List result = this.searchByProperty("id", id);
            if(!result.isEmpty()) {
                algo = (AlgorithmEntity) result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return algo;
        }
    }

    /**
     * 通过算法名查询算法
     * @param name 算法名
     * @return 算法对象
     */
    public AlgorithmEntity searchByName(String name) {
        AlgorithmEntity algo = null;
        try {
            List result = this.searchByProperty("alName", name);
            if(!result.isEmpty()) {
                algo = (AlgorithmEntity) result.get(0);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            return  algo;
        }
    }

    /**
     * 查询算法
     * @param algo 算法对象
     * @return 匹配属性值的算法列表
     */
    public List<AlgorithmEntity> search(AlgorithmEntity algo) {
        List<AlgorithmEntity> list = new ArrayList<>();
        try {
            list = hibernateTemplate.findByExample(algo);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 统计算法数目
     * @return 算法数目
     */
    public int countAlgo() {
        int count = 0;
        try {
            count = this.showAll().size();
        } catch(Exception e) {
            throw e;
        } finally {
            return count;
        }
    }

    /**
     * 通过页码查询算法
     * @param begin 当前页码
     * @param pageSize 每页记录数
     * @return 算法列表
     */
    public List<AlgorithmEntity> searchByPage(int begin, int pageSize) {
        List<AlgorithmEntity> list = new ArrayList<>();
        DetachedCriteria criteria = DetachedCriteria.forClass(AlgorithmEntity.class);
        try {
            list = (List<AlgorithmEntity>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
    @Override
    public List searchSpecific(String column, Object value) {
        List algoList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Criteria c;
            c = session.createCriteria(AlgorithmEntity.class);
            algoList = c.add(Restrictions.eq(column, value)).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
        return algoList;
    }

    @Override
    public List searchLike(String column, Object value)
    {
        List algoList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try {
            Criteria c;
            c = session.createCriteria(AlgorithmEntity.class);
            algoList = c.add(Restrictions.like(column, value).ignoreCase()).list();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        session.close();
        return algoList;
    }
    */
}
