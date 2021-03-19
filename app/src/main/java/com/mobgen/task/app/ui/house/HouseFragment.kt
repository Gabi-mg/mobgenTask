package com.mobgen.task.app.ui.house

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.mobgen.task.R
import com.mobgen.task.app.ui.adapters.HouseRecyclerAdapter
import com.mobgen.task.data.network.model.HouseData
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_house.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HouseFragment : Fragment() {
    private val viewModel: HouseViewModel by viewModel()

    private var houses = ArrayList<HouseData>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_house, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
        initObserver()
    }

    private fun initView(){
        rv_houses.adapter = HouseRecyclerAdapter(requireContext(), houses)
    }

    private fun initObserver() {
        viewModel.runHouses()
        viewModel.getHouses().observe(viewLifecycleOwner, Observer { list ->
            houses.addAll(list)
            rv_houses.adapter?.notifyDataSetChanged()
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