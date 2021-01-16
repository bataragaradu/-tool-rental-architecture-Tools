package com.rbinnovative.tools.repository;

import com.rbinnovative.tools.model.dao.Tools;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToolsRepository extends JpaRepository<Tools, Integer> {
}
