package com.example.retrofit.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.example.retrofit.R
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.retrofit.models.Product

class ProductFragment : Fragment() {

    private lateinit var product: Product
    private lateinit var tv_title: TextView
    private lateinit var tv_price: TextView
    private lateinit var tv_brand: TextView
    private lateinit var tv_description: TextView
    private lateinit var imageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv_title = view.findViewById(R.id.tv_title)
        tv_price = view.findViewById(R.id.tv_price)
        tv_description = view.findViewById(R.id.tv_description)
        tv_brand = view.findViewById(R.id.tv_brand)
        imageView = view.findViewById(R.id.iv)

        val args: ProductFragmentArgs by navArgs()
        product = args.product

        tv_title.text = product.title
        tv_price.text = "Price: $".plus(product.price.toString())

        if (product.brand == null) tv_brand.visibility = View.GONE
        else tv_brand.text = "Brand: ".plus(product.brand)

        tv_description.text = product.description

        Glide.with(view)
            .load(product.thumbnail)
            .error(R.drawable.baseline_error_24)
            .placeholder(R.drawable.loading)
            .into(imageView)
    }

}