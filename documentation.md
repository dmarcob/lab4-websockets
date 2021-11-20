### Greeting application with STOMP and message broker support
I've experimented with this [tutorial](https://spring.io/guides/gs/messaging-stomp-websocket/) and I've adapted it to kotlin.

#### What the application does?
It requests a name and responses a greeting.

#### How it does?
When a new client connects to the server, it starts a new websocket  
connection with STOMP messaging over it.
```js
var socket = new SockJS('/gs-guide-websocket');
stompClient = Stomp.over(socket);
stompClient.connect(...)
```
After doing the connection, the client subscribes to a message broker 
queue in order to receive broadcast server responses.
```js

stompClient.subscribe('/topic/greetings', function (greeting) {
   ...
});
```
When user inputs a name and sends it to the server, a STOMP message
is sended with a json body with this format:
```json
{
  "name": "Diego"
}
```
Server is expecting to receive STOMP messages in `/app/hello`.  
When a message arrives, server prepares a STOMP response with a json body with this format:  
```json
{
    "content": "Hello, Diego!"
}
```
Finally when the STOMP response is prepared, the server broadcasts it 
on `/topic/greetings` message broker channel and every client subscribed to this 
channel is able to see the new broadcasted content.

#### Demonstration
![demostracion](https://user-images.githubusercontent.com/45805074/142741235-60f0d838-386b-4563-a6ff-6f764e143dcc.gif)