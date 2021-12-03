package com.example.hikeu

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.hikeu.databinding.ActivityMainBinding
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val homeFragment = HomeFragment()
        val officialTrailsFragment = OfficialTrailsFragment()
        val createunofficialTrail = CreateUnofficialTrail()
        val profile = UserProfile()
        val unofficial = unofficialFragment()
        val logIn = LoginFragment()
        val register = registerFragment()

        makeCurrentFragment(homeFragment)

        binding.bottomNavigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.home -> {
                    makeCurrentFragment(homeFragment)
                    binding.buttonLogIn.visibility = View.VISIBLE
                    binding.buttonRegister.visibility = View.VISIBLE
                }
                R.id.officialroutes -> {
                    makeCurrentFragment(officialTrailsFragment)
                    binding.buttonLogIn.visibility = View.INVISIBLE
                    binding.buttonRegister.visibility = View.INVISIBLE
                }
                R.id.unofficialroutes -> {
                    makeCurrentFragment(unofficial)
                    binding.buttonLogIn.visibility = View.INVISIBLE
                    binding.buttonRegister.visibility = View.INVISIBLE
                }
                R.id.userprofile -> {
                    makeCurrentFragment(profile)
                    binding.buttonLogIn.visibility = View.INVISIBLE
                    binding.buttonRegister.visibility = View.INVISIBLE
                }
                R.id.createunofficialroute -> {
                    makeCurrentFragment(createunofficialTrail)
                    binding.buttonLogIn.visibility = View.INVISIBLE
                    binding.buttonRegister.visibility = View.INVISIBLE
                }
            }
            true
        }

        binding.buttonRegister.setOnClickListener{
            binding.buttonLogIn.visibility = View.INVISIBLE
            binding.buttonRegister.visibility = View.INVISIBLE
            makeCurrentFragment(register)
        }
        binding.buttonLogIn.setOnClickListener{
            binding.buttonLogIn.visibility = View.INVISIBLE
            binding.buttonRegister.visibility = View.INVISIBLE
            makeCurrentFragment(logIn)
        }

        var viewModel = ViewModelProvider(
            this, HikeuViewModelFactory(
                (application as
                        HikeuApp).database.MainDao()
            )
        ).get(HikeuViewModel::class.java)




    }

    private fun makeCurrentFragment(fragmen: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fl_wrapper, fragmen)

            commit()
        }
}