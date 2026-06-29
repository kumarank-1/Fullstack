package com.funfit.repository;

import com.funfit.dao.ParticipantDao;
import com.funfit.dao.impl.JdbcParticipantDao;
import com.funfit.model.Participant;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ParticipantRepository {
    private final ParticipantDao participantDao;

    public ParticipantRepository() {
        this(new JdbcParticipantDao());
    }

    public ParticipantRepository(ParticipantDao participantDao) {
        this.participantDao = participantDao;
    }

    public int addParticipant(Participant participant) throws SQLException {
        return participantDao.create(participant);
    }

    public Optional<Participant> getParticipant(int id) throws SQLException {
        return participantDao.findById(id);
    }

    public List<Participant> getAllParticipants() throws SQLException {
        return participantDao.findAll();
    }

    public List<Participant> getParticipantsByBatch(int batchId) throws SQLException {
        return participantDao.findByBatchId(batchId);
    }

    public boolean updateParticipant(Participant participant) throws SQLException {
        return participantDao.update(participant);
    }

    public boolean deleteParticipant(int id) throws SQLException {
        return participantDao.delete(id);
    }
}
