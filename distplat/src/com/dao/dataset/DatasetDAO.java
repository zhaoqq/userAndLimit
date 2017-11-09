package com.dao.dataset;

import com.entity.DatasetEntity;
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
 * Created by Benliang on 2017/8/13.
 */

@Repository
public class DatasetDAO implements InfDatasetDAO{
    @Resource(name = "sessionFactory")
    private SessionFactory sessionFactory;
    @Resource(name = "hibernateTemplate")
    private HibernateTemplate hibernateTemplate;

    /**
     * 插入数据集
     * @param dataset 数据集对象
     * @return 数据集Id (失败返回-1)
     */
    public int save(DatasetEntity dataset) {
        int id = -1;
        try {
            hibernateTemplate.save(dataset);
            System.out.println(">><");
            hibernateTemplate.flush();
            id = dataset.getId();
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            return id;
        }
    }

    /**
     * 删除数据集
     * @param dataset 数据集对象
     */
    public void delete(DatasetEntity dataset) {
        try {
            hibernateTemplate.delete(dataset);
        } catch (Exception e) {
            throw  e;
        }
    }

    /**
     * 通过数据集Id删除数据集
     * @param id 数据集Id
     */
    public void deleteById(Integer id) {
        try {
            DatasetEntity dataset = this.searchById(id);
            hibernateTemplate.delete(dataset);
        } catch (Exception e) {
            throw  e;
        }
    }

    /**
     * 更新数据集
     * @param dataset 数据集对象
     */
    public void update(DatasetEntity dataset) {
        try {
            hibernateTemplate.update(dataset);
        } catch(Exception e) {
            throw e;
        }
    }

    /**
     * 查询全部数据集
     * @return 数据集列表
     */
    public List<DatasetEntity> showAll() {
        List<DatasetEntity> list = new ArrayList<>();
        try {
            String queryString = "from DatasetEntity";
            list = (List<DatasetEntity>) hibernateTemplate.find(queryString);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 通过指定属性查询数据集
     * @param propertyName 属性名
     * @param value 属性值
     * @return 数据集列表
     */
    public List<DatasetEntity> searchByProperty(String propertyName, Object value) {
        List<DatasetEntity> list = new ArrayList<>();
        try {
            String queryString = "from com.entity.DatasetEntity as model where model."
                    + propertyName + "=?";
            list = (List<DatasetEntity>) hibernateTemplate.find(queryString, value);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 通过数据集Id查询数据集
     * @param id 数据集Id
     * @return 数据集对象
     */
    public DatasetEntity searchById(Integer id) {
        DatasetEntity dataset = null;
        try {
            List result = this.searchByProperty("id", id);
            if(!result.isEmpty())
                dataset = (DatasetEntity) result.get(0);
        } catch(Exception e) {
            throw e;
        } finally {
            return dataset;
        }
    }

    /**
     * 通过名称查询数据集
     * @param name 数据集名
     * @return 数据集对象
     */
    public DatasetEntity searchByName(String name) {
        DatasetEntity dataset = null;
        try {
            List result = this.searchByProperty("name", name);
            if(!result.isEmpty())
                dataset = (DatasetEntity) result.get(0);
        } catch(Exception e) {
            throw e;
        } finally {
            return dataset;
        }
    }

    /**
     * 查询数据集
     * @param dataset 数据集对象
     * @return 数据集列表
     */
    public List<DatasetEntity> search(DatasetEntity dataset) {
        List<DatasetEntity> list = new ArrayList<>();
        try {
            return hibernateTemplate.findByExample(dataset);
        } catch(Exception e) {
            throw e;
        } finally {
            return list;
        }
    }

    /**
     * 统计数据集数目
     * @return 数据集数目
     */
    public int countDataset() {
        int count = 0;
        try {
            count = this.showAll().size();
        } catch (Exception e) {
            throw e;
        } finally {
            return count;
        }
    }

    /**
     * 通过页码查询数据集
     * @param begin 当前页码
     * @param pageSize 每页记录数
     * @return 数据集列表
     */
    public List<DatasetEntity> searchByPage(int begin, int pageSize) {
        List<DatasetEntity> list = new ArrayList<>();
        DetachedCriteria criteria = DetachedCriteria.forClass(DatasetEntity.class);
        try {
            list = (List<DatasetEntity>) hibernateTemplate.findByCriteria(criteria, begin, pageSize);
        } catch (Exception e) {
            throw e;
        } finally {
            return list;
        }
    }
/*
    public List showAll()
    {
        List datasetList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Criteria c;
            c =  session.createCriteria(DatasetEntity.class);
            datasetList = c.list();
            tx.commit();
        } catch (Exception e)
        {
            tx.rollback();;
        }
        return datasetList;
    }
    public List search(DatasetEntity dataset)
    {
        List datasetList = null;
        Session session = sessionFactory.getCurrentSession();
        Transaction tx = session.beginTransaction();
        try
        {
            Criteria c;
            c =  session.createCriteria(DatasetEntity.class);
            Example example = Example.create(dataset);
            c.add(example);
            datasetList = c.list();
            tx.commit();
        } catch (Exception e)
        {
            tx.rollback();
        }
        return datasetList;
    }
*/
}
