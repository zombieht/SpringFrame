package curd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface TestDto extends JpaRepository<TestEntity, Integer> {

}
