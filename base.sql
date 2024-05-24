CREATE SCHEMA IF NOT EXISTS "public";

CREATE SEQUENCE "public".activite_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".activitevoyage_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".administrateur_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".categorie_idcategorie_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".destination_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".offre_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".offreactivite_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE SEQUENCE "public".voyage_id_seq AS integer START WITH 1 INCREMENT BY 1;

CREATE  TABLE "public".activite ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(100)    ,
	description          varchar    ,
	CONSTRAINT unq_activite_id UNIQUE ( id ) 
 );

CREATE  TABLE "public".administrateur ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(100)    ,
	mail                 varchar(100)    ,
	mdp                  varchar(15)    ,
	CONSTRAINT pk_administrateur PRIMARY KEY ( id )
 );

CREATE  TABLE "public".categorie ( 
	idcategorie          serial  NOT NULL  ,
	nomcategorie         varchar(100)    ,
	CONSTRAINT unq_categorie_idcategorie UNIQUE ( idcategorie ) 
 );

CREATE  TABLE "public".destination ( 
	id                   serial  NOT NULL  ,
	nom                  varchar(100)    ,
	description          varchar    ,
	CONSTRAINT unq_destination_id UNIQUE ( id ) 
 );

CREATE  TABLE "public".offre ( 
	id                   serial  NOT NULL  ,
	destination          integer    ,
	debut                date    ,
	fin                  date    ,
	description          varchar    ,
	prix                 double precision    ,
	idcategorie          integer    ,
	CONSTRAINT unq_offre_id UNIQUE ( id ) ,
	CONSTRAINT fk_offre_destination FOREIGN KEY ( destination ) REFERENCES destination( id )   
 );

CREATE  TABLE "public".offreactivite ( 
	id                   serial  NOT NULL  ,
	idvoyage             integer    ,
	idactivite           integer    
	
 );

CREATE  TABLE "public".voyage ( 
	id                   serial  NOT NULL  ,
	destination          integer    ,
	debut                date    ,
	fin                  date    ,
	description          varchar    ,
	prix                 double precision    ,
	idcategorie          integer    ,
	CONSTRAINT unq_voyage_id UNIQUE ( id ) ,
	CONSTRAINT fk_voyage_categorie FOREIGN KEY ( idcategorie ) REFERENCES "public".categorie( idcategorie )   ,
	CONSTRAINT fk_voyage_destination FOREIGN KEY ( destination ) REFERENCES "public".destination( id )   
 );

CREATE  TABLE "public".activitevoyage ( 
	id                   serial  NOT NULL  ,
	idvoyage             integer    ,
	idactivite           integer    ,
	CONSTRAINT fk_activitevoyage_activite FOREIGN KEY ( idvoyage ) REFERENCES "public".voyage( id )   ,
	CONSTRAINT fk_activitevoyage_activite_to_do FOREIGN KEY ( idactivite ) REFERENCES "public".activite( id )   
 );

CREATE OR REPLACE VIEW v_detail_activite_voyage AS SELECT
    c.nomcategorie,
    v.debut,
    v.fin,
    v.description,
    v.prix,
	d.nom
   FROM ((((voyage v
     JOIN destination d ON ((v.destination = d.id)))
     JOIN categorie c ON ((c.idcategorie = v.idcategorie)))
     JOIN activitevoyage ac ON ((ac.idvoyage = v.id)))
     JOIN activite a ON ((a.id = ac.idactivite)));

CREATE OR REPLACE VIEW v_detail_offre AS SELECT 
    o.debut,
    o.fin,
    d.description,
    o.prix,
    c.nomcategorie
   FROM ((offre o
     JOIN destination d ON ((d.id = o.id)))
     JOIN categorie c ON ((c.idcategorie = o.idcategorie)));

