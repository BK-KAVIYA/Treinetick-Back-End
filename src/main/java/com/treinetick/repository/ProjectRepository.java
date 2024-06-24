package com.treinetick.repository;


import com.treinetick.model.Project;
import com.treinetick.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProjectRepository extends JpaRepository<Project, String> {
//    Optional<User> findByProjectID(String projectID);
}
