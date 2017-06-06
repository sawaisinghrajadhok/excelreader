package org.opallios.excel.mapping.hibernate.util;

  
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.opallios.excel.mapping.yml.ConfiguredData;
 
public class HibernateUtil {
    private static SessionFactory sessionFactory = null;
 
    private static SessionFactory buildSessionFactory(ConfiguredData configuredData) {
        if (sessionFactory != null ) {
        	return sessionFactory;
        } else {
        	try {
           	 	Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                Properties properties = configuration.getProperties();
                properties.setProperty("hibernate.connection.url", configuredData.getUrl());
                properties.setProperty("hibernate.connection.username", configuredData.getUsername());
                properties.setProperty("hibernate.connection.password", configuredData.getPassword());
                StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(properties);
                sessionFactory = configuration.buildSessionFactory(ssrb.build());
                return sessionFactory;
           } catch (Throwable ex) {
               throw new ExceptionInInitializerError(ex);
           }
        }
    }
 
    public static SessionFactory getSessionFactory(ConfiguredData configuredData) {
        return buildSessionFactory(configuredData);
    }
 
    public static void shutdown() {
    	sessionFactory.close();
    }
} 