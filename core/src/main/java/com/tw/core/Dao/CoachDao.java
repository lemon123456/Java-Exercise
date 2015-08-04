package com.tw.core.Dao;

import com.tw.core.entity.Coach;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;

/**
 * Created by twer on 7/22/15.
 */

@Repository
public class CoachDao {

    public List<Coach> getCoaches() throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Employee employee where employee.role = 'COACH' "); //此处User是类名，而不是数据库的表名,select * 不写
        List<Coach> coachList = query.list();
        session.close();
        return coachList;
    }
}
