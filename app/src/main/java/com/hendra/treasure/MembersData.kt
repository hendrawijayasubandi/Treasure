package com.hendra.treasure

object MembersData {
    private val memberNames = arrayOf("Choi Hyunsuk",
        "Park Jihoon",
        "Yoshi",
        "Kim Junkyu",
        "Mashiho",
        "Yoon Jaehyuk",
        "Asahi",
        "Bang Yedam",
        "Kim Doyoung",
        "Haruto",
        "Park Jeongwoo",
        "Song Junghwan")

    private val memberDetails = arrayOf("Choi Hyunsuk (최현석)",
        "Park Ji Hoon (박지훈)",
        "Kanemoto Yoshinori (金本芳典)",
        "Kim Jun Kyu (김준규)",
        "Takata Mashiho (高田ましほ)",
        "Yoon Jae Hyuk (윤재혁)",
        "Hamada Asahi (浜田朝光)",
        "Bang Ye Dam (방예담)",
        "Kim Do Young (김도영)",
        "Watanabe Haruto (渡辺春虎)",
        "Park Jeong Woo (박정우)",
        "So Jung Hwan (소정환)")

    private val membersImages = intArrayOf(R.drawable.choi_hyunsuk,
        R.drawable.park_jihoon,
        R.drawable.yoshi,
        R.drawable.kim_junkyu,
        R.drawable.mashiho,
        R.drawable.yoon_jaehyuk,
        R.drawable.asahi,
        R.drawable.bang_yedam,
        R.drawable.kim_doyoung,
        R.drawable.haruto,
        R.drawable.park_jeongwoo,
        R.drawable.song_junghwan)

    val listData: ArrayList<Member>
        get() {
            val list = arrayListOf<Member>()
            for (position in memberNames.indices) {
                val member = Member()
                member.name = memberNames[position]
                member.detail = memberDetails[position]
                member.photo = membersImages[position]
                list.add(member)
            }
            return list
        }
}