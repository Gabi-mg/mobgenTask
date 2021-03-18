package com.mobgen.task.app.ui.splash

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.mobgen.task.R
import com.mobgen.task.app.session.Preferences
import com.mobgen.task.app.session.Session
import com.mobgen.task.app.utils.Utils
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashFragment : Fragment() {
    private val viewModel: SplashViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_splash, container, false)
    }

    override fun onResume() {
        super.onResume()
        initObserver()
    }

    private fun initObserver() {
        viewModel.runCategories()
        viewModel.categories.observe(viewLifecycleOwner, Observer { list ->
            Session.setString(context, Preferences.CATEGORIES, Utils.toJson(list))
            findNavController().navigate(R.id.action_splash_to_home)
        })
    }
}