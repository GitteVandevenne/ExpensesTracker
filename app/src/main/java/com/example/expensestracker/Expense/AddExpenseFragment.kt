package com.example.expensestracker.Expense

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.expensestracker.MainActivity
import com.example.expensestracker.R
import com.example.expensestracker.databinding.FragmentAddexpenseBinding
import com.example.expensestracker.model.Expense

class AddExpenseFragment: Fragment(R.layout.fragment_addexpense)  {

    private lateinit var binding: FragmentAddexpenseBinding
    private lateinit var main: MainActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAddexpenseBinding.inflate(layoutInflater)
        main = activity as MainActivity

        binding.btnAddExpense.setOnClickListener{
            addExpense()
        }
        return binding.root
    }

    private fun addExpense(){
        val Expense = Expense(binding.txtExpenseNaam.text.toString(), binding.txtExpenseBedrag.toString().toInt())

        findNavController().navigate(R.id.action_addExpenseFragment_to_expenseLijstFragment)
    }

}