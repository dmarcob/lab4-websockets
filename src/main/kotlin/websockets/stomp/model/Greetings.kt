package websockets.stomp.model

import com.fasterxml.jackson.annotation.JsonProperty

data class Greeting( @JsonProperty("content") val content: String)