package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.dtos.IssueDto;
import com.malp.issuemanagement.entities.Issue;
import com.malp.issuemanagement.repositories.IssueRepository;
import com.malp.issuemanagement.services.IssueService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service // add this service to container as a singleton
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issueDto) {

        if (issueDto.getDate() == null) {
            throw new IllegalArgumentException("Issue date cannot be null");
        }

        Issue issue = this.modelMapper.map(issueDto, Issue.class);

        issue = this.issueRepository.save(issue);

        return this.modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
        return null;
    }

    @Override
    public Page<IssueDto> getAll(Pageable pageable) {
        return null;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }
}
