package com.funfit.repository;

import com.funfit.dao.BatchDao;
import com.funfit.dao.impl.JdbcBatchDao;
import com.funfit.model.Batch;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BatchRepository {
    private final BatchDao batchDao;

    public BatchRepository() {
        this(new JdbcBatchDao());
    }

    public BatchRepository(BatchDao batchDao) {
        this.batchDao = batchDao;
    }

    public int addBatch(Batch batch) throws SQLException {
        return batchDao.create(batch);
    }

    public Optional<Batch> getBatch(int id) throws SQLException {
        return batchDao.findById(id);
    }

    public List<Batch> getAllBatches() throws SQLException {
        return batchDao.findAll();
    }

    public boolean updateBatch(Batch batch) throws SQLException {
        return batchDao.update(batch);
    }

    public boolean deleteBatch(int id) throws SQLException {
        return batchDao.delete(id);
    }
}
