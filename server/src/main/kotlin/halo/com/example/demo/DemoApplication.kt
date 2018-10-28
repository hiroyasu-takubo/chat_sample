package halo.com.example.demo

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class DemoApplication
fun main(args: Array<String>) {
    runApplication<DemoApplication>(*args)
}

//class DemoApplication {
//    companion object {
//        @JvmStatic fun main(args: Array<String>) {
////            runApplication<DemoApplication>(*args)
//            SpringApplication.run(DemoApplication::class.java, *args)
//        }
//    }
//}
