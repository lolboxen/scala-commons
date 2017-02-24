package com.lolboxen.commons.time

import java.time.Duration.ofSeconds
import java.time.Instant.{EPOCH, ofEpochSecond}

import test.Spec

/**
  * Created by trent ahrens on 3/8/16.
  */
class InstantExtTest extends Spec with InstantImplicits {

  val earlier = ofEpochSecond(1)
  val later = ofEpochSecond(2)

  val EPOCH2 = ofEpochSecond(2)
  val twoSeconds = ofSeconds(2)

  behavior of "addition"

  it should "add duration to instant" in {
    EPOCH + twoSeconds shouldBe EPOCH2
  }

  behavior of "subtraction"

  it should "subtract two instants" in {
    EPOCH2 - EPOCH shouldBe twoSeconds
  }

  it should "subtract duration from instant" in {
    EPOCH2 - twoSeconds shouldBe EPOCH
  }

  behavior of "greater than"

  it should "later > earlier" in {
    later > earlier shouldBe true
  }

  it should "not earlier > later" in {
    earlier > later shouldBe false
  }

  behavior of "less than"

  it should "later < earlier" in {
    earlier < later shouldBe true
  }

  it should "not earlier < later" in {
    later < earlier shouldBe false
  }

  behavior of "greater than equal to"

  it should "later >= earlier" in {
    later >= earlier shouldBe true
  }

  it should "same >= same" in {
    earlier >= earlier shouldBe true
  }

  it should "not earlier >= later" in {
    earlier >= later shouldBe false
  }

  behavior of "less than equal to"

  it should "later <= earlier" in {
    earlier <= later shouldBe true
  }

  it should "same <= same" in {
    earlier <= earlier shouldBe true
  }

  it should "not earlier <= later" in {
    later <= earlier shouldBe false
  }

  behavior of "min"

  it should "pick lesser when listed descending" in {
    later min earlier shouldBe earlier
  }

  it should "pick lesser when listed ascending" in {
    earlier min later shouldBe earlier
  }

  behavior of "max"

  it should "pick greater when listed descending" in {
    later max earlier shouldBe later
  }

  it should "pick greater when listed ascending" in {
    earlier max later shouldBe later
  }
}
