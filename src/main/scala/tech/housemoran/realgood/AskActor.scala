package tech.housemoran.realgood

import akka.actor.Actor

class AskActor extends Actor {
  override def receive: Receive = {
    case AskName => sender ! "I am the one who knocks!"
    case _ => println("You know my name! SAY IT!")
  }
}
