ALTER TABLE users
    ADD COLUMN phone_number TEXT NOT NULL DEFAULT '0';

ALTER TABLE users
    RENAME COLUMN address TO street;

