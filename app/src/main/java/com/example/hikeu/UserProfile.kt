package com.example.hikeu

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.fragment.app.activityViewModels

import com.example.hikeu.databinding.FragmentCreateUnofficialTrailBinding
import com.example.hikeu.databinding.FragmentUserProfileBinding
import kotlinx.coroutines.launch
import kotlin.random.Random

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [UserProfile.newInstance] factory method to
 * create an instance of this fragment.
 */
class UserProfile : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private val viewModel: HikeuViewModel by activityViewModels()
    private var currentUser = Users("No user found", "No user found", "No user found")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    private var _binding: FragmentUserProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        _binding = FragmentUserProfileBinding.inflate(inflater, container, false)
        val view = binding.root




        binding.buttonGetInfo.setOnClickListener{
            lifecycleScope.launch {
                currentUser = viewModel.getUserById(7)
                binding.inputUsername.editText?.setText(currentUser.username)
                binding.inputEmail.editText?.setText(currentUser.email)
                binding.inputPassword.editText?.setText(currentUser.password)
                binding.inputAge.editText?.setText(currentUser.age.toString())
                binding.inputNumberOfHikes.editText?.setText(currentUser.numberOfHikes.toString())
                binding.inputFavoriteHike.editText?.setText(currentUser.favoriteHike)
                binding.inputDreamHike.editText?.setText(currentUser.dreamHike)

//                    val user = Users("einar"+ Random.nextInt(0,100), "123", "eina@mail.com")
//                    var us = viewModel.addUser(user)
//                    Log.d("User", us.toString())


            }
        }


        binding.buttonUpdate.setOnClickListener{
            lifecycleScope.launch{
                val newUsername = binding.inputUsername.editText?.text.toString()
                val newEmail = binding.inputEmail.editText?.text.toString()
                val newPassword = binding.inputPassword.editText?.text.toString()
                val newAge = binding.inputAge.editText?.text.toString()
                val newNumberOfHikes = binding.inputNumberOfHikes.editText?.text.toString()
                val newFavoriteHike = binding.inputFavoriteHike.editText?.text.toString()
                val newDreamHike = binding.inputDreamHike.editText?.text.toString()


                currentUser.username = newUsername
                currentUser.email = newEmail
                currentUser.password = newPassword
                currentUser.age = newAge.toInt()
                currentUser.numberOfHikes = newNumberOfHikes.toInt()
                currentUser.favoriteHike = newFavoriteHike
                currentUser.dreamHike = newDreamHike

                viewModel.updateUser(currentUser)

                val einar = viewModel.getUserById(7)
                Log.d("UP", einar.toString())
            }
        }


        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment UserProfile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserProfile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }




}