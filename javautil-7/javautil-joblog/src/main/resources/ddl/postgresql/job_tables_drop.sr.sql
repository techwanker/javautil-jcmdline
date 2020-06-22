--#<
--#>
drop sequence if exists job_log_id_seq;
drop sequence if exists job_step_id_seq;
drop sequence if exists job_msg_id_seq;
drop table if exists job_log cascade;
drop table if exists job_step cascade;
drop table if exists job_step_tracefile cascade;
drop table if exists job_step_tracefile_json cascade;
drop table if exists job_msg;
drop view if exists  job_step_vw cascade;
