INSERT INTO leerkrachten (leerkracht_id, naam, paswoord, rol, enabled)
VALUES 
	('d1', "Toon Goedeme", 'd1', "ROLE_docent", 1),
    ('d2', "Gorik Desamblanx", 'd2', "ROLE_docent", 1),
    ('d3', "Ann Philips", 'd3', "ROLE_docent", 1);

INSERT INTO klassen ()
VALUES 
	(),
    (),
    (),
    ();

INSERT INTO leerlingen (leerling_id, naam, paswoord, rol, klas_id, enabled)
VALUES 
	('r1', "Arthur", 'r1', "ROLE_student", 1, 1),
    ('r2', "Jonas", 'r2', "ROLE_student", 1, 1),
    ('r3', "Jef", 'r3', "ROLE_student", 1, 1);

COMMIT;