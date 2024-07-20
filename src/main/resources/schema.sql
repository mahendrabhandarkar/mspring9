create table t_user (id BIGINT PRIMARY KEY AUTO_INCREMENT, username VARCHAR(256), email VARCHAR(256), password VARCHAR(256));
insert into t_user (username, email, password) VALUES ('admin2','test2@test.com','admin2');
insert into stt_queue_node_event (node_event_id, queue_event_name, queue_event_description) VALUES
(2, 'Refer Back','Order is reffered back to previous user'),
(3,'Approve','Order is approved'),
(4,'Reject','Order is Reject'),
(1,'Submit','Order is submitted');

insert into stt_queue_node_master (node_id, node_name, node_short_code, status) VALUES
(1,'Customer','PO','t'),
(2,'Inventory Level 1','RECOML1','t'),
(3,'Inventory Level 2','RECOML1','t'),
(4,'Inventory Level 3','RECOML1','t'),
(5,'Inventory Level 4','RECOML1','t'),
(6,'Inventory Level 5','RECOML1','t'),
(7,'Inventory Level 6','RECOML1','t'),
(8,'Screening Officer','SCRNCOM','t'),
(9,'Approver','APPRVER','t');

insert into stt_queue_role_master (role_id, role_name, role_short_code, status) VALUES
(1,'Approver','aprve','t'),
(2,'branch request1','/view','t'),
(3,'Executor','\tEX','t'),
(4,'Head Of Department','HOD','t'),
(5,'Customer','PO','t'),
(6,'Inventory AGM','AGM','t'),
(7,'Inventory CMD','CMD','t'),
(8,'Inventory DGM','DGM','t'),
(9,'Inventory DM','RDM','t'),
(10,'Inventory ED','ED','t'),
(11,'Inventory GM','GM','t'),
(12,'Inventory SM','SM','t'),
(13,'Screening Officer','SC','t');
