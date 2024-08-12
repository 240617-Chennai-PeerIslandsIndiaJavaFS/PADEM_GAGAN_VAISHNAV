package org.revature.springbootdemo.project;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.revature.springbootdemo.controller.ProjectController;
import org.revature.springbootdemo.models.Projects;
import org.revature.springbootdemo.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProjectController.class)
public class ProjectMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProjectService projectService;

    private List<Projects> projectsList;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);

        projectsList=new ArrayList<>();
        Projects projects1=new Projects();
        projects1.setProject_id(8);
        projects1.setProject_name("MVC PROJECT");

        projectsList.add(projects1);
    }

//    @Test
//    public void testGetProjectById(){
//        when(projectService.getProjectById(2))
//                .thenReturn(Optional.of(projectsList.get(0)));
//
//        try{
//            mockMvc.perform(get("/api/projects/8").accept(MediaType.APPLICATION_JSON))
//                    .andExpect(status().isOk())
//                    .andExpect(jsonPath("project_name").value("MVC PROJECT"));
//        }catch(Exception ex){
//            System.out.println(ex.getMessage());
//        }
//    }

    @Test
    public void testAllProjects(){
        when(projectService.getAllProjects())
                .thenReturn(projectsList);

        try{
            mockMvc.perform(get("/api/projects")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].project_name").value("MVC PROJECT"));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Test
    public void testCreateProject(){
        try{
            mockMvc.perform(post("/api/projects")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content("{\"project_name\":\"project-mock-spring\"}"))
                    .andExpect(status().isCreated());
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
