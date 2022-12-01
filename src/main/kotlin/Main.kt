fun main(args: Array<String>) {
    val options = arrayOf("Камень", "Ножницы", "Бумага")
    val gameChoice = getGameChoice(options)
    val userChoice = getUserChoice(options)
    printResult(userChoice, gameChoice)
}

fun printResult(userChoice: String, gameChoice: String) {
    val result: String = if (userChoice == gameChoice) {
        "Ничья!!!"
    } else if ((userChoice == "Камень" && gameChoice == "Ножницы") ||
        (userChoice == "Бумага" && gameChoice == "Камень") ||
        (userChoice == "Ножницы" && gameChoice == "Бумага")
    ) {
        "Вы выиграли!!!"
    } else {
        "Вы проиграли"
    }
    println("Ваш выбор $userChoice. Я выбрала $gameChoice. $result")
}

fun getGameChoice(optionsParam: Array<String>) =
    optionsParam[(Math.random() * optionsParam.size).toInt()]

fun getUserChoice(optionsParam: Array<String>): String {
    var isValidChoice = false
    var userChoice = ""
    while (!isValidChoice) {
        print("Пожалуйста, укажите ваш выбор: ")
        for (item in optionsParam) print(" $item")
        println(".")

        val userInput = readLine()
        if (userInput != null && userInput in optionsParam) {
            isValidChoice = true
            userChoice = userInput
        }
        if (!isValidChoice) println("Вы сделали неправильный выбор")
    }
    return userChoice
}