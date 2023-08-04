CREATE TABLE IF NOT EXISTS PERSON (
    cc integer(10) not null,
    name varchar(50),
    lastname varchar(50),
    gender varchar(2),
    born date,
    years integer,
    cel varchar(11),
    primary key (cc)
    );

    --SET born AS DATE-FORMAT YDM;

    --Select floor(
    --(cast(convert(varchar(8),get date(),112) as int)-
    --cast(convert(varchar(8),person.born,112) as int) ) / 10000
    --) as years from person;

    CREATE OR REPLACE FUNCTION calcular_edad(born DATE)
    RETURNS INT AS
    $$
    BEGIN
        RETURN EXTRACT(YEAR FROM AGE(NOW(), born));
    END;
    $$
    LANGUAGE SQL;

    INSERT INTO PERSON (cc,name,lastname,Array,born,years,cel) VALUES ('1245786987','antonio','perez','M',
                        '1985-05-10',calcular_edad('1985-05-10'),'3005648976');
    INSERT INTO PERSON (cc,name,lastname,Array,born,years,cel) VALUES ('15786345','pedro','salazar','M',
                        '1990-08-25',calcular_edad('1990-08-25'),'3115649823');
    INSERT INTO PERSON (cc,name,lastname,Array,born,years,cel) VALUES ('43675231','maria','restrepo','F',
                         '2000-02-15',calcular_edad('2000-02-15'),'3158764532');