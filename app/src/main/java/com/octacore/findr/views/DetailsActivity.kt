package com.octacore.findr.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.octacore.findr.R
import com.octacore.findr.viewmodel.DetailsActivityViewModel
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    private lateinit var viewModel: DetailsActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        viewModel = ViewModelProviders.of(this).get(DetailsActivityViewModel::class.java)
        viewModel.getCardDetails(intent)
        viewModel.bank.observe(this, Observer { bank ->
            bank_name_tv.text = bank
        })
        viewModel.country.observe(this, Observer { country ->
            country_tv.text = country
        })
        viewModel.brand.observe(this, Observer { brand ->
            card_brand_tv.text = brand
        })
        viewModel.type.observe(this, Observer { type ->
            card_type_tv.text = type
        })
    }
}
