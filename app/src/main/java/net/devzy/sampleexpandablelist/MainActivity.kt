package net.devzy.sampleexpandablelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ExpandableListView
import android.widget.ListAdapter

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val expandableListView = findViewById<ExpandableListView>(R.id.expand_list_view)
        val adapter = ExpandableListAdapter(applicationContext)
        expandableListView.setAdapter(adapter)

    }
}
