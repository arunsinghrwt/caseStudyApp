package com.target.targetcasestudy.ui.deals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.target.targetcasestudy.R
import com.target.targetcasestudy.ui.deals.fragment.DealListFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    supportFragmentManager.beginTransaction()
      .replace(R.id.container, DealListFragment())
      .commit()
  }
}
