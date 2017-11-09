package com.biz.algo;

/**
 * Created by Benliang on 2017/7/8.
 */
import java.util.List;
import com.entity.AlgorithmEntity;
import com.entity.DatasetEntity;


public interface InfAlgoBiz {
    List showAll();
    List search(AlgorithmEntity algo);
    String runAlgoResult(AlgorithmEntity algo, DatasetEntity dataset);
}
