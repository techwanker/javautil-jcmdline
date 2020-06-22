--@name job_log_insert
-- javautil-joblog/src/main/resources/ddl/logjob_dml.ss.sql
insert into job_log (    
	job_log_id,     job_token, 
	process_name,   thread_name,
	status_msg,     start_ts,  
	classname,      module_name
) values (
	:job_log_id,   :job_token, 
	:process_name, :thread_name,
   :status_msg,    :start_ts,
	:classname,    :module_name
);


--@name job_step_insert
/*
create table job_step (   
    job_step_id             number(9),
    job_log_id 	            number(9),
    step_name               varchar(64),
    classname               varchar(256),
    step_info               varchar(2000),
    start_ts    	    timestamp(9),
    end_ts  		    timestamp(9),
    tracefile_name       varchar(255),
    --cursor_info_run_id      number(9) references cursor_info_run,
    stack_trace              clob,
    exception_message       clob,
    sid                     number(8),
    serial_nbr                 number(8),
    instance_name            varchar(16),
    constraint job_step_pk primary key (job_step_id),
    constraint step_status_fk
	foreign key (job_log_id) references job_log -- is_b
) 
*/   
insert into job_step (
        job_step_id,   job_log_id, 
        step_name,     classname,     
        step_info,     start_ts,      
        stack_trace,    tracefile_name, 
        sid,           serial_nbr,
        instance_name
) values (
        :job_step_id, :job_log_id, 
        :step_name,   :classname,   
        :step_info,   :start_ts,   
        :stack_trace,  :tracefile_name, 
        :sid,         :serial_nbr,
        :instance_name
);
--@name end_step
update job_step 
set end_ts = :end_ts
where job_step_id = :job_step_id;
--@name abort_step
update job_step
set    stack_trace = :stack_trace,
       exception_message  = :exception_message
where  job_step_id = :job_step_id;
--@name job_msg_insert
insert into job_msg (
	job_msg_id,  job_log_id, log_msg_id,                log_msg,
	log_msg_clob,       log_msg_ts,           elapsed_time_MILLISECONDS, log_seq_nbr,
	caller_name,        line_nbr,             call_stack,                log_level
) values (
	:job_msg_id, :job_log_id, :log_msg_id,                :log_msg,
	:log_msg_clob,      :log_msg_ts,           :elapsed_time_milliseconds, :log_seq_nbr,
	:caller_name,       :line_nbr,             :call_stack,                :log_level
);
--@name select_job_log_by_id
select * from job_log
where job_log_id = :job_log_id;
--@name abort_job
UPDATE job_log
SET 
    status_msg = 'ABORT',
    end_ts = :end_ts
where job_token = :job_token;
--@name end_job
UPDATE job_log
SET   
       status_msg = 'DONE',
       end_ts    = :end_ts
where job_token = :job_token;
