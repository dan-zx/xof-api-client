package com.github.danzx.xof.client.ext

import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec

class DataSizeExtensionsTest : StringSpec({

    "should convert to bytes" {
        1.byte shouldBe 1

        1.kilobyte shouldBe 1024
        1.megabyte shouldBe 1048576
        1.gigabyte shouldBe 1073741824
        1.terabyte shouldBe 1099511627776

        15.kilobytes shouldBe 15360
        15.megabytes shouldBe 15728640
        15.gigabytes shouldBe 16106127360
        15.terabytes shouldBe 16492674416640
    }
})