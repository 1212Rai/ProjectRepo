package com.example.spiderr;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import com.example.spiderr.emtity.Student;
import com.example.spiderr.repository.StudentRepository;



@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class StudentApplicationTests {

	@Autowired
    private MockMvc mockMvc; 
	
	@Autowired
    private StudentRepository studentRepository;
	
	@BeforeEach
    void setup(){
        studentRepository.deleteAll();
    }

	@Test
    public void givenListOfEmployees_whenGetAllEmployees_thenReturnEmployeesList() throws Exception{
        // given - precondition or setup
        List<Student> listOfStudents = new ArrayList<>();
        listOfStudents.add(new Student());
        listOfStudents.add(new Student());
        studentRepository.saveAll(listOfStudents);
       
        ResultActions response = mockMvc.perform(get("http://localhost:9078/student"));

        // then - verify the output
        response.andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.size()",
                        is(listOfStudents.size())));

    }
}
