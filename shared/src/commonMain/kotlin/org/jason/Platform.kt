package org.jason

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform