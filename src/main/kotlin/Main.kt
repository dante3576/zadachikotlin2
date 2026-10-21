// Задача 1

// функция для минут
fun mi(m: Int): String {
    when {
        m % 10 == 1 && m % 100 != 11 -> return "$m минуту назад"
        m % 10 >= 2 && m % 10 <= 4 && (m % 100 < 12 || m % 100 > 14) -> return "$m минуты назад"
        else -> return "$m минут назад"
    }
}

// функция для часов
fun ho(h: Int): String {
    when {
        h % 10 == 1 && h % 100 != 11 -> return "$h час назад"
        h % 10 >= 2 && h % 10 <= 4 && (h % 100 < 12 || h % 100 > 14) -> return "$h часа назад"
        else -> return "$h часов назад"
    }
}

// основная функция
fun ag(s: Int): String {
    when {
        s >= 0 && s <= 60 -> return "был(а) только что"
        s > 60 && s <= 3600 -> return mi(s / 60)
        s > 3600 && s <= 86400 -> return ho(s / 3600)
        s > 86400 && s <= 172800 -> return "был(а) вчера"
        s > 172800 && s <= 259200 -> return "был(а) позавчера"
        else -> return "был(а) давно"
    }
}

// Задача 2
// ct - тип карты
// ps - сумма предыдущих
// am - сумма перевода
fun ca(ct: String = "VK Pay", ps: Int = 0, am: Int): Double {
    when {
        ct == "VK Pay" -> return 0.0
        ct == "MasterCard" || ct == "Maestro" -> {
            if (ps + am <= 75000) {
                return 0.0
            } else {
                return am * 0.006 + 20.0
            }
        }
        ct == "Visa" || ct == "Mir" -> {
            val cm = am * 0.0075
            if (cm < 35) {
                return 35.0
            } else {
                return cm
            }
        }
        else -> return 0.0
    }
}

fun main() {
    // проверка задачи 1
    println("Задача 1")
    println()
    println(ag(30))
    println(ag(300))
    println(ag(7200))
    println(ag(100000))

    // проверка задачи 2
    println("Задача 2")
    println()
    val am = 23000
    val cm = ca("Visa", 0, am)
    println("Сумма перевода: $am руб")
    println("Комиссия: $cm руб")
}
