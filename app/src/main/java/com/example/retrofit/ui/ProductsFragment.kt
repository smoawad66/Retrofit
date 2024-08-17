package com.example.retrofit.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofit.R
import com.example.retrofit.models.Product


class ProductsFragment : Fragment() {

    private lateinit var rv: RecyclerView
    private val viewModel: ProductViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_products, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rv = view.findViewById(R.id.rv)
        val adapter = ProductAdapter(emptyList())

        viewModel.products.observe(viewLifecycleOwner) {
            adapter.setData(it)
            rv.adapter = adapter
        }

        adapter.setOnItemClickListener { position ->
            val product = adapter.getData()[position]
            val navController = view.findNavController()
            val action = ProductsFragmentDirections.actionProductsFragment2ToProductFragment(product)
            navController.navigate(action)
        }
    }




}