package jedis;

import java.io.Serializable;

/**
 * @author : Just wyx
 * @Date : 2020/11/20
 */
public class Person  implements Serializable {
	private static final long serialVersionUID = -7125642695178165650L;

	private String name;
	private Integer age;

	public Person(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				'}';
	}
}