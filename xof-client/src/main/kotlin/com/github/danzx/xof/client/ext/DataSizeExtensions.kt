package com.github.danzx.xof.client.ext

import kotlin.math.pow

const val BYTES_PER_KB = 1_024L

val Int.byte
    get() = bytes

val Int.bytes
    get() = toLong()

val Int.kilobyte
    get() = kilobytes

val Int.kilobytes
    get() = toLong() * BYTES_PER_KB

val Int.megabyte
    get() = megabytes

val Int.megabytes
    get() = toLong() * (BYTES_PER_KB `**` 2)

val Int.gigabyte
    get() = gigabytes

val Int.gigabytes
    get() = toLong() * (BYTES_PER_KB `**` 3)

val Int.terabyte
    get() = terabytes

val Int.terabytes
    get() = toLong() * (BYTES_PER_KB `**` 4)

infix fun Long.`**`(exponent: Int) = toDouble().pow(exponent).toLong()
