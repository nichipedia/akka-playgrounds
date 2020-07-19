package tech.housemoran.realgood

import java.util.concurrent.TimeUnit

import akka.actor._
import akka.pattern.{ask, pipe}
import akka.util.Timeout

import scala.concurrent.Await

case object AskName

object Driver extends App {
  val system: ActorSystem = ActorSystem("test-system")


  val countingActor: ActorRef = system.actorOf(Props[CountingActor])
  val helloActor: ActorRef = system.actorOf(Props[HelloActor])
  val askActor: ActorRef = system.actorOf(Props[AskActor])
  val divisibleGaurdian: ActorRef =  system.actorOf(Props(new DivisibleGaurdian(4)))

  helloActor ! "Where fore art thou brother?"
  countingActor ! 10
  helloActor ! "order"
  divisibleGaurdian ! "start"

  val to = Timeout(2, TimeUnit.SECONDS)

  val future = ask(askActor, AskName)(to).mapTo[String]
  val result = Await.result(future, to.duration)
  println(result)

  system.terminate()
}