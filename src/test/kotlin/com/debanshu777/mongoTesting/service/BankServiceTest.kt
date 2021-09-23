package com.debanshu777.mongoTesting.service

import com.debanshu777.mongoTesting.dataSource.repository.BankDataRepository
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class BankServiceTest {

    private val dataRepository: BankDataRepository = mockk(relaxed = true)
    private val bankService = BankService(dataRepository)

    @Test
    fun `should call its data source to retrieve banks`() {
        // where
        bankService.getBanks()
        // then
        verify(exactly = 1) { dataRepository.getBankDetails() }
    }
}
