package websockets

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.runApplication
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;
import websocket.Greeting;
import websocket.HelloMessage;


@SpringBootApplication
class Application

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}


@Controller
class GreetingController {

  @MessageMapping("/hello")
  @SendTo("/topic/greetings")
  fun greeting(message :HelloMessage):Greeting {
    Thread.sleep(1000); // simulated delay
    return Greeting("Hello, " + HtmlUtils.htmlEscape(message.name) + "!");
  }
}