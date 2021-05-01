-- Populate the destinations table by using Postgres' bundled time zone name data.
insert into destinations (region, name)
    select 'Africa', regexp_replace(name, '^Africa/', '') from pg_timezone_names where name ~ '^Africa/.*' union
    select 'Asia', regexp_replace(name, '^Asia/', '') from pg_timezone_names where name ~ '^Asia/.*' union
    select 'Europe', regexp_replace(name, '^Europe/', '') from pg_timezone_names where name ~ '^Europe/.*';
