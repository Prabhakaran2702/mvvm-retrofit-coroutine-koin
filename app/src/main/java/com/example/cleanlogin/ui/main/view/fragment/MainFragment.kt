package com.example.cleanlogin.ui.main.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI.onNavDestinationSelected
import com.example.cleanlogin.R
import com.example.cleanlogin.databinding.MainFragmentBinding
import com.example.cleanlogin.ui.main.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {


    private lateinit var viewModel: MainViewModel
    private lateinit var binding: MainFragmentBinding
    private lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding=DataBindingUtil.inflate(inflater,R.layout.main_fragment,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navController = Navigation.findNavController(activity!!, R.id.nav_host_fragment)
        bottom_nav.setOnNavigationItemSelectedListener {item ->

            onNavDestinationSelected(item, Navigation.findNavController(activity!!, R.id.nav_host_fragment))

        }

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        binding.mainviewmodel=viewModel
        binding.lifecycleOwner=this

        arguments?.let {
           val username = MainFragmentArgs.fromBundle(it).username
         //   message.text="Hello Good afternoon, $username"
            viewModel.bindLogin(MainFragmentArgs.fromBundle(it).login)

        }
        // TODO: Use the ViewModel
    }

}