# avro-examples
Code examples for Apache Avro.  
Source codes are based on [Apache Avro Getting Started](http://avro.apache.org/docs/current/gettingstartedjava.html)  
Schema files are based on [SchemaResistry examples by Confluent](https://github.com/confluentinc/examples/tree/5.1.2-post/clients/avro/src/main/resources/avro/io/confluent/examples/clients/basicavro)  

# Build
```
$ mvn clean package
# Using Specific
$ mvn exec:java -Dexec.mainClass="com.example.kafka.SpecificMain"
# Using Generic
$ mvn exec:java -Dexec.mainClass="com.example.kafka.GenericMain"
```

# Binary Encoding
```
$ od -tx2 -c  -Ax payment.avro 
000000    624f    016a    1602    7661    6f72    732e    6863    6d65
         O   b   j 001 002 026   a   v   r   o   .   s   c   h   e   m
000010    9a61    7b03    7422    7079    2265    223a    6572    6f63
         a 232 003   {   "   t   y   p   e   "   :   "   r   e   c   o
000020    6472    2c22    6e22    6d61    2265    223a    6150    6d79
         r   d   "   ,   "   n   a   m   e   "   :   "   P   a   y   m
000030    6e65    3274    2c22    6e22    6d61    7365    6170    6563
         e   n   t   2   "   ,   "   n   a   m   e   s   p   a   c   e
000040    3a22    6322    6d6f    652e    6178    706d    656c    6b2e
         "   :   "   c   o   m   .   e   x   a   m   p   l   e   .   k
000050    6661    616b    2c22    6622    6569    646c    2273    5b3a
         a   f   k   a   "   ,   "   f   i   e   l   d   s   "   :   [
000060    227b    616e    656d    3a22    6922    2264    222c    7974
         {   "   n   a   m   e   "   :   "   i   d   "   ,   "   t   y
000070    6570    3a22    7322    7274    6e69    2267    2c7d    227b
         p   e   "   :   "   s   t   r   i   n   g   "   }   ,   {   "
000080    616e    656d    3a22    6122    6f6d    6e75    2274    222c
         n   a   m   e   "   :   "   a   m   o   u   n   t   "   ,   "
000090    7974    6570    3a22    6422    756f    6c62    2265    2c7d
         t   y   p   e   "   :   "   d   o   u   b   l   e   "   }   ,
0000a0    227b    616e    656d    3a22    7222    6765    6f69    226e
         {   "   n   a   m   e   "   :   "   r   e   g   i   o   n   "
0000b0    222c    7974    6570    3a22    225b    7473    6972    676e
         ,   "   t   y   p   e   "   :   [   "   s   t   r   i   n   g
0000c0    2c22    6e22    6c75    226c    2c5d    6422    6665    7561
         "   ,   "   n   u   l   l   "   ]   ,   "   d   e   f   a   u
0000d0    746c    3a22    4e22    574f    4548    4552    7d22    7d5d
         l   t   "   :   "   N   O   W   H   E   R   E   "   }   ]   }
0000e0    3f00    91e1    2c8b    f58c    76fb    b9fe    da71    0e90
        \0   ? 341 221 213   , 214 365 373   v 376 271   q 332 220 016
0000f0    06a1    066a    4241    0043    0000    0000    8c20    0040
       241 006   j 006   A   B   C  \0  \0  \0  \0  \0     214   @  \0
000100    540a    6b6f    6f79    4406    4645    0000    0000    0000
        \n   T   o   k   y   o 006   D   E   F  \0  \0  \0  \0  \0  \0
000110    4069    0602    4847    0049    0000    0000    72c0    0040
         i   @ 002 006   G   H   I  \0  \0  \0  \0  \0 300   r   @  \0
000120    4e0e    574f    4548    4552    e13f    8b91    8c2c    fbf5
       016   N   O   W   H   E   R   E   ? 341 221 213   , 214 365 373
000130    fe76    71b9    90da    a10e
         v 376 271   q 332 220 016 241
000138

```
Avro file has a schema, and Avro data itself is not tagged with type information.


# Schema Resolution
| Serialize Schema | Deserialize Schema | Result 
| -----------------| -------------------| -------------------------------------------------------------------------------- 
| Payment1 | Payment1<br> OR <br>Not Specified  | {"id": "ABC", "amount": 900.0}<br>{"id": "DEF", "amount": 200.0}<br>{"id": "GHI", "amount": 300.0}
| Payment1 | Payment2 | {"id": "ABC", "amount": 900.0, "region": "NOWHERE"}<br>{"id": "DEF", "amount": 200.0, "region": "NOWHERE"}<br>{"id": "GHI", "amount": 300.0, "region": "NOWHERE"}
| Payment1 | Payment3 | Exception with message:<br> &nbsp;&nbsp;org.apache.avro.AvroTypeException: Found com.example.kafka.Payment1,<br>&nbsp;&nbsp;expecting com.example.kafka.Payment3, missing required field region
| Payment2 | Payment1 | {"id": "ABC", "amount": 900.0}<br>{"id": "DEF", "amount": 200.0}<br>{"id": "GHI", "amount": 300.0}
| Payment2 | Payment2<br> OR <br>Not Specified | {"id": "ABC", "amount": 900.0, "region": "Tokyo"}<br>{"id": "DEF", "amount": 200.0, "region": null}<br>{"id": "GHI", "amount": 300.0, "region": "NOWHERE"}
| Payment2 | Payment3 | Exception with message:<br>&nbsp;&nbsp; org.apache.avro.AvroTypeException: Found null, expecting string 


# Etc
I pushed an avro file and Payment java source which was generated in `target/generated-sources/com/example/kafka` at `snippets` dir for your convenience
