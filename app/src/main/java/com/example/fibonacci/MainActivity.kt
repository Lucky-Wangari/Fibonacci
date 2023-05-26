package com.Lucky.rv_fibonacio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.Lucky.rv_fibonacio.databinding.ActivityMainBinding
import android.os.Bundle

class MainActivity : ComponentActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        fibonacciNumbersUpTo200()

    }
    fun fibonacciNumbersUpTo200() {
        var a = 0
        var b = 1
        var c: Int

//        println("Fibonacci numbers up to 200:")
//        print("$a, $b")
        var numbers_list= mutableListOf<Int>(a,b)
        while (true) {
            c = a + b
            if (c > 100)
                break

            numbers_list.add(c)

            a = b
            b = c
        }
        binding.rvfibonacio.layoutManager=LinearLayoutManager(this)
        var numbersAdapter=NumbersRVAdapter(numbers_list)
        binding.rvfibonacio.adapter=numbersAdapter
    }


}
10:23
class NumbersRVAdapter(var fiboList: List<Int>):RecyclerView.Adapter<NumbersViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val numView=LayoutInflater.from(parent.context)
            .inflate(R.layout.recycleviews_fibonac,parent,false)
        return NumbersViewHolder(numView)
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
//   turned tostring for it to be a string
        val currentNumber=fiboList.get(position).toString()
        holder.tvfibo.text=currentNumber
    }

    override fun getItemCount(): Int {
        return fiboList.size
    }


}

class NumbersViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
    var tvfibo=itemView.findViewById<TextView>(R.id.tvfibo)
}
