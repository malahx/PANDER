USE pander;
INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("admin","admin","ADMIN",0,NOW(),NOW());
INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("company","company","COMPANY",0,NOW(),NOW());
INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("candidate","candidate","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "candidate"), "Prénom", "NOM");
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "company"), "Company", "01010101010");
INSERT INTO skill (name,type) VALUES ("Esprit d'entreprendre", "SOFT"),
("A l'écoute", "SOFT"),
("Adaptable", "SOFT"),
("Aime les challenges", "SOFT"),
("Autonome", "SOFT"),
("Communicant", "SOFT"),
("Compétitif", "SOFT"),
("Confiant", "SOFT"),
("Courageux", "SOFT"),
("Créatif", "SOFT"),
("Diplomate", "SOFT"),
("Discipliné", "SOFT"),
("Dynamique", "SOFT"),
("Esprit d'équipe", "SOFT"),
("Imaginatif", "SOFT"),
("Ordonné", "SOFT"),
("Organisé", "SOFT"),
("Ouvert", "SOFT"),
("Persévérant", "SOFT"),
("Pragmatique", "SOFT"),
("Précis", "SOFT"),
("Sociable", "SOFT"),
("Tolérant", "SOFT"),
("AngularJS", "TECH"),
("Architecture décisionnelle", "TECH"),
("Architecture logicielle", "TECH"),
("Base de données", "TECH"),
("Bash", "TECH"),
("Bootstrap", "TECH"),
("Business Développement", "TECH"),
("Business Intelligence", "TECH"),
("Cahier des charges", "TECH"),
("Communication", "TECH"),
("Conception et modélisation", "TECH"),
("CSS", "TECH"),
("Cycle en V", "TECH"),
("Design", "TECH"),
("Etude de faisabilité", "TECH"),
("Etude de marché", "TECH"),
("Excel", "TECH"),
("Gantt", "TECH"),
("Git", "TECH"),
("Hibernate", "TECH"),
("HTML", "TECH"),
("Intelligence économique", "TECH"),
("Java", "TECH"),
("JavaScript", "TECH"),
("Kanban", "TECH"),
("Linux", "TECH"),
("Management", "TECH"),
("Marketing", "TECH"),
("Méthodes agiles", "TECH"),
("Perl", "TECH"),
("PHP", "TECH"),
("Planification", "TECH"),
("Powerpoint", "TECH"),
("Python", "TECH"),
("Reporting", "TECH"),
("Scrum", "TECH"),
("SpringBoot", "TECH"),
("SQL", "TECH"),
("UML", "TECH"),
("Windows", "TECH");



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("serge.gainsbourg@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), "Serge", "GAINSBOURG");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "Adaptable"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "A l'écoute"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "Créatif"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "AngularJS"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "Bootstrap"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "CSS"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "Management"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "Scrum"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "serge.gainsbourg@yahoo.fr"), 
(select id FROM skill WHERE name = "UML"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("robert.de.niro@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), "Robert", "DE NIRO");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "Adaptable"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "Courageux"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "Dynamique"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "CSS"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "UML"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "HTML"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "robert.de.niro@yahoo.fr"), 
(select id FROM skill WHERE name = "Linux"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("clark.kent@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), "Clark", "KENT");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Confiant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Diplomate"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Base de données"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Business Développement"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Scrum"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Etude de faisabilité"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "clark.kent@yahoo.fr"), 
(select id FROM skill WHERE name = "Gantt"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("billie.jean@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), "Billie", "JEAN");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Autonome"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Imaginatif"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Ordonné"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Cycle en V"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Excel"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "billie.jean@yahoo.fr"), 
(select id FROM skill WHERE name = "Marketing"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("jennifer.lopez@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), "Jennifer", "LOPEZ");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Confiant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Organisé"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Ouvert"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Communication"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Java"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Kanban"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "PHP"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jennifer.lopez@yahoo.fr"), 
(select id FROM skill WHERE name = "Windows"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("johnny.halliday@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), "Johnny", "HALLIDAY");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Discipliné"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Confiant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Persévérant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Design"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Etude de marché"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Intelligence économique"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "johnny.halliday@yahoo.fr"), 
(select id FROM skill WHERE name = "Perl"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("jean.moulin@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), "Jean", "MOULIN");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Tolérant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Précis"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Sociable"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Planification"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Powerpoint"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Python"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "Reporting"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "jean.moulin@yahoo.fr"), 
(select id FROM skill WHERE name = "SpringBoot"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("barry.allen@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), "Barry", "ALLEN");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Pragmatique"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Esprit d'entreprendre"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Imaginatif"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "SQL"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Design"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Git"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Gantt"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "barry.allen@yahoo.fr"), 
(select id FROM skill WHERE name = "Java"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("tom.sawyer@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), "Tom", "SAWYER");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Adaptable"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Créatif"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Diplomate"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Design"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Scrum"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "Etude de faisabilité"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "tom.sawyer@yahoo.fr"), 
(select id FROM skill WHERE name = "PHP"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("emmanuel.macron@yahoo.fr","password","CANDIDATE",0,NOW(),NOW());
INSERT INTO candidate (id_kuser,firstname,lastname) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), "Emmanuel", "MACRON");
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "PHP"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Confiant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Tolérant"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Organisé"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Business Développement"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Planification"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Powerpoint"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Python"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Java"));
INSERT INTO candidate_skill (id_candidate, id_skill) VALUES ((SELECT id FROM kuser WHERE email = "emmanuel.macron@yahoo.fr"), 
(select id FROM skill WHERE name = "Bash"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("carrefour@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "CARREFOUR", "98756346589");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "Développeur informatique 1");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "A l'écoute"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Base de données"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 1"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "Développeur Java 1");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 1"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "Développeur Web 1");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "CSS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 1"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "Business Développeur 1");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Diplomate"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Excel"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Git"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 1"), 
(SELECT id FROM skill WHERE name = "Hibernate"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "carrefour@yahoo.fr"), "Chef de projets 1");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 1"), 
(SELECT id FROM skill WHERE name = "Scrum"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("cap.gemini@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "CAP-GEMINI", "97537865436");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "Développeur informatique 2");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Scrum"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 2"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "Développeur Java 2");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 2"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "Développeur Web 2");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 2"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "Business Développeur 2");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "CSS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Gantt"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 2"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "cap.gemini@yahoo.fr"), "Chef de projets 2");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Ouvert"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 2"), 
(SELECT id FROM skill WHERE name = "Scrum"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("justice.league@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "JUSTICE LEAGUE", "24907641729");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "Développeur informatique 3");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Architecture logicielle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 3"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "Développeur Java 3");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Bash"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 3"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "Développeur Web 3");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Diplomate"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 3"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "Business Développeur 3");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "CSS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "UML"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 3"), 
(SELECT id FROM skill WHERE name = "Hibernate"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "justice.league@yahoo.fr"), "Chef de projets 3");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Ouvert"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Git"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 3"), 
(SELECT id FROM skill WHERE name = "Scrum"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("kiabi@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "KIABI", "97653892028");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "Développeur informatique 11");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Architecture logicielle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 11"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "Développeur Java 11");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 11"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "Développeur Web 11");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Diplomate"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Excel"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 11"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "Business Développeur 11");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Gantt"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 11"), 
(SELECT id FROM skill WHERE name = "Hibernate"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "kiabi@yahoo.fr"), "Chef de projets 11");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Ouvert"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Git"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 11"), 
(SELECT id FROM skill WHERE name = "Scrum"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("accor.hotels@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "ACCOR HOTELS", "73920093654");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "Développeur informatique 22");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Autonome"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Architecture logicielle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 22"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "Développeur Java 22");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Business Intelligence"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Architecture logicielle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 22"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "Développeur Web 22");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 22"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "Business Développeur 22");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "CSS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Gantt"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Git"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 22"), 
(SELECT id FROM skill WHERE name = "Hibernate"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "accor.hotels@yahoo.fr"), "Chef de projets 22");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 22"), 
(SELECT id FROM skill WHERE name = "Scrum"));



INSERT INTO kuser (email,password,role,disabled,created_at,updated_at) VALUES ("elysee@yahoo.fr","password","COMPANY",0,NOW(),NOW());
INSERT INTO company (id_kuser,name,siret) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "PALAIS DE L'ELYSEE", "XXXXXXXXXX");

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "Développeur informatique 33");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Communicant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Aime les challenges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Architecture décisionnelle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Architecture logicielle"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Cahier des charges"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur informatique 33"), 
(SELECT id FROM skill WHERE name = "Bash"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "Développeur Java 33");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Créatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Compétitif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Bootstrap"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Powerpoint"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "AngularJS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Java 33"), 
(SELECT id FROM skill WHERE name = "Communication"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "Développeur Web 33");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Diplomate"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Courageux"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Adaptable"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Conception et modélisation"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Business Développement"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Cycle en V"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Design"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Développeur Web 33"), 
(SELECT id FROM skill WHERE name = "Etude de faisabilité"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "Business Développeur 33");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Confiant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Discipliné"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Imaginatif"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Etude de marché"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "CSS"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Git"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Méthodes agiles"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Business Développeur 33"), 
(SELECT id FROM skill WHERE name = "Hibernate"));

INSERT INTO job (id_company, name) VALUES ((SELECT id FROM kuser WHERE email = "elysee@yahoo.fr"), "Chef de projets 33");
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Dynamique"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Ouvert"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Persévérant"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Gantt"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Management"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Planification"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Reporting"));
INSERT INTO job_skill (id_job, id_skill) VALUES ((SELECT id FROM job WHERE name = "Chef de projets 33"), 
(SELECT id FROM skill WHERE name = "Scrum"));
