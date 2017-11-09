package com.dao.algo;

import com.entity.AlgorithmEntity;

import java.util.List;

/**
 * Created by Administrator on 2017/7/8.
 */
public interface InfAlgoDAO {
    List<AlgorithmEntity> showAll();
    int save(AlgorithmEntity algo);
    void delete(AlgorithmEntity algo);
    void deleteById(Integer id);
    void update(AlgorithmEntity algo);
    List<AlgorithmEntity> searchByProperty(String propertyName, Object value);
    AlgorithmEntity searchById(Integer id);
    AlgorithmEntity searchByName(String name);
    List<AlgorithmEntity> search(AlgorithmEntity algo);
    int countAlgo();
    List<AlgorithmEntity> searchByPage(int begin, int pageSize);

    //List<AlgorithmEntity> searchSpecific(String column, Object value);
    //List<AlgorithmEntity> searchLike(String column, Object value);
}
