
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="student6")
public class Student {
	@Id
	@GeneratedValue
	private int sid;
	private String name;
	private int age;
	private int sex;
	
	public Student(){}

	public Student(int sid, String name, int age, int sex) {
		this.sid = sid;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
}
