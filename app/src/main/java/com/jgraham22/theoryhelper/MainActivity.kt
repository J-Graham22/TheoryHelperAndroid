package com.jgraham22.theoryhelper

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var spRootNoteSelect: Spinner
    private lateinit var spScaleSelect: Spinner
    private lateinit var tvScaleLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        spRootNoteSelect = findViewById(R.id.spRootNoteSelect)
        spScaleSelect = findViewById(R.id.spScaleSelect)
        tvScaleLabel = findViewById(R.id.tvScaleLabel)

        val notesNames: Array<String> = resources.getStringArray(R.array.notes_array)
        val spRootNoteSelectArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, notesNames)
        spRootNoteSelect.adapter = spRootNoteSelectArrayAdapter

        val scalesLabels: Array<String> = Scales.getScalesAsStringArray()
        val spScaleSelectArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, scalesLabels)
        spScaleSelect.adapter = spScaleSelectArrayAdapter

        var selectedNote: String = spRootNoteSelect.selectedItem.toString()
        var selectedScale: String = spScaleSelect.selectedItem.toString()

        spRootNoteSelect.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedNote = notesNames[position]
                val scaleString = Octave.CreateScaleString(selectedNote, selectedScale)
                tvScaleLabel.setText(scaleString)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        spScaleSelect.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                selectedScale = scalesLabels[position]
                val scaleString = Octave.CreateScaleString(selectedNote, selectedScale)
                tvScaleLabel.setText(scaleString)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

    }

    fun setScaleLabel() {

    }
}