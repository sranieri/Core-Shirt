DROP DATABASE IF EXISTS coreshirt;


create database coreshirt;
use coreshirt;


create table cliente(
	idcliente int(11) not null auto_increment,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	recapito int(10) not null,
	primary key(idcliente)
 );
 
 create table dipendente(
	idDipendente int(11) not null auto_increment,
	nome varchar(50) not null,
	cognome varchar(50) not null,
	codicefiscale varchar(16) not null,
	stipendio double default 900.0,
	tipo varchar(15) not null,
	username varchar(10) not null,
	password varchar(10) not null,
	primary key(idDipendente)
 );
 
 create table tshirt(
	idtshirt int not null auto_increment,
        articolo int(11) references articolo(id_articolo) on delete set null on update cascade,
	sesso varchar(1) not null,
	taglia varchar(3) not null,
	colore char(10) not null,
	quantita int,
	primary key(idtshirt)
 );


 create table articolo(
	idarticolo int(11) not null,
	nome varchar(40) not null,
	categoria varchar(15) not null,
	prezzo decimal(10,0) default 12.0 ,
	quantita int(10) not null,
	primary key(idarticolo)
);


create table composizioneOrdine(
	idordine int(11) references ordine(idOrdine) on delete set null on update cascade,
	idtshirt int (11) references tshirt(idtshirt) on delete set null on update cascade,
	pezzi int not null,
	primary key(idordine,idtshirt)
);


create table ordine(
	idordine int(11) not null auto_increment,
	idcliente int(11) references cliente(id_cliente) on delete set null on update cascade,
	stato varchar(20) default 'inevaso',
	data date not null,
	indirizzoSpedizione varchar(100) not null,
	totale decimal(10,0) not null,
	pagamento varchar(30) not null,
            metodoP varchar(15) not null,
	primary key(idOrdine)
);


create table fattura(
	idfattura int(11) not null auto_increment,
	idordine int(11) references ordine(idOrdine) on delete set null on update cascade,
	indirizzoSpedizione varchar(100) references ordine(indirizzoSpedizione) on delete set null on update cascade,
	totale decimal(10,0) not null references ordine(totale) on delete set null on update cascade,
	iva varchar(4) default '22%',
	data date not null,
	primary key(idfattura)
);


create table rifornimento(
	idrifornimento int(11) not null auto_increment,
	idDipendente int(11) references dipendente(idDipendente) on delete set null on update cascade,
	dataRichiesta date not null,
	dataEffettuazione date not null,
	dataConsegnaPrevista date not null,
	stato varchar(20) default 'inevaso',
	totale decimal(10,0) not null,
	primary key(idRifornimento)
);


create table composizioneRifornimento(
	idrifornimento int(11) references rifornimento(idRifornimento) on delete set null on update cascade,
	idtshirt int (11) references tshirt(idtshirt) on delete set null on update cascade,
	pezzi int not null,
	primary key(idrifornimento,idtshirt)
);


create table StipendiPagati(
	idDipendente int(11) references dipendente(idDipendente) on delete set null on update cascade,
	data date not null,
	primary key (idDipendente,data)
);


create table spesa (
	idspesa int(11) not null ,
	descrizione varchar(500) not null,
	data date not null,
	ammontare decimal(10,0) not null,
	primary key(idspesa)
);
