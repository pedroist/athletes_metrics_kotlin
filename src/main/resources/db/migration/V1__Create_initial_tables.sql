CREATE TABLE athlete (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    sport VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE performance_metric (
    id BIGSERIAL PRIMARY KEY,
    athlete_id BIGINT NOT NULL,
    metric_name VARCHAR(255) NOT NULL,
    value DOUBLE PRECISION NOT NULL,
    unit VARCHAR(50) NOT NULL,
    date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_athlete
        FOREIGN KEY (athlete_id)
        REFERENCES athlete (id)
        ON DELETE CASCADE
);

CREATE INDEX idx_performance_metric_athlete_id ON performance_metric(athlete_id);
CREATE INDEX idx_performance_metric_date ON performance_metric(date);
CREATE INDEX idx_performance_metric_metric_name ON performance_metric(metric_name);