package com.funfit.dao.impl;

import com.funfit.dao.ParticipantDao;
import com.funfit.model.Participant;
import com.funfit.util.DatabaseConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JdbcParticipantDao implements ParticipantDao {
    private static final String INSERT_PARTICIPANT = "INSERT INTO participants "
            + "(full_name, email, phone, age, gender, batch_id, joined_date) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PARTICIPANT_BY_ID = "SELECT * FROM participants WHERE id = ?";
    private static final String SELECT_ALL_PARTICIPANTS = "SELECT * FROM participants ORDER BY id DESC";
    private static final String SELECT_PARTICIPANTS_BY_BATCH = "SELECT * FROM participants WHERE batch_id = ? ORDER BY id DESC";
    private static final String UPDATE_PARTICIPANT = "UPDATE participants SET full_name = ?, email = ?, phone = ?, "
            + "age = ?, gender = ?, batch_id = ?, joined_date = ? WHERE id = ?";
    private static final String DELETE_PARTICIPANT = "DELETE FROM participants WHERE id = ?";

    @Override
    public int create(Participant participant) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(INSERT_PARTICIPANT,
                        Statement.RETURN_GENERATED_KEYS)) {
            setParticipantFields(statement, participant);
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
    public Optional<Participant> findById(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PARTICIPANT_BY_ID)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return Optional.of(mapParticipant(resultSet));
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Participant> findAll() throws SQLException {
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_ALL_PARTICIPANTS);
                ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                participants.add(mapParticipant(resultSet));
            }
        }
        return participants;
    }

    @Override
    public List<Participant> findByBatchId(int batchId) throws SQLException {
        List<Participant> participants = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(SELECT_PARTICIPANTS_BY_BATCH)) {
            statement.setInt(1, batchId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    participants.add(mapParticipant(resultSet));
                }
            }
        }
        return participants;
    }

    @Override
    public boolean update(Participant participant) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(UPDATE_PARTICIPANT)) {
            setParticipantFields(statement, participant);
            statement.setInt(8, participant.getId());
            return statement.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws SQLException {
        try (Connection connection = DatabaseConnection.getConnection();
                PreparedStatement statement = connection.prepareStatement(DELETE_PARTICIPANT)) {
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    private void setParticipantFields(PreparedStatement statement, Participant participant) throws SQLException {
        statement.setString(1, participant.getFullName());
        statement.setString(2, participant.getEmail());
        statement.setString(3, participant.getPhone());
        statement.setInt(4, participant.getAge());
        statement.setString(5, participant.getGender());
        if (participant.getBatchId() == null) {
            statement.setNull(6, Types.INTEGER);
        } else {
            statement.setInt(6, participant.getBatchId());
        }
        statement.setDate(7, Date.valueOf(participant.getJoinedDate()));
    }

    private Participant mapParticipant(ResultSet resultSet) throws SQLException {
        Participant participant = new Participant();
        participant.setId(resultSet.getInt("id"));
        participant.setFullName(resultSet.getString("full_name"));
        participant.setEmail(resultSet.getString("email"));
        participant.setPhone(resultSet.getString("phone"));
        participant.setAge(resultSet.getInt("age"));
        participant.setGender(resultSet.getString("gender"));

        int batchId = resultSet.getInt("batch_id");
        participant.setBatchId(resultSet.wasNull() ? null : batchId);
        participant.setJoinedDate(resultSet.getDate("joined_date").toLocalDate());
        return participant;
    }
}
