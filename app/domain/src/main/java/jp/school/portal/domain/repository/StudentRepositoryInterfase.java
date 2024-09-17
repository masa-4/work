package jp.school.portal.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.school.portal.domain.entity.Student;

@Repository
public interface StudentRepositoryInterfase extends JpaRepository<Student, Long> {
  
}
