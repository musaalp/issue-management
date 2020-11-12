package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.IssueDto;
import com.malp.issuemanagement.dtos.ProjectDto;
import com.malp.issuemanagement.services.impl.IssueServiceImpl;
import com.malp.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api
public class IssueController {
    private final IssueServiceImpl issueServiceImp;

    public IssueController(IssueServiceImpl issueServiceImp) {

        this.issueServiceImp = issueServiceImp;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get by id operation", response = ProjectDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {

        IssueDto issueDto = this.issueServiceImp.getById(id);

        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @ApiOperation(value = "Create operation", response = ProjectDto.class)
    public ResponseEntity<IssueDto> create(@RequestBody IssueDto issueDto) {

        return ResponseEntity.ok(this.issueServiceImp.save(issueDto));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update by id operation", response = ProjectDto.class)
    public ResponseEntity<IssueDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody IssueDto issueDto) {

        return ResponseEntity.ok(this.issueServiceImp.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete by id operation", response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(this.issueServiceImp.deleteById(id));
    }
}
