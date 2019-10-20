class NumberTheory() {


    /*
    greatestCommonDivisor:
    This method finds the greatest common divisor of two integers a and b using the Euclidean Algorithm
        1) Let r(0) = a and r(1) = b
        2) Set i = 1
        3) Divide r(i-1) by r(i) to get quotient q(i) and remainder r(i+1)
                r(i+1) = r(i) * q(i) + r(i+1)      with 0 <= r(i+1) < r(i)
        4) If the remainder r(i+1) == 0, then r(i) == gcd(a.b) and the algorithm terminates
        5) Otherwise, r(i+1) > 0, so set i = i+1 and go to step 3)

        Completes in at most 2log2(b) iterations
     */
    fun greatestCommonDivisor(a : Int, b : Int) : Int {
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