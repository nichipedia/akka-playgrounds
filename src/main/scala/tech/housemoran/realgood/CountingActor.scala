package tech.housemoran.realgood

import akka.actor.Actor

class CountingActor extends Actor {
  override def receive: Receive = {
    case n: Int if n > 0 => {
      println(s"and a $n")
      self ! (n - 1)
    }
    case 0 => println("Done!")
  }
  override def postStop(): Unit = println("Shutting down CountingActor")
}
