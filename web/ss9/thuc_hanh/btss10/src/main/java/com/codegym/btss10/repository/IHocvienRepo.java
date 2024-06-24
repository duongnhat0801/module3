package com.codegym.btss10.repository;

import com.codegym.btss10.model.Hocvien;

import java.sql.SQLException;
import java.util.List;

public interface IHocvienRepo {
List<Hocvien> selectAll() throws SQLException;


}
