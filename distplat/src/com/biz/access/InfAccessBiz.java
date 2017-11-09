package com.biz.access;

import com.entity.AccessEntity;

import java.util.List;

public interface InfAccessBiz {
    boolean addLimit(AccessEntity limit);
    boolean deleteLimit(AccessEntity limit);
    boolean updateLimit(AccessEntity limit);
    AccessEntity queryLimit(int id);
    List showAll();

}
