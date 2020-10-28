package repositories;

import entities.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// JpaRepository lives as singleton in the container, therefore our Repositories life cycle is singleton
public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> getByProjectCode(String projectCode);

    Page<Project> getAll(Pageable pageable);

    List<Project> getAll(Sort sort);
}
