package com.dao.access;

import com.entity.AccessEntity;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Repository("accessDao")
public class AccessDAO implements InfAccessDAO {

        @Resource(name = "sessionFactory")
        private SessionFactory sessionFactory;
        @Resource(name = "hibernateTemplate")
        private HibernateTemplate hibernateTemplate;

        /**
         * 新增数据权限
         * @param access 数据权限对象
         * @return 数据权限Id (失败返回-1)
         */
        @Override
        public int save(AccessEntity access) {
            int id = -1;
            try {
                hibernateTemplate.save(access);
                hibernateTemplate.flush();
                id = access.getId();
            } catch(Exception e) {
                throw e;
            } finally {
                return id;
            }
        }

        /**
         * 删除数据权限
         * @param access 数据权限对象
         */
        @Override
        public void delete(AccessEntity access) {
            try {
                hibernateTemplate.delete(access);
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
                AccessEntity access = this.searchById(id);
                hibernateTemplate.delete(access);
            } catch (Exception e) {
                throw e;
            }
        }

        /***
         * 更新数据权限信息
         * @param access 数据权限对象
         */
        @Override
        public void update(AccessEntity access) {
            System.out.println(access);
            try {
                hibernateTemplate.update(access);
            } catch(Exception e) {
                throw e;
            }
        }

        /***
         * 查询全部数据权限信息
         * @return 数据权限列表
         */
        @Override
        public List<AccessEntity> showAll() {
            List<AccessEntity> list = new ArrayList<>();
            try {
                String queryString = "from AccessEntity";
                list = (List<AccessEntity>) hibernateTemplate.find(queryString);
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
        public List<AccessEntity> searchByProperty(String propertyName, Object value) {
            List<AccessEntity> list = new ArrayList<>();
            try {
                String queryString = "from com.entity.AccessEntity as model where model."
                        + propertyName + "=?";
                list = (List<AccessEntity>) hibernateTemplate.find(queryString, value);
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
        public AccessEntity searchById(Integer id) {
            AccessEntity access = null;
            try {
                List<AccessEntity> result = this.searchByProperty("id", id);
                //System.out.println(result.size());
                if(!result.isEmpty()) {
                    access = result.get(0);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                //System.out.println(access.getId());
                return access;
            }
        }

        /***
         * 通过数据权限名查询数据权限
         * @param name 数据权限名
         * @return 数据权限对象
         */
        @Override
        public AccessEntity searchByName(String name) {
            AccessEntity access = null;
            try {
                List<AccessEntity> result = this.searchByProperty("name", name);
                if(!result.isEmpty()) {
                    access = result.get(0);
                }
            } catch (Exception e) {
                throw e;
            } finally {
                return access;
            }
        }

        /**
         * 通过指定角色Id查询数据权限
         * @param role_id 角色Id
         * @return 数据权限列表
         */
//        @Override
//        public List<AccessEntity> searchByRoleId(Integer role_id) {
//            List<AccessEntity> list = new ArrayList<>();
//            try {
//                list = this.searchByProperty("role_id", role_id);
//            } catch (Exception e) {
//                throw e;
//            } finally {
//                return list;
//            }
//        }

        /**
         * 通过指定数据Id查询数据权限
         * @param data_id 数据Id
         * @return 数据权限列表
         */
        @Override
        public List<AccessEntity> searchByDataId(Integer data_id) {
            List<AccessEntity> list = new ArrayList<>();
            try {
                list = this.searchByProperty("data_id", data_id);
            } catch (Exception e) {
                throw e;
            } finally {
                return list;
            }
        }

        /**
         * 通过指定算法Id查询数据权限
         * @param algo_id 算法Id
         * @return 数据权限列表
         */
        @Override
        public List<AccessEntity> searchByAlgoId(Integer algo_id) {
            List<AccessEntity> list = new ArrayList<>();
            try {
                list = this.searchByProperty("algo_id", algo_id);
            } catch (Exception e) {
                throw e;
            } finally {
                return list;
            }
        }

        /***
         * 查找数据权限
         * @param access 数据权限对象
         * @return 属性匹配的数据权限列表
         */
        @Override
        public List<AccessEntity> search(AccessEntity access) {
            List<AccessEntity> list = new ArrayList<>();
            try {
                list = hibernateTemplate.findByExample(access);
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
//    @Override
//    public int countRole_Access() {
//        int count = 0;
//        try {
//            count = this.showAll().size();
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            return count;
//        }
//    }

        /***
         * 统计数据权限中数据集的数目
         * @return 数据权限中数据集记录数
         */
        @Override
        public int countData_Access() {
            int count = 0;
            try {
                count = this.searchByProperty("type", "d").size();
            } catch (Exception e) {
                throw e;
            } finally {
                return count;
            }
        }

        /***
         * 统计数据权限中算法的数目
         * @return 数据权限中算法记录数
         */
        @Override
        public int countAlgo_Access() {
            int count = 0;
            try {
                count = this.searchByProperty("type", "a").size();
            } catch (Exception e) {
                throw e;
            } finally {
                return count;
            }
        }
    }



