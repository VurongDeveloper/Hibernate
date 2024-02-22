package org.example.dao;

import jakarta.persistence.Query;
import org.example.Object.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;

public class UserDAO implements DAOinterface<Users> {

    public static UserDAO getInstance() {
        return new UserDAO();
    }
    @Override
    public int insert(Users t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            session.save(t);
            System.out.println("đã thêm 1 người dùng");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể thêm người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int update(Users t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            /*Users myUser = t;
            session.update(myUser);*/

            String hql = "UPDATE Users SET userId = :userId, userName = :userName, passWord = :passWord, email = :email, phone = :phone, fullName = :fullName, avatarURL = :avatarURL WHERE " + "userId = 3";
            Query query = session.createQuery(hql);
            query.setParameter("userId", t.getUserId());
            query.setParameter("userName", t.getUserName());
            query.setParameter("passWord", t.getPassWord());
            query.setParameter("email", t.getEmail());
            query.setParameter("phone", t.getPhone());
            query.executeUpdate();

            System.out.println("đã cập nhật 1 người dùng");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể cập nhật người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int delete(Users t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "DELETE FROM Users WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", t.getUserId());
            int check = query.executeUpdate();
            System.out.println(check);
            //session.delete(t);

            System.out.println("Đã xóa 1 người dùng");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể xóa người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public ArrayList<Users> selectAll(SessionFactory factory) {
        ArrayList<Users> arrl = new ArrayList<>();

        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "FROM Users";
            Query query = session.createQuery(hql);
            arrl = (ArrayList<Users>) query.getResultList();

            System.out.println("Đã lấy được danh sách người dùng");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra danh sách người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return arrl;
    }

    @Override
    public Users selectById(int idSelect, SessionFactory factory) {
        Users myUser = new Users();
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            /*
            String hql = "FROM Users WHERE userId = :userId";
            Query query = session.createQuery(hql);
            query.setParameter("userId", idSelect);
            myUser = (Users) ((org.hibernate.query.Query<?>) query).uniqueResult();
            */

            myUser = session.get(Users.class, idSelect);

            System.out.println("Đã lấy được người dùng dựa trên id người dùng");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra được người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return myUser;
    }

    @Override
    public ArrayList<Users> selectByCondition(String condition, SessionFactory factory) {
        ArrayList<Users> arrl = new ArrayList<>();
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "FROM Users WHERE " + condition;
            Query query = session.createQuery(hql);
            arrl = (ArrayList<Users>) query.getResultList();

            System.out.println("Đã lấy được người dùng dựa trên điều kiện");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra được người dùng do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return arrl;
    }
}
