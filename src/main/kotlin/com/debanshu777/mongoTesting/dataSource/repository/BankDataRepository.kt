package com.debanshu777.mongoTesting.dataSource.repository

import com.debanshu777.mongoTesting.model.BankDTO

interface BankDataRepository {
    fun getBankDetails(): Collection<BankDTO>
    fun getBankDetail(accountNumber: String): BankDTO
    fun createBank(bank: BankDTO): BankDTO
    fun editBank(bank: BankDTO): BankDTO
    fun deleteBank(accountNumber: String)
}
