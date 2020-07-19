package tech.housemoran.realgood

import akka.actor.Actor

class HelloActor extends Actor {
  override def receive: Receive = {
    case "order" => println("Pickles hold the sauce!")
    case _ => println("Can I take your order, Sir?")
  }

  override def postStop(): Unit = println("Shutting down HelloActor")
}
