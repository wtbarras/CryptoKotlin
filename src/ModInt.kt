class ModInt(initialValue : Int, private val modulus : Int) {
    private var value = initialValue
        set(value : Int) {
            field += value
            field %= this.modulus
        }

    operator fun plus(b : ModInt) : ModInt{
        val newValue = (this.value + b.value) % this.modulus
        return ModInt(newValue, this.modulus)
    }

    override fun toString(): String {
        return this.value.toString()
    }

}