CREATE DATABASE IF NOT EXISTS funfit;

USE funfit;

CREATE TABLE IF NOT EXISTS batches (
    id INT AUTO_INCREMENT PRIMARY KEY,
    batch_name VARCHAR(100) NOT NULL,
    time_slot ENUM('Morning', 'Evening') NOT NULL,
    instructor_name VARCHAR(100) NOT NULL,
    capacity INT NOT NULL,
    start_time TIME NOT NULL,
    end_time TIME NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UNIQUE KEY uq_batches_batch_name (batch_name)
);

CREATE TABLE IF NOT EXISTS participants (
    id INT AUTO_INCREMENT PRIMARY KEY,
    full_name VARCHAR(120) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    phone VARCHAR(20) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(30) NOT NULL,
    batch_id INT NULL,
    joined_date DATE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_participants_batches
        FOREIGN KEY (batch_id)
        REFERENCES batches(id)
        ON UPDATE CASCADE
        ON DELETE SET NULL
);

INSERT IGNORE INTO batches (batch_name, time_slot, instructor_name, capacity, start_time, end_time)
VALUES
    ('Morning Zumba A', 'Morning', 'Yamin', 25, '06:00:00', '07:00:00'),
    ('Evening Zumba B', 'Evening', 'Yamin', 30, '18:00:00', '19:00:00');
