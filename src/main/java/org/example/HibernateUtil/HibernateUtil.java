package org.example.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory factory = buildSessionFatory();

    private static SessionFactory buildSessionFatory() {
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            return config.buildSessionFactory();
        } catch (Exception e) {
            throw new RuntimeException("không tạo được SessionFactory do lỗi " + e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory () {
        return factory;
    }


}
