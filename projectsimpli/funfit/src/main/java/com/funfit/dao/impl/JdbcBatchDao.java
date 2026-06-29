package com.funfit.dao.impl;

import com.funfit.dao.BatchDao;
import com.funfit.model.Batch;
import com.funfit.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcBatchDao implements BatchDao {
    private static final String INSERT_BATCH = "INSERT INTO batches "
            + "(batch_name, time_slot, instructor_name, capacity, start_time, end_time) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_BATCH_BY_ID = "SELECT * FROM batches WHERE id = ?";
    private static final String SELECT_ALL_BATCHES = "SELECT * FROM batches ORDER BY id DESC";
    private static final String UPDATE_BATCH = "UPDATE batches SET batch_name = ?, time_slot = ?, "
            + "instructor_name = ?, capacity = ?, start_time = ?, end_time = ? WHERE id = ?";
    private static final String DELETE_BATCH = "DELETE FROM batches WHERE id = ?";

    @Override
    public int create(Batch batch) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_BATCH, Statement.RETURN_GENERATED_KEYS)) {
            setBatchFields(statement, batch);
            statement.executeUpdate();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                if (keys.next()) {
                    return keys.getInt(1);
                }
            }
        }
        return 0;
    }

    @Override
    public Optional<Batch> findById(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_BATCH_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapBatch(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Batch> findAll() throws SQLException {
        List<Batch> batches = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_BATCHES);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                batches.add(mapBatch(resultSet));
            }
        }
        return batches;
    }

    @Override
    public boolean update(Batch batch) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_BATCH)) {
            setBatchFields(statement, batch);
            statement.setInt(7, batch.getId());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_BATCH)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    private void setBatchFields(PreparedStatement statement, Batch batch) throws SQLException {
        statement.setString(1, batch.getBatchName());
        statement.setString(2, batch.getTimeSlot());
        statement.setString(3, batch.getInstructorName());
        statement.setInt(4, batch.getCapacity());
        statement.setTime(5, Time.valueOf(batch.getStartTime()));
        statement.setTime(6, Time.valueOf(batch.getEndTime()));
    }

    private Batch mapBatch(ResultSet resultSet) throws SQLException {
        Batch batch = new Batch();
        batch.setId(resultSet.getInt("id"));
        batch.setBatchName(resultSet.getString("batch_name"));
        batch.setTimeSlot(resultSet.getString("time_slot"));
        batch.setInstructorName(resultSet.getString("instructor_name"));
        batch.setCapacity(resultSet.getInt("capacity"));
        batch.setStartTime(resultSet.getTime("start_time").toLocalTime());
        batch.setEndTime(resultSet.getTime("end_time").toLocalTime());
        return batch;
    }
}
