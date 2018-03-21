package curd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

public interface TestDto extends JpaRepository<TestEntity, Integer> {

}
