package com.malp.issuemanagement.services;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.entities.Project;
import com.malp.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getProjectCodeContains(String projectCode);

    Page<Project> getAll(Pageable pageable);

    Boolean delete(ProjectDto projectDto);

    Boolean delete(Long id);

    ProjectDto update(Long id, ProjectDto projectDto);

    TPage<ProjectDto> getAllPageable(Pageable pageable);
}
