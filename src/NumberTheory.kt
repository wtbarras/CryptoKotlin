class NumberTheory() {

    fun greatestCommonDivisor(a : Int, b : Int) : Int {
        var quotient : Int
        var rOne : Int = a
        var rTwo : Int = b
        var greatestCommonDivisor : Int = -1

        // Need to do some sanity checking on the inputs

        while (rTwo != 0) {
            // Find the remainder of rOne divided by rTwo
            var remainder = rOne % rTwo

            // If there is no remainder, then we have reached the end of the algorithm
            if (remainder == 0) {
                greatestCommonDivisor = rTwo
            }

            // Increment the r values for the next iteration
            rOne = rTwo
            rTwo = remainder
        }

        return greatestCommonDivisor
    }
}