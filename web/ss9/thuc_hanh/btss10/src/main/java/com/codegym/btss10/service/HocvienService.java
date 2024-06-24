package com.codegym.btss10.service;

import com.codegym.btss10.model.Hocvien;
import com.codegym.btss10.repository.HocvienRepo;
import com.codegym.btss10.repository.IHocvienRepo;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

public class HocvienService implements IHocvienService{
    IHocvienRepo hocvienRepo = new HocvienRepo();
    @Override
    public List<Hocvien> selectAll() {
        try {
           return hocvienRepo.selectAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
