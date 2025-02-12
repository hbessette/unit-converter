package com.neu.mobileapplicationdevelopment202430.mvp.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.neu.mobileapplicationdevelopment202430.R
import com.neu.mobileapplicationdevelopment202430.databinding.MvpLayoutBinding
import com.neu.mobileapplicationdevelopment202430.mvp.presenter.IMVPPresenter
import com.neu.mobileapplicationdevelopment202430.mvp.presenter.MVPPresenter

class MVPFragment: Fragment(), IMVPFragment {
    private lateinit var binding: MvpLayoutBinding
    private var presenter: MVPPresenter = MVPPresenter(this)
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
        binding = MvpLayoutBinding.inflate(inflater, container, false)
        setIds(binding.root)
        setSpinners()
        setActionListener()
        return binding.root
    }

    override fun setResult(output : String) {
        result.text = output
    }

    override fun toast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }

    private fun setActionListener() {
        convert.setOnClickListener {
            presenter.convert(input.text.toString(), fromUnit.selectedItem.toString(), toUnit.selectedItem.toString())
        }

    }

    private fun setIds(view: View) {
        input = view.findViewById(R.id.mvp_input)
        fromUnit = view.findViewById(R.id.mvp_select_from_unit)
        toUnit = view.findViewById(R.id.mvp_select_to_unit)
        result = view.findViewById(R.id.mvp_output)
        convert = view.findViewById(R.id.mvp_btn_convert)
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