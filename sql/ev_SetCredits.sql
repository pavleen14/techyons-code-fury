SET GLOBAL event_scheduler = ON;
drop event if exists ev_SetCredits;
CREATE EVENT ev_SetCredits
ON SCHEDULE EVERY 1 WEEK
  STARTS CURRENT_DATE + INTERVAL 7 - WEEKDAY(CURRENT_DATE) DAY
DO
   update users 
   set Credits=2000
   where role="MANAGER";
show events;
