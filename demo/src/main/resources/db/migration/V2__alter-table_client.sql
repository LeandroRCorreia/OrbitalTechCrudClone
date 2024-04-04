ALTER TABLE client
ADD column cep varchar(8) not null;

ALTER TABLE client
ADD column public_place varchar(50) not null;

ALTER TABLE client
ADD column locality varchar(50) not null;

ALTER TABLE client
ADD column uf_state varchar(4) not null;
