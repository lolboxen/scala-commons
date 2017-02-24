package com.lolboxen.commons.time

import java.time.Duration

/**
  * Created by trent ahrens on 2/23/17.
  */
trait DurationNumberImplicits {
  implicit object NumericDuration extends Numeric[Duration] {
    override def plus(x: Duration, y: Duration): Duration = x.plus(y)

    override def toDouble(x: Duration): Double = x.toNanos.toDouble

    override def toFloat(x: Duration): Float = x.toNanos.toFloat

    override def toInt(x: Duration): Int = x.toNanos.toInt

    override def negate(x: Duration): Duration = x.negated()

    override def fromInt(x: Int): Duration = Duration.ofNanos(x)

    override def toLong(x: Duration): Long = x.toNanos

    override def times(x: Duration, y: Duration): Duration = x.multipliedBy(y.getNano)

    override def minus(x: Duration, y: Duration): Duration = x.minus(y)

    override def compare(x: Duration, y: Duration): Int = x.compareTo(y)
  }
}
