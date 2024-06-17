package com.codegym.quanli_sinhvinejsb.repository;

import com.codegym.quanli_sinhvinejsb.database.DBConnect;
import com.codegym.quanli_sinhvinejsb.entities.Classroom;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepository {
    private Connection connection;

    public ClassRepository() {
        DBConnect dbConnect = new DBConnect();
        this.connection = dbConnect.getConnection();
    }

    public List<Classroom> getAllClassroom() throws SQLException {
        String sql = "select * from `classroom`";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Classroom> classrooms = new ArrayList<Classroom>();
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Classroom classroom = new Classroom(id, name);
            classrooms.add(classroom);
        }
        return classrooms;
    }

    public Classroom findById(int Id) throws Exception {
        String sql = "select * from `classroom` where `id` = ? ";
        PreparedStatement statement = this.connection.prepareStatement(sql);
        statement.setInt(1, Id);
        ResultSet resultSet = statement.executeQuery();
        Classroom classroom = null;
        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            classroom = new Classroom(id, name);
        }
        return classroom;
    }
}
