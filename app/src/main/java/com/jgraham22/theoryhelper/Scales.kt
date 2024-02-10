package com.jgraham22.theoryhelper

class Scales {
    companion object {
        val scales: HashMap<String, String> = hashMapOf(
            "Major" to "2212221",
            "Minor" to "11111",
            "Natural Minor" to "1111",
            "Harmonic Minor" to "11111"
        )

//        fun getScales(): HashMap<String, String> {
//            return scales
//        }

        fun getScalesAsStringArray(): Array<String> {
            var scales: HashMap<String, String> = scales
            var scalesNamesArray: ArrayList<String> = ArrayList<String>()

            scales.keys.forEach {key ->
                scalesNamesArray.add(key)
            }

            return scalesNamesArray.toTypedArray()
        }
    }
}
