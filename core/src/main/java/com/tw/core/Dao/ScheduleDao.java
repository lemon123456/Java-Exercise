package com.tw.core.Dao;

import com.tw.core.entity.Schedule;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

import static com.tw.core.Util.HibernateUtil.getSessionFactory;


@Repository
public class ScheduleDao {

    public List<Schedule> getSchedules() throws SQLException {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("from Schedule");
        List<Schedule> scheduleList = query.list();
        session.close();
        return scheduleList;
    }

    public void deleteSchedule(int id) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        Schedule schedule = new Schedule();
        schedule.setId(id);
        session.delete(schedule);
        session.getTransaction().commit();

        session.close();
    }

    public void insertSchedule(Schedule schedule) throws SQLException {

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.save(schedule);
        session.getTransaction().commit();
        session.close();
    }

    public Schedule getOneSchedule(int id) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Schedule schedule = (Schedule)session.get(Schedule.class,id);

        session.close();
        return schedule;
    }


    public void updateOneSchedule(Schedule schedule) throws SQLException{

        Session session = getSessionFactory().openSession();
        session.beginTransaction();

        session.update(schedule);
        session.getTransaction().commit();
        session.close();
    }

}
