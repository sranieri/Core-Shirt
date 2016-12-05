DROP DATABASE IF EXISTS coreshirt;

create database coreshirt;
use coreshirt;

create table cliente(
	id int(11) not null auto_increment,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	recapito int(10) not null,
	primary key(id)
 );
 
 create table dipendente(
	id int(11) not null auto_increment,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	codicefiscale varchar(16) not null,
	stipendio double default 900.0,
	tipo varchar(15) not null,
	username varchar(10) not null,
	password varchar(10) not null,
	primary key(id)
 );
 
 create table tshirt(
	id int(11) references articolo(id) on delete set null on update cascade,
	sesso varchar(1) not null,
	taglia char(1) not null,
	colore char(10) not null,
	quantita int references articolo(quantita) on delete set null on update cascade,
	primary key(id,sesso,taglia,colore)
 );

 create table articolo(
	id int(11) not null,
	nome varchar(40) not null,
	categoria varchar(15) not null,
	prezzo decimal(10,0) default 12.0 ,
	quantita int(10) not null,
	primary key(id)
);

create table composizioneOrdine(
	idordine int(11) references ordine(id) on delete set null on update cascade,
	idtshirt int (11) references tshirt(id) on delete set null on update cascade,
	sesso char(1) references tshirt(sesso) on delete set null on update cascade,
	taglia char(1) references tshirt(taglia) on delete set null on update cascade,
	colore char(10) references tshirt(colore) on delete set null on update cascade,
	pezzi int not null,
	primary key(idordine,idtshirt,sesso,taglia,colore)
);

create table ordine(
	id int(11) not null auto_increment,
	idcliente int(11) references cliente(id) on delete set null on update cascade,
	stato varchar(20) default 'non evaso',
	data date not null,
	indirizzoConsegna varchar(100) not null,
	totale decimal(10,0) not null,
	pagamento varchar(15) not null,
	primary key(id)
);

create table fattura(
	id int(11) not null auto_increment,
	idordine int(11) references ordine(id) on delete set null on update cascade,
	indirizzoSpedizione varchar(100) references ordine(indirizzoSpedizione) on delete set null on update cascade,
	totale decimal(10,0) not null references ordine(totale) on delete set null on update cascade,
	pagamento varchar(15) not null references ordine(pagamento) on delete set null on update cascade ,
	iva varchar(4) default '22%',
	primary key(id)
);

create table rifornimento(
	id int(11) not null auto_increment,
	idDipendente int(11) references dipendente(id) on delete set null on update cascade,
	dataRichiesta date not null,
	dataEffettuazione date not null,
	dataConsegnaPrevista date not null,
	stato varchar(20) default 'non evaso',
	totale decimal(10,0) not null,
	primary key(id)
);

create table composizioneRifornimento(
	idrifornimento int(11) references rifornimento(id) on delete set null on update cascade,
	idtshirt int (11) references tshirt(id) on delete set null on update cascade,
	sesso char(1) references tshirt(sesso) on delete set null on update cascade,
	taglia char(1) references tshirt(taglia) on delete set null on update cascade,
	colore char(10) references tshirt(colore) on delete set null on update cascade,
	pezzi int not null,
	primary key(idrifornimento,idtshirt,sesso,taglia,colore)
);

create table stipendiPagati(
	idDipendente int(11) references dipendente(id) on delete set null on update cascade,
	data date not null,
	primary key (idDipendente,data)
);



create table spesa (
	id int(11) not null ,
	descrizione varchar(500) not null,
	data date not null,
	ammontare decimal(10,0) not null,
	primary key(id)
);


