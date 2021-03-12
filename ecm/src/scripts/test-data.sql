
-- 1 manually create data and view via postman get calls.
INSERT INTO ecm_test.employee (email_address, first_name, last_name, active, country_code, mobile, create_time, last_update_time, address, nick_name, employee_type, status, short_desc, key_tech_stack, auto_exp) VALUES ('test@test.com', 'john', null, 0, 1, 1234567890, DEFAULT, DEFAULT, null, null, null, DEFAULT, null, null, null)
INSERT INTO ecm_test.employee (email_address, first_name, last_name, active, country_code, mobile, create_time, last_update_time, address, nick_name, employee_type, status, short_desc, key_tech_stack, auto_exp) VALUES ('test1@test.com', 'smith', null, 0, 1, 1234567890, DEFAULT, DEFAULT, null, null, null, DEFAULT, null, null, null)


--
select * from employee_resume;
INSERT INTO ecm_test.employee_resume (create_time, last_update_time, short_desc, data, file_location, employee_id) VALUES (DEFAULT, DEFAULT, 'JAVA/J2EE and angularJS experience into web application development', 'test resume data here', '/tmp/resume/smith_resume.pdf', null)

--
select *
from time_sheet ;

--
select * from client;

