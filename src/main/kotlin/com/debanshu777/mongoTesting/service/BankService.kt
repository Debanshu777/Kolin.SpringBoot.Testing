package com.debanshu777.mongoTesting.service

import com.debanshu777.mongoTesting.dataSource.repository.BankDataRepository
import com.debanshu777.mongoTesting.model.BankDTO
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.stereotype.Service
/*
Presently it is using MockDataSource use "bankDataSource" to trigger
the actual data source
 */
@Service
class BankService(@Qualifier("mockDataSource") private val dataRepository: BankDataRepository) {
    fun getBanks(): Collection<BankDTO> = dataRepository.getBankDetails()
    fun getBank(accountNumber: String): BankDTO = dataRepository.getBankDetail(accountNumber)
    fun addBank(bank: BankDTO): BankDTO = dataRepository.createBank(bank)
    fun editBank(bank: BankDTO): BankDTO = dataRepository.editBank(bank)
    fun deleteBank(accountNumber: String) = dataRepository.deleteBank(accountNumber)
}
