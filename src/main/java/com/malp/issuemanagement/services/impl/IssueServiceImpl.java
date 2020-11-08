package com.malp.issuemanagement.services.impl;

import com.malp.issuemanagement.dtos.IssueDto;
import com.malp.issuemanagement.entities.Issue;
import com.malp.issuemanagement.repositories.IssueRepository;
import com.malp.issuemanagement.services.IssueService;
import com.malp.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

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

        Issue issue = this.issueRepository.getOne(id);

        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAll(Pageable pageable) {

        Page<Issue> page = this.issueRepository.findAll(pageable);
        TPage tPage = new TPage<IssueDto>();
        IssueDto[] issueDtos = modelMapper.map(page.getContent(), IssueDto[].class);
        tPage.setStats(page, Arrays.asList(issueDtos));

        return tPage;
    }

    @Override
    public Boolean delete(IssueDto issue) {
        return null;
    }

    @Override
    public Boolean deleteById(Long id) {

        this.issueRepository.deleteById(id);

        return Boolean.TRUE;
    }

    @Override
    public IssueDto update(Long id, IssueDto issueDto) {

        return null;
    }
}
