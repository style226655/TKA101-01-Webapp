package Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static StandardServiceRegistry registry;
	private static final SessionFactory sessionFactory = createSessionFactory();
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	private static SessionFactory createSessionFactory() {
		try {
			//載入 hibernate.cfg.xml 檔
			registry = new StandardServiceRegistryBuilder()
					.configure()
					.build();
			//建立 Session Factory
			SessionFactory sessionFactory = new MetadataSources(registry)
					.buildMetadata()
					.buildSessionFactory();
			
			return sessionFactory;
			
		}catch (Exception e) {
			e.printStackTrace();
			throw new ExceptionInInitializerError(e);
		}
	}
		//commit 完畢，資源關閉與釋放
		public static void shutdown() {
			if(registry != null)
				StandardServiceRegistryBuilder.destroy(registry);
		}
}