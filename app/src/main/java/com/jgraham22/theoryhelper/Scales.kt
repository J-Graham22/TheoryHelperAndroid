package com.jgraham22.theoryhelper

class Scales {
    companion object {
        val scales: LinkedHashMap<String, String> = linkedMapOf(
            "Major" to "2212221",
            "Natural Minor" to "2122122",
            "Melodic Minor" to "2122221",
            "Harmonic Minor" to "2122131",
            "Major Pentatonic" to "32223",
            "Minor Pentatonic" to "32232",
            "Ionian (I)" to "2212221",
            "Dorian (II)" to "2122212",
            "Phrygian (III)" to "1222122",
            "Lydian (IV)" to "2221221",
            "Mixolydian (V)" to "2212212",
            "Aeolian (VI)" to "2122122",
            "Locrian (VII)" to "1221222"
        )

        fun getScalesAsStringArray(): Array<String> {
            return scales.keys.toTypedArray()
        }
    }
}
