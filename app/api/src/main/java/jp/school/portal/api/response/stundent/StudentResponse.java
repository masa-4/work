package jp.school.portal.api.response.stundent;

import lombok.Data;

@Data
public class StudentResponse {
  private Long id;
  private String name;
  private String loginId;
  private ClassResponse classroom;

  public StudentResponse(
    Long id,
    String name,
    String loginId,
    ClassResponse classroom
  ) {
    this.id = id;
    this.name = name;
    this.loginId = loginId;
    this.classroom = classroom;
  }
}
