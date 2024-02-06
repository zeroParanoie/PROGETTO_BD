INSERT INTO contatto (cellulare, email, IVArivenditaContatto, telefono) VALUES('000000001', 'referente@rivendita.it', '1', '00000002');
INSERT INTO fornitore (CF, Cfornitore, cognomeFornitore, nomeFornitore, sedePos) VALUES('1', 1, 'Rossi', 'Mario', 'Via Brombeis');
INSERT INTO fornitrice (sede_f) VALUES('Via Brombeis');
INSERT INTO indirizzo (fatturazione, IVArivendita, spedizione) VALUES('Via del Corso', '1', 'Via Manzoni');
INSERT INTO pianta (nomeLatinoSpeciePianta, quantita) VALUES('Abludens', 10);
INSERT INTO pianta (nomeLatinoSpeciePianta, quantita) VALUES('Raccolanae', 15);
INSERT INTO pianta (nomeLatinoSpeciePianta, quantita) VALUES('Macaranga', 12);
INSERT INTO prezzo (costo, nomeLatinoSpeciePrezzo) VALUES(21.0, 'Abludens');
INSERT INTO prezzo (costo, nomeLatinoSpeciePrezzo) VALUES(21.2, 'Raccolanae');
INSERT INTO prezzo (costo, nomeLatinoSpeciePrezzo) VALUES(22.5, 'Macaranga');
INSERT INTO referente (cognomeReferente, IVArivenditaReferente, nomeReferente) VALUES('Verdi', '1', 'Giuseppe');
INSERT INTO rifornisce (accetttata, codFornitriceRif, codicePiantaRif, qtaFornitura, specieRif) VALUES('no', 1, 1, 5);
INSERT INTO rifornisce (accetttata, codFornitriceRif, codicePiantaRif, qtaFornitura, specieRif) VALUES('no', 1, 2, 5);
INSERT INTO rifornisce (accetttata, codFornitriceRif, codicePiantaRif, qtaFornitura, specieRif) VALUES('no', 1, 3, 5);
INSERT INTO rivendita (IVA, sede_rivendita) VALUES('1', 'Via del Corso');
INSERT INTO specie (colore, nome_comune, nome_latino, tipoGenetica) VALUES('rosso', 'Aloe Ciliaris', 'Abludens', 'fio');
INSERT INTO specie (colore, nome_comune, nome_latino, tipoGenetica) VALUES(null , 'Legno insanguinato', 'Macaranga', 'eso');
INSERT INTO specie (colore, nome_comune, nome_latino, tipoGenetica) VALUES(null , 'Aloe nonLaTrovo', 'Raccolanae', 'ext');
INSERT INTO utente (username, pw, ruolo) VALUES('mRossi', 'password1', 'f');
INSERT INTO utente (username, pw, ruolo) VALUES('gVerdi', 'password2', 'r');
INSERT INTO utente (username, pw, ruolo) VALUES('magazzinoo', 'password3', 'v');

