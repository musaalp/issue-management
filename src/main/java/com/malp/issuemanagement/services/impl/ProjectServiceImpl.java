package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.entities.Project;
import com.malp.issuemanagement.repositories.ProjectRepository;
import com.malp.issuemanagement.repositories.UserRepository;
import com.malp.issuemanagement.services.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // add this service to container as a singleton
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public ProjectServiceImpl(ProjectRepository projectRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Boolean isProjectAlreadyExist = (getByProjectCode(projectDto.getProjectCode())) != null;
        if (isProjectAlreadyExist) {
            throw new IllegalArgumentException("Project already exist with project code: " + projectDto.getProjectCode());
        }

        Project project = modelMapper.map(projectDto, Project.class);

        project = this.projectRepository.save(project);

        projectDto.setId(project.getId());

        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {

        Project project = this.projectRepository.getOne(id);

        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {

        Project project = this.projectRepository.getByProjectCode(projectCode);

        if (project == null)
            return null;

        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<Project> getProjectCodeContains(String projectCode) {

        return this.projectRepository.getByProjectCodeContains(projectCode);
    }

    @Override
    public Page<Project> getAll(Pageable pageable) {

        return this.projectRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(ProjectDto projectDto) {

        Project project = this.modelMapper.map(projectDto, Project.class);

        this.projectRepository.delete(project);

        return Boolean.TRUE;
    }

    @Override
    public Boolean delete(Long id) {

        this.projectRepository.deleteById(id);

        return Boolean.TRUE;
    }

    public ProjectDto update(Long id, ProjectDto projectDto) {

        Project project = this.projectRepository.getOne(id);

        if (project == null)
            throw new IllegalArgumentException("Project does not exist with Id:  " + id);

        Project checkProject = this.projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);

        if (checkProject != null) {
            throw new IllegalArgumentException("Project already exist with project code: " + projectDto.getProjectCode());
        }

        project.setProjectCode(projectDto.getProjectCode());
        project.setProjectName(projectDto.getProjectName());

        this.projectRepository.save(project);

        return modelMapper.map(project, ProjectDto.class);
    }
}
