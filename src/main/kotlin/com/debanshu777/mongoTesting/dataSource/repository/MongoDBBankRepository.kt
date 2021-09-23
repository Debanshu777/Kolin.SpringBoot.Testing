package com.debanshu777.mongoTesting.dataSource.repository

import com.debanshu777.mongoTesting.model.BankDTO
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface MongoDBBankRepository : MongoRepository<BankDTO, String>
