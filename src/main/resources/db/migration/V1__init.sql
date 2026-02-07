CREATE TABLE users(
    user_id UUID PRIMARY KEY,
    first_name TEXT NOT NULL,
    last_name TEXT NOT NULL,
    birth_date DATE NOT NULL,
    username TEXT NOT NULL UNIQUE,
    email TEXT NOT NULL UNIQUE,
    password TEXT NOT NULL,
    address TEXT NOT NULL,
    city TEXT NOT NULL,
    postal_code TEXT NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL DEFAULT now()
)

CREATE TABLE tandas(
    tanda_id UUID PRIMARY KEY,
    administrator_user_id UUID NOT NULL,
    name TEXT NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    started_day TIMESTAMPTZ NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now()
)

CREATE TABLE tandas_groups(
    tanda_group_id UUID PRIMARY KEY,
    user_id UUID NOT NULL,
    tanda_id UUID NOT NULL,
    debt NUMERIC(10,2) NOT NULL,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT fk_enrollment_user
                          FOREIGN KEY (user_id)
                          REFERENCES users(user_id)
                          ON DELETE CASCADE,

    CONSTRAINT fk_tanda_id
                          FOREIGN KEY (tanda_id)
                          REFERENCES tandas(tanda_id)
                          ON DELETE CASCADE,

    CONSTRAINT uq_tanda_user
                          UNIQUE (tanda_id, user_id),

    CONSTRAINT chk_debt_equal_more_0
                          CHECK(debt >= 0)
)