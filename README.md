# orientdb-restful

##Enable all HTTP methods for OrientDB server side functions

###Build
    cd orientdb-restful/src
    javac -classpath <path to orientdb>/lib/orientdb-server-<version>.jar orientdb/restful/OServerCommandRestful.java
    jar cvf orientdb-restful-0.0.1.jar orientdb/restful/OServerCommandRestful.class
    cp orientdb-restful-0.0.1.jar <path to orientdb>/lib/

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
* Restart OrientDB

Now you can create a server side javascript function like:
```javascript
switch (request.getHttpMethod()) {
  case 'GET':
    break;
  case 'POST':
    break;
  case 'PUT':
    break;
  case 'DELETE':
    break;
  default:
    return response.send(405, "Method Not Allowed", "application/json", JSON.stringify({
      error: 'Method Not Allowed'
    }));
}   
```

And access it via HTTP REST:

    GET|POST|PUT|DELETE http://localhost:2480/restful/<dbname>/myfunction