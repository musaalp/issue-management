package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.entities.IssueHistory;
import com.malp.issuemanagement.repositories.IssueHistoryRepository;
import com.malp.issuemanagement.services.IssueHistoryService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // add this service to container as a singleton
public class IssueHistoryServiceImpl implements IssueHistoryService {

    private final IssueHistoryRepository issueHistoryRepository;

    public IssueHistoryServiceImpl(IssueHistoryRepository issueHistoryRepository) {
        this.issueHistoryRepository = issueHistoryRepository;
    }

    @Override
    public IssueHistory save(IssueHistory issueHistory) {
        if (issueHistory.getDate() == null) {
            throw new IllegalArgumentException("Issue date cannot be null");
        }

        return this.issueHistoryRepository.save(issueHistory);
    }

    @Override
    public IssueHistory getById(Long id) {
        return this.issueHistoryRepository.getOne(id);
    }

    @Override
    public Page<IssueHistory> getAll(Pageable pageable) {
        return this.issueHistoryRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(IssueHistory issueHistory) {
        issueHistoryRepository.delete(issueHistory);
        return Boolean.TRUE;
    }
}
