CREATE TABLE ojt.order
(
    order_id     integer                  NOT NULL
        CONSTRAINT order_pkey
            PRIMARY KEY,
    name         varchar                  NOT NULL,
    quantity     integer                  NOT NULL,
    unit_price   real                     NOT NULL,
    sub_total    real                     NOT NULL,
    shipping_fee real                     NOT NULL,
    item_total   real                     NOT NULL,
    grand_total  real                     NOT NULL,
    date_time    timestamp with time zone NOT NULL DEFAULT current_timestamp,
    client_id    varchar                  NOT NULL,
    customer_id  integer
        CONSTRAINT order_customer_cid_fk
            REFERENCES ojt.customer
);
