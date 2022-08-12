

package com.example.spiderr.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.spiderr.emtity.Student;
import com.example.spiderr.service.vo.ResponseTemplate;





@Service
public interface StudentService {
	
	Student add(Student stu);
	List<Student> list();
	Student searchById(long id);
	ResponseTemplate stuWithColl(long empId);
	Student assignCollege(long stuId, long collId);
	List<Student> getByCollId(long coll_id);
	List<Student> getStudentByCollegetWithDescAge(long coll_id);

	
}
