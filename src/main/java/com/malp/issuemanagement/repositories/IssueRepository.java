package com.malp.issuemanagement.repositories;

import com.malp.issuemanagement.entities.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository lives as singleton in the container, therefore our Repositories life cycle is singleton
public interface IssueRepository extends JpaRepository<Issue, Long> {
}
