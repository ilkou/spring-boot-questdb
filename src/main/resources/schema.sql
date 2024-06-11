
DROP TABLE IF EXISTS geo_positions;

CREATE TABLE IF NOT EXISTS geo_positions(id uuid, ts timestamp, source symbol, lat double, lng double, metadata symbol)
timestamp(ts)
PARTITION BY DAY WAL
DEDUP UPSERT KEYS(ts, source);
