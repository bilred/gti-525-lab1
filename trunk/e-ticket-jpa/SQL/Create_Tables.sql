CREATE TABLE show_artiste
(
  id serial NOT NULL,
  nom character varying(255) NOT NULL,
  description text,
  photo character varying(255) DEFAULT '',
  CONSTRAINT show_artiste_pkey PRIMARY KEY (nom)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_artiste
  OWNER TO postgres;

  CREATE TABLE show_spectacle
(
  id serial NOT NULL,
  description text,
  lien_image character varying(255),
  lien_video character varying(255),
  artiste_nom character varying(255),
  nom_spectacle character varying(255),
  CONSTRAINT show_spectacle_pkey PRIMARY KEY (id),
  CONSTRAINT fk_show_spectacle_artiste_nom FOREIGN KEY (artiste_nom)
      REFERENCES show_artiste (nom) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_spectacle
  OWNER TO postgres;
  
  
  CREATE TABLE show_representation
(
  id serial NOT NULL,
  adresse character varying(255),
  date_debut date,
  date_fin date,
  is_annulation boolean,
  nb_billets_dispo integer,
  nom character varying(255),
  prix double precision,
  spectacle_id bigint,
  CONSTRAINT show_representation_pkey PRIMARY KEY (id),
  CONSTRAINT fk_show_representation_spectacle_id FOREIGN KEY (spectacle_id)
      REFERENCES show_spectacle (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_representation
  OWNER TO postgres;
  
  
CREATE TABLE show_billet
(
  id serial NOT NULL,
  is_livraison boolean,
  is_vendu boolean,
  representation_id bigint,
  reservation_id character varying(255),
  salle_id double precision,
  CONSTRAINT show_billet_pkey PRIMARY KEY (id),
  CONSTRAINT fk_show_billet_representation_id FOREIGN KEY (representation_id)
      REFERENCES show_representation (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_billet
  OWNER TO postgres;



CREATE TABLE show_reservation
(
  id serial NOT NULL,
  date_reservation date,
  is_confirmation_achat boolean,
  is_reservation boolean,
  CONSTRAINT show_reservation_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_reservation
  OWNER TO postgres;

CREATE TABLE show_salle
(
  id serial NOT NULL,
  adresse_salle character varying(255),
  nb_place integer,
  name character varying(255),
  representation_id bigint,
  CONSTRAINT show_salle_pkey PRIMARY KEY (id),
  CONSTRAINT fk_show_salle_representation_id FOREIGN KEY (representation_id)
      REFERENCES show_representation (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE show_salle
  OWNER TO postgres;



CREATE TABLE vente_carte_credit
(
  id serial NOT NULL,
  date_expiration date,
  date_transaction date,
  nom_detenteur_carte character varying(255),
  num_carte_credit character varying(255),
  num_securite character varying(255),
  type_carte_credit character varying(255),
  CONSTRAINT vente_carte_credit_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vente_carte_credit
  OWNER TO postgres;

CREATE TABLE vente_client
(
  id serial NOT NULL,
  mail character varying(255),
  nom character varying(255),
  nom_civique character varying(255),
  phone character varying(255),
  prenom character varying(255),
  adresseclient_id character varying(255),
  cartecredit_id bigint,
  CONSTRAINT vente_client_pkey PRIMARY KEY (id),
  CONSTRAINT fk_vente_client_cartecredit_id FOREIGN KEY (cartecredit_id)
      REFERENCES vente_carte_credit (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vente_client
  OWNER TO postgres;

CREATE TABLE vente_client_show_billet
(
  client_id bigint NOT NULL,
  billets_id double precision NOT NULL,
  CONSTRAINT vente_client_show_billet_pkey PRIMARY KEY (client_id, billets_id),
  CONSTRAINT fk_vente_client_show_billet_client_id FOREIGN KEY (client_id)
      REFERENCES vente_client (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE vente_client_show_billet
  OWNER TO postgres;