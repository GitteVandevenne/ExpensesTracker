package be.GitteWout.expensestracker.Expense

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.RecyclerView
import be.GitteWout.expensestracker.R
import be.GitteWout.expensestracker.model.Expense
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class ExpenseLijstAdapter(var expenseList: List<Expense>) :
    RecyclerView.Adapter<ExpenseLijstAdapter.ExpenseLijstViewHolder>() {
    private lateinit var parentFragment: ExpenseLijstFragment

    inner class ExpenseLijstViewHolder(currentItemView: View) :
        RecyclerView.ViewHolder(currentItemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseLijstViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        parentFragment = parent.findFragment()
        return ExpenseLijstViewHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseLijstViewHolder, position: Int) {
        val expense = expenseList[position]
        holder.itemView.apply {
            setOnClickListener {
                parentFragment.selecteerExpense(expense)
                true
            }

            findViewById<TextView>(R.id.txtExpenseNaam).text = expense.getNaam().toString()
            findViewById<TextView>(R.id.txtbedrag).text = '€' + expense.getBedrag().toString()
            val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val date = LocalDate.now().format(formatter)
            findViewById<TextView>(R.id.txtDatum).text = expense.getDatum()
        }
    }

    override fun getItemCount(): Int = expenseList.size

    fun filteredList(filteredList: List<Expense>) {
        expenseList = filteredList
        notifyDataSetChanged()
    }
}