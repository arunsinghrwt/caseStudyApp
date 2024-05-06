package com.target.targetcasestudy.ui.deals.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealItemBinding
import com.target.targetcasestudy.network.data.DealItem
import com.target.targetcasestudy.ui.deals.viewModel.DealsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DealItemFragment : Fragment() {
  private val dealsViewModel: DealsViewModel by viewModels()
  private var _binding: FragmentDealItemBinding? = null
  private val binding get() = _binding!!

  private var proId :Int ? = null


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    proId = arguments?.getInt("proId", 0)
    dealsViewModel.responseData.observe(this) {
      if (it == null)
        return@observe
      fetchData(it)
    }

  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    proId?.let {
      dealsViewModel.getDealDetailsDetails(it)
    }
  }



  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View = with(FragmentDealItemBinding.inflate(inflater, container, false)) {
    _binding = this
    return binding.root
  }

  private fun fetchData(item: DealItem) {

    Glide.with(requireContext())
      .load(item.imageUrl)
      .into(binding.imgProduct)
    binding.tvDealPrice.text = if (item.salePrice?.displayString != null) item.salePrice.displayString else item.regularPrice?.displayString
    binding.tvDealRegPrice.text = item.regularPrice?.displayString
    binding.tvFulfillment.text = item.fulfillment
    binding.detailsDesc.text = item.description
    binding.btnBack.setOnClickListener(){
      requireActivity().onBackPressed()
    }
  }





}
