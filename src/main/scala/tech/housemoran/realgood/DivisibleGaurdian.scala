package tech.housemoran.realgood

import akka.actor.{Actor, Props}

class DivisibleGaurdian(private val divisor: Int) extends Actor {
  override def receive: Receive = {
    case "start" => {
      println("yo")
      val actors = (0 to divisor).map(_ => context.actorOf(Props(new DivisibleActor(divisor))))
      for (i <- 0 to 10000) {
        actors(i % divisor) ! i
      }
    }
    case _ => println("Does not compute")
  }

  override def postStop(): Unit = println("Shutting down DivisbleGaurdian")
}
