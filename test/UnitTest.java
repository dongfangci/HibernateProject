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
		//�������ö���		
		Configuration config= new Configuration().configure();
		//����ע�����
		ServiceRegistry serviceRegitry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
		//����session����
		sessionFactory = config.buildSessionFactory(serviceRegitry);
		//����session����
		session = sessionFactory.openSession();
	    //��������
		transaction = session.beginTransaction();
		
	}
	
	@After
	public void destroy(){
		//�ύ����
		transaction.commit();
		//�ر���Դ
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testSaveStudents(){
		//��		
		//Student stu = new Student(100,"jn",34,1);
		Student stu = new Student();
		stu.setName("Old");
		stu.setAge(34);
		stu.setSex(0);
		//�����󱣴浽session�����У�û�������ύ
		session.save(stu);
		//save����֮����Ȼ�����޸Ķ��������
		stu.setName("New");
		
	}
	
	@Test
	public void testGetStudents(){
		//get�飬���ú���������SQL��䣬���س־û�����,��ѯ�����ڷ���null
		Student stu = (Student) session.get(Student.class, 2);
		System.out.println(stu.getClass().getName());
		System.out.println(stu);
		
	} 
	
	@Test
	public void testLoadStudents(){
		//load�飬���ú󷵻ش������ʹ�õ�����������ʱ�ŷ���SQL,��ѯ���������쳣
		Student stu = (Student) session.load(Student.class, 2);
		System.out.println(stu.getClass().getName());
		System.out.println(stu);
		
	}
	
	@Test
	public void testUpdateStudents(){
		//��
		Student stu = (Student) session.get(Student.class, 1);
		stu.setName("Tom");
		session.update(stu); 
		System.out.println(stu);
		
	}
	
	@Test
	public void testDeleteStudents(){
		//ɾ
		Student stu = (Student) session.get(Student.class, 1);
		session.delete(stu);
		
	}
}
