package com.oruel.testmydoc.date

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.LocalDate

@RequiresApi(Build.VERSION_CODES.O)
fun getList(): List<LocalDate> = listOf<LocalDate>(
    LocalDate.of(2021, 3, 6),
    LocalDate.of(2021, 3, 7),
    LocalDate.of(2021, 3, 8),
    LocalDate.of(2021, 3, 9),
    LocalDate.of(2021, 3, 10),
    LocalDate.of(2021, 3, 11),
    LocalDate.of(2021, 3, 12),
    LocalDate.of(2021, 3, 13),
    LocalDate.of(2021, 3, 15),
    LocalDate.of(2021, 3, 16),
    LocalDate.of(2021, 3, 17),
    LocalDate.of(2021, 3, 18),
    LocalDate.of(2021, 3, 14),
)

@RequiresApi(Build.VERSION_CODES.O)
fun String.toDate(): LocalDate {
    return LocalDate.parse(this)
}

@RequiresApi(Build.VERSION_CODES.O)
fun LocalDate.toStr(): String {
    return "${this.dayOfMonth}.${this.month.value}"
}
