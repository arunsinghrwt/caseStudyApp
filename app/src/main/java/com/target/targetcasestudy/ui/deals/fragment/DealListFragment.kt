package com.target.targetcasestudy.ui.deals.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.target.targetcasestudy.R
import com.target.targetcasestudy.databinding.FragmentDealListBinding
import com.target.targetcasestudy.ui.deals.adapter.DealItemAdapter
import com.target.targetcasestudy.ui.deals.viewModel.DealsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DealListFragment : Fragment() {

    private val dealsViewModel: DealsViewModel by viewModels()
    private var _binding: FragmentDealListBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var mAdapter: DealItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dealsViewModel.dealsListResponseData.observe(this) {
            mAdapter.submitList(it.products)
        }

        dealsViewModel.responseData.observe(this) {
            if (it == null)
            return@observe

            activity?.supportFragmentManager?.beginTransaction()
            ?.replace(R.id.container, DealItemFragment())
            ?.addToBackStack(DealItemFragment::class.java.toString())
            ?.commit()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = with(FragmentDealListBinding.inflate(inflater, container, false)) {
        _binding = this
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        dealsViewModel.getDealsListData()
         binding.recyclerView.adapter = mAdapter
        mAdapter.clickListener = { id ->
            val bundle = Bundle().apply { putInt("proId", id) }
            val fragment = DealItemFragment()
            fragment.arguments = bundle
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container, fragment)
                ?.addToBackStack(DealItemFragment::class.java.toString())
                ?.commit()
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}
