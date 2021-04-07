package com.infilos

import picocli.CommandLine
import picocli.CommandLine._

import java.io.File
import java.math.BigInteger
import java.nio.file.Files
import java.security.MessageDigest
import java.util.concurrent.Callable

@Command(
  name = "checksum",
  version = Array("checksum 4.0"),
  description = Array("Prints the checksum (MD5 by default) of a file to STDOUT."),
  mixinStandardHelpOptions = true
)
class CheckSum extends Callable[Int] {

  @Parameters(index = "0", description = Array("The file whose checksum to calculate."))
  private var file: File = _

  @Option(names = Array("-a", "--algorithm"), description = Array("MD5, SHA-1, SHA-256, ..."))
  private var algo: String = _

  override def call(): Int = {
    val content: Array[Byte] = Files.readAllBytes(file.toPath)
    val digest: Array[Byte]  = MessageDigest.getInstance(algo).digest(content)

    printf("%0" + (digest.length * 2) + "x%n", new BigInteger(1, digest))

    0
  }
}

object CheckSum {

  def main(args: Array[String]): Unit = {
    System.exit(new CommandLine(new CheckSum).execute(args: _*))
  }
}
