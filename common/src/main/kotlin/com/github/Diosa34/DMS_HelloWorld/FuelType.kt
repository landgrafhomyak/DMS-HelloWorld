package com.github.Diosa34.DMS_HelloWorld

private var countOfInstances = 0

enum class FuelType {
    GASOLINE,
    DIESEL,
    NUCLEAR;

    var index: Int = countOfInstances++

    fun serialize(): ByteArray {
        return typeToString[this]!!.serialize()
    }

    companion object{
        @JvmStatic
        private val types: Map<Int, FuelType> = mapOf(
            GASOLINE.index to GASOLINE,
            DIESEL.index to DIESEL,
            NUCLEAR.index to NUCLEAR
        )

        @JvmStatic
        fun getFuel(index: Int): FuelType? {
            return types[index]
        }

        @JvmStatic
        fun getTypes(): Map<Int, FuelType> {
            return types
        }

        @JvmStatic
        val stringToType: Map<String, FuelType> = mapOf(
            "GASOLINE" to GASOLINE,
            "DIESEL" to DIESEL,
            "NUCLEAR" to NUCLEAR
        )

        @JvmStatic
        val typeToString: Map<FuelType, String> = mapOf(
            GASOLINE to "GASOLINE",
            DIESEL to "DIESEL",
            NUCLEAR to "NUCLEAR"
        )
    }
}