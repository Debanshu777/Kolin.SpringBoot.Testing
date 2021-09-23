package com.debanshu777.mongoTesting.dataSource.mock

import com.debanshu777.mongoTesting.dataSource.repository.BankDataRepository
import com.debanshu777.mongoTesting.model.BankDTO
import org.springframework.stereotype.Repository

@Repository("mockDataSource")
class MockBankDataResource() : BankDataRepository {
    val banks = mutableListOf(
        BankDTO("1234", 14.0, 17),
        BankDTO("1010", 13.0, 67),
        BankDTO("4040", 12.0, 32)
    )
    override fun getBankDetails(): Collection<BankDTO> = banks
    override fun getBankDetail(accountNumber: String) =
        banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")

    override fun createBank(bank: BankDTO): BankDTO {
        if (banks.any { it.accountNumber == bank.accountNumber }) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exits")
        }
        banks.add(bank)
        return bank
    }

    override fun editBank(bank: BankDTO): BankDTO {
        val currentBank = banks.firstOrNull { it.accountNumber == bank.accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $bank.accountNumber")
        banks.remove(currentBank)
        banks.add(bank)
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        val currentBank = banks.firstOrNull { it.accountNumber == accountNumber }
            ?: throw NoSuchElementException("Could not find a bank with account number $accountNumber")
        banks.remove(currentBank)
    }
}
