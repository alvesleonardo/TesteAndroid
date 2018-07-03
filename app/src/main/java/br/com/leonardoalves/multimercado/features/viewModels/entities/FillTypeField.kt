package br.com.leonardoalves.multimercado.features.viewModels.entities

enum class FillTypeField private constructor(name: String) {
    text("1"),
    telnumber("2"),
    email("3");

    fun equalsName(otherName: String): Boolean {
        return name == otherName
    }

    override fun toString(): String {
        return this.name
    }

    companion object {

        fun fromOrdinal(int:String):FillTypeField?{
            var toIntOrNull = int.toIntOrNull()
            return when(toIntOrNull){
                1-> text
                2-> telnumber
                3-> email
                else -> null
            }
        }

        fun fromString(name: String): FillTypeField? {
            return try {
                findByName(name)
            } catch (e: Exception) {
                null
            }

        }

        @Throws(Exception::class)
        fun findByName(name: String): FillTypeField? {
            for (p in values()) {
                if (name == p.toString()) {
                    return p
                }
            }
            return null
        }
    }
}
