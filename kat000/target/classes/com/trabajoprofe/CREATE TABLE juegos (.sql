CREATE TABLE juegos (
    id number generated always as identity primary key,
    nombre varchar2(100) not null,
    precio number(10) not null,
    consola varchar2(50) not null
);

insert into juegos (nombre, precio, consola) values ('Elden Ring', 49990, 'PC');
insert into juegos (nombre, precio, consola) values ('Zelda Tears of the Kingdom', 59990, 'Nintendo Switch');

COMMIT;