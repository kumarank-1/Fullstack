package com.funfit.dao;

import com.funfit.model.Participant;

import java.sql.SQLException;
import java.util.List;

public interface ParticipantDao extends GenericDao<Participant> {
    List<Participant> findByBatchId(int batchId) throws SQLException;
}
