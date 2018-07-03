package br.com.leonardoalves.multimercado.features.viewModels.entities

enum class FillTypeField private constructor(name: String) {
    text("1"),
    telNumber("2"),
    email("3");

    fun equalsName(otherName: String): Boolean {
        return name == otherName
    }

    override fun toString(): String {
        return this.name
    }

    companion object {

        fun fromString(name: String): FillTypeField? {
            try {
                return findByName(name)
            } catch (e: Exception) {
                return null
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
