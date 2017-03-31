package curd;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/test2")
@RestController
@EnableAutoConfiguration
public class TestController {
	@Autowired
	TestDto testCurd;

	@RequestMapping("/select")
	public List<TestEntity> selectAll() {
		return testCurd.findAll();
	}

	@RequestMapping("/add")
	public String addAccount(Integer id, String book) {
		TestEntity test = new TestEntity(id, book);
		testCurd.save(test);
		return "success";
	}

	@RequestMapping("/delete")
	public String deleteAccount(@RequestParam("id") int id) {
		testCurd.delete(id);
		return "success";
	}

	@RequestMapping("/update")
	public TestEntity testUpdate(@RequestParam("id") int id, @RequestParam("book") String book) {
		TestEntity test = new TestEntity();
		test.setId(id);
		test.setBook(book);
		return testCurd.save(test);
	}

	@GetMapping(value = "/read/{id}")
	public TestEntity FindOne(@PathVariable("id") Integer id) {
		return testCurd.findOne(id);
	}

	@RequestMapping(value = "/read")
	public TestEntity FindOne2(@RequestParam("id") Integer id) {
		return testCurd.findOne(id);
	}
}
