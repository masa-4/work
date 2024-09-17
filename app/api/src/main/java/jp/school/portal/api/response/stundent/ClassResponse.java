package jp.school.portal.api.response.stundent;

import lombok.Data;

@Data
public class ClassResponse {
 private Long id;
 private String name; 

 public ClassResponse(Long classId, String className) {
  this.id = classId;
  this.name = className;
 }
}
