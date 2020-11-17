package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.services.impl.ProjectServiceImpl;
import com.malp.issuemanagement.util.ApiPaths;
import com.malp.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api
@Slf4j // gives an instance of log for logging
public class ProjectController {
    private final ProjectServiceImpl projectServiceImp;

    public ProjectController(ProjectServiceImpl projectServiceImp) {

        this.projectServiceImp = projectServiceImp;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get all by pagination operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {

        return ResponseEntity.ok(this.projectServiceImp.getAllPageable(pageable));
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get by id operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {

        log.info("Project Controller ->");

        ProjectDto projectDto = this.projectServiceImp.getById(id);

        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    @ApiOperation(value = "Create operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.save(projectDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update by id operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete by id operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(this.projectServiceImp.delete(id));
    }
}
