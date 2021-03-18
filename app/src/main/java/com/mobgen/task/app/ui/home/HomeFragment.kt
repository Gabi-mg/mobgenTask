package com.mobgen.task.app.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mobgen.task.R
import com.mobgen.task.app.session.Preferences.CATEGORIES
import com.mobgen.task.app.session.Session
import com.mobgen.task.app.ui.adapters.CategoryRecyclerAdapter
import com.mobgen.task.app.utils.Utils
import com.mobgen.task.data.network.model.CategoryData
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var categories = emptyList<CategoryData>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initView()
    }


    private fun initView(){
        val json = Session.getString(context, CATEGORIES, "")
        val listCategories = Utils.fromJson(json)
        categories = listCategories.sortedBy {
            it.categoryName
        }.toList()

//        rv_categories.adapter?.notifyDataSetChanged()
        rv_categories.adapter = CategoryRecyclerAdapter(categories)
        rv_categories.addItemDecoration(
            DividerItemDecoration(
                context,
                LinearLayoutManager.HORIZONTAL
            )
        )

    }
}