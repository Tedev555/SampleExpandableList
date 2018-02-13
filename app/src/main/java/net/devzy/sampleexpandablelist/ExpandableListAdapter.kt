package net.devzy.sampleexpandablelist

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseExpandableListAdapter
import android.widget.TextView

/**
 * Created by ted555 on 2/12/18.
 */
class ExpandableListAdapter( context: Context): BaseExpandableListAdapter() {
    private var inflater:LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getGroup(groupPosition: Int): Any {

        return 10
    }

    override fun isChildSelectable(groupPosition: Int, childPosition: Int): Boolean {

        return true
    }

    override fun hasStableIds(): Boolean {

        return false
    }

    override fun getGroupView(groupPosition: Int, isExpanded: Boolean, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View

        if (convertView == null) {
            view = inflater.inflate(R.layout.group_list_item, null)
            holder = ViewHolder()
            holder.headerTextView = view.findViewById(R.id.header_text_view) as TextView
            view.tag = holder

        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.headerTextView.text = "Test Content Header"

        return view
    }

    override fun getChildrenCount(groupPosition: Int): Int {

        return 5
    }

    override fun getChild(groupPosition: Int, childPosition: Int): Any {

        return "Child Text"
    }

    override fun getGroupId(groupPosition: Int): Long {

        return groupPosition.toLong()
    }

    override fun getChildView(groupPosition: Int, childPosition: Int, isLastChild: Boolean, convertView: View?, parent: ViewGroup?): View {
        val holder: ViewHolder
        val view: View
        if (convertView == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.child_item_list, null)
            holder.childTextView = view.findViewById(R.id.child_text_View) as TextView
            view.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.childTextView.text = "Child TextView"

        return view
    }

    override fun getChildId(groupPosition: Int, childPosition: Int): Long {

        return childPosition.toLong()
    }

    override fun getGroupCount(): Int {

        return 10
    }

    class ViewHolder() {
        lateinit var headerTextView: TextView
        lateinit var childTextView: TextView
    }
}