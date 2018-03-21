package curd;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test")
public class TestEntity {
	private static final long serialVersionUID = 1L;
	@Id
	// @GeneratedValue
	private Integer id;
	private String book;

	public TestEntity() {
	}

	public TestEntity(Integer id, String book) {
		this.id = id;
		this.book = book;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBook() {
		return book;
	}

	public void setBook(String book) {
		this.book = book;
	}

}
