package ru.netology

import calculateMastercardPeny
import calculatePeny
import org.junit.After
import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @After
    fun tearDown() {
    }

    @Test
    fun calculatePeny_blablabla() {
        val prev_amount: Int =0
        val current_amount: Int = 8_000_000
        val card_type: String ="bla"

        val result = calculatePeny (prev_amount =prev_amount, current_amount = current_amount, card_type = card_type)
        assertEquals(0,result)
    }

    @Test
    fun calculatePeny_vkpay() {
        val prev_amount: Int =0
        val current_amount: Int = 8_000_000
        val card_type: String ="vkpay"

        val result = calculatePeny (prev_amount =prev_amount, current_amount = current_amount, card_type = card_type)
        assertEquals(0,result)
    }

    @Test
    fun calculatePeny_visaBelowMinPeny() {
        val prev_amount: Int = 2_000
        val current_amount: Int = 1_000
        val card_type: String ="visa"

        val result = calculatePeny (prev_amount =prev_amount, current_amount = current_amount, card_type = card_type)
        assertEquals(3500,result)
    }

    @Test
    fun calculatePeny_visaAboveMinPeny() {
        val prev_amount: Int = 2_000
        val current_amount: Int = 1_000_000
        val card_type: String ="visa"

        val result = calculatePeny (prev_amount =prev_amount, current_amount = current_amount, card_type = card_type)
        assertEquals(7500,result)
    }

    @Test
    fun calculateMastercardPeny_aboveLimit() {
        val prev_amount: Int = 3_500_000
        val current_amount: Int = 4_500_000

        val result = calculateMastercardPeny(prev_amount = prev_amount, current_amount = current_amount)

        assertEquals(5000,result)
    }

    @Test
    fun calculateMastercardPeny_belowLimit() {
        val prev_amount: Int = 0
        val current_amount: Int = 4_500_000

        val result = calculateMastercardPeny(prev_amount = prev_amount, current_amount = current_amount)

        assertEquals(0,result)
    }
}