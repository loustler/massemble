# Data Engineering
## Setup
```sh
$ docker-compose up -d # Run docker compose
```

## contents
1. [Pivot](./pivot)
1. [Spark](./spark)
1. [Airflow](./airflow)

## Provided Data
See [dump.sql](./dump.sql)

```
    date    | category | count
------------+----------+-------
 2020-01-01 | Beauty   |    50
 2020-01-01 | Food     |   110
 2020-01-01 | Fashion  |    70
 2020-01-15 | Beauty   |    20
 2020-01-15 | Food     |   100
 2020-01-15 | Fashion  |    53
 2020-01-29 | Beauty   |    23
 2020-01-29 | Food     |   210
 2020-01-29 | Fashion  |    78
 2020-02-01 | Beauty   |    65
 2020-02-01 | Food     |    87
 2020-02-01 | Fashion  |    73
 2020-02-15 | Beauty   |    89
 2020-02-15 | Food     |   121
 2020-02-15 | Fashion  |    53
 2020-02-28 | Beauty   |    78
 2020-02-28 | Food     |   125
 2020-02-28 | Fashion  |   102
 2020-03-01 | Beauty   |    55
 2020-03-01 | Food     |   107
 2020-03-01 | Fashion  |    83
 2020-03-15 | Beauty   |    95
 2020-03-15 | Food     |   185
 2020-03-15 | Fashion  |   121
 2020-03-29 | Beauty   |    32
 2020-03-29 | Food     |   198
 2020-03-29 | Fashion  |   142
 2020-04-01 | Beauty   |    72
 2020-04-01 | Food     |   173
 2020-04-01 | Fashion  |   162
 2020-04-15 | Beauty   |   102
 2020-04-15 | Food     |   179
 2020-04-15 | Fashion  |   183
 2020-04-29 | Beauty   |    88
 2020-04-29 | Food     |   175
 2020-04-29 | Fashion  |   198
```