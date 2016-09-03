package com.lolboxen.commons.time

import java.time.Duration.ofSeconds
import java.time.Instant.{EPOCH, ofEpochMilli}

import test.Spec

/**
  * Created by trent ahrens on 3/8/16.
  */
class InstantExtTest extends Spec {

  val EPOCH2 = ofEpochMilli(2000)
  val twoSeconds = ofSeconds(2)

  "subtracting two instants" must "yield duration difference" in {
    EPOCH2 - EPOCH shouldBe twoSeconds
  }

  "subtracting duration from instant" must "adjust instant by duration amount" in {
    EPOCH2 - twoSeconds shouldBe EPOCH
  }

  "adding duration to instant" must "adjust instant by duration amount" in {
    EPOCH + twoSeconds shouldBe EPOCH2
  }

  "a later date" must "be greater than an earlier date" in {
    EPOCH2 > EPOCH shouldBe true
  }

  "an earlier date" must "not be greater than an earier date" in {
    EPOCH > EPOCH2 shouldBe false
  }

  "an earlier date" must "be less than a greater date" in {
    EPOCH < EPOCH2 shouldBe true
  }

  "a later date" must "not be earlier than a greater date" in {
    EPOCH2 < EPOCH shouldBe false
  }

  "a later date" must "be greater than or equal to an earlier date" in {
    EPOCH2 > EPOCH shouldBe true
  }

  "the same date" must "be greater than or equal to itself" in {
    EPOCH >= EPOCH shouldBe true
  }

  "an earlier date" must "not be greater than or equal to a later date" in {
    EPOCH >= EPOCH2 shouldBe false
  }

  "an earlier date" must "be less than or equal to a greater date" in {
    EPOCH <= EPOCH2 shouldBe true
  }

  "the same date" must "be less than or equal to itself" in {
    EPOCH <= EPOCH shouldBe true
  }

  "a later date" must "not be less than or equal to an earlier date" in {
    EPOCH2 <= EPOCH shouldBe false
  }

  "min" must "return the lesser of two dates" in {
    EPOCH2 min EPOCH shouldBe EPOCH
  }

  "max" must "return the geater of two dates" in {
    EPOCH2 max EPOCH shouldBe EPOCH2
  }
}
