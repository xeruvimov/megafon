CREATE TABLE repair_request
(
    id            bigint PRIMARY KEY,
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    deleted       boolean,
    description   VARCHAR(500),
    address       VARCHAR(255) not null,
    phone_number  VARCHAR(12)  not null
);

CREATE TABLE user_rg
(
    id            bigint PRIMARY KEY,
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    deleted       boolean,
    password      varchar(255),
    username      varchar(255),
    email         varchar(255)
);

CREATE TABLE role
(
    id            bigint PRIMARY KEY,
    created_by    varchar(255),
    date_created  TIMESTAMPTZ,
    modified_by   varchar(255),
    date_modified TIMESTAMPTZ,
    deleted       boolean,
    name          varchar(255)
);

create table user_role
(
    user_id bigint references user_rg (id) ON UPDATE CASCADE ON DELETE CASCADE,
    role_id bigint references role (id) ON UPDATE CASCADE,
    CONSTRAINT bill_product_pkey PRIMARY KEY (user_id, role_id)
);

