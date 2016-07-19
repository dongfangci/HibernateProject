import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class StudengTest {

	public static void main(String[] args) {
		Configuration cf= new Configuration().configure();
		ServiceRegistry ser = new ServiceRegistryBuilder().applySettings(cf.getProperties()).buildServiceRegistry();			
			
		SessionFactory sef = cf.buildSessionFactory(ser);
		Session ses = sef.openSession();
		ses.beginTransaction();
		
		
		Student stu = new Student(5,"john",34,1);
		ses.save(stu);
		ses.getTransaction().commit();
	}

}
