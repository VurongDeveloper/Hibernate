package org.example.Tests;

import org.example.HibernateUtil.HibernateUtil;
import org.example.Object.Posts;
import org.example.Object.Users;
import org.example.dao.PostDAO;
import org.example.dao.UserDAO;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();

//        Transaction transaction = null;
//        Session session = factory.openSession();

//        Users myUser = new Users(1, "ttny", "45678", "nhuy@", "0358124", "trannhuy", "https://");
        /*try {
            transaction = session.beginTransaction();

            session.save(myUser);
            System.out.println("đã thêm 1 người dùng");

            transaction.commit();
        } catch (Exception e) {
            System.out.println("không thể thêm người dùng do lỗi " + e.getMessage();
        }
        finally {
            session.close();
            factory.close();
        }*/

//        UserDAO.getInstance().insert(myUser, factory);
       /* ArrayList<Users> arrl = new ArrayList<>();
        arrl = UserDAO.getInstance().selectAll(factory);
        Iterator<Users> iter = arrl.iterator();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "userId", "userName", "passWord", "email", "phone", "fullName", "avatarURL");
        while (iter.hasNext()) {
            Users u = iter.next();
            u.printUser();
        }*/

        /*Users myUser =  UserDAO.getInstance().selectById(1, factory);
        myUser.printUser();*/
        /*
        ArrayList<Users> arrl = new ArrayList<>();
        arrl = UserDAO.getInstance().selectByCondition("userName = 'tlv'", factory);
        Iterator<Users> iter = arrl.iterator();
        System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s\n", "userId", "userName", "passWord", "email", "phone", "fullName", "avatarURL");
        while (iter.hasNext()) {
            Users myUser = iter.next();
            myUser.printUser();
        }*/

        /*Users myUser = new Users(3, "ntdh", "987654", "dieuhien", "0348592", "nguyenthidieuhien", "https://");
        UserDAO.getInstance().update(myUser, factory);*/

        /*Users myUser = UserDAO.getInstance().selectById(3, factory);
        UserDAO.getInstance().delete(myUser, factory);*/

        Posts myPost = PostDAO.getInstance().selectById(1, factory);
        myPost.printPost();
        Users myUser = UserDAO.getInstance().selectById(myPost.getUser().getUserId(), factory);
        myUser.printUser();
    }
}
