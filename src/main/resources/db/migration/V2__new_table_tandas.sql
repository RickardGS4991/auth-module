CREATE TABLE tandas(
    tanda_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    owner_user_id UUID NOT NULL,
    name TEXT NOT NULL,
    amount NUMERIC(10,2) NOT NULL DEFAULT 0,
    created_at TIMESTAMPTZ DEFAULT now(),
    updated_at TIMESTAMPTZ NOT NULL,
    total_turn INT NOT NULL,

    CONSTRAINT fk_user_id_owner
        FOREIGN KEY (owner_user_id)
        REFERENCES users(user_id)
        ON DELETE CASCADE,

    CONSTRAINT check_amount_not_negative
                   CHECK ( amount >= 0 ),

    CONSTRAINT verify_turns
                   CHECK ( total_turn >= 6 )

);

CREATE TABLE groups_tanda(
    group_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    tanda_id UUID NOT NULL,
    member_id UUID NOT NULL,
    turn_tanda INT NOT NULL DEFAULT 0,
    debt NUMERIC(10,2) DEFAULT 0,

    CONSTRAINT fk_member_id
                         FOREIGN KEY (member_id)
                         REFERENCES users(user_id)
                         ON DELETE CASCADE,

    CONSTRAINT fk_tanda_id
                         FOREIGN KEY (tanda_id)
                         REFERENCES tandas(tanda_id)
                         ON DELETE CASCADE,

    CONSTRAINT chk_turn_not_negative
                         CHECK ( turn_tanda > 0 AND turn_tanda < 13 ),

    CONSTRAINT unq_ids
                         UNIQUE (tanda_id, member_id),

    CONSTRAINT chk_debt_not_negative
                         CHECK ( debt >= 0 )
);

CREATE TABLE tanda_contributions (
    contribution_id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    group_id UUID NOT NULL,
    amount_pay NUMERIC(10,2) NOT NULL DEFAULT 0,
    paid_at TIMESTAMPTZ NOT NULL DEFAULT now(),

    CONSTRAINT chk_amount_not_nega
                                 CHECK ( amount_pay >= 0 ),

    CONSTRAINT fk_group_id
                                 FOREIGN KEY (group_id)
                                 REFERENCES groups_tanda(group_id)
                                 ON DELETE CASCADE
);