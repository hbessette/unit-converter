package com.neu.mobileapplicationdevelopment202430.mvvm.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.neu.mobileapplicationdevelopment202430.R
import com.neu.mobileapplicationdevelopment202430.databinding.MvpLayoutBinding
import com.neu.mobileapplicationdevelopment202430.databinding.MvvmLayoutBinding
import com.neu.mobileapplicationdevelopment202430.mvvm.viewModel.MVVMViewModel

class MVVMFragment: Fragment(), IMVVMFragment {
    private lateinit var binding: MvvmLayoutBinding
    private val vm: MVVMViewModel by viewModels()
    private lateinit var input: EditText
    private lateinit var fromUnit: Spinner
    private lateinit var toUnit: Spinner
    private lateinit var result: TextView
    private lateinit var convert: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = MvvmLayoutBinding.inflate(inflater, container, false)
        setIds(binding.root)
        setSpinners()
        setActionListener()
        vm.conversionResult.observe(viewLifecycleOwner) { result ->
            binding.mvvmOutput.text = result
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        vm.conversionResult.observe(this) {
            result.text = vm.conversionResult.getValue()
        }
    }

    private fun setActionListener() {
        convert.setOnClickListener {
            vm.convert(input.text.toString(), fromUnit.selectedItem.toString(), toUnit.selectedItem.toString());
        }
    }

    private fun setIds(view: View) {
        input = view.findViewById(R.id.mvvm_number_input)
        fromUnit = view.findViewById(R.id.mvvm_select_from_unit)
        toUnit = view.findViewById(R.id.mvvm_select_to_unit)
        result = view.findViewById(R.id.mvvm_output)
        convert = view.findViewById(R.id.mvvm_btn_convert)
    }

    private fun setSpinners() {
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.units_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            fromUnit.adapter = adapter
            toUnit.adapter = adapter
        }
    }


}