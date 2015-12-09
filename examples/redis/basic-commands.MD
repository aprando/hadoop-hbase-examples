# Primeiros passos no Redis

* Listar todos os elementos do DB:
```
KEYS *
```

* Remover todos os elementos do DB
```
FLUSHALL
```

* Exemplos com o tipo String
```
SET CHAVE VALOR
GET CHAVE

SET COUNTER 10
INCRBY COUNTER 100
DECR COUNTER 
APPEND COUNTER 01
GET COUNTER
INCR COUNTER
```

* Exemplos com o tipo List
```
LPUSH MYLIST a
LPUSH MYLIST b
LPUSH MYLIST c
LLEN MYLIST
RPUSH MYLIST d e f
LRANGE MYLIST 0 -1
LTRIM MYLIST 2 4
LRANGE MYLIST 0 -1
```

* Exemplos com o tipo Hash
```
HMSET user:1000 username antirez password P1pp0 age 34
HGETALL user:1000
HSET user:1000 password 12345
HGETALL user:1000
```

* Um tutorial bem bacana feito pelo pessoal que desenvolve o redis: http://try.redis.io/ 

