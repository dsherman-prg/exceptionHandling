import java.text.DecimalFormat

open class Customer (customerName: String,
                     customerPhone: String,
                     customerAddress: String,
                     squareFootage: Double){
    var customerName: String = ""
    var customerPhone: String = ""
    var customerAddress: String = ""
    var squareFootage: Double = 1.1

    init {
        this.customerName = customerName
        this.customerPhone = customerPhone
        this.customerAddress = customerAddress
        this.squareFootage = squareFootage
    }
}

class Residential(seniorStatus: Int,
                  customerName: String,
                  customerPhone: String,
                  customerAddress: String,
                  squareFootage: Double): Customer(customerName,customerPhone,customerAddress,squareFootage) {

    var seniorStatus: Int = 0

    init {
        this.seniorStatus = seniorStatus
    }

}

fun residentialWork(user: Residential) {
    val roundTwoDigits = DecimalFormat ("$###,###,###,###.00")

    println("\nName: " + user.customerName)
    println("Phone number: " + user.customerPhone)
    println("Address: " + user.customerAddress)
    println("Square Footage: " + user.squareFootage + " sq feet")

    if (user.seniorStatus == 1){
        println("The weekly charge will be: "+ (roundTwoDigits.format(((user.squareFootage/1000)*6.00)*.85)))
    }else{
        println("The weekly charge will be: "+ (roundTwoDigits.format(((user.squareFootage/1000)*6.00))))
    }

}

class Commercial(propertyName: String,
                 customerName: String,
                 customerPhone: String,
                 customerAddress: String,
                 squareFootage: Double): Customer(customerName,customerPhone,customerAddress,squareFootage) {

    var propertyName: String = ""

    init {
        this.propertyName = propertyName
    }

}

fun commercialWork(user: Commercial){
    val roundTwoDigits = DecimalFormat ("$###,###,###,###.00")
    var totalProperties = 1

    println("Do you have multiple properties to be mowed?")
    println("1. Yes")
    println("2. No")
    val userInput = readLine()!!.toInt()
    if (userInput == 1){
        var rollingTotal = 0.0
        println("How many more properties do you want to be mowed")
        var moreProperties = readLine()!!.toInt()
        totalProperties = moreProperties + 1
        do {
            println("What is the square footage of the #$moreProperties property?")
            val footage = readLine()!!.toDouble()
            rollingTotal += footage
            moreProperties -= 1
        }while (moreProperties != 0)

        user.squareFootage += rollingTotal

    }
    println("\nName: " + user.customerName)
    println("Phone number: " + user.customerPhone)
    println("Address: " + user.customerAddress)
    println("Property Name: " + user.propertyName)
    println("Total Square Footage: " + user.squareFootage + " sq feet")

    if (userInput == 1){
        println("Total number of properties: $totalProperties")
        println("The weekly charge will be: "+ (roundTwoDigits.format(((user.squareFootage/1000)*5.00)*.9)))
    }else{
        println("The weekly charge will be: "+ (roundTwoDigits.format((user.squareFootage/1000)*5.00)))
    }


}