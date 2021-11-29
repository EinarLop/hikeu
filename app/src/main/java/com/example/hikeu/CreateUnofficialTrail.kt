package com.example.hikeu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hikeu.databinding.FragmentCreateUnofficialTrailBinding
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateUnofficialRoute.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateUnofficialTrail : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }


    private var _binding: FragmentCreateUnofficialTrailBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateUnofficialTrailBinding.inflate(inflater, container, false)
        val view = binding.root



        val items = listOf("Beginner", " Intermediate", "Experienced", "Expert")
        val adapter = ArrayAdapter(requireContext(), R.layout.list_item, items)
        (binding.inputDifficulty.editText as? AutoCompleteTextView)?.setAdapter(adapter)




        binding.buttonCreate.setOnClickListener {
            val trailName = binding.inputTrailName.editText?.text.toString()
            val country = binding.inputCountry.editText?.text.toString()
            val state = binding.inputState.editText?.text.toString()
            val googleMapsLink = binding.inputGoogleMapsLink.editText?.text.toString()
            val difficulty = binding.inputDifficulty.editText?.text.toString()
            val duration = binding.inputDuration.editText?.text.toString().toInt()
            val warnings = binding.inputWarnings.editText?.text.toString()
            val clothing = binding.inputClothing.editText?.text.toString()
            val indispensables = binding.inputIndispensables.editText?.text.toString()


            val unOfficialTrail = UnOfficialTrails(
                trailName,
                country,
                state,
                googleMapsLink,
                difficulty,
                duration,
                warnings,
                clothing,
                indispensables,
            )
            val viewModel = ViewModelProvider(requireActivity()).get(HikeuViewModel::class.java)

            lifecycleScope.launch{
           viewModel.addUnOfficialTrail(unOfficialTrail)
                val trails = viewModel.getAllUnOfficialTrails()
                Log.d("db2", trails.toString())
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
         * @return A new instance of fragment CreateUnofficialRoute.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            CreateUnofficialTrail().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}