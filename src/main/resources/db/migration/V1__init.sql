CREATE TABLE users (
    user_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),

    first_name   TEXT NOT NULL,
    last_name    TEXT NOT NULL,
    birthdate    DATE NOT NULL,

    username     TEXT NOT NULL UNIQUE,
    email        TEXT NOT NULL UNIQUE,
    password     TEXT NOT NULL,

    address      TEXT NOT NULL,
    postal_code  TEXT NOT NULL,
    city         TEXT NOT NULL,

    created_at   TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at   TIMESTAMPTZ NOT NULL DEFAULT now()
);