INSERT INTO "public".activite( id, nom, description ) VALUES ( 1, 'visite des monuments', 'exploration des sites historiques');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 2, 'visite de musee', 'explorez des arts, l''histoire et la culture locale');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 3, 'spectacles traditionnels', 'assistez a des representations de danse et de musique');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 4, 'spectacles traditionnels', 'assistez a des representations de danse et de musique');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 5, 'safari', 'partez a la decouverte de la faune sauvage');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 6, 'escalade', 'explorez des sentires pittoresques et decouvrez des vues splendides');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 7, 'croisiÃ¨re', 'naviguez sur des eaux calmes');
INSERT INTO "public".activite( id, nom, description ) VALUES ( 8, 'camping', 'pprofitez du plein air en famille');


INSERT INTO "public".administrateur( id, nom, mail, mdp ) VALUES ( 1, 'sarobidy', 'sarobidy@gmail.com', 'sarobidy');


INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 1, 'aventure');
INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 2, 'detente');
INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 3, 'culture');
INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 4, 'nature');
INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 5, 'sante');
INSERT INTO "public".categorie( idcategorie, nomcategorie ) VALUES ( 6, 'table');



INSERT INTO "public".destination( id, nom, description ) VALUES ( 1, 'tokyo', 'une metrpole dynamique offrant une cuisine delicieuse et des quarties animes');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 2, 'Ã®les de Fidji', 'une ville emblematique oÃ¹ l''histoire rencontre l''art avec une ambiance romantique');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 3, 'italie', 'une ville pleine de romande et d''histoire');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 4, 'sydney', 'des plages de renommee mondiale avec une scÃ¨ne artistique florissante');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 5, 'rio de janeiro', 'une ville impressionnante avec son carnaval anime,ses paysages naturels et spectaculaires');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 6, 'new york', 'explorez la ville dans toute sa splendeur , avec ses grttes-ciel et ses quarties dynamiques');
INSERT INTO "public".destination( id, nom, description ) VALUES ( 7, 'paris', 'la ville de lumiÃ¨re celÃ¨bre pour sa tour eiffel');


INSERT INTO "public".offre( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 1, 2, '2024-02-01', '2024-02-10', 'Profitez de cette offre speciale!!!', 1254875.0, 3);
INSERT INTO "public".offre( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 2, 4, '2024-02-04', '2024-02-06', 'c''est cool', 147528.0, 1);
INSERT INTO "public".offre( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 3, 5, '2024-03-08', '2024-03-10', 'Venez, vous allez pas le regretter !!!', 1.234567789E10, 3);



INSERT INTO "public".offreactivite( id, idvoyage, idactivite ) VALUES ( 1, 1, 4);
INSERT INTO "public".offreactivite( id, idvoyage, idactivite ) VALUES ( 2, 2, 8);
INSERT INTO "public".offreactivite( id, idvoyage, idactivite ) VALUES ( 3, 3, 4);
INSERT INTO "public".offreactivite( id, idvoyage, idactivite ) VALUES ( 4, 3, 5);


INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 1, 7, null, null, 'C''est un voyage touristique et culturel a Paris', 1.2E8, null);
INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 2, 4, null, null, 'Faites une briÃ¨ve escale  a Sydney pour decouvrir des paysages magnifiques', 1.2E8, null);
INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 3, 7, '2024-02-25', '2024-02-28', 'Visitez les plus belles monuments de Paris et enrichissez votre culture', 1.2E8, 3);
INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 4, 7, '2024-02-25', '2024-02-28', 'Visitez les monuments de Paris avec nous', 1.2E8, 3);
INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 5, 2, '2024-03-03', '2024-03-05', 'venez rejoindre cette offre limitee', 1.246761248E9, 1);
INSERT INTO "public".voyage( id, destination, debut, fin, description, prix, idcategorie ) VALUES ( 6, 5, '2024-03-09', '2024-03-10', 'Venez a notre carnaval', 1.246761248E9, 3);


INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 1, 1, 1);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 2, 1, 2);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 3, 2, 3);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 4, 3, 1);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 5, 3, 2);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 6, 4, 1);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 7, 4, 2);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 8, 5, 8);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 9, 6, 4);
INSERT INTO "public".activitevoyage( id, idvoyage, idactivite ) VALUES ( 10, 6, 5);