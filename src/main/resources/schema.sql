drop table IF EXISTS users CASCADE;
drop table IF EXISTS news CASCADE;
drop table IF EXISTS contact_details CASCADE;
drop table IF EXISTS customers CASCADE;
drop table IF EXISTS briefs CASCADE;
drop table IF EXISTS cons_request CASCADE;

create TABLE IF NOT EXISTS users(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username varchar(50) NOT NULL,
    user_password varchar(200) NOT NULL,
    email varchar(50) NOT NULL UNIQUE,
    first_name varchar(50) NOT NULL,
    last_name varchar(50) NOT NULL,
    created_on timestamp NOT NULL,
    user_role varchar(50) NOT NULL
);

create TABLE IF NOT EXISTS news(
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    title varchar(100) NOT NULL,
    text varchar(1000) NOT NULL,
    created_on timestamp NOT NULL,
    image_data bytea
);

create TABLE IF NOT EXISTS contact_details(
    id integer GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    phone varchar(100) NOT NULL,
    email varchar(250) NOT NULL,
    address varchar(250) NOT NULL,
    working_schedule varchar(250) NOT NULL
);

create TABLE IF NOT EXISTS customers(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    name varchar(50) NOT NULL,
    phone varchar(30) NOT NULL,
    email varchar(50) NOT NULL
);

create TABLE IF NOT EXISTS briefs(
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id bigint,
    production varchar(700) NOT NULL,
    production_load varchar(50) NOT NULL,
    financing_confirmed boolean NOT NULL,
    company_type varchar(50) NOT NULL,
    timing_for_contact varchar(50) NOT NULL,
    request_state varchar(50) NOT NULL,
    created timestamp NOT NULL,
    CONSTRAINT fk_briefs_to_customers FOREIGN KEY(customer_id) REFERENCES customers(id) ON delete CASCADE ON update CASCADE
);

create TABLE IF NOT EXISTS cons_request(
    id bigint GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    customer_id bigint,
    created timestamp NOT NULL,
    timing_for_contact varchar(50) NOT NULL,
    request_state varchar(50) NOT NULL,
    CONSTRAINT fk_cons_requests_to_customers FOREIGN KEY(customer_id) REFERENCES customers(id) ON delete CASCADE ON update CASCADE
);




