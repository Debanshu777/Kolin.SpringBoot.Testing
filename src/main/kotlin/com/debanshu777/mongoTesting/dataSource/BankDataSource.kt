package com.debanshu777.mongoTesting.dataSource

import com.debanshu777.mongoTesting.dataSource.repository.BankDataRepository
import com.debanshu777.mongoTesting.dataSource.repository.MongoDBBankRepository
import com.debanshu777.mongoTesting.model.BankDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository("bankDataSource")
class BankDataSource(@Autowired val mongoDBBankRepository: MongoDBBankRepository) : BankDataRepository {
    override fun getBankDetails(): Collection<BankDTO> = mongoDBBankRepository.findAll()

    override fun getBankDetail(accountNumber: String): BankDTO =
        mongoDBBankRepository.findById(accountNumber)
            .orElseThrow {
                throw NoSuchElementException("Could not find a bank with account number $accountNumber")
            }

    override fun createBank(bank: BankDTO): BankDTO {
        if (mongoDBBankRepository.existsById(bank.accountNumber)) {
            throw IllegalArgumentException("Bank with account number ${bank.accountNumber} already exits")
        }
        mongoDBBankRepository.insert(bank)
        return bank
    }

    override fun editBank(bank: BankDTO): BankDTO {
        if (mongoDBBankRepository.existsById(bank.accountNumber)) {
            mongoDBBankRepository.deleteById(bank.accountNumber)
            mongoDBBankRepository.insert(bank)
        } else {
            throw NoSuchElementException("Could not find a bank with account number $bank.accountNumber")
        }
        return bank
    }

    override fun deleteBank(accountNumber: String) {
        if (mongoDBBankRepository.existsById(accountNumber)) {
            mongoDBBankRepository.deleteById(accountNumber)
        } else {
            throw NoSuchElementException("Bank with account number $accountNumber doesn't exits")
        }
    }
}
