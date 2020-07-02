package ru.job4j.carSale.Util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import ru.job4j.carSale.Model.*;

import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    private static final HibernateUtil INSTANCE = new HibernateUtil();

    private HibernateUtil() {
    }

    public static HibernateUtil getInstance() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Properties app = new Properties();
                app.load(ru.job4j.carSale.Util.HibernateUtil.class
                        .getClassLoader()
                        .getResourceAsStream("app.properties"));

                Configuration config = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, app.getProperty("driver"));
                settings.put(Environment.URL, app.getProperty("url"));
                settings.put(Environment.USER, app.getProperty("username"));
                settings.put(Environment.PASS, app.getProperty("password"));
                settings.put(Environment.DIALECT, app.getProperty("dialect"));
                settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, app.getProperty("thread"));
                settings.put(Environment.SHOW_SQL, app.getProperty("show_sql"));
//                settings.put(Environment.HBM2DDL_AUTO, app.getProperty("hbm2ddl"));

                config.setProperties(settings);
                config.addAnnotatedClass(Advertisement.class);
                config.addAnnotatedClass(Brand.class);
                config.addAnnotatedClass(Car.class);
                config.addAnnotatedClass(Image.class);
                config.addAnnotatedClass(User.class);
                config.addAnnotatedClass(Engine.class);

                StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                        .applySettings(config.getProperties());
                sessionFactory = config.buildSessionFactory(builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
