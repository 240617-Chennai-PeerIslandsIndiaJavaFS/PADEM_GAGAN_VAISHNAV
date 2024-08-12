package org.revature.springbootdemo.dao;

import org.revature.springbootdemo.models.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Tasks, Integer> {

}
