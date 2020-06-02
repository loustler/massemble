# Data Engineer with Spark
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