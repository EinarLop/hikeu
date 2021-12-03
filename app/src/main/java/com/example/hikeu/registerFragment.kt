package com.example.hikeu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hikeu.databinding.FragmentRegisterBinding
import kotlinx.coroutines.launch


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class OfficialTrailsFragment : Fragment() {

    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)


        binding.buttonSignIn.setOnClickListener {

            val viewModel = ViewModelProvider(requireActivity()).get(HikeuViewModel::class.java)

            val username = binding.inputUsername.toString()
            val email = binding.inputEmail.toString()
            val password = binding.inputPassword.toString()
            val confPassword = binding.inputConfPass.toString()

            if(username != null && email != null && password != null && confPassword != null){
                if(password == confPassword){
                    val newUser = Users(username, password, email)
                    lifecycleScope.launch{
                        viewModel.addUser(newUser)

                    }
                }
        }
        }
        return binding.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}