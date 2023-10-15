package com.offline.first.designpatterns.creational.builder.com.phone

import com.offline.first.designpatterns.creational.factory.com.phone.BaseOs

class PhoneFilter private constructor(
    val osType: BaseOs? = null,
    val hasCamera: Boolean? = null,
    val priceRange: IntRange? = null
) {
    class Builder() {
        private var osType: BaseOs? = null
        private var hasCamera: Boolean? = null
        private var priceRange: IntRange? = null

        fun osType(osType: BaseOs): Builder {
            this.osType = osType
            return this
        }

        fun hasCamera(hasCamera: Boolean): Builder {
            this.hasCamera = hasCamera
            return this
        }

        fun priceRange(priceRange: IntRange): Builder {
            this.priceRange = priceRange
            return this
        }

        fun build(): PhoneFilter {
            return PhoneFilter(osType = osType, hasCamera = hasCamera, priceRange = priceRange)
        }
    }
}