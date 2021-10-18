fun main() {
    var userName: String
    var userPhone: String
    var userAddress: String
    var userSquareFootage: Double
    var seniorStatus: Int


    do {
        println("Please select what kind of lawn maintenance you require:")
        println("1. Residential")
        println("2. Commercial")
        println("3. Done")
        val userType = readLine()!!.toInt()

        println("Please enter your name.")
        userName = readLine().toString()
        println("Please enter your phone number.")
        userPhone = readLine().toString()
        println("Please enter your address.")
        userAddress = readLine().toString()
        println("Please enter the square footage of your yard.")
        userSquareFootage = readLine()!!.toDouble()

        if (userType == 1){
            println("Are you a senior?")
            println("1. Yes")
            println("2. No")
            seniorStatus = readLine()!!.toInt()
            val user = Residential(seniorStatus, userName, userPhone, userAddress, userSquareFootage)
            residentialWork(user)

        }else if (userType == 2){
            println("Please enter the name of your property.")
            val userPropertyName = readLine().toString()
            val user = Commercial(userPropertyName, userName, userPhone, userAddress, userSquareFootage)
            commercialWork(user)
        }
    }while (userType !in (1..3))
}

