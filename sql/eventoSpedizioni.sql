set global event_scheduler = on;
CREATE event IF NOT EXISTS spedizione_ordini
	on schedule
    every 2 day
		on completion preserve
	comment 'shipping orders'
    do
		UPDATE ordine SET stato = 'in consegna';

