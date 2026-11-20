create table propiedades (

    id number generated always as identity primary key,
    tipo varchar2(20) not null,
    direccion varchar2(120) not null,
    arriendo_base number(10) not null,
    metros_cuadrados number(6) not null,

    -- EXCLUSIVO DE CASAS
    cantidad_pisos number(3),
    tiene_patio number(1),
-- //////////////////////////


    -- EXCLUSIVO DE DEPARTAMENTO
    numero_de_piso number(3),
    gastos_comunes number(10)
-- //////////////////////////////

);

insert into propiedades (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio) values ('CASA','Av.Los Alerces 420','650000','120','2','1');
insert into propiedades (tipo, direccion, arriendo_base, metros_cuadrados, cantidad_pisos, tiene_patio) values ('CASA','Pasaje Roble 115','590000','95','1','0');


insert into propiedades (tipo, direccion, arriendo_base, metros_cuadrados, numero_de_piso, gastos_comunes) values ('DEPARTAMENTO','Calle Prat 890, Depto 504','480000','62','5','95000');

commit;

