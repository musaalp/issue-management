package com.malp.issuemanagement.services;

import com.malp.issuemanagement.entities.IssueHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueHistoryService {

    IssueHistory save(IssueHistory issue);

    IssueHistory getById(Long id);

    Page<IssueHistory> getAll(Pageable pageable);

    Boolean delete(IssueHistory issueHistory);
}
