CREATE TABLE refresh_tokens(
    refresh_token_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    user_id UUID NOT NULL,
    refresh_token TEXT NOT NULL UNIQUE,
    created_at TIMESTAMPTZ NOT NULL DEFAULT now(),
    expires_at TIMESTAMPTZ NOT NULL,
    revoked BOOLEAN NOT NULL DEFAULT FALSE,

    CONSTRAINT fk_user_id_rt
                           FOREIGN KEY (user_id)
                           REFERENCES users(user_id)
                           ON DELETE CASCADE
);

CREATE INDEX user_id_tokens ON refresh_tokens(user_id);