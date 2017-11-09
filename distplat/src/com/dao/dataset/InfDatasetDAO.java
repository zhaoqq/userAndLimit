package com.dao.dataset;

import com.entity.DatasetEntity;

import java.util.List;
/**
 * Created by Benliang on 2017/8/13.
 */
public interface InfDatasetDAO {
    List<DatasetEntity> showAll();
    int save(DatasetEntity dataset);
    void delete(DatasetEntity dataset);
    void deleteById(Integer id);
    void update(DatasetEntity dataset);
    List<DatasetEntity> searchByProperty(String propertyName, Object value);
    DatasetEntity searchById(Integer id);
    DatasetEntity searchByName(String name);
    List<DatasetEntity> search(DatasetEntity dataset);
    int countDataset();
    List<DatasetEntity> searchByPage(int begin, int pageSize);
}
