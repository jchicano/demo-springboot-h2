# demo-springboot-h2

Spring Boot REST API with H2 database

Access

```
curl http://localhost:9090/account/getall
```

Returns

```
HTTP/1.1 200
<JSON with all data>
```

<br>

Create

```
curl -X POST -H 'Content-Type: application/json' -i http://localhost:9090/account/create --data '{
  "name": "Test",
  "currency": "stone",
  "balance": 0,
  "treasury": true
}'
```

Returns

```
HTTP/1.1 200
<ID of inserted row>
```

Use file `demo-springboot-h2.postman_collection.json` with Postman to see all currently working endpoints.

<b>JUnit not done</b>

<b>JAR not exported</b>

<br><br>

## Additional information

Tools used:

-   Java 8
-   Spring Boot 2.4.2
-   H2 Database
-   Spring Boot DevTools
-   Spring Data JPA
-   Spring Web
