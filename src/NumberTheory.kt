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

    /*
    efficientGCD
    This method finds the greatest common divisor of two integers a and b using an efficient form of the Extended Euclidean Algorithm.
    It should be faster than the implementation in greatestCommonDivisor()
        1) Set u = 1, g = a, x = 0, and y = b
        2) If y == 0, set v = (g-au)/b and return the values (g, u, v)
        3) Divide g by y with remainder, g = qy+t, with 0 <= t < y
        4) Set s = u - qx
        5) Set u = x and g = y
        6) Set x = s and y = t
        7) Go to step 2
     */
    fun efficientGCD(a : Int, b : Int) : Int {
        var greatestCommonDivisor : Int = -1

        var u : Int = 1
        var g : Int = a
        var x : Int = 0
        var y : Int = b

        while (y != 0) {
            val q: Int = g / y
            val t: Int = g % y
            val s: Int = u - (q * x)
            u = x
            g = y
            x = s
            y = t
        }

        // If one of the numbers is 0, then the GCD of those two numbers is just the other number
        if (b == 0) {
            greatestCommonDivisor = a
        } else {
            val v : Int = (g - (a * u)) / b
            greatestCommonDivisor = (a * u) + (v * b)
        }

        return greatestCommonDivisor
    }
}