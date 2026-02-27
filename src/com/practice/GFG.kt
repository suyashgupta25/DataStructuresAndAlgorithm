package com.practice

import java.util.*

object GFG {
    @JvmStatic
    fun main(args: Array<String>) {
        val scanner = Scanner(System.`in`)
        var i: Int
        val burstTime = IntArray(10)
        val arrivalTime = IntArray(10)
        var sumBurstTime = 0
        var smallest: Int
        var sumTurnaround = 0
        var sumWaiting = 0

        val n = scanner.nextInt()
        scanner.nextLine()

        i = 0
        while (i < n) {
            arrivalTime[i] = scanner.nextInt()
            i++
        }
        scanner.nextLine()
        val n2 = scanner.nextInt()
        scanner.nextLine()
        i = 0
        while (i < n2) {
            burstTime[i] = scanner.nextInt()
            sumBurstTime += burstTime[i]
            i++
        }

        burstTime[9] = 9999

        var time = 0
        while (time < sumBurstTime) {
            smallest = 9
            i = 0
            while (i < n) {
                if (arrivalTime[i] <= time && burstTime[i] > 0 && burstTime[i] < burstTime[smallest]) smallest = i
                i++
            }
            sumTurnaround += time + burstTime[smallest] - arrivalTime[smallest]
            sumWaiting += time - arrivalTime[smallest]
            time += burstTime[smallest]
            burstTime[smallest] = 0
        }

        System.out.println(String.format("%.2f", sumWaiting.toFloat() / n))
//        System.out.printf("\n\nAverage turnaround time = %f", sumTurnaround.toFloat() / n)
    }
}

