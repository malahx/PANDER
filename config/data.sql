INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("admin","admin","ADMIN",0,NOW(),NOW());
INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("company","company","COMPANY",0,NOW(),NOW());
INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("candidate","candidate","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "candidate"), "Prénom", "NOM");
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "company"), "Company", "01010101010");
INSERT INTO skill (name,type) VALUES ("Esprit d'entreprendre", "SOFT"),
("Créativité", "SOFT"),
("Confiance", "SOFT"),
("Intelligence émotionnelle", "SOFT"),
("Prise de recul", "SOFT"),
("Audace", "SOFT"),
("Gestion du temps", "SOFT"),
("Gestion du stress", "SOFT");
