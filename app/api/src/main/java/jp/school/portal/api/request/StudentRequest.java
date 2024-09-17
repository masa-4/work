package jp.school.portal.api.request;

import java.io.Serializable;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class StudentRequest implements Serializable {
  
  public StudentRequest() {
    
  }
  
  @NotNull(message = "必須パラメータが欠如しています")
  private Integer facilitator_id;

  private Integer page = 0;

  private Integer limit = 5;

  @Pattern(regexp = "(id|teacherId|studentName|loginId|classId|className)", message = "指定された値は無効です")
  private String sort = "id";

  @Pattern(regexp = "asc|desc", message = "指定された値は無効です")
  private String order = "asc";

  private String name_like = null;

  private String loginId_like = null;
}
