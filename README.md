# orientdb-restful

##Enable all HTTP methods for OrientDB server side functions

Edit `orientdb-server-config.xml`

###Register OrientDB server command: 

(Section `<listeners>` -> `<listener protocol="http" ...` -> `<commands>`)
```xml
<command implementation="orientdb.restful.OServerCommandRestful" pattern="GET|restful/* POST|restful/* PUT|restful/* PATCH|restful/* DELETE|restful/*" stateful="false"/>
```

###Enable CORS (Optional)
(Section `<listeners>` -> `<listener protocol="http" ...` -> `<parameters>`)
```xml
<parameter name="network.http.additionalResponseHeaders" value="Access-Control-Allow-Origin: * ;Access-Control-Allow-Credentials: true;Access-Control-Allow-Headers: Content-Type, Authorization;Access-Control-Allow-Methods: POST, GET, PUT, PATCH, DELETE, HEAD, OPTION"/>
```