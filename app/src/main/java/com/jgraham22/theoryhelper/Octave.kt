package com.jgraham22.theoryhelper

class Octave {
    companion object {
        val CNote = NoteNode("C")
        val CSharpNote = NoteNode("C#/Cb");
        val DNote = NoteNode("D")
        val DSharpNote = NoteNode("D#/Eb")
        val ENote = NoteNode("E")
        val FNote = NoteNode("F")
        val FSharpNote = NoteNode("F#/Gb")
        val GNote = NoteNode("G")
        val GSharpNote = NoteNode("G#/Ab")
        val ANote = NoteNode("A")
        val ASharpNote = NoteNode("A#/Bb")
        val BNote = NoteNode("B")

        init {
            CNote.nextNote = CSharpNote
            CNote.prevNode = BNote

            CSharpNote.nextNote = DNote
            CSharpNote.prevNode = CNote

            DNote.nextNote = DSharpNote
            DNote.prevNode = CSharpNote

            DSharpNote.nextNote = ENote
            DSharpNote.prevNode = DNote

            ENote.nextNote = FNote
            ENote.prevNode = DSharpNote

            FNote.nextNote = FSharpNote
            FNote.prevNode = ENote

            FSharpNote.nextNote = GNote
            FSharpNote.prevNode = FNote

            GNote.nextNote = GSharpNote
            GNote.prevNode = FSharpNote

            GSharpNote.nextNote = ANote
            GSharpNote.prevNode = GNote

            ANote.nextNote = ASharpNote
            ANote.prevNode = GSharpNote

            ASharpNote.nextNote = BNote
            ASharpNote.prevNode = ANote

            BNote.nextNote = CNote
            BNote.prevNode = ASharpNote
        }

        val StartNote: NoteNode = CNote

        fun CreateScaleString(rootNote: String, scale: String): String {
            var scaleStartNote: NoteNode? = null;

            var currentNote = StartNote
            while(scaleStartNote == null) {
                if(currentNote.noteName == rootNote) {
                    scaleStartNote = currentNote
                } else {
                    currentNote = currentNote.nextNote
                }
            }

            var scaleStringBuilder: StringBuilder = StringBuilder()
            scaleStringBuilder.append("${scaleStartNote.noteName}")

            var currentScalePattern: String? = Scales.scales[scale]

            if(currentScalePattern == null) {
                throw Exception("")
            }

            for(interval in currentScalePattern) {
                var intervalVal = interval.digitToInt()

                for(i in 0 until intervalVal) {
                    currentNote = currentNote.nextNote
                }

                scaleStringBuilder.append(" - ${currentNote.noteName}")
            }

            return scaleStringBuilder.toString()
        }
    }
}

class NoteNode(val noteName: String) {
    var nextNote: NoteNode = this
    var prevNode: NoteNode = this
}