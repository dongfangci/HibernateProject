import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UnitTest {
	private SessionFactory sessionFactory;
	private Session session;
	private Transaction transaction;
	
	@Before
	public void init(){
		//创建配置对象		
		Configuration config= new Configuration().configure();
		//创建注册对象
		ServiceRegistry serviceRegitry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//创建session工厂
		sessionFactory = config.buildSessionFactory(serviceRegitry);
		//创建session对象
		session = sessionFactory.openSession();
	    //开启事务
		transaction = session.beginTransaction();
		
	}
	
	@After
	public void destroy(){
		//提交事务
		transaction.commit();
		//关闭资源
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents(){
		//增		
		//Student stu = new Student(100,"jn",34,1);
		Student stu = new Student();
		stu.setName("Old");
		stu.setAge(34);
		stu.setSex(0);
		//将对象保存到session缓存中，没有真正提交
		session.save(stu);
		//save方法之后依然可以修改对象的属性
		stu.setName("New");
		
	}
	
	@Test
	public void testGetStudents(){
		//get查，调用后立即发送SQL语句，返回持久化对象,查询不存在返回null
		Student stu = (Student) session.get(Student.class, 2);
		System.out.println(stu.getClass().getName());
		System.out.println(stu);
		
	} 
	
	@Test
	public void testLoadStudents(){
		//load查，调用后返回代理对象，使用到非主键属性时才发送SQL,查询不存在抛异常
		Student stu = (Student) session.load(Student.class, 2);
		System.out.println(stu.getClass().getName());
		System.out.println(stu);
		
	}
	
	@Test
	public void testUpdateStudents(){
		//改
		Student stu = (Student) session.get(Student.class, 1);
		stu.setName("Tom");
		session.update(stu); 
		System.out.println(stu);
		
	}
	
	@Test
	public void testDeleteStudents(){
		//删
		Student stu = (Student) session.get(Student.class, 1);
		session.delete(stu);
		
	}
}
