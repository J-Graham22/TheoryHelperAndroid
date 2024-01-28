package com.jgraham22.theoryhelper

class Scales {
    val scales: HashMap<String, String> = hashMapOf(
        "Major" to "11111",
        "Minor" to "11111",
        "Natural Minor" to "1111",
        "Harmonic Minor" to "11111"
    )

    fun getScales(): HashMap<String, String> {
        return scales
    }

    companion object {
        fun getScales(): HashMap<String, String> {
            return getScales()
        }

        fun getScalesAsStringArray(): Array<String> {
            var scales: HashMap<String, String> = getScales()
            var scalesNamesArray: ArrayList<String> = ArrayList<String>()

            scales.keys.forEach {key ->
                scalesNamesArray.add(key)
            }

            return scalesNamesArray.toTypedArray()
        }
    }
}
