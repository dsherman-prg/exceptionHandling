/**
 * Class main
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * userName This describes the name of the person
 * userPhone This describes the phone of the person
 * userAddress This describes the address of the person
 * userSquareFootage This describes the square footage of the property of the person
 * seniorStatus This describes the senior status of the user
 * userPropertyName This describes the name of the user's property
 * user This collects all the user info and sends it to either commercial or residential formatting
 *
 * modifications
 * DS 10/18/21 added comments
 */
fun main() {

    // Initialize variables
    var userName: String
    var userPhone: String
    var userAddress: String
    var userSquareFootage: Double
    var seniorStatus: Int

    // Get user to select if they are a business or residential
    do {
        println("Please select what kind of lawn maintenance you require:")
        println("1. Residential")
        println("2. Commercial")
        println("3. Done")
        val userType = readLine()!!.toInt()

        // Get base user info
        println("Please enter your name.")
        userName = readLine().toString()
        println("Please enter your phone number.")
        userPhone = readLine().toString()
        println("Please enter your address.")
        userAddress = readLine().toString()
        println("Please enter the square footage of your yard.")
        userSquareFootage = readLine()!!.toDouble()

        if (userType == 1){
            // If residential ask final question and pass info to residential function
            println("Are you a senior?")
            println("1. Yes")
            println("2. No")
            seniorStatus = readLine()!!.toInt()
            val user = Residential(seniorStatus, userName, userPhone, userAddress, userSquareFootage)
            residentialWork(user)

        }else if (userType == 2){
            // If commercial ask final question and pass info to commercial function
            println("Please enter the name of your property.")
            val userPropertyName = readLine().toString()
            val user = Commercial(userPropertyName, userName, userPhone, userAddress, userSquareFootage)
            commercialWork(user)
        }
    // Loop if they entered an invalid selection
    }while (userType !in (1..3))
}

