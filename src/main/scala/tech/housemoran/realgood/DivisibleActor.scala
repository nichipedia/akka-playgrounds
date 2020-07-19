package tech.housemoran.realgood

import akka.actor.Actor

class DivisibleActor(private val divisor: Int) extends Actor {
  override def receive: Receive = {
    case i: Int => {
      if (i % divisor == 0) {
        println(s"$i divisble by $divisor")
      } else {
        println(s"$i not divisble by $divisor")
      }
    }
  }

  override def postStop(): Unit = println("Shutting down DivisbleActor")
}
