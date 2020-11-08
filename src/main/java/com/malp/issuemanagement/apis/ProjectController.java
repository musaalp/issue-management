package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.services.impl.ProjectServiceImpl;
import com.malp.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
public class ProjectController {
    private final ProjectServiceImpl projectServiceImp;

    public ProjectController(ProjectServiceImpl projectServiceImp) {

        this.projectServiceImp = projectServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {

        ProjectDto projectDto = this.projectServiceImp.getById(id);

        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.save(projectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(this.projectServiceImp.delete(id));
    }
}
