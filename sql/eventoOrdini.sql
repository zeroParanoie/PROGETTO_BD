set global event_scheduler = on;
CREATE event IF NOT EXISTS cleanup_ordini
	on schedule
	every 2 day
		on completion preserve
	comment 'remove shipped orders'
	do
		delete from ordine where stato = 'consegnato';