package com.debanshu777.mongoTesting.dataSource.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockBankDataResourceTest {

    private val mockDataSource = MockBankDataResource()

    @Test
    fun `should provide a collection of banks`() {
        // when
        val banks = mockDataSource.getBankDetails()
        // then
        assertThat(banks.size).isGreaterThanOrEqualTo(3)
    }

    @Test
    fun `should provide some mock data`() {
        // when
        val banks = mockDataSource.getBankDetails()
        // that
        assertThat(banks).allMatch { it.accountNumber.isNotBlank() }
        assertThat(banks).anyMatch { it.trust != 0.0 }
        assertThat(banks).allMatch { it.transactionFee != 0 }
    }
}
