import java.lang.Exception

class ModInt(initialValue : Int, var modulus : Int) {
    var value = initialValue
        set(value : Int) {
            field += value
            field %= this.modulus
        }

    var inverse : Int
        get() {
            var u : Int = 1
            var g : Int = this.value
            var x : Int = 0
            var y : Int = this.modulus

            while (y != 0) {
                val q: Int = g / y
                val t: Int = g % y
                val s: Int = u - (q * x)
                u = x
                g = y
                x = s
                y = t
            }

            // Check the gcd of the two values. If it's not 1, then there is no inverse
            val v : Int = (g - (this.value * u)) / this.modulus
            val greatestCommonDivisor = (this.value * u) + (v * this.modulus)
//            println(greatestCommonDivisor)
            if (greatestCommonDivisor != 1) {
                throw Exception("Error: $value has no inverse in the ring of integers modulo $modulus")
            }

            return u
        }
        private set(value : Int) {}

    operator fun plus(b : ModInt) : ModInt{
        if (this.modulus != b.modulus) {
            throw Exception("To add two ModInt objects, they must have the same modulus")
        }

        val newValue = (this.value + b.value) % this.modulus
        return ModInt(newValue, this.modulus)
    }

    override fun toString(): String {
        return this.value.toString()
    }
}