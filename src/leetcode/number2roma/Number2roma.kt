package leetcode.number2roma

import java.util.*

fun main(args: Array<String>) {

    var inputInt = getKeyboard()
    //当输入错误时，应该能继续输入
    while (inputInt == 0) {
        inputInt = getKeyboard()
    }
    println(getRomaResult(inputInt))

}

fun getKeyboard(): Int {//获取键盘输入，并做检验

    val read = Scanner(System.`in`)
    return try {
        val inputInt = read.nextInt()
        inputInt
    } catch (e: Exception) {
        println("输入非法字符!!!")
        0
    }

}

fun getRoma(number: Int): Char {//把数字转换为罗马字符

    return when (number) {
        Roma.One -> Roma.One_R
        Roma.Five -> Roma.Five_R
        Roma.Ten -> Roma.Ten_R
        Roma.Fifty -> Roma.Fifty_R
        Roma.Hundred -> Roma.Hundred_R
        Roma.Five_Hundred -> Roma.Five_Hundred_R
        Roma.Thousand -> Roma.Thousand_R
        else -> '#'
    }

}

fun getRomaResult(num: Int):String {
    var number = num
    var ten = 0
    var hundred = 0
    var thousand = 0
    if (number > Roma.Thousand) {
        thousand = number / 1000
        number %= 1000
    }
    if (number > Roma.Hundred) {
        hundred = number / 100
        number %= 100
    }
    if (number > Roma.Ten) {
        ten = number / 10
        number %= 10
    }
    var one = number
    val sb = StringBuffer()
    while (thousand in 1..3) {
        sb.append(getRoma(Roma.Thousand))
        thousand--
    }
    when {
        hundred == 9 -> sb.append("CM")
        hundred == 4 -> sb.append("CD")
        hundred >= 5 -> {
            sb.append(getRoma(Roma.Five_Hundred))
            hundred -= 5
        }
    }
    while (hundred in 1..3) {
        sb.append(getRoma(Roma.Hundred))
        hundred--
    }
    when {
        ten == 9 -> sb.append("XC")
        ten == 4 -> sb.append("XL")
        ten >= 5 -> {
            sb.append(getRoma(Roma.Fifty))
            ten -= 5
        }
    }
    while (ten in 1..3) {
        sb.append(getRoma(Roma.Ten))
        ten--
    }
    when {
        one == 9 -> sb.append("IX")
        one == 4 -> sb.append("IV")
        one >= 5 -> {
            sb.append(getRoma(Roma.Five))
            one -= 5
        }
    }
    while (one in 1..3) {
        sb.append(getRoma(Roma.One))
        one--
    }
    return sb.toString()

}