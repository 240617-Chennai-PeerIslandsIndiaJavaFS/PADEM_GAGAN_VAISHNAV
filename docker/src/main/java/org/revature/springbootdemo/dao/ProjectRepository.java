package org.revature.springbootdemo.dao;

import org.revature.springbootdemo.models.Projects;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Projects,Integer> {

}
