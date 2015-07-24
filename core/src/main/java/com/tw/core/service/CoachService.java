package com.tw.core.service;

import com.tw.core.Dao.CoachDao;
import com.tw.core.entity.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;


@Service
public class CoachService {

    @Autowired
    private CoachDao coachDao;

    public List<Coach> getCoaches(){
        try {
            return coachDao.getCoaches();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
