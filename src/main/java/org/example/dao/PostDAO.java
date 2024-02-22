package org.example.dao;

import jakarta.persistence.Query;
import org.example.Object.Posts;
import org.example.Object.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;

public class PostDAO implements DAOinterface<Posts> {

    public static PostDAO getInstance() {
        return new PostDAO();
    }
    @Override
    public int insert(Posts t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            session.save(t);
            System.out.println("đã thêm 1 bài viết");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể thêm bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int update(Posts t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            /*Users myUser = t;
            session.update(myUser);*/

            String hql = "UPDATE Posts SET postId = :postId, caption = :caption, mediaURL = :mediaURL, createAt = :createAt WHERE " + "postId = 1";
            Query query = session.createQuery(hql);
            query.setParameter("postId", t.getPostId());
            query.setParameter("caption", t.getCaption());
            query.setParameter("mediaURL", t.getMediaURL());
            query.setParameter("createAt", t.getCreateAt());
            query.executeUpdate();

            System.out.println("đã cập nhật 1 bài viết");

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể cập nhật bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public int delete(Posts t, SessionFactory factory) {
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "DELETE FROM Posts WHERE postId = :postId";
            Query query = session.createQuery(hql);
            query.setParameter("postId", t.getPostId());
            int check = query.executeUpdate();
            System.out.println(check);
            //session.delete(t);

            System.out.println("Đã xóa 1 bài viết");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể xóa bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return 0;
    }

    @Override
    public ArrayList<Posts> selectAll(SessionFactory factory) {
        ArrayList<Posts> arrl = new ArrayList<>();

        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "FROM Posts";
            Query query = session.createQuery(hql);
            arrl = (ArrayList<Posts>) query.getResultList();

            System.out.println("Đã lấy được danh sách bài viết");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra danh sách bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return arrl;
    }

    @Override
    public Posts selectById(int idSelect, SessionFactory factory) {
        Posts myPost = new Posts();
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

            myPost = session.get(Posts.class, idSelect);

            System.out.println("Đã lấy được bài viết dựa trên id bài viết");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra được bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return myPost;
    }

    @Override
    public ArrayList<Posts> selectByCondition(String condition, SessionFactory factory) {
        ArrayList<Posts> arrl = new ArrayList<>();
        Transaction transaction = null;
        Session session = factory.openSession();
        try {
            transaction = session.beginTransaction();

            String hql = "FROM Posts WHERE " + condition;
            Query query = session.createQuery(hql);
            arrl = (ArrayList<Posts>) query.getResultList();

            System.out.println("Đã lấy được bài viết dựa trên điều kiện");


            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            System.out.println("không thể lấy ra được bài viết do lỗi " + e.getMessage());
        }
        finally {
            session.close();
        }
        return arrl;
    }
}

