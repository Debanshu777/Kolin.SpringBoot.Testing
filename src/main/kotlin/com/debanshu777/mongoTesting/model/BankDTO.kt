package com.debanshu777.mongoTesting.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.stereotype.Component

@Component
@Document("Bank")
data class BankDTO(
    @Id
    @Field(name = "accNumber")
    var accountNumber: String = "",
    @Field(name = "trust")
    var trust: Double = 0.0,
    @Field(name = "transFees")
    var transactionFee: Int = 0,
)
