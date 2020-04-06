package id.dicka.backend.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import id.dicka.backend.entity.ProjectTask;

public interface ProjectTaskRepository extends JpaRepository<ProjectTask, Long>{

}
