package org.revature.springbootdemo.project;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.revature.springbootdemo.dao.ProjectRepository;
import org.revature.springbootdemo.models.Projects;
import org.revature.springbootdemo.service.ProjectService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProjectsTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    public ProjectsTest(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateProjects(){
        Projects projects=new Projects();
        projects.setProject_id(9);
        projects.setProject_name("test Project");
        projects.setProject_desc("sample test cases are written");

        when(projectRepository.save(projects)).thenReturn(projects);

        Projects projects1=projectService.createProject(projects);

        assertNotNull(projects1);
        assertEquals("test Project",projects1.getProject_name());

        verify(projectRepository,times(1)).save(projects);
    }

    @Test
    public void testProjectById(){
        Projects projects=new Projects();
        projects.setProject_id(10);
        projects.setProject_name("sample project");

        when(projectRepository.findById(10)).thenReturn(Optional.of(projects));

        Projects projects1=projectService.getProjectById(10).get();

        assertNotNull(projects1);
        assertEquals(10,projects1.getProject_id());

        verify(projectRepository,times(1)).findById(10);
    }

    @Test
    public void testTaskProjectById(){
        Projects projects=new Projects();
        projects.setProject_id(10);
        projects.setProject_name("sample project");

        when(projectRepository.findById(10)).thenReturn(Optional.of(projects));

        Projects projects1=projectService.getProjectById(10).get();

        assertNotNull(projects1);
        assertEquals(10,projects1.getProject_id());

        verify(projectRepository,times(1)).findById(10);
    }

    //delete project test case
//    @Test
//    public void testDeleteProject(){
//        Projects projects=new Projects();
//        projects.setProject_id(11);
//        projects.setProject_name("delete this project");
//
//        when(projectRepository.delete(Projects projects));
//    }
}
