package com.example.roomdatabase

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.roomdatabase.databinding.MainFragmentBinding

class MainFragment : Fragment() {


    private val viewModel: MainViewModel by viewModels()

    lateinit var binding: MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MainFragmentBinding.inflate(layoutInflater)


        viewModel.persons.observe(viewLifecycleOwner, {
            Toast.makeText(requireContext(), "Registered Persons Number ${it.size}", Toast.LENGTH_SHORT).show()
        })

        binding.btnWrite.setOnClickListener {
            viewModel.write(
                Person(
                    binding.edFirstName.text.toString(),
                    binding.edLastName.text.toString(),
                    binding.edAge.text.toString().toInt(),
                    binding.edAddress.text.toString(),
                    binding.edHeight.text.toString().toInt(),
                    binding.edProfile.text.toString(),
                    binding.edId.text.toString().toInt()
                )
            )
        }

        binding.btnRead.setOnClickListener {
            viewModel.read()
        }

        return binding.root
    }


}