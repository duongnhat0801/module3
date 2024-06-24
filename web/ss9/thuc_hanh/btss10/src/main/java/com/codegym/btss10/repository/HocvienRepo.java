package com.codegym.btss10.repository;

import com.codegym.btss10.database.DBConnection;
import com.codegym.btss10.model.Hocvien;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class HocvienRepo implements IHocvienRepo{

    @Override
    public List<Hocvien> selectAll() throws SQLException {
         List<Hocvien> hocviens = new ArrayList<>();
        Connection connection = new DBConnection().getConnection();
        String sql = "select * from hocvien";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String gender = rs.getString("gender");
            int score = rs.getInt("score");
            Hocvien hocvien = new Hocvien(id,name,gender,score);
            hocviens.add(hocvien);
        }
        return hocviens;
    }

}
