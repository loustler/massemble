# Data Engineer with Spark
## Contents(example)
1. [DataFrame with DataSource from CSV](src/main/scala/io/loustler/massemble/spark/dataframe/csv)
1. [DataFrame with DataSource from hive](src/main/scala/io/loustler/massemble/spark/dataframe/hive)
1. [DataFrame with DataSource from rdb](src/main/scala/io/loustler/massemble/spark/dataframe/rdb)
1. [DataFrame with DataSource from json](src/main/scala/io/loustler/massemble/spark/dataframe/json)

## Prepare
```sh
$ docker-compose up -d # run docker compose
$ psql -h 0.0.0.0 -p 5432 -U spark -d dataeng
```

## Update data
### CSV
See `./data/csv`

### sql
See `./docker-compose.yml`

And add New SQL file into `./data/sql/`

### Dump Postgres
```sh
$ pg_dump -h host -p port -U user -d db_name --no-owner --no-acl > ./new-dummy-yyyymmdd.sql
```