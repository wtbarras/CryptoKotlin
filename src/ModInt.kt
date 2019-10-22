class ModInt(initialValue : Int, private val modulus : Int) {
    private var value = initialValue
        set(value : Int) {
            field += value
            field %= this.modulus
        }


}