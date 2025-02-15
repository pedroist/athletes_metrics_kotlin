-- Insert sample athletes
INSERT INTO athlete (name, sport, created_at, updated_at)
VALUES 
    ('John Doe', 'Swimming', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    ('Jane Smith', 'Running', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert performance metrics for John Doe (assuming id=1)
INSERT INTO performance_metric (athlete_id, metric_name, value, unit, date, created_at, updated_at)
VALUES 
    (1, 'Lap Time', 25.5, 'seconds', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 'Distance', 50, 'meters', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (1, 'Heart Rate', 150, 'bpm', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- Insert performance metrics for Jane Smith (assuming id=2)
INSERT INTO performance_metric (athlete_id, metric_name, value, unit, date, created_at, updated_at)
VALUES 
    (2, 'Speed', 12.5, 'km/h', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'Distance', 10, 'kilometers', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
    (2, 'Heart Rate', 165, 'bpm', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP); 