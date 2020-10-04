fun main() {

    val cur_amount: Int = 1_000_000
    val prev_amount: Int = 2_000
    val card_type = "visa"

    val peny = calculatePeny(prev_amount = prev_amount, current_amount = cur_amount, card_type = card_type)

    println("Тип карты: $card_type, сумма перевода в копейках: $cur_amount, сумма предыдущих перводов в копейках: $prev_amount")
    println("Комиссия: $peny копеек")

}

fun calculatePeny (prev_amount: Int =0, current_amount: Int, card_type: String ="vkpay"): Int {
    val min_peny: Int = 3500

    return when (card_type) {
        "vkpay" -> 0
        "visa","mir" -> if(current_amount * 0.0075 < min_peny) min_peny else kotlin.math.round(current_amount * 0.0075).toInt()
        "mastercard","maestro" -> calculateMastercardPeny (current_amount , prev_amount)
        else -> 0
    }

}

fun calculateMastercardPeny(prev_amount: Int =0, current_amount: Int): Int {
    val limit = 7_500_000

    return if ((current_amount + prev_amount) > limit) ((current_amount + prev_amount - limit) * 0.006 + 2000).toInt()
        else 0
}