package com.target.targetcasestudy.network.data

import com.google.gson.annotations.SerializedName

data class Price(
  @SerializedName("amount_in_cents")
  val amountInCents: Double? = null,
  @SerializedName("currency_symbol")
  val currencySymbol: String? = null,
  @SerializedName("display_string")
  val displayString: String? = null,
)
