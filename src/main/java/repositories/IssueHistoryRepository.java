package repositories;

import entities.IssueHistory;
import org.springframework.data.jpa.repository.JpaRepository;

// JpaRepository lives as singleton in the container, therefore our Repositories life cycle is singleton
public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {
}
