package com.malp.issuemanagement.services;

import com.malp.issuemanagement.dtos.IssueDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issueDto);

    IssueDto getById(Long id);

    Page<IssueDto> getAll(Pageable pageable);

    Boolean delete(IssueDto issueDto);
}
