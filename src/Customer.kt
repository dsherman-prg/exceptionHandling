/**
 * Class Customer
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * customerName This describes the name of the customer
 * customerPhone This describes the phone number of the customer
 * customerAddress This describes the address of the customer
 * squareFootage This describes the square footage of the customer's property
 *
 * modifications
 * DS 10/18/21 added comments
 * -------------------------------------------------------------------------------------
 * class Residential
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * customerName This describes the name of the customer
 * customerPhone This describes the phone number of the customer
 * customerAddress This describes the address of the customer
 * squareFootage This describes the square footage of the customer's property
 * seniorStatus This describes the senior status of the customer
 *
 * modifications
 * DS 10/18/21 added comments
 * -------------------------------------------------------------------------------------
 * class Commercial
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * customerName This describes the name of the customer
 * customerPhone This describes the phone number of the customer
 * customerAddress This describes the address of the customer
 * squareFootage This describes the square footage of the customer's property
 * propertyName This describes the name of the customer's property
 *
 * modifications
 * DS 10/18/21 added comments
 * -------------------------------------------------------------------------------------
 * function residentialWork
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * roundTwoDigits This formats dollar amounts into proper format with 2 digit rounding
 *
 * modifications
 * DS 10/18/21 added comments
 * -------------------------------------------------------------------------------------
 * function commercialWork
 * @author David Sherman
 * date: 10/18/2021
 * @param
 * roundTwoDigits This formats dollar amounts into proper format with 2 digit rounding
 * This function asks if there are more properties to be mowed and calculates the weekly cost for the customer
 * based on inputted information
 *
 * modifications
 * DS 10/18/21 added comments
 * DS 10/25/21 added exception handling
 */
import java.lang.NumberFormatException
import java.text.DecimalFormat
// Base customer class for formatting user info
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

// Residential class for adding on to customer class
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


// Commercial class for adding on to customer class
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

// Function to calculate weekly cost to mow their lawn based on square footage
fun residentialWork(user: Residential) {
    val roundTwoDigits = DecimalFormat ("$###,###,###,###.00")

    // Print info to user
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

// Function to calculate weekly cost to mow their lawn based on square footage
// Also gets the total square footage if they have more than 1 property to be mowed
fun commercialWork(user: Commercial){
    val roundTwoDigits = DecimalFormat ("$###,###,###,###.00")
    var totalProperties = 1
    var userInput = 0
    var moreProperties = 0
    var footage: Double = 0.0

    // Ask if there are more properties
    println("Do you have multiple properties to be mowed?")
    println("1. Yes")
    println("2. No")

    /*DS MOD 10/25/21*/
    try {
    userInput = readLine()!!.toInt()
    }catch (e: NumberFormatException){println("Error: Invalid information entered")}

    // If there are more properties ask how many and loop for that number of times creating a rolling total of the square footage
    if (userInput == 1){
        var rollingTotal = 0.0
        println("How many more properties do you want to be mowed")

        /*DS MOD 10/25/21*/
        try{
        moreProperties = readLine()!!.toInt()
        }catch (e: NumberFormatException){println("Error: Invalid information entered")}

    totalProperties = moreProperties + 1
        do {
            println("What is the square footage of the #$moreProperties property?")

            /*DS MOD 10/25/21*/
            try{
                footage = readLine()!!.toDouble()
            }catch (e: NumberFormatException){println("Error: Invalid information entered")}

            rollingTotal += footage
            moreProperties -= 1
        }while (moreProperties != 0)

        user.squareFootage += rollingTotal

    }

    // Print info to user
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