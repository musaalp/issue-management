package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.services.impl.ProjectServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/versioning")
@Api
public class ProjectVersionedController {

    private final ProjectServiceImpl projectServiceImp;

    public ProjectVersionedController(ProjectServiceImpl projectServiceImp) {
        this.projectServiceImp = projectServiceImp;
    }

    @GetMapping(value = "/{id}", params = "version=1")
    @ApiOperation(value = "Get by id operation v1", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV1(@PathVariable(value = "id", required = true) Long id) {

        ProjectDto projectDto = this.projectServiceImp.getById(id);

        return ResponseEntity.ok(projectDto);
    }

    @GetMapping(value = "/{id}", params = "version=2")
    @ApiOperation(value = "Get by id operation v2", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getByIdV2(@PathVariable(value = "id", required = true) Long id) {

        ProjectDto projectDto = this.projectServiceImp.getById(id);

        return ResponseEntity.ok(projectDto);
    }
}
