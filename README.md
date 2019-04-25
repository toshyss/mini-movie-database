# mini-movie-database

This application is database for keeping movie titles.

## Getting Started

### Prerequisites
- Java(main) / Kotlin(authentication)
- Spring Boot
- Spring Data JPA as a mapper
- Spring Security as a authentication
- Thymeleaf as a template engine
- Bootstrap as a css framework
- Postgresql as a database
- Maven as a package manager


### Installing
#### Download source code
Download source code from here. Extract the zip file at any location of choice.

#### Create Schema and Insert Data
 - movies table
 
|Row |Type |Order |Null |Default |
|---|---|---|---|---|
|id |integer | |not null | |
|title |character varying(255) | | | |
|running_time |character varying(5) | | | |
|production_year |character varying(4) | | | |
|country_of_origin |character varying(20) | | | |
|distributing_agency |character varying(255) | | | |
|movie_cast |character varying(255) | | | |
|image |character varying(255) | | | |

Index: "movies_pkey" PRIMARY KEY, btree (id)

- users table

|Row |Type |Order |Null |Default |
|---|---|---|---|---|
|id |integer | |not null | |
|email |character varying(255) | | | |
|password |character varying(255) | | | |
|create_at |timestamp without time zone | | | |
|update_at |timestamp without time zone | | | |

Index: "users_pkey" PRIMARY KEY, btree (id)


- How to create database and table

* add dependencies in pom.xml

```
<dependency>
	<groupId>org.postgresql</groupId>
	<artifactId>postgresql</artifactId>
	<scope>runtime</scope>
</dependency>
```

* add these settings

[application.properties]

```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/movies
spring.datasource.username=<username>
spring.datasource.password=<password>
```

[resources/hibernate.properties]

```
hibernate.jdbc.lob.non_contextual_creation = true
```

* run these command in psql

* movies テーブル

```
create database movies;

create table movies (
    "id" serial primary key,
    "title" character varying(255),
    "running_time" character varying(5),
    "production_year" character varying(4),
    "country_of_origin" character varying(20),
    "distributing_agency" character varying(255),
    "movie_cast" character varying(255),
    "image" character varying(255));
```

* users テーブル（認証機能用）

```$xslt
create table users (
    "id" serial primary key,
    "email" character varying(255),
    "password" character varying(255),
    "create_at" timestamp,
    "update_at" timestamp);
```

```
insert into users (email, password, create_at, update_at) values ('test@example.com', 'test', current_timestamp, current_timestamp);
```


## Running the tests

Access [http://localhost:8081/].

## Explanation
#### Players Controller
|No |HTTPMethod |URL |Controller Methods |
|---|---|---|---|
|1 |GET |/movies |index |
|2 |POST |/movies |create |
|3 |GET |/movies/new |create |
|4 |GET |/movies/1/edit |edit |
|5 |GET |/movies/1 |index |
|6 |PUT |/movies/1 |edit |
|7 |DELETE |/movies/1 |delete |

## Authors

- [**Toshiya Sasaki**](https://github.com/toshyss)


## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details

