package com.malp.issuemanagement.services;

import com.malp.issuemanagement.entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    Project save(Project project);

    Project getById(Long id);

    List<Project> getByProjectCode(String projectCode);

    List<Project> getProjectCodeContains(String projectCode);

    Page<Project> getAll(Pageable pageable);

    Boolean delete(Project project);
}
