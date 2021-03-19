package com.mobgen.task.app.ui.characters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mobgen.task.R
import com.mobgen.task.app.ui.adapters.CharRecyclerAdapter
import com.mobgen.task.data.network.model.CharData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_char.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharFragment : Fragment() {
    private val viewModel: CharViewModel by viewModel()

    private var chars = ArrayList<CharData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_char, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView(){
        rv_chars.adapter = CharRecyclerAdapter(chars)
    }

    private fun initObserver() {
        viewModel.runBooks()
        viewModel.getChars().observe(viewLifecycleOwner, Observer { list ->
            chars.addAll(list)
            rv_chars.adapter?.notifyDataSetChanged()
            viewModel.setIsLoading(false)
        })
        viewModel.getErrorMessage().observe(viewLifecycleOwner, Observer { error ->
            Toast.makeText(context, error, Toast.LENGTH_LONG).show()
        })

        viewModel.getIsLoading().observe(viewLifecycleOwner, Observer { isLoading ->
            if(isLoading){
                this.activity?.progress_bar?.visibility = View.VISIBLE
            }
            else{
                this.activity?.progress_bar?.visibility = View.GONE
            }
        })
    }
}