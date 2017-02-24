package com.lolboxen.commons.time

import java.time.Duration

/**
  * Created by trent ahrens on 2/24/17.
  */
trait DurationOrderingImplicits {
  implicit object DurationOrdering extends Ordering[Duration] {
    override def compare(x: Duration, y: Duration): Int = x compareTo y
  }
}
