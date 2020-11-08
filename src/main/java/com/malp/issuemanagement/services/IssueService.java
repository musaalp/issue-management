package com.malp.issuemanagement.services;

import com.malp.issuemanagement.dtos.IssueDto;
import com.malp.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issueDto);

    IssueDto getById(Long id);

    TPage<IssueDto> getAll(Pageable pageable);

    Boolean delete(IssueDto issueDto);

    Boolean deleteById(Long id);

    IssueDto update(Long id, IssueDto issueDto);
}
