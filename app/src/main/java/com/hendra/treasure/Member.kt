package com.hendra.treasure

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Member(
    var name: String = "",
    var detail: String = "",
    var facts: String = "",
    var photo: Int = 0
): Parcelable
