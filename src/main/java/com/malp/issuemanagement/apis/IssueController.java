package com.malp.issuemanagement.apis;

import com.malp.issuemanagement.dtos.IssueDto;
import com.malp.issuemanagement.services.impl.IssueServiceImpl;
import com.malp.issuemanagement.util.ApiPaths;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
public class IssueController {
    private final IssueServiceImpl issueServiceImp;

    public IssueController(IssueServiceImpl issueServiceImp) {

        this.issueServiceImp = issueServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {

        IssueDto issueDto = this.issueServiceImp.getById(id);

        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    public ResponseEntity<IssueDto> create(@RequestBody IssueDto issueDto) {

        return ResponseEntity.ok(this.issueServiceImp.save(issueDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<IssueDto> update(@PathVariable(value = "id", required = true) Long id, @RequestBody IssueDto issueDto) {

        return ResponseEntity.ok(this.issueServiceImp.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(this.issueServiceImp.deleteById(id));
    }
}
