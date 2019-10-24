package com.honeygoose.wifiadmin.config

import com.opentable.db.postgres.embedded.EmbeddedPostgres
import com.opentable.db.postgres.junit.EmbeddedPostgresRules
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

//@TestConfiguration
@Configuration
class EmbeddedDbConfig {
//    @Bean
//    fun dataSource() : DataSource {
//        //EmbeddedPostgresRules.preparedDatabase(FlywayPreparer.forClasspathLocation("/db/migration"))
//        val pg = EmbeddedPostgres.builder()
//                .setPort(54321)
//                .start()
//        return pg.postgresDatabase
//    }
}
