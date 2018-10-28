package com.halo.model
import lombok.Data;

//@Entity
//@Data
data class Feed (
    val id: Long,
    val message: String,
    val username: String,
    val registDate: String
) {
    //とり会えず、真似してみる。
//    companion object {
//        private val locale = ULocale("ja_JP")
//        private val rule = RuleBasedNumberFormat(locale, SPELLOUT)
//    }

//    val message: String by lazy {
//        rule.format(value)
//    }

}
