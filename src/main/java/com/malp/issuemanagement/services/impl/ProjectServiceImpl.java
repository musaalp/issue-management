package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.entities.Project;
import com.malp.issuemanagement.repositories.ProjectRepository;
import com.malp.issuemanagement.services.ProjectService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // add this service to container as a singleton
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project save(Project project) {

        if (project.getProjectCode() == null) {
            throw new IllegalArgumentException("Project code cannot be null");
        }

        return this.projectRepository.save(project);
    }

    @Override
    public Project getById(Long id) {
        return this.projectRepository.getOne(id);
    }

    @Override
    public List<Project> getByProjectCode(String projectCode) {
        return this.projectRepository.getByProjectCode(projectCode);
    }

    @Override
    public List<Project> getProjectCodeContains(String projectCode) {
        return this.projectRepository.getProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAll(Pageable pageable) {
        return this.projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(Project project) {
        this.projectRepository.delete(project);
        return Boolean.TRUE;
    }
}
