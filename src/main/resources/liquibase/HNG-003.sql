DELETE
FROM report;

ALTER TABLE report
    ADD COLUMN login TEXT NOT NULL;