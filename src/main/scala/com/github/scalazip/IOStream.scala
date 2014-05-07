package com.github.scalazip

import scala.annotation.tailrec
import java.io.OutputStream
import java.io.InputStream

object IOStream {

  val bufferSize = 16384
  
  def stream(is: InputStream, os: OutputStream) = {
    val buffer = new Array[Byte](bufferSize)
    @tailrec
    def doStream(total: Int): Int = {
      val n = is.read(buffer)
      if (n == -1)
        total
      else {
        os.write(buffer, 0, n)
        doStream(total + n)
      }
    }
    doStream(0)
  }

}