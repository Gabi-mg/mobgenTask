package com.mobgen.task.app.ui.books

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import com.mobgen.task.R
import com.mobgen.task.app.ui.adapters.BookRecyclerAdapter
import com.mobgen.task.data.network.model.BookData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_book.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookFragment : Fragment() {
    private val viewModel: BookViewModel by viewModel()

    private var books = ArrayList<BookData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_book, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView(){
        rv_books.adapter = BookRecyclerAdapter(books)
    }

    private fun initObserver() {
        viewModel.runBooks()
        viewModel.books.observe(viewLifecycleOwner, Observer { list ->
            books.addAll(list)
            rv_books.adapter?.notifyDataSetChanged()
            viewModel.isLoading.value = false
        })
        viewModel.errorMessage.observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading){
                this.activity?.progress_bar?.visibility = View.VISIBLE
            }
            else{
                this.activity?.progress_bar?.visibility = View.GONE
            }
        })
    }
}