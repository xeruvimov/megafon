-- roles

insert into role (id, created_by, date_created, date_modified, deleted, modified_by, name) VALUES (1, 'system', current_date, null, false, null, 'admin');

insert into role (id, created_by, date_created, date_modified, deleted, modified_by, name) VALUES (2, 'system', current_date, null, false, null, 'user');

-- users

insert into user_rg (id, created_by, date_created, date_modified, deleted, modified_by, email,  username, password) values (1, 'system', current_date, null, false, null, 'test@test.ru', 'admin', '$2a$10$3pFd6htyOpvjKZ/fhd/eYOTvW7vGfvLOUB0WRnIh3bus36hpe8rVe');

-- user_role

insert into user_role (user_id, role_id) VALUES (1, 1);