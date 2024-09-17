package jp.school.portal.api.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jp.school.portal.api.request.StudentRequest;
import jp.school.portal.domain.entity.Student;
import jp.school.portal.domain.repository.StudentRepositoryInterfase;

@Service
public class StudentService {
  @Autowired
  StudentRepositoryInterfase studentRepositoryInterfase;

  public Specification<Student> getConditions(StudentRequest studentRequest) {
    return new Specification<Student>() {
          @Override
          public Predicate toPredicate(Root<Student> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
          List<Predicate> predicates = new ArrayList<>();

          // 教師IDは必須パラメータ
          predicates.add(criteriaBuilder.equal(root.get("teacherId"), studentRequest.getFacilitator_id()));

          // 生徒名での曖昧検索があれば検索条件に追加する
          if (studentRequest.getName_like() != null) {
            predicates.add(criteriaBuilder.like(root.get("studentName"), convertPattern(studentRequest.getName_like())));
          }

          // ログインIDでの曖昧検索があれば検索条件に追加する
          if (studentRequest.getLoginId_like() != null) {
            predicates.add(criteriaBuilder.like(root.get("loginId"), convertPattern(studentRequest.getLoginId_like())));
          }
          return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        }
      };
  }

  public Page<Student> getResults(StudentRequest studentRequest, Specification<Student> conditions) {
    PageRequest pageRequest = buildPageRequest(studentRequest); 
    return studentRepositoryInterfase.findAll(conditions, pageRequest);
  }

  /**
   * 曖昧検索文字列に変換する
   * @param likeParm
   * @return
   */
  private String convertPattern(String likeParm) {
    return "%" + likeParm + "%";
  }

  /**
   * ページネーションのための準備
   * @param pageSize
   * @param pageNumber
   * @param sortBy
   * @return
   */
  private PageRequest buildPageRequest(StudentRequest studentRequest) {
    Direction direction = studentRequest.getOrder().equals("desc") ?  Direction.DESC : Direction.ASC;
    String sortKey = studentRequest.getSort();
    Sort sort = Sort.by(direction, sortKey);
    return PageRequest.of(studentRequest.getPage(), studentRequest.getLimit(), sort);
  }
}
