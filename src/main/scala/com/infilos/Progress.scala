package com.infilos

import picocli.CommandLine
import picocli.CommandLine.Command

import java.util.concurrent.Callable

@Command
class Progress extends Callable[Int] {

  override def call(): Int = {
    for (i <- 1 to 100) {
      Thread.sleep(100)

      print(s"Running: ${"#" * i}${"_" * (100 - i)}|$i% \r") //\u0008

      if (i == 100) {
        println(s"Running: ${"#" * i}${"_" * (100 - i)}|$i%")
      }
    }
    println("Complete!")

    0
  }
}

object Progress {

  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new Progress).execute(args: _*))
  }
}
