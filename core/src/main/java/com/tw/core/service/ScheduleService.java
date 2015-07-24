package com.tw.core.service;

import com.tw.core.Dao.ScheduleDao;
import com.tw.core.entity.Employee;
import com.tw.core.entity.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleDao scheduleDao;

    public List<Schedule> getSchedules(){
        try {
            return scheduleDao.getSchedules();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteSchedule(int id){
        try {
            scheduleDao.deleteSchedule(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void insertSchedule(Schedule schedule){
        try {
            scheduleDao.insertSchedule(schedule);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public Schedule getOneSchedule(int id){
        try{
            return scheduleDao.getOneSchedule(id);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void updateOneSchedule(Schedule schedule){
        try{
            scheduleDao.updateOneSchedule(schedule);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
