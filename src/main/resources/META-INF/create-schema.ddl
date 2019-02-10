
    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table ActiveSession (
       id  bigserial not null,
        sessionToken varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe varchar(255),
        header varchar(255),
        primary key (id)
    )

    create table ActiveSession (
       id  bigserial not null,
        sessionToken varchar(255),
        primary key (id)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe TEXT,
        header varchar(255),
        primary key (id)
    )

    create table ActiveSession (
       id  bigserial not null,
        sessionToken varchar(255),
        primary key (id)
    )

    create table Background (
       allias varchar(255) not null,
        active boolean not null,
        name varchar(255),
        primary key (allias)
    )

    create table Client (
       id  bigserial not null,
        login varchar(255),
        password varchar(255),
        primary key (id)
    )

    create table MenuOption (
       id  bigserial not null,
        title varchar(255),
        primary key (id)
    )

    create table TextContent (
       id  bigserial not null,
        describe TEXT,
        header varchar(255),
        primary key (id)
    )
