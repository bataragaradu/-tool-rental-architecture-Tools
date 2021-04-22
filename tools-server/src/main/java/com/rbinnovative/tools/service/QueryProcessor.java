package com.rbinnovative.tools.service;

import com.rbinnovative.tools.exception.CategoryException;
import com.rbinnovative.tools.exception.ToolException;

import java.util.List;

public interface QueryProcessor<T> {
    T processOneQuery(Integer id) throws CategoryException;
    List<T> processAllQuery();
}
