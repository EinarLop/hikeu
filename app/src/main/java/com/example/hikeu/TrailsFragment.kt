package com.example.hikeu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hikeu.databinding.FragmentCreateUnofficialTrailBinding
import com.example.hikeu.databinding.FragmentRutasBinding





// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [TrailsFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class TrailsFragment : Fragment() {

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


    private var _binding: FragmentRutasBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRutasBinding.inflate(inflater, container, false)


val viewModel = ViewModelProvider(requireActivity()).get(HikeuViewModel::class.java)


//        val adaptador = trailsAdapater(viewModel.pruebaRutasList)

        val adaptador = trailsAdapater(listOf<OfficialTrails>(
            OfficialTrails(name="Ruta1", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
                difficulty = 2, duration = 50, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
                images = "imagen"),
            OfficialTrails(name="Ruta2", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
                difficulty = 3, duration = 110, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
                images = "imagen"),
            OfficialTrails(name="Ruta3", country = "Mexico", state = "Nuevo Leon", googleMapsLink = "google",
                difficulty = 1, duration = 10, warnings = "cuidado", clothing = "comoda", indispensables = "agua",
                images = "imagen")
        ))

        binding.rvRutas.adapter = adaptador
        binding.rvRutas.layoutManager = LinearLayoutManager(activity)

        return binding.root
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
            TrailsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}



