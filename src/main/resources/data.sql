INSERT INTO tb_base_user(name, email) VALUES ('Ana', 'ana@email.com');
INSERT INTO tb_base_user(name, email) VALUES ('João', 'joao@email.com');
INSERT INTO tb_base_user(name, email) VALUES ('Maria', 'maria@email.com');
INSERT INTO tb_base_user(name, email) VALUES ('Carlos', 'carlos@email.com');
INSERT INTO tb_base_user(name, email) VALUES ('Luiza', 'luiza@email.com');
INSERT INTO tb_base_user(name, email) VALUES ('Ruth', 'ruth@email.com');

INSERT INTO tb_admin(phone_number, user_id) VALUES ('(15)3222-3333', 1);
INSERT INTO tb_admin(phone_number, user_id) VALUES ('(11)9999-5555', 2);
INSERT INTO tb_admin(phone_number, user_id) VALUES ('(15)3333-4444', 3);

INSERT INTO tb_attendee(balance, user_id) VALUES (0.0, 4);
INSERT INTO tb_attendee(balance, user_id) VALUES (0.0, 5);
INSERT INTO tb_attendee(balance, user_id) VALUES (0.0, 6);

INSERT INTO tb_place(name, address) VALUES ('Auditório', 'Rua X, 123');
INSERT INTO tb_place(name, address) VALUES ('FabLab', 'Rua ABC, 99');
INSERT INTO tb_place(name, address) VALUES ('Universidade', 'Rua Universidade, 123');

INSERT INTO tb_event (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, event_admin_id) VALUES ('Palestra', 'Palestra sobre soft skills', '2023-10-12', '2023-10-12', '20:30:00', '21:30:00', 'palestra@email.com', 100, 0, 0.0, 1);
INSERT INTO tb_event (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, event_admin_id) VALUES ('Workshop', 'Workshop sobre IOT', '2021-05-08', '2021-05-12', '14:30:00', '16:30:00', 'workshop@email.com', 0, 50, 49.9, 2);
INSERT INTO tb_event (name, description, start_date, end_date, start_time, end_time, email_contact, amount_free_tickets, amount_payed_tickets, price_ticket, event_admin_id) VALUES ('Congresso', 'XI Congresso Data Science', '2022-03-25', '2022-04-20', '08:00:00', '20:00:00', 'congresso@email.com', 100, 1000, 120.0, 3);

INSERT INTO tb_event_places(events_id, places_id) VALUES (1,1);
INSERT INTO tb_event_places(events_id, places_id) VALUES (2,2);
INSERT INTO tb_event_places(events_id, places_id) VALUES (3,3);

INSERT INTO tb_ticket(date, price, event_id, attendee_user_id, type) VALUES ('2023-10-01', 0.0, 1, 4, 0);
INSERT INTO tb_ticket(date, price, event_id, attendee_user_id, type) VALUES ('2021-05-07', 49.9, 2, 5, 1);
INSERT INTO tb_ticket(date, price, event_id, attendee_user_id, type) VALUES ('2022-03-24', 120.0, 3, 6, 1);