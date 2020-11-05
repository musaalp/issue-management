package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.services.impl.ProjectServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectServiceImpl projectServiceImp;

    public ProjectController(ProjectServiceImpl projectServiceImp) {

        this.projectServiceImp = projectServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectDto> getById(@PathVariable("id") Long id) {

        ProjectDto projectDto = this.projectServiceImp.getById(id);

        return ResponseEntity.ok(projectDto);
    }

    @PostMapping
    public ResponseEntity<ProjectDto> create(@RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.save(projectDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProjectDto> update(@PathVariable("id") Long id, @RequestBody ProjectDto projectDto) {

        return ResponseEntity.ok(this.projectServiceImp.update(id, projectDto));
    }
}
