package jp.school.portal.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import jp.school.portal.api.request.StudentRequest;
import jp.school.portal.api.response.stundent.ClassResponse;
import jp.school.portal.api.response.stundent.OutputBoundary;
import jp.school.portal.api.response.stundent.StudentResponse;
import jp.school.portal.api.service.StudentService;
import jp.school.portal.domain.entity.Student;


@RestController
public class StudentController {
  @Autowired
  StudentService studentService;

  @GetMapping("/students")
  public OutputBoundary<StudentResponse> getAll(@Valid @ModelAttribute StudentRequest studentRequest) {
      Specification<Student> conditions = studentService.getConditions(studentRequest);
      Page<Student> searchResults = studentService.getResults(studentRequest, conditions); 

      List<StudentResponse> studentResponses = searchResults.getContent().stream()
      .map(student -> new StudentResponse(
        student.getId(),
        student.getStudentName(),
        student.getLoginId(),
        new ClassResponse(
          student.getClassId(),
          student.getClassName()
          )
        )).collect(Collectors.toList());
      return new OutputBoundary<StudentResponse>(studentResponses, studentResponses.size());
  }
  
  /**
   * ヘルスチェック用
   * @return String
   */
  @GetMapping("/ping")
  public String ping() {
    return "It's OK!";
  }
}
