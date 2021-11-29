package com.example.hikeu

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.hikeu.databinding.FragmentCreateUnofficialTrailBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CreateUnofficialRoute.newInstance] factory method to
 * create an instance of this fragment.
 */
class CreateUnofficialRoute : Fragment() {
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

        val spinnerDifficulty = binding.spinnerDifficulty

        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.difficulties,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinnerDifficulty.adapter = adapter
        }
        binding.buttonCreate.setOnClickListener {
            val trailName = binding.inputTrailName.text.toString()
            val country = binding.inputCountry.text.toString()
            val state = binding.inputState.text.toString()
            val googleMapsLink = binding.inputGoogleMapsLink.text.toString()
            val difficulty = binding.spinnerDifficulty.selectedItem.toString()
            val duration = binding.inputDuration.text.toString()
            val warnings = binding.inputWarnings.text.toString()
            val clothing = binding.inputClothing.text.toString()
            val indispensables = binding.inputIndispensables.text.toString()

            val unOfficialTrail = UnOfficialTrails(
                trailName,
                country,
                state,
                googleMapsLink,
                difficulty,
                1,
                warnings,
                clothing,
                indispensables,
            )

            Log.d("Test", "popop")

//            var viewModel = ViewModelProvider(
//                this, HikeuViewModelFactory(
//                    (context as
//                            HikeuApp).database.MainDao()
//                )
//            ).get(HikeuViewModel::class.java)

//            lifecycleScope.launch{
//                viewModel.addUnOfficialTrail(unOfficialTrail)
//            }



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
            CreateUnofficialRoute().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}